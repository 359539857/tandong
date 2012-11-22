/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3-RC1</a>, using an
 * XML Schema.
 * $Id$
 */

package cto.framework.service.plugin.schema;

/**
 * Class InvokeType.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class InvokeType implements java.io.Serializable {

    /**
     * Field _name.
     */
    private java.lang.String _name;

    /**
     * Field _classType.
     */
    private java.lang.String _classType;

    /**
     * Field _method.
     */
    private java.lang.String _method;

    /**
     * Field _outputId.
     */
    private java.lang.String _outputId;

    /**
     * Field _methodParameterList.
     */
    private java.util.List<cto.framework.service.plugin.schema.MethodParameter> _methodParameterList;

    public InvokeType() {
        super();
        this._methodParameterList = new java.util.ArrayList<cto.framework.service.plugin.schema.MethodParameter>();
    }

    /**
     * 
     * 
     * @param vMethodParameter
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addMethodParameter(final cto.framework.service.plugin.schema.MethodParameter vMethodParameter) throws java.lang.IndexOutOfBoundsException {
        this._methodParameterList.add(vMethodParameter);
    }

    /**
     * 
     * 
     * @param index
     * @param vMethodParameter
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addMethodParameter(final int index,final cto.framework.service.plugin.schema.MethodParameter vMethodParameter) throws java.lang.IndexOutOfBoundsException {
        this._methodParameterList.add(index, vMethodParameter);
    }

    /**
     * Method enumerateMethodParameter.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends cto.framework.service.plugin.schema.MethodParameter> enumerateMethodParameter() {
        return java.util.Collections.enumeration(this._methodParameterList);
    }

    /**
     * Returns the value of field 'classType'.
     * 
     * @return the value of field 'ClassType'.
     */
    public java.lang.String getClassType() {
        return this._classType;
    }

    /**
     * Returns the value of field 'method'.
     * 
     * @return the value of field 'Method'.
     */
    public java.lang.String getMethod() {
        return this._method;
    }

    /**
     * Method getMethodParameter.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * cto.framework.service.plugin.schema.MethodParameter at the
     * given index
     */
    public cto.framework.service.plugin.schema.MethodParameter getMethodParameter(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._methodParameterList.size()) {
            throw new IndexOutOfBoundsException("getMethodParameter: Index value '" + index + "' not in range [0.." + (this._methodParameterList.size() - 1) + "]");
        }

        return _methodParameterList.get(index);
    }

    /**
     * Method getMethodParameter.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public cto.framework.service.plugin.schema.MethodParameter[] getMethodParameter() {
        cto.framework.service.plugin.schema.MethodParameter[] array = new cto.framework.service.plugin.schema.MethodParameter[0];
        return this._methodParameterList.toArray(array);
    }

    /**
     * Method getMethodParameterCount.
     * 
     * @return the size of this collection
     */
    public int getMethodParameterCount() {
        return this._methodParameterList.size();
    }

    /**
     * Returns the value of field 'name'.
     * 
     * @return the value of field 'Name'.
     */
    public java.lang.String getName() {
        return this._name;
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
     * Method iterateMethodParameter.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends cto.framework.service.plugin.schema.MethodParameter> iterateMethodParameter() {
        return this._methodParameterList.iterator();
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
    public void removeAllMethodParameter() {
        this._methodParameterList.clear();
    }

    /**
     * Method removeMethodParameter.
     * 
     * @param vMethodParameter
     * @return true if the object was removed from the collection.
     */
    public boolean removeMethodParameter(final cto.framework.service.plugin.schema.MethodParameter vMethodParameter) {
        boolean removed = _methodParameterList.remove(vMethodParameter);
        return removed;
    }

    /**
     * Method removeMethodParameterAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public cto.framework.service.plugin.schema.MethodParameter removeMethodParameterAt(final int index) {
        java.lang.Object obj = this._methodParameterList.remove(index);
        return (cto.framework.service.plugin.schema.MethodParameter) obj;
    }

    /**
     * Sets the value of field 'classType'.
     * 
     * @param classType the value of field 'classType'.
     */
    public void setClassType(final java.lang.String classType) {
        this._classType = classType;
    }

    /**
     * Sets the value of field 'method'.
     * 
     * @param method the value of field 'method'.
     */
    public void setMethod(final java.lang.String method) {
        this._method = method;
    }

    /**
     * 
     * 
     * @param index
     * @param vMethodParameter
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setMethodParameter(final int index,final cto.framework.service.plugin.schema.MethodParameter vMethodParameter) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._methodParameterList.size()) {
            throw new IndexOutOfBoundsException("setMethodParameter: Index value '" + index + "' not in range [0.." + (this._methodParameterList.size() - 1) + "]");
        }

        this._methodParameterList.set(index, vMethodParameter);
    }

    /**
     * 
     * 
     * @param vMethodParameterArray
     */
    public void setMethodParameter(final cto.framework.service.plugin.schema.MethodParameter[] vMethodParameterArray) {
        //-- copy array
        _methodParameterList.clear();

        for (int i = 0; i < vMethodParameterArray.length; i++) {
                this._methodParameterList.add(vMethodParameterArray[i]);
        }
    }

    /**
     * Sets the value of field 'name'.
     * 
     * @param name the value of field 'name'.
     */
    public void setName(final java.lang.String name) {
        this._name = name;
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
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled
     * cto.framework.service.plugin.schema.InvokeType
     */
    public static cto.framework.service.plugin.schema.InvokeType unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (cto.framework.service.plugin.schema.InvokeType) org.exolab.castor.xml.Unmarshaller.unmarshal(cto.framework.service.plugin.schema.InvokeType.class, reader);
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
