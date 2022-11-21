package com.bookstore.DAO;

import com.bookstore.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class baseDAO
{
	private QueryRunner queryRunner = new QueryRunner();

	/**
	 * 执行insert/update/delete语句
	 * 返回影响行数，如果返回-1说明执行失败
	 */
	public int update(String sql, Object... args)
	{
		Connection connection = JDBCUtils.getConnection();
//		System.out.println(sql);
//		System.out.println(Arrays.toString(args));
		try
		{
			return queryRunner.update(connection,sql,args);
		} catch (SQLException ignored){}
		finally
		{
			JDBCUtils.closeConnection(connection);
		}
		return -2;
	}

	/**
	 * 查询返回一个JavaBean
	 * @param type  返回的对象类型
	 * @param sql   需要执行的sql语句
	 * @param args  变长参数
	 * @return      返回一个JavaBean
	 * @param <T>   返回的类型的泛型
	 */
	public <T>T query(Class<T> type,String sql, Object... args)
	{
		Connection connection = JDBCUtils.getConnection();
		try
		{
			return queryRunner.query(connection,sql,new BeanHandler<T>(type),args);
		} catch (SQLException ignored){}
		finally
		{
			JDBCUtils.closeConnection(connection);
		}
		return null;
	}

	/**
	 * 查询返回多个JavaBean
	 * @param type  返回的对象类型
	 * @param sql   需要执行的sql语句
	 * @param args  变长参数
	 * @return      返回一个JavaBean
	 * @param <T>   返回的类型的泛型
	 */
	public <T> List<T> queryList(Class<T> type, String sql, Object... args)
	{
		Connection connection = JDBCUtils.getConnection();
		try
		{
			return queryRunner.query(connection,sql,new BeanListHandler<T>(type),args);
		} catch (SQLException ignored){}
		finally
		{
			JDBCUtils.closeConnection(connection);
		}
		return null;
	}

	/**
	 * 执行返回单个值的语句
	 * @param sql   需要执行的语句
	 * @param args  变长参数
	 * @return      返回对象，如果为空则说明执行失败
	 */
	public Object querySingleValue(String sql,Object... args)
	{
		Connection connection = JDBCUtils.getConnection();
		try
		{
			return queryRunner.query(connection,sql,new ScalarHandler(),args);
		} catch (SQLException ignored){}
		finally
		{
			JDBCUtils.closeConnection(connection);
		}
		return null;
	}

	public <T> List<T> queryColumn(Class<T> type, String sql, Object... args)
	{
		Connection connection = JDBCUtils.getConnection();
		try
		{
			return queryRunner.query(connection,sql,new ColumnListHandler<>(),args);
		} catch (SQLException ignored){}
		finally
		{
			JDBCUtils.closeConnection(connection);
		}
		return null;
	}
}
