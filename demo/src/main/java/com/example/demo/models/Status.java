package com.example.demo.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Status {
    /**
     * rizka tauria
     * - POST
     * - GET ALL
     * - GET BY ID
     * sirajuddin
     * - UPDATE
     * - DELETE
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    /**
     * PESERTA
     * CALON PESERTA
     * REGISTER
     *
     *
     */
    @Column(name="status_name", nullable = false, length = 50)
    private String statusName;

    @Column(name="description", nullable = false)
    private String description;

    /**
     * - MENTOR
     * - PESERTA
     */
    @Column(name="flag", nullable = false)
    private String flag;

    @Column(name="isDeleted")
    private boolean isDeleted;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private Date created_at;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updated_at;
}
