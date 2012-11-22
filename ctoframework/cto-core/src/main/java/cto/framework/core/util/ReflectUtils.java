/**
 * 
 */
package cto.framework.core.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author PeterTan
 * 
 */
public class ReflectUtils {

	public static Method getMethod(Class<?> clazz, String methodName, List<Object> parameterList) throws Exception {
		Method[] methods = clazz.getDeclaredMethods();
		Class<?>[] parameterTypes = null;

		Method $method = null;
		for (Method method : methods) {
			String _methodName = method.getName();
			if (_methodName.toLowerCase().equals(methodName.toLowerCase())) {
				parameterTypes = method.getParameterTypes();
				if (parameterTypes.length != parameterList.size()) {
					continue;
				}
				boolean flag = false;
				int index = 0;
				for (Object parameter : parameterList) {
					Class<?> $clazz = parameter.getClass();
					if ($clazz.equals(parameterTypes[index])) {
						flag = true;
					}
					if (!flag) {
						if (parameterTypes[index].equals(int.class) || parameterTypes[index].equals(Integer.class)) {
							Integer.valueOf((String) parameter);
							flag = true;
						} else if (parameterTypes[index].equals(long.class) || parameterTypes[index].equals(Long.class)) {
							Long.valueOf((String) parameter);
							flag = true;
						} else if (parameterTypes[index].equals(boolean.class) || parameterTypes[index].equals(Boolean.class)) {
							Boolean.valueOf((String) parameter);
							flag = true;
						} else if (parameterTypes[index].equals(double.class) || parameterTypes[index].equals(Double.class)) {
							Double.valueOf((String) parameter);
							flag = true;
						} else if (parameterTypes[index].equals(float.class) || parameterTypes[index].equals(Float.class)) {
							Float.valueOf((String) parameter);
							flag = true;
						}
						index++;
					}
					if (flag) {
						$method = method;
						break;
					}
				}
				if ($method != null) {
					return $method;
				} else {
					if (clazz.getSuperclass() != null) {
						return ReflectUtils.getMethod(clazz.getSuperclass(), methodName, parameterList);
					}
				}
			}
		}
		throw new RuntimeException("在" + clazz.getName() + " 找不到  " + methodName + "(" + parameterTypes + ")");
	}

	public static Constructor<?> getConstructor(Class<?> clazz, List<Object> parameterList) {
		Constructor<?>[] constructors = clazz.getConstructors();
		Class<?>[] parameterTypes = null;
		for (Constructor<?> constructor : constructors) {
			parameterTypes = constructor.getParameterTypes();
			if (parameterTypes.length != parameterList.size()) {
				continue;
			}
			boolean flag = false;
			int index = 0;
			for (Object parameter : parameterList) {
				Class<?> $clazz = parameter.getClass();
				if ($clazz.equals(parameterTypes[index])) {
					flag = true;
				}
				index++;
			}
			if (flag) {
				return constructor;
			}
		}
		throw new RuntimeException("找不到    " + clazz.getName() + "(" + parameterTypes + ")");
	}

	public static void main(String[] args) {
		List<Object> list = new ArrayList<Object>();
		list.add("谭东 ");
		list.add("谭东 ");
	}
}
