package com.nt.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nt.Model.EmployeeLeave;

@Service
public class LeaveService {

    // Temporary in-memory storage
    private List<EmployeeLeave> leaveList = new ArrayList<>();

    // APPLY LEAVE
    public EmployeeLeave applyLeave(EmployeeLeave leave) {

        leaveList.add(leave);

        return leave;
    }

    // GET ALL LEAVES
    public List<EmployeeLeave> getAllLeaves() {

        return leaveList;
    }

    // GET LEAVE BY EMPLOYEE ID
    public EmployeeLeave getLeaveById(int employeeId) {

        for (EmployeeLeave leave : leaveList) {

            if (leave.getEmployeeId() == employeeId) {

                return leave;
            }
        }

        throw new RuntimeException(
                "Leave request not found with Employee ID : " + employeeId);
    }

    // UPDATE LEAVE
    public EmployeeLeave updateLeave(int employeeId,
                                     EmployeeLeave updatedLeave) {

        for (EmployeeLeave leave : leaveList) {

            if (leave.getEmployeeId() == employeeId) {

                leave.setEmployeeName(updatedLeave.getEmployeeName());
                leave.setLeaveType(updatedLeave.getLeaveType());
                leave.setNumberOfDays(updatedLeave.getNumberOfDays());
                leave.setReason(updatedLeave.getReason());

                return leave;
            }
        }

        throw new RuntimeException(
                "Cannot update. Leave request not found with Employee ID : " + employeeId);
    }

    // DELETE LEAVE
    public String deleteLeave(int employeeId) {

        EmployeeLeave leave = getLeaveById(employeeId);

        leaveList.remove(leave);

        return "Leave request deleted successfully";
    }
}