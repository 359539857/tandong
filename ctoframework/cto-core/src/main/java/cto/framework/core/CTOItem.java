package cto.framework.core;

import java.io.Serializable;

import cto.framework.core.json.JSONException;
import cto.framework.core.json.JSONObject;

public class CTOItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9096981929822514408L;
	private Object objValue;
	private Class<?> classType;

	public CTOItem(Object objValue, Class<?> classType) {
		super();
		this.objValue = objValue;
		this.classType = classType;
	}

	public Object getObjValue() {
		return objValue;
	}

	public void setObjValue(Object objValue) {
		this.objValue = objValue;
	}

	public Class<?> getClassType() {
		return classType;
	}

	public void setClassType(Class<?> classType) {
		this.classType = classType;
	}

	@Override
	public String toString() {
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("classType", classType);
			jsonObject.put("objValue", objValue);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return jsonObject.toString();
	}

}