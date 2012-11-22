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
import cto.framework.web.action.ActionBus;
import cto.framework.web.action.CTORequest;
import cto.framework.web.action.CTOResponse;
import cto.framework.web.action.IActionBus;

public class WebApplicationActionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7202673599622099533L;

	private static Logger logger = Logger.getLogger(WebApplicationActionServlet.class);

	private IActionBus actionBus;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CTORequest ctoRequest = getCTORequest(request, response);
		CTOResponse ctoResponse = new CTOResponse();
		try {
			Return $return = actionBus.execute(ctoRequest, ctoResponse);
			if (Return.executeSuccess($return)) {
				logger.info($return);
			} else {
				logger.warn($return);
			}
		} catch (Exception e) {
			logger.warn(ExceptionUtils.getFullStackTrace(e));
		}
	}

	@SuppressWarnings({ "unchecked" })
	public CTORequest getCTORequest(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> parameterMap = request.getParameterMap();
		if (parameterMap != null && !parameterMap.isEmpty()) {
			Iterator<String> iterator = parameterMap.keySet().iterator();
			CTORequest ctoRequest = new CTORequest();
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
			return ctoRequest;
		}
		return null;
	}

	public WebApplicationActionServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void init() throws ServletException {
		this.actionBus = ActionBus.getInstance();
	}

}
