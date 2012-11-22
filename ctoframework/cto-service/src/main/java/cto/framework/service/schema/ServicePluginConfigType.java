/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3-RC1</a>, using an
 * XML Schema.
 * $Id$
 */

package cto.framework.service.schema;

/**
 * Class ServicePluginConfigType.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ServicePluginConfigType implements java.io.Serializable {

    /**
     * Field _autoScanPath.
     */
    private java.lang.String _autoScanPath;

    /**
     * Field _pluginXMLResourceList.
     */
    private java.util.List<cto.framework.service.schema.PluginXMLResource> _pluginXMLResourceList;

    public ServicePluginConfigType() {
        super();
        this._pluginXMLResourceList = new java.util.ArrayList<cto.framework.service.schema.PluginXMLResource>();
    }

    /**
     * 
     * 
     * @param vPluginXMLResource
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addPluginXMLResource(final cto.framework.service.schema.PluginXMLResource vPluginXMLResource) throws java.lang.IndexOutOfBoundsException {
        this._pluginXMLResourceList.add(vPluginXMLResource);
    }

    /**
     * 
     * 
     * @param index
     * @param vPluginXMLResource
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addPluginXMLResource(final int index,final cto.framework.service.schema.PluginXMLResource vPluginXMLResource) throws java.lang.IndexOutOfBoundsException {
        this._pluginXMLResourceList.add(index, vPluginXMLResource);
    }

    /**
     * Method enumeratePluginXMLResource.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends cto.framework.service.schema.PluginXMLResource> enumeratePluginXMLResource() {
        return java.util.Collections.enumeration(this._pluginXMLResourceList);
    }

    /**
     * Returns the value of field 'autoScanPath'.
     * 
     * @return the value of field 'AutoScanPath'.
     */
    public java.lang.String getAutoScanPath() {
        return this._autoScanPath;
    }

    /**
     * Method getPluginXMLResource.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * cto.framework.service.schema.PluginXMLResource at the given
     * index
     */
    public cto.framework.service.schema.PluginXMLResource getPluginXMLResource(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._pluginXMLResourceList.size()) {
            throw new IndexOutOfBoundsException("getPluginXMLResource: Index value '" + index + "' not in range [0.." + (this._pluginXMLResourceList.size() - 1) + "]");
        }

        return _pluginXMLResourceList.get(index);
    }

    /**
     * Method getPluginXMLResource.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public cto.framework.service.schema.PluginXMLResource[] getPluginXMLResource() {
        cto.framework.service.schema.PluginXMLResource[] array = new cto.framework.service.schema.PluginXMLResource[0];
        return this._pluginXMLResourceList.toArray(array);
    }

    /**
     * Method getPluginXMLResourceCount.
     * 
     * @return the size of this collection
     */
    public int getPluginXMLResourceCount() {
        return this._pluginXMLResourceList.size();
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
     * Method iteratePluginXMLResource.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends cto.framework.service.schema.PluginXMLResource> iteratePluginXMLResource() {
        return this._pluginXMLResourceList.iterator();
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
    public void removeAllPluginXMLResource() {
        this._pluginXMLResourceList.clear();
    }

    /**
     * Method removePluginXMLResource.
     * 
     * @param vPluginXMLResource
     * @return true if the object was removed from the collection.
     */
    public boolean removePluginXMLResource(final cto.framework.service.schema.PluginXMLResource vPluginXMLResource) {
        boolean removed = _pluginXMLResourceList.remove(vPluginXMLResource);
        return removed;
    }

    /**
     * Method removePluginXMLResourceAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public cto.framework.service.schema.PluginXMLResource removePluginXMLResourceAt(final int index) {
        java.lang.Object obj = this._pluginXMLResourceList.remove(index);
        return (cto.framework.service.schema.PluginXMLResource) obj;
    }

    /**
     * Sets the value of field 'autoScanPath'.
     * 
     * @param autoScanPath the value of field 'autoScanPath'.
     */
    public void setAutoScanPath(final java.lang.String autoScanPath) {
        this._autoScanPath = autoScanPath;
    }

    /**
     * 
     * 
     * @param index
     * @param vPluginXMLResource
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setPluginXMLResource(final int index,final cto.framework.service.schema.PluginXMLResource vPluginXMLResource) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._pluginXMLResourceList.size()) {
            throw new IndexOutOfBoundsException("setPluginXMLResource: Index value '" + index + "' not in range [0.." + (this._pluginXMLResourceList.size() - 1) + "]");
        }

        this._pluginXMLResourceList.set(index, vPluginXMLResource);
    }

    /**
     * 
     * 
     * @param vPluginXMLResourceArray
     */
    public void setPluginXMLResource(final cto.framework.service.schema.PluginXMLResource[] vPluginXMLResourceArray) {
        //-- copy array
        _pluginXMLResourceList.clear();

        for (int i = 0; i < vPluginXMLResourceArray.length; i++) {
                this._pluginXMLResourceList.add(vPluginXMLResourceArray[i]);
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
     * cto.framework.service.schema.ServicePluginConfigType
     */
    public static cto.framework.service.schema.ServicePluginConfigType unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (cto.framework.service.schema.ServicePluginConfigType) org.exolab.castor.xml.Unmarshaller.unmarshal(cto.framework.service.schema.ServicePluginConfigType.class, reader);
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
