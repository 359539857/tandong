/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3-RC1</a>, using an
 * XML Schema.
 * $Id$
 */

package cto.framework.web.action.plugin.schema;

/**
 * Class ElseTypeChoice.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ElseTypeChoice implements java.io.Serializable {

    /**
     * Field _items.
     */
    private java.util.List<cto.framework.web.action.plugin.schema.ElseTypeChoiceItem> _items;

    public ElseTypeChoice() {
        super();
        this._items = new java.util.ArrayList<cto.framework.web.action.plugin.schema.ElseTypeChoiceItem>();
    }

    /**
     * 
     * 
     * @param vElseTypeChoiceItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addElseTypeChoiceItem(final cto.framework.web.action.plugin.schema.ElseTypeChoiceItem vElseTypeChoiceItem) throws java.lang.IndexOutOfBoundsException {
        this._items.add(vElseTypeChoiceItem);
    }

    /**
     * 
     * 
     * @param index
     * @param vElseTypeChoiceItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addElseTypeChoiceItem(final int index,final cto.framework.web.action.plugin.schema.ElseTypeChoiceItem vElseTypeChoiceItem) throws java.lang.IndexOutOfBoundsException {
        this._items.add(index, vElseTypeChoiceItem);
    }

    /**
     * Method enumerateElseTypeChoiceItem.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends cto.framework.web.action.plugin.schema.ElseTypeChoiceItem> enumerateElseTypeChoiceItem() {
        return java.util.Collections.enumeration(this._items);
    }

    /**
     * Method getElseTypeChoiceItem.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * cto.framework.web.action.plugin.schema.ElseTypeChoiceItem at
     * the given index
     */
    public cto.framework.web.action.plugin.schema.ElseTypeChoiceItem getElseTypeChoiceItem(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("getElseTypeChoiceItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        return _items.get(index);
    }

    /**
     * Method getElseTypeChoiceItem.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public cto.framework.web.action.plugin.schema.ElseTypeChoiceItem[] getElseTypeChoiceItem() {
        cto.framework.web.action.plugin.schema.ElseTypeChoiceItem[] array = new cto.framework.web.action.plugin.schema.ElseTypeChoiceItem[0];
        return this._items.toArray(array);
    }

    /**
     * Method getElseTypeChoiceItemCount.
     * 
     * @return the size of this collection
     */
    public int getElseTypeChoiceItemCount() {
        return this._items.size();
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
     * Method iterateElseTypeChoiceItem.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends cto.framework.web.action.plugin.schema.ElseTypeChoiceItem> iterateElseTypeChoiceItem() {
        return this._items.iterator();
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
    public void removeAllElseTypeChoiceItem() {
        this._items.clear();
    }

    /**
     * Method removeElseTypeChoiceItem.
     * 
     * @param vElseTypeChoiceItem
     * @return true if the object was removed from the collection.
     */
    public boolean removeElseTypeChoiceItem(final cto.framework.web.action.plugin.schema.ElseTypeChoiceItem vElseTypeChoiceItem) {
        boolean removed = _items.remove(vElseTypeChoiceItem);
        return removed;
    }

    /**
     * Method removeElseTypeChoiceItemAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public cto.framework.web.action.plugin.schema.ElseTypeChoiceItem removeElseTypeChoiceItemAt(final int index) {
        java.lang.Object obj = this._items.remove(index);
        return (cto.framework.web.action.plugin.schema.ElseTypeChoiceItem) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vElseTypeChoiceItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setElseTypeChoiceItem(final int index,final cto.framework.web.action.plugin.schema.ElseTypeChoiceItem vElseTypeChoiceItem) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("setElseTypeChoiceItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        this._items.set(index, vElseTypeChoiceItem);
    }

    /**
     * 
     * 
     * @param vElseTypeChoiceItemArray
     */
    public void setElseTypeChoiceItem(final cto.framework.web.action.plugin.schema.ElseTypeChoiceItem[] vElseTypeChoiceItemArray) {
        //-- copy array
        _items.clear();

        for (int i = 0; i < vElseTypeChoiceItemArray.length; i++) {
                this._items.add(vElseTypeChoiceItemArray[i]);
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
     * cto.framework.web.action.plugin.schema.ElseTypeChoice
     */
    public static cto.framework.web.action.plugin.schema.ElseTypeChoice unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (cto.framework.web.action.plugin.schema.ElseTypeChoice) org.exolab.castor.xml.Unmarshaller.unmarshal(cto.framework.web.action.plugin.schema.ElseTypeChoice.class, reader);
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
