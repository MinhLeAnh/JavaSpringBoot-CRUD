package com.example.crud_sql_server.service;

import com.example.crud_sql_server.model.SanPham;
import com.example.crud_sql_server.repository.ISpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpService implements ISpService {

    @Autowired
    private ISpRepository spRepository;

    @Override
    public List<SanPham> findAll() {
        return spRepository.findAll();
    }

    @Override
    public SanPham findById(int id) {
        return spRepository.findById(id);
    }

    @Override
    public int save(SanPham sanPham) {
        return spRepository.save(sanPham);
    }

    @Override
    public int update(SanPham sanPham) {
        return spRepository.update(sanPham);
    }

    @Override
    public int deleteById(int id) {
        return spRepository.deleteById(id);
    }
}
