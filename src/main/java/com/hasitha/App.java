package com.hasitha;

import com.hasitha.entity.Employee;
import com.hasitha.service.EmployeeService;
import com.hasitha.service.impl.EmployeeServiceImpl;

import java.math.BigDecimal;


public class App
{
    public static void main( String[] args )
    {

        int result=-1;
        boolean res=false;
        try {

            EmployeeService employeeService= new EmployeeServiceImpl();
            //Saving data

            Employee emp1= new Employee();
            emp1.setName("Hasitha");
            emp1.setDepartment("IS");
            emp1.setSalary(BigDecimal.valueOf(160000));


            result=employeeService.addEmployee(emp1);
            if(result>0){
                System.out.println("employee successfully saved with ID "+result);
            }else{
                System.out.println("Error occured while saving employee");
            }



            //Retrieving data

          /* Employee employee= employeeService.fetchEmployeeById(1);
            System.out.println(employee);*/


           //Updating data
/*            res=employeeService.updateEmployeeById(2);
            if(res){
                System.out.println("employee updated successfully");
            }else{
                System.out.println("Error occured while updating employee");
            }*/

            //Deleting data
/*
            res=employeeService.deleteEmployeeById(1);
            if(res){
                System.out.println("employee deleted successfully");
            }else{
                System.out.println("Error occured while deleting employee");
            }
*/

        } catch (Exception e) {

            System.out.println("e "+e.getMessage());
        }






    }
}
