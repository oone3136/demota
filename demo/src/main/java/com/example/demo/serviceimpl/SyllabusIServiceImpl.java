package com.example.demo.serviceimpl;

import com.example.demo.models.Program;
import com.example.demo.models.Result;
import com.example.demo.models.Syillabus;
import com.example.demo.repository.SyllabusReposito;
import com.example.demo.request.SyllabusRequest;
import com.example.demo.service.SyllabusService;
import com.example.demo.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class SyllabusIServiceImpl implements SyllabusService{

    @Autowired
    StringUtil stringUtil;

    private Result result;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    SyllabusReposito syllabusReposito;

    @Override
    public ResponseEntity<Result> createSyllabus(SyllabusRequest request) {
        result = new Result();
        try {
            int syllabusname = syllabusReposito.findSyllabusname(request.getSyllabus_name().toLowerCase());


            if (syllabusname > 0) {
                result.setMessage("Error: Nama Syllabus Telah Ada!");
                result.setCode(HttpStatus.BAD_REQUEST.value());
                return ResponseEntity
                        .badRequest()
                        .body(result);
            }

            if(request.getDescription().length()>50 || request.getDescription().isBlank()  || request.getDescription().isEmpty()) {
                result.setMessage("Error: Deskripsi Syllabus tidak boleh kosong dan harus kurang dari 50 karakter");
                result.setCode(HttpStatus.BAD_REQUEST.value());
                return ResponseEntity.badRequest().body(result);
            }

            if(request.getSyllabus_name().length()>30 || request.getSyllabus_name().isBlank() || request.getSyllabus_name().isEmpty()) {
                result.setMessage("Error: Nama Syllabus tidak boleh kosong dan harus kurang dari 30 karakter");
                result.setCode(HttpStatus.BAD_REQUEST.value());
                return ResponseEntity.badRequest().body(result);
            }

            Syillabus newSyillabus = new Syillabus(request.getSyllabus_name(), request.getDescription(), false);

            syllabusReposito.save(newSyillabus);

            result.setMessage("Berhasil membuat Syllabus baru!");
            result.setCode(HttpStatus.OK.value());

        } catch (Exception e) {
            logger.error(stringUtil.getError(e));
        }
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<Result> getAllSyllabus() {
        result = new Result();
        try {
            Map<String, List<Syillabus>> items = new HashMap<>();
            Syillabus syillabus = new Syillabus();
            Example<Syillabus> example = Example.of(syillabus);
            items.put("items", syllabusReposito.findAll());
            result.setData(items);

        } catch (Exception e) {
            logger.error(stringUtil.getError(e));
        }
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<Result> getSyllabusById(int id) {

        result = new Result();
        try {
            Optional<Syillabus> syillabus = syllabusReposito.findById(id);
            if (!syillabus.isPresent()) {
                result.setSuccess(false);
                result.setMessage("Error: Tidak ada syllabus dengan id " + id);
                result.setCode(HttpStatus.BAD_REQUEST.value());
            } else {
                Map<String, Syillabus> items = new HashMap<>();
                items.put("items", syillabus.get());
                result.setData(items);
            }

        } catch (Exception e) {
            logger.error(stringUtil.getError(e));
        }
        return ResponseEntity.ok(result);
    }
}
