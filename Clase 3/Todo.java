package com.esolutions.java.api;

public class Todo {

    private int userId;
    private int id;
    private String title;
    private boolean completed;

    public Todo(int userId, String userName, int id, String title, boolean completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }
    
    public int getUserId() {
        return this.userId;
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isCompleted() {
        return this.completed;
    }

    public boolean getCompleted() {
        return this.completed;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "{" +
            " userId='" + getUserId() + "'" +
            ", id='" + getId() + "'" +
            ", title='" + getTitle() + "'" +
            ", completed='" + isCompleted() + "'" +
            "}";
    }

}
