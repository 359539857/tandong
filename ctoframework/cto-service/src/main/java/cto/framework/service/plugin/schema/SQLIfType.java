/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3-RC1</a>, using an
 * XML Schema.
 * $Id$
 */

package cto.framework.service.plugin.schema;

/**
 * Class SQLIfType.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class SQLIfType implements java.io.Serializable {

    /**
     * Field _expression.
     */
    private java.lang.String _expression;

    /**
     * Field _items.
     */
    private java.util.List<cto.framework.service.plugin.schema.SQLIfTypeItem> _items;

    public SQLIfType() {
        super();
        this._items = new java.util.ArrayList<cto.framework.service.plugin.schema.SQLIfTypeItem>();
    }

    /**
     * 
     * 
     * @param vSQLIfTypeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSQLIfTypeItem(final cto.framework.service.plugin.schema.SQLIfTypeItem vSQLIfTypeItem) throws java.lang.IndexOutOfBoundsException {
        this._items.add(vSQLIfTypeItem);
    }

    /**
     * 
     * 
     * @param index
     * @param vSQLIfTypeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSQLIfTypeItem(final int index,final cto.framework.service.plugin.schema.SQLIfTypeItem vSQLIfTypeItem) throws java.lang.IndexOutOfBoundsException {
        this._items.add(index, vSQLIfTypeItem);
    }

    /**
     * Method enumerateSQLIfTypeItem.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends cto.framework.service.plugin.schema.SQLIfTypeItem> enumerateSQLIfTypeItem() {
        return java.util.Collections.enumeration(this._items);
    }

    /**
     * Returns the value of field 'expression'.
     * 
     * @return the value of field 'Expression'.
     */
    public java.lang.String getExpression() {
        return this._expression;
    }

    /**
     * Method getSQLIfTypeItem.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * cto.framework.service.plugin.schema.SQLIfTypeItem at the
     * given index
     */
    public cto.framework.service.plugin.schema.SQLIfTypeItem getSQLIfTypeItem(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("getSQLIfTypeItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        return _items.get(index);
    }

    /**
     * Method getSQLIfTypeItem.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public cto.framework.service.plugin.schema.SQLIfTypeItem[] getSQLIfTypeItem() {
        cto.framework.service.plugin.schema.SQLIfTypeItem[] array = new cto.framework.service.plugin.schema.SQLIfTypeItem[0];
        return this._items.toArray(array);
    }

    /**
     * Method getSQLIfTypeItemCount.
     * 
     * @return the size of this collection
     */
    public int getSQLIfTypeItemCount() {
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
     * Method iterateSQLIfTypeItem.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends cto.framework.service.plugin.schema.SQLIfTypeItem> iterateSQLIfTypeItem() {
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
    public void removeAllSQLIfTypeItem() {
        this._items.clear();
    }

    /**
     * Method removeSQLIfTypeItem.
     * 
     * @param vSQLIfTypeItem
     * @return true if the object was removed from the collection.
     */
    public boolean removeSQLIfTypeItem(final cto.framework.service.plugin.schema.SQLIfTypeItem vSQLIfTypeItem) {
        boolean removed = _items.remove(vSQLIfTypeItem);
        return removed;
    }

    /**
     * Method removeSQLIfTypeItemAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public cto.framework.service.plugin.schema.SQLIfTypeItem removeSQLIfTypeItemAt(final int index) {
        java.lang.Object obj = this._items.remove(index);
        return (cto.framework.service.plugin.schema.SQLIfTypeItem) obj;
    }

    /**
     * Sets the value of field 'expression'.
     * 
     * @param expression the value of field 'expression'.
     */
    public void setExpression(final java.lang.String expression) {
        this._expression = expression;
    }

    /**
     * 
     * 
     * @param index
     * @param vSQLIfTypeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSQLIfTypeItem(final int index,final cto.framework.service.plugin.schema.SQLIfTypeItem vSQLIfTypeItem) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("setSQLIfTypeItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        this._items.set(index, vSQLIfTypeItem);
    }

    /**
     * 
     * 
     * @param vSQLIfTypeItemArray
     */
    public void setSQLIfTypeItem(final cto.framework.service.plugin.schema.SQLIfTypeItem[] vSQLIfTypeItemArray) {
        //-- copy array
        _items.clear();

        for (int i = 0; i < vSQLIfTypeItemArray.length; i++) {
                this._items.add(vSQLIfTypeItemArray[i]);
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
     * cto.framework.service.plugin.schema.SQLIfType
     */
    public static cto.framework.service.plugin.schema.SQLIfType unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (cto.framework.service.plugin.schema.SQLIfType) org.exolab.castor.xml.Unmarshaller.unmarshal(cto.framework.service.plugin.schema.SQLIfType.class, reader);
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
