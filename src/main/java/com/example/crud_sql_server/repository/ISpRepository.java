package com.example.crud_sql_server.repository;

import com.example.crud_sql_server.model.SanPham;

import java.util.List;

public interface ISpRepository {
    int save(SanPham sanPham);
    int update(SanPham sanPham);
    int deleteById(int id);
    List<SanPham> findAll();
    SanPham findById(int id);
}