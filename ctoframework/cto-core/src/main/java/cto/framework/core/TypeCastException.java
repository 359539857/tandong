package cto.framework.core;

public class TypeCastException extends RuntimeException {

	private static final long serialVersionUID = -8534756017112816379L;

	public TypeCastException() {
	}

	public TypeCastException(String expression) {
		super(expression);
	}

	public TypeCastException(String strFieldName, Class<?> clazz) {
		super("strFieldName is not type of " + clazz.getName());
	}
}
