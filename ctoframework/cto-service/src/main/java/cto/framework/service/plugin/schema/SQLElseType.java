/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3-RC1</a>, using an
 * XML Schema.
 * $Id$
 */

package cto.framework.service.plugin.schema;

/**
 * Class SQLElseType.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class SQLElseType implements java.io.Serializable {

    /**
     * Field _expression.
     */
    private java.lang.String _expression;

    /**
     * Field _items.
     */
    private java.util.List<cto.framework.service.plugin.schema.SQLElseTypeItem> _items;

    public SQLElseType() {
        super();
        this._items = new java.util.ArrayList<cto.framework.service.plugin.schema.SQLElseTypeItem>();
    }

    /**
     * 
     * 
     * @param vSQLElseTypeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSQLElseTypeItem(final cto.framework.service.plugin.schema.SQLElseTypeItem vSQLElseTypeItem) throws java.lang.IndexOutOfBoundsException {
        this._items.add(vSQLElseTypeItem);
    }

    /**
     * 
     * 
     * @param index
     * @param vSQLElseTypeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSQLElseTypeItem(final int index,final cto.framework.service.plugin.schema.SQLElseTypeItem vSQLElseTypeItem) throws java.lang.IndexOutOfBoundsException {
        this._items.add(index, vSQLElseTypeItem);
    }

    /**
     * Method enumerateSQLElseTypeItem.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends cto.framework.service.plugin.schema.SQLElseTypeItem> enumerateSQLElseTypeItem() {
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
     * Method getSQLElseTypeItem.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * cto.framework.service.plugin.schema.SQLElseTypeItem at the
     * given index
     */
    public cto.framework.service.plugin.schema.SQLElseTypeItem getSQLElseTypeItem(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("getSQLElseTypeItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        return _items.get(index);
    }

    /**
     * Method getSQLElseTypeItem.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public cto.framework.service.plugin.schema.SQLElseTypeItem[] getSQLElseTypeItem() {
        cto.framework.service.plugin.schema.SQLElseTypeItem[] array = new cto.framework.service.plugin.schema.SQLElseTypeItem[0];
        return this._items.toArray(array);
    }

    /**
     * Method getSQLElseTypeItemCount.
     * 
     * @return the size of this collection
     */
    public int getSQLElseTypeItemCount() {
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
     * Method iterateSQLElseTypeItem.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends cto.framework.service.plugin.schema.SQLElseTypeItem> iterateSQLElseTypeItem() {
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
    public void removeAllSQLElseTypeItem() {
        this._items.clear();
    }

    /**
     * Method removeSQLElseTypeItem.
     * 
     * @param vSQLElseTypeItem
     * @return true if the object was removed from the collection.
     */
    public boolean removeSQLElseTypeItem(final cto.framework.service.plugin.schema.SQLElseTypeItem vSQLElseTypeItem) {
        boolean removed = _items.remove(vSQLElseTypeItem);
        return removed;
    }

    /**
     * Method removeSQLElseTypeItemAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public cto.framework.service.plugin.schema.SQLElseTypeItem removeSQLElseTypeItemAt(final int index) {
        java.lang.Object obj = this._items.remove(index);
        return (cto.framework.service.plugin.schema.SQLElseTypeItem) obj;
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
     * @param vSQLElseTypeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSQLElseTypeItem(final int index,final cto.framework.service.plugin.schema.SQLElseTypeItem vSQLElseTypeItem) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("setSQLElseTypeItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        this._items.set(index, vSQLElseTypeItem);
    }

    /**
     * 
     * 
     * @param vSQLElseTypeItemArray
     */
    public void setSQLElseTypeItem(final cto.framework.service.plugin.schema.SQLElseTypeItem[] vSQLElseTypeItemArray) {
        //-- copy array
        _items.clear();

        for (int i = 0; i < vSQLElseTypeItemArray.length; i++) {
                this._items.add(vSQLElseTypeItemArray[i]);
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
     * cto.framework.service.plugin.schema.SQLElseType
     */
    public static cto.framework.service.plugin.schema.SQLElseType unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (cto.framework.service.plugin.schema.SQLElseType) org.exolab.castor.xml.Unmarshaller.unmarshal(cto.framework.service.plugin.schema.SQLElseType.class, reader);
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
