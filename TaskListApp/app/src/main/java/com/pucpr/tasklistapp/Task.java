package com.pucpr.tasklistapp;

public class Task {
    private int id;
    private String task;
    private String date;

    public Task(int id, String task, String date) {
        this.id = id;
        this.task = task;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public String getDate() {
        return date;
    }
}
