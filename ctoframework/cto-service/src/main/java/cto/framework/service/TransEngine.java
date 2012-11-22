/**
 * 
 */
package cto.framework.service;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;

import cto.framework.core.CTO;
import cto.framework.core.Constant;
import cto.framework.core.json.JSONException;
import cto.framework.core.util.HttpUtils;
import cto.framework.core.util.ParameterUtils;
import cto.framework.core.util.ReflectUtils;
import cto.framework.core.util.StringHelper;
import cto.framework.service.cache.memcache.CacheManager;
import cto.framework.service.helper.EngineHelper;
import cto.framework.service.helper.ExceptionHelper;
import cto.framework.service.helper.ReturnHelper;
import cto.framework.service.plugin.schema.Bean;
import cto.framework.service.plugin.schema.Call;
import cto.framework.service.plugin.schema.Catch;
import cto.framework.service.plugin.schema.CatchTypeChoice;
import cto.framework.service.plugin.schema.CatchTypeChoiceItem;
import cto.framework.service.plugin.schema.Delete;
import cto.framework.service.plugin.schema.Else;
import cto.framework.service.plugin.schema.ElseIfTypeChoice;
import cto.framework.service.plugin.schema.ElseIfTypeChoiceItem;
import cto.framework.service.plugin.schema.ElseTypeChoice;
import cto.framework.service.plugin.schema.ElseTypeChoiceItem;
import cto.framework.service.plugin.schema.Elseif;
import cto.framework.service.plugin.schema.Finally;
import cto.framework.service.plugin.schema.FinallyTypeChoice;
import cto.framework.service.plugin.schema.FinallyTypeChoiceItem;
import cto.framework.service.plugin.schema.For;
import cto.framework.service.plugin.schema.ForTypeChoice;
import cto.framework.service.plugin.schema.ForTypeChoiceItem;
import cto.framework.service.plugin.schema.HadoopUtil;
import cto.framework.service.plugin.schema.HttpClient;
import cto.framework.service.plugin.schema.If;
import cto.framework.service.plugin.schema.IfElseIfGroup;
import cto.framework.service.plugin.schema.IfTypeChoice;
import cto.framework.service.plugin.schema.IfTypeChoiceItem;
import cto.framework.service.plugin.schema.Insert;
import cto.framework.service.plugin.schema.Invoke;
import cto.framework.service.plugin.schema.Log;
import cto.framework.service.plugin.schema.MethodParameter;
import cto.framework.service.plugin.schema.Out;
import cto.framework.service.plugin.schema.Param;
import cto.framework.service.plugin.schema.Parameter;
import cto.framework.service.plugin.schema.Property;
import cto.framework.service.plugin.schema.Return;
import cto.framework.service.plugin.schema.ReturnItem;
import cto.framework.service.plugin.schema.SelectFeild;
import cto.framework.service.plugin.schema.SelectRecord;
import cto.framework.service.plugin.schema.SelectRecordSet;
import cto.framework.service.plugin.schema.Service;
import cto.framework.service.plugin.schema.SetValue;
import cto.framework.service.plugin.schema.Throw;
import cto.framework.service.plugin.schema.Trans;
import cto.framework.service.plugin.schema.TransTypeChoiceItem;
import cto.framework.service.plugin.schema.Try;
import cto.framework.service.plugin.schema.TryCatchFinallyGroup;
import cto.framework.service.plugin.schema.TryTypeChoice;
import cto.framework.service.plugin.schema.TryTypeChoiceItem;
import cto.framework.service.plugin.schema.Update;
import cto.framework.service.plugin.schema.types.HttpType;

/**
 * @author PeterTan
 * 
 */
public class TransEngine implements ITransEngine {

	private static Logger logger = Logger.getLogger(TransEngine.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 760614937421603154L;

	private Map<String, String> propertyMap;
	private Map<String, String> transParameterMap;
	private Map<String, CycleMap<String, IDataEngine>> dataSourceGroupMap;
	private Map<String, Service> serviceMap;
	private Map<String, Trans> transMap;
	private ServiceBus serviceBus;
	private CacheManager cacheManager;

	public TransEngine() {
		propertyMap = new HashMap<String, String>();
		transParameterMap = new HashMap<String, String>();
		dataSourceGroupMap = new HashMap<String, CycleMap<String, IDataEngine>>();
		serviceMap = new HashMap<String, Service>();
		transMap = new HashMap<String, Trans>();
	}

	public Return onActionItem(TransTypeChoiceItem[] transTypeChoiceItems, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception {

		for (TransTypeChoiceItem transTypeChoiceItem : transTypeChoiceItems) {
			For $for = transTypeChoiceItem.getFor();
			if ($for != null) {
				Return ifReturn = this.onActionFor($for, ctoRequest, ctoResponse);
				if (!this.proccessSuccessed(ifReturn)) {
					return ifReturn;
				}
				continue;
			}
			int ifElseIfGroupCount = transTypeChoiceItem.getIfElseIfGroupCount();
			if (ifElseIfGroupCount > 0) {
				IfElseIfGroup[] ifElseIfGroups = transTypeChoiceItem.getIfElseIfGroup();
				Return elseReturn = this.onActionIfElseIfGroups(ifElseIfGroups, ctoRequest, ctoResponse);
				if (!this.proccessSuccessed(elseReturn)) {
					return elseReturn;
				}
				continue;
			}
			Log log = transTypeChoiceItem.getLog();
			if (log != null) {
				this.onActionLog(log, ctoRequest, ctoResponse);
				continue;
			}
			Out out = transTypeChoiceItem.getOut();
			if (out != null) {
				this.onActionOut(out, ctoRequest, ctoResponse);
				continue;
			}
			Return $return = transTypeChoiceItem.getReturn();
			if ($return != null) {
				return this.onActionReturn($return, ctoRequest, ctoResponse);
			}
			SetValue set = transTypeChoiceItem.getSetValue();
			if (set != null) {
				this.onActionSetValue(set, ctoRequest, ctoResponse);
				continue;
			}
			int tryCatchFinallyGroupCount = transTypeChoiceItem.getTryCatchFinallyGroupCount();
			if (tryCatchFinallyGroupCount > 0) {
				TryCatchFinallyGroup[] tryCatchFinallyGroups = transTypeChoiceItem.getTryCatchFinallyGroup();
				Return catchReturn = this.onActionTryCatchFinallyGroups(tryCatchFinallyGroups, ctoRequest, ctoResponse);
				if (!this.proccessSuccessed(catchReturn)) {
					return catchReturn;
				}
				continue;
			}
			Insert insert = transTypeChoiceItem.getInsert();
			if (insert != null) {
				this.onActionInsert(insert, ctoRequest, ctoResponse);
				continue;
			}
			Update update = transTypeChoiceItem.getUpdate();
			if (update != null) {
				this.onActionUpdate(update, ctoRequest, ctoResponse);
				continue;
			}
			Delete delete = transTypeChoiceItem.getDelete();
			if (delete != null) {
				this.onActionDelete(delete, ctoRequest, ctoResponse);
				continue;
			}
			SelectRecordSet selectRecordSet = transTypeChoiceItem.getSelectRecordSet();
			if (selectRecordSet != null) {
				this.onActionSelectRecordSet(selectRecordSet, ctoRequest, ctoResponse);
				continue;
			}
			SelectRecord selectRecord = transTypeChoiceItem.getSelectRecord();
			if (selectRecord != null) {
				this.onActionSelectRecord(selectRecord, ctoRequest, ctoResponse);
				continue;
			}
			SelectFeild selectFeild = transTypeChoiceItem.getSelectFeild();
			if (selectFeild != null) {
				this.onActionSelectFeild(selectFeild, ctoRequest, ctoResponse);
				continue;
			}
			Call call = transTypeChoiceItem.getCall();
			if (call != null) {
				Return logReturn = this.onActionCall(call, ctoRequest, ctoResponse);
				if (!this.proccessSuccessed(logReturn)) {
					return logReturn;
				}
				continue;
			}

			HttpClient httpClient = transTypeChoiceItem.getHttpClient();
			if (httpClient != null) {
				this.onActionHttpClient(httpClient, ctoRequest, ctoResponse);
				continue;
			}

			HadoopUtil hadoopUtil = transTypeChoiceItem.getHadoopUtil();
			if (hadoopUtil != null) {
				this.onActionHadoopUtil(hadoopUtil, ctoRequest, ctoResponse);
				continue;
			}

			Object commitTrans = transTypeChoiceItem.getCommitTrans();
			if (commitTrans != null) {
				this.onActionCommitTrans(commitTrans, ctoRequest, ctoResponse);
				continue;
			}

			Object rollbackTrans = transTypeChoiceItem.getRollbackTrans();
			if (rollbackTrans != null) {
				this.onActionRollbackTrans(rollbackTrans, ctoRequest, ctoResponse);
				continue;
			}

			Bean bean = transTypeChoiceItem.getBean();
			if (bean != null) {
				this.onActionBean(bean, ctoRequest, ctoResponse);
				continue;
			}

			Invoke invoke = transTypeChoiceItem.getInvoke();
			if (invoke != null) {
				this.onActionInvoke(invoke, ctoRequest, ctoResponse);
				continue;
			}
		}
		this.dataSourceGroupMap.clear();
		this.propertyMap.clear();
		this.serviceMap.clear();
		this.transMap.clear();
		this.transParameterMap.clear();
		return ReturnHelper.newReturnOk();
	}

	private void onActionInvoke(Invoke invoke, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception {
		String classType = invoke.getClassType();
		String methodName = invoke.getMethod();
		String beanName = invoke.getName();
		String outputId = invoke.getOutputId();
		int methodParameterCount = invoke.getMethodParameterCount();
		List<Object> parameterList = new ArrayList<Object>();
		if (methodParameterCount > 0) {
			MethodParameter[] methodParameters = invoke.getMethodParameter();
			for (MethodParameter methodParameter : methodParameters) {
				parameterList.add(ParameterUtils.analyzeCTOValue(methodParameter.getParameter(), ctoRequest));
			}
		}
		Class<?> clazz = null;
		Object object = null;
		if (StringHelper.isNotBlank(classType)) {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			clazz = classLoader.loadClass(classType);
		} else if (StringHelper.isNotBlank(beanName)) {
			object = ctoRequest.getObjectValue(beanName);
			clazz = object.getClass();
		}

		if (clazz == null) {
			return;
		}

		Method method = ReflectUtils.getMethod(clazz, methodName, parameterList);
		if (method == null) {
			return;
		}

		if (object == null) {
			object = clazz.newInstance();
		}
		Object result = method.invoke(object, parameterList.toArray(new Object[1]));

		if (result != null && StringHelper.isNotBlank(outputId)) {
			ctoRequest.setObjectValue(outputId, result);
		}
	}

	private void onActionBean(Bean bean, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception {

		String beanName = bean.getName();
		String classType = bean.getClassType();
		if (!StringHelper.isNotBlank(classType) || !StringHelper.isNotBlank(beanName)) {
			return;
		}
		List<Object> parameterList = new ArrayList<Object>();
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		Class<?> clazz = classLoader.loadClass(classType);

		cto.framework.service.plugin.schema.Constructor constructor = bean.getConstructor();
		if (constructor != null) {
			int paramCount = constructor.getParamCount();
			if (paramCount > 0) {
				Param[] params = constructor.getParam();
				for (Param param : params) {
					parameterList.add(ParameterUtils.analyzeCTOValue(param.getValue(), ctoRequest));
				}
			}
		}
		Object object = null;
		if (!parameterList.isEmpty()) {
			Constructor<?> $constructor = ReflectUtils.getConstructor(clazz, parameterList);
			object = $constructor.newInstance(parameterList.toArray(new Object[1]));
			parameterList.clear();
		} else {
			object = clazz.newInstance();
		}

		int propertyCount = bean.getPropertyCount();
		if (propertyCount > 0) {
			Property[] propertys = bean.getProperty();
			for (Property property : propertys) {
				String name = property.getName();
				String value = property.getValue();
				parameterList.add(ParameterUtils.analyzeCTOValue(value, ctoRequest));
				String setMethodName = StringHelper.fieldNameToMethodName(name, MethodType.SET.value());
				Method method = ReflectUtils.getMethod(clazz, setMethodName, parameterList);
				method.invoke(object, parameterList.toArray(new Object[1]));
			}
		}

	}

	private void onActionHadoopUtil(HadoopUtil hadoopUtil, CTORequest ctoRequest, CTOResponse ctoResponse) {

	}

	private void onActionHttpClient(HttpClient httpClient, CTORequest ctoRequest, CTOResponse ctoResponse) {
		HttpType httpType = httpClient.getHttpType();
		String url = httpClient.getUrl();
		if (StringHelper.isNotBlank(url)) {
			return;
		}
		int parameterCount = httpClient.getParameterCount();
		String responseText = null;
		if (httpType.equals(HttpType.GET)) {
			responseText = HttpUtils.get((String) ParameterUtils.analyzeCTOValue(url, ctoRequest));
		} else if (httpType.equals(HttpType.POST)) {
			Map<String, String> parameterMap = new HashMap<String, String>();
			if (parameterCount > 0) {
				Parameter[] parameters = httpClient.getParameter();
				for (Parameter parameter : parameters) {
					String key = parameter.getName();
					String value = parameter.getValue();
					String $value = (String) ParameterUtils.analyzeCTOValue(value, ctoRequest);
					parameterMap.put(key, $value);
				}
			}
			responseText = HttpUtils.post(url, parameterMap);
		}
		if (StringHelper.isNotBlank(responseText) && StringHelper.isNotBlank(httpClient.getOutputId())) {
			try {
				CTO $ctoResponse = CTO.formJSON(responseText);
				ctoRequest.setObjectValue(httpClient.getOutputId(), $ctoResponse);
			} catch (JSONException e) {
				logger.error(ExceptionUtils.getFullStackTrace(e));
			}
		}
	}

	private Return onActionTryCatchFinallyGroups(TryCatchFinallyGroup[] tryCatchFinallyGroups, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception {
		for (TryCatchFinallyGroup tryCatchFinallyGroup : tryCatchFinallyGroups) {
			Return tryCatchFinallyGroupReturn = this.onActionTryCatchFinallyGroup(tryCatchFinallyGroup, ctoRequest, ctoResponse);
			if (!this.proccessSuccessed(tryCatchFinallyGroupReturn)) {
				return tryCatchFinallyGroupReturn;
			}
		}
		return null;
	}

	private Return onActionIfElseIfGroups(IfElseIfGroup[] ifElseIfGroups, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception {
		for (IfElseIfGroup ifElseIfGroup : ifElseIfGroups) {
			Return ifElseIfGroupReturn = onActionIfElseIfGroup(ifElseIfGroup, ctoRequest, ctoResponse);
			if (!this.proccessSuccessed(ifElseIfGroupReturn)) {
				return ifElseIfGroupReturn;
			}
		}
		return null;
	}

	public void onActionSelectFeild(SelectFeild selectFeild, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception {
		if (this.serviceBus.getSingeDataEngine() != null) {
			this.serviceBus.getSingeDataEngine().executeSelectFeild(selectFeild, cacheManager, ctoRequest, ctoResponse);
		} else if (this.serviceBus.getWriteDataEngine() != null) {
			this.serviceBus.getWriteDataEngine().executeSelectFeild(selectFeild, cacheManager, ctoRequest, ctoResponse);
		} else {
			String dataSource = null;
			if (selectFeild.getDataSource() != null) {
				dataSource = selectFeild.getDataSource();
			} else {
				dataSource = ctoRequest.getStringValue("dataSource");
			}
			if (dataSource.contains(".")) {
				int leftIndex = dataSource.indexOf(".");
				String groupName = dataSource.substring(0, leftIndex);
				String dataSourceName = dataSource.substring(leftIndex + 1, dataSource.length());
				CycleMap<String, IDataEngine> cycleMap = dataSourceGroupMap.get(groupName);
				if(cycleMap == null){
					throw new RuntimeException("not found " + groupName + "DataGroup,请填写有效SelectFeild.DataSource");
				}
				IDataEngine dataEngine = cycleMap.get(dataSourceName);
				if(dataEngine == null){
					throw new RuntimeException("not found " + dataSourceName + "DataSource,请填写有效SelectFeild.DataSource");
				}
				dataEngine.executeSelectFeild(selectFeild, cacheManager, ctoRequest, ctoResponse);
			} else {
				throw new RuntimeException("not found dataSource,please check the framework configuration files, add data configuration");
			}
		}
	}
	
	private void onActionSelectRecord(SelectRecord selectRecord, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception {
		if (this.serviceBus.getSingeDataEngine() != null) {
			this.serviceBus.getSingeDataEngine().executeSelectRecord(selectRecord, cacheManager, ctoRequest, ctoResponse);
		} else if (this.serviceBus.getWriteDataEngine() != null) {
			this.serviceBus.getWriteDataEngine().executeSelectRecord(selectRecord, cacheManager, ctoRequest, ctoResponse);
		} else {
			String dataSource = null;
			if (selectRecord.getDataSource() != null) {
				dataSource = selectRecord.getDataSource();
			} else {
				dataSource = ctoRequest.getStringValue("dataSource");
			}
			if (dataSource.contains(".")) {
				int leftIndex = dataSource.indexOf(".");
				String groupName = dataSource.substring(0, leftIndex);
				String dataSourceName = dataSource.substring(leftIndex + 1, dataSource.length());
				CycleMap<String, IDataEngine> cycleMap = dataSourceGroupMap.get(groupName);
				if(cycleMap == null){
					throw new RuntimeException("not found " + groupName + "DataGroup,请填写有效SelectRecord.DataSource");
				}
				IDataEngine dataEngine = cycleMap.get(dataSourceName);
				if(dataEngine == null){
					throw new RuntimeException("not found " + dataSourceName + "DataSource,请填写有效SelectRecord.DataSource");
				}
				dataEngine.executeSelectRecord(selectRecord, cacheManager, ctoRequest, ctoResponse);
			} else {
				throw new RuntimeException("not found dataSource,please check the framework configuration files, add data configuration");
			}
		}
	}


	public void onActionSelectRecordSet(SelectRecordSet selectRecordSet, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception {
		if (this.serviceBus.getSingeDataEngine() != null) {
			this.serviceBus.getSingeDataEngine().executeSelectRecordSet(selectRecordSet, cacheManager, ctoRequest, ctoResponse);
		} else if (this.serviceBus.getWriteDataEngine() != null) {
			this.serviceBus.getWriteDataEngine().executeSelectRecordSet(selectRecordSet, cacheManager, ctoRequest, ctoResponse);
		} else {
			String dataSource = null;
			if (selectRecordSet.getDataSource() != null) {
				dataSource = selectRecordSet.getDataSource();
			} else {
				dataSource = ctoRequest.getStringValue("dataSource");
			}
			if (dataSource.contains(".")) {
				int leftIndex = dataSource.indexOf(".");
				String groupName = dataSource.substring(0, leftIndex);
				String dataSourceName = dataSource.substring(leftIndex + 1, dataSource.length());
				CycleMap<String, IDataEngine> cycleMap = dataSourceGroupMap.get(groupName);
				if(cycleMap == null){
					throw new RuntimeException("not found " + groupName + "DataGroup,请填写有效SelectRecordSet.DataSource");
				}
				IDataEngine dataEngine = cycleMap.get(dataSourceName);
				if(dataEngine == null){
					throw new RuntimeException("not found " + dataSourceName + "DataSource,请填写有效SelectRecordSet.DataSource");
				}
				dataEngine.executeSelectRecordSet(selectRecordSet, cacheManager, ctoRequest, ctoResponse);
			} else {
				throw new RuntimeException("not found dataSource,please check the framework configuration files, add data configuration");
			}
		}
	}

	public void onActionDelete(Delete delete, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception {
		if (this.serviceBus.getSingeDataEngine() != null) {
			this.serviceBus.getSingeDataEngine().executeDelete(delete, cacheManager, ctoRequest, ctoResponse);
		} else if (this.serviceBus.getWriteDataEngine() != null) {
			this.serviceBus.getWriteDataEngine().executeDelete(delete, cacheManager, ctoRequest, ctoResponse);
		} else {
			String dataSource = null;
			if (delete.getDataSource() != null) {
				dataSource = delete.getDataSource();
			} else {
				dataSource = ctoRequest.getStringValue("dataSource");
			}
			if (dataSource.contains(".")) {
				int leftIndex = dataSource.indexOf(".");
				String groupName = dataSource.substring(0, leftIndex);
				String dataSourceName = dataSource.substring(leftIndex + 1, dataSource.length());
				CycleMap<String, IDataEngine> cycleMap = dataSourceGroupMap.get(groupName);
				if(cycleMap == null){
					throw new RuntimeException("not found " + groupName + "DataGroup,请填写有效Delete.DataSource");
				}
				IDataEngine dataEngine = cycleMap.get(dataSourceName);
				if(dataEngine == null){
					throw new RuntimeException("not found " + dataSourceName + "DataSource,请填写有效Delete.DataSource");
				}
				dataEngine.executeDelete(delete, cacheManager, ctoRequest, ctoResponse);
			} else {
				throw new RuntimeException("not found dataSource,please check the framework configuration files, add data configuration");
			}
		}
	}

	public void onActionUpdate(Update update, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception {
		if (this.serviceBus.getSingeDataEngine() != null) {
			this.serviceBus.getSingeDataEngine().executeUpdate(update, cacheManager, ctoRequest, ctoResponse);
		} else if (this.serviceBus.getWriteDataEngine() != null) {
			this.serviceBus.getWriteDataEngine().executeUpdate(update, cacheManager, ctoRequest, ctoResponse);
		} else {
			String dataSource = null;
			if (update.getDataSource() != null) {
				dataSource = update.getDataSource();
			} else {
				dataSource = ctoRequest.getStringValue("dataSource");
			}
			if (dataSource.contains(".")) {
				int leftIndex = dataSource.indexOf(".");
				String groupName = dataSource.substring(0, leftIndex);
				String dataSourceName = dataSource.substring(leftIndex + 1, dataSource.length());
				CycleMap<String, IDataEngine> cycleMap = dataSourceGroupMap.get(groupName);
				if(cycleMap == null){
					throw new RuntimeException("not found " + groupName + "DataGroup,请填写有效Update.DataSource");
				}
				IDataEngine dataEngine = cycleMap.get(dataSourceName);
				if(dataEngine == null){
					throw new RuntimeException("not found " + dataSourceName + "DataSource,请填写有效Update.DataSource");
				}
				dataEngine.executeUpdate(update, cacheManager, ctoRequest, ctoResponse);
			} else {
				throw new RuntimeException("not found dataSource,please check the framework configuration files, add data configuration");
			}
		}
	}

	public void onActionInsert(Insert insert, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception {
		if (this.serviceBus.getSingeDataEngine() != null) {
			this.serviceBus.getSingeDataEngine().executeInsert(insert, cacheManager, ctoRequest, ctoResponse);
		} else if (this.serviceBus.getWriteDataEngine() != null) {
			this.serviceBus.getWriteDataEngine().executeInsert(insert, cacheManager, ctoRequest, ctoResponse);
		} else {
			String dataSource = null;
			if (insert.getDataSource() != null) {
				dataSource = insert.getDataSource();
			} else {
				dataSource = ctoRequest.getStringValue("dataSource");
			}
			if (dataSource.contains(".")) {
				int leftIndex = dataSource.indexOf(".");
				String groupName = dataSource.substring(0, leftIndex);
				String dataSourceName = dataSource.substring(leftIndex + 1, dataSource.length());
				CycleMap<String, IDataEngine> cycleMap = dataSourceGroupMap.get(groupName);
				if(cycleMap == null){
					throw new RuntimeException("not found " + groupName + "DataGroup,请填写有效Insert.DataSource");
				}
				IDataEngine dataEngine = cycleMap.get(dataSourceName);
				if(dataEngine == null){
					throw new RuntimeException("not found " + dataSourceName + "DataSource,请填写有效Insert.DataSource");
				}
				dataEngine.executeInsert(insert, cacheManager, ctoRequest, ctoResponse);
			} else {
				throw new RuntimeException("not found dataSource,please check the framework configuration files, add data configuration");
			}
		}
	}

	public void onActionOut(Out out, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception {
		Object value = ParameterUtils.analyzeCTOValue(out.getValue(), ctoRequest);
		System.out.println(value);
	}

	public void onActionSetValue(SetValue setValue, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception {
		ctoRequest.setObjectValue(setValue.getName(), ParameterUtils.analyzeCTOValue(setValue.getValue(), ctoRequest));
	}

	public void onActionThrow(Throw $throw, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception {
		EngineHelper.onActionThrow($throw, this.propertyMap, ctoRequest);
	}

	public Return onFor(For $for, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception {
		ForTypeChoice forTypeChoice = $for.getForTypeChoice();
		if (forTypeChoice == null) {
			return null;
		}
		int forTypeChoiceItemCount = forTypeChoice.getForTypeChoiceItemCount();
		if (forTypeChoiceItemCount > 0) {
			ForTypeChoiceItem[] forTypeChoiceItems = forTypeChoice.getForTypeChoiceItem();
			for (ForTypeChoiceItem forTypeChoiceItem : forTypeChoiceItems) {
				Insert insert = forTypeChoiceItem.getInsert();
				if (insert != null) {
					onActionInsert(insert, ctoRequest, ctoResponse);
					continue;
				}
				SelectRecordSet selectRecordSet = forTypeChoiceItem.getSelectRecordSet();
				if (selectRecordSet != null) {
					onActionSelectRecordSet(selectRecordSet, ctoRequest, ctoResponse);
					continue;
				}
				SelectRecord selectRecord = forTypeChoiceItem.getSelectRecord();
				if (selectRecord != null) {
					this.onActionSelectRecord(selectRecord, ctoRequest, ctoResponse);
					continue;
				}
				SelectFeild selectFeild = forTypeChoiceItem.getSelectFeild();
				if (selectFeild != null) {
					onActionSelectFeild(selectFeild, ctoRequest, ctoResponse);
					continue;
				}
				Delete delete = forTypeChoiceItem.getDelete();
				if (delete != null) {
					onActionDelete(delete, ctoRequest, ctoResponse);
					continue;
				}
				Update update = forTypeChoiceItem.getUpdate();
				if (update != null) {
					onActionUpdate(update, ctoRequest, ctoResponse);
					continue;
				}
				For $$for = forTypeChoiceItem.getFor();
				if ($$for != null) {
					Return forReturn = onActionFor($$for, ctoRequest, ctoResponse);
					if (!this.proccessSuccessed(forReturn)) {
						return forReturn;
					}
					continue;
				}
				int ifElseIfGroupCount = forTypeChoiceItem.getIfElseIfGroupCount();
				if (ifElseIfGroupCount > 0) {
					IfElseIfGroup[] ifElseIfGroups = forTypeChoiceItem.getIfElseIfGroup();
					Return ifElseIfGroupsReturn = onActionIfElseIfGroups(ifElseIfGroups, ctoRequest, ctoResponse);
					if (!this.proccessSuccessed(ifElseIfGroupsReturn)) {
						return ifElseIfGroupsReturn;
					}
					continue;
				}
				Log log = forTypeChoiceItem.getLog();
				if (log != null) {
					onActionLog(log, ctoRequest, ctoResponse);
				}
				Out out = forTypeChoiceItem.getOut();
				if (out != null) {
					onActionOut(out, ctoRequest, ctoResponse);
				}
				Return $return = forTypeChoiceItem.getReturn();
				if ($return != null) {
					return onActionReturn($return, ctoRequest, ctoResponse);
				}
				SetValue set = forTypeChoiceItem.getSetValue();
				if (set != null) {
					this.onActionSetValue(set, ctoRequest, ctoResponse);
					continue;
				}
				Call call = forTypeChoiceItem.getCall();
				if (call != null) {
					Return callReturn = onActionCall(call, ctoRequest, ctoResponse);
					if (!this.proccessSuccessed(callReturn)) {
						return callReturn;
					}
					continue;
				}
				int tryCatchFinallyGroupCount = forTypeChoiceItem.getTryCatchFinallyGroupCount();
				if (tryCatchFinallyGroupCount > 0) {
					TryCatchFinallyGroup[] tryCatchFinallyGroups = forTypeChoiceItem.getTryCatchFinallyGroup();
					Return catchReturn = this.onActionTryCatchFinallyGroups(tryCatchFinallyGroups, ctoRequest, ctoResponse);
					if (!this.proccessSuccessed(catchReturn)) {
						return catchReturn;
					}
					continue;
				}
				HttpClient httpClient = forTypeChoiceItem.getHttpClient();
				if (httpClient != null) {
					this.onActionHttpClient(httpClient, ctoRequest, ctoResponse);
					continue;
				}

				HadoopUtil hadoopUtil = forTypeChoiceItem.getHadoopUtil();
				if (hadoopUtil != null) {
					this.onActionHadoopUtil(hadoopUtil, ctoRequest, ctoResponse);
					continue;
				}

				Object commitTrans = forTypeChoiceItem.getCommitTrans();
				if (commitTrans != null) {
					this.onActionCommitTrans(commitTrans, ctoRequest, ctoResponse);
					continue;
				}

				Object rollbackTrans = forTypeChoiceItem.getRollbackTrans();
				if (rollbackTrans != null) {
					this.onActionRollbackTrans(rollbackTrans, ctoRequest, ctoResponse);
					continue;
				}

				Bean bean = forTypeChoiceItem.getBean();
				if (bean != null) {
					this.onActionBean(bean, ctoRequest, ctoResponse);
					continue;
				}

				Invoke invoke = forTypeChoiceItem.getInvoke();
				if (invoke != null) {
					this.onActionInvoke(invoke, ctoRequest, ctoResponse);
					continue;
				}
			}
		}
		ExceptionHelper.throwRuntimeException($for.getThrow(), propertyMap);
		return null;
	}

	public Return onActionFor(For $for, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception {
		String begin = $for.getBegin();
		String end = $for.getEnd();
		String collection = $for.getCollection();
		String index = StringHelper.isNotBlank($for.getIndex()) ? $for.getIndex() : "index";
		String item = $for.getItem();
		String separator = $for.getSeparator();

		// 采用集合方式循环
		if (StringHelper.isNotBlank(collection)) {
			int i = 0;
			if (StringHelper.isNotBlank(separator)) {
				String[] strs = collection.split(separator);
				for (String str : strs) {
					ctoRequest.setIntegerValue(index, i);
					ctoRequest.setStringValue(item, str);
					Return forReturn = onFor($for, ctoRequest, ctoResponse);
					if (!this.proccessSuccessed(forReturn)) {
						ctoRequest.remove(item);
						return forReturn;
					}
					i++;
				}
			} else {
				CTO[] ctos = (CTO[]) ParameterUtils.analyzeCTOValue(collection, ctoRequest);
				for (CTO cto : ctos) {
					ctoRequest.setIntegerValue(index, i);
					ctoRequest.setCTOValue(item, cto);
					Return forReturn = onFor($for, ctoRequest, ctoResponse);
					if (!this.proccessSuccessed(forReturn)) {
						ctoRequest.remove(item);
						return forReturn;
					}
					i++;
				}
			}
		} else if (StringHelper.isNotBlank(begin) && StringHelper.isNotBlank(end)) {// 固定循环
			int $begin = Integer.valueOf(begin);
			int $end = Integer.valueOf(end);
			for (int i = $begin; i < $end; i++) {
				ctoRequest.setIntegerValue(index, $begin);
				Return forReturn = onFor($for, ctoRequest, ctoResponse);
				if (!this.proccessSuccessed(forReturn)) {
					return forReturn;
				}
			}
		}
		if (StringHelper.isNotBlank(item)) {
			ctoRequest.remove(item);
		}
		return null;
	}

	public void onActionLog(Log log, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception {
		EngineHelper.log(log, ctoRequest, logger);
	}

	public Return onActionTryCatchFinallyGroup(TryCatchFinallyGroup tryCatchFinallyGroup, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception {
		Try $try = tryCatchFinallyGroup.getTry();
		Catch $catch = tryCatchFinallyGroup.getCatch();
		Finally $finally = tryCatchFinallyGroup.getFinally();
		if ($try != null && $catch != null && $finally != null) {
			return onActionTryCatchFinally($try, $catch, $finally, ctoRequest, ctoResponse);
		}
		if ($try != null && $catch != null) {
			return onActionTryCatch($try, $catch, ctoRequest, ctoResponse);
		}
		return null;
	}

	public Return onActionCatch(Catch $catch, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception {
		CatchTypeChoice catchTypeChoice = $catch.getCatchTypeChoice();
		if (catchTypeChoice == null) {
			return null;
		}
		int catchTypeChoiceItemCount = catchTypeChoice.getCatchTypeChoiceItemCount();
		if (catchTypeChoiceItemCount > 0) {
			CatchTypeChoiceItem[] catchTypeChoiceItems = catchTypeChoice.getCatchTypeChoiceItem();
			for (CatchTypeChoiceItem catchTypeChoiceItem : catchTypeChoiceItems) {
				Object rollbackTrans = catchTypeChoiceItem.getRollbackTrans();
				if (rollbackTrans != null) {
					onActionRollbackTrans(rollbackTrans, ctoRequest, ctoResponse);
					continue;
				}
				Log log = catchTypeChoiceItem.getLog();
				if (log != null) {
					onActionLog(log, ctoRequest, ctoResponse);
					continue;
				}
				Out out = catchTypeChoiceItem.getOut();
				if (out != null) {
					onActionOut(out, ctoRequest, ctoResponse);
					continue;
				}
				Return $return = catchTypeChoiceItem.getReturn();
				if ($return != null) {
					return onActionReturn($return, ctoRequest, ctoResponse);
				}
				SetValue set = catchTypeChoiceItem.getSetValue();
				if (set != null) {
					this.onActionSetValue(set, ctoRequest, ctoResponse);
					continue;
				}
				Call call = catchTypeChoiceItem.getCall();
				if (call != null) {
					Return callReturn = onActionCall(call, ctoRequest, ctoResponse);
					if (!this.proccessSuccessed(callReturn)) {
						return callReturn;
					}
					continue;
				}
				Insert insert = catchTypeChoiceItem.getInsert();
				if (insert != null) {
					onActionInsert(insert, ctoRequest, ctoResponse);
					continue;
				}
				SelectRecordSet selectRecordSet = catchTypeChoiceItem.getSelectRecordSet();
				if (selectRecordSet != null) {
					onActionSelectRecordSet(selectRecordSet, ctoRequest, ctoResponse);
					continue;
				}
				SelectRecord selectRecord = catchTypeChoiceItem.getSelectRecord();
				if (selectRecord != null) {
					this.onActionSelectRecord(selectRecord, ctoRequest, ctoResponse);
					continue;
				}
				SelectFeild selectFeild = catchTypeChoiceItem.getSelectFeild();
				if (selectFeild != null) {
					onActionSelectFeild(selectFeild, ctoRequest, ctoResponse);
					continue;
				}
				Delete delete = catchTypeChoiceItem.getDelete();
				if (delete != null) {
					onActionDelete(delete, ctoRequest, ctoResponse);
					continue;
				}
				Update update = catchTypeChoiceItem.getUpdate();
				if (update != null) {
					onActionUpdate(update, ctoRequest, ctoResponse);
					continue;
				}
				For $for = catchTypeChoiceItem.getFor();
				if ($for != null) {
					Return forReturn = onActionFor($for, ctoRequest, ctoResponse);
					if (!this.proccessSuccessed(forReturn)) {
						return forReturn;
					}
					continue;
				}
				int ifElseIfGroupCount = catchTypeChoiceItem.getIfElseIfGroupCount();
				if (ifElseIfGroupCount > 0) {
					IfElseIfGroup[] ifElseIfGroups = catchTypeChoiceItem.getIfElseIfGroup();
					Return ifElseIfGroupsReturn = onActionIfElseIfGroups(ifElseIfGroups, ctoRequest, ctoResponse);
					if (!this.proccessSuccessed(ifElseIfGroupsReturn)) {
						return ifElseIfGroupsReturn;
					}
					continue;
				}
				int tryCatchFinallyGroupCount = catchTypeChoiceItem.getTryCatchFinallyGroupCount();
				if (tryCatchFinallyGroupCount > 0) {
					TryCatchFinallyGroup[] tryCatchFinallyGroups = catchTypeChoiceItem.getTryCatchFinallyGroup();
					Return catchReturn = this.onActionTryCatchFinallyGroups(tryCatchFinallyGroups, ctoRequest, ctoResponse);
					if (!this.proccessSuccessed(catchReturn)) {
						return catchReturn;
					}
					continue;
				}
				HttpClient httpClient = catchTypeChoiceItem.getHttpClient();
				if (httpClient != null) {
					this.onActionHttpClient(httpClient, ctoRequest, ctoResponse);
					continue;
				}

				HadoopUtil hadoopUtil = catchTypeChoiceItem.getHadoopUtil();
				if (hadoopUtil != null) {
					this.onActionHadoopUtil(hadoopUtil, ctoRequest, ctoResponse);
					continue;
				}

				Object commitTrans = catchTypeChoiceItem.getCommitTrans();
				if (commitTrans != null) {
					this.onActionCommitTrans(commitTrans, ctoRequest, ctoResponse);
					continue;
				}

				Bean bean = catchTypeChoiceItem.getBean();
				if (bean != null) {
					this.onActionBean(bean, ctoRequest, ctoResponse);
					continue;
				}

				Invoke invoke = catchTypeChoiceItem.getInvoke();
				if (invoke != null) {
					this.onActionInvoke(invoke, ctoRequest, ctoResponse);
					continue;
				}
			}
		}
		Throw $throw = $catch.getThrow();
		ExceptionHelper.throwRuntimeException($throw, propertyMap);
		ctoRequest.remove($catch.getName());
		return null;
	}

	@SuppressWarnings("unchecked")
	private void onActionRollbackTrans(Object rollbackTrans, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception {
		List<Connection> connList = (List<Connection>) ctoRequest.getObjectValue("connections");
		if (connList == null) {
			return;
		}
		for (Connection conn : connList) {
			if (conn != null) {
				if (!conn.isClosed()) {
					if (!conn.getAutoCommit()) {
						conn.rollback();
					}
					conn.close();
				}
			}
		}
	}

	public Return onActionTryCatchFinally(Try $try, Catch $catch, Finally $finally, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception {
		try {
			TryTypeChoice tryTypeChoice = $try.getTryTypeChoice();
			if (tryTypeChoice == null) {
				return null;
			}
			int tryTypeChoiceItemCount = tryTypeChoice.getTryTypeChoiceItemCount();
			if (tryTypeChoiceItemCount > 0) {
				TryTypeChoiceItem[] tryTypeChoiceItems = tryTypeChoice.getTryTypeChoiceItem();
				for (TryTypeChoiceItem tryTypeChoiceItem : tryTypeChoiceItems) {
					Insert insert = tryTypeChoiceItem.getInsert();
					if (insert != null) {
						onActionInsert(insert, ctoRequest, ctoResponse);
						continue;
					}
					SelectRecordSet selectRecordSet = tryTypeChoiceItem.getSelectRecordSet();
					if (selectRecordSet != null) {
						onActionSelectRecordSet(selectRecordSet, ctoRequest, ctoResponse);
						continue;
					}
					SelectRecord selectRecord = tryTypeChoiceItem.getSelectRecord();
					if (selectRecord != null) {
						this.onActionSelectRecord(selectRecord, ctoRequest, ctoResponse);
						continue;
					}
					SelectFeild selectFeild = tryTypeChoiceItem.getSelectFeild();
					if (selectFeild != null) {
						onActionSelectFeild(selectFeild, ctoRequest, ctoResponse);
						continue;
					}
					Delete delete = tryTypeChoiceItem.getDelete();
					if (delete != null) {
						onActionDelete(delete, ctoRequest, ctoResponse);
						continue;
					}
					Update update = tryTypeChoiceItem.getUpdate();
					if (update != null) {
						onActionUpdate(update, ctoRequest, ctoResponse);
						continue;
					}
					For $for = tryTypeChoiceItem.getFor();
					if ($for != null) {
						Return forReturn = onActionFor($for, ctoRequest, ctoResponse);
						if (!this.proccessSuccessed(forReturn)) {
							return forReturn;
						}
						continue;
					}
					int ifElseIfGroupCount = tryTypeChoiceItem.getIfElseIfGroupCount();
					if (ifElseIfGroupCount > 0) {
						IfElseIfGroup[] ifElseIfGroups = tryTypeChoiceItem.getIfElseIfGroup();
						Return ifElseIfGroupsReturn = onActionIfElseIfGroups(ifElseIfGroups, ctoRequest, ctoResponse);
						if (!this.proccessSuccessed(ifElseIfGroupsReturn)) {
							return ifElseIfGroupsReturn;
						}
						continue;
					}
					Log log = tryTypeChoiceItem.getLog();
					if (log != null) {
						onActionLog(log, ctoRequest, ctoResponse);
						continue;
					}
					Out out = tryTypeChoiceItem.getOut();
					if (out != null) {
						onActionOut(out, ctoRequest, ctoResponse);
						continue;
					}
					Return $return = tryTypeChoiceItem.getReturn();
					if ($return != null) {
						return onActionReturn($return, ctoRequest, ctoResponse);
					}
					SetValue set = tryTypeChoiceItem.getSetValue();
					if (set != null) {
						this.onActionSetValue(set, ctoRequest, ctoResponse);
						continue;
					}
					Call call = tryTypeChoiceItem.getCall();
					if (call != null) {
						Return callReturn = onActionCall(call, ctoRequest, ctoResponse);
						if (!this.proccessSuccessed(callReturn)) {
							return callReturn;
						}
						continue;
					}
					int tryCatchFinallyGroupCount = tryTypeChoiceItem.getTryCatchFinallyGroupCount();
					if (tryCatchFinallyGroupCount > 0) {
						TryCatchFinallyGroup[] tryCatchFinallyGroups = tryTypeChoiceItem.getTryCatchFinallyGroup();
						Return catchReturn = this.onActionTryCatchFinallyGroups(tryCatchFinallyGroups, ctoRequest, ctoResponse);
						if (!this.proccessSuccessed(catchReturn)) {
							return catchReturn;
						}
						continue;
					}
					HttpClient httpClient = tryTypeChoiceItem.getHttpClient();
					if (httpClient != null) {
						this.onActionHttpClient(httpClient, ctoRequest, ctoResponse);
						continue;
					}

					HadoopUtil hadoopUtil = tryTypeChoiceItem.getHadoopUtil();
					if (hadoopUtil != null) {
						this.onActionHadoopUtil(hadoopUtil, ctoRequest, ctoResponse);
						continue;
					}

					Object commitTrans = tryTypeChoiceItem.getCommitTrans();
					if (commitTrans != null) {
						this.onActionCommitTrans(commitTrans, ctoRequest, ctoResponse);
						continue;
					}

					Object rollbackTrans = tryTypeChoiceItem.getRollbackTrans();
					if (rollbackTrans != null) {
						this.onActionRollbackTrans(rollbackTrans, ctoRequest, ctoResponse);
						continue;
					}

					Bean bean = tryTypeChoiceItem.getBean();
					if (bean != null) {
						this.onActionBean(bean, ctoRequest, ctoResponse);
						continue;
					}

					Invoke invoke = tryTypeChoiceItem.getInvoke();
					if (invoke != null) {
						this.onActionInvoke(invoke, ctoRequest, ctoResponse);
						continue;
					}
				}
			}
		} catch (Exception ex) {
			ctoRequest.setStringValue($catch.getName(), ExceptionUtils.getFullStackTrace(ex));
			Return catchReturn = onActionCatch($catch, ctoRequest, ctoResponse);
			if (!this.proccessSuccessed(catchReturn)) {
				return catchReturn;
			}
		} finally {
			Return finallyReturn = onActionFinally($finally, ctoRequest, ctoResponse);
			if (!this.proccessSuccessed(finallyReturn)) {
				return finallyReturn;
			}
		}
		ExceptionHelper.throwRuntimeException($try.getThrow(), propertyMap);
		return null;
	}

	public Return onActionTryCatch(Try $try, Catch $catch, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception {
		try {
			TryTypeChoice tryTypeChoice = $try.getTryTypeChoice();
			if (tryTypeChoice == null) {
				return null;
			}
			int tryTypeChoiceItemCount = tryTypeChoice.getTryTypeChoiceItemCount();
			if (tryTypeChoiceItemCount > 0) {
				TryTypeChoiceItem[] tryTypeChoiceItems = tryTypeChoice.getTryTypeChoiceItem();
				for (TryTypeChoiceItem tryTypeChoiceItem : tryTypeChoiceItems) {
					Insert insert = tryTypeChoiceItem.getInsert();
					if (insert != null) {
						onActionInsert(insert, ctoRequest, ctoResponse);
						continue;
					}
					SelectRecordSet selectRecordSet = tryTypeChoiceItem.getSelectRecordSet();
					if (selectRecordSet != null) {
						onActionSelectRecordSet(selectRecordSet, ctoRequest, ctoResponse);
						continue;
					}
					SelectRecord selectRecord = tryTypeChoiceItem.getSelectRecord();
					if (selectRecord != null) {
						this.onActionSelectRecord(selectRecord, ctoRequest, ctoResponse);
						continue;
					}
					SelectFeild selectFeild = tryTypeChoiceItem.getSelectFeild();
					if (selectFeild != null) {
						onActionSelectFeild(selectFeild, ctoRequest, ctoResponse);
						continue;
					}
					Delete delete = tryTypeChoiceItem.getDelete();
					if (delete != null) {
						onActionDelete(delete, ctoRequest, ctoResponse);
						continue;
					}
					Update update = tryTypeChoiceItem.getUpdate();
					if (update != null) {
						onActionUpdate(update, ctoRequest, ctoResponse);
						continue;
					}
					For $for = tryTypeChoiceItem.getFor();
					if ($for != null) {
						Return forReturn = onActionFor($for, ctoRequest, ctoResponse);
						if (!this.proccessSuccessed(forReturn)) {
							return forReturn;
						}
						continue;
					}
					int ifElseIfGroupCount = tryTypeChoiceItem.getIfElseIfGroupCount();
					if (ifElseIfGroupCount > 0) {
						IfElseIfGroup[] ifElseIfGroups = tryTypeChoiceItem.getIfElseIfGroup();
						Return ifElseIfGroupsReturn = onActionIfElseIfGroups(ifElseIfGroups, ctoRequest, ctoResponse);
						if (!this.proccessSuccessed(ifElseIfGroupsReturn)) {
							return ifElseIfGroupsReturn;
						}
						continue;
					}
					Log log = tryTypeChoiceItem.getLog();
					if (log != null) {
						onActionLog(log, ctoRequest, ctoResponse);
						continue;
					}
					Out out = tryTypeChoiceItem.getOut();
					if (out != null) {
						onActionOut(out, ctoRequest, ctoResponse);
						continue;
					}
					Return $return = tryTypeChoiceItem.getReturn();
					if ($return != null) {
						return onActionReturn($return, ctoRequest, ctoResponse);
					}
					SetValue set = tryTypeChoiceItem.getSetValue();
					if (set != null) {
						this.onActionSetValue(set, ctoRequest, ctoResponse);
						continue;
					}
					Call call = tryTypeChoiceItem.getCall();
					if (call != null) {
						Return callReturn = onActionCall(call, ctoRequest, ctoResponse);
						if (!this.proccessSuccessed(callReturn)) {
							return callReturn;
						}
						continue;
					}
					Object commitTrans = tryTypeChoiceItem.getCommitTrans();
					if (commitTrans != null) {
						onActionCommitTrans(commitTrans, ctoRequest, ctoResponse);
						continue;
					}
					int tryCatchFinallyGroupCount = tryTypeChoiceItem.getTryCatchFinallyGroupCount();
					if (tryCatchFinallyGroupCount > 0) {
						TryCatchFinallyGroup[] tryCatchFinallyGroups = tryTypeChoiceItem.getTryCatchFinallyGroup();
						Return catchReturn = this.onActionTryCatchFinallyGroups(tryCatchFinallyGroups, ctoRequest, ctoResponse);
						if (!this.proccessSuccessed(catchReturn)) {
							return catchReturn;
						}
						continue;
					}
					HttpClient httpClient = tryTypeChoiceItem.getHttpClient();
					if (httpClient != null) {
						this.onActionHttpClient(httpClient, ctoRequest, ctoResponse);
						continue;
					}

					HadoopUtil hadoopUtil = tryTypeChoiceItem.getHadoopUtil();
					if (hadoopUtil != null) {
						this.onActionHadoopUtil(hadoopUtil, ctoRequest, ctoResponse);
						continue;
					}

					Object rollbackTrans = tryTypeChoiceItem.getRollbackTrans();
					if (rollbackTrans != null) {
						this.onActionRollbackTrans(rollbackTrans, ctoRequest, ctoResponse);
						continue;
					}

					Bean bean = tryTypeChoiceItem.getBean();
					if (bean != null) {
						this.onActionBean(bean, ctoRequest, ctoResponse);
						continue;
					}

					Invoke invoke = tryTypeChoiceItem.getInvoke();
					if (invoke != null) {
						this.onActionInvoke(invoke, ctoRequest, ctoResponse);
						continue;
					}
				}
			}
			Throw $throw = $try.getThrow();
			ExceptionHelper.throwRuntimeException($throw, propertyMap);
		} catch (Exception ex) {
			ctoRequest.setStringValue($catch.getName(), ex.getLocalizedMessage());
			Return catchReturn = onActionCatch($catch, ctoRequest, ctoResponse);
			if (!this.proccessSuccessed(catchReturn)) {
				return catchReturn;
			}
		}
		return null;
	}

	public Return onActionFinally(Finally $finally, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception {
		FinallyTypeChoice finallyTypeChoice = $finally.getFinallyTypeChoice();
		if (finallyTypeChoice == null) {
			return null;
		}
		int finallyTypeChoiceItemCount = finallyTypeChoice.getFinallyTypeChoiceItemCount();
		if (finallyTypeChoiceItemCount > 0) {
			FinallyTypeChoiceItem[] finallyTypeChoiceItems = finallyTypeChoice.getFinallyTypeChoiceItem();
			for (FinallyTypeChoiceItem finallyTypeChoiceItem : finallyTypeChoiceItems) {
				Object commitTrans = finallyTypeChoiceItem.getCommitTrans();
				if (commitTrans != null) {
					onActionCommitTrans(commitTrans, ctoRequest, ctoResponse);
					continue;
				}
				Log log = finallyTypeChoiceItem.getLog();
				if (log != null) {
					onActionLog(log, ctoRequest, ctoResponse);
					continue;
				}
				Out out = finallyTypeChoiceItem.getOut();
				if (out != null) {
					onActionOut(out, ctoRequest, ctoResponse);
					continue;
				}
				Return $return = finallyTypeChoiceItem.getReturn();
				if ($return != null) {
					return onActionReturn($return, ctoRequest, ctoResponse);
				}
				SetValue set = finallyTypeChoiceItem.getSetValue();
				if (set != null) {
					this.onActionSetValue(set, ctoRequest, ctoResponse);
					continue;
				}
				Call call = finallyTypeChoiceItem.getCall();
				if (call != null) {
					Return callReturn = onActionCall(call, ctoRequest, ctoResponse);
					if (!this.proccessSuccessed(callReturn)) {
						return callReturn;
					}
					continue;
				}
				Insert insert = finallyTypeChoiceItem.getInsert();
				if (insert != null) {
					onActionInsert(insert, ctoRequest, ctoResponse);
					continue;
				}
				SelectRecordSet selectRecordSet = finallyTypeChoiceItem.getSelectRecordSet();
				if (selectRecordSet != null) {
					onActionSelectRecordSet(selectRecordSet, ctoRequest, ctoResponse);
					continue;
				}
				SelectRecord selectRecord = finallyTypeChoiceItem.getSelectRecord();
				if (selectRecord != null) {
					this.onActionSelectRecord(selectRecord, ctoRequest, ctoResponse);
					continue;
				}
				SelectFeild selectFeild = finallyTypeChoiceItem.getSelectFeild();
				if (selectFeild != null) {
					onActionSelectFeild(selectFeild, ctoRequest, ctoResponse);
					continue;
				}
				Delete delete = finallyTypeChoiceItem.getDelete();
				if (delete != null) {
					onActionDelete(delete, ctoRequest, ctoResponse);
					continue;
				}
				Update update = finallyTypeChoiceItem.getUpdate();
				if (update != null) {
					onActionUpdate(update, ctoRequest, ctoResponse);
					continue;
				}
				For $for = finallyTypeChoiceItem.getFor();
				if ($for != null) {
					Return forReturn = onActionFor($for, ctoRequest, ctoResponse);
					if (!this.proccessSuccessed(forReturn)) {
						return forReturn;
					}
					continue;
				}
				int ifElseIfGroupCount = finallyTypeChoiceItem.getIfElseIfGroupCount();
				if (ifElseIfGroupCount > 0) {
					IfElseIfGroup[] ifElseIfGroups = finallyTypeChoiceItem.getIfElseIfGroup();
					Return ifElseIfGroupsReturn = onActionIfElseIfGroups(ifElseIfGroups, ctoRequest, ctoResponse);
					if (!this.proccessSuccessed(ifElseIfGroupsReturn)) {
						return ifElseIfGroupsReturn;
					}
					continue;
				}
				int tryCatchFinallyGroupCount = finallyTypeChoiceItem.getTryCatchFinallyGroupCount();
				if (tryCatchFinallyGroupCount > 0) {
					TryCatchFinallyGroup[] tryCatchFinallyGroups = finallyTypeChoiceItem.getTryCatchFinallyGroup();
					Return catchReturn = this.onActionTryCatchFinallyGroups(tryCatchFinallyGroups, ctoRequest, ctoResponse);
					if (!this.proccessSuccessed(catchReturn)) {
						return catchReturn;
					}
					continue;
				}
				HttpClient httpClient = finallyTypeChoiceItem.getHttpClient();
				if (httpClient != null) {
					this.onActionHttpClient(httpClient, ctoRequest, ctoResponse);
					continue;
				}

				HadoopUtil hadoopUtil = finallyTypeChoiceItem.getHadoopUtil();
				if (hadoopUtil != null) {
					this.onActionHadoopUtil(hadoopUtil, ctoRequest, ctoResponse);
					continue;
				}

				Object rollbackTrans = finallyTypeChoiceItem.getRollbackTrans();
				if (rollbackTrans != null) {
					this.onActionRollbackTrans(rollbackTrans, ctoRequest, ctoResponse);
					continue;
				}

				Bean bean = finallyTypeChoiceItem.getBean();
				if (bean != null) {
					this.onActionBean(bean, ctoRequest, ctoResponse);
					continue;
				}

				Invoke invoke = finallyTypeChoiceItem.getInvoke();
				if (invoke != null) {
					this.onActionInvoke(invoke, ctoRequest, ctoResponse);
					continue;
				}
			}
		}
		Throw $throw = $finally.getThrow();
		ExceptionHelper.throwRuntimeException($throw, propertyMap);
		return null;
	}

	@SuppressWarnings("unchecked")
	private void onActionCommitTrans(Object commitTrans, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception {
		List<Connection> connList = (List<Connection>) ctoRequest.getObjectValue("connections");
		if (connList == null) {
			return;
		}
		for (Connection conn : connList) {
			if (conn != null) {
				if (!conn.isClosed()) {
					if (!conn.getAutoCommit()) {
						conn.commit();
						conn.setAutoCommit(true);
					}
					conn.close();
				}
			}
		}
	}

	public Return onActionCall(Call call, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception {
		String serviceName = call.getServiceName();
		String actionTransName = call.getActionTransName();
		ctoRequest.setStringValue(Constant.STR_SERVICE_NAME, serviceName);
		ctoRequest.setStringValue(Constant.STR_TRANS_NAME, actionTransName);
		this.serviceBus.validator(ctoRequest);
		cto.framework.core.Return $return = this.serviceBus.execute(ctoRequest, ctoResponse);
		if (cto.framework.core.Return.executeSuccess($return)) {
			return ReturnHelper.newReturn(Constant.SUCCSES_CODE, $return.getText(), $return.getInfo());
		}
		return ReturnHelper.newReturn($return.getCode(), $return.getText(), $return.getInfo());
	}

	public Return onActionIfElseIfGroup(IfElseIfGroup ifElseIfGroup, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception {
		If $if = ifElseIfGroup.getIf();
		Elseif[] elseifs = ifElseIfGroup.getElseif();
		Else $else = ifElseIfGroup.getElse();
		int elseifCount = ifElseIfGroup.getElseifCount();
		if ($if != null && elseifCount > 0 && $else != null) {
			return onActionIfElseIfelse($if, elseifs, $else, ctoRequest, ctoResponse);
		} else if ($if != null && elseifCount > 0) {
			return onActionIfElseIf($if, elseifs, ctoRequest, ctoResponse);
		} else if ($if != null && $else != null) {
			return onActionIfElse($if, $else, ctoRequest, ctoResponse);
		} else if ($if != null) {
			if (EngineHelper.executeExpression($if.getExpression(), ctoRequest)) {
				return onActionIf($if, ctoRequest, ctoResponse);
			}
		}
		return null;
	}

	public Return onActionIfElseIfelse(If $if, Elseif[] elseifs, Else $else, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception {
		if (EngineHelper.executeExpression($if.getExpression(), ctoRequest)) {
			return this.onActionIf($if, ctoRequest, ctoResponse);
		} else {
			return this.onActionElseifElse(elseifs, $else, ctoRequest, ctoResponse);
		}
	}

	public Return onActionIfElseIf(If $if, Elseif[] elseifs, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception {
		if (EngineHelper.executeExpression($if.getExpression(), ctoRequest)) {
			return this.onActionIf($if, ctoRequest, ctoResponse);
		} else {
			return this.onActionElseif(elseifs, ctoRequest, ctoResponse);
		}
	}

	public Return onActionIfElse(If $if, Else $else, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception {
		if (EngineHelper.executeExpression($if.getExpression(), ctoRequest)) {
			return this.onActionIf($if, ctoRequest, ctoResponse);
		} else {
			return this.onActionElse($else, ctoRequest, ctoResponse);
		}
	}

	public Return onActionIf(If $if, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception {
		IfTypeChoice ifTypeChoice = $if.getIfTypeChoice();
		if (ifTypeChoice == null) {
			return ReturnHelper.newReturnOk();
		}
		int ifTypeChoiceItemCount = ifTypeChoice.getIfTypeChoiceItemCount();
		if (ifTypeChoiceItemCount > 0) {
			IfTypeChoiceItem[] ifTypeChoiceItems = ifTypeChoice.getIfTypeChoiceItem();
			for (IfTypeChoiceItem ifTypeChoiceItem : ifTypeChoiceItems) {
				Insert insert = ifTypeChoiceItem.getInsert();
				if (insert != null) {
					onActionInsert(insert, ctoRequest, ctoResponse);
					continue;
				}
				SelectRecordSet selectRecordSet = ifTypeChoiceItem.getSelectRecordSet();
				if (selectRecordSet != null) {
					onActionSelectRecordSet(selectRecordSet, ctoRequest, ctoResponse);
					continue;
				}
				SelectRecord selectRecord = ifTypeChoiceItem.getSelectRecord();
				if (selectRecord != null) {
					this.onActionSelectRecord(selectRecord, ctoRequest, ctoResponse);
					continue;
				}
				SelectFeild selectFeild = ifTypeChoiceItem.getSelectFeild();
				if (selectFeild != null) {
					onActionSelectFeild(selectFeild, ctoRequest, ctoResponse);
					continue;
				}
				Delete delete = ifTypeChoiceItem.getDelete();
				if (delete != null) {
					onActionDelete(delete, ctoRequest, ctoResponse);
					continue;
				}
				Update update = ifTypeChoiceItem.getUpdate();
				if (update != null) {
					onActionUpdate(update, ctoRequest, ctoResponse);
					continue;
				}
				For $for = ifTypeChoiceItem.getFor();
				if ($for != null) {
					Return forReturn = onActionFor($for, ctoRequest, ctoResponse);
					if (!this.proccessSuccessed(forReturn)) {
						return forReturn;
					}
					continue;
				}
				int ifElseIfGroupCount = ifTypeChoiceItem.getIfElseIfGroupCount();
				if (ifElseIfGroupCount > 0) {
					IfElseIfGroup[] ifElseIfGroups = ifTypeChoiceItem.getIfElseIfGroup();
					Return ifElseIfGroupsReturn = onActionIfElseIfGroups(ifElseIfGroups, ctoRequest, ctoResponse);
					if (!this.proccessSuccessed(ifElseIfGroupsReturn)) {
						return ifElseIfGroupsReturn;
					}
					continue;
				}
				Log log = ifTypeChoiceItem.getLog();
				if (log != null) {
					onActionLog(log, ctoRequest, ctoResponse);
					continue;
				}
				Out out = ifTypeChoiceItem.getOut();
				if (out != null) {
					onActionOut(out, ctoRequest, ctoResponse);
					continue;
				}
				Return $return = ifTypeChoiceItem.getReturn();
				if ($return != null) {
					Return rtnReturn = onActionReturn($return, ctoRequest, ctoResponse);
					if (!this.proccessSuccessed(rtnReturn)) {
						return rtnReturn;
					}
					continue;
				}
				SetValue set = ifTypeChoiceItem.getSetValue();
				if (set != null) {
					this.onActionSetValue(set, ctoRequest, ctoResponse);
					continue;
				}
				Call call = ifTypeChoiceItem.getCall();
				if (call != null) {
					Return callReturn = onActionCall(call, ctoRequest, ctoResponse);
					if (!this.proccessSuccessed(callReturn)) {
						return callReturn;
					}
					continue;
				}
				int tryCatchFinallyGroupCount = ifTypeChoiceItem.getTryCatchFinallyGroupCount();
				if (tryCatchFinallyGroupCount > 0) {
					TryCatchFinallyGroup[] tryCatchFinallyGroups = ifTypeChoiceItem.getTryCatchFinallyGroup();
					Return catchReturn = this.onActionTryCatchFinallyGroups(tryCatchFinallyGroups, ctoRequest, ctoResponse);
					if (!this.proccessSuccessed(catchReturn)) {
						return catchReturn;
					}
					continue;
				}
				HttpClient httpClient = ifTypeChoiceItem.getHttpClient();
				if (httpClient != null) {
					this.onActionHttpClient(httpClient, ctoRequest, ctoResponse);
					continue;
				}

				HadoopUtil hadoopUtil = ifTypeChoiceItem.getHadoopUtil();
				if (hadoopUtil != null) {
					this.onActionHadoopUtil(hadoopUtil, ctoRequest, ctoResponse);
					continue;
				}

				Object commitTrans = ifTypeChoiceItem.getCommitTrans();
				if (commitTrans != null) {
					this.onActionCommitTrans(commitTrans, ctoRequest, ctoResponse);
					continue;
				}

				Object rollbackTrans = ifTypeChoiceItem.getRollbackTrans();
				if (rollbackTrans != null) {
					this.onActionRollbackTrans(rollbackTrans, ctoRequest, ctoResponse);
					continue;
				}

				Bean bean = ifTypeChoiceItem.getBean();
				if (bean != null) {
					this.onActionBean(bean, ctoRequest, ctoResponse);
					continue;
				}

				Invoke invoke = ifTypeChoiceItem.getInvoke();
				if (invoke != null) {
					this.onActionInvoke(invoke, ctoRequest, ctoResponse);
					continue;
				}
			}
		}
		Throw $throw = $if.getThrow();
		ExceptionHelper.throwRuntimeException($throw, propertyMap);

		return null;
	}

	public Return onActionElseifElse(Elseif[] elseifs, Else $else, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception {
		boolean falg = false;
		for (Elseif elseif : elseifs) {
			if (EngineHelper.executeExpression(elseif.getExpression(), ctoRequest)) {
				falg = true;
				ElseIfTypeChoice elseifTypeChoice = elseif.getElseIfTypeChoice();
				if (elseifTypeChoice == null) {
					break;
				}
				int elseIfTypeChoiceItemCount = elseifTypeChoice.getElseIfTypeChoiceItemCount();
				if (elseIfTypeChoiceItemCount > 0) {
					ElseIfTypeChoiceItem[] elseIfTypeChoiceItems = elseifTypeChoice.getElseIfTypeChoiceItem();
					for (ElseIfTypeChoiceItem elseifTypeChoiceItem : elseIfTypeChoiceItems) {
						Insert insert = elseifTypeChoiceItem.getInsert();
						if (insert != null) {
							onActionInsert(insert, ctoRequest, ctoResponse);
							continue;
						}
						SelectRecordSet selectRecordSet = elseifTypeChoiceItem.getSelectRecordSet();
						if (selectRecordSet != null) {
							onActionSelectRecordSet(selectRecordSet, ctoRequest, ctoResponse);
							continue;
						}
						SelectRecord selectRecord = elseifTypeChoiceItem.getSelectRecord();
						if (selectRecord != null) {
							this.onActionSelectRecord(selectRecord, ctoRequest, ctoResponse);
							continue;
						}
						SelectFeild selectFeild = elseifTypeChoiceItem.getSelectFeild();
						if (selectFeild != null) {
							onActionSelectFeild(selectFeild, ctoRequest, ctoResponse);
							continue;
						}
						Delete delete = elseifTypeChoiceItem.getDelete();
						if (delete != null) {
							onActionDelete(delete, ctoRequest, ctoResponse);
							continue;
						}
						Update update = elseifTypeChoiceItem.getUpdate();
						if (update != null) {
							onActionUpdate(update, ctoRequest, ctoResponse);
							continue;
						}
						For $for = elseifTypeChoiceItem.getFor();
						if ($for != null) {
							Return forReturn = onActionFor($for, ctoRequest, ctoResponse);
							if (!this.proccessSuccessed(forReturn)) {
								return forReturn;
							}
							continue;
						}
						int ifElseIfGroupCount = elseifTypeChoiceItem.getIfElseIfGroupCount();
						if (ifElseIfGroupCount > 0) {
							IfElseIfGroup[] ifElseIfGroups = elseifTypeChoiceItem.getIfElseIfGroup();
							Return ifElseIfGroupsReturn = onActionIfElseIfGroups(ifElseIfGroups, ctoRequest, ctoResponse);
							if (!this.proccessSuccessed(ifElseIfGroupsReturn)) {
								return ifElseIfGroupsReturn;
							}
							continue;
						}
						Log log = elseifTypeChoiceItem.getLog();
						if (log != null) {
							onActionLog(log, ctoRequest, ctoResponse);
							continue;
						}
						Out out = elseifTypeChoiceItem.getOut();
						if (out != null) {
							onActionOut(out, ctoRequest, ctoResponse);
							continue;
						}
						Return $return = elseifTypeChoiceItem.getReturn();
						if ($return != null) {
							return onActionReturn($return, ctoRequest, ctoResponse);
						}
						SetValue set = elseifTypeChoiceItem.getSetValue();
						if (set != null) {
							this.onActionSetValue(set, ctoRequest, ctoResponse);
							continue;
						}
						Call call = elseifTypeChoiceItem.getCall();
						if (call != null) {
							Return callReturn = onActionCall(call, ctoRequest, ctoResponse);
							if (!this.proccessSuccessed(callReturn)) {
								return callReturn;
							}
							continue;
						}
						int tryCatchFinallyGroupCount = elseifTypeChoiceItem.getTryCatchFinallyGroupCount();
						if (tryCatchFinallyGroupCount > 0) {
							TryCatchFinallyGroup[] tryCatchFinallyGroups = elseifTypeChoiceItem.getTryCatchFinallyGroup();
							Return catchReturn = this.onActionTryCatchFinallyGroups(tryCatchFinallyGroups, ctoRequest, ctoResponse);
							if (!this.proccessSuccessed(catchReturn)) {
								return catchReturn;
							}
							continue;
						}
						HttpClient httpClient = elseifTypeChoiceItem.getHttpClient();
						if (httpClient != null) {
							this.onActionHttpClient(httpClient, ctoRequest, ctoResponse);
							continue;
						}

						HadoopUtil hadoopUtil = elseifTypeChoiceItem.getHadoopUtil();
						if (hadoopUtil != null) {
							this.onActionHadoopUtil(hadoopUtil, ctoRequest, ctoResponse);
							continue;
						}

						Object commitTrans = elseifTypeChoiceItem.getCommitTrans();
						if (commitTrans != null) {
							this.onActionCommitTrans(commitTrans, ctoRequest, ctoResponse);
							continue;
						}

						Object rollbackTrans = elseifTypeChoiceItem.getRollbackTrans();
						if (rollbackTrans != null) {
							this.onActionRollbackTrans(rollbackTrans, ctoRequest, ctoResponse);
							continue;
						}

						Bean bean = elseifTypeChoiceItem.getBean();
						if (bean != null) {
							this.onActionBean(bean, ctoRequest, ctoResponse);
							continue;
						}

						Invoke invoke = elseifTypeChoiceItem.getInvoke();
						if (invoke != null) {
							this.onActionInvoke(invoke, ctoRequest, ctoResponse);
							continue;
						}
					}
				}
				Throw $throw = elseif.getThrow();
				ExceptionHelper.throwRuntimeException($throw, propertyMap);
				break;
			}
		}
		if (!falg) {
			return this.onActionElse($else, ctoRequest, ctoResponse);
		}
		return null;
	}

	public Return onActionElseif(Elseif[] elseifs, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception {
		for (Elseif elseif : elseifs) {
			if (EngineHelper.executeExpression(elseif.getExpression(), ctoRequest)) {
				ElseIfTypeChoice elseIfTypeChoice = elseif.getElseIfTypeChoice();
				if (elseIfTypeChoice == null) {
					break;
				}
				int elseIfTypeChoiceItemCount = elseIfTypeChoice.getElseIfTypeChoiceItemCount();
				if (elseIfTypeChoiceItemCount > 0) {
					ElseIfTypeChoiceItem[] elseIfTypeChoiceItems = elseIfTypeChoice.getElseIfTypeChoiceItem();
					for (ElseIfTypeChoiceItem elseifTypeChoiceItem : elseIfTypeChoiceItems) {
						Insert insert = elseifTypeChoiceItem.getInsert();
						if (insert != null) {
							onActionInsert(insert, ctoRequest, ctoResponse);
							continue;
						}
						SelectRecordSet selectRecordSet = elseifTypeChoiceItem.getSelectRecordSet();
						if (selectRecordSet != null) {
							onActionSelectRecordSet(selectRecordSet, ctoRequest, ctoResponse);
							continue;
						}
						SelectRecord selectRecord = elseifTypeChoiceItem.getSelectRecord();
						if (selectRecord != null) {
							this.onActionSelectRecord(selectRecord, ctoRequest, ctoResponse);
							continue;
						}
						SelectFeild selectFeild = elseifTypeChoiceItem.getSelectFeild();
						if (selectFeild != null) {
							onActionSelectFeild(selectFeild, ctoRequest, ctoResponse);
							continue;
						}
						Delete delete = elseifTypeChoiceItem.getDelete();
						if (delete != null) {
							onActionDelete(delete, ctoRequest, ctoResponse);
							continue;
						}
						Update update = elseifTypeChoiceItem.getUpdate();
						if (update != null) {
							onActionUpdate(update, ctoRequest, ctoResponse);
							continue;
						}
						For $for = elseifTypeChoiceItem.getFor();
						if ($for != null) {
							Return forReturn = onActionFor($for, ctoRequest, ctoResponse);
							if (!this.proccessSuccessed(forReturn)) {
								return forReturn;
							}
							continue;
						}
						int ifElseIfGroupCount = elseifTypeChoiceItem.getIfElseIfGroupCount();
						if (ifElseIfGroupCount > 0) {
							IfElseIfGroup[] ifElseIfGroups = elseifTypeChoiceItem.getIfElseIfGroup();
							Return ifElseIfGroupsReturn = onActionIfElseIfGroups(ifElseIfGroups, ctoRequest, ctoResponse);
							if (!this.proccessSuccessed(ifElseIfGroupsReturn)) {
								return ifElseIfGroupsReturn;
							}
							continue;
						}
						Log log = elseifTypeChoiceItem.getLog();
						if (log != null) {
							onActionLog(log, ctoRequest, ctoResponse);
							continue;
						}
						Out out = elseifTypeChoiceItem.getOut();
						if (out != null) {
							onActionOut(out, ctoRequest, ctoResponse);
							continue;
						}
						Return $return = elseifTypeChoiceItem.getReturn();
						if ($return != null) {
							return onActionReturn($return, ctoRequest, ctoResponse);
						}
						SetValue set = elseifTypeChoiceItem.getSetValue();
						if (set != null) {
							this.onActionSetValue(set, ctoRequest, ctoResponse);
							continue;
						}
						Call call = elseifTypeChoiceItem.getCall();
						if (call != null) {
							Return callReturn = onActionCall(call, ctoRequest, ctoResponse);
							if (!this.proccessSuccessed(callReturn)) {
								return callReturn;
							}
							continue;
						}
						int tryCatchFinallyGroupCount = elseifTypeChoiceItem.getTryCatchFinallyGroupCount();
						if (tryCatchFinallyGroupCount > 0) {
							TryCatchFinallyGroup[] tryCatchFinallyGroups = elseifTypeChoiceItem.getTryCatchFinallyGroup();
							Return catchReturn = this.onActionTryCatchFinallyGroups(tryCatchFinallyGroups, ctoRequest, ctoResponse);
							if (!this.proccessSuccessed(catchReturn)) {
								return catchReturn;
							}
							continue;
						}
						HttpClient httpClient = elseifTypeChoiceItem.getHttpClient();
						if (httpClient != null) {
							this.onActionHttpClient(httpClient, ctoRequest, ctoResponse);
							continue;
						}

						HadoopUtil hadoopUtil = elseifTypeChoiceItem.getHadoopUtil();
						if (hadoopUtil != null) {
							this.onActionHadoopUtil(hadoopUtil, ctoRequest, ctoResponse);
							continue;
						}

						Object commitTrans = elseifTypeChoiceItem.getCommitTrans();
						if (commitTrans != null) {
							this.onActionCommitTrans(commitTrans, ctoRequest, ctoResponse);
							continue;
						}

						Object rollbackTrans = elseifTypeChoiceItem.getRollbackTrans();
						if (rollbackTrans != null) {
							this.onActionRollbackTrans(rollbackTrans, ctoRequest, ctoResponse);
							continue;
						}

						Bean bean = elseifTypeChoiceItem.getBean();
						if (bean != null) {
							this.onActionBean(bean, ctoRequest, ctoResponse);
							continue;
						}

						Invoke invoke = elseifTypeChoiceItem.getInvoke();
						if (invoke != null) {
							this.onActionInvoke(invoke, ctoRequest, ctoResponse);
							continue;
						}
					}
				}
				Throw $throw = elseif.getThrow();
				ExceptionHelper.throwRuntimeException($throw, propertyMap);
				return null;
			}
		}
		return null;
	}

	public Return onActionElse(Else $else, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception {
		ElseTypeChoice elseTypeChoice = $else.getElseTypeChoice();
		if (elseTypeChoice == null) {
			return null;
		}
		int elseTypeChoiceItemCount = elseTypeChoice.getElseTypeChoiceItemCount();
		if (elseTypeChoiceItemCount > 0) {
			ElseTypeChoiceItem[] elseTypeChoiceItems = elseTypeChoice.getElseTypeChoiceItem();
			for (ElseTypeChoiceItem elseTypeChoiceItem : elseTypeChoiceItems) {
				Insert insert = elseTypeChoiceItem.getInsert();
				if (insert != null) {
					onActionInsert(insert, ctoRequest, ctoResponse);
					continue;
				}
				SelectRecordSet selectRecordSet = elseTypeChoiceItem.getSelectRecordSet();
				if (selectRecordSet != null) {
					onActionSelectRecordSet(selectRecordSet, ctoRequest, ctoResponse);
					continue;
				}
				SelectRecord selectRecord = elseTypeChoiceItem.getSelectRecord();
				if (selectRecord != null) {
					this.onActionSelectRecord(selectRecord, ctoRequest, ctoResponse);
					continue;
				}
				SelectFeild selectFeild = elseTypeChoiceItem.getSelectFeild();
				if (selectFeild != null) {
					onActionSelectFeild(selectFeild, ctoRequest, ctoResponse);
					continue;
				}
				Delete delete = elseTypeChoiceItem.getDelete();
				if (delete != null) {
					onActionDelete(delete, ctoRequest, ctoResponse);
					continue;
				}
				Update update = elseTypeChoiceItem.getUpdate();
				if (update != null) {
					onActionUpdate(update, ctoRequest, ctoResponse);
					continue;
				}
				For $for = elseTypeChoiceItem.getFor();
				if ($for != null) {
					Return forReturn = onActionFor($for, ctoRequest, ctoResponse);
					if (!this.proccessSuccessed(forReturn)) {
						return forReturn;
					}
					continue;
				}
				int ifElseIfGroupCount = elseTypeChoiceItem.getIfElseIfGroupCount();
				if (ifElseIfGroupCount > 0) {
					IfElseIfGroup[] ifElseIfGroups = elseTypeChoiceItem.getIfElseIfGroup();
					Return ifElseIfGroupsReturn = onActionIfElseIfGroups(ifElseIfGroups, ctoRequest, ctoResponse);
					if (!this.proccessSuccessed(ifElseIfGroupsReturn)) {
						return ifElseIfGroupsReturn;
					}
					continue;
				}
				Log log = elseTypeChoiceItem.getLog();
				if (log != null) {
					onActionLog(log, ctoRequest, ctoResponse);
					continue;
				}
				Out out = elseTypeChoiceItem.getOut();
				if (out != null) {
					onActionOut(out, ctoRequest, ctoResponse);
					continue;
				}
				Return $return = elseTypeChoiceItem.getReturn();
				if ($return != null) {
					return onActionReturn($return, ctoRequest, ctoResponse);
				}
				SetValue setValue = elseTypeChoiceItem.getSetValue();
				if (setValue != null) {
					onActionSetValue(setValue, ctoRequest, ctoResponse);
					continue;
				}
				Call call = elseTypeChoiceItem.getCall();
				if (call != null) {
					Return callReturn = onActionCall(call, ctoRequest, ctoResponse);
					if (!this.proccessSuccessed(callReturn)) {
						return callReturn;
					}
					continue;
				}
				int tryCatchFinallyGroupCount = elseTypeChoiceItem.getTryCatchFinallyGroupCount();
				if (tryCatchFinallyGroupCount > 0) {
					TryCatchFinallyGroup[] tryCatchFinallyGroups = elseTypeChoiceItem.getTryCatchFinallyGroup();
					Return catchReturn = this.onActionTryCatchFinallyGroups(tryCatchFinallyGroups, ctoRequest, ctoResponse);
					if (!this.proccessSuccessed(catchReturn)) {
						return catchReturn;
					}
					continue;
				}
				HttpClient httpClient = elseTypeChoiceItem.getHttpClient();
				if (httpClient != null) {
					this.onActionHttpClient(httpClient, ctoRequest, ctoResponse);
					continue;
				}

				HadoopUtil hadoopUtil = elseTypeChoiceItem.getHadoopUtil();
				if (hadoopUtil != null) {
					this.onActionHadoopUtil(hadoopUtil, ctoRequest, ctoResponse);
					continue;
				}

				Object commitTrans = elseTypeChoiceItem.getCommitTrans();
				if (commitTrans != null) {
					this.onActionCommitTrans(commitTrans, ctoRequest, ctoResponse);
					continue;
				}

				Object rollbackTrans = elseTypeChoiceItem.getRollbackTrans();
				if (rollbackTrans != null) {
					this.onActionRollbackTrans(rollbackTrans, ctoRequest, ctoResponse);
					continue;
				}

				Bean bean = elseTypeChoiceItem.getBean();
				if (bean != null) {
					this.onActionBean(bean, ctoRequest, ctoResponse);
					continue;
				}

				Invoke invoke = elseTypeChoiceItem.getInvoke();
				if (invoke != null) {
					this.onActionInvoke(invoke, ctoRequest, ctoResponse);
					continue;
				}
			}
		}
		Throw $throw = $else.getThrow();
		ExceptionHelper.throwRuntimeException($throw, propertyMap);
		return null;
	}

	public Return onActionReturn(Return $return, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception {
		int returnItemCount = $return.getReturnItemCount();
		if (returnItemCount > 0) {
			ReturnItem[] returnItems = $return.getReturnItem();
			for (ReturnItem returnItem : returnItems) {
				String id = returnItem.getId();
				String value = returnItem.getValue();
				Object objectValue = ParameterUtils.analyzeCTOValue(value, ctoRequest);
				ctoResponse.setObjectValue(id, objectValue);
			}
		}
		$return.setText((String)ParameterUtils.analyzeCTOValue($return.getText(), ctoRequest));
		$return.setInfo((String)ParameterUtils.analyzeCTOValue($return.getInfo(), ctoRequest));
		return $return;
	}

	protected boolean proccessSuccessed(Return $return) {
		if ($return == null) {
			return true;
		}
		return false;
	}

	public void setPropertyMap(Map<String, String> propertyMap) {
		this.propertyMap.putAll(propertyMap);
	}

	public void setTransParameterMap(Map<String, String> transParameterMap) {
		this.transParameterMap.putAll(transParameterMap);
	}

	public void setDataSourceGroupMap(Map<String, CycleMap<String, IDataEngine>> dataSourceGroupMap) {
		this.dataSourceGroupMap.putAll(dataSourceGroupMap);
	}

	public void setServiceMap(Map<String, Service> serviceMap) {
		this.serviceMap.putAll(serviceMap);
	}

	public void setTransMap(Map<String, Trans> transMap) {
		this.transMap.putAll(transMap);
	}

	public void setServiceBus(ServiceBus serviceBus) {
		this.serviceBus = serviceBus;
	}

	public void setCacheManager(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

}
