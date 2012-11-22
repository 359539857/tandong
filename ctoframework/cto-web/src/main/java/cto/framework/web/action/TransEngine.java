/**
 * 
 */
package cto.framework.web.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
import cto.framework.web.action.plugin.schema.Action;
import cto.framework.web.action.plugin.schema.Bean;
import cto.framework.web.action.plugin.schema.Call;
import cto.framework.web.action.plugin.schema.Catch;
import cto.framework.web.action.plugin.schema.CatchTypeChoice;
import cto.framework.web.action.plugin.schema.CatchTypeChoiceItem;
import cto.framework.web.action.plugin.schema.Else;
import cto.framework.web.action.plugin.schema.ElseIfTypeChoice;
import cto.framework.web.action.plugin.schema.ElseIfTypeChoiceItem;
import cto.framework.web.action.plugin.schema.ElseTypeChoice;
import cto.framework.web.action.plugin.schema.ElseTypeChoiceItem;
import cto.framework.web.action.plugin.schema.Elseif;
import cto.framework.web.action.plugin.schema.Finally;
import cto.framework.web.action.plugin.schema.FinallyTypeChoice;
import cto.framework.web.action.plugin.schema.FinallyTypeChoiceItem;
import cto.framework.web.action.plugin.schema.For;
import cto.framework.web.action.plugin.schema.ForTypeChoice;
import cto.framework.web.action.plugin.schema.ForTypeChoiceItem;
import cto.framework.web.action.plugin.schema.HadoopUtil;
import cto.framework.web.action.plugin.schema.Header;
import cto.framework.web.action.plugin.schema.HttpClient;
import cto.framework.web.action.plugin.schema.If;
import cto.framework.web.action.plugin.schema.IfElseIfGroup;
import cto.framework.web.action.plugin.schema.IfTypeChoice;
import cto.framework.web.action.plugin.schema.IfTypeChoiceItem;
import cto.framework.web.action.plugin.schema.Invoke;
import cto.framework.web.action.plugin.schema.Log;
import cto.framework.web.action.plugin.schema.MethodParameter;
import cto.framework.web.action.plugin.schema.Out;
import cto.framework.web.action.plugin.schema.OutResponse;
import cto.framework.web.action.plugin.schema.Param;
import cto.framework.web.action.plugin.schema.Parameter;
import cto.framework.web.action.plugin.schema.Property;
import cto.framework.web.action.plugin.schema.Return;
import cto.framework.web.action.plugin.schema.ReturnItem;
import cto.framework.web.action.plugin.schema.SetApplication;
import cto.framework.web.action.plugin.schema.SetRequest;
import cto.framework.web.action.plugin.schema.SetSession;
import cto.framework.web.action.plugin.schema.SetValue;
import cto.framework.web.action.plugin.schema.Throw;
import cto.framework.web.action.plugin.schema.Trans;
import cto.framework.web.action.plugin.schema.TransTypeChoiceItem;
import cto.framework.web.action.plugin.schema.Try;
import cto.framework.web.action.plugin.schema.TryCatchFinallyGroup;
import cto.framework.web.action.plugin.schema.TryTypeChoice;
import cto.framework.web.action.plugin.schema.TryTypeChoiceItem;
import cto.framework.web.action.plugin.schema.types.HttpType;

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
	private Map<String, String> actionParameterMap;
	private Map<String, Action> actionMap;
	private Map<String, Trans> transMap;
	private ActionBus actionBus;

	public TransEngine() {
		propertyMap = new HashMap<String, String>();
		actionParameterMap = new HashMap<String, String>();
		actionMap = new HashMap<String, Action>();
		transMap = new HashMap<String, Trans>();
	}

	public Return onActionItem(TransTypeChoiceItem[] transTypeChoiceItems, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception {

		for (TransTypeChoiceItem actionTransTypeChoiceItem : transTypeChoiceItems) {
			For $for = actionTransTypeChoiceItem.getFor();
			if ($for != null) {
				Return ifReturn = this.onActionFor($for, ctoRequest, ctoResponse);
				if (!this.proccessSuccessed(ifReturn)) {
					return ifReturn;
				}
				continue;
			}
			int ifElseIfGroupCount = actionTransTypeChoiceItem.getIfElseIfGroupCount();
			if (ifElseIfGroupCount > 0) {
				IfElseIfGroup[] ifElseIfGroups = actionTransTypeChoiceItem.getIfElseIfGroup();
				Return elseReturn = this.onActionIfElseIfGroups(ifElseIfGroups, ctoRequest, ctoResponse);
				if (!this.proccessSuccessed(elseReturn)) {
					return elseReturn;
				}
				continue;
			}
			Log log = actionTransTypeChoiceItem.getLog();
			if (log != null) {
				this.onActionLog(log, ctoRequest, ctoResponse);
				continue;
			}
			Out out = actionTransTypeChoiceItem.getOut();
			if (out != null) {
				this.onActionOut(out, ctoRequest, ctoResponse);
				continue;
			}
			Return $return = actionTransTypeChoiceItem.getReturn();
			if ($return != null) {
				return this.onActionReturn($return, ctoRequest, ctoResponse);
			}
			SetValue set = actionTransTypeChoiceItem.getSetValue();
			if (set != null) {
				this.onActionSetValue(set, ctoRequest, ctoResponse);
				continue;
			}
			int tryCatchFinallyGroupCount = actionTransTypeChoiceItem.getTryCatchFinallyGroupCount();
			if (tryCatchFinallyGroupCount > 0) {
				TryCatchFinallyGroup[] tryCatchFinallyGroups = actionTransTypeChoiceItem.getTryCatchFinallyGroup();
				Return catchReturn = this.onActionTryCatchFinallyGroups(tryCatchFinallyGroups, ctoRequest, ctoResponse);
				if (!this.proccessSuccessed(catchReturn)) {
					return catchReturn;
				}
				continue;
			}
			Call call = actionTransTypeChoiceItem.getCall();
			if (call != null) {
				Return logReturn = this.onActionCall(call, ctoRequest, ctoResponse);
				if (!this.proccessSuccessed(logReturn)) {
					return logReturn;
				}
				continue;
			}

			HttpClient httpClient = actionTransTypeChoiceItem.getHttpClient();
			if (httpClient != null) {
				this.onActionHttpClient(httpClient, ctoRequest, ctoResponse);
				continue;
			}

			HadoopUtil hadoopUtil = actionTransTypeChoiceItem.getHadoopUtil();
			if (hadoopUtil != null) {
				this.onActionHadoopUtil(hadoopUtil, ctoRequest, ctoResponse);
				continue;
			}

			SetRequest setRequest = actionTransTypeChoiceItem.getSetRequest();
			if (setRequest != null) {
				this.onActionSetRequest(setRequest, ctoRequest, ctoResponse);
				continue;
			}

			SetSession setSession = actionTransTypeChoiceItem.getSetSession();
			if (setSession != null) {
				this.onActionSetSession(setSession, ctoRequest, ctoResponse);
				continue;
			}

			SetApplication setApplication = actionTransTypeChoiceItem.getSetApplication();
			if (setApplication != null) {
				this.onActionSetApplication(setApplication, ctoRequest, ctoResponse);
				continue;
			}

			OutResponse outResponse = actionTransTypeChoiceItem.getOutResponse();
			if (outResponse != null) {
				this.onActionOutResponse(outResponse, ctoRequest, ctoResponse);
				continue;
			}

			Bean bean = actionTransTypeChoiceItem.getBean();
			if (bean != null) {
				this.onActionBean(bean, ctoRequest, ctoResponse);
				continue;
			}

			Invoke invoke = actionTransTypeChoiceItem.getInvoke();
			if (invoke != null) {
				this.onActionInvoke(invoke, ctoRequest, ctoResponse);
				continue;
			}
		}
		this.propertyMap.clear();
		this.actionMap.clear();
		this.transMap.clear();
		this.actionParameterMap.clear();
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

		cto.framework.web.action.plugin.schema.Constructor constructor = bean.getConstructor();
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

	private void onActionOutResponse(OutResponse outResponse, CTORequest ctoRequest, CTOResponse ctoResponse) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException,
			SecurityException, NoSuchMethodException, IOException {
		Object httpServletResponse = ctoRequest.getObjectValue(Constant.HTTP_SERVLET_RESPONSE);

		int bufferSize = outResponse.getBufferSize();
		int contentLength = outResponse.getContentLength();
		int status = outResponse.getStatus();
		String contentType = outResponse.getContentType();
		String characterEncoding = outResponse.getCharacterEncoding();
		String outputId = outResponse.getOutputId();
		Class<?> httpServletResponseClass = httpServletResponse.getClass();
		if (bufferSize > 0) {
			Method method = httpServletResponseClass.getMethod("setBufferSize", Integer.class);
			method.invoke(httpServletResponse, bufferSize);
		}
		if (contentLength > 0) {
			Method method = httpServletResponseClass.getMethod("setContentLength", Integer.class);
			method.invoke(httpServletResponse, contentLength);
		}
		if (status > 0) {
			Method method = httpServletResponseClass.getMethod("setStatus", Integer.class);
			method.invoke(httpServletResponse, status);
		}

		if (StringHelper.isNotBlank(contentType)) {
			Method method = httpServletResponseClass.getMethod("setContentType", String.class);
			method.invoke(httpServletResponse, contentType);
		}

		if (StringHelper.isNotBlank(characterEncoding)) {
			Method method = httpServletResponseClass.getMethod("setCharacterEncoding", String.class);
			method.invoke(httpServletResponse, status);
		}
		int headerCount = outResponse.getHeaderCount();
		if (headerCount > 0) {
			Header[] headers = outResponse.getHeader();
			Method method = httpServletResponseClass.getMethod("setHeader", String.class, String.class);
			for (Header header : headers) {
				method.invoke(httpServletResponse, header.getName(), ParameterUtils.analyzeCTOValue(header.getValue(), ctoRequest));
			}
		}

		Object objectValue = ParameterUtils.analyzeCTOValue(outputId, ctoRequest);
		if (objectValue instanceof CTO) {
			Method method = httpServletResponseClass.getMethod("getWriter");
			Writer writer = (Writer) method.invoke(httpServletResponse);
			CTO cto = (CTO) objectValue;
			writer.write(cto.toString());
		} else if (objectValue instanceof File) {
			int $bufferSize = bufferSize > 0 ? bufferSize : 1024;
			byte[] size = new byte[$bufferSize];
			File file = (File) objectValue;
			FileInputStream fileInputStream = new FileInputStream(file);
			BufferedInputStream bfInStream = new BufferedInputStream(fileInputStream, bufferSize > 0 ? bufferSize : 1024);
			Method method = httpServletResponseClass.getMethod("getOutputStream");
			OutputStream out = (OutputStream) method.invoke(httpServletResponse);
			BufferedOutputStream bfOutStream = new BufferedOutputStream(out);
			int len;
			while ((len = bfInStream.read(size)) != -1) {
				bfOutStream.write(size, 0, len);
			}
			bfOutStream.flush();
			bfInStream.close();
		} else {
			Method method = httpServletResponseClass.getMethod("getWriter");
			Writer writer = (Writer) method.invoke(httpServletResponse);
			writer.write((String) objectValue);
		}
		Method method = httpServletResponseClass.getMethod("flushBuffer");
		method.invoke(httpServletResponse);
	}

	private void onActionSetApplication(SetApplication setApplication, CTORequest ctoRequest, CTOResponse ctoResponse) throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException, SecurityException, NoSuchMethodException {
		Object httpApplication = ctoRequest.getObjectValue(Constant.HTTP_APPLICATION);
		Class<?> clazz = httpApplication.getClass();
		Method method = clazz.getMethod("setAttribute", String.class, Object.class);
		method.invoke(httpApplication, setApplication.getName(), ParameterUtils.analyzeCTOValue(setApplication.getValue(), ctoRequest));
	}

	private void onActionSetSession(SetSession setSession, CTORequest ctoRequest, CTOResponse ctoResponse) throws SecurityException, NoSuchMethodException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {
		Object httpSession = ctoRequest.getObjectValue(Constant.HTTP_SESSION);
		Class<?> clazz = httpSession.getClass();
		Method method = clazz.getMethod("setAttribute", String.class, Object.class);
		method.invoke(httpSession, setSession.getName(), ParameterUtils.analyzeCTOValue(setSession.getValue(), ctoRequest));

	}

	private void onActionSetRequest(SetRequest setRequest, CTORequest ctoRequest, CTOResponse ctoResponse) throws SecurityException, NoSuchMethodException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {
		Object httpServletRequest = ctoRequest.getObjectValue(Constant.HTTP_SERVLET_REQUEST);
		Class<?> clazz = httpServletRequest.getClass();
		Method method = clazz.getMethod("setAttribute", String.class, Object.class);
		method.invoke(httpServletRequest, setRequest.getName(), ParameterUtils.analyzeCTOValue(setRequest.getValue(), ctoRequest));
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
				For $$for = forTypeChoiceItem.getFor();
				if ($$for != null) {
					Return forReturn = onActionFor($$for, ctoRequest, ctoResponse);
					if (!this.proccessSuccessed(forReturn)) {
						return forReturn;
					}
					continue;
				}
				IfElseIfGroup[] ifElseIfGroups = forTypeChoiceItem.getIfElseIfGroup();
				if (ifElseIfGroups != null) {
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
			}
		}
		Throw $throw = $catch.getThrow();
		ExceptionHelper.throwRuntimeException($throw, propertyMap);
		ctoRequest.remove($catch.getName());
		return null;
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
					For $for = tryTypeChoiceItem.getFor();
					if ($for != null) {
						Return forReturn = onActionFor($for, ctoRequest, ctoResponse);
						if (!this.proccessSuccessed(forReturn)) {
							return forReturn;
						}
						continue;
					}
					IfElseIfGroup[] ifElseIfGroups = tryTypeChoiceItem.getIfElseIfGroup();
					if (ifElseIfGroups != null) {
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
					For $for = tryTypeChoiceItem.getFor();
					if ($for != null) {
						Return forReturn = onActionFor($for, ctoRequest, ctoResponse);
						if (!this.proccessSuccessed(forReturn)) {
							return forReturn;
						}
						continue;
					}
					IfElseIfGroup[] ifElseIfGroups = tryTypeChoiceItem.getIfElseIfGroup();
					if (ifElseIfGroups != null) {
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
				For $for = finallyTypeChoiceItem.getFor();
				if ($for != null) {
					Return forReturn = onActionFor($for, ctoRequest, ctoResponse);
					if (!this.proccessSuccessed(forReturn)) {
						return forReturn;
					}
					continue;
				}
				IfElseIfGroup[] ifElseIfGroups = finallyTypeChoiceItem.getIfElseIfGroup();
				if (ifElseIfGroups != null) {
					Return ifElseIfGroupsReturn = onActionIfElseIfGroups(ifElseIfGroups, ctoRequest, ctoResponse);
					if (!this.proccessSuccessed(ifElseIfGroupsReturn)) {
						return ifElseIfGroupsReturn;
					}
					continue;
				}
			}
		}
		Throw $throw = $finally.getThrow();
		ExceptionHelper.throwRuntimeException($throw, propertyMap);
		return null;
	}

	public Return onActionCall(Call call, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception {
		String actionName = call.getActionName();
		String transName = call.getTransName();
		ctoRequest.setStringValue(Constant.STR_ACTION_NAME, actionName);
		ctoRequest.setStringValue(Constant.STR_TRANS_NAME, transName);
		cto.framework.core.Return $return = this.actionBus.execute(ctoRequest, ctoResponse);
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
				For $for = ifTypeChoiceItem.getFor();
				if ($for != null) {
					Return forReturn = onActionFor($for, ctoRequest, ctoResponse);
					if (!this.proccessSuccessed(forReturn)) {
						return forReturn;
					}
					continue;
				}
				IfElseIfGroup[] ifElseIfGroups = ifTypeChoiceItem.getIfElseIfGroup();
				if (ifElseIfGroups != null) {
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
						For $for = elseifTypeChoiceItem.getFor();
						if ($for != null) {
							Return forReturn = onActionFor($for, ctoRequest, ctoResponse);
							if (!this.proccessSuccessed(forReturn)) {
								return forReturn;
							}
							continue;
						}
						IfElseIfGroup[] ifElseIfGroups = elseifTypeChoiceItem.getIfElseIfGroup();
						if (ifElseIfGroups != null) {
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
						For $for = elseifTypeChoiceItem.getFor();
						if ($for != null) {
							Return forReturn = onActionFor($for, ctoRequest, ctoResponse);
							if (!this.proccessSuccessed(forReturn)) {
								return forReturn;
							}
							continue;
						}
						IfElseIfGroup[] ifElseIfGroups = elseifTypeChoiceItem.getIfElseIfGroup();
						if (ifElseIfGroups != null) {
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
				For $for = elseTypeChoiceItem.getFor();
				if ($for != null) {
					Return forReturn = onActionFor($for, ctoRequest, ctoResponse);
					if (!this.proccessSuccessed(forReturn)) {
						return forReturn;
					}
					continue;
				}
				IfElseIfGroup[] ifElseIfGroups = elseTypeChoiceItem.getIfElseIfGroup();
				if (ifElseIfGroups != null) {
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

	public void setActionParameterMap(Map<String, String> actionParameterMap) {
		this.actionParameterMap.putAll(actionParameterMap);
	}

	public void setActionMap(Map<String, Action> actionMap) {
		this.actionMap.putAll(actionMap);
	}

	public void setTransMap(Map<String, Trans> transMap) {
		this.transMap.putAll(transMap);
	}

	@Override
	public void setActionBus(ActionBus actionBus) {
		this.actionBus = actionBus;
	}

}
