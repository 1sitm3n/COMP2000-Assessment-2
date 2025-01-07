package com.example.hrmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManagementActivity extends AppCompatActivity {

    private EditText etSearch;
    private Spinner spDepartmentFilter, spRoleFilter, spStatusFilter;
    private RecyclerView rvEmployees;
    private FloatingActionButton fabAddEmployee;
    private EmployeeAdapter employeeAdapter;
    private List<Employee> employeeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_management);

        etSearch = findViewById(R.id.etSearch);
        spDepartmentFilter = findViewById(R.id.spDepartmentFilter);
        spRoleFilter = findViewById(R.id.spRoleFilter);
        spStatusFilter = findViewById(R.id.spStatusFilter);
        rvEmployees = findViewById(R.id.rvEmployees);
        fabAddEmployee = findViewById(R.id.fabAddEmployee);

        // Dummy data for employees
        employeeList = new ArrayList<>();
        employeeList.add(new Employee("John Smith", "Developer", "Engineering", "Active"));
        employeeList.add(new Employee("Sophia Brown", "Manager", "Sales", "Active"));
        employeeList.add(new Employee("Michael Lee", "Analyst", "HR", "Inactive"));

        // Set up RecyclerView
        rvEmployees.setLayoutManager(new LinearLayoutManager(this));
        employeeAdapter = new EmployeeAdapter(employeeList);
        rvEmployees.setAdapter(employeeAdapter);

        // Add new employee
        fabAddEmployee.setOnClickListener(v -> {
            Intent intent = new Intent(EmployeeManagementActivity.this, AddEditEmployeeActivity.class);
            startActivity(intent);
        });
    }
}
