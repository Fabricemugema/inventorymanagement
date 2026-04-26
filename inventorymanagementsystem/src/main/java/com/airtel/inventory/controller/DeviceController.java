package com.airtel.inventory.controller;

import com.airtel.inventory.model.Device;
import com.airtel.inventory.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
@CrossOrigin(origins = "*")
public class DeviceController {
    
    @Autowired
    private DeviceRepository deviceRepository;
    
    // Get all devices
    @GetMapping
    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }
    
    // Create new device
    @PostMapping
    public Device createDevice(@RequestBody Device device) {
        // Set default values if not provided
        if (device.getStatus() == null) {
            device.setStatus("AVAILABLE");
        }
        if (device.getCurrentCondition() == null) {
            device.setCurrentCondition("GOOD");
        }
        return deviceRepository.save(device);
    }
    
    // Get device by ID
    @GetMapping("/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable Long id) {
        return deviceRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    // Update device
    @PutMapping("/{id}")
    public ResponseEntity<Device> updateDevice(@PathVariable Long id, @RequestBody Device deviceDetails) {
        return deviceRepository.findById(id)
                .map(device -> {
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
                    return ResponseEntity.ok(deviceRepository.save(device));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    // Delete device
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDevice(@PathVariable Long id) {
        if (deviceRepository.existsById(id)) {
            deviceRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    // Search devices (FIXED)

}