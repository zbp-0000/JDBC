package com.atguigu.advanced.senior.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBC工具类（V1.0）
 * 1.维护一个连接池对象
 * 2.对外提供连接池对象的方法
 * 3.对外提供回收连接的方法
 * */
public class JDBCUtil {
    //创建连接池引用
    private static DataSource dataSource;

    // 项目启动时，既创建连接池对象，赋值给datasource
    static {
        // 静态代码块 是不能向外抛出异常的 所以加try catch
        try {
            Properties properties = new Properties();
            InputStream resourceAsStream = JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");
            properties.load(resourceAsStream);

            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
