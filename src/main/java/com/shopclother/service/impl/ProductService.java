package com.shopclother.service.impl;

import com.shopclother.dao.IProductDAO;
import com.shopclother.entity.ChiTietSanPham;
import com.shopclother.entity.SanPham;
import com.shopclother.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductService implements IProductService {
    @Autowired
    IProductDAO productDAO;
    @Override
    public List<SanPham> getProduct() {
        return productDAO.getListProduct ();
    }
    public List<SanPham> getProductHaveCategoryIsTShirt() {
        List<SanPham> listAll =productDAO.getListProduct ();
        List<SanPham> listHaveCategoryIsTShirt=new ArrayList<> ();
        for (SanPham s : listAll) {
            if(s.getDanhmucsanpham ().getTendanhmuc ().equals ( "Áo Thun" ))
                listHaveCategoryIsTShirt.add ( s );
        }
        return listHaveCategoryIsTShirt;
    }

    public List<SanPham> getProductHaveCategoryIsShort() {
        List<SanPham> listAll =productDAO.getListProduct ();
        List<SanPham> listHaveCategoryIsShort=new ArrayList<> ();
        for (SanPham s : listAll) {
            if(s.getDanhmucsanpham ().getTendanhmuc ().equals ( "Quần Short" ))
                listHaveCategoryIsShort.add ( s );
        }
        return listHaveCategoryIsShort;
    }
    @Override
    public SanPham getProductHaveProductById ( int masanpham ) {
        return productDAO.getProductHaveProductId ( masanpham );
    }
}
