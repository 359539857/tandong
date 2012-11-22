/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3-RC1</a>, using an
 * XML Schema.
 * $Id$
 */

package cto.framework.service.plugin.schema;

/**
 * Class ForTypeChoice.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ForTypeChoice implements java.io.Serializable {

    /**
     * Field _items.
     */
    private java.util.List<cto.framework.service.plugin.schema.ForTypeChoiceItem> _items;

    public ForTypeChoice() {
        super();
        this._items = new java.util.ArrayList<cto.framework.service.plugin.schema.ForTypeChoiceItem>();
    }

    /**
     * 
     * 
     * @param vForTypeChoiceItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addForTypeChoiceItem(final cto.framework.service.plugin.schema.ForTypeChoiceItem vForTypeChoiceItem) throws java.lang.IndexOutOfBoundsException {
        this._items.add(vForTypeChoiceItem);
    }

    /**
     * 
     * 
     * @param index
     * @param vForTypeChoiceItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addForTypeChoiceItem(final int index,final cto.framework.service.plugin.schema.ForTypeChoiceItem vForTypeChoiceItem) throws java.lang.IndexOutOfBoundsException {
        this._items.add(index, vForTypeChoiceItem);
    }

    /**
     * Method enumerateForTypeChoiceItem.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends cto.framework.service.plugin.schema.ForTypeChoiceItem> enumerateForTypeChoiceItem() {
        return java.util.Collections.enumeration(this._items);
    }

    /**
     * Method getForTypeChoiceItem.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * cto.framework.service.plugin.schema.ForTypeChoiceItem at the
     * given index
     */
    public cto.framework.service.plugin.schema.ForTypeChoiceItem getForTypeChoiceItem(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("getForTypeChoiceItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        return _items.get(index);
    }

    /**
     * Method getForTypeChoiceItem.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public cto.framework.service.plugin.schema.ForTypeChoiceItem[] getForTypeChoiceItem() {
        cto.framework.service.plugin.schema.ForTypeChoiceItem[] array = new cto.framework.service.plugin.schema.ForTypeChoiceItem[0];
        return this._items.toArray(array);
    }

    /**
     * Method getForTypeChoiceItemCount.
     * 
     * @return the size of this collection
     */
    public int getForTypeChoiceItemCount() {
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
     * Method iterateForTypeChoiceItem.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends cto.framework.service.plugin.schema.ForTypeChoiceItem> iterateForTypeChoiceItem() {
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
    public void removeAllForTypeChoiceItem() {
        this._items.clear();
    }

    /**
     * Method removeForTypeChoiceItem.
     * 
     * @param vForTypeChoiceItem
     * @return true if the object was removed from the collection.
     */
    public boolean removeForTypeChoiceItem(final cto.framework.service.plugin.schema.ForTypeChoiceItem vForTypeChoiceItem) {
        boolean removed = _items.remove(vForTypeChoiceItem);
        return removed;
    }

    /**
     * Method removeForTypeChoiceItemAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public cto.framework.service.plugin.schema.ForTypeChoiceItem removeForTypeChoiceItemAt(final int index) {
        java.lang.Object obj = this._items.remove(index);
        return (cto.framework.service.plugin.schema.ForTypeChoiceItem) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vForTypeChoiceItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setForTypeChoiceItem(final int index,final cto.framework.service.plugin.schema.ForTypeChoiceItem vForTypeChoiceItem) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("setForTypeChoiceItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        this._items.set(index, vForTypeChoiceItem);
    }

    /**
     * 
     * 
     * @param vForTypeChoiceItemArray
     */
    public void setForTypeChoiceItem(final cto.framework.service.plugin.schema.ForTypeChoiceItem[] vForTypeChoiceItemArray) {
        //-- copy array
        _items.clear();

        for (int i = 0; i < vForTypeChoiceItemArray.length; i++) {
                this._items.add(vForTypeChoiceItemArray[i]);
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
     * cto.framework.service.plugin.schema.ForTypeChoice
     */
    public static cto.framework.service.plugin.schema.ForTypeChoice unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (cto.framework.service.plugin.schema.ForTypeChoice) org.exolab.castor.xml.Unmarshaller.unmarshal(cto.framework.service.plugin.schema.ForTypeChoice.class, reader);
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
