/**
 * 
 */
package cto.framework.core.util;

import java.util.Map;

import cto.framework.core.CTO;

/**
 * @author PeterTan
 * 
 */
public class ParameterUtils {

	public static String analyzePropertyValue(String value, Map<String, String> propertyMap) {
		if (!StringHelper.isNotBlank(value)) {
			throw new RuntimeException("parameter is null!");
		} else if (value.trim().startsWith("$")) {
			if (value.startsWith("${") && value.endsWith("}") && value.length() >= 2) {
				String parameterName = value.substring(2, value.length() - 1);
				if (propertyMap.containsKey(parameterName)) {
					return propertyMap.get(parameterName);
				}
			} else if (value.startsWith("$") && value.length() >= 1) {
				String parameterName = value.substring(1);
				if (propertyMap.containsKey(parameterName)) {
					return propertyMap.get(parameterName);
				}
			}
		}
		return value;
	}

	public static Object analyzeCTOValue(String value, CTO cto) {
		if (!StringHelper.isNotBlank(value)) {
			throw new RuntimeException("parameter is null!");
		} else if (value.contains("${")) {
			StringBuilder builder = new StringBuilder();
			int startIndex = value.indexOf("${");
			if (startIndex != 0) {
				builder.append(value.substring(0, startIndex));
				value = value.substring(startIndex);
				startIndex = 0;
			}
			int endIndex = value.indexOf("}");
			String $value = value.substring(startIndex + 2, endIndex);
			Object $$value = ParameterUtils.getCTOValue($value, cto);
			if ($$value instanceof CTO || $$value instanceof CTO[]) {
				return $$value;
			}
			builder.append($$value);
			if (endIndex + 1 < value.length()) {
				builder.append(ParameterUtils.analyzeCTOValue(value.substring(endIndex + 1, value.length()), cto));
			}
			return builder.toString();
		} else if (value.contains("$")) {
			StringBuilder builder = new StringBuilder();
			int startIndex = value.indexOf("$");
			if (startIndex != 0) {
				builder.append(value.substring(0, startIndex));
				value = value.substring(startIndex);
				startIndex = 0;
			}
			int endIndex = value.indexOf(" ");
			if (endIndex == -1) {
				endIndex = value.length();
			}
			String $value = value.substring(startIndex + 1, endIndex);
			Object $$value = ParameterUtils.getCTOValue($value, cto);
			if ($$value instanceof CTO || $$value instanceof CTO[]) {
				return $$value;
			}
			builder.append($$value);
			if (endIndex < value.length()) {
				builder.append(" ").append(ParameterUtils.analyzeCTOValue(value.substring(endIndex + 1, value.length()), cto));
			}
			return builder.toString();
		}
		return value;
	}

	private static Object getCTOValue(String value, CTO cto) {
		if (value.contains(".")) {
			int index = value.indexOf(".");
			String $value = value.substring(0, index);
			String $$value = value.substring(index + 1);
			if (cto.exists($value)) {
				CTO $cto = (CTO) cto.getObjectValue($value);
				return getCTOValue($$value, $cto);
			}
		} else {
			if (cto.exists(value)) {
				return cto.getObjectValue(value);
			}
		}
		return value;
	}

	public static void main(String[] args) {

	}
}
