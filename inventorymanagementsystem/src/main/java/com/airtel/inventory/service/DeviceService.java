package com.airtel.inventory.service;

import com.airtel.inventory.model.Device;
import com.airtel.inventory.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class DeviceService {
    
    @Autowired
    private DeviceRepository deviceRepository;
    
    @Autowired
    private AuditService auditService;
    
    public Device createDevice(Device device) {
        if (device.getStatus() == null) {
            device.setStatus("AVAILABLE");
        }
        if (device.getCurrentCondition() == null) {
            device.setCurrentCondition("GOOD");
        }
        
        Device savedDevice = deviceRepository.save(device);
        auditService.logAction("CREATE_DEVICE", savedDevice.getId(), savedDevice.getSerialNumber(), 
                               null, savedDevice.toString(), "SYSTEM", null);
        return savedDevice;
    }
    
    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }
    
    public List<Device> searchDevices(String searchTerm) {
        if (searchTerm == null || searchTerm.trim().isEmpty()) {
            return getAllDevices();
        }
        return deviceRepository.searchDevices(searchTerm.trim());
    }
    
    public Device getDeviceById(Long id) {
        return deviceRepository.findById(id).orElseThrow(() -> new RuntimeException("Device not found"));
    }
    
    public Device updateDevice(Long id, Device deviceDetails) {
        Device device = getDeviceById(id);
        
        String oldValue = device.toString();
        
        device.setSerialNumber(deviceDetails.getSerialNumber());
        device.setDeviceType(deviceDetails.getDeviceType());
        device.setBrand(deviceDetails.getBrand());
        device.setModel(deviceDetails.getModel());
        device.setSpecifications(deviceDetails.getSpecifications());
        device.setPurchaseDate(deviceDetails.getPurchaseDate());
        device.setWarrantyUntil(deviceDetails.getWarrantyUntil());
        device.setCurrentCondition(deviceDetails.getCurrentCondition());
        device.setStatus(deviceDetails.getStatus());
        device.setNotes(deviceDetails.getNotes());
        
        Device updatedDevice = deviceRepository.save(device);
        auditService.logAction("UPDATE_DEVICE", updatedDevice.getId(), updatedDevice.getSerialNumber(),
                               oldValue, updatedDevice.toString(), "SYSTEM", null);
        
        return updatedDevice;
    }
    
    public void deleteDevice(Long id) {
        Device device = getDeviceById(id);
        auditService.logAction("DELETE_DEVICE", device.getId(), device.getSerialNumber(), 
                               device.toString(), null, "SYSTEM", null);
        deviceRepository.deleteById(id);
    }
}