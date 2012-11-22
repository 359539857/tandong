/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3-RC1</a>, using an
 * XML Schema.
 * $Id$
 */

package cto.framework.web.action.plugin.schema;

/**
 * Class ActionType.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ActionType implements java.io.Serializable {

    /**
     * Field _name.
     */
    private java.lang.String _name;

    /**
     * Field _description.
     */
    private java.lang.String _description;

    /**
     * Field _parameterList.
     */
    private java.util.List<cto.framework.web.action.plugin.schema.Parameter> _parameterList;

    /**
     * Field _transList.
     */
    private java.util.List<cto.framework.web.action.plugin.schema.Trans> _transList;

    public ActionType() {
        super();
        this._parameterList = new java.util.ArrayList<cto.framework.web.action.plugin.schema.Parameter>();
        this._transList = new java.util.ArrayList<cto.framework.web.action.plugin.schema.Trans>();
    }

    /**
     * 
     * 
     * @param vParameter
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addParameter(final cto.framework.web.action.plugin.schema.Parameter vParameter) throws java.lang.IndexOutOfBoundsException {
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
    public void addParameter(final int index,final cto.framework.web.action.plugin.schema.Parameter vParameter) throws java.lang.IndexOutOfBoundsException {
        this._parameterList.add(index, vParameter);
    }

    /**
     * 
     * 
     * @param vTrans
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addTrans(final cto.framework.web.action.plugin.schema.Trans vTrans) throws java.lang.IndexOutOfBoundsException {
        this._transList.add(vTrans);
    }

    /**
     * 
     * 
     * @param index
     * @param vTrans
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addTrans(final int index,final cto.framework.web.action.plugin.schema.Trans vTrans) throws java.lang.IndexOutOfBoundsException {
        this._transList.add(index, vTrans);
    }

    /**
     * Method enumerateParameter.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends cto.framework.web.action.plugin.schema.Parameter> enumerateParameter() {
        return java.util.Collections.enumeration(this._parameterList);
    }

    /**
     * Method enumerateTrans.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends cto.framework.web.action.plugin.schema.Trans> enumerateTrans() {
        return java.util.Collections.enumeration(this._transList);
    }

    /**
     * Returns the value of field 'description'.
     * 
     * @return the value of field 'Description'.
     */
    public java.lang.String getDescription() {
        return this._description;
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
     * Method getParameter.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * cto.framework.web.action.plugin.schema.Parameter at the
     * given index
     */
    public cto.framework.web.action.plugin.schema.Parameter getParameter(final int index) throws java.lang.IndexOutOfBoundsException {
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
    public cto.framework.web.action.plugin.schema.Parameter[] getParameter() {
        cto.framework.web.action.plugin.schema.Parameter[] array = new cto.framework.web.action.plugin.schema.Parameter[0];
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
     * Method getTrans.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * cto.framework.web.action.plugin.schema.Trans at the given
     * index
     */
    public cto.framework.web.action.plugin.schema.Trans getTrans(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._transList.size()) {
            throw new IndexOutOfBoundsException("getTrans: Index value '" + index + "' not in range [0.." + (this._transList.size() - 1) + "]");
        }

        return _transList.get(index);
    }

    /**
     * Method getTrans.Returns the contents of the collection in an
     * Array.  <p>Note:  Just in case the collection contents are
     * changing in another thread, we pass a 0-length Array of the
     * correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public cto.framework.web.action.plugin.schema.Trans[] getTrans() {
        cto.framework.web.action.plugin.schema.Trans[] array = new cto.framework.web.action.plugin.schema.Trans[0];
        return this._transList.toArray(array);
    }

    /**
     * Method getTransCount.
     * 
     * @return the size of this collection
     */
    public int getTransCount() {
        return this._transList.size();
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
     * Method iterateParameter.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends cto.framework.web.action.plugin.schema.Parameter> iterateParameter() {
        return this._parameterList.iterator();
    }

    /**
     * Method iterateTrans.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends cto.framework.web.action.plugin.schema.Trans> iterateTrans() {
        return this._transList.iterator();
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
    public void removeAllParameter() {
        this._parameterList.clear();
    }

    /**
     */
    public void removeAllTrans() {
        this._transList.clear();
    }

    /**
     * Method removeParameter.
     * 
     * @param vParameter
     * @return true if the object was removed from the collection.
     */
    public boolean removeParameter(final cto.framework.web.action.plugin.schema.Parameter vParameter) {
        boolean removed = _parameterList.remove(vParameter);
        return removed;
    }

    /**
     * Method removeParameterAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public cto.framework.web.action.plugin.schema.Parameter removeParameterAt(final int index) {
        java.lang.Object obj = this._parameterList.remove(index);
        return (cto.framework.web.action.plugin.schema.Parameter) obj;
    }

    /**
     * Method removeTrans.
     * 
     * @param vTrans
     * @return true if the object was removed from the collection.
     */
    public boolean removeTrans(final cto.framework.web.action.plugin.schema.Trans vTrans) {
        boolean removed = _transList.remove(vTrans);
        return removed;
    }

    /**
     * Method removeTransAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public cto.framework.web.action.plugin.schema.Trans removeTransAt(final int index) {
        java.lang.Object obj = this._transList.remove(index);
        return (cto.framework.web.action.plugin.schema.Trans) obj;
    }

    /**
     * Sets the value of field 'description'.
     * 
     * @param description the value of field 'description'.
     */
    public void setDescription(final java.lang.String description) {
        this._description = description;
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
     * 
     * 
     * @param index
     * @param vParameter
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setParameter(final int index,final cto.framework.web.action.plugin.schema.Parameter vParameter) throws java.lang.IndexOutOfBoundsException {
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
    public void setParameter(final cto.framework.web.action.plugin.schema.Parameter[] vParameterArray) {
        //-- copy array
        _parameterList.clear();

        for (int i = 0; i < vParameterArray.length; i++) {
                this._parameterList.add(vParameterArray[i]);
        }
    }

    /**
     * 
     * 
     * @param index
     * @param vTrans
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setTrans(final int index,final cto.framework.web.action.plugin.schema.Trans vTrans) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._transList.size()) {
            throw new IndexOutOfBoundsException("setTrans: Index value '" + index + "' not in range [0.." + (this._transList.size() - 1) + "]");
        }

        this._transList.set(index, vTrans);
    }

    /**
     * 
     * 
     * @param vTransArray
     */
    public void setTrans(final cto.framework.web.action.plugin.schema.Trans[] vTransArray) {
        //-- copy array
        _transList.clear();

        for (int i = 0; i < vTransArray.length; i++) {
                this._transList.add(vTransArray[i]);
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
     * cto.framework.web.action.plugin.schema.ActionType
     */
    public static cto.framework.web.action.plugin.schema.ActionType unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (cto.framework.web.action.plugin.schema.ActionType) org.exolab.castor.xml.Unmarshaller.unmarshal(cto.framework.web.action.plugin.schema.ActionType.class, reader);
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
