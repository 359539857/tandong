package cto.framework.web.action;

import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;

import cto.framework.core.CTO;
import cto.framework.core.Constant;
import cto.framework.core.util.ParameterUtils;
import cto.framework.core.util.StringHelper;
import cto.framework.web.action.plugin.schema.Field;
import cto.framework.web.action.plugin.schema.Log;
import cto.framework.web.action.plugin.schema.Return;
import cto.framework.web.action.plugin.schema.Throw;
import cto.framework.web.action.plugin.schema.types.FieldTypeType;
import cto.framework.web.action.plugin.schema.types.LevelType;

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
		if (expression.contains("&&")) {
			String[] subexpressions = expression.split("&&");
			for (String subexpression : subexpressions) {
				subexpression = subexpression.trim();
				if (subexpression.contains("==")) {
					EngineHelper.equalExpression(subexpression, ctoRequest);
				} else if (subexpression.contains("!=")) {
					EngineHelper.notEqualExpression(subexpression, ctoRequest);
				} else if (subexpression.contains("<")) {
					EngineHelper.lessThanExpression(subexpression, ctoRequest);
				} else if (subexpression.contains(">")) {
					EngineHelper.greaterThanExpression(expression, ">", ctoRequest);
				} else if (subexpression.contains("<=")) {
					EngineHelper.lessThanEqualExpression(expression, "<=", ctoRequest);
				} else if (subexpression.contains(">=") || subexpression.contains("&gt;=")) {
					EngineHelper.greaterThanEqualExpression(expression, ">=", ctoRequest);
				}
			}
		} else if (expression.contains("||")) {
			String[] subexpressions = expression.split("||");
			for (String subexpression : subexpressions) {
				subexpression = subexpression.trim();
			}
		} else {
			if (expression.contains("==")) {
				return EngineHelper.equalExpression(expression, ctoRequest);
			} else if (expression.contains("!=")) {
				return EngineHelper.notEqualExpression(expression, ctoRequest);
			} else if (expression.contains("<")) {
				return EngineHelper.lessThanExpression(expression, ctoRequest);
			} else if (expression.contains(">")) {
				return EngineHelper.greaterThanExpression(expression, ">", ctoRequest);
			} else if (expression.contains("<=")) {
				return EngineHelper.lessThanEqualExpression(expression, "<=", ctoRequest);
			} else if (expression.contains(">=")) {
				return EngineHelper.greaterThanEqualExpression(expression, ">=", ctoRequest);
			}
		}
		return false;
	}

	private static boolean equalExpression(String expression, CTO ctoRequest) throws Exception {
		String[] denghaosubexpressions = expression.split("==");
		String value1 = StringHelper.deleteStr2(denghaosubexpressions[0].trim(), "'");
		String value2 = StringHelper.deleteStr2(denghaosubexpressions[1].trim(), "'");
		value1 = (String) ParameterUtils.analyzeCTOValue(value1, ctoRequest);
		value2 = (String) ParameterUtils.analyzeCTOValue(value2, ctoRequest);
		if (value2.equals(Constant.NULL)) {
			if (value1 == null) {
				return true;
			}
		}
		if (value1.equals(value2)) {
			return true;
		}
		return false;
	}

	private static boolean notEqualExpression(String expression, CTO ctoRequest) throws Exception {
		String[] denghaosubexpressions = expression.split("!=");
		String value1 = StringHelper.deleteStr2(denghaosubexpressions[0].trim(), "'");
		String value2 = StringHelper.deleteStr2(denghaosubexpressions[1].trim(), "'");
		value1 = (String) ParameterUtils.analyzeCTOValue(value1, ctoRequest);
		value2 = (String) ParameterUtils.analyzeCTOValue(value2, ctoRequest);
		if (value2.equals(Constant.NULL)) {
			if (value1 != null) {
				return true;
			}
		}
		if (!value1.equals(value2)) {
			return true;
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
		if (dvalue1 > dvalue2) {
			return true;
		}
		return false;
	}
}
