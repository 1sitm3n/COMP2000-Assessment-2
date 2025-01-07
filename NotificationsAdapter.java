package com.example.hrmanagement;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder> {

    private List<Notification> notificationList;

    public NotificationAdapter(List<Notification> notificationList) {
        this.notificationList = notificationList;
    }

    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notification, parent, false);
        return new NotificationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationViewHolder holder, int position) {
        Notification notification = notificationList.get(position);

        holder.tvTitle.setText(notification.getTitle());
        holder.tvDescription.setText(notification.getDescription());
        holder.ivStatus.setImageResource(notification.isRead() ? R.drawable.ic_read : R.drawable.ic_unread);

        // Mark as read/unread
        holder.btnMark.setText(notification.isRead() ? "Mark as Unread" : "Mark as Read");
        holder.btnMark.setOnClickListener(v -> {
            notification.setRead(!notification.isRead());
            notifyItemChanged(position);
        });

        // Delete notification
        holder.btnDelete.setOnClickListener(v -> {
            notificationList.remove(position);
            notifyItemRemoved(position);
        });
    }

    @Override
    public int getItemCount() {
        return notificationList.size();
    }

    static class NotificationViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvDescription;
        ImageView ivStatus;
        Button btnMark, btnDelete;

        public NotificationViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            ivStatus = itemView.findViewById(R.id.ivStatus);
            btnMark = itemView.findViewById(R.id.btnMark);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }
}
