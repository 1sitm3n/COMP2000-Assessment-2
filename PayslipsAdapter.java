package com.example.hrmanagement;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PayslipAdapter extends RecyclerView.Adapter<PayslipAdapter.PayslipViewHolder> {

    private List<Payslip> payslipList;

    public PayslipAdapter(List<Payslip> payslipList) {
        this.payslipList = payslipList;
    }

    @NonNull
    @Override
    public PayslipViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_payslip, parent, false);
        return new PayslipViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PayslipViewHolder holder, int position) {
        Payslip payslip = payslipList.get(position);
        holder.tvMonth.setText(payslip.getMonth());
        holder.tvAmount.setText(payslip.getAmount());

        holder.btnDownload.setOnClickListener(v -> {
            // Logic to download payslip (mock example)
        });
    }

    @Override
    public int getItemCount() {
        return payslipList.size();
    }

    static class PayslipViewHolder extends RecyclerView.ViewHolder {

        TextView tvMonth, tvAmount;
        Button btnDownload;

        public PayslipViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMonth = itemView.findViewById(R.id.tvMonth);
            tvAmount = itemView.findViewById(R.id.tvAmount);
            btnDownload = itemView.findViewById(R.id.btnDownload);
        }
    }
}
