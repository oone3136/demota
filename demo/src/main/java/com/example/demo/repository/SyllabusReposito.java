package com.example.demo.repository;

import com.example.demo.models.Syillabus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
@Repository
public interface SyllabusReposito extends JpaRepository<Syillabus,Integer> {

    @Transactional
    Optional<Syillabus> findBysyllabusName(String syllabus_name);

    @Transactional
    @Query("select count(*) as jumlah from Syillabus as s where lower(s.syllabusName) = ?1")
    int findSyllabusname(String syllabus_name);


}
