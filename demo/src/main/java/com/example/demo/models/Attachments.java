package com.example.demo.models;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "attachments")
@DynamicUpdate
public class Attachments {
    /**
     * yudha kirana
     * - POST
     * - GET ALL
     * - GET BY ID
     * maulana hassan
     * - PUT
     * - DELETE
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

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private Date created_at;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updated_at;
}
