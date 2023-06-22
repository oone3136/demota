package com.hilman.chalenge.repository;

import com.hilman.chalenge.entity.Makanan;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MakananRepository extends JpaRepository<Makanan, Long> {


    Page<Makanan> findByNamaContaining(String nama, Pageable pagingShort);

    Page<Makanan> findByDiJual(boolean b, Pageable paging);
}
