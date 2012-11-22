/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3-RC1</a>, using an
 * XML Schema.
 * $Id$
 */

package cto.framework.service.plugin.schema;

/**
 * Class IfType.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class IfType implements java.io.Serializable {

    /**
     * Field _expression.
     */
    private java.lang.String _expression;

    /**
     * Field _ifTypeChoice.
     */
    private cto.framework.service.plugin.schema.IfTypeChoice _ifTypeChoice;

    /**
     * Field _throw.
     */
    private cto.framework.service.plugin.schema.Throw _throw;

    public IfType() {
        super();
    }

    /**
     * Returns the value of field 'expression'.
     * 
     * @return the value of field 'Expression'.
     */
    public java.lang.String getExpression() {
        return this._expression;
    }

    /**
     * Returns the value of field 'ifTypeChoice'.
     * 
     * @return the value of field 'IfTypeChoice'.
     */
    public cto.framework.service.plugin.schema.IfTypeChoice getIfTypeChoice() {
        return this._ifTypeChoice;
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
     * Sets the value of field 'expression'.
     * 
     * @param expression the value of field 'expression'.
     */
    public void setExpression(final java.lang.String expression) {
        this._expression = expression;
    }

    /**
     * Sets the value of field 'ifTypeChoice'.
     * 
     * @param ifTypeChoice the value of field 'ifTypeChoice'.
     */
    public void setIfTypeChoice(final cto.framework.service.plugin.schema.IfTypeChoice ifTypeChoice) {
        this._ifTypeChoice = ifTypeChoice;
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
     * cto.framework.service.plugin.schema.IfType
     */
    public static cto.framework.service.plugin.schema.IfType unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (cto.framework.service.plugin.schema.IfType) org.exolab.castor.xml.Unmarshaller.unmarshal(cto.framework.service.plugin.schema.IfType.class, reader);
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
