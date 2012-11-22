/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3-RC1</a>, using an
 * XML Schema.
 * $Id$
 */

package cto.framework.service.plugin.schema;

/**
 * Class TryCatchFinallyGroup.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class TryCatchFinallyGroup implements java.io.Serializable {

    /**
     * Field _try.
     */
    private cto.framework.service.plugin.schema.Try _try;

    /**
     * Field _catch.
     */
    private cto.framework.service.plugin.schema.Catch _catch;

    /**
     * Field _finally.
     */
    private cto.framework.service.plugin.schema.Finally _finally;

    public TryCatchFinallyGroup() {
        super();
    }

    /**
     * Returns the value of field 'catch'.
     * 
     * @return the value of field 'Catch'.
     */
    public cto.framework.service.plugin.schema.Catch getCatch() {
        return this._catch;
    }

    /**
     * Returns the value of field 'finally'.
     * 
     * @return the value of field 'Finally'.
     */
    public cto.framework.service.plugin.schema.Finally getFinally() {
        return this._finally;
    }

    /**
     * Returns the value of field 'try'.
     * 
     * @return the value of field 'Try'.
     */
    public cto.framework.service.plugin.schema.Try getTry() {
        return this._try;
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
     * Sets the value of field 'catch'.
     * 
     * @param _catch
     * @param catch the value of field 'catch'.
     */
    public void setCatch(final cto.framework.service.plugin.schema.Catch _catch) {
        this._catch = _catch;
    }

    /**
     * Sets the value of field 'finally'.
     * 
     * @param _finally
     * @param finally the value of field 'finally'.
     */
    public void setFinally(final cto.framework.service.plugin.schema.Finally _finally) {
        this._finally = _finally;
    }

    /**
     * Sets the value of field 'try'.
     * 
     * @param _try
     * @param try the value of field 'try'.
     */
    public void setTry(final cto.framework.service.plugin.schema.Try _try) {
        this._try = _try;
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
     * cto.framework.service.plugin.schema.TryCatchFinallyGroup
     */
    public static cto.framework.service.plugin.schema.TryCatchFinallyGroup unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (cto.framework.service.plugin.schema.TryCatchFinallyGroup) org.exolab.castor.xml.Unmarshaller.unmarshal(cto.framework.service.plugin.schema.TryCatchFinallyGroup.class, reader);
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
