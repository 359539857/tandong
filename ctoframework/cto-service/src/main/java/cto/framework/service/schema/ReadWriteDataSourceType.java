/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3-RC1</a>, using an
 * XML Schema.
 * $Id$
 */

package cto.framework.service.schema;

/**
 * Class ReadWriteDataSourceType.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ReadWriteDataSourceType implements java.io.Serializable {

    /**
     * Field _dataSourceList.
     */
    private java.util.List<cto.framework.service.schema.DataSource> _dataSourceList;

    public ReadWriteDataSourceType() {
        super();
        this._dataSourceList = new java.util.ArrayList<cto.framework.service.schema.DataSource>();
    }

    /**
     * 
     * 
     * @param vDataSource
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addDataSource(final cto.framework.service.schema.DataSource vDataSource) throws java.lang.IndexOutOfBoundsException {
        // check for the maximum size
        if (this._dataSourceList.size() >= 2) {
            throw new IndexOutOfBoundsException("addDataSource has a maximum of 2");
        }

        this._dataSourceList.add(vDataSource);
    }

    /**
     * 
     * 
     * @param index
     * @param vDataSource
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addDataSource(final int index,final cto.framework.service.schema.DataSource vDataSource) throws java.lang.IndexOutOfBoundsException {
        // check for the maximum size
        if (this._dataSourceList.size() >= 2) {
            throw new IndexOutOfBoundsException("addDataSource has a maximum of 2");
        }

        this._dataSourceList.add(index, vDataSource);
    }

    /**
     * Method enumerateDataSource.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends cto.framework.service.schema.DataSource> enumerateDataSource() {
        return java.util.Collections.enumeration(this._dataSourceList);
    }

    /**
     * Method getDataSource.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * cto.framework.service.schema.DataSource at the given index
     */
    public cto.framework.service.schema.DataSource getDataSource(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._dataSourceList.size()) {
            throw new IndexOutOfBoundsException("getDataSource: Index value '" + index + "' not in range [0.." + (this._dataSourceList.size() - 1) + "]");
        }

        return _dataSourceList.get(index);
    }

    /**
     * Method getDataSource.Returns the contents of the collection
     * in an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public cto.framework.service.schema.DataSource[] getDataSource() {
        cto.framework.service.schema.DataSource[] array = new cto.framework.service.schema.DataSource[0];
        return this._dataSourceList.toArray(array);
    }

    /**
     * Method getDataSourceCount.
     * 
     * @return the size of this collection
     */
    public int getDataSourceCount() {
        return this._dataSourceList.size();
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
     * Method iterateDataSource.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends cto.framework.service.schema.DataSource> iterateDataSource() {
        return this._dataSourceList.iterator();
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
    public void removeAllDataSource() {
        this._dataSourceList.clear();
    }

    /**
     * Method removeDataSource.
     * 
     * @param vDataSource
     * @return true if the object was removed from the collection.
     */
    public boolean removeDataSource(final cto.framework.service.schema.DataSource vDataSource) {
        boolean removed = _dataSourceList.remove(vDataSource);
        return removed;
    }

    /**
     * Method removeDataSourceAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public cto.framework.service.schema.DataSource removeDataSourceAt(final int index) {
        java.lang.Object obj = this._dataSourceList.remove(index);
        return (cto.framework.service.schema.DataSource) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vDataSource
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setDataSource(final int index,final cto.framework.service.schema.DataSource vDataSource) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._dataSourceList.size()) {
            throw new IndexOutOfBoundsException("setDataSource: Index value '" + index + "' not in range [0.." + (this._dataSourceList.size() - 1) + "]");
        }

        this._dataSourceList.set(index, vDataSource);
    }

    /**
     * 
     * 
     * @param vDataSourceArray
     */
    public void setDataSource(final cto.framework.service.schema.DataSource[] vDataSourceArray) {
        //-- copy array
        _dataSourceList.clear();

        for (int i = 0; i < vDataSourceArray.length; i++) {
                this._dataSourceList.add(vDataSourceArray[i]);
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
     * cto.framework.service.schema.ReadWriteDataSourceType
     */
    public static cto.framework.service.schema.ReadWriteDataSourceType unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (cto.framework.service.schema.ReadWriteDataSourceType) org.exolab.castor.xml.Unmarshaller.unmarshal(cto.framework.service.schema.ReadWriteDataSourceType.class, reader);
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
