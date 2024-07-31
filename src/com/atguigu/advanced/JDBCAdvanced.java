package com.atguigu.advanced;

import com.atguigu.advanced.pojo.Employee;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCAdvanced {
    @Test
    public void testORM() throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/atguigu", "root", "root");
        String sql = "SELECT emp_id, emp_name, emp_salary, emp_age from t_emp WHERE emp_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, 1);
        ResultSet resultSet = preparedStatement.executeQuery();

        // 声明变量，存ORM对象
        Employee employee = null;

        if(resultSet.next()) {
            int empId = resultSet.getInt("emp_id");
            String empName = resultSet.getString("emp_name");
            double empSalary = resultSet.getDouble("emp_salary");
            int empAge = resultSet.getInt("emp_age");
            employee = new Employee(empId, empName, empSalary,empAge);
        }

        System.out.println(employee);

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }

    @Test
    public void testORMList() throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/atguigu", "root", "root");
        String sql = "SELECT emp_id, emp_name, emp_salary, emp_age from t_emp";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        // 声明变量，存ORM对象
        Employee employee = null;

        // 集合
        List<Employee> employeeList = new ArrayList<>();
        while (resultSet.next()) {
            int empId = resultSet.getInt("emp_id");
            String empName = resultSet.getString("emp_name");
            double empSalary = resultSet.getDouble("emp_salary");
            int empAge = resultSet.getInt("emp_age");
            employee = new Employee(empId, empName, empSalary,empAge);
            employeeList.add(employee);
        }

        for (Employee emp : employeeList) {
            System.out.println(emp);
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }

    @Test
    public void testReturnPK() throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/atguigu", "root", "root");
        String sql = "INSERT INTO t_emp(emp_name, emp_salary, emp_age) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        Employee employee = new Employee(null, "王五", 123.45, 35);
        preparedStatement.setString(1, employee.getEmpName());
        preparedStatement.setDouble(2, employee.getEmpSalary());
        preparedStatement.setInt(3, employee.getEmpAge());
        int result = preparedStatement.executeUpdate();
        ResultSet generatedKeys = null;
        if(result > 0) {
            System.out.println("成功");
            // 获取当前新增数据的主键列，然后会先到当前employee的empID
            // 返回的主键值 是要给单行单列的结果
            generatedKeys = preparedStatement.getGeneratedKeys();
            if(generatedKeys.next()) {
                int empId = generatedKeys.getInt(1);
                employee.setEmpId(empId);
            }
            System.out.println(employee);
        } else {
            System.out.println("失败");
        }
        if(generatedKeys != null) {
            generatedKeys.close();
        }
        preparedStatement.close();
        connection.close();
    }

    @Test
    public void testBatch() throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/atguigu?rewriteBatchedStatements=true", "root", "root");
        String sql = "INSERT INTO t_emp(emp_name, emp_salary, emp_age) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < 10; i++) {
            preparedStatement.setString(1, "王麻子" + i);
            preparedStatement.setDouble(2, 123.45);
            preparedStatement.setInt(3, 35);
            // 把executeUpdate()换成addBatch()
            preparedStatement.addBatch();
        }
        // 执行批量操作
        preparedStatement.executeBatch();

        preparedStatement.close();
        connection.close();
    }
}
