/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3-RC1</a>, using an
 * XML Schema.
 * $Id$
 */

package cto.framework.web.action.plugin.schema;

/**
 * Class ValidatorType.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ValidatorType implements java.io.Serializable {

    /**
     * Field _description.
     */
    private java.lang.String _description;

    /**
     * Field _fieldList.
     */
    private java.util.List<cto.framework.web.action.plugin.schema.Field> _fieldList;

    public ValidatorType() {
        super();
        this._fieldList = new java.util.ArrayList<cto.framework.web.action.plugin.schema.Field>();
    }

    /**
     * 
     * 
     * @param vField
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addField(final cto.framework.web.action.plugin.schema.Field vField) throws java.lang.IndexOutOfBoundsException {
        this._fieldList.add(vField);
    }

    /**
     * 
     * 
     * @param index
     * @param vField
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addField(final int index,final cto.framework.web.action.plugin.schema.Field vField) throws java.lang.IndexOutOfBoundsException {
        this._fieldList.add(index, vField);
    }

    /**
     * Method enumerateField.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends cto.framework.web.action.plugin.schema.Field> enumerateField() {
        return java.util.Collections.enumeration(this._fieldList);
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
     * Method getField.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * cto.framework.web.action.plugin.schema.Field at the given
     * index
     */
    public cto.framework.web.action.plugin.schema.Field getField(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._fieldList.size()) {
            throw new IndexOutOfBoundsException("getField: Index value '" + index + "' not in range [0.." + (this._fieldList.size() - 1) + "]");
        }

        return _fieldList.get(index);
    }

    /**
     * Method getField.Returns the contents of the collection in an
     * Array.  <p>Note:  Just in case the collection contents are
     * changing in another thread, we pass a 0-length Array of the
     * correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public cto.framework.web.action.plugin.schema.Field[] getField() {
        cto.framework.web.action.plugin.schema.Field[] array = new cto.framework.web.action.plugin.schema.Field[0];
        return this._fieldList.toArray(array);
    }

    /**
     * Method getFieldCount.
     * 
     * @return the size of this collection
     */
    public int getFieldCount() {
        return this._fieldList.size();
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
     * Method iterateField.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends cto.framework.web.action.plugin.schema.Field> iterateField() {
        return this._fieldList.iterator();
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
     */
    public void removeAllField() {
        this._fieldList.clear();
    }

    /**
     * Method removeField.
     * 
     * @param vField
     * @return true if the object was removed from the collection.
     */
    public boolean removeField(final cto.framework.web.action.plugin.schema.Field vField) {
        boolean removed = _fieldList.remove(vField);
        return removed;
    }

    /**
     * Method removeFieldAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public cto.framework.web.action.plugin.schema.Field removeFieldAt(final int index) {
        java.lang.Object obj = this._fieldList.remove(index);
        return (cto.framework.web.action.plugin.schema.Field) obj;
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
     * 
     * 
     * @param index
     * @param vField
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setField(final int index,final cto.framework.web.action.plugin.schema.Field vField) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._fieldList.size()) {
            throw new IndexOutOfBoundsException("setField: Index value '" + index + "' not in range [0.." + (this._fieldList.size() - 1) + "]");
        }

        this._fieldList.set(index, vField);
    }

    /**
     * 
     * 
     * @param vFieldArray
     */
    public void setField(final cto.framework.web.action.plugin.schema.Field[] vFieldArray) {
        //-- copy array
        _fieldList.clear();

        for (int i = 0; i < vFieldArray.length; i++) {
                this._fieldList.add(vFieldArray[i]);
        }
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
     * cto.framework.web.action.plugin.schema.ValidatorType
     */
    public static cto.framework.web.action.plugin.schema.ValidatorType unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (cto.framework.web.action.plugin.schema.ValidatorType) org.exolab.castor.xml.Unmarshaller.unmarshal(cto.framework.web.action.plugin.schema.ValidatorType.class, reader);
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
