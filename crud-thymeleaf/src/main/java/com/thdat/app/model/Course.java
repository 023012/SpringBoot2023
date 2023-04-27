package com.thdat.app.model;

import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 128, nullable = false)
    private String name;

    @Column(length = 256)
    private String description;

    @Column
    private Double price;

    @Column
    private boolean enabledStatus;

    public Course() {
    }

    public Course(long id, String name, String description, Double price, boolean enabledStatus) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.enabledStatus = enabledStatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isEnabledStatus() {
        return enabledStatus;
    }

    public void setEnabledStatus(boolean enabledStatus) {
        this.enabledStatus = enabledStatus;
    }
}
