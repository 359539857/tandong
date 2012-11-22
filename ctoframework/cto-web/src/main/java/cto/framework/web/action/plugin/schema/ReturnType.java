/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3-RC1</a>, using an
 * XML Schema.
 * $Id$
 */

package cto.framework.web.action.plugin.schema;

/**
 * Class ReturnType.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ReturnType implements java.io.Serializable {

    /**
     * Field _code.
     */
    private java.lang.String _code = "0";

    /**
     * Field _info.
     */
    private java.lang.String _info = "ok";

    /**
     * Field _text.
     */
    private java.lang.String _text = "ok";

    /**
     * Field _returnItemList.
     */
    private java.util.List<cto.framework.web.action.plugin.schema.ReturnItem> _returnItemList;

    public ReturnType() {
        super();
        setCode("0");
        setInfo("ok");
        setText("ok");
        this._returnItemList = new java.util.ArrayList<cto.framework.web.action.plugin.schema.ReturnItem>();
    }

    /**
     * 
     * 
     * @param vReturnItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addReturnItem(final cto.framework.web.action.plugin.schema.ReturnItem vReturnItem) throws java.lang.IndexOutOfBoundsException {
        this._returnItemList.add(vReturnItem);
    }

    /**
     * 
     * 
     * @param index
     * @param vReturnItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addReturnItem(final int index,final cto.framework.web.action.plugin.schema.ReturnItem vReturnItem) throws java.lang.IndexOutOfBoundsException {
        this._returnItemList.add(index, vReturnItem);
    }

    /**
     * Method enumerateReturnItem.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends cto.framework.web.action.plugin.schema.ReturnItem> enumerateReturnItem() {
        return java.util.Collections.enumeration(this._returnItemList);
    }

    /**
     * Returns the value of field 'code'.
     * 
     * @return the value of field 'Code'.
     */
    public java.lang.String getCode() {
        return this._code;
    }

    /**
     * Returns the value of field 'info'.
     * 
     * @return the value of field 'Info'.
     */
    public java.lang.String getInfo() {
        return this._info;
    }

    /**
     * Method getReturnItem.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * cto.framework.web.action.plugin.schema.ReturnItem at the
     * given index
     */
    public cto.framework.web.action.plugin.schema.ReturnItem getReturnItem(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._returnItemList.size()) {
            throw new IndexOutOfBoundsException("getReturnItem: Index value '" + index + "' not in range [0.." + (this._returnItemList.size() - 1) + "]");
        }

        return _returnItemList.get(index);
    }

    /**
     * Method getReturnItem.Returns the contents of the collection
     * in an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public cto.framework.web.action.plugin.schema.ReturnItem[] getReturnItem() {
        cto.framework.web.action.plugin.schema.ReturnItem[] array = new cto.framework.web.action.plugin.schema.ReturnItem[0];
        return this._returnItemList.toArray(array);
    }

    /**
     * Method getReturnItemCount.
     * 
     * @return the size of this collection
     */
    public int getReturnItemCount() {
        return this._returnItemList.size();
    }

    /**
     * Returns the value of field 'text'.
     * 
     * @return the value of field 'Text'.
     */
    public java.lang.String getText() {
        return this._text;
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
     * Method iterateReturnItem.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends cto.framework.web.action.plugin.schema.ReturnItem> iterateReturnItem() {
        return this._returnItemList.iterator();
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
    public void removeAllReturnItem() {
        this._returnItemList.clear();
    }

    /**
     * Method removeReturnItem.
     * 
     * @param vReturnItem
     * @return true if the object was removed from the collection.
     */
    public boolean removeReturnItem(final cto.framework.web.action.plugin.schema.ReturnItem vReturnItem) {
        boolean removed = _returnItemList.remove(vReturnItem);
        return removed;
    }

    /**
     * Method removeReturnItemAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public cto.framework.web.action.plugin.schema.ReturnItem removeReturnItemAt(final int index) {
        java.lang.Object obj = this._returnItemList.remove(index);
        return (cto.framework.web.action.plugin.schema.ReturnItem) obj;
    }

    /**
     * Sets the value of field 'code'.
     * 
     * @param code the value of field 'code'.
     */
    public void setCode(final java.lang.String code) {
        this._code = code;
    }

    /**
     * Sets the value of field 'info'.
     * 
     * @param info the value of field 'info'.
     */
    public void setInfo(final java.lang.String info) {
        this._info = info;
    }

    /**
     * 
     * 
     * @param index
     * @param vReturnItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setReturnItem(final int index,final cto.framework.web.action.plugin.schema.ReturnItem vReturnItem) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._returnItemList.size()) {
            throw new IndexOutOfBoundsException("setReturnItem: Index value '" + index + "' not in range [0.." + (this._returnItemList.size() - 1) + "]");
        }

        this._returnItemList.set(index, vReturnItem);
    }

    /**
     * 
     * 
     * @param vReturnItemArray
     */
    public void setReturnItem(final cto.framework.web.action.plugin.schema.ReturnItem[] vReturnItemArray) {
        //-- copy array
        _returnItemList.clear();

        for (int i = 0; i < vReturnItemArray.length; i++) {
                this._returnItemList.add(vReturnItemArray[i]);
        }
    }

    /**
     * Sets the value of field 'text'.
     * 
     * @param text the value of field 'text'.
     */
    public void setText(final java.lang.String text) {
        this._text = text;
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
     * cto.framework.web.action.plugin.schema.ReturnType
     */
    public static cto.framework.web.action.plugin.schema.ReturnType unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (cto.framework.web.action.plugin.schema.ReturnType) org.exolab.castor.xml.Unmarshaller.unmarshal(cto.framework.web.action.plugin.schema.ReturnType.class, reader);
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
