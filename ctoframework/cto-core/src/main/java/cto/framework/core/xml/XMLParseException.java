package cto.framework.core.xml;

public class XMLParseException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3064063778725485519L;
	public static final int NO_LINE = -1;
	private int lineNr;

	public XMLParseException(String name, String message) {
		super("XML Parse Exception during parsing of "
				+ (name == null ? "the XML definition" : new StringBuilder("a ").append(name).append(" element")
						.toString()) + ": " + message);
		this.lineNr = -1;
	}

	public XMLParseException(String name, int lineNr, String message) {
		super("XML Parse Exception during parsing of "
				+ (name == null ? "the XML definition" : new StringBuilder("a ").append(name).append(" element")
						.toString()) + " at line " + lineNr + ": " + message);
		this.lineNr = lineNr;
	}

	public int getLineNr() {
		return this.lineNr;
	}
}
