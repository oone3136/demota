package com.example.demo.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Documents {
    /**
     * end point petrus dan kiki dana
     * kikidana
     * - POST
     * - GET ALL
     * - GET ID
     * petrus
     * - PUT
     * - DELETE
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="url", nullable = false, length = 50)
    private String url;

    @Column(name="directory", nullable = false, length = 50)
    private String directory;

    @Column(name="key", nullable = false)
    private String key;

    @Column(name="filetype", nullable = false, length = 5)
    private String filetype;

    @Column(name="filename", nullable = false, length = 50)
    private String filename;

    @Column(name="isDeleted")
    private boolean isDeleted;

    @Column(name="user_id")
    private int userId;

    @Column(name="role_id")
    private int roleId;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private Date created_at;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updated_at;
}
