package com.example.demo.repository;

import com.example.demo.models.Peserta;
import com.example.demo.models.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PesertaRepository extends JpaRepository<Peserta, Long> {


}
