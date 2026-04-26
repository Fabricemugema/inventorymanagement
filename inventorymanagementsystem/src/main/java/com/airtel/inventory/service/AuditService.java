package com.airtel.inventory.service;

import com.airtel.inventory.model.AuditLog;
import com.airtel.inventory.repository.AuditLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class AuditService {
    
    @Autowired
    private AuditLogRepository auditLogRepository;
    
    public void logAction(String actionType, Long deviceId, String deviceSerialNumber, 
                         String oldValue, String newValue, String changedBy, String ipAddress) {
        try {
            AuditLog auditLog = new AuditLog();
            auditLog.setActionType(actionType);
            auditLog.setDeviceId(deviceId);
            auditLog.setDeviceSerialNumber(deviceSerialNumber);
            auditLog.setOldValue(oldValue);
            auditLog.setNewValue(newValue);
            auditLog.setChangedBy(changedBy != null ? changedBy : "SYSTEM");
            auditLog.setIpAddress(ipAddress);
            auditLog.setCreatedAt(LocalDateTime.now());
            
            if (auditLogRepository != null) {
                auditLogRepository.save(auditLog);
            }
        } catch (Exception e) {
            // Don't fail the main operation if audit fails
            System.err.println("Failed to save audit log: " + e.getMessage());
        }
    }
}