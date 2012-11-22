/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3-RC1</a>, using an
 * XML Schema.
 * $Id$
 */

package cto.framework.service.plugin.schema;

/**
 * Class SQLForType.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class SQLForType implements java.io.Serializable {

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
     * Field _items.
     */
    private java.util.List<cto.framework.service.plugin.schema.SQLForTypeItem> _items;

    public SQLForType() {
        super();
        this._items = new java.util.ArrayList<cto.framework.service.plugin.schema.SQLForTypeItem>();
    }

    /**
     * 
     * 
     * @param vSQLForTypeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSQLForTypeItem(final cto.framework.service.plugin.schema.SQLForTypeItem vSQLForTypeItem) throws java.lang.IndexOutOfBoundsException {
        this._items.add(vSQLForTypeItem);
    }

    /**
     * 
     * 
     * @param index
     * @param vSQLForTypeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSQLForTypeItem(final int index,final cto.framework.service.plugin.schema.SQLForTypeItem vSQLForTypeItem) throws java.lang.IndexOutOfBoundsException {
        this._items.add(index, vSQLForTypeItem);
    }

    /**
     * Method enumerateSQLForTypeItem.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends cto.framework.service.plugin.schema.SQLForTypeItem> enumerateSQLForTypeItem() {
        return java.util.Collections.enumeration(this._items);
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
     * Method getSQLForTypeItem.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * cto.framework.service.plugin.schema.SQLForTypeItem at the
     * given index
     */
    public cto.framework.service.plugin.schema.SQLForTypeItem getSQLForTypeItem(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("getSQLForTypeItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        return _items.get(index);
    }

    /**
     * Method getSQLForTypeItem.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public cto.framework.service.plugin.schema.SQLForTypeItem[] getSQLForTypeItem() {
        cto.framework.service.plugin.schema.SQLForTypeItem[] array = new cto.framework.service.plugin.schema.SQLForTypeItem[0];
        return this._items.toArray(array);
    }

    /**
     * Method getSQLForTypeItemCount.
     * 
     * @return the size of this collection
     */
    public int getSQLForTypeItemCount() {
        return this._items.size();
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
     * Method iterateSQLForTypeItem.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends cto.framework.service.plugin.schema.SQLForTypeItem> iterateSQLForTypeItem() {
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
    public void removeAllSQLForTypeItem() {
        this._items.clear();
    }

    /**
     * Method removeSQLForTypeItem.
     * 
     * @param vSQLForTypeItem
     * @return true if the object was removed from the collection.
     */
    public boolean removeSQLForTypeItem(final cto.framework.service.plugin.schema.SQLForTypeItem vSQLForTypeItem) {
        boolean removed = _items.remove(vSQLForTypeItem);
        return removed;
    }

    /**
     * Method removeSQLForTypeItemAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public cto.framework.service.plugin.schema.SQLForTypeItem removeSQLForTypeItemAt(final int index) {
        java.lang.Object obj = this._items.remove(index);
        return (cto.framework.service.plugin.schema.SQLForTypeItem) obj;
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
     * 
     * 
     * @param index
     * @param vSQLForTypeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSQLForTypeItem(final int index,final cto.framework.service.plugin.schema.SQLForTypeItem vSQLForTypeItem) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("setSQLForTypeItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        this._items.set(index, vSQLForTypeItem);
    }

    /**
     * 
     * 
     * @param vSQLForTypeItemArray
     */
    public void setSQLForTypeItem(final cto.framework.service.plugin.schema.SQLForTypeItem[] vSQLForTypeItemArray) {
        //-- copy array
        _items.clear();

        for (int i = 0; i < vSQLForTypeItemArray.length; i++) {
                this._items.add(vSQLForTypeItemArray[i]);
        }
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
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled
     * cto.framework.service.plugin.schema.SQLForType
     */
    public static cto.framework.service.plugin.schema.SQLForType unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (cto.framework.service.plugin.schema.SQLForType) org.exolab.castor.xml.Unmarshaller.unmarshal(cto.framework.service.plugin.schema.SQLForType.class, reader);
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
