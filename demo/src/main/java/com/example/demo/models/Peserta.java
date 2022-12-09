package com.example.demo.models;


import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "peserta")
@DynamicUpdate
public class Peserta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(max = 50)
    @Column(name="nama", nullable = false)
    @NotEmpty(message = "Nama Tidak Boleh Kosong")
    private String nama;

    @Column(name="email", nullable = false)
    @Email(message = "Format Email Tidak Sesuai")
    @Pattern(regexp = "^(?=.{1,64})[A-Za-z0-9_\\-]+(\\.[A-Za-z0-9_\\-]+)*+@[^-]{3,}[A-Za-z0-9-]+(\\.[A-Za-z]{2,})*+$", message = "Format Email Tidak Sesuai")
    @Size(max = 100)
    @NotEmpty(message = "Email Tidak Boleh Kosong")
    private String email;

    @Column(name="password", nullable = false)
    @Size(max = 100)
    @NotEmpty(message = "Password Tidak Boleh Kosong")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$", message = "Format Password Salah")
    private String password;

    @NotEmpty(message = "Np HP Tidak Boleh Kosong")
    @Pattern(regexp = "^(\\+62|62)?[\\s-]?0?8[1-9]{1}\\d{1}[\\s-]?\\d{4}[\\s-]?\\d{2,5}$", message = "Format Hp Tidak Sesuai")
    @Column(name = "no_hp", length = 15)
    private String noHp;

    @Column(name="is_deleted", nullable = false, columnDefinition = "boolean default false")
    private boolean isDeleted;

    public Peserta() {
    }

    public Peserta(String nama, String email, String password, String noHp) {
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.noHp = noHp;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
