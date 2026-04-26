package com.airtel.inventory.repository;

import com.airtel.inventory.model.Assignment;
import com.airtel.inventory.model.Device;
import com.airtel.inventory.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    Optional<Assignment> findByDeviceAndStatus(Device device, String status);
    List<Assignment> findByEmployeeAndStatus(Employee employee, String status);
    List<Assignment> findByStatus(String status);
    
    @Query("SELECT a FROM Assignment a WHERE a.status = 'ACTIVE' AND a.expectedReturnDate < :date")
    List<Assignment> findOverdueAssignments(@Param("date") LocalDate date);
    
    boolean existsByDeviceAndStatus(Device device, String status);
}