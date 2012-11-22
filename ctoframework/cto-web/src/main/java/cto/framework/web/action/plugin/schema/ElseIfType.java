/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3-RC1</a>, using an
 * XML Schema.
 * $Id$
 */

package cto.framework.web.action.plugin.schema;

/**
 * Class ElseIfType.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ElseIfType implements java.io.Serializable {

    /**
     * Field _expression.
     */
    private java.lang.String _expression;

    /**
     * Field _elseIfTypeChoice.
     */
    private cto.framework.web.action.plugin.schema.ElseIfTypeChoice _elseIfTypeChoice;

    /**
     * Field _throw.
     */
    private cto.framework.web.action.plugin.schema.Throw _throw;

    public ElseIfType() {
        super();
    }

    /**
     * Returns the value of field 'elseIfTypeChoice'.
     * 
     * @return the value of field 'ElseIfTypeChoice'.
     */
    public cto.framework.web.action.plugin.schema.ElseIfTypeChoice getElseIfTypeChoice() {
        return this._elseIfTypeChoice;
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
     * Returns the value of field 'throw'.
     * 
     * @return the value of field 'Throw'.
     */
    public cto.framework.web.action.plugin.schema.Throw getThrow() {
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
     * Sets the value of field 'elseIfTypeChoice'.
     * 
     * @param elseIfTypeChoice the value of field 'elseIfTypeChoice'
     */
    public void setElseIfTypeChoice(final cto.framework.web.action.plugin.schema.ElseIfTypeChoice elseIfTypeChoice) {
        this._elseIfTypeChoice = elseIfTypeChoice;
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
     * Sets the value of field 'throw'.
     * 
     * @param _throw
     * @param throw the value of field 'throw'.
     */
    public void setThrow(final cto.framework.web.action.plugin.schema.Throw _throw) {
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
     * cto.framework.web.action.plugin.schema.ElseIfType
     */
    public static cto.framework.web.action.plugin.schema.ElseIfType unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (cto.framework.web.action.plugin.schema.ElseIfType) org.exolab.castor.xml.Unmarshaller.unmarshal(cto.framework.web.action.plugin.schema.ElseIfType.class, reader);
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
