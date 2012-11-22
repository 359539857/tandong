/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3-RC1</a>, using an
 * XML Schema.
 * $Id$
 */

package cto.framework.web.action.plugin.schema;

/**
 * Class IfElseIfGroup.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class IfElseIfGroup implements java.io.Serializable {

    /**
     * Field _if.
     */
    private cto.framework.web.action.plugin.schema.If _if;

    /**
     * Field _elseifList.
     */
    private java.util.List<cto.framework.web.action.plugin.schema.Elseif> _elseifList;

    /**
     * Field _else.
     */
    private cto.framework.web.action.plugin.schema.Else _else;

    public IfElseIfGroup() {
        super();
        this._elseifList = new java.util.ArrayList<cto.framework.web.action.plugin.schema.Elseif>();
    }

    /**
     * 
     * 
     * @param vElseif
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addElseif(final cto.framework.web.action.plugin.schema.Elseif vElseif) throws java.lang.IndexOutOfBoundsException {
        this._elseifList.add(vElseif);
    }

    /**
     * 
     * 
     * @param index
     * @param vElseif
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addElseif(final int index,final cto.framework.web.action.plugin.schema.Elseif vElseif) throws java.lang.IndexOutOfBoundsException {
        this._elseifList.add(index, vElseif);
    }

    /**
     * Method enumerateElseif.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends cto.framework.web.action.plugin.schema.Elseif> enumerateElseif() {
        return java.util.Collections.enumeration(this._elseifList);
    }

    /**
     * Returns the value of field 'else'.
     * 
     * @return the value of field 'Else'.
     */
    public cto.framework.web.action.plugin.schema.Else getElse() {
        return this._else;
    }

    /**
     * Method getElseif.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * cto.framework.web.action.plugin.schema.Elseif at the given
     * index
     */
    public cto.framework.web.action.plugin.schema.Elseif getElseif(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._elseifList.size()) {
            throw new IndexOutOfBoundsException("getElseif: Index value '" + index + "' not in range [0.." + (this._elseifList.size() - 1) + "]");
        }

        return _elseifList.get(index);
    }

    /**
     * Method getElseif.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public cto.framework.web.action.plugin.schema.Elseif[] getElseif() {
        cto.framework.web.action.plugin.schema.Elseif[] array = new cto.framework.web.action.plugin.schema.Elseif[0];
        return this._elseifList.toArray(array);
    }

    /**
     * Method getElseifCount.
     * 
     * @return the size of this collection
     */
    public int getElseifCount() {
        return this._elseifList.size();
    }

    /**
     * Returns the value of field 'if'.
     * 
     * @return the value of field 'If'.
     */
    public cto.framework.web.action.plugin.schema.If getIf() {
        return this._if;
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
     * Method iterateElseif.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends cto.framework.web.action.plugin.schema.Elseif> iterateElseif() {
        return this._elseifList.iterator();
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
    public void removeAllElseif() {
        this._elseifList.clear();
    }

    /**
     * Method removeElseif.
     * 
     * @param vElseif
     * @return true if the object was removed from the collection.
     */
    public boolean removeElseif(final cto.framework.web.action.plugin.schema.Elseif vElseif) {
        boolean removed = _elseifList.remove(vElseif);
        return removed;
    }

    /**
     * Method removeElseifAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public cto.framework.web.action.plugin.schema.Elseif removeElseifAt(final int index) {
        java.lang.Object obj = this._elseifList.remove(index);
        return (cto.framework.web.action.plugin.schema.Elseif) obj;
    }

    /**
     * Sets the value of field 'else'.
     * 
     * @param _else
     * @param else the value of field 'else'.
     */
    public void setElse(final cto.framework.web.action.plugin.schema.Else _else) {
        this._else = _else;
    }

    /**
     * 
     * 
     * @param index
     * @param vElseif
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setElseif(final int index,final cto.framework.web.action.plugin.schema.Elseif vElseif) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._elseifList.size()) {
            throw new IndexOutOfBoundsException("setElseif: Index value '" + index + "' not in range [0.." + (this._elseifList.size() - 1) + "]");
        }

        this._elseifList.set(index, vElseif);
    }

    /**
     * 
     * 
     * @param vElseifArray
     */
    public void setElseif(final cto.framework.web.action.plugin.schema.Elseif[] vElseifArray) {
        //-- copy array
        _elseifList.clear();

        for (int i = 0; i < vElseifArray.length; i++) {
                this._elseifList.add(vElseifArray[i]);
        }
    }

    /**
     * Sets the value of field 'if'.
     * 
     * @param _if
     * @param if the value of field 'if'.
     */
    public void setIf(final cto.framework.web.action.plugin.schema.If _if) {
        this._if = _if;
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
     * cto.framework.web.action.plugin.schema.IfElseIfGroup
     */
    public static cto.framework.web.action.plugin.schema.IfElseIfGroup unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (cto.framework.web.action.plugin.schema.IfElseIfGroup) org.exolab.castor.xml.Unmarshaller.unmarshal(cto.framework.web.action.plugin.schema.IfElseIfGroup.class, reader);
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
