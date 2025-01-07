package com.example.hrmanagement;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LeaveRequestAdapter extends RecyclerView.Adapter<LeaveRequestAdapter.LeaveRequestViewHolder> {

    private List<LeaveRequest> leaveRequestList;

    public LeaveRequestAdapter(List<LeaveRequest> leaveRequestList) {
        this.leaveRequestList = leaveRequestList;
    }

    @NonNull
    @Override
    public LeaveRequestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_leave_request, parent, false);
        return new LeaveRequestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeaveRequestViewHolder holder, int position) {
        LeaveRequest request = leaveRequestList.get(position);
        holder.tvEmployeeName.setText(request.getEmployeeName());
        holder.tvDateRange.setText(request.getDateRange());
        holder.tvStatus.setText(request.getStatus());

        if (request.getStatus().equalsIgnoreCase("Pending")) {
            holder.btnApprove.setVisibility(View.VISIBLE);
            holder.btnDecline.setVisibility(View.VISIBLE);

            holder.btnApprove.setOnClickListener(v -> {
                request.setStatus("Approved");
                notifyItemChanged(position);
            });

            holder.btnDecline.setOnClickListener(v -> {
                request.setStatus("Declined");
                notifyItemChanged(position);
            });
        } else {
            holder.btnApprove.setVisibility(View.GONE);
            holder.btnDecline.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return leaveRequestList.size();
    }

    public void updateList(List<LeaveRequest> newRequests) {
        this.leaveRequestList = newRequests;
        notifyDataSetChanged();
    }

    static class LeaveRequestViewHolder extends RecyclerView.ViewHolder {

        TextView tvEmployeeName, tvDateRange, tvStatus;
        Button btnApprove, btnDecline;

        public LeaveRequestViewHolder(@NonNull View itemView) {
            super(itemView);
            tvEmployeeName = itemView.findViewById(R.id.tvEmployeeName);
            tvDateRange = itemView.findViewById(R.id.tvDateRange);
            tvStatus = itemView.findViewById(R.id.tvStatus);
            btnApprove = itemView.findViewById(R.id.btnApprove);
            btnDecline = itemView.findViewById(R.id.btnDecline);
        }
    }
}
