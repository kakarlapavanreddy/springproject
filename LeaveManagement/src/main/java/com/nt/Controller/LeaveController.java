package com.nt.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.Model.EmployeeLeave;
import com.nt.Service.LeaveService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/leaves")
public class LeaveController {

    @Autowired
    private LeaveService service;

    // APPLY LEAVE
    @PostMapping
    public EmployeeLeave applyLeave(
            @Valid @RequestBody EmployeeLeave leave) {

        return service.applyLeave(leave);
    }

    // GET ALL LEAVE REQUESTS
    @GetMapping
    public List<EmployeeLeave> getAllLeaves() {

        return service.getAllLeaves();
    }

    // GET LEAVE BY EMPLOYEE ID
    @GetMapping("/{employeeId}")
    public EmployeeLeave getLeaveById(
            @PathVariable int employeeId) {

        return service.getLeaveById(employeeId);
    }

    // UPDATE LEAVE
    @PutMapping("/{employeeId}")
    public EmployeeLeave updateLeave(
            @PathVariable int employeeId,
            @Valid @RequestBody EmployeeLeave leave) {

        return service.updateLeave(employeeId, leave);
    }

    // DELETE LEAVE
    @DeleteMapping("/{employeeId}")
    public String deleteLeave(
            @PathVariable int employeeId) {

        return service.deleteLeave(employeeId);
    }
}