package com.jsp.employee.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import com.jsp.employee.dao.EmployeeDao;
import com.jsp.employee.dto.Employee;

public class TestBatch {

	public static void main(String[] args) throws SQLException {
		EmployeeDao employeeDao = new EmployeeDao();
		ArrayList<Employee> al = new ArrayList();
		Employee employee1 = new Employee();
		employee1.setId(1);
		employee1.setName("");
		employee1.setEmail("");

		Employee employee2 = new Employee();
		employee2.setId(2);
		employee2.setName("");
		employee2.setEmail("");

		Employee employee3 = new Employee();
		employee3.setId(3);
		employee3.setName("");
		employee3.setEmail("");

		Employee employee4 = new Employee();
		employee4.setId(4);
		employee4.setName("");
		employee4.setEmail("");

		Employee employee5 = new Employee();
		employee5.setId(5);
		employee5.setName("");
		employee5.setEmail("");

		al.add(employee1);
		al.add(employee2);
		al.add(employee3);
		al.add(employee4);
		al.add(employee5);

		employeeDao.addMultipleEmployees(al);
		System.out.println("All good");

	}
}
