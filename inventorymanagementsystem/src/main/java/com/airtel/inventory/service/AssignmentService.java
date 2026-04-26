package com.airtel.inventory.service;

import com.airtel.inventory.dto.AssignmentDTO;
import com.airtel.inventory.model.Assignment;
import com.airtel.inventory.model.Device;
import com.airtel.inventory.model.Employee;
import com.airtel.inventory.repository.AssignmentRepository;
import com.airtel.inventory.repository.DeviceRepository;
import com.airtel.inventory.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AssignmentService {
    
    @Autowired
    private AssignmentRepository assignmentRepository;
    
    @Autowired
    private DeviceRepository deviceRepository;
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private AuditService auditService;
    
    public Assignment assignDevice(AssignmentDTO assignmentDTO) {
        Device device = deviceRepository.findById(assignmentDTO.getDeviceId())
                .orElseThrow(() -> new RuntimeException("Device not found"));
        
        if (!"AVAILABLE".equals(device.getStatus())) {
            throw new RuntimeException("Device is not available for assignment");
        }
        
        Employee employee = employeeRepository.findById(assignmentDTO.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        
        Assignment assignment = new Assignment();
        assignment.setDevice(device);
        assignment.setEmployee(employee);
        assignment.setAssignedDate(LocalDate.now());
        assignment.setExpectedReturnDate(assignmentDTO.getExpectedReturnDate());
        assignment.setIssueNotes(assignmentDTO.getIssueNotes());
        assignment.setStatus("ACTIVE");
        
        device.setStatus("ASSIGNED");
        deviceRepository.save(device);
        
        Assignment savedAssignment = assignmentRepository.save(assignment);
        auditService.logAction("ASSIGN_DEVICE", device.getId(), device.getSerialNumber(), null, 
                "Assigned to: " + employee.getName(), "SYSTEM", null);
        
        return savedAssignment;
    }
    
    public List<AssignmentDTO> getActiveAssignments() {
        return assignmentRepository.findByStatus("ACTIVE").stream().map(this::convertToDTO).collect(Collectors.toList());
    }
    
    private AssignmentDTO convertToDTO(Assignment assignment) {
        AssignmentDTO dto = new AssignmentDTO();
        dto.setId(assignment.getId());
        dto.setDeviceId(assignment.getDevice().getId());
        dto.setDeviceSerial(assignment.getDevice().getSerialNumber());
        dto.setDeviceModel(assignment.getDevice().getBrand() + " " + assignment.getDevice().getModel());
        dto.setEmployeeId(assignment.getEmployee().getId());
        dto.setEmployeeName(assignment.getEmployee().getName());
        dto.setEmployeeCode(assignment.getEmployee().getEmployeeCode());
        dto.setDepartment(assignment.getEmployee().getDepartment());
        dto.setAssignedDate(assignment.getAssignedDate());
        dto.setExpectedReturnDate(assignment.getExpectedReturnDate());
        dto.setStatus(assignment.getStatus());
        return dto;
    }
}