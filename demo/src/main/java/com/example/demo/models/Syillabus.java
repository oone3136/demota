package com.example.demo.models;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "syllabus")
@DynamicUpdate
public class Syillabus {
    /**
     * Muhammad Hilman
     * - POST
     * - GET ALL
     * - GET BY ID
     * raihan ramaahdan
     * - DELETE
     * - UPDATE
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="syllabus_name", nullable = false, length = 50)
    private String syllabusName;

    @Column(name="description", nullable = false, length = 500)
    private String description;

    @Column(name="isDeleted")
    private boolean isDeleted;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private Date created_at;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updated_at;

    public Syillabus(){

    }
    public Syillabus(int id, String syllabusName, String description, Date created_at, Date updated_at, boolean isDeleted) {
        this.id = id;
        this.syllabusName = syllabusName;
        this.description = description;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.isDeleted = isDeleted;
    }

    public Syillabus(int id, String syllabusName, String description, boolean isDeleted) {
        this.id = id;
        this.syllabusName = syllabusName;
        this.description = description;
        this.isDeleted = isDeleted;
    }

    public Syillabus(String syllabusName, String description, boolean isDeleted) {
        this.syllabusName = syllabusName;
        this.description = description;
        this.isDeleted = isDeleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSyllabusName() {
        return syllabusName;
    }

    public void setSyllabusName(String syllabusName) {
        this.syllabusName = syllabusName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}
