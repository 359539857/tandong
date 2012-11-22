/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3-RC1</a>, using an
 * XML Schema.
 * $Id$
 */

package cto.framework.web.action.plugin.schema;

/**
 * Class TransType.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class TransType implements java.io.Serializable {

    /**
     * Field _name.
     */
    private java.lang.String _name;

    /**
     * Field _description.
     */
    private java.lang.String _description;

    /**
     * Field _validator.
     */
    private cto.framework.web.action.plugin.schema.Validator _validator;

    /**
     * Field _transTypeChoice.
     */
    private cto.framework.web.action.plugin.schema.TransTypeChoice _transTypeChoice;

    /**
     * Field _throw.
     */
    private cto.framework.web.action.plugin.schema.Throw _throw;

    public TransType() {
        super();
    }

    /**
     * Returns the value of field 'description'.
     * 
     * @return the value of field 'Description'.
     */
    public java.lang.String getDescription() {
        return this._description;
    }

    /**
     * Returns the value of field 'name'.
     * 
     * @return the value of field 'Name'.
     */
    public java.lang.String getName() {
        return this._name;
    }

    /**
     * Returns the value of field 'throw'.
     * 
     * @return the value of field 'Throw'.
     */
    public cto.framework.web.action.plugin.schema.Throw getThrow() {
        return this._throw;
    }

    /**
     * Returns the value of field 'transTypeChoice'.
     * 
     * @return the value of field 'TransTypeChoice'.
     */
    public cto.framework.web.action.plugin.schema.TransTypeChoice getTransTypeChoice() {
        return this._transTypeChoice;
    }

    /**
     * Returns the value of field 'validator'.
     * 
     * @return the value of field 'Validator'.
     */
    public cto.framework.web.action.plugin.schema.Validator getValidator() {
        return this._validator;
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
     * Sets the value of field 'description'.
     * 
     * @param description the value of field 'description'.
     */
    public void setDescription(final java.lang.String description) {
        this._description = description;
    }

    /**
     * Sets the value of field 'name'.
     * 
     * @param name the value of field 'name'.
     */
    public void setName(final java.lang.String name) {
        this._name = name;
    }

    /**
     * Sets the value of field 'throw'.
     * 
     * @param _throw
     * @param throw the value of field 'throw'.
     */
    public void setThrow(final cto.framework.web.action.plugin.schema.Throw _throw) {
        this._throw = _throw;
    }

    /**
     * Sets the value of field 'transTypeChoice'.
     * 
     * @param transTypeChoice the value of field 'transTypeChoice'.
     */
    public void setTransTypeChoice(final cto.framework.web.action.plugin.schema.TransTypeChoice transTypeChoice) {
        this._transTypeChoice = transTypeChoice;
    }

    /**
     * Sets the value of field 'validator'.
     * 
     * @param validator the value of field 'validator'.
     */
    public void setValidator(final cto.framework.web.action.plugin.schema.Validator validator) {
        this._validator = validator;
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
     * cto.framework.web.action.plugin.schema.TransType
     */
    public static cto.framework.web.action.plugin.schema.TransType unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (cto.framework.web.action.plugin.schema.TransType) org.exolab.castor.xml.Unmarshaller.unmarshal(cto.framework.web.action.plugin.schema.TransType.class, reader);
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
