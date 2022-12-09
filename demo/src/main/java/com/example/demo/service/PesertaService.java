package com.example.demo.service;

import com.example.demo.models.Result;
import com.example.demo.request.PesertaRequest;
import com.example.demo.request.ProgramRequest;
import org.springframework.http.ResponseEntity;

public interface PesertaService {

    ResponseEntity<Result> createPeserta(PesertaRequest peserta);
}
