/**
 * 
 */
package cto.framework.web.container;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;

import cto.framework.core.Constant;
import cto.framework.core.Return;
import cto.framework.core.util.StringHelper;
import cto.framework.service.CTORequest;
import cto.framework.service.CTOResponse;
import cto.framework.service.ServiceBus;
import cto.framework.web.annotation.Service;
import cto.framework.web.annotation.Trans;
import cto.framework.web.service.IService;

/**
 * @author PeterTan
 * 
 */
public class WebContainer implements Container {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4246899047688866643L;

	private static Logger logger = Logger.getLogger(WebContainer.class);

	private static WebContainer webContainer;

	private Map<String, TransItem> transMap;

	private WebContainer() {
		transMap = new HashMap<String, TransItem>();
	}

	public static WebContainer getInstance() {
		if (webContainer == null) {
			webContainer = new WebContainer();
		}
		return webContainer;
	}

	@Override
	public Return execute(CTORequest ctoRequest, CTOResponse ctoResponse) {
		String transName = ctoRequest.getStringValue(Constant.STR_TRANS_NAME);
		TransItem tramsItem = transMap.get(transName);
		if (tramsItem == null) {
			logger.error("找不到对应的 " + transName);
			return Return.valueOf("-1", "找不到对应的 " + transName, "transName");
		}
		try {
			Method method = tramsItem.getMethod();
			IService service = tramsItem.getService();
			Return $return = (Return) method.invoke(service, ctoRequest, ctoResponse);
			return $return;
		} catch (Exception e) {
			logger.error(ExceptionUtils.getFullStackTrace(e));
			return Return.valueOf("-1", ExceptionUtils.getFullStackTrace(e), "Error");
		}
	}

	public void scanService() throws Exception {
		URL url = Thread.currentThread().getContextClassLoader().getResource("cto/framework/web/service/support");
		if (url != null) {
			String strUrl = url.getPath();
			File file = new File(strUrl);
			File[] files = file.listFiles();
			if (files == null) {
				url = Thread.currentThread().getContextClassLoader().getResource("");
				strUrl = strUrl.substring(0, strUrl.length() - 8) + "lib";
				file = new File(strUrl);
				scanJarDirectory(file);
			}else{
				scanDirectory(file);
			}
		}
	}

	public void scanDirectory(File file) throws Exception {
		File[] files = file.listFiles();
		for (File $file : files) {
			if ($file.isDirectory()) {
				scanDirectory($file);
			} else if ($file.isFile()) {
				String fileFullName = $file.getCanonicalPath();
				String fullClassName = StringHelper.fromDirectoryGetClassName(fileFullName);
				Class<?> clazz = Thread.currentThread().getContextClassLoader().loadClass(fullClassName);
				AddTransMap(clazz);
			}
		}
	}

	public void scanJarDirectory(File file) throws Exception {
		File[] files = file.listFiles();
		for (File $file : files) {
			String fileName = $file.getName();
			if (fileName.contains("cto-service-web")) {
				ZipFile zip = new ZipFile($file);
				Enumeration<? extends ZipEntry> zipEntrys = zip.entries();
				while (zipEntrys.hasMoreElements()) {
					ZipEntry zipEntry = zipEntrys.nextElement();
					String entryName = zipEntry.getName();
					if (entryName.startsWith("cto/framework/web/service/support") && entryName.endsWith(".class")) {
						entryName = entryName.substring(0, entryName.length() - 6);
						String fullClassName = entryName.replaceAll("/", ".");
						Class<?> clazz = Thread.currentThread().getContextClassLoader().loadClass(fullClassName);
						AddTransMap(clazz);
					}
				}
			}
		}
	}

	private boolean AddTransMap(Class<?> clazz) throws InstantiationException, IllegalAccessException {
		Service service = clazz.getAnnotation(Service.class);
		if (service == null) {
			return false;
		}
		IService $service = (IService) clazz.newInstance();
		$service.setIServiceBus(ServiceBus.getInstance());
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			Trans trans = method.getAnnotation(Trans.class);
			if (trans == null) {
				continue;
			}
			String transName = trans.value();
			if (StringHelper.isBlank(transName)) {
				transName = method.getName();
			}
			transMap.put(transName, new TransItem($service, method));
		}
		return true;
	}

	@Override
	public void start() throws Exception {
		this.scanService();
	}

	@Override
	public void stop() {
		this.transMap.clear();
	}

}
