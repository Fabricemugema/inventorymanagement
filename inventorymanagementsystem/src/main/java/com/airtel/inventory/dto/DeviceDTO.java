package com.airtel.inventory.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DeviceDTO {
    private Long id;
    private String serialNumber;
    private String deviceType;
    private String brand;
    private String model;
    private String specifications;
    private LocalDate purchaseDate;
    private LocalDate warrantyUntil;
    private String currentCondition;
    private String status;
    private String notes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getSerialNumber() {
        return serialNumber;
    }
    
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
    
    public String getDeviceType() {
        return deviceType;
    }
    
    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }
    
    public String getBrand() {
        return brand;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public String getSpecifications() {
        return specifications;
    }
    
    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }
    
    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }
    
    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
    
    public LocalDate getWarrantyUntil() {
        return warrantyUntil;
    }
    
    public void setWarrantyUntil(LocalDate warrantyUntil) {
        this.warrantyUntil = warrantyUntil;
    }
    
    public String getCurrentCondition() {
        return currentCondition;
    }
    
    public void setCurrentCondition(String currentCondition) {
        this.currentCondition = currentCondition;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getNotes() {
        return notes;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
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
}