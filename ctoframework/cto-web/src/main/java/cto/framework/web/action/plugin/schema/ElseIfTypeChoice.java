/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3-RC1</a>, using an
 * XML Schema.
 * $Id$
 */

package cto.framework.web.action.plugin.schema;

/**
 * Class ElseIfTypeChoice.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ElseIfTypeChoice implements java.io.Serializable {

    /**
     * Field _items.
     */
    private java.util.List<cto.framework.web.action.plugin.schema.ElseIfTypeChoiceItem> _items;

    public ElseIfTypeChoice() {
        super();
        this._items = new java.util.ArrayList<cto.framework.web.action.plugin.schema.ElseIfTypeChoiceItem>();
    }

    /**
     * 
     * 
     * @param vElseIfTypeChoiceItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addElseIfTypeChoiceItem(final cto.framework.web.action.plugin.schema.ElseIfTypeChoiceItem vElseIfTypeChoiceItem) throws java.lang.IndexOutOfBoundsException {
        this._items.add(vElseIfTypeChoiceItem);
    }

    /**
     * 
     * 
     * @param index
     * @param vElseIfTypeChoiceItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addElseIfTypeChoiceItem(final int index,final cto.framework.web.action.plugin.schema.ElseIfTypeChoiceItem vElseIfTypeChoiceItem) throws java.lang.IndexOutOfBoundsException {
        this._items.add(index, vElseIfTypeChoiceItem);
    }

    /**
     * Method enumerateElseIfTypeChoiceItem.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends cto.framework.web.action.plugin.schema.ElseIfTypeChoiceItem> enumerateElseIfTypeChoiceItem() {
        return java.util.Collections.enumeration(this._items);
    }

    /**
     * Method getElseIfTypeChoiceItem.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * cto.framework.web.action.plugin.schema.ElseIfTypeChoiceItem
     * at the given index
     */
    public cto.framework.web.action.plugin.schema.ElseIfTypeChoiceItem getElseIfTypeChoiceItem(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("getElseIfTypeChoiceItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        return _items.get(index);
    }

    /**
     * Method getElseIfTypeChoiceItem.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public cto.framework.web.action.plugin.schema.ElseIfTypeChoiceItem[] getElseIfTypeChoiceItem() {
        cto.framework.web.action.plugin.schema.ElseIfTypeChoiceItem[] array = new cto.framework.web.action.plugin.schema.ElseIfTypeChoiceItem[0];
        return this._items.toArray(array);
    }

    /**
     * Method getElseIfTypeChoiceItemCount.
     * 
     * @return the size of this collection
     */
    public int getElseIfTypeChoiceItemCount() {
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
     * Method iterateElseIfTypeChoiceItem.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends cto.framework.web.action.plugin.schema.ElseIfTypeChoiceItem> iterateElseIfTypeChoiceItem() {
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
    public void removeAllElseIfTypeChoiceItem() {
        this._items.clear();
    }

    /**
     * Method removeElseIfTypeChoiceItem.
     * 
     * @param vElseIfTypeChoiceItem
     * @return true if the object was removed from the collection.
     */
    public boolean removeElseIfTypeChoiceItem(final cto.framework.web.action.plugin.schema.ElseIfTypeChoiceItem vElseIfTypeChoiceItem) {
        boolean removed = _items.remove(vElseIfTypeChoiceItem);
        return removed;
    }

    /**
     * Method removeElseIfTypeChoiceItemAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public cto.framework.web.action.plugin.schema.ElseIfTypeChoiceItem removeElseIfTypeChoiceItemAt(final int index) {
        java.lang.Object obj = this._items.remove(index);
        return (cto.framework.web.action.plugin.schema.ElseIfTypeChoiceItem) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vElseIfTypeChoiceItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setElseIfTypeChoiceItem(final int index,final cto.framework.web.action.plugin.schema.ElseIfTypeChoiceItem vElseIfTypeChoiceItem) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("setElseIfTypeChoiceItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        this._items.set(index, vElseIfTypeChoiceItem);
    }

    /**
     * 
     * 
     * @param vElseIfTypeChoiceItemArray
     */
    public void setElseIfTypeChoiceItem(final cto.framework.web.action.plugin.schema.ElseIfTypeChoiceItem[] vElseIfTypeChoiceItemArray) {
        //-- copy array
        _items.clear();

        for (int i = 0; i < vElseIfTypeChoiceItemArray.length; i++) {
                this._items.add(vElseIfTypeChoiceItemArray[i]);
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
     * cto.framework.web.action.plugin.schema.ElseIfTypeChoice
     */
    public static cto.framework.web.action.plugin.schema.ElseIfTypeChoice unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (cto.framework.web.action.plugin.schema.ElseIfTypeChoice) org.exolab.castor.xml.Unmarshaller.unmarshal(cto.framework.web.action.plugin.schema.ElseIfTypeChoice.class, reader);
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
