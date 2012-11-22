package cto.framework.core.util;

import org.apache.commons.lang.StringUtils;

public class StringHelper extends StringUtils {

	public static String fieldNameToMethodName(String fieldName, String type) throws Exception {
		String first = fieldName.substring(0, 1);
		String methodName = type + first.toUpperCase() + fieldName.substring(1);
		return methodName;
	}

	public static String convertClassNameToResourcePath(String className) throws Exception {
		return className.replace('.', '/');
	}

	public static String deleteStr2(String str, String str2) throws Exception {
		return str.replaceAll(str2, "").trim();
	}

	public static String analyzeTableList(String string) throws Exception {
		string = string.trim().toLowerCase();
		if (string.contains("into")) {
			int startIndex = string.indexOf("into");
			int endIndex = string.indexOf("values");
			String $str = string.substring(startIndex + 4, endIndex);
			if ($str.contains("(")) {
				endIndex = $str.indexOf("(");
				return $str.substring(0, endIndex).trim();
			}
			return string.substring(startIndex + 5, endIndex).trim();
		} else if (string.contains("from")) {
			int startIndex = string.indexOf("from");
			int endIndex = 0;
			if (string.contains("where")) {
				endIndex = string.indexOf("where");
			} else {
				endIndex = string.length();
			}
			return string.substring(startIndex + 5, endIndex).trim();
		} else if (string.contains("update")) {
			int startIndex = string.indexOf("update");
			int endIndex = string.indexOf("set");
			return string.substring(startIndex + 6, endIndex).trim();
		}
		return null;
	}

	public static String fromDirectoryGetClassName(String path) throws Exception {
		int index = path.indexOf("/cto/");
		if(index == -1){ 
			index = path.indexOf("\\cto\\");
			path = path.substring(index + 1, path.length());
			path = path.replaceAll("\\\\", ".");
		}else{
			path = path.substring(index + 1, path.length());
			path = path.replaceAll("/", ".");
		}
		path = path.substring(0, path.length() - 6);
		return path;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(StringHelper.fromDirectoryGetClassName("file:/D:/tandong/cto-workspace/cto-service-web/target/classes/cto/framework/web/service/aaa.class"));
	}
}
