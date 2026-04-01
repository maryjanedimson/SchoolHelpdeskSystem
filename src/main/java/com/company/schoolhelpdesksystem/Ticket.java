package com.company.schoolhelpdesksystem;

import org.bson.types.ObjectId;

/**
 * Ticket model class
 */
public class Ticket {

    private ObjectId id;
    private String userId;
    private String department;
    private String issue;
    private String status;

    // Default constructor for MongoDB
    public Ticket() {}

    public Ticket(String userId, String department, String issue, String status) {
        this.userId = userId;
        this.department = department;
        this.issue = issue;
        this.status = status;
    }

    // Getters and Setters
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", department='" + department + '\'' +
                ", issue='" + issue + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}