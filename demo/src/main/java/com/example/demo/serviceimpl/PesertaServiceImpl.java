package com.example.demo.serviceimpl;

import com.example.demo.models.Peserta;
import com.example.demo.models.Program;
import com.example.demo.models.Result;
import com.example.demo.repository.PesertaRepository;
import com.example.demo.request.PesertaRequest;
import com.example.demo.service.PesertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PesertaServiceImpl implements PesertaService {

    @Autowired
    PesertaRepository pesertaRepository;

    private Result result;

    @Override
    public ResponseEntity<Result> createPeserta(PesertaRequest peserta) {
        result = new Result();
        Peserta newPeserta = new Peserta(peserta.getNama(), peserta.getEmail(), peserta.getPassword(), peserta.getNoHp());
        pesertaRepository.save(newPeserta);
        result.setMessage("Berhasil membuat peserta!");
        result.setCode(HttpStatus.OK.value());
        return ResponseEntity.ok(result);
    }
}
