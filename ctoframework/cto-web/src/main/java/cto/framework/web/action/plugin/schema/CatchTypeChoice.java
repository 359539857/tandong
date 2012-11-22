/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3-RC1</a>, using an
 * XML Schema.
 * $Id$
 */

package cto.framework.web.action.plugin.schema;

/**
 * Class CatchTypeChoice.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CatchTypeChoice implements java.io.Serializable {

    /**
     * Field _items.
     */
    private java.util.List<cto.framework.web.action.plugin.schema.CatchTypeChoiceItem> _items;

    public CatchTypeChoice() {
        super();
        this._items = new java.util.ArrayList<cto.framework.web.action.plugin.schema.CatchTypeChoiceItem>();
    }

    /**
     * 
     * 
     * @param vCatchTypeChoiceItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCatchTypeChoiceItem(final cto.framework.web.action.plugin.schema.CatchTypeChoiceItem vCatchTypeChoiceItem) throws java.lang.IndexOutOfBoundsException {
        this._items.add(vCatchTypeChoiceItem);
    }

    /**
     * 
     * 
     * @param index
     * @param vCatchTypeChoiceItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCatchTypeChoiceItem(final int index,final cto.framework.web.action.plugin.schema.CatchTypeChoiceItem vCatchTypeChoiceItem) throws java.lang.IndexOutOfBoundsException {
        this._items.add(index, vCatchTypeChoiceItem);
    }

    /**
     * Method enumerateCatchTypeChoiceItem.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends cto.framework.web.action.plugin.schema.CatchTypeChoiceItem> enumerateCatchTypeChoiceItem() {
        return java.util.Collections.enumeration(this._items);
    }

    /**
     * Method getCatchTypeChoiceItem.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * cto.framework.web.action.plugin.schema.CatchTypeChoiceItem
     * at the given index
     */
    public cto.framework.web.action.plugin.schema.CatchTypeChoiceItem getCatchTypeChoiceItem(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("getCatchTypeChoiceItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        return _items.get(index);
    }

    /**
     * Method getCatchTypeChoiceItem.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public cto.framework.web.action.plugin.schema.CatchTypeChoiceItem[] getCatchTypeChoiceItem() {
        cto.framework.web.action.plugin.schema.CatchTypeChoiceItem[] array = new cto.framework.web.action.plugin.schema.CatchTypeChoiceItem[0];
        return this._items.toArray(array);
    }

    /**
     * Method getCatchTypeChoiceItemCount.
     * 
     * @return the size of this collection
     */
    public int getCatchTypeChoiceItemCount() {
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
     * Method iterateCatchTypeChoiceItem.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends cto.framework.web.action.plugin.schema.CatchTypeChoiceItem> iterateCatchTypeChoiceItem() {
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
    public void removeAllCatchTypeChoiceItem() {
        this._items.clear();
    }

    /**
     * Method removeCatchTypeChoiceItem.
     * 
     * @param vCatchTypeChoiceItem
     * @return true if the object was removed from the collection.
     */
    public boolean removeCatchTypeChoiceItem(final cto.framework.web.action.plugin.schema.CatchTypeChoiceItem vCatchTypeChoiceItem) {
        boolean removed = _items.remove(vCatchTypeChoiceItem);
        return removed;
    }

    /**
     * Method removeCatchTypeChoiceItemAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public cto.framework.web.action.plugin.schema.CatchTypeChoiceItem removeCatchTypeChoiceItemAt(final int index) {
        java.lang.Object obj = this._items.remove(index);
        return (cto.framework.web.action.plugin.schema.CatchTypeChoiceItem) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vCatchTypeChoiceItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setCatchTypeChoiceItem(final int index,final cto.framework.web.action.plugin.schema.CatchTypeChoiceItem vCatchTypeChoiceItem) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("setCatchTypeChoiceItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        this._items.set(index, vCatchTypeChoiceItem);
    }

    /**
     * 
     * 
     * @param vCatchTypeChoiceItemArray
     */
    public void setCatchTypeChoiceItem(final cto.framework.web.action.plugin.schema.CatchTypeChoiceItem[] vCatchTypeChoiceItemArray) {
        //-- copy array
        _items.clear();

        for (int i = 0; i < vCatchTypeChoiceItemArray.length; i++) {
                this._items.add(vCatchTypeChoiceItemArray[i]);
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
     * cto.framework.web.action.plugin.schema.CatchTypeChoice
     */
    public static cto.framework.web.action.plugin.schema.CatchTypeChoice unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (cto.framework.web.action.plugin.schema.CatchTypeChoice) org.exolab.castor.xml.Unmarshaller.unmarshal(cto.framework.web.action.plugin.schema.CatchTypeChoice.class, reader);
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
