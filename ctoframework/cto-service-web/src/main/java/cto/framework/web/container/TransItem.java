/**
 * 
 */
package cto.framework.web.container;

import java.io.Serializable;
import java.lang.reflect.Method;

import cto.framework.core.json.JSONException;
import cto.framework.core.json.JSONObject;
import cto.framework.web.service.IService;

/**
 * @author PeterTan
 * 
 */
public class TransItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3726149168090210681L;

	private Method method;
	private IService service;

	public TransItem(IService service, Method method) {
		this.method = method;
		this.service = service;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

	public IService getService() {
		return service;
	}

	public void setService(IService service) {
		this.service = service;
	}

	@Override
	public String toString() {
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("methodName", method.getName());
			jsonObject.put("serviceName", service.getClass().getSimpleName());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
}
