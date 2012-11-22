/**
 * 
 */
package cto.framework.service;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import cto.framework.core.CTO;
import cto.framework.service.cache.memcache.CacheManager;
import cto.framework.service.plugin.schema.Delete;
import cto.framework.service.plugin.schema.Insert;
import cto.framework.service.plugin.schema.SelectFeild;
import cto.framework.service.plugin.schema.SelectRecord;
import cto.framework.service.plugin.schema.SelectRecordSet;
import cto.framework.service.plugin.schema.Update;

/**
 * @author PeterTan
 * 
 */
public interface IDataEngine extends Serializable {

	public void setDataSource(DataSource dataSource);

	public Connection getConnection() throws SQLException;

	public void testSQL() throws SQLException;

	public void executeSelectRecordSet(SelectRecordSet selectRecordSet, CacheManager cacheManager, CTO ctoRequest, CTO ctoResponse) throws Exception;

	public void executeSelectFeild(SelectFeild selectFeild, CacheManager cacheManager, CTO ctoRequest, CTO ctoResponse) throws Exception;

	public void executeUpdate(Update update, CacheManager cacheManager, CTO ctoRequest, CTO ctoResponse) throws Exception;

	public void executeInsert(Insert insert, CacheManager cacheManager, CTO ctoRequest, CTO ctoResponse) throws Exception;

	public void executeDelete(Delete delete, CacheManager cacheManager, CTO ctoRequest, CTO ctoResponse) throws Exception;

	public void executeSQLUpdate(String sql, List<String> sqlParams, CTO ctoRequest, CTO ctoResponse) throws Exception;

	public void executeSQLQuery(String sql, String outputId, List<String> sqlParams, CTO ctoRequest, CTO ctoResponse,int sqlQueryType) throws Exception;

	public void executeSelectRecord(SelectRecord selectRecord, CacheManager cacheManager, CTORequest ctoRequest, CTOResponse ctoResponse)throws Exception;

}
