package com.alisher.model;

import java.time.LocalDateTime;

public class User {

    private int id;
    private int fingerId;
    private String fullName;
    private LocalDateTime createdAt;
    private LocalDateTime lastAccessedAt;

    public User(int id, int fingerId, String fullName) {
        this.id = id;
        this.fingerId = fingerId;
        this.fullName = fullName;
        this.createdAt = LocalDateTime.now();
        this.lastAccessedAt = null;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFingerId(int fingerId) {
        this.fingerId = fingerId;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setLastAccessedAt(LocalDateTime lastAccessedAt) {
        this.lastAccessedAt = lastAccessedAt;
    }

    public int getId() {
        return id;
    }

    public int getFingerId() {
        return fingerId;
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getLastAccessedAt() {
        return lastAccessedAt;
    }
}