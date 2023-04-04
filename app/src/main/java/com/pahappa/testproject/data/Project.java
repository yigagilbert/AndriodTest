package com.pahappa.testproject.data;

import java.io.Serializable;

public class Project implements Serializable {
    private  String name;
    private  String status;
    private  String descriptin;

    public Project(String name, String status, String descriptin) {
        this.name = name;
        this.status = status;
        this.descriptin = descriptin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescriptin() {
        return descriptin;
    }

    public void setDescriptin(String descriptin) {
        this.descriptin = descriptin;
    }
}
