/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3-RC1</a>, using an
 * XML Schema.
 * $Id$
 */

package cto.framework.web.action.plugin.schema;

/**
 * Class TryTypeChoice.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class TryTypeChoice implements java.io.Serializable {

    /**
     * Field _items.
     */
    private java.util.List<cto.framework.web.action.plugin.schema.TryTypeChoiceItem> _items;

    public TryTypeChoice() {
        super();
        this._items = new java.util.ArrayList<cto.framework.web.action.plugin.schema.TryTypeChoiceItem>();
    }

    /**
     * 
     * 
     * @param vTryTypeChoiceItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addTryTypeChoiceItem(final cto.framework.web.action.plugin.schema.TryTypeChoiceItem vTryTypeChoiceItem) throws java.lang.IndexOutOfBoundsException {
        this._items.add(vTryTypeChoiceItem);
    }

    /**
     * 
     * 
     * @param index
     * @param vTryTypeChoiceItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addTryTypeChoiceItem(final int index,final cto.framework.web.action.plugin.schema.TryTypeChoiceItem vTryTypeChoiceItem) throws java.lang.IndexOutOfBoundsException {
        this._items.add(index, vTryTypeChoiceItem);
    }

    /**
     * Method enumerateTryTypeChoiceItem.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends cto.framework.web.action.plugin.schema.TryTypeChoiceItem> enumerateTryTypeChoiceItem() {
        return java.util.Collections.enumeration(this._items);
    }

    /**
     * Method getTryTypeChoiceItem.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * cto.framework.web.action.plugin.schema.TryTypeChoiceItem at
     * the given index
     */
    public cto.framework.web.action.plugin.schema.TryTypeChoiceItem getTryTypeChoiceItem(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("getTryTypeChoiceItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        return _items.get(index);
    }

    /**
     * Method getTryTypeChoiceItem.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public cto.framework.web.action.plugin.schema.TryTypeChoiceItem[] getTryTypeChoiceItem() {
        cto.framework.web.action.plugin.schema.TryTypeChoiceItem[] array = new cto.framework.web.action.plugin.schema.TryTypeChoiceItem[0];
        return this._items.toArray(array);
    }

    /**
     * Method getTryTypeChoiceItemCount.
     * 
     * @return the size of this collection
     */
    public int getTryTypeChoiceItemCount() {
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
     * Method iterateTryTypeChoiceItem.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends cto.framework.web.action.plugin.schema.TryTypeChoiceItem> iterateTryTypeChoiceItem() {
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
    public void removeAllTryTypeChoiceItem() {
        this._items.clear();
    }

    /**
     * Method removeTryTypeChoiceItem.
     * 
     * @param vTryTypeChoiceItem
     * @return true if the object was removed from the collection.
     */
    public boolean removeTryTypeChoiceItem(final cto.framework.web.action.plugin.schema.TryTypeChoiceItem vTryTypeChoiceItem) {
        boolean removed = _items.remove(vTryTypeChoiceItem);
        return removed;
    }

    /**
     * Method removeTryTypeChoiceItemAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public cto.framework.web.action.plugin.schema.TryTypeChoiceItem removeTryTypeChoiceItemAt(final int index) {
        java.lang.Object obj = this._items.remove(index);
        return (cto.framework.web.action.plugin.schema.TryTypeChoiceItem) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vTryTypeChoiceItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setTryTypeChoiceItem(final int index,final cto.framework.web.action.plugin.schema.TryTypeChoiceItem vTryTypeChoiceItem) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("setTryTypeChoiceItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        this._items.set(index, vTryTypeChoiceItem);
    }

    /**
     * 
     * 
     * @param vTryTypeChoiceItemArray
     */
    public void setTryTypeChoiceItem(final cto.framework.web.action.plugin.schema.TryTypeChoiceItem[] vTryTypeChoiceItemArray) {
        //-- copy array
        _items.clear();

        for (int i = 0; i < vTryTypeChoiceItemArray.length; i++) {
                this._items.add(vTryTypeChoiceItemArray[i]);
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
     * cto.framework.web.action.plugin.schema.TryTypeChoice
     */
    public static cto.framework.web.action.plugin.schema.TryTypeChoice unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (cto.framework.web.action.plugin.schema.TryTypeChoice) org.exolab.castor.xml.Unmarshaller.unmarshal(cto.framework.web.action.plugin.schema.TryTypeChoice.class, reader);
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
