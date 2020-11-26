package com.infotech.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.infotech.dao.EmployeeDAO;
import com.infotech.model.Employee;
import com.infotech.util.DBUtil;

public class EmployeeDAOImpl implements EmployeeDAO {
 
    
//    @Override
//    public void createEmployee(Employee employee) {
//
//        String SQL = "INSERT INTO employee_table(employee_name,email,salary,date_of_joining,bonus)VALUES(?,?,?,?,?)";
//        try (Connection connection = DBUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(SQL)) {
//
//            ps.setString(1, employee.getEmployeeName());
//            ps.setString(2, employee.getEmail());
//            ps.setDouble(3, employee.getSalary());
//            ps.setDate(4, new Date(employee.getDoj().getTime()));
//            ps.setBigDecimal(5, employee.getBonus());
//
//            int executeUpdate = ps.executeUpdate();
//
//            if (executeUpdate == 1) {
//                System.out.println("Employée est crée..");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    } 

    
    @Override
    public Employee getEmployeeById(Integer employeeId) {
        Employee employee = null;
        String SQL = "SELECT *FROM employee_table WHERE employee_id=?";
        try (Connection connection = DBUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(SQL)) {

            ps.setInt(1, employeeId);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int empId = rs.getInt("employee_id");
                String eName = rs.getString("employee_name");
                String email = rs.getString("email");
                Double salary = rs.getDouble("salary");
                BigDecimal bonus = rs.getBigDecimal("bonus");
                Date date = rs.getDate("date_of_joining");

                employee = new Employee();
                employee.setEmployeeName(eName);
                employee.setBonus(bonus);
                employee.setDoj(date);
                employee.setEmail(email);
                employee.setEmployee_id(empId);
                employee.setSalary(salary);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return employee;
    } 

    
    @Override
    public void updateEmployeeEmailById(String newEmail, Integer employeeId) {

        String SQL = "UPDATE employee_table set email=? WHERE employee_id=?;";
        try (Connection connection = DBUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(SQL)) {

            ps.setString(1, newEmail);
            ps.setInt(2, employeeId);

            int executeUpdate = ps.executeUpdate();

            if (executeUpdate == 1) {
                System.out.println("Employee email is updated..");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    
    @Override
    public void deleteEmployeeById(Integer employeeId) {

        String SQL = "DELETE FROM employee_table WHERE employee_id=?;";
        try (Connection connection = DBUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(SQL)) {

            ps.setInt(1, employeeId);

            int executeUpdate = ps.executeUpdate();

            if (executeUpdate == 1) {
                System.out.println("Employee is deleted with ID::" + employeeId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    

    
//    public static void main(String[] args) {                //createEmployee
//        EmployeeDAOImpl employee = new EmployeeDAOImpl();
//        employee.getAllEmployeesInfo();
//    }
    
    @Override
    public List<Employee> getAllEmployeesInfo() {

        List<Employee> empList = new ArrayList<>();
        String SQL = "SELECT *FROM user";
        try (Connection connection = DBUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(SQL)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int empId = rs.getInt("user_id");
                String eName = rs.getString("user_nom");
                String ePrename = rs.getString("user_prenom");
                String email = rs.getString("user_email");
                String password = rs.getString("user_password");
                String confirmPassword = rs.getString("confirm_user_password");
                

                Employee employee = new Employee();
                employee.setEmployee_id(empId);
                employee.setEmployeeName(eName);
                employee.setEmployeePrename(ePrename);
                employee.setEmail(email);
                employee.setEmployeePassword(password);
                employee.setEmployeeConfirmPassword(confirmPassword);
                
                System.out.println(empId);
                System.out.println(eName);
                System.out.println(ePrename);
                System.out.println(email);
                System.out.println(password);
                System.out.println(confirmPassword);
                empList.add(employee);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return empList;
    }
    
//    @Override
//    public List<Employee> getAllEmployeesInfo() {
//
//        List<Employee> empList = new ArrayList<>();
//        String SQL = "SELECT *FROM employee_table";
//        try (Connection connection = DBUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(SQL)) {
//
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                int empId = rs.getInt("employee_id");
//                String eName = rs.getString("employee_name");
//                String email = rs.getString("email");
//                Double salary = rs.getDouble("salary");
//                BigDecimal bonus = rs.getBigDecimal("bonus");
//                Date date = rs.getDate("date_of_joining");
//
//                Employee employee = new Employee();
//                employee.setEmployeeName(eName);
//                employee.setBonus(bonus);
//                employee.setDoj(date);
//                employee.setEmail(email);
//                employee.setEmployee_id(empId);
//                employee.setSalary(salary);
//
//                empList.add(employee);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return empList;
//    }

    
    public static void main(String[] args) {                //createEmployee
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        Employee employee = getEmployee();
        employeeDAO.createEmployee(employee);
    }
    
    private static Employee getEmployee() {
        Employee employee = new Employee();
        employee.setEmail("Martine@yahoo.com");
        employee.setEmployeeName("Martine");
        employee.setEmployeePrename("Duponte");
        employee.setEmployeePassword("motdepasse123");
        employee.setEmployeeConfirmPassword("motdepasse123");
        return employee;
    }
    
    @Override
    public void createEmployee(Employee employee) {
        System.out.println(employee);
        String SQL = "INSERT INTO user(user_email, user_nom, user_prenom, user_password, confirm_user_password) VALUES(?,?,?,?,?)";
        try (Connection connection = DBUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(SQL)) {

            ps.setString(1, employee.getEmail());
            ps.setString(2, employee.getEmployeeName());
            ps.setString(3, employee.getEmployeePrename());
            ps.setString(4, employee.getEmployeePassword());
            ps.setString(5, employee.getEmployeeConfirmPassword());

            int executeUpdate = ps.executeUpdate();

            if (executeUpdate == 1) {
                System.out.println("Employée est crée..");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
