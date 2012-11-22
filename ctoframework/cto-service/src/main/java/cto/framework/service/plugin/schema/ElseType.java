/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3-RC1</a>, using an
 * XML Schema.
 * $Id$
 */

package cto.framework.service.plugin.schema;

/**
 * Class ElseType.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ElseType implements java.io.Serializable {

    /**
     * Field _elseTypeChoice.
     */
    private cto.framework.service.plugin.schema.ElseTypeChoice _elseTypeChoice;

    /**
     * Field _throw.
     */
    private cto.framework.service.plugin.schema.Throw _throw;

    public ElseType() {
        super();
    }

    /**
     * Returns the value of field 'elseTypeChoice'.
     * 
     * @return the value of field 'ElseTypeChoice'.
     */
    public cto.framework.service.plugin.schema.ElseTypeChoice getElseTypeChoice() {
        return this._elseTypeChoice;
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
     * Sets the value of field 'elseTypeChoice'.
     * 
     * @param elseTypeChoice the value of field 'elseTypeChoice'.
     */
    public void setElseTypeChoice(final cto.framework.service.plugin.schema.ElseTypeChoice elseTypeChoice) {
        this._elseTypeChoice = elseTypeChoice;
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
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled
     * cto.framework.service.plugin.schema.ElseType
     */
    public static cto.framework.service.plugin.schema.ElseType unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (cto.framework.service.plugin.schema.ElseType) org.exolab.castor.xml.Unmarshaller.unmarshal(cto.framework.service.plugin.schema.ElseType.class, reader);
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
