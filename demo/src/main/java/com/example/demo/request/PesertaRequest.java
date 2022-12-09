package com.example.demo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;


public class PesertaRequest {



    @ApiModelProperty(example = "nama", required = true)
    private String nama;

    @ApiModelProperty(example = "udindev@gmail.com", required = true)
    private String email;

//    Password must contain at least one digit [0-9].
//    Password must contain at least one lowercase Latin character [a-z].
//    Password must contain at least one uppercase Latin character [A-Z].
//    Password must contain at least one special character like ! @ # & ( ).
//    Password must contain a length of at least 8 characters and a maximum of 20 characters.

    @ApiModelProperty(example = "V3rySecret06!", required = true)
    private String password;

    @ApiModelProperty(example = "082115294344", required = true)
    private String noHp;

//    @NotNull(message = "test long Tidak Boleh Kosong")
//    @ApiModelProperty(example = "0", required = true)
//    private Long test;
//
//    @NotNull(message = "test int Tidak Boleh Kosong")
//    @ApiModelProperty(example = "0", required = true)
//    private Integer testint;
//
//    @ApiModelProperty(example = "false", required = true)
//    private boolean testbool;

//    public Long getTest() {
//        return test;
//    }
//
//    public void setTest(Long test) {
//        this.test = test;
//    }
//
//    public Integer getTestint() {
//        return testint;
//    }
//
//    public void setTestint(Integer testint) {
//        this.testint = testint;
//    }
//
//    public boolean isTestbool() {
//        return testbool;
//    }
//
//    public void setTestbool(boolean testbool) {
//        this.testbool = testbool;
//    }


    public PesertaRequest(String nama, String email, String password, String noHp) {
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.noHp = noHp;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public PesertaRequest(String nama, String email, String password) {
        this.nama = nama;
        this.email = email;
        this.password = password;
    }

    public PesertaRequest() {
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
}
