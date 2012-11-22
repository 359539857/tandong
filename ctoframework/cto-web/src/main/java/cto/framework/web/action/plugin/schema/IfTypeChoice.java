/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3-RC1</a>, using an
 * XML Schema.
 * $Id$
 */

package cto.framework.web.action.plugin.schema;

/**
 * Class IfTypeChoice.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class IfTypeChoice implements java.io.Serializable {

    /**
     * Field _items.
     */
    private java.util.List<cto.framework.web.action.plugin.schema.IfTypeChoiceItem> _items;

    public IfTypeChoice() {
        super();
        this._items = new java.util.ArrayList<cto.framework.web.action.plugin.schema.IfTypeChoiceItem>();
    }

    /**
     * 
     * 
     * @param vIfTypeChoiceItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addIfTypeChoiceItem(final cto.framework.web.action.plugin.schema.IfTypeChoiceItem vIfTypeChoiceItem) throws java.lang.IndexOutOfBoundsException {
        this._items.add(vIfTypeChoiceItem);
    }

    /**
     * 
     * 
     * @param index
     * @param vIfTypeChoiceItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addIfTypeChoiceItem(final int index,final cto.framework.web.action.plugin.schema.IfTypeChoiceItem vIfTypeChoiceItem) throws java.lang.IndexOutOfBoundsException {
        this._items.add(index, vIfTypeChoiceItem);
    }

    /**
     * Method enumerateIfTypeChoiceItem.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends cto.framework.web.action.plugin.schema.IfTypeChoiceItem> enumerateIfTypeChoiceItem() {
        return java.util.Collections.enumeration(this._items);
    }

    /**
     * Method getIfTypeChoiceItem.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * cto.framework.web.action.plugin.schema.IfTypeChoiceItem at
     * the given index
     */
    public cto.framework.web.action.plugin.schema.IfTypeChoiceItem getIfTypeChoiceItem(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("getIfTypeChoiceItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        return _items.get(index);
    }

    /**
     * Method getIfTypeChoiceItem.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public cto.framework.web.action.plugin.schema.IfTypeChoiceItem[] getIfTypeChoiceItem() {
        cto.framework.web.action.plugin.schema.IfTypeChoiceItem[] array = new cto.framework.web.action.plugin.schema.IfTypeChoiceItem[0];
        return this._items.toArray(array);
    }

    /**
     * Method getIfTypeChoiceItemCount.
     * 
     * @return the size of this collection
     */
    public int getIfTypeChoiceItemCount() {
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
     * Method iterateIfTypeChoiceItem.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends cto.framework.web.action.plugin.schema.IfTypeChoiceItem> iterateIfTypeChoiceItem() {
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
    public void removeAllIfTypeChoiceItem() {
        this._items.clear();
    }

    /**
     * Method removeIfTypeChoiceItem.
     * 
     * @param vIfTypeChoiceItem
     * @return true if the object was removed from the collection.
     */
    public boolean removeIfTypeChoiceItem(final cto.framework.web.action.plugin.schema.IfTypeChoiceItem vIfTypeChoiceItem) {
        boolean removed = _items.remove(vIfTypeChoiceItem);
        return removed;
    }

    /**
     * Method removeIfTypeChoiceItemAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public cto.framework.web.action.plugin.schema.IfTypeChoiceItem removeIfTypeChoiceItemAt(final int index) {
        java.lang.Object obj = this._items.remove(index);
        return (cto.framework.web.action.plugin.schema.IfTypeChoiceItem) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vIfTypeChoiceItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setIfTypeChoiceItem(final int index,final cto.framework.web.action.plugin.schema.IfTypeChoiceItem vIfTypeChoiceItem) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("setIfTypeChoiceItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        this._items.set(index, vIfTypeChoiceItem);
    }

    /**
     * 
     * 
     * @param vIfTypeChoiceItemArray
     */
    public void setIfTypeChoiceItem(final cto.framework.web.action.plugin.schema.IfTypeChoiceItem[] vIfTypeChoiceItemArray) {
        //-- copy array
        _items.clear();

        for (int i = 0; i < vIfTypeChoiceItemArray.length; i++) {
                this._items.add(vIfTypeChoiceItemArray[i]);
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
     * cto.framework.web.action.plugin.schema.IfTypeChoice
     */
    public static cto.framework.web.action.plugin.schema.IfTypeChoice unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (cto.framework.web.action.plugin.schema.IfTypeChoice) org.exolab.castor.xml.Unmarshaller.unmarshal(cto.framework.web.action.plugin.schema.IfTypeChoice.class, reader);
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
