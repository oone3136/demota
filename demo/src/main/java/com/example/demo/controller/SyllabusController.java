package com.example.demo.controller;

import com.example.demo.models.Result;
import com.example.demo.request.SyllabusRequest;
import com.example.demo.service.SyllabusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin
@RestController
@RequestMapping("/syllabus")
public class SyllabusController {

    @Autowired
    SyllabusService service;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //creat data
    @PostMapping("/create")
    public ResponseEntity<Result>createSyllabus(@Valid @RequestBody SyllabusRequest request){
        return service.createSyllabus(request);
    }

    //get all
    @GetMapping(value = "/all", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Result>getAllSyllabus(){

        return service.getAllSyllabus();
    }

    //get by id
    @GetMapping(value = ("/{id}"),produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Result>getSyllabusById(@PathVariable("id")int id){

        return service.getSyllabusById(id);
    }
}
