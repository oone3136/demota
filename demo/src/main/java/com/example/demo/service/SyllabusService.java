package com.example.demo.service;

import com.example.demo.models.Result;
import com.example.demo.request.SyllabusRequest;
import org.springframework.http.ResponseEntity;

public interface SyllabusService {

    //membuat program
    ResponseEntity<Result>createSyllabus(SyllabusRequest request);

    //mengambil keseluruhan data
    ResponseEntity<Result>getAllSyllabus();

    //mengambil data dengan id
    ResponseEntity<Result>getSyllabusById(int id);
}
