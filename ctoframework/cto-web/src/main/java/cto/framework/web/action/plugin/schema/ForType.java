/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3-RC1</a>, using an
 * XML Schema.
 * $Id$
 */

package cto.framework.web.action.plugin.schema;

/**
 * Class ForType.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ForType implements java.io.Serializable {

    /**
     * Field _collection.
     */
    private java.lang.String _collection;

    /**
     * Field _item.
     */
    private java.lang.String _item;

    /**
     * Field _begin.
     */
    private java.lang.String _begin;

    /**
     * Field _end.
     */
    private java.lang.String _end;

    /**
     * Field _separator.
     */
    private java.lang.String _separator;

    /**
     * Field _index.
     */
    private java.lang.String _index;

    /**
     * Field _forTypeChoice.
     */
    private cto.framework.web.action.plugin.schema.ForTypeChoice _forTypeChoice;

    /**
     * Field _throw.
     */
    private cto.framework.web.action.plugin.schema.Throw _throw;

    public ForType() {
        super();
    }

    /**
     * Returns the value of field 'begin'.
     * 
     * @return the value of field 'Begin'.
     */
    public java.lang.String getBegin() {
        return this._begin;
    }

    /**
     * Returns the value of field 'collection'.
     * 
     * @return the value of field 'Collection'.
     */
    public java.lang.String getCollection() {
        return this._collection;
    }

    /**
     * Returns the value of field 'end'.
     * 
     * @return the value of field 'End'.
     */
    public java.lang.String getEnd() {
        return this._end;
    }

    /**
     * Returns the value of field 'forTypeChoice'.
     * 
     * @return the value of field 'ForTypeChoice'.
     */
    public cto.framework.web.action.plugin.schema.ForTypeChoice getForTypeChoice() {
        return this._forTypeChoice;
    }

    /**
     * Returns the value of field 'index'.
     * 
     * @return the value of field 'Index'.
     */
    public java.lang.String getIndex() {
        return this._index;
    }

    /**
     * Returns the value of field 'item'.
     * 
     * @return the value of field 'Item'.
     */
    public java.lang.String getItem() {
        return this._item;
    }

    /**
     * Returns the value of field 'separator'.
     * 
     * @return the value of field 'Separator'.
     */
    public java.lang.String getSeparator() {
        return this._separator;
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
     * Sets the value of field 'begin'.
     * 
     * @param begin the value of field 'begin'.
     */
    public void setBegin(final java.lang.String begin) {
        this._begin = begin;
    }

    /**
     * Sets the value of field 'collection'.
     * 
     * @param collection the value of field 'collection'.
     */
    public void setCollection(final java.lang.String collection) {
        this._collection = collection;
    }

    /**
     * Sets the value of field 'end'.
     * 
     * @param end the value of field 'end'.
     */
    public void setEnd(final java.lang.String end) {
        this._end = end;
    }

    /**
     * Sets the value of field 'forTypeChoice'.
     * 
     * @param forTypeChoice the value of field 'forTypeChoice'.
     */
    public void setForTypeChoice(final cto.framework.web.action.plugin.schema.ForTypeChoice forTypeChoice) {
        this._forTypeChoice = forTypeChoice;
    }

    /**
     * Sets the value of field 'index'.
     * 
     * @param index the value of field 'index'.
     */
    public void setIndex(final java.lang.String index) {
        this._index = index;
    }

    /**
     * Sets the value of field 'item'.
     * 
     * @param item the value of field 'item'.
     */
    public void setItem(final java.lang.String item) {
        this._item = item;
    }

    /**
     * Sets the value of field 'separator'.
     * 
     * @param separator the value of field 'separator'.
     */
    public void setSeparator(final java.lang.String separator) {
        this._separator = separator;
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
     * cto.framework.web.action.plugin.schema.ForType
     */
    public static cto.framework.web.action.plugin.schema.ForType unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (cto.framework.web.action.plugin.schema.ForType) org.exolab.castor.xml.Unmarshaller.unmarshal(cto.framework.web.action.plugin.schema.ForType.class, reader);
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
