/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3-RC1</a>, using an
 * XML Schema.
 * $Id$
 */

package cto.framework.service.plugin.schema;

/**
 * Class CallType.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CallType implements java.io.Serializable {

    /**
     * Field _actionTransName.
     */
    private java.lang.String _actionTransName;

    /**
     * Field _serviceName.
     */
    private java.lang.String _serviceName;

    public CallType() {
        super();
    }

    /**
     * Returns the value of field 'actionTransName'.
     * 
     * @return the value of field 'ActionTransName'.
     */
    public java.lang.String getActionTransName() {
        return this._actionTransName;
    }

    /**
     * Returns the value of field 'serviceName'.
     * 
     * @return the value of field 'ServiceName'.
     */
    public java.lang.String getServiceName() {
        return this._serviceName;
    }

    /**
     * Method isValid.
     * 
     * @return true if this object is valid according to the schema
     */
    public boolean isValid() {
        try {
            validate();
        } catch (org.exolab.castor.xml.ValidationException vex) {
            return false;
        }
        return true;
    }

    /**
     * 
     * 
     * @param out
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void marshal(final java.io.Writer out) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Marshaller.marshal(this, out);
    }

    /**
     * 
     * 
     * @param handler
     * @throws java.io.IOException if an IOException occurs during
     * marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     */
    public void marshal(final org.xml.sax.ContentHandler handler) throws java.io.IOException, org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Marshaller.marshal(this, handler);
    }

    /**
     * Sets the value of field 'actionTransName'.
     * 
     * @param actionTransName the value of field 'actionTransName'.
     */
    public void setActionTransName(final java.lang.String actionTransName) {
        this._actionTransName = actionTransName;
    }

    /**
     * Sets the value of field 'serviceName'.
     * 
     * @param serviceName the value of field 'serviceName'.
     */
    public void setServiceName(final java.lang.String serviceName) {
        this._serviceName = serviceName;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled
     * cto.framework.service.plugin.schema.CallType
     */
    public static cto.framework.service.plugin.schema.CallType unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (cto.framework.service.plugin.schema.CallType) org.exolab.castor.xml.Unmarshaller.unmarshal(cto.framework.service.plugin.schema.CallType.class, reader);
    }

    /**
     * 
     * 
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void validate() throws org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    }

}
