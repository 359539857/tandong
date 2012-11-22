/**
 * 
 */
package cto.framework.service;

import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import net.spy.memcached.CachedData;
import net.spy.memcached.transcoders.Transcoder;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;

import cto.framework.core.CTO;
import cto.framework.core.CTOItem;
import cto.framework.core.Constant;
import cto.framework.core.util.ParameterUtils;
import cto.framework.core.util.StringHelper;
import cto.framework.service.cache.memcache.CacheManager;
import cto.framework.service.helper.EngineHelper;
import cto.framework.service.plugin.schema.Delete;
import cto.framework.service.plugin.schema.Insert;
import cto.framework.service.plugin.schema.SQLElementTypeItem;
import cto.framework.service.plugin.schema.SQLElse;
import cto.framework.service.plugin.schema.SQLElseTypeItem;
import cto.framework.service.plugin.schema.SQLFor;
import cto.framework.service.plugin.schema.SQLForTypeItem;
import cto.framework.service.plugin.schema.SQLIf;
import cto.framework.service.plugin.schema.SQLIfElseGroup;
import cto.framework.service.plugin.schema.SQLIfTypeItem;
import cto.framework.service.plugin.schema.SelectFeild;
import cto.framework.service.plugin.schema.SelectRecord;
import cto.framework.service.plugin.schema.SelectRecordSet;
import cto.framework.service.plugin.schema.SelectTypeItem;
import cto.framework.service.plugin.schema.Update;
import cto.framework.service.task.SynchroCacheTask;
import cto.framework.service.task.TaskExecutor;

/**
 * @author PeterTan
 * 
 */
public class DataEngine implements IDataEngine {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1715868150251913504L;

	private Logger logger = Logger.getLogger(getClass());

	private DataSource dataSource;

	public void executeSelectRecordSet(SelectRecordSet selectRecordSet, CacheManager cacheManager, CTO ctoRequest, CTO ctoResponse) throws Exception {
		int selectTypeItemCount = selectRecordSet.getSelectTypeItemCount();
		if (selectTypeItemCount > 0) {
			SelectTypeItem[] selectTypeItems = selectRecordSet.getSelectTypeItem();
			StringBuffer sqlBuffer = new StringBuffer();
			for (SelectTypeItem selectTypeItem : selectTypeItems) {
				String outputSQL = selectTypeItem.getOutputSQL();
				if (outputSQL != null) {
					sqlBuffer.append(outputSQL.trim()).append(" ");
				}

				SQLFor sqlFor = selectTypeItem.getSQLFor();
				if (sqlFor != null) {
					onSQLFor(sqlFor, sqlBuffer, ctoRequest, ctoResponse);
				}

				int sqlIfElseGroupCount = selectTypeItem.getSQLIfElseGroupCount();
				if (sqlIfElseGroupCount > 0) {
					SQLIfElseGroup[] sqlIfElseGroups = selectTypeItem.getSQLIfElseGroup();
					for (SQLIfElseGroup sqlIfElseGroup : sqlIfElseGroups) {
						SQLIf sqlIf = sqlIfElseGroup.getSQLIf();
						SQLElse sqlElse = sqlIfElseGroup.getSQLElse();
						if (sqlIf != null && sqlElse != null) {
							if (EngineHelper.executeExpression(sqlIf.getExpression(), ctoRequest)) {
								onSQLIf(sqlIf, sqlBuffer, ctoRequest, ctoResponse);
							} else {
								onSQLElse(sqlElse, sqlBuffer, ctoRequest, ctoResponse);
							}
						} else if (sqlIf != null) {
							if (EngineHelper.executeExpression(sqlIf.getExpression(), ctoRequest)) {
								onSQLIf(sqlIf, sqlBuffer, ctoRequest, ctoResponse);
							}
						}
					}
				}
			}
			if (logger.isDebugEnabled()) {
				logger.debug(sqlBuffer.toString());
			}
			ArrayList<String> sqlParams = new ArrayList<String>();
			String sqlString = this.buildSQL(sqlBuffer.toString(), sqlParams, ctoRequest);
			if (logger.isDebugEnabled()) {
				logger.debug(sqlString);
			}
			if (selectRecordSet.getCache()) {
				String cacheKey = EngineHelper.getCachekey(sqlString, sqlParams, ctoRequest, Constant.SQL_QUERY_RECORDSET);
				CTO[] value = (CTO[]) cacheManager.get(cacheManager.getDefaultUseCacheGroup(), cacheKey);
				if (value != null) {
					ctoRequest.setObjectValue(selectRecordSet.getOutputId(), value);
				} else {
					this.executeSQLQuery(sqlString, selectRecordSet.getOutputId(), sqlParams, ctoRequest, ctoResponse, Constant.SQL_QUERY_RECORDSET);
					CTO[] $value = (CTO[]) ctoRequest.getObjectValue(selectRecordSet.getOutputId());
					if ($value != null) {
						String cacheGroupId = ctoRequest.getStringValue(Constant.CACHEGROUP);
						if (StringHelper.isBlank(cacheGroupId)) {
							cacheGroupId = cacheManager.getDefaultUseCacheGroup();
						}
						if (StringHelper.isBlank(cacheGroupId)) {
							throw new RuntimeException("cacheGroupId is null,please set effective Trans or Service CacheGroupId");
						}
						boolean flag = cacheManager.put(cacheGroupId, cacheKey, $value);
						if (!flag) {
							throw new RuntimeException(cacheGroupId + " CacheGroupId is not found,Please set effective CacheGroupId");
						} else {
							CTO cacheCTO = (CTO) cacheManager.get(cacheGroupId, Constant.CACHE_KEY);
							if (cacheCTO == null) {
								cacheCTO = new CTO();
							}
							CTO ctoSQLInfo = ctoRequest.getCTOValue("$sqlinfo$");
							ctoSQLInfo.setStringValue("outputId", selectRecordSet.getOutputId());
							cacheCTO.setCTOValue(cacheKey, ctoSQLInfo);
							cacheManager.put(cacheGroupId, Constant.CACHE_KEY, cacheCTO);
						}
					}
				}
				ctoRequest.remove("$sqlinfo$");
			} else {
				this.executeSQLQuery(sqlString, selectRecordSet.getOutputId(), sqlParams, ctoRequest, ctoResponse, Constant.SQL_QUERY_RECORDSET);
			}
		}
	}

	public void executeSelectRecord(SelectRecord selectRecord, CacheManager cacheManager, CTORequest ctoRequest, CTOResponse ctoResponse) throws Exception {
		int selectTypeItemCount = selectRecord.getSelectTypeItemCount();
		if (selectTypeItemCount > 0) {
			SelectTypeItem[] selectTypeItems = selectRecord.getSelectTypeItem();
			StringBuffer sqlBuffer = new StringBuffer();
			for (SelectTypeItem selectTypeItem : selectTypeItems) {
				String outputSQL = selectTypeItem.getOutputSQL();
				if (outputSQL != null) {
					sqlBuffer.append(outputSQL.trim()).append(" ");
				}

				SQLFor sqlFor = selectTypeItem.getSQLFor();
				if (sqlFor != null) {
					onSQLFor(sqlFor, sqlBuffer, ctoRequest, ctoResponse);
				}

				int sqlIfElseGroupCount = selectTypeItem.getSQLIfElseGroupCount();
				if (sqlIfElseGroupCount > 0) {
					SQLIfElseGroup[] sqlIfElseGroups = selectTypeItem.getSQLIfElseGroup();
					for (SQLIfElseGroup sqlIfElseGroup : sqlIfElseGroups) {
						SQLIf sqlIf = sqlIfElseGroup.getSQLIf();
						SQLElse sqlElse = sqlIfElseGroup.getSQLElse();
						if (sqlIf != null && sqlElse != null) {
							if (EngineHelper.executeExpression(sqlIf.getExpression(), ctoRequest)) {
								onSQLIf(sqlIf, sqlBuffer, ctoRequest, ctoResponse);
							} else {
								onSQLElse(sqlElse, sqlBuffer, ctoRequest, ctoResponse);
							}
						} else if (sqlIf != null) {
							if (EngineHelper.executeExpression(sqlIf.getExpression(), ctoRequest)) {
								onSQLIf(sqlIf, sqlBuffer, ctoRequest, ctoResponse);
							}
						}
					}
				}
			}
			if (logger.isDebugEnabled()) {
				logger.debug(sqlBuffer.toString());
			}
			ArrayList<String> sqlParams = new ArrayList<String>();
			String sqlString = this.buildSQL(sqlBuffer.toString(), sqlParams, ctoRequest);
			if (logger.isDebugEnabled()) {
				logger.debug(sqlString);
			}
			if (cacheManager.getDefaultUseCacheGroup() != null && selectRecord.getCache()) {
				String cacheKey = EngineHelper.getCachekey(sqlString, sqlParams, ctoRequest, Constant.SQL_QUERY_RECORDSET);
				CTO[] value = (CTO[]) cacheManager.get(cacheManager.getDefaultUseCacheGroup(), cacheKey);
				if (value != null) {
					ctoRequest.setObjectValue(selectRecord.getOutputId(), value);
				} else {
					this.executeSQLQuery(sqlString, selectRecord.getOutputId(), sqlParams, ctoRequest, ctoResponse, Constant.SQL_QUERY_RECORD);
					CTO[] $value = (CTO[]) ctoRequest.getObjectValue(selectRecord.getOutputId());
					if ($value != null) {
						String cacheGroupId = ctoRequest.getStringValue(Constant.CACHEGROUP);
						if (StringHelper.isBlank(cacheGroupId)) {
							cacheGroupId = cacheManager.getDefaultUseCacheGroup();
						}
						if (StringHelper.isBlank(cacheGroupId)) {
							throw new RuntimeException("cacheGroupId is null,please set effective Trans or Service CacheGroupId");
						}
						boolean flag = cacheManager.put(cacheGroupId, cacheKey, $value);
						if (!flag) {
							throw new RuntimeException(cacheGroupId + " CacheGroupId is not found,Please set effective CacheGroupId");
						} else {
							CTO cacheCTO = (CTO) cacheManager.get(cacheGroupId, Constant.CACHE_KEY);
							if (cacheCTO == null) {
								cacheCTO = new CTO();
							}
							CTO ctoSQLInfo = ctoRequest.getCTOValue("$sqlinfo$");
							ctoSQLInfo.setStringValue("outputId", selectRecord.getOutputId());
							cacheCTO.setCTOValue(cacheKey, ctoSQLInfo);
							cacheManager.put(cacheGroupId, Constant.CACHE_KEY, cacheCTO);
						}
					}
				}
				ctoRequest.remove("$sqlinfo$");
			} else {
				this.executeSQLQuery(sqlString, selectRecord.getOutputId(), sqlParams, ctoRequest, ctoResponse, Constant.SQL_QUERY_RECORD);
			}
		}
	}

	public void executeSelectFeild(SelectFeild selectFeild, CacheManager cacheManager, CTO ctoRequest, CTO ctoResponse) throws Exception {
		int selectTypeItemCount = selectFeild.getSelectTypeItemCount();
		if (selectTypeItemCount > 0) {
			SelectTypeItem[] selectTypeItems = selectFeild.getSelectTypeItem();
			StringBuffer sqlBuffer = new StringBuffer();
			for (SelectTypeItem selectTypeItem : selectTypeItems) {
				String outputSQL = selectTypeItem.getOutputSQL();
				if (outputSQL != null) {
					sqlBuffer.append(outputSQL.trim()).append(" ");
				}

				SQLFor sqlFor = selectTypeItem.getSQLFor();
				if (sqlFor != null) {
					onSQLFor(sqlFor, sqlBuffer, ctoRequest, ctoResponse);
				}

				int sqlIfElseGroupCount = selectTypeItem.getSQLIfElseGroupCount();
				if (sqlIfElseGroupCount > 0) {
					SQLIfElseGroup[] sqlIfElseGroups = selectTypeItem.getSQLIfElseGroup();
					for (SQLIfElseGroup sqlIfElseGroup : sqlIfElseGroups) {
						SQLIf sqlIf = sqlIfElseGroup.getSQLIf();
						SQLElse sqlElse = sqlIfElseGroup.getSQLElse();
						if (sqlIf != null && sqlElse != null) {
							if (EngineHelper.executeExpression(sqlIf.getExpression(), ctoRequest)) {
								onSQLIf(sqlIf, sqlBuffer, ctoRequest, ctoResponse);
							} else {
								onSQLElse(sqlElse, sqlBuffer, ctoRequest, ctoResponse);
							}
						} else if (sqlIf != null) {
							if (EngineHelper.executeExpression(sqlIf.getExpression(), ctoRequest)) {
								onSQLIf(sqlIf, sqlBuffer, ctoRequest, ctoResponse);
							}
						}
					}
				}
			}
			if (logger.isDebugEnabled()) {
				logger.debug(sqlBuffer.toString());
			}
			ArrayList<String> sqlParams = new ArrayList<String>();
			String sqlString = this.buildSQL(sqlBuffer.toString(), sqlParams, ctoRequest);
			if (logger.isDebugEnabled()) {
				logger.debug(sqlString);
			}
			if (cacheManager.getDefaultUseCacheGroup() != null && selectFeild.getCache()) {
				String cacheKey = EngineHelper.getCachekey(sqlString, sqlParams, ctoRequest, Constant.SQL_QUERY_FEILD);
				CTO value = (CTO) cacheManager.get(cacheManager.getDefaultUseCacheGroup(), cacheKey);
				if (value != null) {
					ctoRequest.setObjectValue(selectFeild.getOutputId(), value);
				} else {
					this.executeSQLQuery(sqlString, selectFeild.getOutputId(), sqlParams, ctoRequest, ctoResponse, Constant.SQL_QUERY_FEILD);
					CTO $value = (CTO) ctoRequest.getObjectValue(selectFeild.getOutputId());
					if ($value != null) {
						Transcoder tc = null;
						 CachedData co = tc.encode(value);
						cacheManager.put(cacheManager.getDefaultUseCacheGroup(), cacheKey, $value);
						CTO cacheCTO = (CTO) cacheManager.get(cacheManager.getDefaultUseCacheGroup(), Constant.CACHE_KEY);
						CTO ctoSQLInfo = ctoRequest.getCTOValue("$sqlinfo$");
						ctoSQLInfo.setStringValue("outputId", selectFeild.getOutputId());
						cacheCTO.setCTOValue(cacheKey, ctoSQLInfo);
						cacheManager.put(cacheManager.getDefaultUseCacheGroup(), Constant.CACHE_KEY, cacheCTO);
					}
				}
				ctoRequest.remove("$sqlinfo$");
			} else {
				this.executeSQLQuery(sqlString, selectFeild.getOutputId(), sqlParams, ctoRequest, ctoResponse, Constant.SQL_QUERY_FEILD);
			}
		}
	}

	public void executeUpdate(Update update, CacheManager cacheManager, CTO ctoRequest, CTO ctoResponse) throws Exception {
		int sqlElementTypeItemCount = update.getSQLElementTypeItemCount();
		if (sqlElementTypeItemCount > 0) {
			SQLElementTypeItem[] sqlElementTypeItems = update.getSQLElementTypeItem();
			StringBuffer sqlBuffer = new StringBuffer();
			for (SQLElementTypeItem sqlElementTypeItem : sqlElementTypeItems) {
				String outputSQL = sqlElementTypeItem.getOutputSQL();
				if (outputSQL != null) {
					sqlBuffer.append(outputSQL.trim()).append(" ");
				}

				SQLFor sqlFor = sqlElementTypeItem.getSQLFor();
				if (sqlFor != null) {
					onSQLFor(sqlFor, sqlBuffer, ctoRequest, ctoResponse);
				}

				int sqlIfElseGroupCount = sqlElementTypeItem.getSQLIfElseGroupCount();
				if (sqlIfElseGroupCount > 0) {
					SQLIfElseGroup[] sqlIfElseGroups = sqlElementTypeItem.getSQLIfElseGroup();
					for (SQLIfElseGroup sqlIfElseGroup : sqlIfElseGroups) {
						SQLIf sqlIf = sqlIfElseGroup.getSQLIf();
						SQLElse sqlElse = sqlIfElseGroup.getSQLElse();
						if (sqlIf != null && sqlElse != null) {
							if (EngineHelper.executeExpression(sqlIf.getExpression(), ctoRequest)) {
								onSQLIf(sqlIf, sqlBuffer, ctoRequest, ctoResponse);
							} else {
								onSQLElse(sqlElse, sqlBuffer, ctoRequest, ctoResponse);
							}
						} else if (sqlIf != null) {
							if (EngineHelper.executeExpression(sqlIf.getExpression(), ctoRequest)) {
								onSQLIf(sqlIf, sqlBuffer, ctoRequest, ctoResponse);
							}
						}
					}
				}
			}
			if (logger.isDebugEnabled()) {
				logger.debug(sqlBuffer.toString());
			}
			ArrayList<String> sqlParams = new ArrayList<String>();
			String sqlString = this.buildSQL(sqlBuffer.toString(), sqlParams, ctoRequest);
			if (logger.isDebugEnabled()) {
				logger.debug(sqlString);
			}
			this.executeSQLUpdate(sqlString, sqlParams, ctoRequest, ctoResponse);
			if (cacheManager.getDefaultUseCacheGroup() != null) {
				String table = StringHelper.analyzeTableList(sqlBuffer.toString());
				TaskExecutor.getInstance().executeTask(new SynchroCacheTask(table, this));
			}
		}
	}

	public void executeInsert(Insert insert, CacheManager cacheManager, CTO ctoRequest, CTO ctoResponse) throws Exception {
		int sqlElementTypeItemCount = insert.getSQLElementTypeItemCount();
		if (sqlElementTypeItemCount > 0) {
			SQLElementTypeItem[] sqlElementTypeItems = insert.getSQLElementTypeItem();
			StringBuffer sqlBuffer = new StringBuffer();
			for (SQLElementTypeItem sqlElementTypeItem : sqlElementTypeItems) {
				String outputSQL = sqlElementTypeItem.getOutputSQL();
				if (outputSQL != null) {
					sqlBuffer.append(outputSQL.trim()).append(" ");
				}

				SQLFor sqlFor = sqlElementTypeItem.getSQLFor();
				if (sqlFor != null) {
					onSQLFor(sqlFor, sqlBuffer, ctoRequest, ctoResponse);
				}

				int sqlIfElseGroupCount = sqlElementTypeItem.getSQLIfElseGroupCount();
				if (sqlIfElseGroupCount > 0) {
					SQLIfElseGroup[] sqlIfElseGroups = sqlElementTypeItem.getSQLIfElseGroup();
					for (SQLIfElseGroup sqlIfElseGroup : sqlIfElseGroups) {
						SQLIf sqlIf = sqlIfElseGroup.getSQLIf();
						SQLElse sqlElse = sqlIfElseGroup.getSQLElse();
						if (sqlIf != null && sqlElse != null) {
							if (EngineHelper.executeExpression(sqlIf.getExpression(), ctoRequest)) {
								onSQLIf(sqlIf, sqlBuffer, ctoRequest, ctoResponse);
							} else {
								onSQLElse(sqlElse, sqlBuffer, ctoRequest, ctoResponse);
							}
						} else if (sqlIf != null) {
							if (EngineHelper.executeExpression(sqlIf.getExpression(), ctoRequest)) {
								onSQLIf(sqlIf, sqlBuffer, ctoRequest, ctoResponse);
							}
						}
					}
				}
			}
			if (logger.isDebugEnabled()) {
				logger.debug(sqlBuffer.toString());
			}
			ArrayList<String> sqlParams = new ArrayList<String>();
			String sqlString = this.buildSQL(sqlBuffer.toString(), sqlParams, ctoRequest);
			if (logger.isDebugEnabled()) {
				logger.debug(sqlString);
			}
			this.executeSQLUpdate(sqlString, sqlParams, ctoRequest, ctoResponse);
			if (cacheManager.getDefaultUseCacheGroup() != null) {
				String table = StringHelper.analyzeTableList(sqlBuffer.toString());
				TaskExecutor.getInstance().executeTask(new SynchroCacheTask(table, this));
			}
		}
	}

	public void executeDelete(Delete delete, CacheManager cacheManager, CTO ctoRequest, CTO ctoResponse) throws Exception {
		int sqlElementTypeItemCount = delete.getSQLElementTypeItemCount();
		if (sqlElementTypeItemCount > 0) {
			SQLElementTypeItem[] sqlElementTypeItems = delete.getSQLElementTypeItem();
			StringBuffer sqlBuffer = new StringBuffer();
			for (SQLElementTypeItem sqlElementTypeItem : sqlElementTypeItems) {
				String outputSQL = sqlElementTypeItem.getOutputSQL();
				if (outputSQL != null) {
					sqlBuffer.append(outputSQL.trim()).append(" ");
				}

				SQLFor sqlFor = sqlElementTypeItem.getSQLFor();
				if (sqlFor != null) {
					onSQLFor(sqlFor, sqlBuffer, ctoRequest, ctoResponse);
				}

				int sqlIfElseGroupCount = sqlElementTypeItem.getSQLIfElseGroupCount();
				if (sqlIfElseGroupCount > 0) {
					SQLIfElseGroup[] sqlIfElseGroups = sqlElementTypeItem.getSQLIfElseGroup();
					for (SQLIfElseGroup sqlIfElseGroup : sqlIfElseGroups) {
						SQLIf sqlIf = sqlIfElseGroup.getSQLIf();
						SQLElse sqlElse = sqlIfElseGroup.getSQLElse();
						if (sqlIf != null && sqlElse != null) {
							if (EngineHelper.executeExpression(sqlIf.getExpression(), ctoRequest)) {
								onSQLIf(sqlIf, sqlBuffer, ctoRequest, ctoResponse);
							} else {
								onSQLElse(sqlElse, sqlBuffer, ctoRequest, ctoResponse);
							}
						} else if (sqlIf != null) {
							if (EngineHelper.executeExpression(sqlIf.getExpression(), ctoRequest)) {
								onSQLIf(sqlIf, sqlBuffer, ctoRequest, ctoResponse);
							}
						}
					}
				}
			}
			if (logger.isDebugEnabled()) {
				logger.debug(sqlBuffer.toString());
			}
			ArrayList<String> sqlParams = new ArrayList<String>();
			String sqlString = this.buildSQL(sqlBuffer.toString(), sqlParams, ctoRequest);
			if (logger.isDebugEnabled()) {
				logger.debug(sqlString);
			}
			this.executeSQLUpdate(sqlString, sqlParams, ctoRequest, ctoResponse);
			if (cacheManager.getDefaultUseCacheGroup() != null) {
				String table = StringHelper.analyzeTableList(sqlBuffer.toString());
				TaskExecutor.getInstance().executeTask(new SynchroCacheTask(table, this));
			}
		}
	}

	private void onSQLElse(SQLElse sqlElse, StringBuffer sqlBuffer, CTO ctoRequest, CTO ctoResponse) throws Exception {
		int sqlElseTypeItemCount = sqlElse.getSQLElseTypeItemCount();
		if (sqlElseTypeItemCount > 0) {
			SQLElseTypeItem[] sqlElseTypeItems = sqlElse.getSQLElseTypeItem();
			for (SQLElseTypeItem sqlElseTypeItem : sqlElseTypeItems) {
				String outputSQL = sqlElseTypeItem.getOutputSQL();
				if (outputSQL != null) {
					sqlBuffer.append(outputSQL.trim()).append(" ");
				}

				SQLFor sqlFor = sqlElseTypeItem.getSQLFor();
				if (sqlFor != null) {
					onSQLFor(sqlFor, sqlBuffer, ctoRequest, ctoResponse);
				}

				int sqlIfElseGroupCount = sqlElseTypeItem.getSQLIfElseGroupCount();
				if (sqlIfElseGroupCount > 0) {
					SQLIfElseGroup[] sqlIfElseGroups = sqlElseTypeItem.getSQLIfElseGroup();
					for (SQLIfElseGroup sqlIfElseGroup : sqlIfElseGroups) {
						SQLIf sqlIf = sqlIfElseGroup.getSQLIf();
						SQLElse $sqlElse = sqlIfElseGroup.getSQLElse();
						if (sqlIf != null && $sqlElse != null) {
							if (EngineHelper.executeExpression(sqlIf.getExpression(), ctoRequest)) {
								onSQLIf(sqlIf, sqlBuffer, ctoRequest, ctoResponse);
							} else {
								onSQLElse($sqlElse, sqlBuffer, ctoRequest, ctoResponse);
							}
						} else if (sqlIf != null) {
							if (EngineHelper.executeExpression(sqlIf.getExpression(), ctoRequest)) {
								onSQLIf(sqlIf, sqlBuffer, ctoRequest, ctoResponse);
							}
						}
					}
				}
			}
		}
	}

	private void onSQLIf(SQLIf sqlIf, StringBuffer sqlBuffer, CTO ctoRequest, CTO ctoResponse) throws Exception {
		int sqlIfTypeItemCount = sqlIf.getSQLIfTypeItemCount();
		if (sqlIfTypeItemCount > 0) {
			SQLIfTypeItem[] sqlIfTypeItems = sqlIf.getSQLIfTypeItem();
			for (SQLIfTypeItem sqlIfTypeItem : sqlIfTypeItems) {
				String outputSQL = sqlIfTypeItem.getOutputSQL();
				if (outputSQL != null) {
					sqlBuffer.append(outputSQL.trim()).append(" ");
				}

				SQLFor sqlFor = sqlIfTypeItem.getSQLFor();
				if (sqlFor != null) {
					onSQLFor(sqlFor, sqlBuffer, ctoRequest, ctoResponse);
				}

				int sqlIfElseGroupCount = sqlIfTypeItem.getSQLIfElseGroupCount();
				if (sqlIfElseGroupCount > 0) {
					SQLIfElseGroup[] sqlIfElseGroups = sqlIfTypeItem.getSQLIfElseGroup();
					for (SQLIfElseGroup sqlIfElseGroup : sqlIfElseGroups) {
						SQLIf $sqlIf = sqlIfElseGroup.getSQLIf();
						SQLElse $sqlElse = sqlIfElseGroup.getSQLElse();
						if ($sqlIf != null && $sqlElse != null) {
							if (EngineHelper.executeExpression($sqlIf.getExpression(), ctoRequest)) {
								onSQLIf($sqlIf, sqlBuffer, ctoRequest, ctoResponse);
							} else {
								onSQLElse($sqlElse, sqlBuffer, ctoRequest, ctoResponse);
							}
						} else if ($sqlIf != null) {
							if (EngineHelper.executeExpression($sqlIf.getExpression(), ctoRequest)) {
								onSQLIf($sqlIf, sqlBuffer, ctoRequest, ctoResponse);
							}
						}
					}
				}
			}
		}
	}

	private void onSQLFor(SQLFor sqlFor, StringBuffer sqlBuffer, CTO ctoRequest, CTO ctoResponse) throws Exception {
		int sqlForTypeItemCount = sqlFor.getSQLForTypeItemCount();
		if (sqlForTypeItemCount > 0) {
			String begin = sqlFor.getBegin();
			String end = sqlFor.getEnd();
			String collection = sqlFor.getCollection();
			String index = StringHelper.isNotBlank(sqlFor.getIndex()) ? sqlFor.getIndex() : "index";
			String item = sqlFor.getItem();
			String separator = sqlFor.getSeparator();

			// 采用集合方式循环
			if (StringHelper.isNotBlank(collection)) {
				int i = 0;
				if (ParameterUtils.analyzeCTOValue(collection, ctoRequest) instanceof String) {
					if (StringHelper.isNotBlank(item) && StringHelper.isNotBlank(separator) && StringHelper.isNotBlank(begin) && StringHelper.isNotBlank(end)) {
						String[] strs = collection.split(separator);
						sqlBuffer.append("(");
						for (String str : strs) {
							ctoRequest.setIntegerValue(index, i);
							ctoRequest.setStringValue(item, str);
							onFor(sqlFor.getSQLForTypeItem(), sqlBuffer, ctoRequest, ctoResponse);
							ctoRequest.remove(index);
							ctoRequest.remove(item);
							if (i < strs.length - 1) {
								sqlBuffer.append(separator);
							}
							i++;
						}
						sqlBuffer.append(")");
					}
				} else {
					CTO[] ctos = (CTO[]) ParameterUtils.analyzeCTOValue(collection, ctoRequest);
					if (StringHelper.isNotBlank(item) && StringHelper.isNotBlank(separator) && StringHelper.isNotBlank(begin) && StringHelper.isNotBlank(end)) {
						sqlBuffer.append("(");
						for (CTO cto : ctos) {
							ctoRequest.setIntegerValue(index, i);
							ctoRequest.setCTOValue(item, cto);
							onFor(sqlFor.getSQLForTypeItem(), sqlBuffer, ctoRequest, ctoResponse);
							ctoRequest.remove(index);
							ctoRequest.remove(item);
							if (i < ctos.length - 1) {
								sqlBuffer.append(separator);
							}
							i++;
						}
						sqlBuffer.append(")");
					} else {
						for (CTO cto : ctos) {
							ctoRequest.setIntegerValue(index, i);
							ctoRequest.setCTOValue(item, cto);
							onFor(sqlFor.getSQLForTypeItem(), sqlBuffer, ctoRequest, ctoResponse);
							ctoRequest.remove(index);
							ctoRequest.remove(item);
							i++;
						}
					}
				}
			} else if (StringHelper.isNotBlank(begin) && StringHelper.isNotBlank(end)) {// 固定循环
				int $begin = Integer.valueOf(begin);
				int $end = Integer.valueOf(end);
				for (int i = $begin; i < $end; i++) {
					ctoRequest.setIntegerValue(index, $begin);
					onFor(sqlFor.getSQLForTypeItem(), sqlBuffer, ctoRequest, ctoResponse);
					ctoRequest.remove(index);
					i++;
				}
			}
		}
	}

	public void onFor(SQLForTypeItem[] sqlForTypeItems, StringBuffer sqlBuffer, CTO ctoRequest, CTO ctoResponse) throws Exception {
		for (SQLForTypeItem sqlForTypeItem : sqlForTypeItems) {
			String outputSQL = sqlForTypeItem.getOutputSQL();
			if (outputSQL != null) {
				Object value = ParameterUtils.analyzeCTOValue(outputSQL.trim(), ctoRequest);
				if (value instanceof String) {
					sqlBuffer.append("'").append(value).append("' ");
				} else {
					sqlBuffer.append(value).append(" ");
				}
			}
			SQLFor $sqlFor = sqlForTypeItem.getSQLFor();
			if ($sqlFor != null) {
				onSQLFor($sqlFor, sqlBuffer, ctoRequest, ctoResponse);
			}

			int sqlIfElseGroupCount = sqlForTypeItem.getSQLIfElseGroupCount();
			if (sqlIfElseGroupCount > 0) {
				SQLIfElseGroup[] sqlIfElseGroups = sqlForTypeItem.getSQLIfElseGroup();
				for (SQLIfElseGroup sqlIfElseGroup : sqlIfElseGroups) {
					SQLIf $sqlIf = sqlIfElseGroup.getSQLIf();
					SQLElse $sqlElse = sqlIfElseGroup.getSQLElse();
					if ($sqlIf != null && $sqlElse != null) {
						if (EngineHelper.executeExpression($sqlIf.getExpression(), ctoRequest)) {
							onSQLIf($sqlIf, sqlBuffer, ctoRequest, ctoResponse);
						} else {
							onSQLElse($sqlElse, sqlBuffer, ctoRequest, ctoResponse);
						}
					} else if ($sqlIf != null) {
						if (EngineHelper.executeExpression($sqlIf.getExpression(), ctoRequest)) {
							onSQLIf($sqlIf, sqlBuffer, ctoRequest, ctoResponse);
						}
					}
				}
			}
		}
	}

	public PreparedStatement prepareStatement(String sql, List<String> sqlParams, Connection conn, CTO ctoRequest) throws Exception {
		PreparedStatement psmt = conn.prepareStatement(sql);
		if (!sqlParams.isEmpty()) {
			for (int i = 0; i < sqlParams.size(); i++) {
				String param = sqlParams.get(i);
				CTOItem ctoItem = ctoRequest.getCTOItem(param);
				if (ctoItem.getClassType().equals(String.class)) {
					String value = (String) ctoItem.getObjValue();
					psmt.setString(i + 1, value);
				} else if (ctoItem.getClassType().equals(Integer.class)) {
					Integer value = (Integer) ctoItem.getObjValue();
					psmt.setInt(i + 1, value);
				} else if (ctoItem.getClassType().equals(Long.class)) {
					Long value = (Long) ctoItem.getObjValue();
					psmt.setLong(i + 1, value);
				} else if (ctoItem.getClassType().equals(Date.class)) {
					Date value = (Date) ctoItem.getObjValue();
					psmt.setDate(i + 1, value);
				} else if (ctoItem.getClassType().equals(Timestamp.class)) {
					Timestamp value = (Timestamp) ctoItem.getObjValue();
					psmt.setTimestamp(i + 1, value);
				} else if (ctoItem.getClassType().equals(Float.class)) {
					Float value = (Float) ctoItem.getObjValue();
					psmt.setFloat(i + 1, value);
				} else if (ctoItem.getClassType().equals(Short.class)) {
					Short value = (Short) ctoItem.getObjValue();
					psmt.setShort(i + 1, value);
				} else if (ctoItem.getClassType().equals(Boolean.class)) {
					Boolean value = (Boolean) ctoItem.getObjValue();
					psmt.setBoolean(i + 1, value);
				} else if (ctoItem.getClassType().equals(Byte.class)) {
					Byte value = (Byte) ctoItem.getObjValue();
					psmt.setByte(i + 1, value);
				} else if (ctoItem.getClassType().equals(byte[].class)) {
					byte[] value = (byte[]) ctoItem.getObjValue();
					psmt.setBytes(i + 1, value);
				}
			}
		}
		return psmt;
	}

	@SuppressWarnings({ "unchecked" })
	public void executeSQLQuery(String sql, String outputId, List<String> sqlParams, CTO ctoRequest, CTO ctoResponse, int type) throws Exception {
		List<Connection> ctoList = (List<Connection>) ctoRequest.getObjectValue("connections");
		if (ctoList == null) {
			ctoList = new ArrayList<Connection>();
		}
		Connection conn = this.getConnection();
		conn.setAutoCommit(true);
		ctoList.add(conn);
		ctoRequest.setObjectValue("connections", ctoList);
		PreparedStatement psmt = this.prepareStatement(sql, sqlParams, conn, ctoRequest);
		ResultSet rs = null;
		try {
			rs = psmt.executeQuery();
			ResultSetMetaData meta = rs.getMetaData();
			String[] strsFieldName = new String[meta.getColumnCount()];
			for (int i = 0; i < strsFieldName.length; ++i) {
				strsFieldName[i] = meta.getColumnName(i + 1);
			}
			readRecord(rs, strsFieldName, outputId, ctoRequest, type);
		} catch (SQLException e) {
			throw e;
		} finally {
			closeStatement(psmt);
		}
	}

	private void readRecord(ResultSet rs, String[] strsFieldName, String outputId, CTO cto, int type) throws Exception {
		if (type == Constant.SQL_QUERY_RECORDSET) {
			ArrayList<CTO> ctoList = new ArrayList<CTO>();
			while (rs.next()) {
				CTO $cto = new CTO();
				for (int i = 0; i < strsFieldName.length; ++i) {
					Object value = rs.getObject(strsFieldName[i]);
					$cto.setObjectValue(strsFieldName[i], value);
				}
				ctoList.add($cto);
			}
			cto.setCTOArrayValue(outputId, ctoList.toArray(new CTO[1]));
		} else if (type == Constant.SQL_QUERY_RECORD) {
			while (rs.next()) {
				CTO $cto = new CTO();
				for (int i = 0; i < strsFieldName.length; ++i) {
					Object value = rs.getObject(strsFieldName[i]);
					$cto.setObjectValue(strsFieldName[i], value);
				}
				cto.setCTOValue(outputId, $cto);
			}
		} else if (type == Constant.SQL_QUERY_FEILD) {
			while (rs.next()) {
				Object value = rs.getObject(strsFieldName[0]);
				cto.setObjectValue(outputId, value);
			}
		}
		if (rs != null) {
			rs.close();
		}
	}

	@SuppressWarnings({ "unchecked" })
	public void executeSQLUpdate(String sql, List<String> sqlParams, CTO ctoRequest, CTO ctoResponse) throws Exception {
		List<Connection> ctoList = (List<Connection>) ctoRequest.getObjectValue("connections");
		if (ctoList == null) {
			ctoList = new ArrayList<Connection>();
		}
		Connection conn = getConnection();
		conn.setAutoCommit(false);
		ctoList.add(conn);
		ctoRequest.setObjectValue("connections", ctoList);
		PreparedStatement psmt = this.prepareStatement(sql, sqlParams, conn, ctoRequest);
		try {
			psmt.executeUpdate();
		} catch (SQLException e) {
			throw e;
		} finally {
			closeStatement(psmt);
		}
	}

	private void closeStatement(Statement stat) {
		if (stat == null) {
			return;
		}
		try {
			stat.close();
		} catch (Exception localException) {
			logger.error(ExceptionUtils.getFullStackTrace(localException));
		}
	}

	public String buildSQL(String sql, ArrayList<String> sqlParams, CTO ctoRequest) {
		StringBuffer sqlBuffer = new StringBuffer();
		if (sql.contains("$")) {
			int $Index = sql.indexOf("$");
			if (sql.charAt($Index + 1) == '{') {
				int endIndex = sql.indexOf("}");
				if (endIndex != -1) {
					sqlBuffer.append(sql.substring(0, $Index));
					String paramName = sql.substring($Index + 2, endIndex);
					sqlParams.add(paramName);
					sqlBuffer.append("?");
					sql = sql.substring(endIndex + 1, sql.length());
					if (StringHelper.isNotBlank(sql)) {
						sqlBuffer.append(this.buildSQL(sql, sqlParams, ctoRequest));
					}
				}
			} else {
				sqlBuffer.append(sql.substring(0, $Index));
				sql = sql.substring($Index, sql.length());
				int endIndex = sql.indexOf(" ");
				if (endIndex != -1) {
					String paramName = sql.substring(1, endIndex);
					sqlParams.add(paramName);
					sqlBuffer.append("?");
					sql = sql.substring(endIndex, sql.length());
					if (StringHelper.isNotBlank(sql)) {
						sqlBuffer.append(this.buildSQL(sql, sqlParams, ctoRequest));
					}
				}
			}

		} else {
			sqlBuffer.append(sql);
		}

		return sqlBuffer.toString();
	}

	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

	public void testSQL() throws SQLException {
		Connection conn = getConnection();
		Statement statement = conn.createStatement();
		statement.execute("select 1 ");
		logger.info("select 1 is successful");
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}
}
