package cto.framework.core;

import java.io.Serializable;

import cto.framework.core.json.JSONObject;

public final class Return implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7294107794374292151L;
	public static final Return OK = new Return("0", "OK", "OK");
	private String nCode;
	private String strText;
	private String strInfo;
	private Throwable throwable;

	public String getCode() {
		return this.nCode;
	}

	public void setCode(String code) {
		this.nCode = code;
	}

	public String getInfo() {
		return this.strInfo;
	}

	public void setInfo(String strInfo) {
		this.strInfo = strInfo;
	}

	public String getText() {
		return this.strText;
	}

	public void setText(String strText) {
		this.strText = strText;
	}

	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}

	public Throwable getThrowable() {
		return this.throwable;
	}

	public Return() {
	}

	public Return(String nCode, String strText) {
		this.nCode = nCode;
		this.strText = strText;
		this.strInfo = "";
	}

	public Return(String nCode, String strText, String strInfo) {
		this.nCode = nCode;
		this.strText = strText;
		this.strInfo = strInfo;
	}

	public static Return valueOf(String nCode, String strText) {
		Return ret = new Return(nCode, strText);

		return ret;
	}

	public static Return valueOf(String nCode, String strText, String strInfo) {
		Return ret = new Return(nCode, strText, strInfo);

		return ret;
	}

	public static Return valueOf(Return ret, String strInfo) {
		Return retNew = new Return(ret.nCode, ret.strText, strInfo);

		return retNew;
	}

	public static Return valueOf(String nCode, String strText, Throwable throwable) {
		Return ret = new Return(nCode, strText);
		ret.setThrowable(throwable);
		return ret;
	}

	public static Return valueOf(String nCode, String strText, String strInfo, Throwable throwable) {
		Return ret = new Return(nCode, strText, strInfo);
		ret.setThrowable(throwable);
		return ret;
	}

	public static Return valueOfOK(String strInfo) {
		Return retNew = new Return("0", "OK", strInfo);

		return retNew;
	}

	public static Return valueOfFail(String strInfo) {
		Return retNew = new Return("-1", "Fail", strInfo);

		return retNew;
	}

	public static boolean executeSuccess(Return $return) {
		if ($return.getCode().equals("0")) {
			return true;
		} else {
			return false;
		}
	}

	public String toString() {
		return new JSONObject(this, false).toString();
	}
}
