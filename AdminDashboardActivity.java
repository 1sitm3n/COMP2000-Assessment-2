package com.example.hrmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AdminDashboardActivity extends AppCompatActivity {

    private Button btnManageEmployees, btnLeaveRequests, btnNotifications;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        btnManageEmployees = findViewById(R.id.btnManageEmployees);
        btnLeaveRequests = findViewById(R.id.btnLeaveRequests);
        btnNotifications = findViewById(R.id.btnNotifications);

        btnManageEmployees.setOnClickListener(v -> {
            Intent intent = new Intent(AdminDashboardActivity.this, EmployeeManagementActivity.class);
            startActivity(intent);
        });

        btnLeaveRequests.setOnClickListener(v -> {
            Intent intent = new Intent(AdminDashboardActivity.this, LeaveRequestsActivity.class);
            startActivity(intent);
        });

        btnNotifications.setOnClickListener(v -> {
            Intent intent = new Intent(AdminDashboardActivity.this, NotificationsActivity.class);
            startActivity(intent);
        });
    }
}
