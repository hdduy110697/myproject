package com.shopclother.dao;

import com.shopclother.entity.SanPham;

import java.util.List;

public interface IProductDAO{
    List<SanPham> getListProduct();
    SanPham getProductHaveProductId(int masanpham);
}
