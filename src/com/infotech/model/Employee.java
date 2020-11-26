package com.infotech.model;

import java.math.BigDecimal;
import java.util.Date;

public class Employee {

	private int employee_id;
	private String employeeName;
        private String employeePrename;
        private String employeePassword;
        private String employeeConfirmPassword;
	private String email;
	private Double salary;
	private Date doj;
	private BigDecimal bonus;

    public int getEmployee_id() {
        return employee_id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeePrename() {
        return employeePrename;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public String getEmployeeConfirmPassword() {
        return employeeConfirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public Double getSalary() {
        return salary;
    }

    public Date getDoj() {
        return doj;
    }

    public BigDecimal getBonus() {
        return bonus;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setEmployeePrename(String employeePrename) {
        this.employeePrename = employeePrename;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }

    public void setEmployeeConfirmPassword(String employeeConfirmPassword) {
        this.employeeConfirmPassword = employeeConfirmPassword;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }

    public void setBonus(BigDecimal bonus) {
        this.bonus = bonus;
    }
	
	
        
    // La méthode toString() en java permet de donner un aperçut d'un objet instancié. 
//C'est à dire que cette méthode va te retourner une chaine de caractère représentant ton objet : 
    //affichage de la valeur des propriétés par exemple.

	@Override
        public String toString() {
            return "Employee{" + "employee_id=" + employee_id + ", employeeName=" + employeeName + ", employeePrename=" + employeePrename + ", employeePassword=" + employeePassword + ", employeeConfirmPassword=" + employeeConfirmPassword + ", email=" + email + '}';
        }
}
