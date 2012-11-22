/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3-RC1</a>, using an
 * XML Schema.
 * $Id$
 */

package cto.framework.service.plugin.schema;

/**
 * Class SQLElementType.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class SQLElementType implements java.io.Serializable {

    /**
     * Field _dataSource.
     */
    private java.lang.String _dataSource;

    /**
     * Field _items.
     */
    private java.util.List<cto.framework.service.plugin.schema.SQLElementTypeItem> _items;

    public SQLElementType() {
        super();
        this._items = new java.util.ArrayList<cto.framework.service.plugin.schema.SQLElementTypeItem>();
    }

    /**
     * 
     * 
     * @param vSQLElementTypeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSQLElementTypeItem(final cto.framework.service.plugin.schema.SQLElementTypeItem vSQLElementTypeItem) throws java.lang.IndexOutOfBoundsException {
        this._items.add(vSQLElementTypeItem);
    }

    /**
     * 
     * 
     * @param index
     * @param vSQLElementTypeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSQLElementTypeItem(final int index,final cto.framework.service.plugin.schema.SQLElementTypeItem vSQLElementTypeItem) throws java.lang.IndexOutOfBoundsException {
        this._items.add(index, vSQLElementTypeItem);
    }

    /**
     * Method enumerateSQLElementTypeItem.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends cto.framework.service.plugin.schema.SQLElementTypeItem> enumerateSQLElementTypeItem() {
        return java.util.Collections.enumeration(this._items);
    }

    /**
     * Returns the value of field 'dataSource'.
     * 
     * @return the value of field 'DataSource'.
     */
    public java.lang.String getDataSource() {
        return this._dataSource;
    }

    /**
     * Method getSQLElementTypeItem.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * cto.framework.service.plugin.schema.SQLElementTypeItem at
     * the given index
     */
    public cto.framework.service.plugin.schema.SQLElementTypeItem getSQLElementTypeItem(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("getSQLElementTypeItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        return _items.get(index);
    }

    /**
     * Method getSQLElementTypeItem.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public cto.framework.service.plugin.schema.SQLElementTypeItem[] getSQLElementTypeItem() {
        cto.framework.service.plugin.schema.SQLElementTypeItem[] array = new cto.framework.service.plugin.schema.SQLElementTypeItem[0];
        return this._items.toArray(array);
    }

    /**
     * Method getSQLElementTypeItemCount.
     * 
     * @return the size of this collection
     */
    public int getSQLElementTypeItemCount() {
        return this._items.size();
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
     * Method iterateSQLElementTypeItem.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends cto.framework.service.plugin.schema.SQLElementTypeItem> iterateSQLElementTypeItem() {
        return this._items.iterator();
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
    public void removeAllSQLElementTypeItem() {
        this._items.clear();
    }

    /**
     * Method removeSQLElementTypeItem.
     * 
     * @param vSQLElementTypeItem
     * @return true if the object was removed from the collection.
     */
    public boolean removeSQLElementTypeItem(final cto.framework.service.plugin.schema.SQLElementTypeItem vSQLElementTypeItem) {
        boolean removed = _items.remove(vSQLElementTypeItem);
        return removed;
    }

    /**
     * Method removeSQLElementTypeItemAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public cto.framework.service.plugin.schema.SQLElementTypeItem removeSQLElementTypeItemAt(final int index) {
        java.lang.Object obj = this._items.remove(index);
        return (cto.framework.service.plugin.schema.SQLElementTypeItem) obj;
    }

    /**
     * Sets the value of field 'dataSource'.
     * 
     * @param dataSource the value of field 'dataSource'.
     */
    public void setDataSource(final java.lang.String dataSource) {
        this._dataSource = dataSource;
    }

    /**
     * 
     * 
     * @param index
     * @param vSQLElementTypeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSQLElementTypeItem(final int index,final cto.framework.service.plugin.schema.SQLElementTypeItem vSQLElementTypeItem) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("setSQLElementTypeItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        this._items.set(index, vSQLElementTypeItem);
    }

    /**
     * 
     * 
     * @param vSQLElementTypeItemArray
     */
    public void setSQLElementTypeItem(final cto.framework.service.plugin.schema.SQLElementTypeItem[] vSQLElementTypeItemArray) {
        //-- copy array
        _items.clear();

        for (int i = 0; i < vSQLElementTypeItemArray.length; i++) {
                this._items.add(vSQLElementTypeItemArray[i]);
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
     * cto.framework.service.plugin.schema.SQLElementType
     */
    public static cto.framework.service.plugin.schema.SQLElementType unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (cto.framework.service.plugin.schema.SQLElementType) org.exolab.castor.xml.Unmarshaller.unmarshal(cto.framework.service.plugin.schema.SQLElementType.class, reader);
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
