package com.shopclother.service;

import com.shopclother.entity.SanPham;

import java.util.List;

public interface IProductService {
    List<SanPham> getProduct();
    List<SanPham> getProductHaveCategoryIsTShirt();
    List<SanPham> getProductHaveCategoryIsShort();
    SanPham getProductHaveProductById ( int masanpham );
}
