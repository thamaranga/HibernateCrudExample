package com.hasitha.service;

import com.hasitha.entity.Employee;
import org.hibernate.HibernateException;

public interface EmployeeService {

    int addEmployee(Employee employee) throws HibernateException;
    Employee  fetchEmployeeById(int employeeId) throws HibernateException;
    boolean updateEmployeeById(int employeeId) throws HibernateException;
    boolean  deleteEmployeeById(int employeeId) throws HibernateException;
}
