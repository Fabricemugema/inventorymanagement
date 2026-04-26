package com.airtel.inventory.model;

import javax.persistence.*;
import java.time.LocalDate;

@SuppressWarnings("serial")
@Entity
@Table(name = "assignments")
public class Assignment extends BaseEntity {
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_id", nullable = false)
    private Device device;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;
    
    @Column(nullable = false)
    private LocalDate assignedDate;
    
    private LocalDate expectedReturnDate;
    
    private LocalDate actualReturnDate;
    
    @Column(length = 500)
    private String issueNotes;
    
    @Column(length = 500)
    private String returnNotes;
    
    private String status;
    
    // Getters and Setters
    public Device getDevice() {
        return device;
    }
    
    public void setDevice(Device device) {
        this.device = device;
    }
    
    public Employee getEmployee() {
        return employee;
    }
    
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    public LocalDate getAssignedDate() {
        return assignedDate;
    }
    
    public void setAssignedDate(LocalDate assignedDate) {
        this.assignedDate = assignedDate;
    }
    
    public LocalDate getExpectedReturnDate() {
        return expectedReturnDate;
    }
    
    public void setExpectedReturnDate(LocalDate expectedReturnDate) {
        this.expectedReturnDate = expectedReturnDate;
    }
    
    public LocalDate getActualReturnDate() {
        return actualReturnDate;
    }
    
    public void setActualReturnDate(LocalDate actualReturnDate) {
        this.actualReturnDate = actualReturnDate;
    }
    
    public String getIssueNotes() {
        return issueNotes;
    }
    
    public void setIssueNotes(String issueNotes) {
        this.issueNotes = issueNotes;
    }
    
    public String getReturnNotes() {
        return returnNotes;
    }
    
    public void setReturnNotes(String returnNotes) {
        this.returnNotes = returnNotes;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
}