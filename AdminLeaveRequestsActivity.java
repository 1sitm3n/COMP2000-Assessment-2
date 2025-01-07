package com.example.hrmanagement;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class AdminLeaveRequestsActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private RecyclerView rvLeaveRequests;
    private LeaveRequestAdapter leaveRequestAdapter;
    private List<LeaveRequest> leaveRequests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_leave_requests);

        tabLayout = findViewById(R.id.tabLayout);
        rvLeaveRequests = findViewById(R.id.rvLeaveRequests);

        // Initialize leave requests
        leaveRequests = new ArrayList<>();
        leaveRequests.add(new LeaveRequest("John Smith", "2023-11-01 to 2023-11-05", "Pending"));
        leaveRequests.add(new LeaveRequest("Sophia Brown", "2023-11-10 to 2023-11-12", "Approved"));
        leaveRequests.add(new LeaveRequest("Michael Lee", "2023-11-15 to 2023-11-17", "Declined"));

        // Set up RecyclerView
        rvLeaveRequests.setLayoutManager(new LinearLayoutManager(this));
        leaveRequestAdapter = new LeaveRequestAdapter(leaveRequests);
        rvLeaveRequests.setAdapter(leaveRequestAdapter);

        // Tab layout for filtering
        tabLayout.addTab(tabLayout.newTab().setText("Pending"));
        tabLayout.addTab(tabLayout.newTab().setText("Approved"));
        tabLayout.addTab(tabLayout.newTab().setText("Declined"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                filterLeaveRequests(tab.getText().toString());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });
    }

    private void filterLeaveRequests(String status) {
        List<LeaveRequest> filteredRequests = new ArrayList<>();
        for (LeaveRequest request : leaveRequests) {
            if (request.getStatus().equalsIgnoreCase(status)) {
                filteredRequests.add(request);
            }
        }
        leaveRequestAdapter.updateList(filteredRequests);
    }
}
