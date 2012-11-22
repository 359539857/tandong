/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3-RC1</a>, using an
 * XML Schema.
 * $Id$
 */

package cto.framework.service.plugin.schema;

/**
 * Class FinallyTypeChoice.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class FinallyTypeChoice implements java.io.Serializable {

    /**
     * Field _items.
     */
    private java.util.List<cto.framework.service.plugin.schema.FinallyTypeChoiceItem> _items;

    public FinallyTypeChoice() {
        super();
        this._items = new java.util.ArrayList<cto.framework.service.plugin.schema.FinallyTypeChoiceItem>();
    }

    /**
     * 
     * 
     * @param vFinallyTypeChoiceItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addFinallyTypeChoiceItem(final cto.framework.service.plugin.schema.FinallyTypeChoiceItem vFinallyTypeChoiceItem) throws java.lang.IndexOutOfBoundsException {
        this._items.add(vFinallyTypeChoiceItem);
    }

    /**
     * 
     * 
     * @param index
     * @param vFinallyTypeChoiceItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addFinallyTypeChoiceItem(final int index,final cto.framework.service.plugin.schema.FinallyTypeChoiceItem vFinallyTypeChoiceItem) throws java.lang.IndexOutOfBoundsException {
        this._items.add(index, vFinallyTypeChoiceItem);
    }

    /**
     * Method enumerateFinallyTypeChoiceItem.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends cto.framework.service.plugin.schema.FinallyTypeChoiceItem> enumerateFinallyTypeChoiceItem() {
        return java.util.Collections.enumeration(this._items);
    }

    /**
     * Method getFinallyTypeChoiceItem.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * cto.framework.service.plugin.schema.FinallyTypeChoiceItem at
     * the given index
     */
    public cto.framework.service.plugin.schema.FinallyTypeChoiceItem getFinallyTypeChoiceItem(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("getFinallyTypeChoiceItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        return _items.get(index);
    }

    /**
     * Method getFinallyTypeChoiceItem.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public cto.framework.service.plugin.schema.FinallyTypeChoiceItem[] getFinallyTypeChoiceItem() {
        cto.framework.service.plugin.schema.FinallyTypeChoiceItem[] array = new cto.framework.service.plugin.schema.FinallyTypeChoiceItem[0];
        return this._items.toArray(array);
    }

    /**
     * Method getFinallyTypeChoiceItemCount.
     * 
     * @return the size of this collection
     */
    public int getFinallyTypeChoiceItemCount() {
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
     * Method iterateFinallyTypeChoiceItem.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends cto.framework.service.plugin.schema.FinallyTypeChoiceItem> iterateFinallyTypeChoiceItem() {
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
    public void removeAllFinallyTypeChoiceItem() {
        this._items.clear();
    }

    /**
     * Method removeFinallyTypeChoiceItem.
     * 
     * @param vFinallyTypeChoiceItem
     * @return true if the object was removed from the collection.
     */
    public boolean removeFinallyTypeChoiceItem(final cto.framework.service.plugin.schema.FinallyTypeChoiceItem vFinallyTypeChoiceItem) {
        boolean removed = _items.remove(vFinallyTypeChoiceItem);
        return removed;
    }

    /**
     * Method removeFinallyTypeChoiceItemAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public cto.framework.service.plugin.schema.FinallyTypeChoiceItem removeFinallyTypeChoiceItemAt(final int index) {
        java.lang.Object obj = this._items.remove(index);
        return (cto.framework.service.plugin.schema.FinallyTypeChoiceItem) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vFinallyTypeChoiceItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setFinallyTypeChoiceItem(final int index,final cto.framework.service.plugin.schema.FinallyTypeChoiceItem vFinallyTypeChoiceItem) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("setFinallyTypeChoiceItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        this._items.set(index, vFinallyTypeChoiceItem);
    }

    /**
     * 
     * 
     * @param vFinallyTypeChoiceItemArray
     */
    public void setFinallyTypeChoiceItem(final cto.framework.service.plugin.schema.FinallyTypeChoiceItem[] vFinallyTypeChoiceItemArray) {
        //-- copy array
        _items.clear();

        for (int i = 0; i < vFinallyTypeChoiceItemArray.length; i++) {
                this._items.add(vFinallyTypeChoiceItemArray[i]);
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
     * cto.framework.service.plugin.schema.FinallyTypeChoice
     */
    public static cto.framework.service.plugin.schema.FinallyTypeChoice unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (cto.framework.service.plugin.schema.FinallyTypeChoice) org.exolab.castor.xml.Unmarshaller.unmarshal(cto.framework.service.plugin.schema.FinallyTypeChoice.class, reader);
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
