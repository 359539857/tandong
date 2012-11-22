package cto.framework.core;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import cto.framework.core.json.JSONArray;
import cto.framework.core.json.JSONException;
import cto.framework.core.json.JSONObject;
import cto.framework.core.util.Function;
import cto.framework.core.xml.XMLElement;

public class CTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private HashMap<String, CTOItem> hmItem = new HashMap<String, CTOItem>();;

	public CTO(Map<String, Object> map) {
		if (map != null && !map.isEmpty()) {
			Iterator<String> iterator = map.keySet().iterator();
			while (iterator.hasNext()) {
				String key = iterator.next();
				Object value = map.get(key);
				this.setObjectValue(key, value);
			}
		}
	}

	public static CTO formJSON(String jsonString) throws JSONException {
		JSONObject jsonObject = new JSONObject(jsonString);
		CTO CTO = new CTO();
		CTO.fromJSON(jsonObject);
		return CTO;
	}

	protected void fromJSON(String strField, Object objValue) throws JSONException {
		if (strField.endsWith("Date")) {
			this.setDateStringValue(strField, (String) objValue);
			return;
		} else if (strField.endsWith("DateArray")) {
			this.setDateArrayStringValue(strField, (String[]) objValue);
			return;
		} else if (strField.endsWith("Time")) {
			this.setTimestampStringValue(strField, (String) objValue);
			return;
		} else if (strField.endsWith("TimeArray")) {
			this.setTimestampArrayStringValue(strField, (String[]) objValue);
			return;
		} else if (objValue instanceof Boolean) {
			this.setBooleanValue(strField, (Boolean) objValue);
			return;
		} else if (objValue instanceof boolean[]) {
			this.setBooleanArrayValue(strField, (boolean[]) objValue);
			return;
		} else if (objValue instanceof Byte) {
			this.setByteValue(strField, (Byte) objValue);
			return;
		} else if (objValue instanceof byte[]) {
			this.setByteArrayValue(strField, (byte[]) objValue);
			return;
		} else if (objValue instanceof Short) {
			this.setShortValue(strField, (Short) objValue);
			return;
		} else if (objValue instanceof short[]) {
			this.setShortArrayValue(strField, (short[]) objValue);
			return;
		} else if (objValue instanceof Integer) {
			this.setIntegerValue(strField, (Integer) objValue);
			return;
		} else if (objValue instanceof int[]) {
			this.setIntegerArrayValue(strField, (int[]) objValue);
			return;
		} else if (objValue instanceof Long) {
			this.setLongValue(strField, (Long) objValue);
			return;
		} else if (objValue instanceof long[]) {
			this.setLongArrayValue(strField, (long[]) objValue);
			return;
		} else if (objValue instanceof Float) {
			this.setFloatValue(strField, (Float) objValue);
			return;
		} else if (objValue instanceof float[]) {
			this.setFloatArrayValue(strField, (float[]) objValue);
			return;
		} else if (objValue instanceof Double) {
			this.setDoubleValue(strField, (Double) objValue);
			return;
		} else if (objValue instanceof double[]) {
			this.setDoubleArrayValue(strField, (double[]) objValue);
			return;
		} else if (objValue instanceof String) {
			this.setStringValue(strField, (String) objValue);
			return;
		} else if (objValue instanceof String[]) {
			this.setStringArrayValue(strField, (String[]) objValue);
			return;
		} else if (objValue instanceof JSONObject) {
			CTO CTOValue = new CTO();
			CTOValue.fromJSON((JSONObject) objValue);
			this.setCTOValue(strField, CTOValue);
			return;
		} else if (objValue instanceof JSONArray) {
			JSONArray jsonArray = (JSONArray) objValue;
			CTO[] CTOValues = new CTO[jsonArray.length()];
			for (int i = 0; i < jsonArray.length(); i++) {
				CTOValues[i] = new CTO();
				CTOValues[i].fromJSON((JSONObject) jsonArray.get(i));
			}
			this.setCTOArrayValue(strField, CTOValues);
			return;
		}
	}

	protected void fromJSON(JSONObject jsonObject) throws JSONException {
		Iterator<?> iterator = jsonObject.keys();
		while (iterator.hasNext()) {
			String strField = (String) iterator.next();
			Object objValue = jsonObject.get(strField);
			if (objValue instanceof JSONArray) {
				JSONArray jsonArray = (JSONArray) objValue;
				this.fromJSONArray(strField, jsonArray);
			} else {
				this.fromJSON(strField, objValue);
			}
		}
	}

	protected void fromJSONArray(String strField, JSONArray jsonArray) throws JSONException {
		int length = jsonArray.length();
		Object tempObject = jsonArray.get(0);
		if (tempObject instanceof JSONObject) {
			this.fromJSON(strField, jsonArray);
		} else if (tempObject instanceof Integer) {
			int[] nValues = new int[length];
			for (int i = 0; i < nValues.length; i++) {
				nValues[i] = jsonArray.getInt(i);
			}
			this.fromJSON(strField, nValues);
			return;
		} else if (tempObject instanceof Integer) {
			int[] nValues = new int[length];
			for (int i = 0; i < nValues.length; i++) {
				nValues[i] = jsonArray.getInt(i);
			}
			this.fromJSON(strField, nValues);
			return;
		} else if (tempObject instanceof Boolean) {
			boolean[] nValues = new boolean[length];
			for (int i = 0; i < nValues.length; i++) {
				nValues[i] = jsonArray.getBoolean(i);
			}
			this.fromJSON(strField, nValues);
			return;
		} else if (tempObject instanceof Byte) {
			byte[] nValues = new byte[length];
			for (int i = 0; i < nValues.length; i++) {
				nValues[i] = jsonArray.getByte(i);
			}
			this.fromJSON(strField, nValues);
			return;
		} else if (tempObject instanceof Short) {
			short[] nValues = new short[length];
			for (int i = 0; i < nValues.length; i++) {
				nValues[i] = jsonArray.getShort(i);
			}
			this.fromJSON(strField, nValues);
			return;
		} else if (tempObject instanceof Float) {
			float[] nValues = new float[length];
			for (int i = 0; i < nValues.length; i++) {
				nValues[i] = jsonArray.getFloat(i);
			}
			this.fromJSON(strField, nValues);
			return;
		} else if (tempObject instanceof Double) {
			double[] nValues = new double[length];
			for (int i = 0; i < nValues.length; i++) {
				nValues[i] = jsonArray.getDouble(i);
			}
			this.fromJSON(strField, nValues);
			return;
		} else if (tempObject instanceof Long) {
			long[] nValues = new long[length];
			for (int i = 0; i < nValues.length; i++) {
				nValues[i] = jsonArray.getLong(i);
			}
			this.fromJSON(strField, nValues);
			return;
		} else if (tempObject instanceof String) {
			String[] nValues = new String[length];
			for (int i = 0; i < nValues.length; i++) {
				nValues[i] = jsonArray.getString(i);
			}
			this.fromJSON(strField, nValues);
			return;
		}
	}

	protected void fromXML(XMLElement nodeCTO) {
		Iterator<?> enumNodes = nodeCTO.enumerateChildren();

		while (enumNodes.hasNext()) {
			XMLElement node = (XMLElement) enumNodes.next();

			String strTag = node.getName();
			if (strTag.equals("BF")) {
				String strName = node.getStringAttribute("N");
				String strValue = node.getStringAttribute("V");
				boolean bValue = false;
				if (strValue.equalsIgnoreCase("true")) {
					bValue = true;
				} else if (!strValue.equalsIgnoreCase("false")) {
					throw new TypeCastException("Parse xml error: unexpected boolean value " + strValue + " under " + strTag);
				}
				this.setBooleanValue(strName, bValue);
			} else if (strTag.equals("BYF")) {
				String strName = node.getStringAttribute("N");
				String strValue = node.getStringAttribute("V");
				this.setByteValue(strName, new Byte(strValue));
			} else if (strTag.equals("SF")) {
				String strName = node.getStringAttribute("N");
				String strValue = node.getStringAttribute("V");
				this.setShortValue(strName, new Short(strValue));
			} else if (strTag.equals("NF")) {
				String strName = node.getStringAttribute("N");
				String strValue = node.getStringAttribute("V");
				this.setIntegerValue(strName, new Integer(strValue));
			} else if (strTag.equals("LF")) {
				String strName = node.getStringAttribute("N");
				String strValue = node.getStringAttribute("V");
				this.setLongValue(strName, new Long(strValue));
			} else if (strTag.equals("FF")) {
				String strName = node.getStringAttribute("N");
				String strValue = node.getStringAttribute("V");
				this.setFloatValue(strName, new Float(strValue));
			} else if (strTag.equals("DBLF")) {
				String strName = node.getStringAttribute("N");
				String strValue = node.getStringAttribute("V");
				this.setDoubleValue(strName, new Double(strValue));
			} else if (strTag.equals("STRF")) {
				String strName = node.getStringAttribute("N");
				String strValue = node.getStringAttribute("V");
				this.setStringValue(strName, strValue);
			} else if (strTag.equals("DF")) {
				String strName = node.getStringAttribute("N");
				String strValue = node.getStringAttribute("V");
				this.setDateStringValue(strName, strValue);
			} else if (strTag.equals("TF")) {
				String strName = node.getStringAttribute("N");
				String strValue = node.getStringAttribute("V");
				this.setTimestampStringValue(strName, strValue);
			} else if (strTag.equals("CTOF")) {
				String strName = node.getStringAttribute("N");
				CTO ctoValue = new CTO();
				ctoValue.fromXML((XMLElement) node.getChildren().get(0));
				this.setCTOValue(strName, ctoValue);
			} else if (strTag.equals("OF")) {
				String strName = node.getStringAttribute("N");
				String strValue = node.getStringAttribute("V");
				if (strValue == null || strValue.equals("null")) {
					this.setObjectValue(strName, null);
				} else {
					this.setObjectValue(strName, strValue);
				}
			} else if (strTag.equals("BAF")) {
				String strName = node.getStringAttribute("N");
				String strValue = node.getStringAttribute("V");
				String[] strValueArr = (String[]) null;
				if (strValue.length() == 0) {
					strValueArr = new String[0];
				} else {
					strValueArr = strValue.split(",");
				}
				boolean[] bsValue = new boolean[strValueArr.length];
				for (int i = 0; i < strValueArr.length; i++) {
					if (strValueArr[i].equalsIgnoreCase("false")) {
						bsValue[i] = false;
					} else if (strValueArr[i].equalsIgnoreCase("true")) {
						bsValue[i] = true;
					} else {
						throw new TypeCastException("Parse xml error: unexpected boolean value " + strValueArr[i] + " under " + strTag);
					}
				}
				this.setBooleanArrayValue(strName, bsValue);
			} else if (strTag.equals("BYAF")) {
				String strName = node.getStringAttribute("N");
				String strValue = node.getStringAttribute("V");
				String[] strValueArr = (String[]) null;
				if (strValue.length() == 0) {
					strValueArr = new String[0];
				} else {
					strValueArr = strValue.split(",");
				}
				byte[] bysValue = new byte[strValueArr.length];
				for (int i = 0; i < strValueArr.length; i++) {
					try {
						bysValue[i] = Byte.parseByte(strValueArr[i]);
					} catch (Exception ex) {
						throw new TypeCastException("Parse xml error: unexpected short value " + strValueArr[i] + " under " + strTag);
					}
				}
				this.setByteArrayValue(strName, bysValue);
			} else if (strTag.equals("SAF")) {
				String strName = node.getStringAttribute("N");
				String strValue = node.getStringAttribute("V");
				String[] strValueArr = (String[]) null;
				if (strValue.length() == 0) {
					strValueArr = new String[0];
				} else {
					strValueArr = strValue.split(",");
				}
				short[] shsValue = new short[strValueArr.length];
				for (int i = 0; i < strValueArr.length; i++) {
					try {
						shsValue[i] = Short.parseShort(strValueArr[i]);
					} catch (Exception ex) {
						throw new TypeCastException("Parse xml error: unexpected short value " + strValueArr[i] + " under " + strTag);
					}
				}
				this.setShortArrayValue(strName, shsValue);
			} else if (strTag.equals("NAF")) {
				String strName = node.getStringAttribute("N");
				String strValue = node.getStringAttribute("V");
				String[] strValueArr = (String[]) null;
				if (strValue.length() == 0) {
					strValueArr = new String[0];
				} else {
					strValueArr = strValue.split(",");
				}
				int[] nsValue = new int[strValueArr.length];
				for (int i = 0; i < strValueArr.length; i++) {
					try {
						nsValue[i] = Integer.parseInt(strValueArr[i]);
					} catch (Exception ex) {
						throw new TypeCastException("Parse xml error: unexpected int value " + strValueArr[i] + " under " + strTag);
					}
				}
				this.setIntegerArrayValue(strName, nsValue);
			} else if (strTag.equals("LAF")) {
				String strName = node.getStringAttribute("N");
				String strValue = node.getStringAttribute("V");
				String[] strValueArr = (String[]) null;
				if (strValue.length() == 0) {
					strValueArr = new String[0];
				} else {
					strValueArr = strValue.split(",");
				}
				long[] lsValue = new long[strValueArr.length];
				for (int i = 0; i < strValueArr.length; i++) {
					try {
						lsValue[i] = Long.parseLong(strValueArr[i]);
					} catch (Exception ex) {
						throw new TypeCastException("Parse xml error: unexpected long value " + strValueArr[i] + " under " + strTag);
					}
				}
				this.setLongArrayValue(strName, lsValue);
			} else if (strTag.equals("FAF")) {
				String strName = node.getStringAttribute("N");
				String strValue = node.getStringAttribute("V");
				String[] strValueArr = (String[]) null;
				if (strValue.length() == 0) {
					strValueArr = new String[0];
				} else {
					strValueArr = strValue.split(",");
				}
				float[] fsValue = new float[strValueArr.length];
				for (int i = 0; i < strValueArr.length; i++) {
					try {
						fsValue[i] = Float.parseFloat(strValueArr[i]);
					} catch (Exception ex) {
						throw new TypeCastException("Parse xml error: unexpected float value " + strValueArr[i] + " under " + strTag);
					}
				}
				this.setFloatArrayValue(strName, fsValue);
			} else if (strTag.equals("DBLAF")) {
				String strName = node.getStringAttribute("N");
				String strValue = node.getStringAttribute("V");
				String[] strValueArr = (String[]) null;
				if (strValue.length() == 0) {
					strValueArr = new String[0];
				} else {
					strValueArr = strValue.split(",");
				}
				double[] dblsValue = new double[strValueArr.length];
				for (int i = 0; i < strValueArr.length; i++) {
					try {
						dblsValue[i] = Double.parseDouble(strValueArr[i]);
					} catch (Exception ex) {
						throw new TypeCastException("Parse xml error: unexpected float value " + strValueArr[i] + " under " + strTag);
					}
				}
				this.setDoubleArrayValue(strName, dblsValue);
			} else if (strTag.equals("STRAF")) {
				String strName = node.getStringAttribute("N");
				Iterator<?> enumItems = node.enumerateChildren();

				String[] strsValue = new String[node.countChildren()];
				int nIndex = 0;
				while (enumItems.hasNext()) {
					XMLElement subNode = (XMLElement) enumItems.next();
					String strSubNodeTag = subNode.getName();
					if (!strSubNodeTag.equals("STR")) {
						throw new TypeCastException("Parse xml error: unexpected Tag name " + strSubNodeTag + " under " + strTag);
					}
					strsValue[nIndex] = subNode.getContent();
					nIndex++;
				}
				this.setStringArrayValue(strName, strsValue);
			} else if (strTag.equals("DAF")) {
				String strName = node.getStringAttribute("N");
				String strValue = node.getStringAttribute("V");
				String[] strValueArr = (String[]) null;
				if (strValue.length() == 0) {
					strValueArr = new String[0];
				} else {
					strValueArr = strValue.split(",");
				}
				this.setDateArrayStringValue(strName, strValueArr);
			} else if (strTag.equals("TAF")) {
				String strName = node.getStringAttribute("N");
				String strValue = node.getStringAttribute("V");
				String[] strsValue = (String[]) null;
				if (strValue.length() == 0) {
					strsValue = new String[0];
				} else {
					strsValue = strValue.split(",");
				}
				this.setTimestampArrayStringValue(strName, strsValue);
			} else if (strTag.equals("CTOAF")) {
				String strName = node.getStringAttribute("N");
				Iterator<?> enumItems = node.enumerateChildren();

				CTO[] ctosValue = new CTO[node.countChildren()];
				int nIndex = 0;
				while (enumItems.hasNext()) {
					XMLElement subNode = (XMLElement) enumItems.next();
					String strSubNodeTag = subNode.getName();
					if (!strSubNodeTag.equals("CTO")) {
						throw new TypeCastException("Parse xml error: unexpected Tag name " + strSubNodeTag + " under " + strTag);
					}
					CTO ctoValue = new CTO();
					ctoValue.fromXML(subNode);
					ctosValue[nIndex] = ctoValue;
					nIndex++;
				}
				this.setCTOArrayValue(strName, ctosValue);
			} else {
				throw new RuntimeException("Parse xml error: unexpected Tag name [" + strTag + "]");
			}
		}
	}

	public static CTO fromXML(String strXML) {
		XMLElement xmlNode = new XMLElement();
		xmlNode.parseString(strXML);

		CTO cto = new CTO();
		cto.fromXML(xmlNode);

		return cto;
	}

	public static void xmlToCTO(String strXML, CTO CTOOutPut) {
		XMLElement xmlNode = new XMLElement();
		xmlNode.parseString(strXML);
		CTOOutPut.fromXML(xmlNode);
	}

	public String toXML() {
		StringBuilder strbXML = new StringBuilder();
		strbXML.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		toXMLWithIndent(null, strbXML);

		String strXML = strbXML.toString();

		return strXML;
	}

	public String toXML(StringBuilder strbXML) {
		strbXML.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		toXMLWithIndent(null, strbXML);

		String strXML = strbXML.toString();

		return strXML;
	}

	protected void outputField(String strFieldId, CTOItem item, String strIndent, StringBuilder strbXML) {
		if (strIndent != null) {
			strbXML.append(strIndent);
		}
		if (item.getClassType().equals(Boolean.class)) {
			strbXML.append("<BF N=\"").append(strFieldId).append("\"");
			strbXML.append(" V=\"").append(item.getObjValue()).append("\"/>");
			return;
		} else if (item.getClassType().equals(Byte.class)) {
			strbXML.append("<BYF N=\"").append(strFieldId).append("\"");
			strbXML.append(" V=\"").append(item.getObjValue()).append("\"/>");
			return;
		} else if (item.getClassType().equals(Short.class)) {
			strbXML.append("<SF N=\"").append(strFieldId).append("\"");
			strbXML.append(" V=\"").append(item.getObjValue()).append("\"/>");
			return;
		} else if (item.getClassType().equals(Integer.class)) {
			strbXML.append("<NF N=\"").append(strFieldId).append("\"");
			strbXML.append(" V=\"").append(item.getObjValue()).append("\"/>");
			return;
		} else if (item.getClassType().equals(Long.class)) {
			strbXML.append("<LF N=\"").append(strFieldId).append("\"");
			strbXML.append(" V=\"").append(item.getObjValue()).append("\"/>");
			return;
		} else if (item.getClassType().equals(Float.class)) {
			strbXML.append("<FF N=\"").append(strFieldId).append("\"");
			strbXML.append(" V=\"").append(item.getObjValue()).append("\"/>");
			return;
		} else if (item.getClassType().equals(Double.class)) {
			strbXML.append("<DBLF N=\"").append(strFieldId).append("\"");
			strbXML.append(" V=\"").append(item.getObjValue()).append("\"/>");
			return;
		} else if (item.getClassType().equals(String.class)) {
			strbXML.append("<STRF N=\"").append(strFieldId).append("\"");
			strbXML.append(" V=\"").append(item.getObjValue()).append("\"/>");
			return;
		} else if (item.getClassType().equals(Date.class)) {
			strbXML.append("<DF N=\"").append(strFieldId).append("\"");
			strbXML.append(" V=\"").append(this.getDateStringValue(strFieldId)).append("\"/>");
			return;
		} else if (item.getClassType().equals(Timestamp.class)) {
			strbXML.append("<TF N=\"").append(strFieldId).append("\"");
			strbXML.append(" V=\"").append(this.getTimestampStringValue(strFieldId)).append("\"/>");
			return;
		} else if (item.getClassType().equals(Object.class)) {
			strbXML.append("<OF N=\"").append(strFieldId).append("\"");
			strbXML.append(" V=\"").append(this.getObjectValue(strFieldId)).append("\"/>");
			return;
		} else if (item.getClassType().equals(CTO.class)) {
			if (strIndent != null) {
				strbXML.append("<CTOF N=\"").append(strFieldId).append("\">\r\n");
			} else {
				strbXML.append("<CTOF N=\"").append(strFieldId).append("\">");
			}
			CTO CTO = this.getCTOValue(strFieldId);
			if (strIndent != null) {
				CTO.toXMLWithIndent(strIndent + "\t", strbXML);
			} else {
				CTO.toXMLWithIndent(null, strbXML);
			}
			if (strIndent != null) {
				strbXML.append(strIndent);
			}
			strbXML.append("</CTOF>");
			return;
		} else if (item.getClassType().equals(boolean[].class)) {
			strbXML.append("<BAF N=\"").append(strFieldId).append("\"");
			strbXML.append(" V=\"");
			boolean[] bsValue = this.getBooleanArrayValue(strFieldId);
			for (int i = 0; i < bsValue.length; i++) {
				if (i > 0) {
					strbXML.append(",");
				}
				strbXML.append(bsValue[i]);
			}
			strbXML.append("\"/>");
			return;
		} else if (item.getClassType().equals(byte[].class)) {
			strbXML.append("<BYAF N=\"").append(strFieldId).append("\"");
			strbXML.append(" V=\"");
			byte[] bsValue = this.getByteArrayValue(strFieldId);
			for (int i = 0; i < bsValue.length; i++) {
				if (i > 0) {
					strbXML.append(",");
				}
				strbXML.append(bsValue[i]);
			}
			strbXML.append("\"/>");
			return;
		} else if (item.getClassType().equals(short[].class)) {
			strbXML.append("<SAF N=\"").append(strFieldId).append("\"");
			strbXML.append(" V=\"");
			short[] bsValue = this.getShortArrayValue(strFieldId);
			for (int i = 0; i < bsValue.length; i++) {
				if (i > 0) {
					strbXML.append(",");
				}
				strbXML.append(bsValue[i]);
			}
			strbXML.append("\"/>");
			return;
		} else if (item.getClassType().equals(int[].class)) {
			strbXML.append("<NAF N=\"").append(strFieldId).append("\"");
			strbXML.append(" V=\"");
			int[] bsValue = this.getIntegerArrayValue(strFieldId);
			for (int i = 0; i < bsValue.length; i++) {
				if (i > 0) {
					strbXML.append(",");
				}
				strbXML.append(bsValue[i]);
			}
			strbXML.append("\"/>");
			return;
		} else if (item.getClassType().equals(long[].class)) {
			strbXML.append("<LAF N=\"").append(strFieldId).append("\"");
			strbXML.append(" V=\"");
			long[] bsValue = this.getLongArrayValue(strFieldId);
			for (int i = 0; i < bsValue.length; i++) {
				if (i > 0) {
					strbXML.append(",");
				}
				strbXML.append(bsValue[i]);
			}
			strbXML.append("\"/>");
			return;
		} else if (item.getClassType().equals(float[].class)) {
			strbXML.append("<FAF N=\"").append(strFieldId).append("\"");
			strbXML.append(" V=\"");
			float[] bsValue = this.getFloatArrayValue(strFieldId);
			for (int i = 0; i < bsValue.length; i++) {
				if (i > 0) {
					strbXML.append(",");
				}
				strbXML.append(bsValue[i]);
			}
			strbXML.append("\"/>");
			return;
		} else if (item.getClassType().equals(double[].class)) {
			strbXML.append("<DBLAF N=\"").append(strFieldId).append("\"");
			strbXML.append(" V=\"");
			double[] bsValue = this.getDoubleArrayValue(strFieldId);
			for (int i = 0; i < bsValue.length; i++) {
				if (i > 0) {
					strbXML.append(",");
				}
				strbXML.append(bsValue[i]);
			}
			strbXML.append("\"/>");
			return;
		} else if (item.getClassType().equals(String[].class)) {
			strbXML.append("<STRAF N=\"").append(strFieldId).append("\">");
			String[] strsValue = this.getStringArrayValue(strFieldId);
			if (strIndent == null) {
				for (int i = 0; i < strsValue.length; i++) {
					strbXML.append("<STR>").append(Function.FormatTextForXML(strsValue[i])).append("</STR>");
				}
			} else {
				strbXML.append("\r\n");
				for (int i = 0; i < strsValue.length; i++) {
					strbXML.append(strIndent).append('\t').append("<STR>");
					strbXML.append(Function.FormatTextForXML(strsValue[i]));
					strbXML.append("</STR>").append("\r\n");
				}
				strbXML.append(strIndent);
			}
			strbXML.append("</STRAF>");
			return;
		} else if (item.getClassType().equals(Date[].class)) {
			strbXML.append("<DAF N=\"").append(strFieldId).append("\"");
			strbXML.append(" V=\"");
			String[] dtValues = this.getDateArrayStringValue(strFieldId);
			for (int i = 0; i < dtValues.length; i++) {
				if (i > 0) {
					strbXML.append(",");
				}
				strbXML.append(dtValues[i]);
			}
			strbXML.append("\"/>");
			return;
		} else if (item.getClassType().equals(Timestamp[].class)) {
			strbXML.append("<TAF N=\"").append(strFieldId).append("\"");
			strbXML.append(" V=\"");
			String[] dtValues = this.getTimestampArrayStringValue(strFieldId);
			for (int i = 0; i < dtValues.length; i++) {
				if (i > 0) {
					strbXML.append(",");
				}
				strbXML.append(dtValues[i]);
			}
			strbXML.append("\"/>");
			return;
		} else if (item.getClassType().equals(CTO[].class)) {
			strbXML.append("<CTOAF N=\"").append(strFieldId).append("\">");
			if (strIndent != null) {
				strbXML.append("\r\n");
			}
			CTO[] ctosValue = this.getCTOArrayValue(strFieldId);
			for (int i = 0; i < ctosValue.length; i++) {
				if (strIndent != null) {
					ctosValue[i].toXMLWithIndent(strIndent + '\t', strbXML);
				} else {
					ctosValue[i].toXMLWithIndent(null, strbXML);
				}
			}
			if (strIndent != null) {
				strbXML.append(strIndent).append("</CTOAF>");
			} else {
				strbXML.append("</CTOAF>");
			}
			return;
		}

		if (strIndent != null) {
			strbXML.append("\r\n");
		}
	}

	protected void toXMLWithIndent(String strIndent, StringBuilder strbXML) {
		if (strIndent != null) {
			strbXML.append(strIndent).append("<CTO>\r\n");
		} else {
			strbXML.append("<CTO>");
		}

		Iterator<String> iterator = this.hmItem.keySet().iterator();
		for (; iterator.hasNext();) {
			String strFieldId = iterator.next();
			CTOItem item = this.hmItem.get(strFieldId);

			if (strIndent != null) {
				outputField(strFieldId, item, strIndent + '\t', strbXML);
			} else {
				outputField(strFieldId, item, null, strbXML);
			}
		}
		if (strIndent != null) {
			strbXML.append(strIndent).append("</CTO>\r\n");
		} else {
			strbXML.append("</CTO>");
		}
	}

	public String toXMLWithIndent() {
		StringBuilder strbXML = new StringBuilder();
		strbXML.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n");
		toXMLWithIndent("", strbXML);

		String strXML = strbXML.toString();

		return strXML;
	}

	public boolean getBooleanValue(String strFieldId) {
		CTOItem item = this.hmItem.get(strFieldId);
		if (item == null) {
			return false;
		}
		Object value = item.getObjValue();
		if (value == null) {
			return false;
		}
		if (item.getClassType().equals(Boolean.class)) {
			return (Boolean) item.getObjValue();
		} else if (item.getClassType().equals(String.class)) {
			return Boolean.valueOf((String) item.getObjValue());
		}
		throw new TypeCastException("不能将" + item.getClassType() + "转换成Boolean类型");
	}

	public byte getByteValue(String strFieldId) {
		CTOItem item = this.hmItem.get(strFieldId);
		if (item == null) {
			return 0;
		}
		Object value = item.getObjValue();
		if (value == null) {
			return 0;
		}
		if (item.getClassType().equals(Byte.class)) {
			return (Byte) item.getObjValue();
		} else if (item.getClassType().equals(String.class)) {
			return Byte.valueOf((String) item.getObjValue());
		}
		throw new TypeCastException("不能将" + item.getClassType() + "转换成Byte类型");
	}

	public short getShortValue(String strFieldId) {
		CTOItem item = this.hmItem.get(strFieldId);
		if (item == null) {
			return 0;
		}
		Object value = item.getObjValue();
		if (value == null) {
			return 0;
		}
		if (item.getClassType().equals(Short.class)) {
			return (Short) item.getObjValue();
		} else if (item.getClassType().equals(String.class)) {
			return Short.valueOf((String) item.getObjValue());
		}
		throw new TypeCastException("不能将" + item.getClassType() + "转换成Short类型");
	}

	public int getIntegerValue(String strFieldId) {
		CTOItem item = this.hmItem.get(strFieldId);
		if (item == null) {
			return 0;
		}
		Object value = item.getObjValue();
		if (value == null) {
			return 0;
		}
		if (item.getClassType().equals(Integer.class)) {
			return (Integer) item.getObjValue();
		} else if (item.getClassType().equals(String.class)) {
			return Integer.valueOf((String) item.getObjValue());
		}
		throw new TypeCastException("不能将" + item.getClassType() + "转换成Integer类型");
	}

	public long getLongValue(String strFieldId) {
		CTOItem item = this.hmItem.get(strFieldId);
		if (item == null) {
			return 0;
		}
		Object value = item.getObjValue();
		if (value == null) {
			return 0;
		}
		if (item.getClassType().equals(Long.class)) {
			return (Long) item.getObjValue();
		} else if (item.getClassType().equals(String.class)) {
			return Long.valueOf((String) item.getObjValue());
		}
		throw new TypeCastException("不能将" + item.getClassType() + "转换成Long类型");
	}

	public float getFloatValue(String strFieldId) {
		CTOItem item = this.hmItem.get(strFieldId);
		if (item == null) {
			return 0;
		}
		Object value = item.getObjValue();
		if (value == null) {
			return 0;
		}
		if (item.getClassType().equals(Float.class)) {
			return (Float) item.getObjValue();
		} else if (item.getClassType().equals(String.class)) {
			return Float.valueOf((String) item.getObjValue());
		}
		throw new TypeCastException("不能将" + item.getClassType() + "转换成Float类型");
	}

	public double getDoubleValue(String strFieldId) {
		CTOItem item = this.hmItem.get(strFieldId);
		if (item == null) {
			return 0;
		}
		Object value = item.getObjValue();
		if (value == null) {
			return 0;
		}
		if (item.getClassType().equals(Double.class)) {
			return (Double) item.getObjValue();
		} else if (item.getClassType().equals(String.class)) {
			return Double.valueOf((String) item.getObjValue());
		}
		throw new TypeCastException("不能将" + item.getClassType() + "转换成Double类型");
	}

	public String getStringValue(String strFieldId) {
		CTOItem item = this.hmItem.get(strFieldId);
		if (item == null) {
			return null;
		}
		Object value = item.getObjValue();
		if (value == null) {
			return null;
		}
		if (item.getClassType().equals(String.class)) {
			return ((String) item.getObjValue()).trim();
		} else if (item.getClassType().equals(Integer.class)) {
			return String.valueOf((Integer) item.getObjValue());
		} else if (item.getClassType().equals(Long.class)) {
			return String.valueOf((Long) item.getObjValue());
		} else if (item.getClassType().equals(Double.class)) {
			return String.valueOf((Double) item.getObjValue());
		} else if (item.getClassType().equals(Float.class)) {
			return String.valueOf((Float) item.getObjValue());
		} else if (item.getClassType().equals(Short.class)) {
			return String.valueOf((Short) item.getObjValue());
		} else if (item.getClassType().equals(Boolean.class)) {
			return String.valueOf((Boolean) item.getObjValue());
		} else if (item.getClassType().equals(Byte.class)) {
			return String.valueOf((Byte) item.getObjValue());
		}
		throw new TypeCastException("不能将" + item.getClassType() + "转换成String类型");
	}

	public Date getDateValue(String strFieldId) {
		CTOItem item = this.hmItem.get(strFieldId);
		if (item == null) {
			return null;
		}
		Object value = item.getObjValue();
		if (value == null) {
			return null;
		}
		if (item.getClassType().equals(Date.class)) {
			return (Date) item.getObjValue();
		}
		throw new TypeCastException("不能将" + item.getClassType() + "转换成Date类型");
	}

	public String getDateStringValue(String strFieldId) {
		CTOItem item = this.hmItem.get(strFieldId);
		if (item == null) {
			return null;
		}
		Object value = item.getObjValue();
		if (value == null) {
			return null;
		}
		if (item.getClassType().equals(Date.class)) {
			Date date = (Date) value;
			SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
			return format.format(date);
		}
		throw new TypeCastException("不能将" + item.getClassType() + "转换成Date类型");
	}

	public Timestamp getTimestampValue(String strFieldId) {
		CTOItem item = this.hmItem.get(strFieldId);
		if (item == null) {
			return null;
		}
		Object value = item.getObjValue();
		if (value == null) {
			return null;
		}
		if (item.getClassType().equals(Timestamp.class)) {
			return (Timestamp) item.getObjValue();
		}
		throw new TypeCastException("不能将" + item.getClassType() + "转换成Timestamp类型");
	}

	public String getTimestampStringValue(String strFieldId) {
		CTOItem item = this.hmItem.get(strFieldId);
		if (item == null) {
			return null;
		}
		Object value = item.getObjValue();
		if (value == null) {
			return null;
		}
		if (item.getClassType().equals(Timestamp.class)) {
			Timestamp time = (Timestamp) value;
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return format.format(time);
		}
		throw new TypeCastException("不能将" + item.getClassType() + "转换成Timestamp类型");
	}

	public CTO getCTOValue(String strFieldId) {
		CTOItem item = this.hmItem.get(strFieldId);
		if (item == null) {
			return null;
		}
		Object value = item.getObjValue();
		if (value == null) {
			return null;
		}
		if (item.getClassType().equals(CTO.class)) {
			return (CTO) item.getObjValue();
		}
		throw new TypeCastException("不能将" + item.getClassType() + "转换成CTO类型");
	}

	public boolean[] getBooleanArrayValue(String strFieldId) {
		CTOItem item = this.hmItem.get(strFieldId);
		if (item == null) {
			return null;
		}
		Object value = item.getObjValue();
		if (value == null) {
			return null;
		}
		if (item.getClassType().equals(boolean[].class)) {
			return (boolean[]) item.getObjValue();
		}
		throw new TypeCastException("不能将" + item.getClassType() + "转换成boolean[]类型");
	}

	public byte[] getByteArrayValue(String strFieldId) {
		CTOItem item = this.hmItem.get(strFieldId);
		if (item == null) {
			return null;
		}
		Object value = item.getObjValue();
		if (value == null) {
			return null;
		}
		if (item.getClassType().equals(byte[].class)) {
			return (byte[]) item.getObjValue();
		}
		throw new TypeCastException("不能将" + item.getClassType() + "转换成byte[]类型");
	}

	public short[] getShortArrayValue(String strFieldId) {
		CTOItem item = this.hmItem.get(strFieldId);
		if (item == null) {
			return null;
		}
		Object value = item.getObjValue();
		if (value == null) {
			return null;
		}
		if (item.getClassType().equals(short[].class)) {
			return (short[]) item.getObjValue();
		}
		throw new TypeCastException("不能将" + item.getClassType() + "转换成short[]类型");
	}

	public int[] getIntegerArrayValue(String strFieldId) {
		CTOItem item = this.hmItem.get(strFieldId);
		if (item == null) {
			return null;
		}
		Object value = item.getObjValue();
		if (value == null) {
			return null;
		}
		if (item.getClassType().equals(int[].class)) {
			return (int[]) item.getObjValue();
		}
		throw new TypeCastException("不能将" + item.getClassType() + "转换成int[]类型");
	}

	public long[] getLongArrayValue(String strFieldId) {
		CTOItem item = this.hmItem.get(strFieldId);
		if (item == null) {
			return null;
		}
		Object value = item.getObjValue();
		if (value == null) {
			return null;
		}
		if (item.getClassType().equals(long[].class)) {
			return (long[]) item.getObjValue();
		}
		throw new TypeCastException("不能将" + item.getClassType() + "转换成long[]类型");
	}

	public float[] getFloatArrayValue(String strFieldId) {
		CTOItem item = this.hmItem.get(strFieldId);
		if (item == null) {
			return null;
		}
		Object value = item.getObjValue();
		if (value == null) {
			return null;
		}
		if (item.getClassType().equals(float[].class)) {
			return (float[]) item.getObjValue();
		}
		throw new TypeCastException("不能将" + item.getClassType() + "转换成float[]类型");
	}

	public double[] getDoubleArrayValue(String strFieldId) {
		CTOItem item = this.hmItem.get(strFieldId);
		if (item == null) {
			return null;
		}
		Object value = item.getObjValue();
		if (value == null) {
			return null;
		}
		if (item.getClassType().equals(double[].class)) {
			return (double[]) item.getObjValue();
		}
		throw new TypeCastException("不能将" + item.getClassType() + "转换成double[]类型");
	}

	public String[] getStringArrayValue(String strFieldId) {
		CTOItem item = this.hmItem.get(strFieldId);
		if (item == null) {
			return null;
		}
		Object value = item.getObjValue();
		if (value == null) {
			return null;
		}
		if (item.getClassType().equals(String[].class)) {
			return (String[]) item.getObjValue();
		}
		throw new TypeCastException("不能将" + item.getClassType() + "转换成String[]类型");
	}

	public Date[] getDateArrayValue(String strFieldId) {
		CTOItem item = this.hmItem.get(strFieldId);
		if (item == null) {
			return null;
		}
		Object value = item.getObjValue();
		if (value == null) {
			return null;
		}
		if (item.getClassType().equals(Date[].class)) {
			return (Date[]) item.getObjValue();
		}
		throw new TypeCastException("不能将" + item.getClassType() + "转换成Date[]类型");
	}

	public String[] getDateArrayStringValue(String strFieldId) {
		CTOItem item = this.hmItem.get(strFieldId);
		if (item == null) {
			return null;
		}
		Object value = item.getObjValue();
		if (value == null) {
			return null;
		}
		if (item.getClassType().equals(Date[].class)) {
			Date[] dates = (Date[]) value;
			String[] datestrs = new String[dates.length];
			for (int i = 0; i < dates.length; i++) {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
				datestrs[i] = format.format(dates[i]);
			}
			return datestrs;
		}
		throw new TypeCastException("不能将" + item.getClassType() + "转换成Date[]类型");
	}

	public Timestamp[] getTimestampArrayValue(String strFieldId) {
		CTOItem item = this.hmItem.get(strFieldId);
		if (item == null) {
			return null;
		}
		Object value = item.getObjValue();
		if (value == null) {
			return null;
		}
		if (item.getClassType().equals(Timestamp[].class)) {
			return (Timestamp[]) item.getObjValue();
		}
		throw new TypeCastException("不能将" + item.getClassType() + "转换成Timestamp[]类型");
	}

	public String[] getTimestampArrayStringValue(String strFieldId) {
		CTOItem item = this.hmItem.get(strFieldId);
		if (item == null) {
			return null;
		}
		Object value = item.getObjValue();
		if (value == null) {
			return null;
		}
		if (item.getClassType().equals(Timestamp[].class)) {
			Timestamp[] times = (Timestamp[]) value;
			String[] datestrs = new String[times.length];
			for (int i = 0; i < times.length; i++) {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
				datestrs[i] = format.format(times[i]);
			}
			return datestrs;
		}
		throw new TypeCastException("不能将" + item.getClassType() + "转换成Timestamp[]类型");
	}

	public CTO[] getCTOArrayValue(String strFieldId) {
		CTOItem item = this.hmItem.get(strFieldId);
		if (item == null) {
			return null;
		}
		Object value = item.getObjValue();
		if (value == null) {
			return null;
		}
		if (item.getClassType().equals(CTO[].class)) {
			return (CTO[]) item.getObjValue();
		}
		throw new TypeCastException("不能将" + item.getClassType() + "转换成CTO[]类型");
	}

	public void setBooleanValue(String strFieldId, boolean bValue) {
		CTOItem item = new CTOItem(bValue, Boolean.class);
		this.hmItem.put(strFieldId, item);
	}

	public void setByteValue(String strFieldId, byte byValue) {
		CTOItem item = new CTOItem(byValue, Byte.class);
		this.hmItem.put(strFieldId, item);
	}

	public void setShortValue(String strFieldId, short shValue) {
		CTOItem item = new CTOItem(shValue, Short.class);
		this.hmItem.put(strFieldId, item);
	}

	public void setIntegerValue(String strFieldId, int nValue) {
		CTOItem item = new CTOItem(nValue, Integer.class);
		this.hmItem.put(strFieldId, item);
	}

	public void setLongValue(String strFieldId, long lValue) {
		CTOItem item = new CTOItem(lValue, Long.class);
		this.hmItem.put(strFieldId, item);
	}

	public void setFloatValue(String strFieldId, float fValue) {
		CTOItem item = new CTOItem(fValue, Float.class);
		this.hmItem.put(strFieldId, item);
	}

	public void setDoubleValue(String strFieldId, double dValue) {
		CTOItem item = new CTOItem(dValue, Double.class);
		this.hmItem.put(strFieldId, item);
	}

	public void setStringValue(String strFieldId, String strValue) {
		CTOItem item = new CTOItem(strValue, String.class);
		this.hmItem.put(strFieldId, item);
	}

	public void setDateValue(String strFieldId, Date dtValue) {
		CTOItem item = new CTOItem(dtValue, Date.class);
		this.hmItem.put(strFieldId, item);
	}

	public void setDateStringValue(String strFieldId, String dtValue) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date _dtValue = format.parse(dtValue);
			CTOItem item = new CTOItem(_dtValue, Date.class);
			this.hmItem.put(strFieldId, item);
		} catch (Exception e) {
			throw new TypeCastException("解析" + dtValue + "出错," + e.getLocalizedMessage());
		}

	}

	public void setTimestampStringValue(String strFieldId, String tmValue) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			Date dtValue = format.parse(tmValue);
			Timestamp _tmValue = new Timestamp(dtValue.getTime());
			CTOItem item = new CTOItem(_tmValue, Date.class);
			this.hmItem.put(strFieldId, item);
		} catch (Exception e) {
			throw new TypeCastException("解析" + tmValue + "出错," + e.getLocalizedMessage());
		}
	}

	public void setTimestampValue(String strFieldId, Timestamp tmValue) {
		CTOItem item = new CTOItem(tmValue, Timestamp.class);
		this.hmItem.put(strFieldId, item);
	}

	public void setCTOValue(String strFieldId, CTO CTOValue) {
		CTOItem item = new CTOItem(CTOValue, CTO.class);
		this.hmItem.put(strFieldId, item);
	}

	public void setBooleanArrayValue(String strFieldId, boolean[] bsValue) {
		CTOItem item = new CTOItem(bsValue, boolean[].class);
		this.hmItem.put(strFieldId, item);
	}

	public void setByteArrayValue(String strFieldId, byte[] bysValue) {
		CTOItem item = new CTOItem(bysValue, byte[].class);
		this.hmItem.put(strFieldId, item);
	}

	public void setShortArrayValue(String strFieldId, short[] shsValue) {
		CTOItem item = new CTOItem(shsValue, short[].class);
		this.hmItem.put(strFieldId, item);
	}

	public void setIntegerArrayValue(String strFieldId, int[] nsValue) {
		CTOItem item = new CTOItem(nsValue, int[].class);
		this.hmItem.put(strFieldId, item);
	}

	public void setFloatArrayValue(String strFieldId, float[] fsValue) {
		CTOItem item = new CTOItem(fsValue, float[].class);
		this.hmItem.put(strFieldId, item);
	}

	public void setDoubleArrayValue(String strFieldId, double[] dblsValue) {
		CTOItem item = new CTOItem(dblsValue, double[].class);
		this.hmItem.put(strFieldId, item);
	}

	public void setLongArrayValue(String strFieldId, long[] lsValue) {
		CTOItem item = new CTOItem(lsValue, long[].class);
		this.hmItem.put(strFieldId, item);
	}

	public void setStringArrayValue(String strFieldId, String[] strsValue) {
		CTOItem item = new CTOItem(strsValue, String[].class);
		this.hmItem.put(strFieldId, item);
	}

	public void setDateArrayStringValue(String strFieldId, String[] dtValues) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date[] _dtValues = new Date[dtValues.length];
			for (int i = 0; i < dtValues.length; i++) {
				_dtValues[i] = format.parse(dtValues[i]);
			}
			CTOItem item = new CTOItem(_dtValues, Date[].class);
			this.hmItem.put(strFieldId, item);
		} catch (Exception e) {
			throw new TypeCastException("解析" + dtValues + "出错," + e.getLocalizedMessage());
		}
	}

	public void setDateArrayValue(String strFieldId, Date[] dtsValue) {
		CTOItem item = new CTOItem(dtsValue, Date[].class);
		this.hmItem.put(strFieldId, item);
	}

	public void setTimestampArrayStringValue(String strFieldId, String[] tmValues) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Timestamp[] _tmValues = new Timestamp[tmValues.length];
			for (int i = 0; i < _tmValues.length; i++) {
				_tmValues[i] = new Timestamp(format.parse(tmValues[i]).getTime());
			}
			CTOItem item = new CTOItem(_tmValues, Timestamp[].class);
			this.hmItem.put(strFieldId, item);
		} catch (Exception e) {
			throw new TypeCastException("解析" + tmValues + "出错," + e.getLocalizedMessage());
		}
	}

	public void setTimestampArrayValue(String strFieldId, Timestamp[] tmsValue) {
		CTOItem item = new CTOItem(tmsValue, Timestamp[].class);
		this.hmItem.put(strFieldId, item);
	}

	public void setCTOArrayValue(String strFieldId, CTO[] CTOsValue) {
		CTOItem item = new CTOItem(CTOsValue, CTO[].class);
		this.hmItem.put(strFieldId, item);
	}

	public boolean exists(String strFieldId) {
		Iterator<String> iterator = hmItem.keySet().iterator();
		while (iterator.hasNext()) {
			String field = iterator.next();
			if (field.equals(strFieldId)) {
				return true;
			}
		}
		return false;
	}

	public boolean isEmpty() {
		return this.hmItem.size() == 0;
	}

	public boolean isEmpty(String strFieldId) {
		CTOItem item = null;
		try {
			item = this.hmItem.get(strFieldId);
		} catch (Exception e) {
			return true;
		}
		if (item == null || item.getObjValue() == null) {
			return true;
		}
		return false;
	}

	public void copyFrom(CTO CTOSource) {
		XMLElement xmlNode = new XMLElement();
		xmlNode.parseString(CTOSource.toXML());

		fromXML(xmlNode);
	}

	public void copyFrom(String strCTOXML) {
		XMLElement xmlNode = new XMLElement();
		xmlNode.parseString(strCTOXML);
		fromXML(xmlNode);
	}

	public CTO clone() {
		String strXML = toXML();
		return fromXML(strXML);
	}

	public Object getObjectValue(String strFieldId) {
		CTOItem item = this.hmItem.get(strFieldId);
		if (item != null) {
			return item.getObjValue();
		}
		return null;
	}

	public CTOItem getCTOItem(String strFieldId) {
		return this.hmItem.get(strFieldId);
	}

	public void setObjectValue(String strFieldId, Object object) {
		if (object instanceof Byte) {
			setByteValue(strFieldId, ((Byte) object).byteValue());
			return;
		} else if (object instanceof byte[]) {
			setByteArrayValue(strFieldId, ((byte[]) object));
			return;
		} else if (object instanceof byte[]) {
			setByteArrayValue(strFieldId, ((byte[]) object));
			return;
		} else if (object instanceof Short) {
			setShortValue(strFieldId, ((Short) object).shortValue());
			return;
		} else if (object instanceof short[]) {
			setShortArrayValue(strFieldId, ((short[]) object));
			return;
		} else if (object instanceof Integer) {
			setIntegerValue(strFieldId, ((Integer) object).intValue());
			return;
		} else if (object instanceof int[]) {
			setIntegerArrayValue(strFieldId, ((int[]) object));
			return;
		} else if (object instanceof Long) {
			setLongValue(strFieldId, ((Long) object).longValue());
			return;
		} else if (object instanceof long[]) {
			setLongArrayValue(strFieldId, ((long[]) object));
			return;
		} else if (object instanceof Float) {
			setFloatValue(strFieldId, ((Float) object).floatValue());
			return;
		} else if (object instanceof float[]) {
			setFloatArrayValue(strFieldId, ((float[]) object));
			return;
		} else if (object instanceof Double) {
			setDoubleValue(strFieldId, ((Double) object).doubleValue());
			return;
		} else if (object instanceof double[]) {
			setDoubleArrayValue(strFieldId, ((double[]) object));
			return;
		} else if (object instanceof String) {
			setStringValue(strFieldId, ((String) object));
			return;
		} else if (object instanceof String[]) {
			setStringArrayValue(strFieldId, ((String[]) object));
			return;
		} else if (object instanceof Date) {
			setDateValue(strFieldId, ((Date) object));
			return;
		} else if (object instanceof Date[]) {
			setDateArrayValue(strFieldId, ((Date[]) object));
			return;
		} else if (object instanceof Timestamp) {
			setTimestampValue(strFieldId, ((Timestamp) object));
			return;
		} else if (object instanceof Timestamp[]) {
			setTimestampArrayValue(strFieldId, ((Timestamp[]) object));
			return;
		} else if (object instanceof CTO) {
			setCTOValue(strFieldId, ((CTO) object));
			return;
		} else if (object instanceof CTO[]) {
			setCTOArrayValue(strFieldId, ((CTO[]) object));
			return;
		} else {
			this.hmItem.put(strFieldId, new CTOItem(object, Object.class));
		}
	}

	public void remove(String key) {
		if (hmItem.containsKey(key)) {
			this.hmItem.remove(key);
		}
	}

	public Set<String> keys() {
		return this.hmItem.keySet();
	}

	public CTO() {
	}

	public String toString() {
		return toJSONString();
	}

	public String toJSONString() {
		try {
			return this.toJSONObject().toString();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}

	public JSONObject toJSONObject() throws JSONException {
		JSONObject jsonObject = new JSONObject();
		Iterator<String> iterator = this.hmItem.keySet().iterator();
		while (iterator.hasNext()) {
			String strKey = iterator.next();
			CTOItem item = this.hmItem.get(strKey);
			if (item == null) {
				jsonObject.put(strKey, "");
				continue;
			}
			if (item.getClassType().equals(Boolean.class)) {
				jsonObject.put(strKey, this.getBooleanValue(strKey));
				continue;
			} else if (item.getClassType().equals(Byte.class)) {
				jsonObject.put(strKey, this.getByteValue(strKey));
				continue;
			} else if (item.getClassType().equals(Short.class)) {
				jsonObject.put(strKey, this.getShortValue(strKey));
				continue;
			} else if (item.getClassType().equals(Integer.class)) {
				jsonObject.put(strKey, this.getIntegerValue(strKey));
				continue;
			} else if (item.getClassType().equals(Long.class)) {
				jsonObject.put(strKey, this.getLongValue(strKey));
				continue;
			} else if (item.getClassType().equals(Float.class)) {
				jsonObject.put(strKey, this.getFloatValue(strKey));
				continue;
			} else if (item.getClassType().equals(Double.class)) {
				jsonObject.put(strKey, this.getDoubleValue(strKey));
				continue;
			} else if (item.getClassType().equals(String.class)) {
				jsonObject.put(strKey, this.getStringValue(strKey));
				continue;
			} else if (item.getClassType().equals(Date.class)) {
				jsonObject.put(strKey, this.getDateStringValue(strKey));
				continue;
			} else if (item.getClassType().equals(Timestamp.class)) {
				jsonObject.put(strKey, this.getTimestampStringValue(strKey));
				continue;
			} else if (item.getClassType().equals(CTO.class)) {
				CTO cto = this.getCTOValue(strKey);
				jsonObject.put(strKey, cto.toJSONObject());
				continue;
			} else if (item.getClassType().equals(boolean[].class)) {
				boolean[] blValue = this.getBooleanArrayValue(strKey);
				jsonObject.put(strKey, blValue);
				continue;
			} else if (item.getClassType().equals(byte[].class)) {
				byte[] byValue = this.getByteArrayValue(strKey);
				jsonObject.put(strKey, byValue);
				continue;
			} else if (item.getClassType().equals(short[].class)) {
				short[] shValue = this.getShortArrayValue(strKey);
				jsonObject.put(strKey, shValue);
				continue;
			} else if (item.getClassType().equals(int[].class)) {
				int[] nValue = this.getIntegerArrayValue(strKey);
				jsonObject.put(strKey, nValue);
				continue;
			} else if (item.getClassType().equals(long[].class)) {
				long[] lValue = this.getLongArrayValue(strKey);
				jsonObject.put(strKey, lValue);
				continue;
			} else if (item.getClassType().equals(float[].class)) {
				float[] flValue = this.getFloatArrayValue(strKey);
				jsonObject.put(strKey, flValue);
				continue;
			} else if (item.getClassType().equals(double[].class)) {
				double[] dbValue = this.getDoubleArrayValue(strKey);
				jsonObject.put(strKey, dbValue);
				continue;
			} else if (item.getClassType().equals(String[].class)) {
				String[] strsValue = this.getStringArrayValue(strKey);
				jsonObject.put(strKey, strsValue);
				continue;
			} else if (item.getClassType().equals(Date[].class)) {
				String[] dtValues = this.getDateArrayStringValue(strKey);
				jsonObject.put(strKey, dtValues);
				continue;
			} else if (item.getClassType().equals(Timestamp[].class)) {
				String[] dtValues = this.getTimestampArrayStringValue(strKey);
				jsonObject.put(strKey, dtValues);
				continue;
			} else if (item.getClassType().equals(CTO[].class)) {
				JSONArray jsonArray = new JSONArray();
				CTO[] ctosValue = this.getCTOArrayValue(strKey);
				for (int i = 0; i < ctosValue.length; i++) {
					jsonArray.put(ctosValue[i].toJSONObject());
				}
				jsonObject.put(strKey, jsonArray);
				continue;
			} else {
				Object objvalue = this.getObjectValue(strKey);
				if (objvalue == null) {
					jsonObject.put(strKey, "");
				} else {
					jsonObject.put(strKey, this.getObjectValue(strKey).toString());
				}
				continue;
			}
		}
		return jsonObject;
	}

	public int length() {
		return this.hmItem.size();
	}

	public static void main(String[] args) {

	}
}