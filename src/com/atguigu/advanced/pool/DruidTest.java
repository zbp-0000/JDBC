package com.atguigu.advanced.pool;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DruidTest {
    @Test
    public void testHardCodeDruid() throws Exception {
        /*
        * 硬编码Druid
        * 1.创建DruidDataSource连接池对象
        * 2.设置连接池的配置信息【必须|非必须】
        * 3.通过连接池获取连接对象
        * 4.回收连接【不是释放连接，而是将连接归还连接池】
        * */
        // 1. 创建 DruidDataSource
        DruidDataSource druidDataSource = new DruidDataSource();
        // 2. 设置连接参数
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/atguigu");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("root");
        // 2.2 非必须
        druidDataSource.setInitialSize(10); // 初始化连接池时的连接个数的大小
        druidDataSource.setMaxActive(20); // 最大连接数

        DruidPooledConnection connection = druidDataSource.getConnection();
        System.out.println(connection);
        connection.close(); // 归还、回收连接
    }

    @Test
    public void testResourcesDruid() throws Exception {
        // 1. 创建properties集合
        Properties properties = new Properties();

        // 2. 读取配置文件
        InputStream resourceAsStream = DruidTest.class.getClassLoader().getResourceAsStream("db.properties");
        properties.load(resourceAsStream); // 读取配置 返回的是配置信息

        // 3. 基于Properties集合构建DruidDatasource连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        // 4. 通过连接池获取连接对象
        Connection connection = dataSource.getConnection();

        // 5. 并发CRUD

        // 6. 回收连接
        connection.close();
    }
}
