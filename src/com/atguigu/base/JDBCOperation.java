package com.atguigu.base;

import org.junit.Test;

import java.sql.*;

public class JDBCOperation {
    @Test
    public void testQuerySingleRowAndCol () throws SQLException {
        // 注册驱动 jdk6之后不用显示的写

        // 2.获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/atguigu", "root", "root");

        // 3.预编译sql语句
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) as count FROM t_emp");

        // 4.执行sql语句获取结果
        ResultSet resultSet = preparedStatement.executeQuery();

        // 5.处理结果
        while (resultSet.next()) {
            int count = resultSet.getInt("count");
            System.out.println(count);
        }

        // 6.释放资源
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }

    @Test
    public void testQuerySingleRow() throws Exception {
        // 注册驱动 jdk6之后不用显示的写

        // 2.获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/atguigu", "root", "root");

        String sql = "SELECT emp_id, emp_name, emp_salary, emp_age from t_emp WHERE emp_id = ?";
        // 3.预编译sql语句
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        // 4.执行sql语句获取结果
        preparedStatement.setInt(1, 5); // 给第一个参数，赋值为5
        ResultSet resultSet = preparedStatement.executeQuery();

        // 5.处理结果
        while (resultSet.next()) {
            int empId = resultSet.getInt("emp_id");
            String empName = resultSet.getString("emp_name");
            double empSalary = resultSet.getDouble("emp_salary");
            int empAge = resultSet.getInt("emp_age");
            System.out.println(empId+"\t"+empName+"\t"+empSalary+"\t"+empAge);
        }

        // 6.释放资源
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
