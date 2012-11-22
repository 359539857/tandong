/**
 * 
 */
package cto.framework.service;

import java.io.Serializable;
import java.util.Map;

import cto.framework.service.cache.memcache.CacheManager;
import cto.framework.service.plugin.schema.Call;
import cto.framework.service.plugin.schema.Delete;
import cto.framework.service.plugin.schema.For;
import cto.framework.service.plugin.schema.IfElseIfGroup;
import cto.framework.service.plugin.schema.Insert;
import cto.framework.service.plugin.schema.Log;
import cto.framework.service.plugin.schema.Out;
import cto.framework.service.plugin.schema.Return;
import cto.framework.service.plugin.schema.SelectFeild;
import cto.framework.service.plugin.schema.SelectRecordSet;
import cto.framework.service.plugin.schema.Service;
import cto.framework.service.plugin.schema.SetValue;
import cto.framework.service.plugin.schema.Throw;
import cto.framework.service.plugin.schema.Trans;
import cto.framework.service.plugin.schema.TransTypeChoiceItem;
import cto.framework.service.plugin.schema.TryCatchFinallyGroup;
import cto.framework.service.plugin.schema.Update;

/**
 * @author PeterTan
 * 
 */
public interface ITransEngine extends Serializable {

	public void setServiceBus(ServiceBus serviceBus);

	public void setPropertyMap(Map<String, String> propertyMap);

	public void setTransParameterMap(Map<String, String> transParameterMap);

	public void setTransMap(Map<String, Trans> transMap);

	public void setDataSourceGroupMap(Map<String, CycleMap<String, IDataEngine>> dataSourceGroupMap);

	public void setServiceMap(Map<String, Service> serviceMap);

	public void onActionThrow(Throw $throw, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception;

	public void onActionOut(Out out, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception;

	public Return onActionFor(For $for, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception;

	public void onActionLog(Log log, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception;

	public Return onActionTryCatchFinallyGroup(TryCatchFinallyGroup tryCatchFinallyGroup, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception;

	public Return onActionCall(Call call, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception;

	public Return onActionIfElseIfGroup(IfElseIfGroup ifElseIfGroup, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception;

	public Return onActionReturn(Return $return, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception;

	public void onActionSetValue(SetValue setValue, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception;

	public void onActionSelectRecordSet(SelectRecordSet selectRecordSet, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception;

	public void onActionSelectFeild(SelectFeild selectFeild, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception;

	public void onActionDelete(Delete delete, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception;

	public void onActionUpdate(Update update, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception;

	public void onActionInsert(Insert insert, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception;

	public cto.framework.service.plugin.schema.Return onActionItem(TransTypeChoiceItem[] transTypeChoiceItem, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception;

	public void setCacheManager(CacheManager cacheManager);

}
