/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3-RC1</a>, using an
 * XML Schema.
 * $Id$
 */

package cto.framework.service.schema;

/**
 * Class CacheServerType.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CacheServerType implements java.io.Serializable {

    /**
     * Field _id.
     */
    private java.lang.String _id;

    /**
     * Field _maxIdleTime.
     */
    private int _maxIdleTime;

    /**
     * keeps track of state for field: _maxIdleTime
     */
    private boolean _has_maxIdleTime;

    /**
     * Field _minConnCount.
     */
    private int _minConnCount;

    /**
     * keeps track of state for field: _minConnCount
     */
    private boolean _has_minConnCount;

    /**
     * Field _maxConnCount.
     */
    private int _maxConnCount;

    /**
     * keeps track of state for field: _maxConnCount
     */
    private boolean _has_maxConnCount;

    /**
     * Field _initConnCount.
     */
    private int _initConnCount;

    /**
     * keeps track of state for field: _initConnCount
     */
    private boolean _has_initConnCount;

    /**
     * Field _serverList.
     */
    private java.util.List<cto.framework.service.schema.Server> _serverList;

    public CacheServerType() {
        super();
        this._serverList = new java.util.ArrayList<cto.framework.service.schema.Server>();
    }

    /**
     * 
     * 
     * @param vServer
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addServer(final cto.framework.service.schema.Server vServer) throws java.lang.IndexOutOfBoundsException {
        this._serverList.add(vServer);
    }

    /**
     * 
     * 
     * @param index
     * @param vServer
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addServer(final int index,final cto.framework.service.schema.Server vServer) throws java.lang.IndexOutOfBoundsException {
        this._serverList.add(index, vServer);
    }

    /**
     */
    public void deleteInitConnCount() {
        this._has_initConnCount= false;
    }

    /**
     */
    public void deleteMaxConnCount() {
        this._has_maxConnCount= false;
    }

    /**
     */
    public void deleteMaxIdleTime() {
        this._has_maxIdleTime= false;
    }

    /**
     */
    public void deleteMinConnCount() {
        this._has_minConnCount= false;
    }

    /**
     * Method enumerateServer.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends cto.framework.service.schema.Server> enumerateServer() {
        return java.util.Collections.enumeration(this._serverList);
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
     * Returns the value of field 'initConnCount'.
     * 
     * @return the value of field 'InitConnCount'.
     */
    public int getInitConnCount() {
        return this._initConnCount;
    }

    /**
     * Returns the value of field 'maxConnCount'.
     * 
     * @return the value of field 'MaxConnCount'.
     */
    public int getMaxConnCount() {
        return this._maxConnCount;
    }

    /**
     * Returns the value of field 'maxIdleTime'.
     * 
     * @return the value of field 'MaxIdleTime'.
     */
    public int getMaxIdleTime() {
        return this._maxIdleTime;
    }

    /**
     * Returns the value of field 'minConnCount'.
     * 
     * @return the value of field 'MinConnCount'.
     */
    public int getMinConnCount() {
        return this._minConnCount;
    }

    /**
     * Method getServer.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the cto.framework.service.schema.Server
     * at the given index
     */
    public cto.framework.service.schema.Server getServer(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._serverList.size()) {
            throw new IndexOutOfBoundsException("getServer: Index value '" + index + "' not in range [0.." + (this._serverList.size() - 1) + "]");
        }

        return _serverList.get(index);
    }

    /**
     * Method getServer.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public cto.framework.service.schema.Server[] getServer() {
        cto.framework.service.schema.Server[] array = new cto.framework.service.schema.Server[0];
        return this._serverList.toArray(array);
    }

    /**
     * Method getServerCount.
     * 
     * @return the size of this collection
     */
    public int getServerCount() {
        return this._serverList.size();
    }

    /**
     * Method hasInitConnCount.
     * 
     * @return true if at least one InitConnCount has been added
     */
    public boolean hasInitConnCount() {
        return this._has_initConnCount;
    }

    /**
     * Method hasMaxConnCount.
     * 
     * @return true if at least one MaxConnCount has been added
     */
    public boolean hasMaxConnCount() {
        return this._has_maxConnCount;
    }

    /**
     * Method hasMaxIdleTime.
     * 
     * @return true if at least one MaxIdleTime has been added
     */
    public boolean hasMaxIdleTime() {
        return this._has_maxIdleTime;
    }

    /**
     * Method hasMinConnCount.
     * 
     * @return true if at least one MinConnCount has been added
     */
    public boolean hasMinConnCount() {
        return this._has_minConnCount;
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
     * Method iterateServer.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends cto.framework.service.schema.Server> iterateServer() {
        return this._serverList.iterator();
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
    public void removeAllServer() {
        this._serverList.clear();
    }

    /**
     * Method removeServer.
     * 
     * @param vServer
     * @return true if the object was removed from the collection.
     */
    public boolean removeServer(final cto.framework.service.schema.Server vServer) {
        boolean removed = _serverList.remove(vServer);
        return removed;
    }

    /**
     * Method removeServerAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public cto.framework.service.schema.Server removeServerAt(final int index) {
        java.lang.Object obj = this._serverList.remove(index);
        return (cto.framework.service.schema.Server) obj;
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
     * Sets the value of field 'initConnCount'.
     * 
     * @param initConnCount the value of field 'initConnCount'.
     */
    public void setInitConnCount(final int initConnCount) {
        this._initConnCount = initConnCount;
        this._has_initConnCount = true;
    }

    /**
     * Sets the value of field 'maxConnCount'.
     * 
     * @param maxConnCount the value of field 'maxConnCount'.
     */
    public void setMaxConnCount(final int maxConnCount) {
        this._maxConnCount = maxConnCount;
        this._has_maxConnCount = true;
    }

    /**
     * Sets the value of field 'maxIdleTime'.
     * 
     * @param maxIdleTime the value of field 'maxIdleTime'.
     */
    public void setMaxIdleTime(final int maxIdleTime) {
        this._maxIdleTime = maxIdleTime;
        this._has_maxIdleTime = true;
    }

    /**
     * Sets the value of field 'minConnCount'.
     * 
     * @param minConnCount the value of field 'minConnCount'.
     */
    public void setMinConnCount(final int minConnCount) {
        this._minConnCount = minConnCount;
        this._has_minConnCount = true;
    }

    /**
     * 
     * 
     * @param index
     * @param vServer
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setServer(final int index,final cto.framework.service.schema.Server vServer) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._serverList.size()) {
            throw new IndexOutOfBoundsException("setServer: Index value '" + index + "' not in range [0.." + (this._serverList.size() - 1) + "]");
        }

        this._serverList.set(index, vServer);
    }

    /**
     * 
     * 
     * @param vServerArray
     */
    public void setServer(final cto.framework.service.schema.Server[] vServerArray) {
        //-- copy array
        _serverList.clear();

        for (int i = 0; i < vServerArray.length; i++) {
                this._serverList.add(vServerArray[i]);
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
     * cto.framework.service.schema.CacheServerType
     */
    public static cto.framework.service.schema.CacheServerType unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (cto.framework.service.schema.CacheServerType) org.exolab.castor.xml.Unmarshaller.unmarshal(cto.framework.service.schema.CacheServerType.class, reader);
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
