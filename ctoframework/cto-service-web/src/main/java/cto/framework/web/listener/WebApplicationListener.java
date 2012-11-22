package cto.framework.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;

import cto.framework.core.Constant;
import cto.framework.core.util.StringHelper;
import cto.framework.service.ServiceBus;

public class WebApplicationListener implements ServletContextListener, ServletRequestListener {
	private static final Logger log = Logger.getLogger(WebApplicationListener.class);

	private long requestTime;
	private long responseTime;

	public void contextInitialized(ServletContextEvent event) {// web start
		String application_config_path = event.getServletContext().getInitParameter(Constant.APPLICATION_CONFIG);
		String application_name = event.getServletContext().getInitParameter(Constant.APPLICATION_NAME);
		if (StringHelper.isNotBlank(application_config_path)) {
			if (application_config_path.contains("classpath:")) {
				int index = application_config_path.indexOf(":");
				application_config_path = application_config_path.substring(index + 1, application_config_path.length());
				application_config_path = event.getServletContext().getRealPath("/WEB-INF/classes/" + application_config_path);
			} else {
				application_config_path = event.getServletContext().getRealPath(application_config_path);
			}
		}
		try {
			ServiceBus.getInstance().start(application_config_path);
			if (StringHelper.isNotBlank(application_name)) {
				if (log.isInfoEnabled()) {
					log.info(application_name + " started-----------------");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void contextDestroyed(ServletContextEvent event) {
		String application_name = event.getServletContext().getInitParameter(Constant.APPLICATION_NAME);
		try {
			ServiceBus.getInstance().stop();
			if (StringHelper.isNotBlank(application_name)) {
				if (log.isInfoEnabled()) {
					log.info(application_name + " stoped-----------------");
				}
			}
		} catch (Exception e) {
			log.info(ExceptionUtils.getFullStackTrace(e));
		}

	}

	public void requestInitialized(ServletRequestEvent arg0) {
		HttpServletRequest request = (HttpServletRequest) arg0.getServletRequest();
		String strURL = request.getRequestURI();
		requestTime = System.currentTimeMillis();
		if (request.getQueryString() != null) {
			strURL += "?" + request.getQueryString();
		}
		String strClientIP = request.getRemoteAddr();
		if (log.isInfoEnabled()) {
			log.info(strClientIP + ": " + strURL);
		}
	}

	public void requestDestroyed(ServletRequestEvent arg0) {
		responseTime = System.currentTimeMillis();
		System.out.println("本次请求耗时:" + (responseTime - requestTime) + "毫秒");
	}

}
