package com.example.hrmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EmployeeDashboardActivity extends AppCompatActivity {

    private TextView tvLeaveBalance, tvPendingRequests;
    private Button btnManageLeave, btnViewPayslips, btnNotifications;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_dashboard);

        tvLeaveBalance = findViewById(R.id.tvLeaveBalance);
        tvPendingRequests = findViewById(R.id.tvPendingRequests);
        btnManageLeave = findViewById(R.id.btnManageLeave);
        btnViewPayslips = findViewById(R.id.btnViewPayslips);
        btnNotifications = findViewById(R.id.btnNotifications);

        // Load dynamic data (mock example)
        loadDashboardData();

        // Navigate to Manage Leave
        btnManageLeave.setOnClickListener(v -> {
            Intent intent = new Intent(EmployeeDashboardActivity.this, EmployeeLeaveManagementActivity.class);
            startActivity(intent);
        });

        // Navigate to View Payslips
        btnViewPayslips.setOnClickListener(v -> {
            Intent intent = new Intent(EmployeeDashboardActivity.this, PayslipsActivity.class);
            startActivity(intent);
        });

        // Navigate to Notifications
        btnNotifications.setOnClickListener(v -> {
            Intent intent = new Intent(EmployeeDashboardActivity.this, NotificationsActivity.class);
            startActivity(intent);
        });
    }

    private void loadDashboardData() {
        // Mock data (replace with API call)
        String leaveBalance = "Leave Balance: 20/30 days";
        String pendingRequests = "Pending Requests: 2";

        tvLeaveBalance.setText(leaveBalance);
        tvPendingRequests.setText(pendingRequests);
    }
}
