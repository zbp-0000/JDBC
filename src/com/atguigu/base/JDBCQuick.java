package com.atguigu.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCQuick {
    public static void main(String[] args) throws Exception {
        // 1.注册驱动
        // Class.forName("com.mysql.cj.jdbc.Driver"); // jdk6 开始不用写了

        // 2.获取连接对象
        String url = "jdbc:mysql://localhost:3306/atguigu"; // 连接本地的atguigu数据库
        String username = "root";
        String password = "root";
        Connection connection =  DriverManager.getConnection(url, username, password);

        // 3.执行sql语句的对象
        Statement statement = connection.createStatement(); // 执行sql语句的对象

        // 4.编写sql语句并执行
        String sql = "SELECT emp_id, emp_name, emp_salary, emp_age from t_emp";
        ResultSet resultSet = statement.executeQuery(sql); // 返回一个 resultSet (翻译：结果的集合)

        // 5.处理结果
        while (resultSet.next()) {
            int empId = resultSet.getInt("emp_id");
            String empName = resultSet.getString("emp_name");
            double empSalary = resultSet.getDouble("emp_salary");
            int empAge = resultSet.getInt("emp_age");
            System.out.println(empId+"\t"+empName+"\t"+empSalary+"\t"+empAge);
        }

        // 6.释放资源（先开后关的原则）
        resultSet.close();
        statement.close();
        connection.close();
    }
}
