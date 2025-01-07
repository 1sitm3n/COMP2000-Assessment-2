package com.example.hrmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddEditEmployeeActivity extends AppCompatActivity {

    private EditText etName, etEmail, etPhone, etSalary;
    private Spinner spDepartment;
    private Button btnSave, btnCancel;
    private boolean isEditMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_employee);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        etSalary = findViewById(R.id.etSalary);
        spDepartment = findViewById(R.id.spDepartment);
        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);

        // Check if this is edit mode
        Intent intent = getIntent();
        if (intent.hasExtra("employee")) {
            isEditMode = true;
            setTitle("Edit Employee");
            Employee employee = (Employee) intent.getSerializableExtra("employee");
            populateEmployeeDetails(employee);
        } else {
            setTitle("Add Employee");
        }

        // Save button functionality
        btnSave.setOnClickListener(v -> saveEmployeeDetails());

        // Cancel button functionality
        btnCancel.setOnClickListener(v -> finish());
    }

    private void populateEmployeeDetails(Employee employee) {
        etName.setText(employee.getName());
        etEmail.setText(employee.getEmail());
        etPhone.setText(employee.getPhone());
        etSalary.setText(String.valueOf(employee.getSalary()));
        // Set department in spinner (e.g., using index or matching string)
    }

    private void saveEmployeeDetails() {
        String name = etName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();
        String salaryStr = etSalary.getText().toString().trim();
        String department = spDepartment.getSelectedItem().toString();

        if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || salaryStr.isEmpty()) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
            return;
        }

        double salary = Double.parseDouble(salaryStr);

        // Create or update employee object
        Employee employee = new Employee(name, email, phone, department, salary);

        // Mock saving to backend
        new Thread(() -> {
            try {
                // Make API call to save employee
                if (isEditMode) {
                    // PUT request for updating employee
                } else {
                    // POST request for adding new employee
                }

                runOnUiThread(() -> {
                    Toast.makeText(AddEditEmployeeActivity.this, "Employee saved successfully", Toast.LENGTH_SHORT).show();
                    finish();
                });
            } catch (Exception e) {
                e.printStackTrace();
                runOnUiThread(() -> Toast.makeText(AddEditEmployeeActivity.this, "Failed to save employee", Toast.LENGTH_SHORT).show());
            }
        }).start();
    }
}
