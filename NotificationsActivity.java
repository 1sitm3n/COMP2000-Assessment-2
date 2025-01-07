package com.example.hrmanagement;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NotificationsActivity extends AppCompatActivity {

    private RecyclerView rvNotifications;
    private NotificationAdapter notificationAdapter;
    private List<Notification> notificationList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        rvNotifications = findViewById(R.id.rvNotifications);

        // Initialize notification list
        notificationList = new ArrayList<>();
        notificationList.add(new Notification("Leave Request Approved", "Your leave request for 2023-11-01 has been approved.", false));
        notificationList.add(new Notification("New Leave Request", "John Smith has submitted a new leave request.", true));
        notificationList.add(new Notification("Profile Updated", "Your profile has been successfully updated.", false));

        // Set up RecyclerView
        rvNotifications.setLayoutManager(new LinearLayoutManager(this));
        notificationAdapter = new NotificationAdapter(notificationList);
        rvNotifications.setAdapter(notificationAdapter);
    }
}
