package com.bookstore.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.util.JdbcUtils;

import javax.servlet.ServletContext;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils
{
	public static DruidDataSource dataSource;
	static
	{
		try
		{
			Properties properties = new Properties();

			InputStream resourceAsStream = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
			//从流中加载数据
			properties.load(resourceAsStream);
//			InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");



//			//username=root
//			//password=root
//			//url=jdbc:mysql://localhost:3306/bookstore
//			//driverClassName=com.mysql.jdbc.Driver
//			//initialSize=5
//			//maxActive=10
//			properties.setProperty("username","root");
//			properties.setProperty("password","root");
//			properties.setProperty("url","jdbc:mysql://localhost:3306/bookstore");
//			properties.setProperty("driverClassName","com.mysql.jdbc.Driver");
//			properties.setProperty("initialSize","5");
//			properties.setProperty("maxActive","10");

			System.out.println("loading_1");
//			properties.load(resourceAsStream);
			//创建数据库连接池
			dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
			System.out.println("loading_2");
			System.out.println(dataSource);
		} catch (FileNotFoundException e){e.printStackTrace();}
		catch (Exception e){e.printStackTrace();}
	}
	/**
	 * 获取数据库连接池中的连接
	 * 返回null就是失败
	 */
	public static Connection getConnection()
	{
		Connection connection = null;
		try
		{
//			System.out.println("dataSource: "+dataSource);
			connection = dataSource.getConnection();
		}
		catch (Exception e){
//			System.out.println("connection: "+connection+"dataSource: "+dataSource);
			e.printStackTrace();
		}
		return connection;
//		return null;
	}

	public static void closeConnection(Connection connection)
	{
		if(connection != null)
		{
			try
			{
				connection.close();
			} catch (SQLException ignored){}
		}
	}
}