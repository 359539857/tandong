package cto.framework.web.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;

import cto.framework.core.Return;
import cto.framework.service.CTORequest;
import cto.framework.service.CTOResponse;
import cto.framework.service.IServiceBus;
import cto.framework.service.ServiceBus;
import cto.framework.web.util.ResponseUtils;

public class WebApplicationServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7202673599622099533L;

	private static Logger logger = Logger.getLogger(WebApplicationServlet.class);

	private IServiceBus serviceBus;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CTORequest ctoRequest = getCTORequest(request, response);
		CTOResponse ctoResponse = new CTOResponse();
		try {
			Return $return = serviceBus.execute(ctoRequest, ctoResponse);
			ctoResponse.setObjectValue("return", $return);
			ResponseUtils.renderJson(response, ctoResponse.toString());
			if (Return.executeSuccess($return)) {
				if(logger.isDebugEnabled()){
					logger.info(response);
				}else{
					logger.info($return);
				}
			} else {
				logger.warn($return);
			}
		} catch (Exception e) {
			logger.warn(ExceptionUtils.getFullStackTrace(e));
		}
	}

	@SuppressWarnings({ "unchecked" })
	public CTORequest getCTORequest(HttpServletRequest request, HttpServletResponse response) {
		CTORequest ctoRequest = new CTORequest();
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

	public WebApplicationServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void init() throws ServletException {
		this.serviceBus = ServiceBus.getInstance();
	}

}
