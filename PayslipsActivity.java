package com.example.hrmanagement;

import android.os.Bundle;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PayslipsActivity extends AppCompatActivity {

    private Spinner spFilterYear;
    private RecyclerView rvPayslips;
    private PayslipAdapter payslipAdapter;
    private List<Payslip> payslipList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payslips);

        spFilterYear = findViewById(R.id.spFilterYear);
        rvPayslips = findViewById(R.id.rvPayslips);

        // Initialize payslip list
        payslipList = new ArrayList<>();
        payslipList.add(new Payslip("January 2023", "$3000"));
        payslipList.add(new Payslip("February 2023", "$3000"));
        payslipList.add(new Payslip("March 2023", "$3200"));

        // Set up RecyclerView
        rvPayslips.setLayoutManager(new LinearLayoutManager(this));
        payslipAdapter = new PayslipAdapter(payslipList);
        rvPayslips.setAdapter(payslipAdapter);

        // Spinner action (optional for future dynamic filtering)
        spFilterYear.setOnItemSelectedListener((parent, view, position, id) -> {
            // Filter payslips by year (mock example for now)
        });
    }
}
