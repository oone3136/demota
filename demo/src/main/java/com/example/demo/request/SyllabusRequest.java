package com.example.demo.request;

import io.swagger.annotations.ApiModelProperty;

public class SyllabusRequest {

    @ApiModelProperty(example = "nama syllabus", required = true)
    private String syllabusName;

    @ApiModelProperty(example = "deskripsi", required = true)
    private String description;

    public SyllabusRequest() {
    }
    public SyllabusRequest(String syllabus_name, String description) {
        this.syllabusName = syllabus_name;
        this.description = description;
    }

    public String getSyllabus_name() {
        return syllabusName;
    }

    public void setSyllabus_name(String syllabus_name) {
        this.syllabusName = syllabus_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
