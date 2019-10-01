package com.shopclother.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "sanpham")
public class SanPham {
    @Id
    @Column(name = "masanpham")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int masanpham;
    @OneToOne
    @JoinColumn(name = "madanhmuc")
    private DanhMucSanPham danhmucsanpham;

    @Column(name = "tensanpham")
    private String tensanpham;
    @Column(name = "giatien")
    private Integer giatien;
    @Column(name = "mota",columnDefinition = "TEXT")
    private String mota;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "masanpham")
    private Set<ChiTietSanPham> chitietsanpham;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "CHITIETKHUYENMAI",joinColumns = {@JoinColumn(name = "masanpham",referencedColumnName = "masanpham")},
            inverseJoinColumns = {@JoinColumn(name = "makhuyenmai",referencedColumnName = "makhuyenmai")})
    private Set<KhuyenMai> danhsachkhuyenmai;

    public Set<ChiTietSanPham> getChitietsanpham() {
        return chitietsanpham;
    }

    public void setChitietsanpham(Set<ChiTietSanPham> chitietsanpham) {
        this.chitietsanpham = chitietsanpham;
    }

    public Set<KhuyenMai> getDanhsachkhuyenmai() {
        return danhsachkhuyenmai;
    }

    public void setDanhsachkhuyenmai(Set<KhuyenMai> danhsachkhuyenmai) {
        this.danhsachkhuyenmai = danhsachkhuyenmai;
    }

    public int getMasanpham() {
        return masanpham;
    }

    public void setMasanpham(int masanpham) {
        this.masanpham = masanpham;
    }

    public DanhMucSanPham getDanhmucsanpham() {
        return danhmucsanpham;
    }

    public void setDanhmucsanpham(DanhMucSanPham danhmucsanpham) {
        this.danhmucsanpham = danhmucsanpham;
    }

    public String getTensanpham() {
        return tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        this.tensanpham = tensanpham;
    }

    public Integer getGiatien() {
        return giatien;
    }

    public void setGiatien(Integer giatien) {
        this.giatien = giatien;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }


    public String AvatarForHomePage(){
        // lay ra ten cua anh? co ten trung voi tên nhập váo
        String namePictureNeedGet="";
        Integer max=0;
        //lay san pham co so luong nhieu nhat lam avatar
        for (ChiTietSanPham detail :this.chitietsanpham) {
            if (detail.getSoluong ()>max){
                max = detail.getSoluong ();
            }
        }
        for (ChiTietSanPham detail :this.chitietsanpham) {
            if (detail.getSoluong ()==max){
                namePictureNeedGet=detail.getHinhsanpham ();
            }
        }
        return namePictureNeedGet;
    }
}
