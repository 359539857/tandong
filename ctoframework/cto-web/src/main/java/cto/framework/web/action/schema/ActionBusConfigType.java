/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3-RC1</a>, using an
 * XML Schema.
 * $Id$
 */

package cto.framework.web.action.schema;

/**
 * Class ActionBusConfigType.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ActionBusConfigType implements java.io.Serializable {

    /**
     * Field _defaultUseCacheGroup.
     */
    private java.lang.String _defaultUseCacheGroup;

    /**
     * Field _defaultUseHadoopGroup.
     */
    private java.lang.String _defaultUseHadoopGroup;

    /**
     * Field _importResourceList.
     */
    private java.util.List<cto.framework.web.action.schema.ImportResource> _importResourceList;

    /**
     * Field _parameterList.
     */
    private java.util.List<cto.framework.web.action.schema.Parameter> _parameterList;

    /**
     * Field _hadoopServerGroupList.
     */
    private java.util.List<cto.framework.web.action.schema.HadoopServerGroup> _hadoopServerGroupList;

    /**
     * Field _actionPluginConfig.
     */
    private cto.framework.web.action.schema.ActionPluginConfig _actionPluginConfig;

    /**
     * Field _resultPath.
     */
    private cto.framework.web.action.schema.ResultPath _resultPath;

    public ActionBusConfigType() {
        super();
        this._importResourceList = new java.util.ArrayList<cto.framework.web.action.schema.ImportResource>();
        this._parameterList = new java.util.ArrayList<cto.framework.web.action.schema.Parameter>();
        this._hadoopServerGroupList = new java.util.ArrayList<cto.framework.web.action.schema.HadoopServerGroup>();
    }

    /**
     * 
     * 
     * @param vHadoopServerGroup
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addHadoopServerGroup(final cto.framework.web.action.schema.HadoopServerGroup vHadoopServerGroup) throws java.lang.IndexOutOfBoundsException {
        this._hadoopServerGroupList.add(vHadoopServerGroup);
    }

    /**
     * 
     * 
     * @param index
     * @param vHadoopServerGroup
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addHadoopServerGroup(final int index,final cto.framework.web.action.schema.HadoopServerGroup vHadoopServerGroup) throws java.lang.IndexOutOfBoundsException {
        this._hadoopServerGroupList.add(index, vHadoopServerGroup);
    }

    /**
     * 
     * 
     * @param vImportResource
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addImportResource(final cto.framework.web.action.schema.ImportResource vImportResource) throws java.lang.IndexOutOfBoundsException {
        this._importResourceList.add(vImportResource);
    }

    /**
     * 
     * 
     * @param index
     * @param vImportResource
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addImportResource(final int index,final cto.framework.web.action.schema.ImportResource vImportResource) throws java.lang.IndexOutOfBoundsException {
        this._importResourceList.add(index, vImportResource);
    }

    /**
     * 
     * 
     * @param vParameter
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addParameter(final cto.framework.web.action.schema.Parameter vParameter) throws java.lang.IndexOutOfBoundsException {
        this._parameterList.add(vParameter);
    }

    /**
     * 
     * 
     * @param index
     * @param vParameter
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addParameter(final int index,final cto.framework.web.action.schema.Parameter vParameter) throws java.lang.IndexOutOfBoundsException {
        this._parameterList.add(index, vParameter);
    }

    /**
     * Method enumerateHadoopServerGroup.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends cto.framework.web.action.schema.HadoopServerGroup> enumerateHadoopServerGroup() {
        return java.util.Collections.enumeration(this._hadoopServerGroupList);
    }

    /**
     * Method enumerateImportResource.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends cto.framework.web.action.schema.ImportResource> enumerateImportResource() {
        return java.util.Collections.enumeration(this._importResourceList);
    }

    /**
     * Method enumerateParameter.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends cto.framework.web.action.schema.Parameter> enumerateParameter() {
        return java.util.Collections.enumeration(this._parameterList);
    }

    /**
     * Returns the value of field 'actionPluginConfig'.
     * 
     * @return the value of field 'ActionPluginConfig'.
     */
    public cto.framework.web.action.schema.ActionPluginConfig getActionPluginConfig() {
        return this._actionPluginConfig;
    }

    /**
     * Returns the value of field 'defaultUseCacheGroup'.
     * 
     * @return the value of field 'DefaultUseCacheGroup'.
     */
    public java.lang.String getDefaultUseCacheGroup() {
        return this._defaultUseCacheGroup;
    }

    /**
     * Returns the value of field 'defaultUseHadoopGroup'.
     * 
     * @return the value of field 'DefaultUseHadoopGroup'.
     */
    public java.lang.String getDefaultUseHadoopGroup() {
        return this._defaultUseHadoopGroup;
    }

    /**
     * Method getHadoopServerGroup.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * cto.framework.web.action.schema.HadoopServerGroup at the
     * given index
     */
    public cto.framework.web.action.schema.HadoopServerGroup getHadoopServerGroup(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._hadoopServerGroupList.size()) {
            throw new IndexOutOfBoundsException("getHadoopServerGroup: Index value '" + index + "' not in range [0.." + (this._hadoopServerGroupList.size() - 1) + "]");
        }

        return _hadoopServerGroupList.get(index);
    }

    /**
     * Method getHadoopServerGroup.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public cto.framework.web.action.schema.HadoopServerGroup[] getHadoopServerGroup() {
        cto.framework.web.action.schema.HadoopServerGroup[] array = new cto.framework.web.action.schema.HadoopServerGroup[0];
        return this._hadoopServerGroupList.toArray(array);
    }

    /**
     * Method getHadoopServerGroupCount.
     * 
     * @return the size of this collection
     */
    public int getHadoopServerGroupCount() {
        return this._hadoopServerGroupList.size();
    }

    /**
     * Method getImportResource.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * cto.framework.web.action.schema.ImportResource at the given
     * index
     */
    public cto.framework.web.action.schema.ImportResource getImportResource(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._importResourceList.size()) {
            throw new IndexOutOfBoundsException("getImportResource: Index value '" + index + "' not in range [0.." + (this._importResourceList.size() - 1) + "]");
        }

        return _importResourceList.get(index);
    }

    /**
     * Method getImportResource.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public cto.framework.web.action.schema.ImportResource[] getImportResource() {
        cto.framework.web.action.schema.ImportResource[] array = new cto.framework.web.action.schema.ImportResource[0];
        return this._importResourceList.toArray(array);
    }

    /**
     * Method getImportResourceCount.
     * 
     * @return the size of this collection
     */
    public int getImportResourceCount() {
        return this._importResourceList.size();
    }

    /**
     * Method getParameter.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * cto.framework.web.action.schema.Parameter at the given index
     */
    public cto.framework.web.action.schema.Parameter getParameter(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._parameterList.size()) {
            throw new IndexOutOfBoundsException("getParameter: Index value '" + index + "' not in range [0.." + (this._parameterList.size() - 1) + "]");
        }

        return _parameterList.get(index);
    }

    /**
     * Method getParameter.Returns the contents of the collection
     * in an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public cto.framework.web.action.schema.Parameter[] getParameter() {
        cto.framework.web.action.schema.Parameter[] array = new cto.framework.web.action.schema.Parameter[0];
        return this._parameterList.toArray(array);
    }

    /**
     * Method getParameterCount.
     * 
     * @return the size of this collection
     */
    public int getParameterCount() {
        return this._parameterList.size();
    }

    /**
     * Returns the value of field 'resultPath'.
     * 
     * @return the value of field 'ResultPath'.
     */
    public cto.framework.web.action.schema.ResultPath getResultPath() {
        return this._resultPath;
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
     * Method iterateHadoopServerGroup.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends cto.framework.web.action.schema.HadoopServerGroup> iterateHadoopServerGroup() {
        return this._hadoopServerGroupList.iterator();
    }

    /**
     * Method iterateImportResource.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends cto.framework.web.action.schema.ImportResource> iterateImportResource() {
        return this._importResourceList.iterator();
    }

    /**
     * Method iterateParameter.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends cto.framework.web.action.schema.Parameter> iterateParameter() {
        return this._parameterList.iterator();
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
    public void removeAllHadoopServerGroup() {
        this._hadoopServerGroupList.clear();
    }

    /**
     */
    public void removeAllImportResource() {
        this._importResourceList.clear();
    }

    /**
     */
    public void removeAllParameter() {
        this._parameterList.clear();
    }

    /**
     * Method removeHadoopServerGroup.
     * 
     * @param vHadoopServerGroup
     * @return true if the object was removed from the collection.
     */
    public boolean removeHadoopServerGroup(final cto.framework.web.action.schema.HadoopServerGroup vHadoopServerGroup) {
        boolean removed = _hadoopServerGroupList.remove(vHadoopServerGroup);
        return removed;
    }

    /**
     * Method removeHadoopServerGroupAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public cto.framework.web.action.schema.HadoopServerGroup removeHadoopServerGroupAt(final int index) {
        java.lang.Object obj = this._hadoopServerGroupList.remove(index);
        return (cto.framework.web.action.schema.HadoopServerGroup) obj;
    }

    /**
     * Method removeImportResource.
     * 
     * @param vImportResource
     * @return true if the object was removed from the collection.
     */
    public boolean removeImportResource(final cto.framework.web.action.schema.ImportResource vImportResource) {
        boolean removed = _importResourceList.remove(vImportResource);
        return removed;
    }

    /**
     * Method removeImportResourceAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public cto.framework.web.action.schema.ImportResource removeImportResourceAt(final int index) {
        java.lang.Object obj = this._importResourceList.remove(index);
        return (cto.framework.web.action.schema.ImportResource) obj;
    }

    /**
     * Method removeParameter.
     * 
     * @param vParameter
     * @return true if the object was removed from the collection.
     */
    public boolean removeParameter(final cto.framework.web.action.schema.Parameter vParameter) {
        boolean removed = _parameterList.remove(vParameter);
        return removed;
    }

    /**
     * Method removeParameterAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public cto.framework.web.action.schema.Parameter removeParameterAt(final int index) {
        java.lang.Object obj = this._parameterList.remove(index);
        return (cto.framework.web.action.schema.Parameter) obj;
    }

    /**
     * Sets the value of field 'actionPluginConfig'.
     * 
     * @param actionPluginConfig the value of field
     * 'actionPluginConfig'.
     */
    public void setActionPluginConfig(final cto.framework.web.action.schema.ActionPluginConfig actionPluginConfig) {
        this._actionPluginConfig = actionPluginConfig;
    }

    /**
     * Sets the value of field 'defaultUseCacheGroup'.
     * 
     * @param defaultUseCacheGroup the value of field
     * 'defaultUseCacheGroup'.
     */
    public void setDefaultUseCacheGroup(final java.lang.String defaultUseCacheGroup) {
        this._defaultUseCacheGroup = defaultUseCacheGroup;
    }

    /**
     * Sets the value of field 'defaultUseHadoopGroup'.
     * 
     * @param defaultUseHadoopGroup the value of field
     * 'defaultUseHadoopGroup'.
     */
    public void setDefaultUseHadoopGroup(final java.lang.String defaultUseHadoopGroup) {
        this._defaultUseHadoopGroup = defaultUseHadoopGroup;
    }

    /**
     * 
     * 
     * @param index
     * @param vHadoopServerGroup
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setHadoopServerGroup(final int index,final cto.framework.web.action.schema.HadoopServerGroup vHadoopServerGroup) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._hadoopServerGroupList.size()) {
            throw new IndexOutOfBoundsException("setHadoopServerGroup: Index value '" + index + "' not in range [0.." + (this._hadoopServerGroupList.size() - 1) + "]");
        }

        this._hadoopServerGroupList.set(index, vHadoopServerGroup);
    }

    /**
     * 
     * 
     * @param vHadoopServerGroupArray
     */
    public void setHadoopServerGroup(final cto.framework.web.action.schema.HadoopServerGroup[] vHadoopServerGroupArray) {
        //-- copy array
        _hadoopServerGroupList.clear();

        for (int i = 0; i < vHadoopServerGroupArray.length; i++) {
                this._hadoopServerGroupList.add(vHadoopServerGroupArray[i]);
        }
    }

    /**
     * 
     * 
     * @param index
     * @param vImportResource
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setImportResource(final int index,final cto.framework.web.action.schema.ImportResource vImportResource) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._importResourceList.size()) {
            throw new IndexOutOfBoundsException("setImportResource: Index value '" + index + "' not in range [0.." + (this._importResourceList.size() - 1) + "]");
        }

        this._importResourceList.set(index, vImportResource);
    }

    /**
     * 
     * 
     * @param vImportResourceArray
     */
    public void setImportResource(final cto.framework.web.action.schema.ImportResource[] vImportResourceArray) {
        //-- copy array
        _importResourceList.clear();

        for (int i = 0; i < vImportResourceArray.length; i++) {
                this._importResourceList.add(vImportResourceArray[i]);
        }
    }

    /**
     * 
     * 
     * @param index
     * @param vParameter
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setParameter(final int index,final cto.framework.web.action.schema.Parameter vParameter) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._parameterList.size()) {
            throw new IndexOutOfBoundsException("setParameter: Index value '" + index + "' not in range [0.." + (this._parameterList.size() - 1) + "]");
        }

        this._parameterList.set(index, vParameter);
    }

    /**
     * 
     * 
     * @param vParameterArray
     */
    public void setParameter(final cto.framework.web.action.schema.Parameter[] vParameterArray) {
        //-- copy array
        _parameterList.clear();

        for (int i = 0; i < vParameterArray.length; i++) {
                this._parameterList.add(vParameterArray[i]);
        }
    }

    /**
     * Sets the value of field 'resultPath'.
     * 
     * @param resultPath the value of field 'resultPath'.
     */
    public void setResultPath(final cto.framework.web.action.schema.ResultPath resultPath) {
        this._resultPath = resultPath;
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
     * cto.framework.web.action.schema.ActionBusConfigType
     */
    public static cto.framework.web.action.schema.ActionBusConfigType unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (cto.framework.web.action.schema.ActionBusConfigType) org.exolab.castor.xml.Unmarshaller.unmarshal(cto.framework.web.action.schema.ActionBusConfigType.class, reader);
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
