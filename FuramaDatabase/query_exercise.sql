use furama_project;
-- Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.

select *
from NhanVien
where (ho_ten like 'H%' or ho_ten like 'K%' or ho_ten like 'T%') and length(ho_ten)<15;

-- Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.

select *,(year(curdate())-year(ngay_sinh)) as age
from khachhang
having (dia_chi='Da Nang' OR dia_chi='Quang Tri') and age<=50 and age>=18;

-- ⦁	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.

select k.ho_ten,count(h.id_khach_hang) as so_lan_dat_phong
from hopdong h
inner join khachhang k on h.id_khach_hang=k.id
where k.id_loai_khach=1
group by k.ho_ten
Order By so_lan_dat_phong desc;

-- ⦁	Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien (Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem) cho tất cả các Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).

select k.id,k.ho_ten, l.ten_loai_khach,h.id as id_hop_dong,d.ten_dich_vu,h.ngay_lam_hop_dong,h.ngay_ket_thuc
from khachhang k
left join hopdong h on k.id=h.id_khach_hang
inner join loaikhach l on k.id_loai_khach=l.id
 left join dichvu d on h.id_dich_vu=d.id;