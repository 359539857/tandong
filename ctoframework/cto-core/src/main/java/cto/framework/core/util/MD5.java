/**  
 * $Id: MD5.java 7677 2012-01-13 09:53:38Z tandong $
 * Copyright @Expoint.com.cn All Right Reserved
 */
package cto.framework.core.util;

import java.security.MessageDigest;

/**
 * 
 * @author tandong
 * @date 2011-12-29 上午10:38:56
 * @version V1.0
 */
public class MD5 {
	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	private static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	public static String encode(String origin) {
		String resultString = null;
		try {
			resultString = origin;
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultString;
	}

	public static void main(String[] args) {
		System.out.println(MD5.encode("0liantongFD630E85-4F74-47FC-B616-2272412DC699"));
	}

}
