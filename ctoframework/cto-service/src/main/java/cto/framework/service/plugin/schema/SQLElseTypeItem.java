/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3-RC1</a>, using an
 * XML Schema.
 * $Id$
 */

package cto.framework.service.plugin.schema;

/**
 * Class SQLElseTypeItem.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class SQLElseTypeItem implements java.io.Serializable {

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * Field _SQLIfElseGroupList.
     */
    private java.util.List<cto.framework.service.plugin.schema.SQLIfElseGroup> _SQLIfElseGroupList;

    /**
     * Field _SQLFor.
     */
    private cto.framework.service.plugin.schema.SQLFor _SQLFor;

    /**
     * Field _outputSQL.
     */
    private java.lang.String _outputSQL;

    public SQLElseTypeItem() {
        super();
        this._SQLIfElseGroupList = new java.util.ArrayList<cto.framework.service.plugin.schema.SQLIfElseGroup>();
    }

    /**
     * 
     * 
     * @param vSQLIfElseGroup
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSQLIfElseGroup(final cto.framework.service.plugin.schema.SQLIfElseGroup vSQLIfElseGroup) throws java.lang.IndexOutOfBoundsException {
        this._SQLIfElseGroupList.add(vSQLIfElseGroup);
    }

    /**
     * 
     * 
     * @param index
     * @param vSQLIfElseGroup
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSQLIfElseGroup(final int index,final cto.framework.service.plugin.schema.SQLIfElseGroup vSQLIfElseGroup) throws java.lang.IndexOutOfBoundsException {
        this._SQLIfElseGroupList.add(index, vSQLIfElseGroup);
    }

    /**
     * Method enumerateSQLIfElseGroup.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends cto.framework.service.plugin.schema.SQLIfElseGroup> enumerateSQLIfElseGroup() {
        return java.util.Collections.enumeration(this._SQLIfElseGroupList);
    }

    /**
     * Returns the value of field 'choiceValue'. The field
     * 'choiceValue' has the following description: Internal choice
     * value storage
     * 
     * @return the value of field 'ChoiceValue'.
     */
    public java.lang.Object getChoiceValue() {
        return this._choiceValue;
    }

    /**
     * Returns the value of field 'outputSQL'.
     * 
     * @return the value of field 'OutputSQL'.
     */
    public java.lang.String getOutputSQL() {
        return this._outputSQL;
    }

    /**
     * Returns the value of field 'SQLFor'.
     * 
     * @return the value of field 'SQLFor'.
     */
    public cto.framework.service.plugin.schema.SQLFor getSQLFor() {
        return this._SQLFor;
    }

    /**
     * Method getSQLIfElseGroup.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * cto.framework.service.plugin.schema.SQLIfElseGroup at the
     * given index
     */
    public cto.framework.service.plugin.schema.SQLIfElseGroup getSQLIfElseGroup(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._SQLIfElseGroupList.size()) {
            throw new IndexOutOfBoundsException("getSQLIfElseGroup: Index value '" + index + "' not in range [0.." + (this._SQLIfElseGroupList.size() - 1) + "]");
        }

        return _SQLIfElseGroupList.get(index);
    }

    /**
     * Method getSQLIfElseGroup.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public cto.framework.service.plugin.schema.SQLIfElseGroup[] getSQLIfElseGroup() {
        cto.framework.service.plugin.schema.SQLIfElseGroup[] array = new cto.framework.service.plugin.schema.SQLIfElseGroup[0];
        return this._SQLIfElseGroupList.toArray(array);
    }

    /**
     * Method getSQLIfElseGroupCount.
     * 
     * @return the size of this collection
     */
    public int getSQLIfElseGroupCount() {
        return this._SQLIfElseGroupList.size();
    }

    /**
     * Method iterateSQLIfElseGroup.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends cto.framework.service.plugin.schema.SQLIfElseGroup> iterateSQLIfElseGroup() {
        return this._SQLIfElseGroupList.iterator();
    }

    /**
     */
    public void removeAllSQLIfElseGroup() {
        this._SQLIfElseGroupList.clear();
    }

    /**
     * Method removeSQLIfElseGroup.
     * 
     * @param vSQLIfElseGroup
     * @return true if the object was removed from the collection.
     */
    public boolean removeSQLIfElseGroup(final cto.framework.service.plugin.schema.SQLIfElseGroup vSQLIfElseGroup) {
        boolean removed = _SQLIfElseGroupList.remove(vSQLIfElseGroup);
        return removed;
    }

    /**
     * Method removeSQLIfElseGroupAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public cto.framework.service.plugin.schema.SQLIfElseGroup removeSQLIfElseGroupAt(final int index) {
        java.lang.Object obj = this._SQLIfElseGroupList.remove(index);
        return (cto.framework.service.plugin.schema.SQLIfElseGroup) obj;
    }

    /**
     * Sets the value of field 'outputSQL'.
     * 
     * @param outputSQL the value of field 'outputSQL'.
     */
    public void setOutputSQL(final java.lang.String outputSQL) {
        this._outputSQL = outputSQL;
        this._choiceValue = outputSQL;
    }

    /**
     * Sets the value of field 'SQLFor'.
     * 
     * @param SQLFor the value of field 'SQLFor'.
     */
    public void setSQLFor(final cto.framework.service.plugin.schema.SQLFor SQLFor) {
        this._SQLFor = SQLFor;
        this._choiceValue = SQLFor;
    }

    /**
     * 
     * 
     * @param index
     * @param vSQLIfElseGroup
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSQLIfElseGroup(final int index,final cto.framework.service.plugin.schema.SQLIfElseGroup vSQLIfElseGroup) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._SQLIfElseGroupList.size()) {
            throw new IndexOutOfBoundsException("setSQLIfElseGroup: Index value '" + index + "' not in range [0.." + (this._SQLIfElseGroupList.size() - 1) + "]");
        }

        this._SQLIfElseGroupList.set(index, vSQLIfElseGroup);
    }

    /**
     * 
     * 
     * @param vSQLIfElseGroupArray
     */
    public void setSQLIfElseGroup(final cto.framework.service.plugin.schema.SQLIfElseGroup[] vSQLIfElseGroupArray) {
        //-- copy array
        _SQLIfElseGroupList.clear();

        for (int i = 0; i < vSQLIfElseGroupArray.length; i++) {
                this._SQLIfElseGroupList.add(vSQLIfElseGroupArray[i]);
        }
    }

}
