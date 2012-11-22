/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3-RC1</a>, using an
 * XML Schema.
 * $Id$
 */

package cto.framework.service.schema;

/**
 * Class MemCacheServerGroupType.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class MemCacheServerGroupType implements java.io.Serializable {

    /**
     * Field _id.
     */
    private java.lang.String _id;

    /**
     * Field _cacheServerList.
     */
    private java.util.List<cto.framework.service.schema.CacheServer> _cacheServerList;

    public MemCacheServerGroupType() {
        super();
        this._cacheServerList = new java.util.ArrayList<cto.framework.service.schema.CacheServer>();
    }

    /**
     * 
     * 
     * @param vCacheServer
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCacheServer(final cto.framework.service.schema.CacheServer vCacheServer) throws java.lang.IndexOutOfBoundsException {
        this._cacheServerList.add(vCacheServer);
    }

    /**
     * 
     * 
     * @param index
     * @param vCacheServer
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCacheServer(final int index,final cto.framework.service.schema.CacheServer vCacheServer) throws java.lang.IndexOutOfBoundsException {
        this._cacheServerList.add(index, vCacheServer);
    }

    /**
     * Method enumerateCacheServer.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends cto.framework.service.schema.CacheServer> enumerateCacheServer() {
        return java.util.Collections.enumeration(this._cacheServerList);
    }

    /**
     * Method getCacheServer.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * cto.framework.service.schema.CacheServer at the given index
     */
    public cto.framework.service.schema.CacheServer getCacheServer(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._cacheServerList.size()) {
            throw new IndexOutOfBoundsException("getCacheServer: Index value '" + index + "' not in range [0.." + (this._cacheServerList.size() - 1) + "]");
        }

        return _cacheServerList.get(index);
    }

    /**
     * Method getCacheServer.Returns the contents of the collection
     * in an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public cto.framework.service.schema.CacheServer[] getCacheServer() {
        cto.framework.service.schema.CacheServer[] array = new cto.framework.service.schema.CacheServer[0];
        return this._cacheServerList.toArray(array);
    }

    /**
     * Method getCacheServerCount.
     * 
     * @return the size of this collection
     */
    public int getCacheServerCount() {
        return this._cacheServerList.size();
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
     * Method iterateCacheServer.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends cto.framework.service.schema.CacheServer> iterateCacheServer() {
        return this._cacheServerList.iterator();
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
    public void removeAllCacheServer() {
        this._cacheServerList.clear();
    }

    /**
     * Method removeCacheServer.
     * 
     * @param vCacheServer
     * @return true if the object was removed from the collection.
     */
    public boolean removeCacheServer(final cto.framework.service.schema.CacheServer vCacheServer) {
        boolean removed = _cacheServerList.remove(vCacheServer);
        return removed;
    }

    /**
     * Method removeCacheServerAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public cto.framework.service.schema.CacheServer removeCacheServerAt(final int index) {
        java.lang.Object obj = this._cacheServerList.remove(index);
        return (cto.framework.service.schema.CacheServer) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vCacheServer
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setCacheServer(final int index,final cto.framework.service.schema.CacheServer vCacheServer) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._cacheServerList.size()) {
            throw new IndexOutOfBoundsException("setCacheServer: Index value '" + index + "' not in range [0.." + (this._cacheServerList.size() - 1) + "]");
        }

        this._cacheServerList.set(index, vCacheServer);
    }

    /**
     * 
     * 
     * @param vCacheServerArray
     */
    public void setCacheServer(final cto.framework.service.schema.CacheServer[] vCacheServerArray) {
        //-- copy array
        _cacheServerList.clear();

        for (int i = 0; i < vCacheServerArray.length; i++) {
                this._cacheServerList.add(vCacheServerArray[i]);
        }
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
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled
     * cto.framework.service.schema.MemCacheServerGroupType
     */
    public static cto.framework.service.schema.MemCacheServerGroupType unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (cto.framework.service.schema.MemCacheServerGroupType) org.exolab.castor.xml.Unmarshaller.unmarshal(cto.framework.service.schema.MemCacheServerGroupType.class, reader);
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
