/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3-RC1</a>, using an
 * XML Schema.
 * $Id$
 */

package cto.framework.web.action.plugin.schema;

/**
 * Class CallType.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CallType implements java.io.Serializable {

    /**
     * Field _transName.
     */
    private java.lang.String _transName;

    /**
     * Field _actionName.
     */
    private java.lang.String _actionName;

    public CallType() {
        super();
    }

    /**
     * Returns the value of field 'actionName'.
     * 
     * @return the value of field 'ActionName'.
     */
    public java.lang.String getActionName() {
        return this._actionName;
    }

    /**
     * Returns the value of field 'transName'.
     * 
     * @return the value of field 'TransName'.
     */
    public java.lang.String getTransName() {
        return this._transName;
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
     * Sets the value of field 'actionName'.
     * 
     * @param actionName the value of field 'actionName'.
     */
    public void setActionName(final java.lang.String actionName) {
        this._actionName = actionName;
    }

    /**
     * Sets the value of field 'transName'.
     * 
     * @param transName the value of field 'transName'.
     */
    public void setTransName(final java.lang.String transName) {
        this._transName = transName;
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
     * cto.framework.web.action.plugin.schema.CallType
     */
    public static cto.framework.web.action.plugin.schema.CallType unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (cto.framework.web.action.plugin.schema.CallType) org.exolab.castor.xml.Unmarshaller.unmarshal(cto.framework.web.action.plugin.schema.CallType.class, reader);
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
