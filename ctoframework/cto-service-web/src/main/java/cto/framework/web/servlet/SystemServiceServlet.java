/**
 * 
 */
package cto.framework.web.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;

import cto.framework.core.Constant;
import cto.framework.core.Return;
import cto.framework.core.util.StringHelper;
import cto.framework.service.CTORequest;
import cto.framework.service.CTOResponse;
import cto.framework.web.container.Container;
import cto.framework.web.container.WebContainer;

/**
 * @author PeterTan
 * 
 */
public class SystemServiceServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7202673599622099533L;

	private static Logger logger = Logger.getLogger(WebApplicationServlet.class);

	private Container webContainer;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CTORequest ctoRequest = getCTORequest(request, response);
		CTOResponse ctoResponse = new CTOResponse();
		try {
			Return $return = webContainer.execute(ctoRequest, ctoResponse);
			ctoResponse.setObjectValue("return", $return);
			request.setAttribute("ctoResponse", ctoResponse);
			if (Return.executeSuccess($return)) {
				String resultPath = ctoResponse.getStringValue(Constant.RESULT_PATH);
				if (StringHelper.isBlank(resultPath)) {
					String dispatcherPath = "/business/" + ctoRequest.getStringValue(Constant.STR_TRANS_NAME) + ".jsp";
					RequestDispatcher requestDispatcher = request.getRequestDispatcher(dispatcherPath);
					requestDispatcher.forward(request, response);
				}
				if (logger.isDebugEnabled()) {
					logger.info(response);
				} else {
					logger.info($return);
				}
			} else {
				logger.warn($return);
			}
		} catch (Exception e) {
			logger.warn(ExceptionUtils.getFullStackTrace(e));
		}
	}
	
	public void setReuqest(HttpServletRequest request,CTOResponse ctoResponse){
		
	}

	@SuppressWarnings({ "unchecked" })
	public CTORequest getCTORequest(HttpServletRequest request, HttpServletResponse response) {
		String requestURI = request.getRequestURI();
		int beginIndex = requestURI.lastIndexOf("/");
		int endIndex = requestURI.lastIndexOf(".service");
		String transName = requestURI.substring(beginIndex + 1, endIndex);
		CTORequest ctoRequest = new CTORequest();
		ctoRequest.setStringValue(Constant.STR_TRANS_NAME, transName);
		Map<String, Object> parameterMap = request.getParameterMap();
		if (parameterMap != null && !parameterMap.isEmpty()) {
			Iterator<String> iterator = parameterMap.keySet().iterator();
			while (iterator.hasNext()) {
				String key = iterator.next();
				Object value = parameterMap.get(key);
				if (value instanceof String[]) {
					String[] values = (String[]) value;
					if (values.length > 1) {
						ctoRequest.setStringArrayValue(key, values);
					} else {
						ctoRequest.setStringValue(key, values[0]);
					}
				}
			}
		}
		return ctoRequest;
	}

	public SystemServiceServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
		webContainer.stop();
	}

	public void init() throws ServletException {
		webContainer = WebContainer.getInstance();
		try {
			webContainer.start();
		} catch (Exception e) {
			logger.error(ExceptionUtils.getFullStackTrace(e));
		}
	}
}
