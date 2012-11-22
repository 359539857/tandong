/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3-RC1</a>, using an
 * XML Schema.
 * $Id$
 */

package cto.framework.service.plugin.schema.types;

/**
 * Enumeration LevelType.
 * 
 * @version $Revision$ $Date$
 */
public enum LevelType {


      //------------------/
     //- Enum Constants -/
    //------------------/

    /**
     * Constant INFO
     */
    INFO("info"),
    /**
     * Constant DEBUG
     */
    DEBUG("debug"),
    /**
     * Constant WARN
     */
    WARN("warn"),
    /**
     * Constant ERROR
     */
    ERROR("error"),
    /**
     * Constant FATAL
     */
    FATAL("fatal");
    /**
     * Field value.
     */
    private final java.lang.String value;

    /**
     * Field enumConstants.
     */
    private static final java.util.Map<java.lang.String, LevelType> enumConstants = new java.util.HashMap<java.lang.String, LevelType>();


    static {
        for (LevelType c: LevelType.values()) {
            LevelType.enumConstants.put(c.value, c);
        }

    };

    private LevelType(final java.lang.String value) {
        this.value = value;
    }

    /**
     * Method fromValue.
     * 
     * @param value
     * @return the constant for this value
     */
    public static cto.framework.service.plugin.schema.types.LevelType fromValue(final java.lang.String value) {
        LevelType c = LevelType.enumConstants.get(value);
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
