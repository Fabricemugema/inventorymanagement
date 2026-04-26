package com.airtel.inventory.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AssignmentDTO {
    private Long id;
    private Long deviceId;
    private String deviceSerial;
    private String deviceModel;
    private Long employeeId;
    private String employeeName;
    private String employeeCode;
    private String department;
    private LocalDate assignedDate;
    private LocalDate expectedReturnDate;
    private LocalDate actualReturnDate;
    private String issueNotes;
    private String returnNotes;
    private String status;
    private LocalDateTime createdAt;
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getDeviceId() {
        return deviceId;
    }
    
    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }
    
    public String getDeviceSerial() {
        return deviceSerial;
    }
    
    public void setDeviceSerial(String deviceSerial) {
        this.deviceSerial = deviceSerial;
    }
    
    public String getDeviceModel() {
        return deviceModel;
    }
    
    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }
    
    public Long getEmployeeId() {
        return employeeId;
    }
    
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
    
    public String getEmployeeName() {
        return employeeName;
    }
    
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    
    public String getEmployeeCode() {
        return employeeCode;
    }
    
    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
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
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}