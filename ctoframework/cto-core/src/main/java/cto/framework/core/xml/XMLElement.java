// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   XMLElement.java

package cto.framework.core.xml;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package nanoxml:
//			XMLParseException

public class XMLElement {

	static final long serialVersionUID = 0x5cc6040a57beee99L;
	public static final int NANOXML_MAJOR_VERSION = 2;
	public static final int NANOXML_MINOR_VERSION = 2;
	private HashMap<Object, Object> attributes;
	private ArrayList<Object> children;
	private String name;
	private String contents;
	private HashMap<Object, Object> entities;
	private int lineNr;
	private boolean ignoreCase;
	private boolean ignoreWhitespace;
	private char charReadTooMuch;
	char chsReader[];
	int nIndex;
	private int parserLineNr;

	public XMLElement() {
		this(new HashMap<Object, Object>(), false, true, true);
	}

	public XMLElement(HashMap<Object, Object> entities) {
		this(entities, false, true, true);
	}

	public XMLElement(boolean skipLeadingWhitespace) {
		this(new HashMap<Object, Object>(), skipLeadingWhitespace, true, true);
	}

	public XMLElement(HashMap<Object, Object> entities, boolean skipLeadingWhitespace) {
		this(entities, skipLeadingWhitespace, true, true);
	}

	public XMLElement(HashMap<Object, Object> entities, boolean skipLeadingWhitespace, boolean ignoreCase) {
		this(entities, skipLeadingWhitespace, true, ignoreCase);
	}

	protected XMLElement(HashMap<Object, Object> entities, boolean skipLeadingWhitespace,
			boolean fillBasicConversionTable, boolean ignoreCase) {
		nIndex = 0;
		ignoreWhitespace = skipLeadingWhitespace;
		this.ignoreCase = ignoreCase;
		name = null;
		contents = "";
		attributes = new HashMap<Object, Object>();
		children = new ArrayList<Object>();
		this.entities = entities;
		lineNr = 0;
		for (Iterator<Object> enum1 = this.entities.keySet().iterator(); enum1.hasNext();) {
			Object key = enum1.next();
			Object value = this.entities.get(key);
			if (value instanceof String) {
				value = ((String) value).toCharArray();
				this.entities.put(key, value);
			}
		}

		if (fillBasicConversionTable) {
			this.entities.put("amp", new char[] { '&' });
			this.entities.put("quot", new char[] { '"' });
			this.entities.put("apos", new char[] { '\'' });
			this.entities.put("lt", new char[] { '<' });
			this.entities.put("gt", new char[] { '>' });
		}
	}

	public void addChild(XMLElement child) {
		children.add(child);
	}

	public void setAttribute(String name, Object value) {
		if (ignoreCase)
			name = name.toUpperCase();
		attributes.put(name, value.toString());
	}

	/**
	 * @deprecated Method addProperty is deprecated
	 */

	public void addProperty(String name, Object value) {
		setAttribute(name, value);
	}

	public void setIntAttribute(String name, int value) {
		if (ignoreCase)
			name = name.toUpperCase();
		attributes.put(name, Integer.toString(value));
	}

	/**
	 * @deprecated Method addProperty is deprecated
	 */

	public void addProperty(String key, int value) {
		setIntAttribute(key, value);
	}

	public void setDoubleAttribute(String name, double value) {
		if (ignoreCase)
			name = name.toUpperCase();
		attributes.put(name, Double.toString(value));
	}

	/**
	 * @deprecated Method addProperty is deprecated
	 */

	public void addProperty(String name, double value) {
		setDoubleAttribute(name, value);
	}

	public int countChildren() {
		return children.size();
	}

	public Set<?> enumerateAttributeNames() {
		return attributes.keySet();
	}

	public Iterator<?> enumerateChildren() {
		return children.iterator();
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Object> getChildren() {
		try {
			return ((ArrayList<Object>) this.children.clone());
		} catch (Exception e) {
		}

		return null;
	}

	/**
	 * @deprecated Method getContents is deprecated
	 */

	public String getContents() {
		return getContent();
	}

	public String getContent() {
		return contents;
	}

	public int getLineNr() {
		return lineNr;
	}

	public Object getAttribute(String name) {
		return getAttribute(name, null);
	}

	public Object getAttribute(String name, Object defaultValue) {
		if (ignoreCase)
			name = name.toUpperCase();
		Object value = attributes.get(name);
		if (value == null)
			value = defaultValue;
		return value;
	}

	@SuppressWarnings("rawtypes")
	public Object getAttribute(String name, HashMap valueSet, String defaultKey, boolean allowLiterals) {
		if (ignoreCase)
			name = name.toUpperCase();
		Object key = attributes.get(name);
		if (key == null)
			key = defaultKey;
		Object result = valueSet.get(key);
		if (result == null)
			if (allowLiterals)
				result = key;
			else
				throw invalidValue(name, (String) key);
		return result;
	}

	public String getStringAttribute(String name) {
		return getStringAttribute(name, null);
	}

	public String getStringAttribute(String name, String defaultValue) {
		return (String) getAttribute(name, defaultValue);
	}

	@SuppressWarnings("rawtypes")
	public String getStringAttribute(String name, HashMap valueSet, String defaultKey, boolean allowLiterals) {
		return (String) getAttribute(name, valueSet, defaultKey, allowLiterals);
	}

	public int getIntAttribute(String name) {
		return getIntAttribute(name, 0);
	}

	public int getIntAttribute(String name, int defaultValue) {
		if (this.ignoreCase) {
			name = name.toUpperCase();
		}
		String value = (String) this.attributes.get(name);
		if (value == null) {
			return defaultValue;
		}

		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			throw invalidValue(name, value);
		}
	}

	@SuppressWarnings("rawtypes")
	public int getIntAttribute(String name, HashMap valueSet, String defaultKey, boolean allowLiteralNumbers) {
		if (ignoreCase)
			name = name.toUpperCase();
		Object key = attributes.get(name);
		if (key == null)
			key = defaultKey;
		Integer result;
		try {
			result = (Integer) valueSet.get(key);
		} catch (ClassCastException e) {
			throw invalidValueSet(name);
		}
		if (result == null) {
			if (!allowLiteralNumbers)
				throw invalidValue(name, (String) key);
			try {
				result = Integer.valueOf((String) key);
			} catch (NumberFormatException e) {
				throw invalidValue(name, (String) key);
			}
		}
		return result.intValue();
	}

	public double getDoubleAttribute(String name) {
		return getDoubleAttribute(name, 0.0D);
	}

	public double getDoubleAttribute(String name, double defaultValue) {
		if (this.ignoreCase) {
			name = name.toUpperCase();
		}
		String value = (String) this.attributes.get(name);
		if (value == null) {
			return defaultValue;
		}

		try {
			return Double.valueOf(value).doubleValue();
		} catch (NumberFormatException e) {
			throw invalidValue(name, value);
		}
	}

	@SuppressWarnings("rawtypes")
	public double getDoubleAttribute(String name, HashMap valueSet, String defaultKey, boolean allowLiteralNumbers) {
		if (ignoreCase)
			name = name.toUpperCase();
		Object key = attributes.get(name);
		if (key == null)
			key = defaultKey;
		Double result;
		try {
			result = (Double) valueSet.get(key);
		} catch (ClassCastException e) {
			throw invalidValueSet(name);
		}
		if (result == null) {
			if (!allowLiteralNumbers)
				throw invalidValue(name, (String) key);
			try {
				result = Double.valueOf((String) key);
			} catch (NumberFormatException e) {
				throw invalidValue(name, (String) key);
			}
		}
		return result.doubleValue();
	}

	public boolean getBooleanAttribute(String name, String trueValue, String falseValue, boolean defaultValue) {
		if (ignoreCase)
			name = name.toUpperCase();
		Object value = attributes.get(name);
		if (value == null)
			return defaultValue;
		if (value.equals(trueValue))
			return true;
		if (value.equals(falseValue))
			return false;
		else
			throw invalidValue(name, (String) value);
	}

	/**
	 * @deprecated Method getIntProperty is deprecated
	 */

	@SuppressWarnings("rawtypes")
	public int getIntProperty(String name, HashMap valueSet, String defaultKey) {
		return getIntAttribute(name, valueSet, defaultKey, false);
	}

	/**
	 * @deprecated Method getProperty is deprecated
	 */

	public String getProperty(String name) {
		return getStringAttribute(name);
	}

	/**
	 * @deprecated Method getProperty is deprecated
	 */

	public String getProperty(String name, String defaultValue) {
		return getStringAttribute(name, defaultValue);
	}

	/**
	 * @deprecated Method getProperty is deprecated
	 */

	public int getProperty(String name, int defaultValue) {
		return getIntAttribute(name, defaultValue);
	}

	/**
	 * @deprecated Method getProperty is deprecated
	 */

	public double getProperty(String name, double defaultValue) {
		return getDoubleAttribute(name, defaultValue);
	}

	/**
	 * @deprecated Method getProperty is deprecated
	 */

	public boolean getProperty(String key, String trueValue, String falseValue, boolean defaultValue) {
		return getBooleanAttribute(key, trueValue, falseValue, defaultValue);
	}

	/**
	 * @deprecated Method getProperty is deprecated
	 */

	@SuppressWarnings("rawtypes")
	public Object getProperty(String name, HashMap valueSet, String defaultKey) {
		return getAttribute(name, valueSet, defaultKey, false);
	}

	/**
	 * @deprecated Method getStringProperty is deprecated
	 */

	@SuppressWarnings("rawtypes")
	public String getStringProperty(String name, HashMap valueSet, String defaultKey) {
		return getStringAttribute(name, valueSet, defaultKey, false);
	}

	/**
	 * @deprecated Method getSpecialIntProperty is deprecated
	 */

	@SuppressWarnings("rawtypes")
	public int getSpecialIntProperty(String name, HashMap valueSet, String defaultKey) {
		return getIntAttribute(name, valueSet, defaultKey, true);
	}

	/**
	 * @deprecated Method getSpecialDoubleProperty is deprecated
	 */

	@SuppressWarnings("rawtypes")
	public double getSpecialDoubleProperty(String name, HashMap valueSet, String defaultKey) {
		return getDoubleAttribute(name, valueSet, defaultKey, true);
	}

	public String getName() {
		return name;
	}

	/**
	 * @deprecated Method getTagName is deprecated
	 */

	public String getTagName() {
		return getName();
	}

	public void parseFromReader() throws IOException, XMLParseException {
		parseFromReader(1);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void parseFromReader(int startingLineNr) throws IOException, XMLParseException {
		name = null;
		contents = "";
		attributes = new HashMap();
		children = new ArrayList();
		charReadTooMuch = '\0';
		parserLineNr = startingLineNr;
		do {
			char ch = scanWhitespace();
			if (ch != '<')
				throw expectedInput("<");
			ch = readChar();
			if (ch == '!' || ch == '?') {
				skipSpecialTag(0);
			} else {
				unreadChar(ch);
				scanElement(this);
				return;
			}
		} while (true);
	}

	public void parseString(String string) throws XMLParseException {
		try {
			chsReader = string.toCharArray();
			parseFromReader(1);
		} catch (IOException ioexception) {
		}
	}

	public void parseString(String string, int offset) throws XMLParseException {
		parseString(string.substring(offset));
	}

	public void parseString(String string, int offset, int end) throws XMLParseException {
		parseString(string.substring(offset, end));
	}

	public void parseString(String string, int offset, int end, int startingLineNr) throws XMLParseException {
		string = string.substring(offset, end);
		try {
			parseFromReader(startingLineNr);
		} catch (IOException ioexception) {
		}
	}

	public void parseCharArray(char input[], int offset, int end) throws XMLParseException {
		parseCharArray(input, offset, end, 1);
	}

	public void parseCharArray(char input[], int offset, int end, int startingLineNr) throws XMLParseException {
		try {
			parseFromReader(startingLineNr);
		} catch (IOException ioexception) {
		}
	}

	public void removeChild(XMLElement child) {
		children.remove(child);
	}

	public void removeAttribute(String name) {
		if (ignoreCase)
			name = name.toUpperCase();
		attributes.remove(name);
	}

	/**
	 * @deprecated Method removeProperty is deprecated
	 */

	public void removeProperty(String name) {
		removeAttribute(name);
	}

	/**
	 * @deprecated Method removeChild is deprecated
	 */

	public void removeChild(String name) {
		removeAttribute(name);
	}

	protected XMLElement createAnotherElement() {
		return new XMLElement(entities, ignoreWhitespace, false, ignoreCase);
	}

	public void setContent(String content) {
		contents = content;
	}

	/**
	 * @deprecated Method setTagName is deprecated
	 */

	public void setTagName(String name) {
		setName(name);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		ByteArrayOutputStream out;
		try {
			out = new ByteArrayOutputStream();
			OutputStreamWriter writer = new OutputStreamWriter(out);
			write(writer);
			writer.flush();
			return new String(out.toByteArray());
		} catch (IOException e) {
		}
		return super.toString();
	}

	@SuppressWarnings("rawtypes")
	public void write(Writer writer) throws IOException {
		if (name == null) {
			writeEncoded(writer, contents);
			return;
		}
		writer.write(60);
		writer.write(name);
		if (!attributes.isEmpty()) {
			Set enum1 = attributes.keySet();
			for (Iterator iter = enum1.iterator(); iter.hasNext(); writer.write(34)) {
				writer.write(32);
				String key = (String) iter.next();
				String value = (String) attributes.get(key);
				writer.write(key);
				writer.write(61);
				writer.write(34);
				writeEncoded(writer, value);
			}

		}
		if (contents != null && contents.length() > 0) {
			writer.write(62);
			writeEncoded(writer, contents);
			writer.write(60);
			writer.write(47);
			writer.write(name);
			writer.write(62);
		} else if (children.isEmpty()) {
			writer.write(47);
			writer.write(62);
		} else {
			writer.write(62);
			XMLElement child;
			for (Iterator enum1 = enumerateChildren(); enum1.hasNext(); child.write(writer))
				child = (XMLElement) enum1.next();

			writer.write(60);
			writer.write(47);
			writer.write(name);
			writer.write(62);
		}
	}

	protected void writeEncoded(Writer writer, String str) throws IOException {
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			switch (ch) {
			case 60: // '<'
				writer.write(38);
				writer.write(108);
				writer.write(116);
				writer.write(59);
				break;

			case 62: // '>'
				writer.write(38);
				writer.write(103);
				writer.write(116);
				writer.write(59);
				break;

			case 38: // '&'
				writer.write(38);
				writer.write(97);
				writer.write(109);
				writer.write(112);
				writer.write(59);
				break;

			case 34: // '"'
				writer.write(38);
				writer.write(113);
				writer.write(117);
				writer.write(111);
				writer.write(116);
				writer.write(59);
				break;

			case 39: // '\''
				writer.write(38);
				writer.write(97);
				writer.write(112);
				writer.write(111);
				writer.write(115);
				writer.write(59);
				break;

			default:
				int unicode = ch;
				if (unicode < 32 || unicode > 126) {
					writer.write(38);
					writer.write(35);
					writer.write(120);
					writer.write(Integer.toString(unicode, 16));
					writer.write(59);
				} else {
					writer.write(ch);
				}
				break;
			}
		}

	}

	protected void scanIdentifier(StringBuilder result) throws IOException {
		do {
			char ch = readChar();
			if ((ch < 'A' || ch > 'Z') && (ch < 'a' || ch > 'z') && (ch < '0' || ch > '9') && ch != '_' && ch != '.'
					&& ch != ':' && ch != '-' && ch <= '~') {
				unreadChar(ch);
				return;
			}
			result.append(ch);
		} while (true);
	}

	protected char scanWhitespace() throws IOException {
		do {
			char ch = readChar();
			switch (ch) {
			default:
				return ch;

			case 9: // '\t'
			case 10: // '\n'
			case 13: // '\r'
			case 32: // ' '
				break;
			}
		} while (true);
	}

	protected char scanWhitespace(StringBuilder result) throws IOException {
		do {
			char ch = readChar();
			switch (ch) {
			case 9: // '\t'
			case 10: // '\n'
			case 32: // ' '
				result.append(ch);
				break;

			default:
				return ch;

			case 13: // '\r'
				break;
			}
		} while (true);
	}

	protected void scanString(StringBuilder string) throws IOException {
		char delimiter = readChar();
		if (delimiter != '\'' && delimiter != '"')
			throw expectedInput("' or \"");
		do {
			char ch = readChar();
			if (ch == delimiter)
				return;
			if (ch == '&')
				resolveEntity(string);
			else
				string.append(ch);
		} while (true);
	}

	protected void scanPCData(StringBuilder data) throws IOException {
		do {
			char ch = readChar();
			if (ch == '<') {
				ch = readChar();
				if (ch == '!') {
					checkCDATA(data);
				} else {
					unreadChar(ch);
					return;
				}
			} else if (ch == '&')
				resolveEntity(data);
			else
				data.append(ch);
		} while (true);
	}

	protected boolean checkCDATA(StringBuilder buf) throws IOException {
		char ch = readChar();
		if (ch != '[') {
			unreadChar(ch);
			skipSpecialTag(0);
			return false;
		}
		if (!checkLiteral("CDATA[")) {
			skipSpecialTag(1);
			return false;
		}
		for (int delimiterCharsSkipped = 0; delimiterCharsSkipped < 3;) {
			ch = readChar();
			switch (ch) {
			case 93: // ']'
				if (delimiterCharsSkipped < 2) {
					delimiterCharsSkipped++;
				} else {
					buf.append(']');
					buf.append(']');
					delimiterCharsSkipped = 0;
				}
				break;

			case 62: // '>'
				if (delimiterCharsSkipped < 2) {
					for (int i = 0; i < delimiterCharsSkipped; i++)
						buf.append(']');

					delimiterCharsSkipped = 0;
					buf.append('>');
				} else {
					delimiterCharsSkipped = 3;
				}
				break;

			default:
				for (int i = 0; i < delimiterCharsSkipped; i++)
					buf.append(']');

				buf.append(ch);
				delimiterCharsSkipped = 0;
				break;
			}
		}

		return true;
	}

	protected void skipComment() throws IOException {
		for (int dashesToRead = 2; dashesToRead > 0;) {
			char ch = readChar();
			if (ch == '-')
				dashesToRead--;
			else
				dashesToRead = 2;
		}

		if (readChar() != '>')
			throw expectedInput(">");
		else
			return;
	}

	protected void skipSpecialTag(int bracketLevel) throws IOException {
		int tagLevel = 1;
		char stringDelimiter = '\0';
		if (bracketLevel == 0) {
			char ch = readChar();
			if (ch == '[')
				bracketLevel++;
			else if (ch == '-') {
				ch = readChar();
				if (ch == '[')
					bracketLevel++;
				else if (ch == ']')
					bracketLevel--;
				else if (ch == '-') {
					skipComment();
					return;
				}
			}
		}
		while (tagLevel > 0) {
			char ch = readChar();
			if (stringDelimiter == 0) {
				if (ch == '"' || ch == '\'')
					stringDelimiter = ch;
				else if (bracketLevel <= 0)
					if (ch == '<')
						tagLevel++;
					else if (ch == '>')
						tagLevel--;
				if (ch == '[')
					bracketLevel++;
				else if (ch == ']')
					bracketLevel--;
			} else if (ch == stringDelimiter)
				stringDelimiter = '\0';
		}
	}

	protected boolean checkLiteral(String literal) throws IOException {
		int length = literal.length();
		for (int i = 0; i < length; i++)
			if (readChar() != literal.charAt(i))
				return false;

		return true;
	}

	protected char readChar() throws IOException {
		char ch;
		if (charReadTooMuch != 0) {
			ch = charReadTooMuch;
			charReadTooMuch = '\0';
			return ch;
		}
		if (nIndex >= chsReader.length)
			throw unexpectedEndOfData();
		ch = chsReader[nIndex++];
		if (ch == '\n') {
			parserLineNr++;
			return '\n';
		} else {
			return ch;
		}
	}

	protected void scanElement(XMLElement elt) throws IOException {
		StringBuilder buf;
		String name;
		char ch;
		label0: {
			buf = new StringBuilder();
			scanIdentifier(buf);
			name = buf.toString();
			elt.setName(name);
			for (ch = scanWhitespace(); ch != '>' && ch != '/'; ch = scanWhitespace()) {
				buf.setLength(0);
				unreadChar(ch);
				scanIdentifier(buf);
				String key = buf.toString();
				ch = scanWhitespace();
				if (ch != '=')
					throw expectedInput("=");
				unreadChar(scanWhitespace());
				buf.setLength(0);
				scanString(buf);
				elt.setAttribute(key, buf);
			}

			if (ch == '/') {
				ch = readChar();
				if (ch != '>')
					throw expectedInput(">");
				else
					return;
			}
			buf.setLength(0);
			ch = scanWhitespace(buf);
			if (ch != '<') {
				unreadChar(ch);
				scanPCData(buf);
				break label0;
			}
			do {
				ch = readChar();
				if (ch != '!')
					break;
				if (checkCDATA(buf)) {
					scanPCData(buf);
					break label0;
				}
				ch = scanWhitespace(buf);
				if (ch != '<') {
					unreadChar(ch);
					scanPCData(buf);
					break label0;
				}
			} while (true);
			if (ch != '/' || ignoreWhitespace)
				buf.setLength(0);
			if (ch == '/')
				unreadChar(ch);
		}
		if (buf.length() == 0) {
			for (; ch != '/'; ch = readChar()) {
				if (ch == '!') {
					ch = readChar();
					if (ch != '-')
						throw expectedInput("Comment or Element");
					ch = readChar();
					if (ch != '-')
						throw expectedInput("Comment or Element");
					skipComment();
				} else {
					unreadChar(ch);
					XMLElement child = createAnotherElement();
					scanElement(child);
					elt.addChild(child);
				}
				ch = scanWhitespace();
				if (ch != '<')
					throw expectedInput("<");
			}

			unreadChar(ch);
		} else if (ignoreWhitespace)
			elt.setContent(buf.toString().trim());
		else
			elt.setContent(buf.toString());
		ch = readChar();
		if (ch != '/')
			throw expectedInput("/");
		unreadChar(scanWhitespace());
		if (!checkLiteral(name))
			throw expectedInput(name);
		if (scanWhitespace() != '>')
			throw expectedInput(">");
		else
			return;
	}

	protected void resolveEntity(StringBuilder buf) throws IOException {
		char ch = '\0';
		StringBuilder keyBuf = new StringBuilder();
		do {
			ch = readChar();
			if (ch == ';')
				break;
			keyBuf.append(ch);
		} while (true);
		String key = keyBuf.toString();
		if (key.charAt(0) == '#') {
			try {
				if (key.charAt(1) == 'x')
					ch = (char) Integer.parseInt(key.substring(2), 16);
				else
					ch = (char) Integer.parseInt(key.substring(1), 10);
			} catch (NumberFormatException e) {
				throw unknownEntity(key);
			}
			buf.append(ch);
		} else {
			char value[] = (char[]) entities.get(key);
			if (value == null)
				throw unknownEntity(key);
			buf.append(value);
		}
	}

	protected void unreadChar(char ch) {
		charReadTooMuch = ch;
	}

	protected XMLParseException invalidValueSet(String name) {
		String msg = (new StringBuilder("Invalid value set (entity name = \"")).append(name).append("\")").toString();
		return new XMLParseException(getName(), parserLineNr, msg);
	}

	protected XMLParseException invalidValue(String name, String value) {
		String msg = (new StringBuilder("Attribute \"")).append(name).append("\" does not contain a valid ")
				.append("value (\"").append(value).append("\")").toString();
		return new XMLParseException(getName(), parserLineNr, msg);
	}

	protected XMLParseException unexpectedEndOfData() {
		String msg = "Unexpected end of data reached";
		return new XMLParseException(getName(), parserLineNr, msg);
	}

	protected XMLParseException syntaxError(String context) {
		String msg = (new StringBuilder("Syntax error while parsing ")).append(context).toString();
		return new XMLParseException(getName(), parserLineNr, msg);
	}

	protected XMLParseException expectedInput(String charSet) {
		String msg = (new StringBuilder("Expected: ")).append(charSet).toString();
		return new XMLParseException(getName(), parserLineNr, msg);
	}

	protected XMLParseException unknownEntity(String name) {
		String msg = (new StringBuilder("Unknown or invalid entity: &")).append(name).append(";").toString();
		return new XMLParseException(getName(), parserLineNr, msg);
	}
}