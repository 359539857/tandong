package cto.framework.service.helper;

import java.util.ArrayList;
import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;

import cto.framework.core.CTO;
import cto.framework.core.Constant;
import cto.framework.core.util.MD5;
import cto.framework.core.util.ParameterUtils;
import cto.framework.core.util.StringHelper;
import cto.framework.service.CTORequest;
import cto.framework.service.plugin.schema.Field;
import cto.framework.service.plugin.schema.Log;
import cto.framework.service.plugin.schema.Return;
import cto.framework.service.plugin.schema.Throw;
import cto.framework.service.plugin.schema.types.FieldTypeType;
import cto.framework.service.plugin.schema.types.LevelType;

public class EngineHelper {

	public static Return validator(Field field, CTO ctoRequest) {
		String name = field.getName();
		FieldTypeType fieldTypeType = field.getType();
		if (!ctoRequest.exists(name)) {
			return ReturnHelper.newReturnFail(name + " parameter not found!", "");
		}
		try {
			if (fieldTypeType.equals(FieldTypeType.STRING)) {
				ctoRequest.getStringValue(name);
			} else if (fieldTypeType.equals(FieldTypeType.INT)) {
				ctoRequest.getIntegerValue(name);
			} else if (fieldTypeType.equals(FieldTypeType.FLOAT)) {
				ctoRequest.getFloatValue(name);
			} else if (fieldTypeType.equals(FieldTypeType.DOUBLE)) {
				ctoRequest.getDoubleValue(name);
			} else if (fieldTypeType.equals(FieldTypeType.LONG)) {
				ctoRequest.getLongValue(name);
			} else if (fieldTypeType.equals(FieldTypeType.BOOLEAN)) {
				ctoRequest.getBooleanValue(name);
			}
		} catch (Exception ex) {
			return ReturnHelper.newReturnFail(ExceptionUtils.getFullStackTrace(ex), "validator." + name);
		}
		return ReturnHelper.newReturnOk();
	}

	public static void log(Log log, CTO ctoRequest, Logger logger) {
		LevelType level = log.getLevel();
		String text = log.getText();
		if (level.equals(LevelType.INFO)) {
			if (logger.isInfoEnabled()) {
				logger.info(ParameterUtils.analyzeCTOValue(text, ctoRequest));
			}
		} else if (level.equals(LevelType.DEBUG)) {
			if (logger.isDebugEnabled()) {
				logger.debug(ParameterUtils.analyzeCTOValue(text, ctoRequest));
			}
		} else if (level.equals(LevelType.ERROR)) {
			logger.error(ParameterUtils.analyzeCTOValue(text, ctoRequest));
		} else if (level.equals(LevelType.WARN)) {
			logger.warn(ParameterUtils.analyzeCTOValue(text, ctoRequest));
		} else if (level.equals(LevelType.FATAL)) {
			logger.fatal(ParameterUtils.analyzeCTOValue(text, ctoRequest));
		}
	}

	public static void onActionThrow(Throw $throw, Map<String, String> propertyMap, CTO ctoRequest) throws Exception {
		ExceptionHelper.throwRuntimeException($throw, propertyMap);
	}

	public static boolean executeExpression(String expression, CTO ctoRequest) throws Exception {
		expression = expression.trim();
		if (expression.contains(" and ")) {
			String[] subexpressions = expression.split(" and ");
			boolean flag = false;
			for (String subexpression : subexpressions) {
				subexpression = subexpression.trim();
				if (subexpression.contains(" and ") || subexpression.contains(" or ")) {
					flag = executeExpression(subexpression, ctoRequest);
				} else {
					if (subexpression.contains("==")) {
						flag = EngineHelper.equalExpression(subexpression, ctoRequest);
					} else if (subexpression.contains("!=")) {
						flag = EngineHelper.notEqualExpression(subexpression, ctoRequest);
					} else if (subexpression.contains(">=") || subexpression.contains("&gt;=")) {
						flag = EngineHelper.greaterThanEqualExpression(subexpression, ">=", ctoRequest);
					} else if (subexpression.contains("<=")) {
						flag = EngineHelper.lessThanEqualExpression(subexpression, "<=", ctoRequest);
					} else if (subexpression.contains("<")) {
						flag = EngineHelper.lessThanExpression(subexpression, ctoRequest);
					} else if (subexpression.contains(">")) {
						flag = EngineHelper.greaterThanExpression(subexpression, ">", ctoRequest);
					}
				}
			}
			return flag;
		} else if (expression.contains(" or ")) {
			String[] subexpressions = expression.split(" or ");
			boolean flag = false;
			for (String subexpression : subexpressions) {
				subexpression = subexpression.trim();
				if (subexpression.contains(" and ") || subexpression.contains(" or ")) {
					flag = executeExpression(subexpression, ctoRequest);
				} else {
					if (subexpression.contains("==")) {
						flag = EngineHelper.equalExpression(subexpression, ctoRequest);
					} else if (subexpression.contains("!=")) {
						flag = EngineHelper.notEqualExpression(subexpression, ctoRequest);
					} else if (subexpression.contains(">=") || subexpression.contains("&gt;=")) {
						flag = EngineHelper.greaterThanEqualExpression(subexpression, ">=", ctoRequest);
					} else if (subexpression.contains("<=")) {
						flag = EngineHelper.lessThanEqualExpression(subexpression, "<=", ctoRequest);
					} else if (subexpression.contains("<")) {
						flag = EngineHelper.lessThanExpression(subexpression, ctoRequest);
					} else if (subexpression.contains(">")) {
						flag = EngineHelper.greaterThanExpression(subexpression, ">", ctoRequest);
					}
				}
				if (flag) {
					return flag;
				}
			}
			return false;
		} else {
			if (expression.contains("==")) {
				return EngineHelper.equalExpression(expression, ctoRequest);
			} else if (expression.contains("!=")) {
				return EngineHelper.notEqualExpression(expression, ctoRequest);
			} else if (expression.contains("<=")) {
				return EngineHelper.lessThanEqualExpression(expression, "<=", ctoRequest);
			} else if (expression.contains(">=")) {
				return EngineHelper.greaterThanEqualExpression(expression, ">=", ctoRequest);
			} else if (expression.contains("<")) {
				return EngineHelper.lessThanExpression(expression, ctoRequest);
			} else if (expression.contains(">")) {
				return EngineHelper.greaterThanExpression(expression, ">", ctoRequest);
			}
		}
		return false;
	}

	private static boolean equalExpression(String expression, CTO ctoRequest) throws Exception {
		String[] denghaosubexpressions = expression.split("==");
		String value1 = StringHelper.deleteStr2(denghaosubexpressions[0].trim(), "'");
		String value2 = StringHelper.deleteStr2(denghaosubexpressions[1].trim(), "'");
		String $value1 = (String) ParameterUtils.analyzeCTOValue(value1, ctoRequest);
		String $value2 = (String) ParameterUtils.analyzeCTOValue(value2, ctoRequest);
		if(value1.equals("$" + $value1) || value1.equals("${" + $value1 + "}")){
			$value1 = null;
		}
		if(value2.equals("$" + $value2) || value1.equals("${" + $value2 + "}")){
			$value2 = null;
		}
		if ($value2.equals(Constant.NULL)) {
			if ($value1 == null) {
				return true;
			}else{
				return false;
			}
		}
		if ($value1 != null) {
			if ($value1.equals($value2)) {
				return true;
			}
		}
		return false;
	}

	private static boolean notEqualExpression(String expression, CTO ctoRequest) throws Exception {
		String[] denghaosubexpressions = expression.split("!=");
		String value1 = StringHelper.deleteStr2(denghaosubexpressions[0].trim(), "'");
		String value2 = StringHelper.deleteStr2(denghaosubexpressions[1].trim(), "'");
		String $value1 = (String) ParameterUtils.analyzeCTOValue(value1, ctoRequest);
		String $value2 = (String) ParameterUtils.analyzeCTOValue(value2, ctoRequest);
		if(value1.equals("$" + $value1) || value1.equals("${" + $value1 + "}")){
			$value1 = null;
		}
		if(value2.equals("$" + $value2) || value1.equals("${" + $value2 + "}")){
			$value2 = null;
		}
		if ($value2.equals(Constant.NULL)) {
			if ($value1 != null) {
				return true;
			}else{
				return false;
			}
		}
		if ($value1 != null) {
			if (!$value1.equals($value2)) {
				return true;
			}
		}
		return false;
	}

	private static boolean lessThanExpression(String expression, CTO ctoRequest) throws Exception {
		String[] xiaoyuhaosubexpressions = expression.split("<");
		String value1 = StringHelper.deleteStr2(xiaoyuhaosubexpressions[0].trim(), "'");
		String value2 = StringHelper.deleteStr2(xiaoyuhaosubexpressions[1].trim(), "'");
		value1 = (String) ParameterUtils.analyzeCTOValue(value1, ctoRequest);
		value2 = (String) ParameterUtils.analyzeCTOValue(value2, ctoRequest);

		double dvalue1 = Double.valueOf(value1);
		double dvalue2 = Double.valueOf(value2);
		if (dvalue1 < dvalue2) {
			return true;
		}
		return false;
	}

	private static boolean greaterThanExpression(String expression, String lable, CTO ctoRequest) throws Exception {
		String[] xiaoyuhaosubexpressions = expression.split(lable);
		String value1 = StringHelper.deleteStr2(xiaoyuhaosubexpressions[0].trim(), "'");
		String value2 = StringHelper.deleteStr2(xiaoyuhaosubexpressions[1].trim(), "'");
		value1 = (String) ParameterUtils.analyzeCTOValue(value1, ctoRequest);
		value2 = (String) ParameterUtils.analyzeCTOValue(value2, ctoRequest);

		double dvalue1 = Double.valueOf(value1);
		double dvalue2 = Double.valueOf(value2);
		if (dvalue1 > dvalue2) {
			return true;
		}
		return false;
	}

	private static boolean lessThanEqualExpression(String expression, String lable, CTO ctoRequest) throws Exception {
		String[] xiaoyuhaosubexpressions = expression.split(lable);
		String value1 = StringHelper.deleteStr2(xiaoyuhaosubexpressions[0].trim(), "'");
		String value2 = StringHelper.deleteStr2(xiaoyuhaosubexpressions[1].trim(), "'");
		value1 = (String) ParameterUtils.analyzeCTOValue(value1, ctoRequest);
		value2 = (String) ParameterUtils.analyzeCTOValue(value2, ctoRequest);

		double dvalue1 = Double.valueOf(value1);
		double dvalue2 = Double.valueOf(value2);
		if (dvalue1 <= dvalue2) {
			return true;
		}
		return false;
	}

	private static boolean greaterThanEqualExpression(String expression, String lable, CTO ctoRequest) throws Exception {
		String[] xiaoyuhaosubexpressions = expression.split(lable);
		String value1 = StringHelper.deleteStr2(xiaoyuhaosubexpressions[0].trim(), "'");
		String value2 = StringHelper.deleteStr2(xiaoyuhaosubexpressions[1].trim(), "'");
		value1 = (String) ParameterUtils.analyzeCTOValue(value1, ctoRequest);
		value2 = (String) ParameterUtils.analyzeCTOValue(value2, ctoRequest);

		double dvalue1 = Double.valueOf(value1);
		double dvalue2 = Double.valueOf(value2);
		if (dvalue1 >= dvalue2) {
			return true;
		}
		return false;
	}

	public static String getCachekey(String sqlString, ArrayList<String> sqlParams, CTO ctoRequest, int sqlQueryType) {
		CTO cto = new CTO();
		cto.setStringValue("sql", sqlString.trim());
		cto.setIntegerValue("sqlQueryType", sqlQueryType);
		CTORequest ctos = new CTORequest();
		for (String str : sqlParams) {
			ctos.setObjectValue(str, ctoRequest.getObjectValue(str));
		}
		
		cto.setCTOValue("sqlParams", ctos);
		ctoRequest.setCTOValue("$sqlinfo$", cto);
		String cacheKey = MD5.encode(cto.toJSONString());
		return cacheKey;
	}
	
	public static void main(String[] args) {
		CTO cto = new CTO();
		cto.setStringValue("sql", "fdsfdsf");
		cto.setIntegerValue("sqlQueryType", 1);
		CTORequest ctos = new CTORequest();
		ctos.setObjectValue("ddd", null);
		cto.setCTOValue("sqlParams", ctos);
		System.out.println(cto);
	}
}
