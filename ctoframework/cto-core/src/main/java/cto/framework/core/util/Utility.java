package cto.framework.core.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Utility {
	protected static DecimalFormat decFormat = new DecimalFormat();

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static boolean hasSameString(String[] strsString) {
		HashSet hsString = new HashSet();
		for (int i = 0; i < strsString.length; i++) {
			if (!hsString.add(strsString[i])) {
				return true;
			}
		}

		return false;
	}

	public static int findString(String[] strsString, String strValue) {
		for (int i = 0; i < strsString.length; i++) {
			if (strsString[i].equals(strValue)) {
				return i;
			}
		}

		return -1;
	}

	public static String connectString(char chSeperator, String[] strsString) {
		StringBuilder strbOutput = new StringBuilder();

		for (int i = 0; i < strsString.length; i++) {
			if (i > 0) {
				strbOutput.append(chSeperator);
			}

			strbOutput.append(strsString[i]);
		}

		return strbOutput.toString();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String[] splitString(String strSource, char chSeperator) {
		ArrayList alOutput = new ArrayList();

		StringBuilder strbString = new StringBuilder();
		for (int i = 0; i < strSource.length(); i++) {
			char chChar = strSource.charAt(i);
			if (chChar == chSeperator) {
				alOutput.add(strbString.toString());

				strbString = new StringBuilder();
			} else {
				strbString.append(chChar);
			}
		}
		alOutput.add(strbString.toString());

		String[] strsOutput = new String[alOutput.size()];
		for (int i = 0; i < alOutput.size(); i++) {
			strsOutput[i] = ((String) alOutput.get(i));
		}

		return strsOutput;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String[] splitString(String strSource, char chSeperator, boolean bRepeated) {
		ArrayList alOutput = new ArrayList();

		StringBuilder strbString = new StringBuilder();
		char chLastChar = '\000';
		for (int i = 0; i < strSource.length(); i++) {
			char chChar = strSource.charAt(i);
			if (chChar == chSeperator) {
				if (bRepeated) {
					if (chChar != chLastChar) {
						alOutput.add(strbString.toString());

						strbString = new StringBuilder();
					}
				} else {
					alOutput.add(strbString.toString());

					strbString = new StringBuilder();
				}
			} else {
				strbString.append(chChar);
			}
			chLastChar = chChar;
		}
		alOutput.add(strbString.toString());

		String[] strsOutput = new String[alOutput.size()];
		for (int i = 0; i < alOutput.size(); i++) {
			strsOutput[i] = ((String) alOutput.get(i));
		}

		return strsOutput;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static String[] readLine(String str) {
		List list = new ArrayList(10);
		BufferedReader reader = new BufferedReader(new StringReader(str));
		String strContent = null;
		try {
			while ((strContent = reader.readLine()) != null) {
				list.add(strContent);
			}
		} catch (IOException e) {
			return null;
		} finally {
			try {
				reader.close();
			} catch (IOException localIOException2) {
			}
		}
		String[] strReturn = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			strReturn[i] = ((String) list.get(i));
		}
		return strReturn;
	}

	public static String encodingText(String strText, String strFromCoding, String strToCoding) {
		if (strFromCoding.equalsIgnoreCase(strToCoding)) {
			return strText;
		}
		try {
			return new String(strText.getBytes(strFromCoding), strToCoding);
		} catch (Exception e) {
		}
		return null;
	}

	public static String noNull(String strValue) {
		if (strValue == null) {
			return "";
		}

		return strValue;
	}

	public static String readTextFile(String strFile) {
		FileInputStream stream = null;
		InputStreamReader reader = null;
		try {
			stream = new FileInputStream(strFile);
			reader = new InputStreamReader(stream);

			char[] chsData = new char[(int) stream.getChannel().size()];
			int nReadSize = reader.read(chsData, 0, chsData.length);

			String str = new String(chsData, 0, nReadSize);
			return str;
		} catch (Exception e) {
			return null;
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
				if (stream != null) {
					stream.close();
				}
			} catch (Exception localException3) {
			}
		}
	}

	public static String readTextFile(String strFile, String strCoding) {
		FileInputStream stream = null;
		InputStreamReader reader = null;
		try {
			stream = new FileInputStream(strFile);
			reader = new InputStreamReader(stream, strCoding);

			char[] chsData = new char[(int) stream.getChannel().size()];
			int nReadSize = reader.read(chsData, 0, chsData.length);

			String str = new String(chsData, 0, nReadSize);
			return str;
		} catch (Exception e) {
			return null;
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
				if (stream != null) {
					stream.close();
				}
			} catch (Exception localException3) {
			}
		}
	}

	public static String readTextResource(String strFile, String strCoding) {
		InputStream stream = null;
		InputStreamReader reader = null;
		try {
			stream = Resources.getResourceAsStream(strFile);
			reader = new InputStreamReader(stream, strCoding);

			StringBuilder strbContent = new StringBuilder();
			char[] chsData = new char[1024];
			while (true) {
				int nReadSize = reader.read(chsData, 0, chsData.length);
				if (nReadSize <= 0) {
					break;
				}
				strbContent.append(new String(chsData, 0, nReadSize));
			}

			String str = strbContent.toString();
			return str;
		} catch (Exception e) {
			return null;
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (Exception localException5) {
			}
			if (stream != null) {
				try {
					stream.close();
				} catch (Exception localException6) {
				}
			}
		}
	}

	public static String readTextResource(String strFile) {
		InputStream stream = null;
		InputStreamReader reader = null;
		try {
			stream = Resources.getResourceAsStream(strFile);
			reader = new InputStreamReader(stream);

			StringBuilder strbContent = new StringBuilder();
			char[] chsData = new char[10240];
			while (true) {
				int nReadSize = reader.read(chsData, 0, chsData.length);
				if (nReadSize <= 0) {
					break;
				}
				strbContent.append(new String(chsData, 0, nReadSize));
			}

			String str = strbContent.toString();
			return str;
		} catch (Exception e) {
			return null;
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (Exception localException5) {
			}
			if (stream != null) {
				try {
					stream.close();
				} catch (Exception localException6) {
				}
			}
		}
	}

	public static boolean IsInstanceOf(Object obj, String strClassName) {
		try {
			return Class.forName(strClassName).isInstance(obj);
		} catch (Exception e) {
		}
		return false;
	}

	public static byte[] readFile(String strFile) {
		FileInputStream stream = null;
		try {
			stream = new FileInputStream(strFile);

			byte[] bysData = new byte[(int) stream.getChannel().size()];
			stream.read(bysData);

			byte[] arrayOfByte1 = bysData;
			return arrayOfByte1;
		} catch (Exception e) {
			return null;
		} finally {
			try {
				if (stream != null) {
					stream.close();
				}
			} catch (Exception localException3) {
			}
		}
	}

	public static void writeFile(String strFile, byte[] bysData) {
		FileOutputStream stream = null;
		try {
			stream = new FileOutputStream(strFile);

			stream.write(bysData, 0, bysData.length);
		} catch (Exception e) {
			return;
		} finally {
			try {
				if (stream != null) {
					stream.close();
				}
			} catch (Exception localException2) {
			}
		}
	}

	public static void writeFile(File file, byte[] bysData) {
		FileOutputStream stream = null;
		try {
			stream = new FileOutputStream(file);

			stream.write(bysData, 0, bysData.length);
		} catch (Exception e) {
			return;
		} finally {
			try {
				if (stream != null) {
					stream.close();
				}
			} catch (Exception localException2) {
			}
		}
	}

	public static void closeStream(InputStream stream) {
		if (stream != null) {
			try {
				stream.close();
			} catch (Exception localException) {
			}
		}
	}

	public static void closeStream(OutputStream stream) {
		if (stream != null) {
			try {
				stream.close();
			} catch (Exception localException) {
			}
		}
	}

	public static void close(Socket socket) {
		if (socket != null) {
			try {
				socket.close();
			} catch (Exception localException) {
			}
		}
	}

	public static String getHostName() {
		String strHostName = null;
		try {
			InetAddress netAddress = InetAddress.getLocalHost();

			strHostName = netAddress.getHostName();
		} catch (Exception localException) {
		}
		return strHostName;
	}

	public static String getIPAddress() {
		String strIPAddress = null;
		try {
			InetAddress netAddress = InetAddress.getLocalHost();
			strIPAddress = netAddress.getHostAddress();
		} catch (Exception localException) {
		}

		return strIPAddress;
	}

	public static String getLocalIp() {
		String strIp = null;
		try {
			InetAddress netAddress = InetAddress.getLocalHost();
			strIp = netAddress.getHostAddress();
			if (!strIp.startsWith("127")) {
				return strIp;
			}

		} catch (UnknownHostException netInterfaces) {
			Enumeration<?> netInterfaces1 = null;
			try {
				netInterfaces1 = NetworkInterface.getNetworkInterfaces();
			} catch (SocketException e) {
				return strIp;
			}
			InetAddress ip = null;
			while (netInterfaces1.hasMoreElements()) {
				NetworkInterface ni = (NetworkInterface) netInterfaces1.nextElement();
				Enumeration<?> enumInetAddress = ni.getInetAddresses();
				while (enumInetAddress.hasMoreElements()) {
					ip = (InetAddress) enumInetAddress.nextElement();
					strIp = ip.getHostAddress();

					if ((!strIp.startsWith("127")) && (!strIp.startsWith("l")) && (!strIp.startsWith("L"))) {
						return strIp;
					}
				}
			}
		}
		return strIp;
	}

	public static byte[] hexStringToBytes(String strHexString) {
		String strDigital = "0123456789ABCDEF";

		byte[] bytes = new byte[strHexString.length() / 2];

		for (int i = 0; i < bytes.length; i++) {
			int temp = strDigital.indexOf(strHexString.substring(2 * i, 2 * i + 1)) * 16;
			temp += strDigital.indexOf(strHexString.substring(2 * i + 1, 2 * i + 2));
			bytes[i] = (byte) (temp & 0xFF);
		}

		return bytes;
	}

	public static String bytesToHexString(byte[] bysBytes) {
		String strDigital = "0123456789ABCDEF";

		StringBuilder sb = new StringBuilder("");
		byte[] bs = bysBytes;

		for (int i = 0; i < bs.length; i++) {
			int bit = (bs[i] & 0xF0) >> 4;
			sb.append(strDigital.substring(bit, bit + 1));
			bit = bs[i] & 0xF;
			sb.append(strDigital.substring(bit, bit + 1));
		}

		return sb.toString();
	}

	public static void closeReader(Reader reader) {
		if (reader == null) {
			return;
		}
		try {
			reader.close();
		} catch (Exception localException) {
		}
	}

	public static String getExceptionMessage(Exception e) {
		StringBuilder strbMessage = new StringBuilder(1024);

		StackTraceElement[] ste = e.getStackTrace();
		strbMessage.append(e.getMessage());
		for (int i = 0; i < ste.length; i++) {
			strbMessage.append("\r\n");
			strbMessage.append(ste[i].toString());
		}

		return strbMessage.toString();
	}

	public static String makeSameCharString(char ch, int nLength) {
		char[] chsOutput = new char[nLength];
		for (int i = 0; i < nLength; i++) {
			chsOutput[i] = ch;
		}

		return new String(chsOutput);
	}

	public static String format(Object obj, String strFormat) throws Exception {
		if (IsInstanceOf(obj, "java.lang.String")) {
			String strObj = (String) obj;
			if ((strFormat == null) || (strFormat.length() == 0)) {
				return strObj;
			}

			String[] strsFormatItem = splitString(strFormat, ',');
			int nLength = 0;
			char chFill = ' ';
			int nFillAt = 0;
			if (strsFormatItem.length >= 1) {
				nLength = Integer.parseInt(strsFormatItem[0]);
			}
			if (strsFormatItem.length >= 2) {
				if (strsFormatItem[1].length() != 1) {
					throw new Exception("Unsupported format: " + strFormat);
				}
				chFill = strsFormatItem[1].charAt(0);
			}
			if (strsFormatItem.length >= 3) {
				nFillAt = Integer.parseInt(strsFormatItem[2]);
				if ((nFillAt != 0) && (nFillAt != 1)) {
					throw new Exception("Unsupported format: " + strFormat);
				}
			} else {
				throw new Exception("Unsupported format: " + strFormat);
			}

			if (strObj.length() >= nLength) {
				return strObj;
			}

			String strOutput = "";
			if (nFillAt == 0) {
				strOutput = makeSameCharString(chFill, nLength - strObj.length()) + strObj;
			} else {
				strOutput = strObj + makeSameCharString(chFill, nLength - strObj.length());
			}

			return strOutput;
		}
		if ((IsInstanceOf(obj, "java.lang.Byte")) || (IsInstanceOf(obj, "java.lang.Integer")) || (IsInstanceOf(obj, "java.lang.Long"))) {
			String strObj = obj.toString();
			if ((strFormat == null) || (strFormat.length() == 0)) {
				return strObj;
			}

			String[] strsFormatItem = splitString(strFormat, ',');
			int nLength = 0;
			char chFill = ' ';
			int nFillAt = 0;
			if (strsFormatItem.length >= 1) {
				nLength = Integer.parseInt(strsFormatItem[0]);
			}
			if (strsFormatItem.length >= 2) {
				if (strsFormatItem[1].length() != 1) {
					throw new Exception("Unsupported format: " + strFormat);
				}
				chFill = strsFormatItem[1].charAt(0);
			}
			if (strsFormatItem.length >= 3) {
				nFillAt = Integer.parseInt(strsFormatItem[2]);
				if ((nFillAt != 0) && (nFillAt != 1)) {
					throw new Exception("Unsupported format: " + strFormat);
				}
			} else {
				throw new Exception("Unsupported format: " + strFormat);
			}

			if (strObj.length() >= nLength) {
				return strObj;
			}

			String strOutput = "";
			if (nFillAt == 0) {
				strOutput = makeSameCharString(chFill, nLength - strObj.length()) + strObj;
			} else {
				strOutput = strObj + makeSameCharString(chFill, nLength - strObj.length());
			}

			return strOutput;
		}
		if (IsInstanceOf(obj, "java.sql.Timestamp")) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return format.format((Timestamp) obj);
		}

		throw new Exception("Unsupported format: " + strFormat);
	}

	public static String formatArray(Object objArray, int nIndex, String strFormat) throws Exception {
		if (!objArray.getClass().isArray()) {
			throw new Exception("Object not an array");
		}

		Object obj = null;
		if (IsInstanceOf(objArray, "[B")) {
			byte[] bysObj = (byte[]) objArray;
			obj = new Byte(bysObj[nIndex]);
		} else if (IsInstanceOf(objArray, "[I")) {
			int[] nsObj = (int[]) objArray;
			obj = new Integer(nsObj[nIndex]);
		} else if (IsInstanceOf(objArray, "[J")) {
			long[] lsObj = (long[]) objArray;
			obj = new Long(lsObj[nIndex]);
		} else if (IsInstanceOf(objArray, "[Ljava.lang.String")) {
			String[] strsObj = (String[]) objArray;
			obj = strsObj[nIndex];
		} else if (IsInstanceOf(objArray, "[Ljava.sql.Timestamp")) {
			Timestamp[] dtsObj = (Timestamp[]) objArray;
			obj = dtsObj[nIndex];
		} else {
			throw new Exception("Unsupported array: " + objArray.getClass().getName());
		}

		if (IsInstanceOf(obj, "java.lang.String")) {
			String strObj = (String) obj;
			if ((strFormat == null) || (strFormat.length() == 0)) {
				return strObj;
			}

			String[] strsFormatItem = splitString(strFormat, ',');
			int nLength = 0;
			char chFill = ' ';
			int nFillAt = 0;
			if (strsFormatItem.length >= 1) {
				nLength = Integer.parseInt(strsFormatItem[0]);
			}
			if (strsFormatItem.length >= 2) {
				if (strsFormatItem[1].length() != 1) {
					throw new Exception("Unsupported format: " + strFormat);
				}
				chFill = strsFormatItem[1].charAt(0);
			}
			if (strsFormatItem.length >= 3) {
				nFillAt = Integer.parseInt(strsFormatItem[2]);
				if ((nFillAt != 0) && (nFillAt != 1)) {
					throw new Exception("Unsupported format: " + strFormat);
				}
			} else {
				throw new Exception("Unsupported format: " + strFormat);
			}

			if (strObj.length() >= nLength) {
				return strObj;
			}

			String strOutput = "";
			if (nFillAt == 0) {
				strOutput = makeSameCharString(chFill, nLength - strObj.length()) + strObj;
			} else {
				strOutput = strObj + makeSameCharString(chFill, nLength - strObj.length());
			}

			return strOutput;
		}
		if ((IsInstanceOf(obj, "java.lang.Byte")) || (IsInstanceOf(obj, "java.lang.Integer")) || (IsInstanceOf(obj, "java.lang.Long"))) {
			String strObj = obj.toString();
			if ((strFormat == null) || (strFormat.length() == 0)) {
				return strObj;
			}

			String[] strsFormatItem = splitString(strFormat, ',');
			int nLength = 0;
			char chFill = ' ';
			int nFillAt = 0;
			if (strsFormatItem.length >= 1) {
				nLength = Integer.parseInt(strsFormatItem[0]);
			}
			if (strsFormatItem.length >= 2) {
				if (strsFormatItem[1].length() != 1) {
					throw new Exception("Unsupported format: " + strFormat);
				}
				chFill = strsFormatItem[1].charAt(0);
			}
			if (strsFormatItem.length >= 3) {
				nFillAt = Integer.parseInt(strsFormatItem[2]);
				if ((nFillAt != 0) && (nFillAt != 1)) {
					throw new Exception("Unsupported format: " + strFormat);
				}
			} else {
				throw new Exception("Unsupported format: " + strFormat);
			}

			if (strObj.length() >= nLength) {
				return strObj;
			}

			String strOutput = "";
			if (nFillAt == 0) {
				strOutput = makeSameCharString(chFill, nLength - strObj.length()) + strObj;
			} else {
				strOutput = strObj + makeSameCharString(chFill, nLength - strObj.length());
			}

			return strOutput;
		}
		if (IsInstanceOf(obj, "java.sql.Timestamp")) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return format.format((Timestamp) obj);
		}

		throw new Exception("Unsupported format: " + strFormat);
	}

	public static String writeTempFile(String strPrefix, String strPostfix, byte[] bysContent) {
		File fileTemp = null;
		try {
			fileTemp = File.createTempFile(strPrefix, strPostfix);
			writeFile(fileTemp, bysContent);
		} catch (Exception e) {
			return null;
		}

		return fileTemp.getAbsolutePath();
	}

	public static boolean isLeapYear(int nYear) {
		if (nYear % 100 == 0) {
			return nYear % 400 == 0;
		}

		return nYear % 4 == 0;
	}

	public static boolean checkDate(String strValue) {
		int nLength = strValue.length();
		if (nLength == 0) {
			return true;
		}
		if (nLength != 10) {
			return false;
		}

		if ((strValue.charAt(4) != '-') && (strValue.charAt(7) != '-')) {
			return false;
		}
		String strYear = strValue.substring(0, 4);
		String strMonth = strValue.substring(5, 7);
		String strDay = strValue.substring(8);
		if ((!isIntText(strYear)) || (!isIntText(strMonth)) || (!isIntText(strDay))) {
			return false;
		}
		int nMonth = Integer.parseInt(strMonth);
		if ((nMonth < 1) || (nMonth > 12)) {
			return false;
		}
		int nDay = Integer.parseInt(strDay);
		if ((nDay < 1) || (nDay > 31)) {
			return false;
		}
		if ((nMonth == 1) || (nMonth == 3) || (nMonth == 5) || (nMonth == 7) || (nMonth == 8) || (nMonth == 10) || (nMonth == 12)) {
			return true;
		}
		if ((nMonth == 4) || (nMonth == 6) || (nMonth == 9) || (nMonth == 11)) {
			return nDay <= 30;
		}

		int nYear = Integer.parseInt(strYear);
		if ((!isLeapYear(nYear)) && (nDay > 28)) {
			return false;
		}

		return (!isLeapYear(nYear)) || (nDay <= 29);
	}

	public static boolean checkTime(String strValue) {
		int nLength = strValue.length();
		if (nLength == 0) {
			return true;
		}
		if (nLength != 8) {
			return false;
		}

		if ((strValue.charAt(2) != ':') && (strValue.charAt(5) != ':')) {
			return false;
		}
		String strHour = strValue.substring(0, 2);
		String strMinute = strValue.substring(3, 5);
		String strSecond = strValue.substring(6);
		if ((!isIntText(strHour)) || (!isIntText(strMinute)) || (!isIntText(strSecond))) {
			return false;
		}
		int nHour = Integer.parseInt(strHour);
		if ((nHour < 0) || (nHour > 23)) {
			return false;
		}
		int nMinute = Integer.parseInt(strMinute);
		if ((nMinute < 0) || (nMinute > 59)) {
			return false;
		}
		int nSecond = Integer.parseInt(strSecond);

		return (nSecond >= 0) && (nSecond <= 59);
	}

	public static boolean checkDateTime(String strValue) {
		if (strValue.length() != 19) {
			return false;
		}
		if (strValue.charAt(10) != ' ') {
			return false;
		}

		String strDate = strValue.substring(0, 10);
		if (!checkDate(strDate)) {
			return false;
		}
		String strTime = strValue.substring(11);

		return checkTime(strTime);
	}

	public static boolean isDateArray(String[] strsDate) {
		if (strsDate == null) {
			return false;
		}
		for (int i = 0; i < strsDate.length; i++) {
			if (!strsDate[i].matches("([0-9]{4}-[0-9]{2}-[0-9]{2})?")) {
				return false;
			}
		}

		return true;
	}

	public static boolean isTimeArray(String[] strsTime) {
		if (strsTime == null) {
			return false;
		}
		for (int i = 0; i < strsTime.length; i++) {
			if (!strsTime[i].matches("([0-9]{2}:[0-9]{2}:[0-9]{2})?")) {
				return false;
			}
		}

		return true;
	}

	public static boolean isDateTimeArray(String[] strsDateTime) {
		if (strsDateTime == null) {
			return false;
		}
		for (int i = 0; i < strsDateTime.length; i++) {
			if (!strsDateTime[i].matches("([0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2})?")) {
				return false;
			}
		}

		return true;
	}

	public static int findMatchedChar(int nIndex, String strText) {
		if (nIndex < 0) {
			return -1;
		}

		char[] chsText = strText.toCharArray();

		char chChar = chsText[nIndex];
		int nCount = 0;
		int nStartIndex = -1;
		int nEndIndex = -1;

		char chFind = ' ';
		switch (chChar) {
		case '(':
			chFind = ')';
			break;
		case '{':
			chFind = '}';
			break;
		case '[':
			chFind = ']';
			break;
		case ')':
			chFind = '(';
			break;
		case '}':
			chFind = '{';
			break;
		case ']':
			chFind = '[';
			break;
		default:
			return -1;
		}

		int nLength = chsText.length;
		switch (chChar) {
		case '(':
		case '[':
		case '{':
			for (int i = nIndex + 1; i < nLength; i++) {
				char ch = chsText[i];

				if (ch == chChar) {
					nCount++;
				} else {
					if (ch != chFind)
						continue;
					if (nCount == 0) {
						nEndIndex = i;
						break;
					}

					nCount--;
				}
			}

			return nEndIndex;
		case ')':
		case ']':
		case '}':
			for (int i = nIndex - 1; i >= 0; i--) {
				char ch = chsText[i];

				if (ch == chChar) {
					nCount++;
				} else {
					if (ch != chFind)
						continue;
					if (nCount == 0) {
						nStartIndex = i;
						break;
					}

					nCount--;
				}
			}

			return nStartIndex;
		}
		return -1;
	}

	public static int findMatchedChar(int nIndex, char[] chsText) {
		if (nIndex < 0) {
			return -1;
		}

		char chChar = chsText[nIndex];
		int nCount = 0;
		int nStartIndex = -1;
		int nEndIndex = -1;

		char chFind = ' ';
		switch (chChar) {
		case '(':
			chFind = ')';
			break;
		case '{':
			chFind = '}';
			break;
		case '[':
			chFind = ']';
			break;
		case ')':
			chFind = '(';
			break;
		case '}':
			chFind = '{';
			break;
		case ']':
			chFind = '[';
			break;
		default:
			return -1;
		}

		int nLength = chsText.length;
		switch (chChar) {
		case '(':
		case '[':
		case '{':
			for (int i = nIndex + 1; i < nLength; i++) {
				char ch = chsText[i];

				if (ch == chChar) {
					nCount++;
				} else {
					if (ch != chFind)
						continue;
					if (nCount == 0) {
						nEndIndex = i;
						break;
					}

					nCount--;
				}
			}

			return nEndIndex;
		case ')':
		case ']':
		case '}':
			for (int i = nIndex - 1; i >= 0; i--) {
				char ch = chsText[i];

				if (ch == chChar) {
					nCount++;
				} else {
					if (ch != chFind)
						continue;
					if (nCount == 0) {
						nStartIndex = i;
						break;
					}

					nCount--;
				}
			}

			return nStartIndex;
		}
		return -1;
	}

	public static String[] getDirFileList(String strDirOrFile) {
		File file = null;
		try {
			file = new File(strDirOrFile);
			String[] strsFile = (String[]) null;
			if (file.isFile()) {
				strsFile = new String[1];
				strsFile[0] = strDirOrFile;
				return strsFile;
			}
			File[] filesList = file.listFiles();
			strsFile = new String[filesList.length];
			for (int i = 0; i < filesList.length; i++) {
				String strFile = filesList[i].getAbsolutePath();
				strsFile[i] = strFile;
			}

			return strsFile;
		} catch (Exception e) {
		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	public static String mapToString(Map map) {
		Iterator<?> iterator = map.keySet().iterator();
		StringBuilder sb = new StringBuilder();
		String key = null;
		String value = null;
		while (iterator.hasNext()) {
			key = (String) iterator.next();
			value = map.get(key).toString();
			sb.append(key).append("=").append(value).append(";");
		}
		return sb.toString();
	}

	public static int getSecondOfDay() {
		Calendar cal = Calendar.getInstance();
		int nReturn = cal.get(13);
		nReturn += cal.get(12) * 60;
		nReturn += cal.get(11) * 3600;
		return nReturn;
	}

	public static int getWeekDay() {
		Calendar cal = Calendar.getInstance();
		int nReturn = cal.get(7);
		return nReturn - 1;
	}

	public static String formatIPV4(String strIp) {
		if (strIp == null) {
			return null;
		}
		String[] strs = strIp.split("\\.");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < strs.length; i++) {
			if (i > 0) {
				sb.append(".");
			}
			int len = strs[i].length();
			if (len == 1) {
				sb.append("00");
			} else if (len == 2) {
				sb.append("0");
			}
			sb.append(strs[i]);
		}
		return sb.toString();
	}

	public static int getFirstWord(String strText, StringBuilder strWord) {
		strWord.setLength(0);

		int nIndex = 0;
		for (int i = 0; i < strText.length(); i++) {
			char chChar = strText.charAt(i);

			if ((chChar == ' ') || (chChar == '\t')) {
				if (strWord.length() > 0) {
					break;
				}
				nIndex++;
			} else {
				strWord.append(chChar);
			}
		}

		if (strWord.length() == 0) {
			nIndex = 0;
		}

		return nIndex;
	}

	public static String subStr(String strSource, int nIndex, int nLength) {
		int nSize = strSource.length();
		if (nIndex >= nSize) {
			return "";
		}
		if (nIndex + nLength >= nSize) {
			return strSource.substring(nIndex);
		}
		return strSource.substring(nIndex, nIndex + nLength);
	}

	public static boolean isIntText(String strText) {
		strText = strText.trim();
		if (strText.length() == 0) {
			return false;
		}

		for (int i = 0; i < strText.length(); i++) {
			if ((strText.charAt(i) < '0') || (strText.charAt(i) > '9')) {
				return false;
			}
		}

		return true;
	}

	public static boolean isIntTextSet(String strText) {
		strText = strText.trim();
		if (strText.length() == 0) {
			return false;
		}

		for (int i = 0; i < strText.length(); i++) {
			if (((strText.charAt(i) < '0') || (strText.charAt(i) > '9')) && (strText.charAt(i) != ' ')) {
				return false;
			}
		}

		return true;
	}

	public static String intToString(long nValue) {
		Long intTemp = new Long(nValue);
		return intTemp.toString();
	}

	public static String intToString(long nValue, int nLength) {
		StringBuilder strbFormat = new StringBuilder(32);
		for (int i = 0; i < nLength; i++) {
			strbFormat.append('0');
		}

		synchronized (decFormat) {
			decFormat.applyPattern(strbFormat.toString());
			return decFormat.format(nValue);
		}
	}

	public static boolean isNumberText(String strText, int nDigitCount) {
		if (strText.length() == 0) {
			return false;
		}

		int nDotCount = 0;
		for (int i = 0; i < strText.length(); i++) {
			if (strText.charAt(i) == '.') {
				if (nDotCount > 0) {
					return false;
				}
				if (i + 3 < strText.length()) {
					return false;
				}
				nDotCount++;
			} else if ((strText.charAt(i) < '0') || (strText.charAt(i) > '9')) {
				return false;
			}
		}

		return true;
	}

	public static boolean isNumberText(String strText) {
		if (strText.length() == 0) {
			return false;
		}

		for (int i = 0; i < strText.length(); i++) {
			if ((strText.charAt(i) < '0') || (strText.charAt(i) > '9')) {
				return false;
			}
		}

		return true;
	}

	public static long numberTextToInteger(String strText, int nDigitCount) throws Exception {
		if (strText.length() == 0) {
			throw new Exception("");
		}

		long lValue = 0L;
		int nDotCount = 0;
		int nDotPos = strText.length();
		for (int i = 0; i < strText.length(); i++) {
			if (strText.charAt(i) == '.') {
				if (nDotCount > 0) {
					throw new Exception("");
				}
				if (i + nDigitCount + 1 < strText.length()) {
					throw new Exception("");
				}
				nDotCount++;
				nDotPos = i;
			} else {
				if ((strText.charAt(i) < '0') || (strText.charAt(i) > '9')) {
					throw new Exception("");
				}

				if ((nDotCount > 0) && (i - nDotPos > nDigitCount)) {
					throw new Exception("");
				}
				lValue = lValue * 10L + (strText.charAt(i) - '0');
			}
		}
		if (nDotCount == 0) {
			for (int i = 0; i < nDigitCount; i++) {
				lValue *= 10L;
			}
			return lValue;
		}

		for (int i = 0; i < nDigitCount - (strText.length() - nDotPos - 1); i++) {
			lValue *= 10L;
		}

		return lValue;
	}

	public static String integerToNumberText(long lValue, int nDigitCount) {
		String strDigit = "";
		long lTemp = lValue;
		for (int i = 0; i < nDigitCount; i++) {
			if (lTemp >= 0L) {
				strDigit = lTemp % 10L + strDigit;
			} else {
				strDigit = -lTemp % 10L + strDigit;
			}
			lTemp /= 10L;
		}

		if (strDigit.length() > 0) {
			if ((lTemp == 0L) && (lValue < 0L)) {
				return 45L + lTemp + 46L + strDigit;
			}

			return lTemp + '.' + strDigit;
		}

		return lTemp + strDigit;
	}

	public static Serializable deepClone(Serializable obj) {
		Serializable objOutput = null;
		byte[] bysObject = (byte[]) null;

		ObjectOutputStream out = null;
		ByteArrayOutputStream streamOutput = new ByteArrayOutputStream();
		try {
			out = new ObjectOutputStream(streamOutput);
			out.writeObject(obj);
			bysObject = streamOutput.toByteArray();
		} catch (Exception e) {
			return null;
		} finally {
			try {
				out.close();
			} catch (Exception localException3) {
			}
			try {
				streamOutput.close();
			} catch (Exception localException4) {
			}

		}

		ByteArrayInputStream streamInput = new ByteArrayInputStream(bysObject);

		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(streamInput);
			objOutput = (Serializable) in.readObject();
		} catch (Exception e) {
			return null;
		} finally {
			try {
				in.close();
			} catch (Exception localException9) {
			}
			try {
				streamInput.close();
			} catch (Exception localException10) {
			}
		}

		return objOutput;
	}

	public static int compareLong(Object objValue1, Object objValue2) {
		Long value1 = parseLongValue(objValue1);
		Long value2 = parseLongValue(objValue2);
		return value1.compareTo(value2);
	}

	public static int compareDouble(Object objValue1, Object objValue2) {
		Double value1 = Double.valueOf(objValue1.toString());
		Double value2 = Double.valueOf(objValue2.toString());
		return value1.compareTo(value2);
	}

	public static int compareString(Object objValue1, Object objValue2) {
		String strValue1 = objValue1.toString();
		String strValue2 = objValue2.toString();
		return strValue1.compareTo(strValue2);
	}

	public static Object parseObjectValue(int nType, Object source) {
		if (source == null) {
			return null;
		}
		switch (nType) {
		case 8:
			return source.toString();
		case 4:
			return parseIntegerValue(source);
		case 5:
			return parseLongValue(source);
		case 11:
			return parseDateTimeValue(source);
		case 9:
			return parseDateValue(source);
		case 10:
			return parseTimeValue(source);
		case 6:
			return parseFloatValue(source);
		case 7:
			return parseDoubleValue(source);
		case 1:
			return parseBooleanValue(source);
		case 2:
			return parseByteValue(source);
		case 3:
			return parseShortValue(source);
		case 102:
			return parseByteArrayValue(source);
		case 104:
			return parseIntegerArrayValue(source);
		case 105:
			return parseLongArrayValue(source);
		case 101:
			return parseBooleanArrayValue(source);
		case 103:
			return parseShortArrayValue(source);
		case 108:
			return parseStringArrayValue(source);
		}

		throw new RuntimeException("invalid type " + nType);
	}

	public static String parseStingValue(Object source) {
		if (source == null) {
			return null;
		}
		return source.toString();
	}

	public static String[] parseStringArrayValue(Object source) {
		if (source == null) {
			return null;
		}
		if ((source instanceof String[])) {
			return (String[]) source;
		}
		if ((source instanceof String)) {
			String[] ss = ((String) source).split(",");
			return ss;
		}
		return new String[] { source.toString() };
	}

	public static Integer parseIntegerValue(Object source) {
		if (source == null) {
			return null;
		}
		if ((source instanceof Integer)) {
			return (Integer) source;
		}
		return Integer.valueOf(Double.valueOf(source.toString()).intValue());
	}

	public static int[] parseIntegerArrayValue(Object source) {
		if (source == null) {
			return null;
		}
		if ((source instanceof int[])) {
			return (int[]) source;
		}
		if ((source instanceof Object[])) {
			Object[] objs = (Object[]) source;
			int[] values = new int[objs.length];
			for (int i = 0; i < objs.length; i++) {
				values[i] = Double.valueOf(objs[i].toString()).intValue();
			}
			return values;
		}
		if ((source instanceof String)) {
			String[] ss = ((String) source).split(",");
			int[] bsArr = new int[ss.length];
			for (int i = 0; i < ss.length; i++) {
				bsArr[i] = Double.valueOf(ss[i]).intValue();
			}
			return bsArr;
		}
		return new int[] { Double.valueOf(source.toString()).intValue() };
	}

	public static Long parseLongValue(Object source) {
		if (source == null) {
			return null;
		}

		if ((source instanceof Long)) {
			return (Long) source;
		}
		return Long.valueOf(Double.valueOf(source.toString()).longValue());
	}

	public static long[] parseLongArrayValue(Object source) {
		if (source == null) {
			return null;
		}
		if ((source instanceof long[])) {
			return (long[]) source;
		}
		if ((source instanceof int[])) {
			int[] nsSource = (int[]) source;
			long[] lsResult = new long[nsSource.length];
			for (int i = 0; i < nsSource.length; i++) {
				lsResult[i] = nsSource[i];
			}
			return lsResult;
		}
		if ((source instanceof Object[])) {
			Object[] objs = (Object[]) source;
			long[] values = new long[objs.length];
			for (int i = 0; i < objs.length; i++) {
				values[i] = new Double(objs[i].toString()).longValue();
			}
			return values;
		}
		if ((source instanceof String)) {
			String[] ss = ((String) source).split(",");
			long[] bsArr = new long[ss.length];
			for (int i = 0; i < ss.length; i++) {
				bsArr[i] = new Double(ss[i]).longValue();
			}
			return bsArr;
		}
		return new long[] { new Double(source.toString()).longValue() };
	}

	public static String parseDateTimeValue(Object source) {
		if (source == null) {
			return null;
		}
		if ((source instanceof String)) {
			String strValue = source.toString();
			if (checkDateTime(strValue)) {
				return strValue;
			}
			if (checkDate(strValue)) {
				return strValue + " 00:00:00";
			}

			throw new RuntimeException("Invalid date format " + source);
		}

		if ((source instanceof java.util.Date)) {
			java.util.Date temp = (java.util.Date) source;
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return format.format(temp);
		}
		if ((source instanceof java.sql.Timestamp)) {
			java.sql.Timestamp temp = (java.sql.Timestamp) source;
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return format.format(temp);
		}
		throw new RuntimeException("Invalid date format " + source);
	}

	public static String parseDateValue(Object source) {
		if (source == null) {
			return null;
		}
		if ((source instanceof String)) {
			String strValue = source.toString();
			if (checkDate(strValue)) {
				return strValue;
			}
			if (checkDateTime(strValue)) {
				return strValue.substring(0, 10);
			}

			throw new RuntimeException("Invalid date format");
		}

		if ((source instanceof java.util.Date)) {
			java.util.Date temp = (java.util.Date) source;
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return format.format(temp);
		}
		if ((source instanceof java.sql.Timestamp)) {
			java.sql.Timestamp temp = (java.sql.Timestamp) source;
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return format.format(temp);
		}
		throw new RuntimeException("Invalid date format " + source);
	}

	public static String parseTimeValue(Object source) {
		if (source == null) {
			return null;
		}
		if ((source instanceof String)) {
			String strValue = source.toString();
			if (checkTime(strValue)) {
				return strValue;
			}
			if (checkDateTime(strValue)) {
				return strValue.substring(11);
			}
			throw new RuntimeException("Invalid date format");
		}
		if ((source instanceof java.util.Date)) {
			java.util.Date temp = (java.util.Date) source;
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return format.format(temp);
		}
		if ((source instanceof java.sql.Timestamp)) {
			java.sql.Timestamp temp = (java.sql.Timestamp) source;
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return format.format(temp);
		}

		throw new RuntimeException("Invalid date format " + source);
	}

	public static Float parseFloatValue(Object source) {
		if (source == null) {
			return null;
		}
		if ((source instanceof Float)) {
			return (Float) source;
		}
		return Float.valueOf(Double.valueOf(source.toString()).floatValue());
	}

	public static float[] parseFloatArrayValue(Object source) {
		if (source == null) {
			return null;
		}
		if ((source instanceof float[])) {
			return (float[]) source;
		}
		if ((source instanceof Object[])) {
			Object[] objs = (Object[]) source;
			float[] values = new float[objs.length];
			for (int i = 0; i < objs.length; i++) {
				values[i] = Double.valueOf(objs[i].toString()).floatValue();
			}
			return values;
		}
		if ((source instanceof String)) {
			String[] ss = ((String) source).split(",");
			float[] bsArr = new float[ss.length];
			for (int i = 0; i < ss.length; i++) {
				bsArr[i] = Float.parseFloat(ss[i]);
			}
			return bsArr;
		}
		return new float[] { Double.valueOf(source.toString()).floatValue() };
	}

	public static Double parseDoubleValue(Object source) {
		if (source == null) {
			return null;
		}
		if ((source instanceof Double)) {
			return (Double) source;
		}
		return Double.valueOf(source.toString());
	}

	public static double[] parseDoubleArrayValue(Object source) {
		if (source == null) {
			return null;
		}
		if ((source instanceof double[])) {
			return (double[]) source;
		}
		if ((source instanceof Object[])) {
			Object[] objs = (Object[]) source;
			double[] values = new double[objs.length];
			for (int i = 0; i < objs.length; i++) {
				values[i] = Double.valueOf(objs[i].toString()).floatValue();
			}
			return values;
		}
		if ((source instanceof String)) {
			String[] ss = ((String) source).split(",");
			double[] bsArr = new double[ss.length];
			for (int i = 0; i < ss.length; i++) {
				bsArr[i] = Double.parseDouble(ss[i]);
			}
			return bsArr;
		}
		return new double[] { Double.valueOf(source.toString()).doubleValue() };
	}

	public static Boolean parseBooleanValue(Object source) {
		if (source == null) {
			return null;
		}
		if ((source instanceof Boolean)) {
			return (Boolean) source;
		}
		String strValue = source.toString();
		if ("true".equalsIgnoreCase(strValue)) {
			return Boolean.TRUE;
		}
		if ("false".equalsIgnoreCase(strValue)) {
			return Boolean.FALSE;
		}
		if (Long.parseLong(strValue) == 0L) {
			return Boolean.FALSE;
		}

		return Boolean.TRUE;
	}

	public static boolean[] parseBooleanArrayValue(Object source) {
		if (source == null) {
			return null;
		}
		if ((source instanceof boolean[])) {
			return (boolean[]) source;
		}
		if ((source instanceof Boolean[])) {
			Boolean[] bs = (Boolean[]) source;
			boolean[] bsArr = new boolean[bs.length];
			for (int i = 0; i < bs.length; i++) {
				bsArr[i] = bs[i].booleanValue();
			}
			return bsArr;
		}
		if ((source instanceof String)) {
			String[] ss = ((String) source).split(",");
			boolean[] bsArr = new boolean[ss.length];
			for (int i = 0; i < ss.length; i++) {
				if ("true".equalsIgnoreCase(ss[i])) {
					bsArr[i] = true;
				} else {
					bsArr[i] = false;
				}
			}
			return bsArr;
		}
		return null;
	}

	public static Boolean[] parseBooleanObjectArrayValue(Object source) {
		if (source == null) {
			return null;
		}
		if ((source instanceof Boolean[])) {
			return (Boolean[]) source;
		}
		if ((source instanceof boolean[])) {
			boolean[] bs = (boolean[]) source;
			Boolean[] bsArr = new Boolean[bs.length];
			for (int i = 0; i < bs.length; i++) {
				bsArr[i] = new Boolean(bs[i]);
			}
			return bsArr;
		}
		if ((source instanceof String)) {
			String[] ss = ((String) source).split(",");
			Boolean[] bsArr = new Boolean[ss.length];
			for (int i = 0; i < ss.length; i++) {
				if ("true".equalsIgnoreCase(ss[i])) {
					bsArr[i] = Boolean.TRUE;
				} else {
					bsArr[i] = Boolean.FALSE;
				}
			}
			return bsArr;
		}
		return null;
	}

	public static Short parseShortValue(Object source) {
		if (source == null) {
			return null;
		}
		if ((source instanceof Byte)) {
			return (Short) source;
		}
		return Short.valueOf(Double.valueOf(source.toString()).shortValue());
	}

	public static short[] parseShortArrayValue(Object source) {
		if (source == null) {
			return null;
		}
		if ((source instanceof short[])) {
			return (short[]) source;
		}
		if ((source instanceof Object[])) {
			Object[] objs = (Object[]) source;
			short[] values = new short[objs.length];
			for (int i = 0; i < objs.length; i++) {
				values[i] = Double.valueOf(objs[i].toString()).shortValue();
			}
			return values;
		}
		if ((source instanceof String)) {
			String[] ss = ((String) source).split(",");
			short[] bsArr = new short[ss.length];
			for (int i = 0; i < ss.length; i++) {
				bsArr[i] = Short.parseShort(ss[i]);
			}
			return bsArr;
		}
		return new short[] { Long.valueOf(source.toString()).shortValue() };
	}

	public static Byte parseByteValue(Object source) {
		if (source == null) {
			return null;
		}
		if ((source instanceof Byte)) {
			return (Byte) source;
		}
		return Byte.valueOf(Long.valueOf(source.toString()).byteValue());
	}

	public static byte[] parseByteArrayValue(Object source) {
		if (source == null) {
			return null;
		}
		if ((source instanceof byte[])) {
			return (byte[]) source;
		}
		if ((source instanceof String)) {
			String[] ss = ((String) source).split(",");
			byte[] bsArr = new byte[ss.length];
			for (int i = 0; i < ss.length; i++) {
				bsArr[i] = Byte.parseByte(ss[i]);
			}
			return bsArr;
		}
		return source.toString().getBytes();
	}

	public static String numberToStringWithFixedLength(int value, int length) {
		String temp = "";
		for (int i = 0; i < length; i++) {
			temp = temp + "0";
		}
		DecimalFormat df = new DecimalFormat(temp);
		return df.format(value);
	}

	public static String FormatTextForMongodb(String strText) {
		if (strText == null) {
			return null;
		}
		StringBuilder strbText = new StringBuilder(strText.length());
		int nLength = strText.length();
		for (int i = 0; i < nLength; i++) {
			char ch = strText.charAt(i);
			switch (ch) {
			case '[':
				strbText.append("\\[");
				break;
			case ']':
				strbText.append("\\]");
				break;
			case '(':
				strbText.append("\\(");
				break;
			case ')':
				strbText.append("\\)");
				break;
			case '{':
				strbText.append("\\{");
				break;
			case '}':
				strbText.append("\\}");
				break;
			case '\\':
				strbText.append("\\\\");
				break;
			case '+':
				strbText.append("\\+");
				break;
			case '*':
				strbText.append("\\*");
				break;
			case '?':
				strbText.append("\\?");
				break;
			case '.':
				strbText.append("\\.");
				break;
			default:
				strbText.append(ch);
			}
		}

		return strbText.toString();
	}
}
