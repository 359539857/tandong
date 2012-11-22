/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3-RC1</a>, using an
 * XML Schema.
 * $Id$
 */

package cto.framework.web.action.plugin.schema;

/**
 * Class ForTypeChoiceItem.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ForTypeChoiceItem implements java.io.Serializable {

    /**
     * Field _ifElseIfGroupList.
     */
    private java.util.List<cto.framework.web.action.plugin.schema.IfElseIfGroup> _ifElseIfGroupList;

    /**
     * Field _tryCatchFinallyGroupList.
     */
    private java.util.List<cto.framework.web.action.plugin.schema.TryCatchFinallyGroup> _tryCatchFinallyGroupList;

    /**
     * Field _log.
     */
    private cto.framework.web.action.plugin.schema.Log _log;

    /**
     * Field _for.
     */
    private cto.framework.web.action.plugin.schema.For _for;

    /**
     * Field _return.
     */
    private cto.framework.web.action.plugin.schema.Return _return;

    /**
     * Field _setValue.
     */
    private cto.framework.web.action.plugin.schema.SetValue _setValue;

    /**
     * Field _out.
     */
    private cto.framework.web.action.plugin.schema.Out _out;

    /**
     * Field _call.
     */
    private cto.framework.web.action.plugin.schema.Call _call;

    /**
     * Field _httpClient.
     */
    private cto.framework.web.action.plugin.schema.HttpClient _httpClient;

    /**
     * Field _bean.
     */
    private cto.framework.web.action.plugin.schema.Bean _bean;

    /**
     * Field _invoke.
     */
    private cto.framework.web.action.plugin.schema.Invoke _invoke;

    /**
     * Field _setRequest.
     */
    private cto.framework.web.action.plugin.schema.SetRequest _setRequest;

    /**
     * Field _setSession.
     */
    private cto.framework.web.action.plugin.schema.SetSession _setSession;

    /**
     * Field _setApplication.
     */
    private cto.framework.web.action.plugin.schema.SetApplication _setApplication;

    /**
     * Field _outResponse.
     */
    private cto.framework.web.action.plugin.schema.OutResponse _outResponse;

    /**
     * Field _hadoopUtil.
     */
    private cto.framework.web.action.plugin.schema.HadoopUtil _hadoopUtil;

    public ForTypeChoiceItem() {
        super();
        this._ifElseIfGroupList = new java.util.ArrayList<cto.framework.web.action.plugin.schema.IfElseIfGroup>();
        this._tryCatchFinallyGroupList = new java.util.ArrayList<cto.framework.web.action.plugin.schema.TryCatchFinallyGroup>();
    }

    /**
     * 
     * 
     * @param vIfElseIfGroup
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addIfElseIfGroup(final cto.framework.web.action.plugin.schema.IfElseIfGroup vIfElseIfGroup) throws java.lang.IndexOutOfBoundsException {
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
    public void addIfElseIfGroup(final int index,final cto.framework.web.action.plugin.schema.IfElseIfGroup vIfElseIfGroup) throws java.lang.IndexOutOfBoundsException {
        this._ifElseIfGroupList.add(index, vIfElseIfGroup);
    }

    /**
     * 
     * 
     * @param vTryCatchFinallyGroup
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addTryCatchFinallyGroup(final cto.framework.web.action.plugin.schema.TryCatchFinallyGroup vTryCatchFinallyGroup) throws java.lang.IndexOutOfBoundsException {
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
    public void addTryCatchFinallyGroup(final int index,final cto.framework.web.action.plugin.schema.TryCatchFinallyGroup vTryCatchFinallyGroup) throws java.lang.IndexOutOfBoundsException {
        this._tryCatchFinallyGroupList.add(index, vTryCatchFinallyGroup);
    }

    /**
     * Method enumerateIfElseIfGroup.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends cto.framework.web.action.plugin.schema.IfElseIfGroup> enumerateIfElseIfGroup() {
        return java.util.Collections.enumeration(this._ifElseIfGroupList);
    }

    /**
     * Method enumerateTryCatchFinallyGroup.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends cto.framework.web.action.plugin.schema.TryCatchFinallyGroup> enumerateTryCatchFinallyGroup() {
        return java.util.Collections.enumeration(this._tryCatchFinallyGroupList);
    }

    /**
     * Returns the value of field 'bean'.
     * 
     * @return the value of field 'Bean'.
     */
    public cto.framework.web.action.plugin.schema.Bean getBean() {
        return this._bean;
    }

    /**
     * Returns the value of field 'call'.
     * 
     * @return the value of field 'Call'.
     */
    public cto.framework.web.action.plugin.schema.Call getCall() {
        return this._call;
    }

    /**
     * Returns the value of field 'for'.
     * 
     * @return the value of field 'For'.
     */
    public cto.framework.web.action.plugin.schema.For getFor() {
        return this._for;
    }

    /**
     * Returns the value of field 'hadoopUtil'.
     * 
     * @return the value of field 'HadoopUtil'.
     */
    public cto.framework.web.action.plugin.schema.HadoopUtil getHadoopUtil() {
        return this._hadoopUtil;
    }

    /**
     * Returns the value of field 'httpClient'.
     * 
     * @return the value of field 'HttpClient'.
     */
    public cto.framework.web.action.plugin.schema.HttpClient getHttpClient() {
        return this._httpClient;
    }

    /**
     * Method getIfElseIfGroup.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * cto.framework.web.action.plugin.schema.IfElseIfGroup at the
     * given index
     */
    public cto.framework.web.action.plugin.schema.IfElseIfGroup getIfElseIfGroup(final int index) throws java.lang.IndexOutOfBoundsException {
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
    public cto.framework.web.action.plugin.schema.IfElseIfGroup[] getIfElseIfGroup() {
        cto.framework.web.action.plugin.schema.IfElseIfGroup[] array = new cto.framework.web.action.plugin.schema.IfElseIfGroup[0];
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
     * Returns the value of field 'invoke'.
     * 
     * @return the value of field 'Invoke'.
     */
    public cto.framework.web.action.plugin.schema.Invoke getInvoke() {
        return this._invoke;
    }

    /**
     * Returns the value of field 'log'.
     * 
     * @return the value of field 'Log'.
     */
    public cto.framework.web.action.plugin.schema.Log getLog() {
        return this._log;
    }

    /**
     * Returns the value of field 'out'.
     * 
     * @return the value of field 'Out'.
     */
    public cto.framework.web.action.plugin.schema.Out getOut() {
        return this._out;
    }

    /**
     * Returns the value of field 'outResponse'.
     * 
     * @return the value of field 'OutResponse'.
     */
    public cto.framework.web.action.plugin.schema.OutResponse getOutResponse() {
        return this._outResponse;
    }

    /**
     * Returns the value of field 'return'.
     * 
     * @return the value of field 'Return'.
     */
    public cto.framework.web.action.plugin.schema.Return getReturn() {
        return this._return;
    }

    /**
     * Returns the value of field 'setApplication'.
     * 
     * @return the value of field 'SetApplication'.
     */
    public cto.framework.web.action.plugin.schema.SetApplication getSetApplication() {
        return this._setApplication;
    }

    /**
     * Returns the value of field 'setRequest'.
     * 
     * @return the value of field 'SetRequest'.
     */
    public cto.framework.web.action.plugin.schema.SetRequest getSetRequest() {
        return this._setRequest;
    }

    /**
     * Returns the value of field 'setSession'.
     * 
     * @return the value of field 'SetSession'.
     */
    public cto.framework.web.action.plugin.schema.SetSession getSetSession() {
        return this._setSession;
    }

    /**
     * Returns the value of field 'setValue'.
     * 
     * @return the value of field 'SetValue'.
     */
    public cto.framework.web.action.plugin.schema.SetValue getSetValue() {
        return this._setValue;
    }

    /**
     * Method getTryCatchFinallyGroup.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * cto.framework.web.action.plugin.schema.TryCatchFinallyGroup
     * at the given index
     */
    public cto.framework.web.action.plugin.schema.TryCatchFinallyGroup getTryCatchFinallyGroup(final int index) throws java.lang.IndexOutOfBoundsException {
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
    public cto.framework.web.action.plugin.schema.TryCatchFinallyGroup[] getTryCatchFinallyGroup() {
        cto.framework.web.action.plugin.schema.TryCatchFinallyGroup[] array = new cto.framework.web.action.plugin.schema.TryCatchFinallyGroup[0];
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
     * Method iterateIfElseIfGroup.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends cto.framework.web.action.plugin.schema.IfElseIfGroup> iterateIfElseIfGroup() {
        return this._ifElseIfGroupList.iterator();
    }

    /**
     * Method iterateTryCatchFinallyGroup.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends cto.framework.web.action.plugin.schema.TryCatchFinallyGroup> iterateTryCatchFinallyGroup() {
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
    public boolean removeIfElseIfGroup(final cto.framework.web.action.plugin.schema.IfElseIfGroup vIfElseIfGroup) {
        boolean removed = _ifElseIfGroupList.remove(vIfElseIfGroup);
        return removed;
    }

    /**
     * Method removeIfElseIfGroupAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public cto.framework.web.action.plugin.schema.IfElseIfGroup removeIfElseIfGroupAt(final int index) {
        java.lang.Object obj = this._ifElseIfGroupList.remove(index);
        return (cto.framework.web.action.plugin.schema.IfElseIfGroup) obj;
    }

    /**
     * Method removeTryCatchFinallyGroup.
     * 
     * @param vTryCatchFinallyGroup
     * @return true if the object was removed from the collection.
     */
    public boolean removeTryCatchFinallyGroup(final cto.framework.web.action.plugin.schema.TryCatchFinallyGroup vTryCatchFinallyGroup) {
        boolean removed = _tryCatchFinallyGroupList.remove(vTryCatchFinallyGroup);
        return removed;
    }

    /**
     * Method removeTryCatchFinallyGroupAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public cto.framework.web.action.plugin.schema.TryCatchFinallyGroup removeTryCatchFinallyGroupAt(final int index) {
        java.lang.Object obj = this._tryCatchFinallyGroupList.remove(index);
        return (cto.framework.web.action.plugin.schema.TryCatchFinallyGroup) obj;
    }

    /**
     * Sets the value of field 'bean'.
     * 
     * @param bean the value of field 'bean'.
     */
    public void setBean(final cto.framework.web.action.plugin.schema.Bean bean) {
        this._bean = bean;
    }

    /**
     * Sets the value of field 'call'.
     * 
     * @param call the value of field 'call'.
     */
    public void setCall(final cto.framework.web.action.plugin.schema.Call call) {
        this._call = call;
    }

    /**
     * Sets the value of field 'for'.
     * 
     * @param _for
     * @param for the value of field 'for'.
     */
    public void setFor(final cto.framework.web.action.plugin.schema.For _for) {
        this._for = _for;
    }

    /**
     * Sets the value of field 'hadoopUtil'.
     * 
     * @param hadoopUtil the value of field 'hadoopUtil'.
     */
    public void setHadoopUtil(final cto.framework.web.action.plugin.schema.HadoopUtil hadoopUtil) {
        this._hadoopUtil = hadoopUtil;
    }

    /**
     * Sets the value of field 'httpClient'.
     * 
     * @param httpClient the value of field 'httpClient'.
     */
    public void setHttpClient(final cto.framework.web.action.plugin.schema.HttpClient httpClient) {
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
    public void setIfElseIfGroup(final int index,final cto.framework.web.action.plugin.schema.IfElseIfGroup vIfElseIfGroup) throws java.lang.IndexOutOfBoundsException {
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
    public void setIfElseIfGroup(final cto.framework.web.action.plugin.schema.IfElseIfGroup[] vIfElseIfGroupArray) {
        //-- copy array
        _ifElseIfGroupList.clear();

        for (int i = 0; i < vIfElseIfGroupArray.length; i++) {
                this._ifElseIfGroupList.add(vIfElseIfGroupArray[i]);
        }
    }

    /**
     * Sets the value of field 'invoke'.
     * 
     * @param invoke the value of field 'invoke'.
     */
    public void setInvoke(final cto.framework.web.action.plugin.schema.Invoke invoke) {
        this._invoke = invoke;
    }

    /**
     * Sets the value of field 'log'.
     * 
     * @param log the value of field 'log'.
     */
    public void setLog(final cto.framework.web.action.plugin.schema.Log log) {
        this._log = log;
    }

    /**
     * Sets the value of field 'out'.
     * 
     * @param out the value of field 'out'.
     */
    public void setOut(final cto.framework.web.action.plugin.schema.Out out) {
        this._out = out;
    }

    /**
     * Sets the value of field 'outResponse'.
     * 
     * @param outResponse the value of field 'outResponse'.
     */
    public void setOutResponse(final cto.framework.web.action.plugin.schema.OutResponse outResponse) {
        this._outResponse = outResponse;
    }

    /**
     * Sets the value of field 'return'.
     * 
     * @param _return
     * @param return the value of field 'return'.
     */
    public void setReturn(final cto.framework.web.action.plugin.schema.Return _return) {
        this._return = _return;
    }

    /**
     * Sets the value of field 'setApplication'.
     * 
     * @param setApplication the value of field 'setApplication'.
     */
    public void setSetApplication(final cto.framework.web.action.plugin.schema.SetApplication setApplication) {
        this._setApplication = setApplication;
    }

    /**
     * Sets the value of field 'setRequest'.
     * 
     * @param setRequest the value of field 'setRequest'.
     */
    public void setSetRequest(final cto.framework.web.action.plugin.schema.SetRequest setRequest) {
        this._setRequest = setRequest;
    }

    /**
     * Sets the value of field 'setSession'.
     * 
     * @param setSession the value of field 'setSession'.
     */
    public void setSetSession(final cto.framework.web.action.plugin.schema.SetSession setSession) {
        this._setSession = setSession;
    }

    /**
     * Sets the value of field 'setValue'.
     * 
     * @param setValue the value of field 'setValue'.
     */
    public void setSetValue(final cto.framework.web.action.plugin.schema.SetValue setValue) {
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
    public void setTryCatchFinallyGroup(final int index,final cto.framework.web.action.plugin.schema.TryCatchFinallyGroup vTryCatchFinallyGroup) throws java.lang.IndexOutOfBoundsException {
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
    public void setTryCatchFinallyGroup(final cto.framework.web.action.plugin.schema.TryCatchFinallyGroup[] vTryCatchFinallyGroupArray) {
        //-- copy array
        _tryCatchFinallyGroupList.clear();

        for (int i = 0; i < vTryCatchFinallyGroupArray.length; i++) {
                this._tryCatchFinallyGroupList.add(vTryCatchFinallyGroupArray[i]);
        }
    }

}
