package com.example.hrmanagement;

public class LeaveRequest {
    private String employeeName;
    private String dateRange;
    private String status;

    public LeaveRequest(String employeeName, String dateRange, String status) {
        this.employeeName = employeeName;
        this.dateRange = dateRange;
        this.status = status;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDateRange() {
        return dateRange;
    }

    public void setDateRange(String dateRange) {
        this.dateRange = dateRange;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
