package com.airtel.inventory.repository;

import com.airtel.inventory.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
    
    List<Device> findByStatus(String status);
    
    List<Device> findByDeviceType(String deviceType);
    
    // Add this method for search
    @Query("SELECT d FROM Device d WHERE " +
           "LOWER(d.serialNumber) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
           "LOWER(d.brand) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
           "LOWER(d.model) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    List<Device> searchDevices(@Param("searchTerm") String searchTerm);
    
    // For case-insensitive search
    List<Device> findBySerialNumberContainingIgnoreCaseOrBrandContainingIgnoreCaseOrModelContainingIgnoreCase(
        String serialNumber, String brand, String model);
}