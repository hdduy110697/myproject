package com.shopclother.dao.impl;

import com.shopclother.dao.IProductDAO;
import com.shopclother.entity.SanPham;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Repository
public class ProductDAO extends AbtrackDAO<SanPham> implements IProductDAO  {
    @Override
    public List<SanPham> getListProduct() {
        return query ( "select s from SanPham s" );
    }
    public SanPham getProductHaveProductId(int masanpham){
        SanPham sanPham= query1 ( "select s from SanPham s where s.masanpham=?1",masanpham );
        // fix lazy ex
//        Hibernate.initialize(sanPham.getChitietsanpham ());
        return sanPham;
    }
}
