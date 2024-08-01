package com.atguigu.advanced.senior;

import com.atguigu.advanced.senior.util.JDBCUtil;
import org.junit.Test;

import java.sql.Connection;

public class JDBCUtilTest {
    @Test
    public void testGetConnection() {
        Connection connection =  JDBCUtil.getConnection();
        System.out.println(connection);
        JDBCUtil.close(connection);
    }
}
