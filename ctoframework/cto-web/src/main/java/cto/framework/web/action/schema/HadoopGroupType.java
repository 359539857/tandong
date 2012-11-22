/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3-RC1</a>, using an
 * XML Schema.
 * $Id$
 */

package cto.framework.web.action.schema;

/**
 * Class HadoopGroupType.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class HadoopGroupType implements java.io.Serializable {

    /**
     * Field _id.
     */
    private java.lang.String _id;

    /**
     * Field _hadoopServerList.
     */
    private java.util.List<cto.framework.web.action.schema.HadoopServer> _hadoopServerList;

    public HadoopGroupType() {
        super();
        this._hadoopServerList = new java.util.ArrayList<cto.framework.web.action.schema.HadoopServer>();
    }

    /**
     * 
     * 
     * @param vHadoopServer
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addHadoopServer(final cto.framework.web.action.schema.HadoopServer vHadoopServer) throws java.lang.IndexOutOfBoundsException {
        this._hadoopServerList.add(vHadoopServer);
    }

    /**
     * 
     * 
     * @param index
     * @param vHadoopServer
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addHadoopServer(final int index,final cto.framework.web.action.schema.HadoopServer vHadoopServer) throws java.lang.IndexOutOfBoundsException {
        this._hadoopServerList.add(index, vHadoopServer);
    }

    /**
     * Method enumerateHadoopServer.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends cto.framework.web.action.schema.HadoopServer> enumerateHadoopServer() {
        return java.util.Collections.enumeration(this._hadoopServerList);
    }

    /**
     * Method getHadoopServer.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * cto.framework.web.action.schema.HadoopServer at the given
     * index
     */
    public cto.framework.web.action.schema.HadoopServer getHadoopServer(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._hadoopServerList.size()) {
            throw new IndexOutOfBoundsException("getHadoopServer: Index value '" + index + "' not in range [0.." + (this._hadoopServerList.size() - 1) + "]");
        }

        return _hadoopServerList.get(index);
    }

    /**
     * Method getHadoopServer.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public cto.framework.web.action.schema.HadoopServer[] getHadoopServer() {
        cto.framework.web.action.schema.HadoopServer[] array = new cto.framework.web.action.schema.HadoopServer[0];
        return this._hadoopServerList.toArray(array);
    }

    /**
     * Method getHadoopServerCount.
     * 
     * @return the size of this collection
     */
    public int getHadoopServerCount() {
        return this._hadoopServerList.size();
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
     * Method iterateHadoopServer.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends cto.framework.web.action.schema.HadoopServer> iterateHadoopServer() {
        return this._hadoopServerList.iterator();
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
    public void removeAllHadoopServer() {
        this._hadoopServerList.clear();
    }

    /**
     * Method removeHadoopServer.
     * 
     * @param vHadoopServer
     * @return true if the object was removed from the collection.
     */
    public boolean removeHadoopServer(final cto.framework.web.action.schema.HadoopServer vHadoopServer) {
        boolean removed = _hadoopServerList.remove(vHadoopServer);
        return removed;
    }

    /**
     * Method removeHadoopServerAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public cto.framework.web.action.schema.HadoopServer removeHadoopServerAt(final int index) {
        java.lang.Object obj = this._hadoopServerList.remove(index);
        return (cto.framework.web.action.schema.HadoopServer) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vHadoopServer
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setHadoopServer(final int index,final cto.framework.web.action.schema.HadoopServer vHadoopServer) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._hadoopServerList.size()) {
            throw new IndexOutOfBoundsException("setHadoopServer: Index value '" + index + "' not in range [0.." + (this._hadoopServerList.size() - 1) + "]");
        }

        this._hadoopServerList.set(index, vHadoopServer);
    }

    /**
     * 
     * 
     * @param vHadoopServerArray
     */
    public void setHadoopServer(final cto.framework.web.action.schema.HadoopServer[] vHadoopServerArray) {
        //-- copy array
        _hadoopServerList.clear();

        for (int i = 0; i < vHadoopServerArray.length; i++) {
                this._hadoopServerList.add(vHadoopServerArray[i]);
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
     * cto.framework.web.action.schema.HadoopGroupType
     */
    public static cto.framework.web.action.schema.HadoopGroupType unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (cto.framework.web.action.schema.HadoopGroupType) org.exolab.castor.xml.Unmarshaller.unmarshal(cto.framework.web.action.schema.HadoopGroupType.class, reader);
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
