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
import cto.framework.web.action.ActionBus;
import cto.framework.web.common.WebConstants;

public class WebApplicationActionListener implements ServletContextListener, ServletRequestListener {
	private static final Logger log = Logger.getLogger(WebApplicationActionListener.class);

	private long requestTime;
	private long responseTime;

	public void contextInitialized(ServletContextEvent event) {// web start
		String application_config = event.getServletContext().getInitParameter(WebConstants.APPLICATION_CONFIG);
		String application_name = event.getServletContext().getInitParameter(Constant.APPLICATION_NAME);
		try {
			ActionBus.getInstance().start(application_config);
			if (StringHelper.isNotBlank(application_name)) {
				if (log.isInfoEnabled()) {
					log.info(application_name + " started-----------------");
				}
			}
		} catch (Exception e) {
			log.error(ExceptionUtils.getFullStackTrace(e));
		}

	}

	public void contextDestroyed(ServletContextEvent event) {
		String application_name = event.getServletContext().getInitParameter(Constant.APPLICATION_NAME);
		try {
			ActionBus.getInstance().stop();
			if (StringHelper.isNotBlank(application_name)) {
				if (log.isInfoEnabled()) {
					log.info(application_name + " stoped-----------------");
				}
			}
		} catch (Exception e) {
			log.error(ExceptionUtils.getFullStackTrace(e));
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
