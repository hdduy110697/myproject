package com.shopclother.controller.detailProduct;
import com.shopclother.dao.ISizeDAO;
import com.shopclother.entity.ChiTietSanPham;
import com.shopclother.entity.GioHang.GioHang;
import com.shopclother.entity.MauSanPham;
import com.shopclother.entity.SanPham;
import com.shopclother.entity.SizeSanPham;
import com.shopclother.service.IColorService;
import com.shopclother.service.IDetailProductService;
import com.shopclother.service.IProductService;
import com.shopclother.service.ISizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller(value = "homeControllerOfWebDetail")
@RequestMapping(value = "/detail")
public class detailProductController {

    @Autowired
    IProductService productService;
    @Autowired
    ISizeService sizeService;
    @Autowired
    IDetailProductService detailProductService;
    @GetMapping("/{masanpham}")
    public ModelAndView homePage(@PathVariable int masanpham ,HttpSession session) {
        ModelAndView mav = new ModelAndView ();
//        get product by ID
        SanPham sanPham= productService.getProductHaveProductById ( masanpham);
        mav.addObject ( "product",sanPham );
//        get all size
        List<ChiTietSanPham> chiTietSanPhamListDontHaveSameColor=detailProductService.getProductDetailByIDButDontHaveSameColor ( masanpham );
        mav.addObject ( "DetailProductDontHaveSameColor",chiTietSanPhamListDontHaveSameColor );
        List<SizeSanPham> sizeSanPhams=sizeService.getAllSize ();
        mav.addObject ( "sizes",sizeSanPhams );
        // lay session gio hang de hien thi
        if (session.getAttribute ( "giohangs" )!=null){
            List<GioHang> gioHangs = (List<GioHang>) session.getAttribute ( "giohangs" );
            mav.addObject ( "sizeGioHang",gioHangs.size () );
        }
        mav.setViewName ( "web/homeDetail" );
        return mav;
    }
}
