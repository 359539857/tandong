/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3-RC1</a>, using an
 * XML Schema.
 * $Id$
 */

package cto.framework.service.plugin.schema;

/**
 * Class SelectType.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class SelectType implements java.io.Serializable {

    /**
     * Field _dataSource.
     */
    private java.lang.String _dataSource;

    /**
     * Field _outputId.
     */
    private java.lang.String _outputId;

    /**
     * Field _cache.
     */
    private boolean _cache;

    /**
     * keeps track of state for field: _cache
     */
    private boolean _has_cache;

    /**
     * Field _items.
     */
    private java.util.List<cto.framework.service.plugin.schema.SelectTypeItem> _items;

    public SelectType() {
        super();
        this._items = new java.util.ArrayList<cto.framework.service.plugin.schema.SelectTypeItem>();
    }

    /**
     * 
     * 
     * @param vSelectTypeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSelectTypeItem(final cto.framework.service.plugin.schema.SelectTypeItem vSelectTypeItem) throws java.lang.IndexOutOfBoundsException {
        this._items.add(vSelectTypeItem);
    }

    /**
     * 
     * 
     * @param index
     * @param vSelectTypeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSelectTypeItem(final int index,final cto.framework.service.plugin.schema.SelectTypeItem vSelectTypeItem) throws java.lang.IndexOutOfBoundsException {
        this._items.add(index, vSelectTypeItem);
    }

    /**
     */
    public void deleteCache() {
        this._has_cache= false;
    }

    /**
     * Method enumerateSelectTypeItem.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends cto.framework.service.plugin.schema.SelectTypeItem> enumerateSelectTypeItem() {
        return java.util.Collections.enumeration(this._items);
    }

    /**
     * Returns the value of field 'cache'.
     * 
     * @return the value of field 'Cache'.
     */
    public boolean getCache() {
        return this._cache;
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
     * Returns the value of field 'outputId'.
     * 
     * @return the value of field 'OutputId'.
     */
    public java.lang.String getOutputId() {
        return this._outputId;
    }

    /**
     * Method getSelectTypeItem.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * cto.framework.service.plugin.schema.SelectTypeItem at the
     * given index
     */
    public cto.framework.service.plugin.schema.SelectTypeItem getSelectTypeItem(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("getSelectTypeItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        return _items.get(index);
    }

    /**
     * Method getSelectTypeItem.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public cto.framework.service.plugin.schema.SelectTypeItem[] getSelectTypeItem() {
        cto.framework.service.plugin.schema.SelectTypeItem[] array = new cto.framework.service.plugin.schema.SelectTypeItem[0];
        return this._items.toArray(array);
    }

    /**
     * Method getSelectTypeItemCount.
     * 
     * @return the size of this collection
     */
    public int getSelectTypeItemCount() {
        return this._items.size();
    }

    /**
     * Method hasCache.
     * 
     * @return true if at least one Cache has been added
     */
    public boolean hasCache() {
        return this._has_cache;
    }

    /**
     * Returns the value of field 'cache'.
     * 
     * @return the value of field 'Cache'.
     */
    public boolean isCache() {
        return this._cache;
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
     * Method iterateSelectTypeItem.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends cto.framework.service.plugin.schema.SelectTypeItem> iterateSelectTypeItem() {
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
    public void removeAllSelectTypeItem() {
        this._items.clear();
    }

    /**
     * Method removeSelectTypeItem.
     * 
     * @param vSelectTypeItem
     * @return true if the object was removed from the collection.
     */
    public boolean removeSelectTypeItem(final cto.framework.service.plugin.schema.SelectTypeItem vSelectTypeItem) {
        boolean removed = _items.remove(vSelectTypeItem);
        return removed;
    }

    /**
     * Method removeSelectTypeItemAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public cto.framework.service.plugin.schema.SelectTypeItem removeSelectTypeItemAt(final int index) {
        java.lang.Object obj = this._items.remove(index);
        return (cto.framework.service.plugin.schema.SelectTypeItem) obj;
    }

    /**
     * Sets the value of field 'cache'.
     * 
     * @param cache the value of field 'cache'.
     */
    public void setCache(final boolean cache) {
        this._cache = cache;
        this._has_cache = true;
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
     * Sets the value of field 'outputId'.
     * 
     * @param outputId the value of field 'outputId'.
     */
    public void setOutputId(final java.lang.String outputId) {
        this._outputId = outputId;
    }

    /**
     * 
     * 
     * @param index
     * @param vSelectTypeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSelectTypeItem(final int index,final cto.framework.service.plugin.schema.SelectTypeItem vSelectTypeItem) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("setSelectTypeItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        this._items.set(index, vSelectTypeItem);
    }

    /**
     * 
     * 
     * @param vSelectTypeItemArray
     */
    public void setSelectTypeItem(final cto.framework.service.plugin.schema.SelectTypeItem[] vSelectTypeItemArray) {
        //-- copy array
        _items.clear();

        for (int i = 0; i < vSelectTypeItemArray.length; i++) {
                this._items.add(vSelectTypeItemArray[i]);
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
     * cto.framework.service.plugin.schema.SelectType
     */
    public static cto.framework.service.plugin.schema.SelectType unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (cto.framework.service.plugin.schema.SelectType) org.exolab.castor.xml.Unmarshaller.unmarshal(cto.framework.service.plugin.schema.SelectType.class, reader);
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
