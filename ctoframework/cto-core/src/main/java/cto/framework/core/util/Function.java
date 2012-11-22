package cto.framework.core.util;

import java.security.MessageDigest;

public class Function {
	public static String FormatTextForHTML(String strText) {
		if (strText == null) {
			return null;
		}
		StringBuilder strbText = new StringBuilder(strText.length());
		int nLength = strText.length();
		for (int i = 0; i < nLength; i++) {
			char ch = strText.charAt(i);
			switch (ch) {
			case '&':
				strbText.append("&amp;");
				break;
			case '>':
				strbText.append("&gt;");
				break;
			case '<':
				strbText.append("&lt;");
				break;
			case '\'':
				strbText.append("&apos;");
				break;
			case '"':
				strbText.append("&quot;");
				break;
			case '\r':
				strbText.append("");
				break;
			case '\n':
				strbText.append("<br/>");
				break;
			case ' ':
				strbText.append("&nbsp;");
				break;
			case '/':
				strbText.append("&#47;");
				break;
			case '\\':
				strbText.append("&#092;");
				break;
			default:
				strbText.append(ch);
			}
		}

		return strbText.toString();
	}

	public static String FormatTextForXML(String strText) {
		if (strText == null) {
			return null;
		}
		StringBuilder strbText = new StringBuilder(strText.length());
		int nLength = strText.length();
		for (int i = 0; i < nLength; i++) {
			char ch = strText.charAt(i);
			switch (ch) {
			case '&':
				strbText.append("&amp;");
				break;
			case '>':
				strbText.append("&gt;");
				break;
			case '<':
				strbText.append("&lt;");
				break;
			case '\'':
				strbText.append("&apos;");
				break;
			case '"':
				strbText.append("&quot;");
				break;
			case '\r':
				strbText.append("");
				break;
			case '\n':
				strbText.append("&#xa;");
				break;
			default:
				strbText.append(ch);
			}

		}

		return strbText.toString();
	}

	public static String getMd5(String s) {
		char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			byte[] strTemp = s.getBytes();
			MessageDigest mdTemp = MessageDigest.getInstance("md5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char[] str = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[(k++)] = hexDigits[(byte0 >>> 4 & 0xF)];
				str[(k++)] = hexDigits[(byte0 & 0xF)];
			}
			return new String(str);
		} catch (Exception e) {
		}
		return null;
	}

	public static String FormatTextForJson(String strText) {
		if (strText == null) {
			return null;
		}
		strText = strText.replace("\\", "\\\\");
		strText = strText.replaceAll("\"", "\\\\\"");
		return strText;
	}
}
