package com.example.hrmanagement;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class EmployeeLeaveManagementActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private RecyclerView rvLeaveHistory;
    private LeaveHistoryAdapter leaveHistoryAdapter;
    private FloatingActionButton fabRequestLeave;
    private List<LeaveRequest> leaveHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_leave_management);

        tabLayout = findViewById(R.id.tabLayoutLeaveManagement);
        rvLeaveHistory = findViewById(R.id.rvLeaveHistory);
        fabRequestLeave = findViewById(R.id.fabRequestLeave);

        // Initialize leave history
        leaveHistory = new ArrayList<>();
        leaveHistory.add(new LeaveRequest("2023-11-01 to 2023-11-05", "Pending"));
        leaveHistory.add(new LeaveRequest("2023-10-15 to 2023-10-20", "Approved"));
        leaveHistory.add(new LeaveRequest("2023-09-10 to 2023-09-12", "Declined"));

        // Set up RecyclerView
        rvLeaveHistory.setLayoutManager(new LinearLayoutManager(this));
        leaveHistoryAdapter = new LeaveHistoryAdapter(leaveHistory);
        rvLeaveHistory.setAdapter(leaveHistoryAdapter);

        // Tab Layout for filtering
        tabLayout.addTab(tabLayout.newTab().setText("Pending"));
        tabLayout.addTab(tabLayout.newTab().setText("Approved"));
        tabLayout.addTab(tabLayout.newTab().setText("Declined"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                filterLeaveHistory(tab.getText().toString());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });

        // Request Leave
        fabRequestLeave.setOnClickListener(v -> {
            Intent intent = new Intent(EmployeeLeaveManagementActivity.this, RequestLeaveActivity.class);
            startActivity(intent);
        });
    }

    private void filterLeaveHistory(String status) {
        List<LeaveRequest> filteredHistory = new ArrayList<>();
        for (LeaveRequest request : leaveHistory) {
            if (request.getStatus().equalsIgnoreCase(status)) {
                filteredHistory.add(request);
            }
        }
        leaveHistoryAdapter.updateList(filteredHistory);
    }
}
