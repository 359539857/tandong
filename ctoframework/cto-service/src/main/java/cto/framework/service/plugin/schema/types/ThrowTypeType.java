/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3-RC1</a>, using an
 * XML Schema.
 * $Id$
 */

package cto.framework.service.plugin.schema.types;

/**
 * Enumeration ThrowTypeType.
 * 
 * @version $Revision$ $Date$
 */
public enum ThrowTypeType {


      //------------------/
     //- Enum Constants -/
    //------------------/

    /**
     * Constant RUNTIMEEXCEPTION
     */
    RUNTIMEEXCEPTION("RuntimeException");
    /**
     * Field value.
     */
    private final java.lang.String value;

    /**
     * Field enumConstants.
     */
    private static final java.util.Map<java.lang.String, ThrowTypeType> enumConstants = new java.util.HashMap<java.lang.String, ThrowTypeType>();


    static {
        for (ThrowTypeType c: ThrowTypeType.values()) {
            ThrowTypeType.enumConstants.put(c.value, c);
        }

    };

    private ThrowTypeType(final java.lang.String value) {
        this.value = value;
    }

    /**
     * Method fromValue.
     * 
     * @param value
     * @return the constant for this value
     */
    public static cto.framework.service.plugin.schema.types.ThrowTypeType fromValue(final java.lang.String value) {
        ThrowTypeType c = ThrowTypeType.enumConstants.get(value);
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
