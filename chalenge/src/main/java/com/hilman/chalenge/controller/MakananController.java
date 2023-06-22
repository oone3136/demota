package com.hilman.chalenge.controller;

import com.hilman.chalenge.entity.Makanan;
import com.hilman.chalenge.repository.MakananRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin("http://localhost:8080")
@RequestMapping("/api")
@RestController
public class MakananController {

    @Autowired
    MakananRepository repository;

    private Sort.Direction getSortDirection(String direction){
        if (direction.equals("asc")){
            return Sort.Direction.ASC;
        } else if (direction.equals("desc")) {
            return Sort.Direction.DESC;
        }
        return Sort.Direction.ASC;
    }
    @GetMapping("/sortedmakanan")
    public ResponseEntity<List<Makanan>> getAllMakanan(@RequestParam(defaultValue = "id,desc") String[] sort){
        try{
            List<Order> orders = new ArrayList<>();
            if (sort[0].contains(",")){
                for (String sortOrder : sort){
                    String[] sort1 = sortOrder.split(",");
                    orders.add(new Order(getSortDirection(sort1[1]), sort1[0]));
                }
            }else {
                orders.add(new Order(getSortDirection(sort[1]), sort[0]));
            }
            List<Makanan> tutorials = repository.findAll(Sort.by(orders));
            if (tutorials.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tutorials,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/makanan")
    public ResponseEntity<Map<String, Object>> getAllTutorialPage(@RequestParam(required = false) String nama,
                                                                  @RequestParam(defaultValue = "0") int page,
                                                                  @RequestParam(defaultValue = "3") int size,
                                                                  @RequestParam(defaultValue = "id,desc") String[] sort) {
        try {
            List<Order> orders = new ArrayList<>();
            if (sort[0].contains(",")){
                for (String sortOrder :sort){
                    String[] sort1 = sortOrder.split(",");
                    orders.add(new Order(getSortDirection(sort1[1]), sort1[0]));
                }
            }else {
                orders.add(new Order(getSortDirection(sort[1]), sort[0]));
            }
           List<Makanan> makanans = new ArrayList<>();
            Pageable pagingShort = PageRequest.of(page, size, Sort.by(orders));

            Page<Makanan> pageTuts;
            if (nama == null)
                pageTuts = repository.findAll(pagingShort);
            else pageTuts=repository.findByNamaContaining(nama, pagingShort);

            makanans = pageTuts.getContent();
            Map<String, Object> response = new HashMap<>();
            response.put("makanans", makanans);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItem", pageTuts.getTotalElements());
            response.put("totalPage", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
            } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/makanan/dijual")
    public ResponseEntity<Map<String, Object>> findByDiJual(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size){
        try {
            List<Makanan> makanans = new ArrayList<>();
            Pageable paging = PageRequest.of(page, size);

            Page<Makanan> pageTuts = repository.findByDiJual(true, paging);
            makanans = pageTuts.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("makanans", makanans);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItem", pageTuts.getTotalElements());
            response.put("totalPage", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/makanans/{id}")
    public ResponseEntity<Makanan> getMakananById(@PathVariable("id") long id){
        Optional<Makanan> dataMakanan = repository.findById(id);
        if (dataMakanan.isPresent()){
            return new ResponseEntity<>(dataMakanan.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/makanans")
    public ResponseEntity<Makanan> creatMakanan(@RequestBody Makanan makanan){
        try {
            Makanan makanan1 = repository.save(new Makanan(makanan.getNama(), makanan.getDescirption(), makanan.isDiJual()));
            return new ResponseEntity<>(makanan1, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/makanan/{id}")
    public ResponseEntity<Makanan> updateMakanan(@PathVariable("id") long id, @RequestBody Makanan makanan){
        Optional<Makanan> dataMakanan = repository.findById(id);

        if (dataMakanan.isPresent()){
            Makanan makanan1 = dataMakanan.get();
            makanan1.setNama(makanan.getNama());
            makanan1.setDescirption(makanan.getDescirption());
            makanan1.setDijual(makanan.isDiJual());
            return new ResponseEntity<>(repository.save(makanan1), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/makanan/{id}")
    public ResponseEntity<HttpStatus> deleteMakanan(@PathVariable("id") long id){
        try {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/makanan")
    public ResponseEntity<HttpStatus> deleteAllMakanan(){
        try {
            repository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
