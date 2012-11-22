/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3-RC1</a>, using an
 * XML Schema.
 * $Id$
 */

package cto.framework.service.plugin.schema;

/**
 * Class FinallyTypeChoiceItem.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class FinallyTypeChoiceItem implements java.io.Serializable {

    /**
     * Field _ifElseIfGroupList.
     */
    private java.util.List<cto.framework.service.plugin.schema.IfElseIfGroup> _ifElseIfGroupList;

    /**
     * Field _tryCatchFinallyGroupList.
     */
    private java.util.List<cto.framework.service.plugin.schema.TryCatchFinallyGroup> _tryCatchFinallyGroupList;

    /**
     * Field _log.
     */
    private cto.framework.service.plugin.schema.Log _log;

    /**
     * Field _for.
     */
    private cto.framework.service.plugin.schema.For _for;

    /**
     * Field _out.
     */
    private cto.framework.service.plugin.schema.Out _out;

    /**
     * Field _return.
     */
    private cto.framework.service.plugin.schema.Return _return;

    /**
     * Field _setValue.
     */
    private cto.framework.service.plugin.schema.SetValue _setValue;

    /**
     * Field _insert.
     */
    private cto.framework.service.plugin.schema.Insert _insert;

    /**
     * Field _update.
     */
    private cto.framework.service.plugin.schema.Update _update;

    /**
     * Field _delete.
     */
    private cto.framework.service.plugin.schema.Delete _delete;

    /**
     * Field _selectRecordSet.
     */
    private cto.framework.service.plugin.schema.SelectRecordSet _selectRecordSet;

    /**
     * Field _selectRecord.
     */
    private cto.framework.service.plugin.schema.SelectRecord _selectRecord;

    /**
     * Field _selectFeild.
     */
    private cto.framework.service.plugin.schema.SelectFeild _selectFeild;

    /**
     * Field _call.
     */
    private cto.framework.service.plugin.schema.Call _call;

    /**
     * Field _commitTrans.
     */
    private java.lang.Object _commitTrans;

    /**
     * Field _httpClient.
     */
    private cto.framework.service.plugin.schema.HttpClient _httpClient;

    /**
     * Field _bean.
     */
    private cto.framework.service.plugin.schema.Bean _bean;

    /**
     * Field _invoke.
     */
    private cto.framework.service.plugin.schema.Invoke _invoke;

    /**
     * Field _rollbackTrans.
     */
    private java.lang.Object _rollbackTrans;

    /**
     * Field _hadoopUtil.
     */
    private cto.framework.service.plugin.schema.HadoopUtil _hadoopUtil;

    public FinallyTypeChoiceItem() {
        super();
        this._ifElseIfGroupList = new java.util.ArrayList<cto.framework.service.plugin.schema.IfElseIfGroup>();
        this._tryCatchFinallyGroupList = new java.util.ArrayList<cto.framework.service.plugin.schema.TryCatchFinallyGroup>();
    }

    /**
     * 
     * 
     * @param vIfElseIfGroup
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addIfElseIfGroup(final cto.framework.service.plugin.schema.IfElseIfGroup vIfElseIfGroup) throws java.lang.IndexOutOfBoundsException {
        this._ifElseIfGroupList.add(vIfElseIfGroup);
    }

    /**
     * 
     * 
     * @param index
     * @param vIfElseIfGroup
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addIfElseIfGroup(final int index,final cto.framework.service.plugin.schema.IfElseIfGroup vIfElseIfGroup) throws java.lang.IndexOutOfBoundsException {
        this._ifElseIfGroupList.add(index, vIfElseIfGroup);
    }

    /**
     * 
     * 
     * @param vTryCatchFinallyGroup
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addTryCatchFinallyGroup(final cto.framework.service.plugin.schema.TryCatchFinallyGroup vTryCatchFinallyGroup) throws java.lang.IndexOutOfBoundsException {
        this._tryCatchFinallyGroupList.add(vTryCatchFinallyGroup);
    }

    /**
     * 
     * 
     * @param index
     * @param vTryCatchFinallyGroup
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addTryCatchFinallyGroup(final int index,final cto.framework.service.plugin.schema.TryCatchFinallyGroup vTryCatchFinallyGroup) throws java.lang.IndexOutOfBoundsException {
        this._tryCatchFinallyGroupList.add(index, vTryCatchFinallyGroup);
    }

    /**
     * Method enumerateIfElseIfGroup.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends cto.framework.service.plugin.schema.IfElseIfGroup> enumerateIfElseIfGroup() {
        return java.util.Collections.enumeration(this._ifElseIfGroupList);
    }

    /**
     * Method enumerateTryCatchFinallyGroup.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends cto.framework.service.plugin.schema.TryCatchFinallyGroup> enumerateTryCatchFinallyGroup() {
        return java.util.Collections.enumeration(this._tryCatchFinallyGroupList);
    }

    /**
     * Returns the value of field 'bean'.
     * 
     * @return the value of field 'Bean'.
     */
    public cto.framework.service.plugin.schema.Bean getBean() {
        return this._bean;
    }

    /**
     * Returns the value of field 'call'.
     * 
     * @return the value of field 'Call'.
     */
    public cto.framework.service.plugin.schema.Call getCall() {
        return this._call;
    }

    /**
     * Returns the value of field 'commitTrans'.
     * 
     * @return the value of field 'CommitTrans'.
     */
    public java.lang.Object getCommitTrans() {
        return this._commitTrans;
    }

    /**
     * Returns the value of field 'delete'.
     * 
     * @return the value of field 'Delete'.
     */
    public cto.framework.service.plugin.schema.Delete getDelete() {
        return this._delete;
    }

    /**
     * Returns the value of field 'for'.
     * 
     * @return the value of field 'For'.
     */
    public cto.framework.service.plugin.schema.For getFor() {
        return this._for;
    }

    /**
     * Returns the value of field 'hadoopUtil'.
     * 
     * @return the value of field 'HadoopUtil'.
     */
    public cto.framework.service.plugin.schema.HadoopUtil getHadoopUtil() {
        return this._hadoopUtil;
    }

    /**
     * Returns the value of field 'httpClient'.
     * 
     * @return the value of field 'HttpClient'.
     */
    public cto.framework.service.plugin.schema.HttpClient getHttpClient() {
        return this._httpClient;
    }

    /**
     * Method getIfElseIfGroup.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * cto.framework.service.plugin.schema.IfElseIfGroup at the
     * given index
     */
    public cto.framework.service.plugin.schema.IfElseIfGroup getIfElseIfGroup(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._ifElseIfGroupList.size()) {
            throw new IndexOutOfBoundsException("getIfElseIfGroup: Index value '" + index + "' not in range [0.." + (this._ifElseIfGroupList.size() - 1) + "]");
        }

        return _ifElseIfGroupList.get(index);
    }

    /**
     * Method getIfElseIfGroup.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public cto.framework.service.plugin.schema.IfElseIfGroup[] getIfElseIfGroup() {
        cto.framework.service.plugin.schema.IfElseIfGroup[] array = new cto.framework.service.plugin.schema.IfElseIfGroup[0];
        return this._ifElseIfGroupList.toArray(array);
    }

    /**
     * Method getIfElseIfGroupCount.
     * 
     * @return the size of this collection
     */
    public int getIfElseIfGroupCount() {
        return this._ifElseIfGroupList.size();
    }

    /**
     * Returns the value of field 'insert'.
     * 
     * @return the value of field 'Insert'.
     */
    public cto.framework.service.plugin.schema.Insert getInsert() {
        return this._insert;
    }

    /**
     * Returns the value of field 'invoke'.
     * 
     * @return the value of field 'Invoke'.
     */
    public cto.framework.service.plugin.schema.Invoke getInvoke() {
        return this._invoke;
    }

    /**
     * Returns the value of field 'log'.
     * 
     * @return the value of field 'Log'.
     */
    public cto.framework.service.plugin.schema.Log getLog() {
        return this._log;
    }

    /**
     * Returns the value of field 'out'.
     * 
     * @return the value of field 'Out'.
     */
    public cto.framework.service.plugin.schema.Out getOut() {
        return this._out;
    }

    /**
     * Returns the value of field 'return'.
     * 
     * @return the value of field 'Return'.
     */
    public cto.framework.service.plugin.schema.Return getReturn() {
        return this._return;
    }

    /**
     * Returns the value of field 'rollbackTrans'.
     * 
     * @return the value of field 'RollbackTrans'.
     */
    public java.lang.Object getRollbackTrans() {
        return this._rollbackTrans;
    }

    /**
     * Returns the value of field 'selectFeild'.
     * 
     * @return the value of field 'SelectFeild'.
     */
    public cto.framework.service.plugin.schema.SelectFeild getSelectFeild() {
        return this._selectFeild;
    }

    /**
     * Returns the value of field 'selectRecord'.
     * 
     * @return the value of field 'SelectRecord'.
     */
    public cto.framework.service.plugin.schema.SelectRecord getSelectRecord() {
        return this._selectRecord;
    }

    /**
     * Returns the value of field 'selectRecordSet'.
     * 
     * @return the value of field 'SelectRecordSet'.
     */
    public cto.framework.service.plugin.schema.SelectRecordSet getSelectRecordSet() {
        return this._selectRecordSet;
    }

    /**
     * Returns the value of field 'setValue'.
     * 
     * @return the value of field 'SetValue'.
     */
    public cto.framework.service.plugin.schema.SetValue getSetValue() {
        return this._setValue;
    }

    /**
     * Method getTryCatchFinallyGroup.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * cto.framework.service.plugin.schema.TryCatchFinallyGroup at
     * the given index
     */
    public cto.framework.service.plugin.schema.TryCatchFinallyGroup getTryCatchFinallyGroup(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._tryCatchFinallyGroupList.size()) {
            throw new IndexOutOfBoundsException("getTryCatchFinallyGroup: Index value '" + index + "' not in range [0.." + (this._tryCatchFinallyGroupList.size() - 1) + "]");
        }

        return _tryCatchFinallyGroupList.get(index);
    }

    /**
     * Method getTryCatchFinallyGroup.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public cto.framework.service.plugin.schema.TryCatchFinallyGroup[] getTryCatchFinallyGroup() {
        cto.framework.service.plugin.schema.TryCatchFinallyGroup[] array = new cto.framework.service.plugin.schema.TryCatchFinallyGroup[0];
        return this._tryCatchFinallyGroupList.toArray(array);
    }

    /**
     * Method getTryCatchFinallyGroupCount.
     * 
     * @return the size of this collection
     */
    public int getTryCatchFinallyGroupCount() {
        return this._tryCatchFinallyGroupList.size();
    }

    /**
     * Returns the value of field 'update'.
     * 
     * @return the value of field 'Update'.
     */
    public cto.framework.service.plugin.schema.Update getUpdate() {
        return this._update;
    }

    /**
     * Method iterateIfElseIfGroup.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends cto.framework.service.plugin.schema.IfElseIfGroup> iterateIfElseIfGroup() {
        return this._ifElseIfGroupList.iterator();
    }

    /**
     * Method iterateTryCatchFinallyGroup.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends cto.framework.service.plugin.schema.TryCatchFinallyGroup> iterateTryCatchFinallyGroup() {
        return this._tryCatchFinallyGroupList.iterator();
    }

    /**
     */
    public void removeAllIfElseIfGroup() {
        this._ifElseIfGroupList.clear();
    }

    /**
     */
    public void removeAllTryCatchFinallyGroup() {
        this._tryCatchFinallyGroupList.clear();
    }

    /**
     * Method removeIfElseIfGroup.
     * 
     * @param vIfElseIfGroup
     * @return true if the object was removed from the collection.
     */
    public boolean removeIfElseIfGroup(final cto.framework.service.plugin.schema.IfElseIfGroup vIfElseIfGroup) {
        boolean removed = _ifElseIfGroupList.remove(vIfElseIfGroup);
        return removed;
    }

    /**
     * Method removeIfElseIfGroupAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public cto.framework.service.plugin.schema.IfElseIfGroup removeIfElseIfGroupAt(final int index) {
        java.lang.Object obj = this._ifElseIfGroupList.remove(index);
        return (cto.framework.service.plugin.schema.IfElseIfGroup) obj;
    }

    /**
     * Method removeTryCatchFinallyGroup.
     * 
     * @param vTryCatchFinallyGroup
     * @return true if the object was removed from the collection.
     */
    public boolean removeTryCatchFinallyGroup(final cto.framework.service.plugin.schema.TryCatchFinallyGroup vTryCatchFinallyGroup) {
        boolean removed = _tryCatchFinallyGroupList.remove(vTryCatchFinallyGroup);
        return removed;
    }

    /**
     * Method removeTryCatchFinallyGroupAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public cto.framework.service.plugin.schema.TryCatchFinallyGroup removeTryCatchFinallyGroupAt(final int index) {
        java.lang.Object obj = this._tryCatchFinallyGroupList.remove(index);
        return (cto.framework.service.plugin.schema.TryCatchFinallyGroup) obj;
    }

    /**
     * Sets the value of field 'bean'.
     * 
     * @param bean the value of field 'bean'.
     */
    public void setBean(final cto.framework.service.plugin.schema.Bean bean) {
        this._bean = bean;
    }

    /**
     * Sets the value of field 'call'.
     * 
     * @param call the value of field 'call'.
     */
    public void setCall(final cto.framework.service.plugin.schema.Call call) {
        this._call = call;
    }

    /**
     * Sets the value of field 'commitTrans'.
     * 
     * @param commitTrans the value of field 'commitTrans'.
     */
    public void setCommitTrans(final java.lang.Object commitTrans) {
        this._commitTrans = commitTrans;
    }

    /**
     * Sets the value of field 'delete'.
     * 
     * @param delete the value of field 'delete'.
     */
    public void setDelete(final cto.framework.service.plugin.schema.Delete delete) {
        this._delete = delete;
    }

    /**
     * Sets the value of field 'for'.
     * 
     * @param _for
     * @param for the value of field 'for'.
     */
    public void setFor(final cto.framework.service.plugin.schema.For _for) {
        this._for = _for;
    }

    /**
     * Sets the value of field 'hadoopUtil'.
     * 
     * @param hadoopUtil the value of field 'hadoopUtil'.
     */
    public void setHadoopUtil(final cto.framework.service.plugin.schema.HadoopUtil hadoopUtil) {
        this._hadoopUtil = hadoopUtil;
    }

    /**
     * Sets the value of field 'httpClient'.
     * 
     * @param httpClient the value of field 'httpClient'.
     */
    public void setHttpClient(final cto.framework.service.plugin.schema.HttpClient httpClient) {
        this._httpClient = httpClient;
    }

    /**
     * 
     * 
     * @param index
     * @param vIfElseIfGroup
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setIfElseIfGroup(final int index,final cto.framework.service.plugin.schema.IfElseIfGroup vIfElseIfGroup) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._ifElseIfGroupList.size()) {
            throw new IndexOutOfBoundsException("setIfElseIfGroup: Index value '" + index + "' not in range [0.." + (this._ifElseIfGroupList.size() - 1) + "]");
        }

        this._ifElseIfGroupList.set(index, vIfElseIfGroup);
    }

    /**
     * 
     * 
     * @param vIfElseIfGroupArray
     */
    public void setIfElseIfGroup(final cto.framework.service.plugin.schema.IfElseIfGroup[] vIfElseIfGroupArray) {
        //-- copy array
        _ifElseIfGroupList.clear();

        for (int i = 0; i < vIfElseIfGroupArray.length; i++) {
                this._ifElseIfGroupList.add(vIfElseIfGroupArray[i]);
        }
    }

    /**
     * Sets the value of field 'insert'.
     * 
     * @param insert the value of field 'insert'.
     */
    public void setInsert(final cto.framework.service.plugin.schema.Insert insert) {
        this._insert = insert;
    }

    /**
     * Sets the value of field 'invoke'.
     * 
     * @param invoke the value of field 'invoke'.
     */
    public void setInvoke(final cto.framework.service.plugin.schema.Invoke invoke) {
        this._invoke = invoke;
    }

    /**
     * Sets the value of field 'log'.
     * 
     * @param log the value of field 'log'.
     */
    public void setLog(final cto.framework.service.plugin.schema.Log log) {
        this._log = log;
    }

    /**
     * Sets the value of field 'out'.
     * 
     * @param out the value of field 'out'.
     */
    public void setOut(final cto.framework.service.plugin.schema.Out out) {
        this._out = out;
    }

    /**
     * Sets the value of field 'return'.
     * 
     * @param _return
     * @param return the value of field 'return'.
     */
    public void setReturn(final cto.framework.service.plugin.schema.Return _return) {
        this._return = _return;
    }

    /**
     * Sets the value of field 'rollbackTrans'.
     * 
     * @param rollbackTrans the value of field 'rollbackTrans'.
     */
    public void setRollbackTrans(final java.lang.Object rollbackTrans) {
        this._rollbackTrans = rollbackTrans;
    }

    /**
     * Sets the value of field 'selectFeild'.
     * 
     * @param selectFeild the value of field 'selectFeild'.
     */
    public void setSelectFeild(final cto.framework.service.plugin.schema.SelectFeild selectFeild) {
        this._selectFeild = selectFeild;
    }

    /**
     * Sets the value of field 'selectRecord'.
     * 
     * @param selectRecord the value of field 'selectRecord'.
     */
    public void setSelectRecord(final cto.framework.service.plugin.schema.SelectRecord selectRecord) {
        this._selectRecord = selectRecord;
    }

    /**
     * Sets the value of field 'selectRecordSet'.
     * 
     * @param selectRecordSet the value of field 'selectRecordSet'.
     */
    public void setSelectRecordSet(final cto.framework.service.plugin.schema.SelectRecordSet selectRecordSet) {
        this._selectRecordSet = selectRecordSet;
    }

    /**
     * Sets the value of field 'setValue'.
     * 
     * @param setValue the value of field 'setValue'.
     */
    public void setSetValue(final cto.framework.service.plugin.schema.SetValue setValue) {
        this._setValue = setValue;
    }

    /**
     * 
     * 
     * @param index
     * @param vTryCatchFinallyGroup
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setTryCatchFinallyGroup(final int index,final cto.framework.service.plugin.schema.TryCatchFinallyGroup vTryCatchFinallyGroup) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._tryCatchFinallyGroupList.size()) {
            throw new IndexOutOfBoundsException("setTryCatchFinallyGroup: Index value '" + index + "' not in range [0.." + (this._tryCatchFinallyGroupList.size() - 1) + "]");
        }

        this._tryCatchFinallyGroupList.set(index, vTryCatchFinallyGroup);
    }

    /**
     * 
     * 
     * @param vTryCatchFinallyGroupArray
     */
    public void setTryCatchFinallyGroup(final cto.framework.service.plugin.schema.TryCatchFinallyGroup[] vTryCatchFinallyGroupArray) {
        //-- copy array
        _tryCatchFinallyGroupList.clear();

        for (int i = 0; i < vTryCatchFinallyGroupArray.length; i++) {
                this._tryCatchFinallyGroupList.add(vTryCatchFinallyGroupArray[i]);
        }
    }

    /**
     * Sets the value of field 'update'.
     * 
     * @param update the value of field 'update'.
     */
    public void setUpdate(final cto.framework.service.plugin.schema.Update update) {
        this._update = update;
    }

}
