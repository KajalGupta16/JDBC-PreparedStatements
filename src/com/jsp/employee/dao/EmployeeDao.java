package com.jsp.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.jsp.employee.dto.Employee;
import com.jsp.employee.helper.HelperClass;

public class EmployeeDao {
	HelperClass helperClass = new HelperClass();
	Connection connection = null;

	public Employee saveEmployee(Employee employee) throws SQLException {

		connection = helperClass.getConnection();
		String sql = "insert into employee values (?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, employee.getId());
			preparedStatement.setString(2, employee.getName());
			preparedStatement.setString(3, employee.getEmail());

			preparedStatement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return employee;
	}

	public Employee deleteEmployee(Employee employee) throws SQLException {
		connection = helperClass.getConnection();
		String sql = "delete from employee where id=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, employee.getId());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return employee;
	}

	public Employee updateEmployee(Employee employee) throws SQLException {
		connection = helperClass.getConnection();
		String sql = "update Employee set name=? where id=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, employee.getName());
			preparedStatement.setInt(2, employee.getId());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return employee;
	}

	public List<Employee> addMultipleEmployees(List<Employee> employees) throws SQLException {

		connection = helperClass.getConnection();
		String sql = "insert into employee values(?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			for (Employee employee : employees) {
				preparedStatement.setInt(1, employee.getId());
				preparedStatement.setString(2, employee.getName());
				preparedStatement.setString(3, employee.getEmail());

				preparedStatement.addBatch();
			}
			preparedStatement.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return employees;

	}

}
