/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3-RC1</a>, using an
 * XML Schema.
 * $Id$
 */

package cto.framework.service.schema.types;

/**
 * Enumeration PoolClassType.
 * 
 * @version $Revision$ $Date$
 */
public enum PoolClassType {


      //------------------/
     //- Enum Constants -/
    //------------------/

    /**
     * Constant COM_MCHANGE_V2_C3P0_COMBOPOOLEDDATASOURCE
     */
    COM_MCHANGE_V2_C3P0_COMBOPOOLEDDATASOURCE("com.mchange.v2.c3p0.ComboPooledDataSource"),
    /**
     * Constant ORG_APACHE_COMMONS_DBCP_BASICDATASOURCE
     */
    ORG_APACHE_COMMONS_DBCP_BASICDATASOURCE("org.apache.commons.dbcp.BasicDataSource"),
    /**
     * Constant ORG_LOGICALCOBWEBS_PROXOOL_PROXOOLDATASOURCE
     */
    ORG_LOGICALCOBWEBS_PROXOOL_PROXOOLDATASOURCE("org.logicalcobwebs.proxool.ProxoolDataSource"),
    /**
     * Constant COM_JOLBOX_BONECP_BONECPDATASOURCE
     */
    COM_JOLBOX_BONECP_BONECPDATASOURCE("com.jolbox.bonecp.BoneCPDataSource");
    /**
     * Field value.
     */
    private final java.lang.String value;

    /**
     * Field enumConstants.
     */
    private static final java.util.Map<java.lang.String, PoolClassType> enumConstants = new java.util.HashMap<java.lang.String, PoolClassType>();


    static {
        for (PoolClassType c: PoolClassType.values()) {
            PoolClassType.enumConstants.put(c.value, c);
        }

    };

    private PoolClassType(final java.lang.String value) {
        this.value = value;
    }

    /**
     * Method fromValue.
     * 
     * @param value
     * @return the constant for this value
     */
    public static cto.framework.service.schema.types.PoolClassType fromValue(final java.lang.String value) {
        PoolClassType c = PoolClassType.enumConstants.get(value);
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
