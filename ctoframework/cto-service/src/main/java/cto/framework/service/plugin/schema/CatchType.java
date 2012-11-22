/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3-RC1</a>, using an
 * XML Schema.
 * $Id$
 */

package cto.framework.service.plugin.schema;

/**
 * Class CatchType.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CatchType implements java.io.Serializable {

    /**
     * Field _type.
     */
    private cto.framework.service.plugin.schema.types.CatchTypeType _type;

    /**
     * Field _name.
     */
    private java.lang.String _name;

    /**
     * Field _catchTypeChoice.
     */
    private cto.framework.service.plugin.schema.CatchTypeChoice _catchTypeChoice;

    /**
     * Field _throw.
     */
    private cto.framework.service.plugin.schema.Throw _throw;

    public CatchType() {
        super();
    }

    /**
     * Returns the value of field 'catchTypeChoice'.
     * 
     * @return the value of field 'CatchTypeChoice'.
     */
    public cto.framework.service.plugin.schema.CatchTypeChoice getCatchTypeChoice() {
        return this._catchTypeChoice;
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
    public cto.framework.service.plugin.schema.Throw getThrow() {
        return this._throw;
    }

    /**
     * Returns the value of field 'type'.
     * 
     * @return the value of field 'Type'.
     */
    public cto.framework.service.plugin.schema.types.CatchTypeType getType() {
        return this._type;
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
     * Sets the value of field 'catchTypeChoice'.
     * 
     * @param catchTypeChoice the value of field 'catchTypeChoice'.
     */
    public void setCatchTypeChoice(final cto.framework.service.plugin.schema.CatchTypeChoice catchTypeChoice) {
        this._catchTypeChoice = catchTypeChoice;
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
    public void setThrow(final cto.framework.service.plugin.schema.Throw _throw) {
        this._throw = _throw;
    }

    /**
     * Sets the value of field 'type'.
     * 
     * @param type the value of field 'type'.
     */
    public void setType(final cto.framework.service.plugin.schema.types.CatchTypeType type) {
        this._type = type;
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
     * cto.framework.service.plugin.schema.CatchType
     */
    public static cto.framework.service.plugin.schema.CatchType unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (cto.framework.service.plugin.schema.CatchType) org.exolab.castor.xml.Unmarshaller.unmarshal(cto.framework.service.plugin.schema.CatchType.class, reader);
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
