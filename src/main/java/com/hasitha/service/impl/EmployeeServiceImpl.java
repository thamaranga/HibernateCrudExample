package com.hasitha.service.impl;

import com.hasitha.dao.impl.EmployeeDAOImpl;
import com.hasitha.entity.Employee;
import com.hasitha.service.EmployeeService;
import org.hibernate.HibernateException;

public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public int addEmployee(Employee employee) throws HibernateException {
        return new EmployeeDAOImpl().addEmployee(employee);
    }

    @Override
    public Employee fetchEmployeeById(int employeeId) throws HibernateException {
        return new EmployeeDAOImpl().fetchEmployeeById(employeeId);
    }

    @Override
    public boolean updateEmployeeById(int employeeId) throws HibernateException {
        return new EmployeeDAOImpl().updateEmployeeById(employeeId);
    }

    @Override
    public boolean deleteEmployeeById(int employeeId) throws HibernateException {
        return new EmployeeDAOImpl().deleteEmployeeById(employeeId);
    }
}
