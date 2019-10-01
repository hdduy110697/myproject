package com.shopclother.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "chitietsanpham")
public class ChiTietSanPham {
    @Id
    @Column(name = "machitietsanpham")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int machitietsanpham;

    @Column(name = "hinhsanpham",columnDefinition = "TEXT")
    private String hinhsanpham;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "masanpham")
    private SanPham sanpham;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "masize")
    private SizeSanPham sizesanpham;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mamau")
    private MauSanPham mausanpham;
    @Column(name = "soluong")
    private int soluong;
    @Column(name = "ngaynhap")
    private String ngaynhap;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "machitietsanpham")
    private Set<ChiTietHoaDon> danhsachchitiethoadon;

    public String getHinhsanpham() {
        return hinhsanpham;
    }

    public void setHinhsanpham(String hinhsanpham) {
        this.hinhsanpham = hinhsanpham;
    }

    public Set<ChiTietHoaDon> getDanhsachchitiethoadon() {
        return danhsachchitiethoadon;
    }

    public void setDanhsachchitiethoadon(Set<ChiTietHoaDon> danhsachchitiethoadon) {
        this.danhsachchitiethoadon = danhsachchitiethoadon;
    }

    public int getMachitietsanpham() {
        return machitietsanpham;
    }

    public void setMachitietsanpham(int machitietsanpham) {
        this.machitietsanpham = machitietsanpham;
    }

    public SanPham getSanpham() {
        return sanpham;
    }

    public void setSanpham(SanPham sanpham) {
        this.sanpham = sanpham;
    }

    public SizeSanPham getSizesanpham() {
        return sizesanpham;
    }

    public void setSizesanpham(SizeSanPham sizesanpham) {
        this.sizesanpham = sizesanpham;
    }

    public MauSanPham getMausanpham() {
        return mausanpham;
    }

    public void setMausanpham(MauSanPham mausanpham) {
        this.mausanpham = mausanpham;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(String ngaynhap) {
        this.ngaynhap = ngaynhap;
    }
}
