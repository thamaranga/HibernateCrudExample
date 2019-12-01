package com.hasitha.dao.impl;

import com.hasitha.dao.EmployeeDAO;
import com.hasitha.entity.Employee;
import com.hasitha.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;

public class EmployeeDAOImpl implements EmployeeDAO {


    @Override
    public int addEmployee(Employee employee)  throws HibernateException{
        int result=-1;
        Transaction transaction=null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction=session.beginTransaction();
            result=(int)session.save(employee);
            transaction.commit();
            System.out.println("Employee is created  with Id::"+result);

        } catch (HibernateException e) {
            transaction.rollback();
            System.out.println("e "+e);
            throw e;
        }
        return result;
    }

    @Override
    public Employee fetchEmployeeById(int employeeId) throws HibernateException {
        Employee employee = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            employee = session.get(Employee.class,employeeId );
            if(employee != null){
                return employee;
            }else{
                System.out.println("Employee doesn't exist with provided Id.."+employeeId);
            }
        } catch (HibernateException e) {
            System.out.println("e "+e);
            throw e;
        }
        return null;
    }

    @Override
    public boolean updateEmployeeById(int employeeId) throws HibernateException{
        boolean result=false;
        Transaction transaction=null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Employee employee = session.get(Employee.class, employeeId);
            if(employee != null){
                employee.setSalary(new BigDecimal(175000));
                transaction=session.beginTransaction();
                session.update(employee);
                transaction.commit();
                result=true;
            }else{
                System.out.println("Employee doesn't exist with provided Id.."+employeeId);
            }

        } catch (HibernateException e) {
            transaction.rollback();
            System.out.println("e "+e);
            throw e;
        }
        return result;
    }

    @Override
    public boolean deleteEmployeeById(int employeeId) throws HibernateException {
        boolean result=false;
        Transaction transaction=null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Employee employee = session.get(Employee.class, employeeId);
            if(employee != null){
                transaction=session.beginTransaction();
                session.delete(employee);
                transaction.commit();
                result=true;
            }else{
                System.out.println("Employee doesn't exist with provided Id.."+employeeId);
            }
        } catch (HibernateException e) {
            transaction.rollback();
            System.out.println("e "+e);
            throw e;
        }
        return result;
    }
}
