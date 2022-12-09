package com.example.demo.controller;


import com.example.demo.models.Result;
import com.example.demo.request.PesertaRequest;
import com.example.demo.request.ProgramRequest;
import com.example.demo.service.PesertaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/peserta")
public class PesertaController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PesertaService pesertaService;

    @PostMapping("/create")
    public ResponseEntity<Result> createPeserta(@Valid @RequestBody PesertaRequest program) {
        return pesertaService.createPeserta(program);
    }
}
