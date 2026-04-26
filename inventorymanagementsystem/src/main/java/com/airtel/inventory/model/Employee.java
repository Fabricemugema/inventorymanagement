package com.airtel.inventory.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "employees", 
       uniqueConstraints = {
           @UniqueConstraint(columnNames = "employee_code", name = "uk_employee_code")  // FIXED: Changed from "employeeCode" to "employee_code"
       })
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employee implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "employee_code", unique = true, nullable = false, length = 50)  // FIXED: Added explicit column name
    private String employeeCode;
    
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    
    @Column(name = "department", nullable = false, length = 100)  // FIXED: Added column name
    private String department;
    
    @Column(name = "email", length = 100)  // FIXED: Added column name
    private String email;
    
    @Column(name = "phone", length = 15)  // FIXED: Added column name
    private String phone;
    
    @Column(name = "designation", length = 100)  // FIXED: Added column name
    private String designation;
    
    @Column(name = "status", length = 20)  // FIXED: Added column name
    private String status = "ACTIVE";
    
    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    
    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    // Constructors
    public Employee() {
    }
    
    public Employee(String employeeCode, String name, String department) {
        this.employeeCode = employeeCode;
        this.name = name;
        this.department = department;
        this.status = "ACTIVE";
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getEmployeeCode() {
        return employeeCode;
    }
    
    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getDesignation() {
        return designation;
    }
    
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    // Helper methods
    public boolean isActive() {
        return "ACTIVE".equals(this.status);
    }
    
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", employeeCode='" + employeeCode + '\'' +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}