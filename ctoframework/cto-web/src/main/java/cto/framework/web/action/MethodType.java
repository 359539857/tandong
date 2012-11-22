/**
 * 
 */
package cto.framework.web.action;

/**
 * @author PeterTan
 * 
 */
public enum MethodType {

	SET("set"), GET("get");

	private final String value;

	private static final java.util.Map<java.lang.String, MethodType> enumConstants = new java.util.HashMap<java.lang.String, MethodType>();

	static {
		for (MethodType c : MethodType.values()) {
			MethodType.enumConstants.put(c.value, c);
		}

	};

	private MethodType(final java.lang.String value) {
		this.value = value;
	}

	/**
	 * Method fromValue.
	 * 
	 * @param value
	 * @return the constant for this value
	 */
	public static MethodType fromValue(final java.lang.String value) {
		MethodType c = MethodType.enumConstants.get(value);
		if (c != null) {
			return c;
		}
		throw new IllegalArgumentException(value);
	}

	/**
	 * 
	 * 
	 * @param value
	 */
	public void setValue(final java.lang.String value) {
	}

	/**
	 * Method toString.
	 * 
	 * @return the value of this constant
	 */
	public java.lang.String toString() {
		return this.value;
	}

	/**
	 * Method value.
	 * 
	 * @return the value of this constant
	 */
	public java.lang.String value() {
		return this.value;
	}
}
