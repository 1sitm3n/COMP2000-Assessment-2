package com.example.hrmanagement;

public class Notification {
    private String title;
    private String description;
    private boolean isRead;

    public Notification(String title, String description, boolean isRead) {
        this.title = title;
        this.description = description;
        this.isRead = isRead;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
}
