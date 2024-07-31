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

    @Test
    public void testQueryMoreRow() throws  Exception {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/atguigu", "root", "root");
        String sql = "SELECT emp_id, emp_name, emp_salary, emp_age from t_emp WHERE emp_age > ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, 30); // 给第一个参数，赋值为5
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int empId = resultSet.getInt("emp_id");
            String empName = resultSet.getString("emp_name");
            double empSalary = resultSet.getDouble("emp_salary");
            int empAge = resultSet.getInt("emp_age");
            System.out.println(empId+"\t"+empName+"\t"+empSalary+"\t"+empAge);
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }

    // 增加
    @Test
    public void testInsert() throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/atguigu", "root", "root");
        String sql = "INSERT INTO t_emp(emp_name, emp_salary, emp_age) VALUES (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "李四"); // 给第一个参数，赋值为5
        preparedStatement.setDouble(2, 5299); // 给第一个参数，赋值为5
        preparedStatement.setInt(3, 18); // 给第一个参数，赋值为5
        int result = preparedStatement.executeUpdate(); // 增删改 用 executeUpdate

        // 根据受影响行数，做判断，得到成功或失败
        if(result > 0) {
            System.out.println("成功:"+result);
        } else {
            System.out.println("失败:"+result);
        }

        preparedStatement.close();
        connection.close();
    }

    // 修改
    @Test
    public void testUpdate() throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/atguigu", "root", "root");
        String sql = "UPDATE t_emp SET emp_salary = ? WHERE emp_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setDouble(1, 5299); // 给第一个参数，赋值为5
        preparedStatement.setInt(2, 1); // 给第一个参数，赋值为5
        int result = preparedStatement.executeUpdate(); // 增删改 用 executeUpdate

        // 根据受影响行数，做判断，得到成功或失败
        if(result > 0) {
            System.out.println("成功:"+result);
        } else {
            System.out.println("失败:"+result);
        }

        preparedStatement.close();
        connection.close();
    }

    // 删除
    @Test
    public void testDelete() throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/atguigu", "root", "root");
        String sql = "DELETE FROM t_emp WHERE emp_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, 9); // 给第一个参数，赋值为5
        int result = preparedStatement.executeUpdate(); // 增删改 用 executeUpdate

        // 根据受影响行数，做判断，得到成功或失败
        if(result > 0) {
            System.out.println("成功:"+result);
        } else {
            System.out.println("失败:"+result);
        }

        preparedStatement.close();
        connection.close();
    }
}
