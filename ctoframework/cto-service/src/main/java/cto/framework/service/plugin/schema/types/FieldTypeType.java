/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3-RC1</a>, using an
 * XML Schema.
 * $Id$
 */

package cto.framework.service.plugin.schema.types;

/**
 * Enumeration FieldTypeType.
 * 
 * @version $Revision$ $Date$
 */
public enum FieldTypeType {


      //------------------/
     //- Enum Constants -/
    //------------------/

    /**
     * Constant STRING
     */
    STRING("string"),
    /**
     * Constant INT
     */
    INT("int"),
    /**
     * Constant FLOAT
     */
    FLOAT("float"),
    /**
     * Constant DOUBLE
     */
    DOUBLE("double"),
    /**
     * Constant LONG
     */
    LONG("long"),
    /**
     * Constant BOOLEAN
     */
    BOOLEAN("boolean");
    /**
     * Field value.
     */
    private final java.lang.String value;

    /**
     * Field enumConstants.
     */
    private static final java.util.Map<java.lang.String, FieldTypeType> enumConstants = new java.util.HashMap<java.lang.String, FieldTypeType>();


    static {
        for (FieldTypeType c: FieldTypeType.values()) {
            FieldTypeType.enumConstants.put(c.value, c);
        }

    };

    private FieldTypeType(final java.lang.String value) {
        this.value = value;
    }

    /**
     * Method fromValue.
     * 
     * @param value
     * @return the constant for this value
     */
    public static cto.framework.service.plugin.schema.types.FieldTypeType fromValue(final java.lang.String value) {
        FieldTypeType c = FieldTypeType.enumConstants.get(value);
        if (c != null) {
            return c;
        }
        throw new IllegalArgumentException(value);
    }

    /**
     * 
     * 
     * @param value
     */
    public void setValue(final java.lang.String value) {
    }

    /**
     * Method toString.
     * 
     * @return the value of this constant
     */
    public java.lang.String toString() {
        return this.value;
    }

    /**
     * Method value.
     * 
     * @return the value of this constant
     */
    public java.lang.String value() {
        return this.value;
    }

}
