/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3-RC1</a>, using an
 * XML Schema.
 * $Id$
 */

package cto.framework.service.schema;

/**
 * Class SystemDataSourceGroup.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class SystemDataSourceGroup implements java.io.Serializable {

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * Field _dataSourceGroupList.
     */
    private java.util.List<cto.framework.service.schema.DataSourceGroup> _dataSourceGroupList;

    /**
     * Field _singleDataSource.
     */
    private cto.framework.service.schema.SingleDataSource _singleDataSource;

    /**
     * Field _readWriteDataSource.
     */
    private cto.framework.service.schema.ReadWriteDataSource _readWriteDataSource;

    public SystemDataSourceGroup() {
        super();
        this._dataSourceGroupList = new java.util.ArrayList<cto.framework.service.schema.DataSourceGroup>();
    }

    /**
     * 
     * 
     * @param vDataSourceGroup
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addDataSourceGroup(final cto.framework.service.schema.DataSourceGroup vDataSourceGroup) throws java.lang.IndexOutOfBoundsException {
        this._dataSourceGroupList.add(vDataSourceGroup);
    }

    /**
     * 
     * 
     * @param index
     * @param vDataSourceGroup
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addDataSourceGroup(final int index,final cto.framework.service.schema.DataSourceGroup vDataSourceGroup) throws java.lang.IndexOutOfBoundsException {
        this._dataSourceGroupList.add(index, vDataSourceGroup);
    }

    /**
     * Method enumerateDataSourceGroup.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends cto.framework.service.schema.DataSourceGroup> enumerateDataSourceGroup() {
        return java.util.Collections.enumeration(this._dataSourceGroupList);
    }

    /**
     * Returns the value of field 'choiceValue'. The field
     * 'choiceValue' has the following description: Internal choice
     * value storage
     * 
     * @return the value of field 'ChoiceValue'.
     */
    public java.lang.Object getChoiceValue() {
        return this._choiceValue;
    }

    /**
     * Method getDataSourceGroup.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * cto.framework.service.schema.DataSourceGroup at the given
     * index
     */
    public cto.framework.service.schema.DataSourceGroup getDataSourceGroup(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._dataSourceGroupList.size()) {
            throw new IndexOutOfBoundsException("getDataSourceGroup: Index value '" + index + "' not in range [0.." + (this._dataSourceGroupList.size() - 1) + "]");
        }

        return _dataSourceGroupList.get(index);
    }

    /**
     * Method getDataSourceGroup.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public cto.framework.service.schema.DataSourceGroup[] getDataSourceGroup() {
        cto.framework.service.schema.DataSourceGroup[] array = new cto.framework.service.schema.DataSourceGroup[0];
        return this._dataSourceGroupList.toArray(array);
    }

    /**
     * Method getDataSourceGroupCount.
     * 
     * @return the size of this collection
     */
    public int getDataSourceGroupCount() {
        return this._dataSourceGroupList.size();
    }

    /**
     * Returns the value of field 'readWriteDataSource'.
     * 
     * @return the value of field 'ReadWriteDataSource'.
     */
    public cto.framework.service.schema.ReadWriteDataSource getReadWriteDataSource() {
        return this._readWriteDataSource;
    }

    /**
     * Returns the value of field 'singleDataSource'.
     * 
     * @return the value of field 'SingleDataSource'.
     */
    public cto.framework.service.schema.SingleDataSource getSingleDataSource() {
        return this._singleDataSource;
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
     * Method iterateDataSourceGroup.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends cto.framework.service.schema.DataSourceGroup> iterateDataSourceGroup() {
        return this._dataSourceGroupList.iterator();
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
    public void removeAllDataSourceGroup() {
        this._dataSourceGroupList.clear();
    }

    /**
     * Method removeDataSourceGroup.
     * 
     * @param vDataSourceGroup
     * @return true if the object was removed from the collection.
     */
    public boolean removeDataSourceGroup(final cto.framework.service.schema.DataSourceGroup vDataSourceGroup) {
        boolean removed = _dataSourceGroupList.remove(vDataSourceGroup);
        return removed;
    }

    /**
     * Method removeDataSourceGroupAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public cto.framework.service.schema.DataSourceGroup removeDataSourceGroupAt(final int index) {
        java.lang.Object obj = this._dataSourceGroupList.remove(index);
        return (cto.framework.service.schema.DataSourceGroup) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vDataSourceGroup
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setDataSourceGroup(final int index,final cto.framework.service.schema.DataSourceGroup vDataSourceGroup) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._dataSourceGroupList.size()) {
            throw new IndexOutOfBoundsException("setDataSourceGroup: Index value '" + index + "' not in range [0.." + (this._dataSourceGroupList.size() - 1) + "]");
        }

        this._dataSourceGroupList.set(index, vDataSourceGroup);
    }

    /**
     * 
     * 
     * @param vDataSourceGroupArray
     */
    public void setDataSourceGroup(final cto.framework.service.schema.DataSourceGroup[] vDataSourceGroupArray) {
        //-- copy array
        _dataSourceGroupList.clear();

        for (int i = 0; i < vDataSourceGroupArray.length; i++) {
                this._dataSourceGroupList.add(vDataSourceGroupArray[i]);
        }
    }

    /**
     * Sets the value of field 'readWriteDataSource'.
     * 
     * @param readWriteDataSource the value of field
     * 'readWriteDataSource'.
     */
    public void setReadWriteDataSource(final cto.framework.service.schema.ReadWriteDataSource readWriteDataSource) {
        this._readWriteDataSource = readWriteDataSource;
        this._choiceValue = readWriteDataSource;
    }

    /**
     * Sets the value of field 'singleDataSource'.
     * 
     * @param singleDataSource the value of field 'singleDataSource'
     */
    public void setSingleDataSource(final cto.framework.service.schema.SingleDataSource singleDataSource) {
        this._singleDataSource = singleDataSource;
        this._choiceValue = singleDataSource;
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
     * cto.framework.service.schema.SystemDataSourceGroup
     */
    public static cto.framework.service.schema.SystemDataSourceGroup unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (cto.framework.service.schema.SystemDataSourceGroup) org.exolab.castor.xml.Unmarshaller.unmarshal(cto.framework.service.schema.SystemDataSourceGroup.class, reader);
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
