package com.app.registration.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.registration.model.Staff;
import com.app.registration.repository.StaffRepository;
import com.app.registration.service.ResourceNotFoundException3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class StaffController {

    @Autowired
    private StaffRepository staffRepository;

    @GetMapping("/staffs")
    public List<Staff> getAllStaffs(){
        return this.staffRepository.findAll();
    }

    @GetMapping("/staffs/{id}")
    public ResponseEntity<Staff> getStaffById(@PathVariable Long id){
    	Staff staff = staffRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException3("Staff with id '"+id+"' does not exist"));
        return ResponseEntity.ok(staff);
    }

    @PostMapping("/staffs")
    public Staff createStaff(@RequestBody Staff staff){
        return staffRepository.save(staff);
    }
    @PutMapping("/staffs/{id}")
    public ResponseEntity<Staff> updateStaff (@PathVariable Long id, @RequestBody Staff staffInfo) {

        Staff staff = staffRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException3("Staff with id '" + id + "' does not exist"));

        staff.setId(staffInfo.getId());
        staff.setName(staffInfo.getName());
        staff.setAge(staffInfo.getAge());
        staff.setAddress(staffInfo.getAddress());
        staff.setPhoneNo(staffInfo.getPhoneNo());
        staff.setRole(staffInfo.getRole());
       

        
        Staff updatedStaff = staffRepository.save(staff);
        return ResponseEntity.ok(updatedStaff);
    }

    // todo: validate
    @DeleteMapping("/staffs/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Map<String, Boolean>> deleteStaff(@PathVariable Long id){
    	Staff staff = staffRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException3("Staff with id '" + id + "' does not exist"));

        staffRepository.delete(staff);
        Map<String, Boolean> response = new HashMap<>();

        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);

    }

}