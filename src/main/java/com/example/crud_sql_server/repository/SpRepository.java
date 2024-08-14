package com.example.crud_sql_server.repository;

import com.example.crud_sql_server.model.SanPham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SpRepository implements ISpRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(SanPham sanPham) {
        String sql = "INSERT INTO SanPham (Ten, GiaSanPham, GiaKhuyenMai, HinhAnh, MoTa, DanhMuc, TrangThai) VALUES (?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, new Object[]{
                sanPham.getTen(),
                sanPham.getGiaSanPham(),
                sanPham.getGiaKhuyenMai(),
                sanPham.getHinhAnh(),
                sanPham.getMoTa(),
                sanPham.getDanhMuc(),
                sanPham.getTrangThai()
        });
    }

    @Override
    public int update(SanPham sanPham) {
        String sql = "UPDATE SanPham SET Ten=?, GiaSanPham=?, GiaKhuyenMai=?, HinhAnh=?, MoTa=?, DanhMuc=?, TrangThai=? WHERE Id=?";
        return jdbcTemplate.update(sql, new Object[]{
                sanPham.getTen(),
                sanPham.getGiaSanPham(),
                sanPham.getGiaKhuyenMai(),
                sanPham.getHinhAnh(),
                sanPham.getMoTa(),
                sanPham.getDanhMuc(),
                sanPham.getTrangThai(),
                sanPham.getId()
        });
    }

    @Override
    public int deleteById(int id) {
        String sql = "DELETE FROM SanPham WHERE Id=?";
        return jdbcTemplate.update(sql, new Object[]{id});
    }

    @Override
    public List<SanPham> findAll() {
        String sql = "SELECT * FROM SanPham WHERE TrangThai=N'Còn hàng'";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(SanPham.class));
    }

    @Override
    public SanPham findById(int id) {
        String sql = "SELECT * FROM SanPham WHERE Id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, BeanPropertyRowMapper.newInstance(SanPham.class));
    }
}
