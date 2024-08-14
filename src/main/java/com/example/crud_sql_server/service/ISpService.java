package com.example.crud_sql_server.service;

import com.example.crud_sql_server.model.SanPham;

import java.util.List;

public interface ISpService {
    List<SanPham> findAll();
    SanPham findById(int id);
    int save(SanPham sanPham);
    int update(SanPham sanPham);
    int deleteById(int id);
    List<SanPham> findByPriceRange(int giaThap, int giaCao);

}
