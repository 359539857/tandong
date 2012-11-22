/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3-RC1</a>, using an
 * XML Schema.
 * $Id$
 */

package cto.framework.web.action.plugin.schema.types;

/**
 * Enumeration CatchTypeType.
 * 
 * @version $Revision$ $Date$
 */
public enum CatchTypeType {


      //------------------/
     //- Enum Constants -/
    //------------------/

    /**
     * Constant EXCEPTION
     */
    EXCEPTION("Exception");
    /**
     * Field value.
     */
    private final java.lang.String value;

    /**
     * Field enumConstants.
     */
    private static final java.util.Map<java.lang.String, CatchTypeType> enumConstants = new java.util.HashMap<java.lang.String, CatchTypeType>();


    static {
        for (CatchTypeType c: CatchTypeType.values()) {
            CatchTypeType.enumConstants.put(c.value, c);
        }

    };

    private CatchTypeType(final java.lang.String value) {
        this.value = value;
    }

    /**
     * Method fromValue.
     * 
     * @param value
     * @return the constant for this value
     */
    public static cto.framework.web.action.plugin.schema.types.CatchTypeType fromValue(final java.lang.String value) {
        CatchTypeType c = CatchTypeType.enumConstants.get(value);
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
