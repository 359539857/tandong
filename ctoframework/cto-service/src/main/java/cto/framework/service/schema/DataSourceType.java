/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3-RC1</a>, using an
 * XML Schema.
 * $Id$
 */

package cto.framework.service.schema;

/**
 * Class DataSourceType.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class DataSourceType implements java.io.Serializable {

    /**
     * Field _poolClass.
     */
    private cto.framework.service.schema.types.PoolClassType _poolClass;

    /**
     * Field _id.
     */
    private java.lang.String _id;

    /**
     * Field _description.
     */
    private java.lang.String _description;

    /**
     * Field _propertyList.
     */
    private java.util.List<cto.framework.service.schema.Property> _propertyList;

    public DataSourceType() {
        super();
        this._propertyList = new java.util.ArrayList<cto.framework.service.schema.Property>();
    }

    /**
     * 
     * 
     * @param vProperty
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addProperty(final cto.framework.service.schema.Property vProperty) throws java.lang.IndexOutOfBoundsException {
        this._propertyList.add(vProperty);
    }

    /**
     * 
     * 
     * @param index
     * @param vProperty
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addProperty(final int index,final cto.framework.service.schema.Property vProperty) throws java.lang.IndexOutOfBoundsException {
        this._propertyList.add(index, vProperty);
    }

    /**
     * Method enumerateProperty.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends cto.framework.service.schema.Property> enumerateProperty() {
        return java.util.Collections.enumeration(this._propertyList);
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
     * Returns the value of field 'id'.
     * 
     * @return the value of field 'Id'.
     */
    public java.lang.String getId() {
        return this._id;
    }

    /**
     * Returns the value of field 'poolClass'.
     * 
     * @return the value of field 'PoolClass'.
     */
    public cto.framework.service.schema.types.PoolClassType getPoolClass() {
        return this._poolClass;
    }

    /**
     * Method getProperty.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * cto.framework.service.schema.Property at the given index
     */
    public cto.framework.service.schema.Property getProperty(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._propertyList.size()) {
            throw new IndexOutOfBoundsException("getProperty: Index value '" + index + "' not in range [0.." + (this._propertyList.size() - 1) + "]");
        }

        return _propertyList.get(index);
    }

    /**
     * Method getProperty.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public cto.framework.service.schema.Property[] getProperty() {
        cto.framework.service.schema.Property[] array = new cto.framework.service.schema.Property[0];
        return this._propertyList.toArray(array);
    }

    /**
     * Method getPropertyCount.
     * 
     * @return the size of this collection
     */
    public int getPropertyCount() {
        return this._propertyList.size();
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
     * Method iterateProperty.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends cto.framework.service.schema.Property> iterateProperty() {
        return this._propertyList.iterator();
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
    public void removeAllProperty() {
        this._propertyList.clear();
    }

    /**
     * Method removeProperty.
     * 
     * @param vProperty
     * @return true if the object was removed from the collection.
     */
    public boolean removeProperty(final cto.framework.service.schema.Property vProperty) {
        boolean removed = _propertyList.remove(vProperty);
        return removed;
    }

    /**
     * Method removePropertyAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public cto.framework.service.schema.Property removePropertyAt(final int index) {
        java.lang.Object obj = this._propertyList.remove(index);
        return (cto.framework.service.schema.Property) obj;
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
     * Sets the value of field 'id'.
     * 
     * @param id the value of field 'id'.
     */
    public void setId(final java.lang.String id) {
        this._id = id;
    }

    /**
     * Sets the value of field 'poolClass'.
     * 
     * @param poolClass the value of field 'poolClass'.
     */
    public void setPoolClass(final cto.framework.service.schema.types.PoolClassType poolClass) {
        this._poolClass = poolClass;
    }

    /**
     * 
     * 
     * @param index
     * @param vProperty
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setProperty(final int index,final cto.framework.service.schema.Property vProperty) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._propertyList.size()) {
            throw new IndexOutOfBoundsException("setProperty: Index value '" + index + "' not in range [0.." + (this._propertyList.size() - 1) + "]");
        }

        this._propertyList.set(index, vProperty);
    }

    /**
     * 
     * 
     * @param vPropertyArray
     */
    public void setProperty(final cto.framework.service.schema.Property[] vPropertyArray) {
        //-- copy array
        _propertyList.clear();

        for (int i = 0; i < vPropertyArray.length; i++) {
                this._propertyList.add(vPropertyArray[i]);
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
     * cto.framework.service.schema.DataSourceType
     */
    public static cto.framework.service.schema.DataSourceType unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (cto.framework.service.schema.DataSourceType) org.exolab.castor.xml.Unmarshaller.unmarshal(cto.framework.service.schema.DataSourceType.class, reader);
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
