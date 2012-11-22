/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3-RC1</a>, using an
 * XML Schema.
 * $Id$
 */

package cto.framework.web.action.schema;

/**
 * Class HadoopServerType.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class HadoopServerType implements java.io.Serializable {

    /**
     * Field _name.
     */
    private java.lang.String _name;

    /**
     * Field _IP.
     */
    private java.lang.String _IP;

    /**
     * Field _prot.
     */
    private java.lang.String _prot;

    public HadoopServerType() {
        super();
    }

    /**
     * Returns the value of field 'IP'.
     * 
     * @return the value of field 'IP'.
     */
    public java.lang.String getIP() {
        return this._IP;
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
     * Returns the value of field 'prot'.
     * 
     * @return the value of field 'Prot'.
     */
    public java.lang.String getProt() {
        return this._prot;
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
     * Sets the value of field 'IP'.
     * 
     * @param IP the value of field 'IP'.
     */
    public void setIP(final java.lang.String IP) {
        this._IP = IP;
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
     * Sets the value of field 'prot'.
     * 
     * @param prot the value of field 'prot'.
     */
    public void setProt(final java.lang.String prot) {
        this._prot = prot;
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
     * cto.framework.web.action.schema.HadoopServerType
     */
    public static cto.framework.web.action.schema.HadoopServerType unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (cto.framework.web.action.schema.HadoopServerType) org.exolab.castor.xml.Unmarshaller.unmarshal(cto.framework.web.action.schema.HadoopServerType.class, reader);
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
