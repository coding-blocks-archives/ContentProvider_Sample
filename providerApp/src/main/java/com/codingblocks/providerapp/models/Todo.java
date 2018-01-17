package com.codingblocks.providerapp.models;

/**
 * Created by championswimmer on 17/01/18.
 */

public class Todo {
    private Integer id;
    private String task;
    private Boolean done;

    public Todo(Integer id, String task, Boolean done) {
        this.id = id;
        this.task = task;
        this.done = done;
    }

    public Todo(String task, Boolean done) {
        this.task = task;
        this.done = done;
    }

    public Integer getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public Boolean getDone() {
        return done;
    }
}
