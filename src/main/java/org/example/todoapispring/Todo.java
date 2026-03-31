package org.example.todoapispring;

public class Todo {

    private int userId;
    private int id;
    private String title;
    private boolean completed;

    // Default constructor (needed for Spring/Jackson)
    public Todo() {
    }

    // Parameterized constructor
    public Todo(int userId, int id, String title, boolean completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {   // boolean uses "is"
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}