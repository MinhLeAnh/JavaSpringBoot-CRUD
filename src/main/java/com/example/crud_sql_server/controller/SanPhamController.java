package com.example.crud_sql_server.controller;

import com.example.crud_sql_server.model.SanPham;
import com.example.crud_sql_server.model.ServiceResponse;
import com.example.crud_sql_server.service.SpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sanpham")
@CrossOrigin("*")
public class SanPhamController {

    @Autowired
    private SpService sanPhamService;

    @GetMapping("/list")
    public ResponseEntity<List<SanPham>> list() {
        List<SanPham> result = sanPhamService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ServiceResponse> save(@RequestBody SanPham sanPham) {
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = sanPhamService.save(sanPham);
        if (result == 1) {
            serviceResponse.setMessage("Item saved with success");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<ServiceResponse> update(@RequestBody SanPham sanPham) {
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = sanPhamService.update(sanPham);
        if (result == 1) {
            serviceResponse.setMessage("Item updated with success");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ServiceResponse> delete(@PathVariable int id) {
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = sanPhamService.deleteById(id);
        if (result == 1) {
            serviceResponse.setMessage("Item removed successfully");
            return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
        } else {
            serviceResponse.setMessage("Item not found or could not be deleted");
            return new ResponseEntity<>(serviceResponse, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<SanPham>> findByPriceRange(
            @RequestParam("giaThap") int giaThap,
            @RequestParam("giaCao") int giaCao) {
        List<SanPham> sanPhams = sanPhamService.findByPriceRange(giaThap, giaCao);
        return new ResponseEntity<>(sanPhams, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<SanPham> findById(@PathVariable int id) {
        SanPham sanPham = sanPhamService.findById(id);
        if (sanPham != null) {
            return new ResponseEntity<>(sanPham, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

