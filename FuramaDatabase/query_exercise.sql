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

select k.id,k.ho_ten, l.ten_loai_khach,h.id as id_hop_dong,d.ten_dich_vu,h.ngay_lam_hop_dong,h.ngay_ket_thuc,(CAST(d.chi_phi_thue as unsigned)*dvdk.don_vi*dvdk.gia) as TongTien
from khachhang k
left join hopdong h on k.id=h.id_khach_hang
inner join loaikhach l on k.id_loai_khach=l.id
 left join dichvu d on h.id_dich_vu=d.id
 left join hopdongchitiet hdct on hdct.id_hop_dong=h.id
 left join dichvudikem dvdk on dvdk.id=hdct.id_dich_vu_di_kem;
 
 -- ⦁	Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các loại Dịch vụ chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).
 
select *
 from dichvu d
 inner join loaidichvu l on d.id_loai_dich_vu=l.id
where d.id not in (
 select d.id
 from dichvu d
 inner join loaidichvu l on d.id_loai_dich_vu=l.id
inner join hopdong h on d.id=h.id_dich_vu
where year(h.ngay_lam_hop_dong)=2019 and (month(h.ngay_lam_hop_dong)=1 or month(h.ngay_lam_hop_dong)=2 or month(h.ngay_lam_hop_dong)=3)
);
 
 -- ⦁	Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018 nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019.
select d.id,ten_dich_vu,dien_tich,so_nguoi_toi_da,chi_phi_thue,ten_loai_dich_vu
from dichvu d
 inner join loaidichvu l on d.id_loai_dich_vu=l.id
inner join hopdong h on d.id=h.id_dich_vu
inner join khachhang k on h.id_khach_hang=k.id
where year(h.ngay_lam_hop_dong)=2018;

-- Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau. Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên
select distinct ho_ten
from khachhang;

select distinct ho_ten
from khachhang
UNION
select distinct ho_ten
from khachhang;

select ho_ten
from khachhang
UNION
select ho_ten
from khachhang;

-- Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2019 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.

select month(ngay_lam_hop_dong) as thang,count(id_khach_hang) as 'Số lượt khách đặt', sum(tong_tien) as "Doanh thu tháng"
from hopdong
where year(ngay_lam_hop_dong)=2019
group by thang
order by thang;

-- Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem (được tính dựa trên việc count các IDHopDongChiTiet).

select h.id,ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc,count(hdct.id) as 'Số lượng dịch vụ đi kèm'
from hopdong h
inner join hopdongchitiet hdct on hdct.id_hop_dong=h.id 
inner join dichvudikem dvdk on hdct.id_dich_vu_di_kem=dvdk.id 
group by h.id;

-- 	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có TenLoaiKhachHang là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.

select dvdk.ten_dich_vu_di_kem 
from khachhang k
inner join hopdong h on h.id_khach_hang=k.id 
inner join hopdongchitiet hdct on hdct.id_hop_dong=h.id
inner join dichvudikem dvdk on hdct.id_dich_vu_di_kem=dvdk.id 
where (k.dia_chi="vinh" or k.dia_chi="quang ngai") and k.id_loai_khach=1;

-- ⦁	Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem (được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2019 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019.

create view ba_thang_cuoi
as
select h.id,n.ho_ten as Ho_ten_Nhan_vien,k.ho_ten as ho_ten_khach_hang,k.sdt,d.ten_dich_vu,hdct.so_luong,h.ngay_lam_hop_dong
from hopdong h
inner join hopdongchitiet hdct on h.id=hdct.id_hop_dong
inner join khachhang k on k.id=h.id_khach_hang 
inner join nhanvien n on n.id=h.id_nhan_vien 
inner join dichvu d on h.id_dich_vu=d.id
where year(h.ngay_lam_hop_dong)=2019 and(month(h.ngay_lam_hop_dong)=10 
or month(h.ngay_lam_hop_dong)=11 or month(h.ngay_lam_hop_dong)=12); 

create view sau_thang_dau
as
select h.id,n.ho_ten as Ho_ten_Nhan_vien,k.ho_ten as ho_ten_khach_hang,k.sdt,d.ten_dich_vu,hdct.so_luong,h.ngay_lam_hop_dong
from hopdong h
inner join hopdongchitiet hdct on h.id=hdct.id_hop_dong
inner join khachhang k on k.id=h.id_khach_hang 
inner join nhanvien n on n.id=h.id_nhan_vien 
inner join dichvu d on h.id_dich_vu=d.id
where h.id not in(
select h.id
from hopdong h
inner join hopdongchitiet hdct on h.id=hdct.id_hop_dong
inner join khachhang k on k.id=h.id_khach_hang 
inner join nhanvien n on n.id=h.id_nhan_vien 
inner join dichvu d on h.id_dich_vu=d.id
where year(h.ngay_lam_hop_dong)=2019 and (month(h.ngay_lam_hop_dong)=1 
or month(h.ngay_lam_hop_dong)=2 or month(h.ngay_lam_hop_dong)=3 or month(h.ngay_lam_hop_dong)=4 or month(h.ngay_lam_hop_dong)=5 or month(h.ngay_lam_hop_dong)=6)
);

select *
from ba_thang_cuoi b
join sau_thang_dau s where b.id=s.id;

-- Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).

select dvdk.id,ten_dich_vu_di_kem,count(k.id) as So_lan_su_dung
from dichvudikem dvdk
join hopdongchitiet hdct on dvdk.id=hdct.id_dich_vu_di_kem  
join hopdong h on h.id=hdct.id_hop_dong
join khachhang k on k.id=h.id_khach_hang 
group by dvdk.id;

-- Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.

select h.id,dvdk.id,ten_dich_vu_di_kem,ldv.ten_loai_dich_vu,dvdk.ten_dich_vu_di_kem,count(h.id_khach_hang) as so_lan_su_dung
from dichvudikem dvdk
join hopdongchitiet hdct on dvdk.id=hdct.id_dich_vu_di_kem  
join hopdong h on h.id=hdct.id_hop_dong
join dichvu d on d.id=h.id_dich_vu
join loaidichvu ldv on ldv.id=d.id_loai_dich_vu
group by dvdk.id
having so_lan_su_dung<=1;

-- 	Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai, DiaChi mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.

select ho_ten,n.id,sdt,dia_chi,t.trinh_do,vt.ten_vi_tri,count(h.id_nhan_vien) as sohopdong
from nhanvien n
inner join hopdong h on n.id=h.id_nhan_vien
inner join trinhdo t on t.id=n.id_trinh_do
inner join vitri vt on vt.id=n.id_vi_tri
where year(h.ngay_lam_hop_dong) =2018 or year(h.ngay_lam_hop_dong) =2019
group by n.id
having sohopdong<=3;

-- Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.

delete from nhanvien
where id not in(
select id from(
select n.id 
from nhanvien n
join hopdong h on n.id=h.id_nhan_vien) as c);

-- Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond, chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ.

create view diamond
as
select k.id,k.ho_ten,h.tong_tien,k.id_loai_khach
from khachhang k
inner join hopdong h on k.id=h.id_khach_hang 
where year(ngay_lam_hop_dong)=2019 and tong_tien>=10000000;

update diamond
set id_loai_khach=1;

--  Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràng buộc giữa các bảng).

SET FOREIGN_KEY_CHECKS=0;
delete from khachhang,hopdong
using khachhang
inner join hopdong
on khachhang.id=hopdong.id_khach_hang 
where year(hopdong.ngay_lam_hop_dong)<2016;
SET FOREIGN_KEY_CHECKS=1;

-- Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi.

create view giagapdoi
as
select dvdk.id,ten_dich_vu_di_kem,count(id_dich_vu_di_kem) as So_luong_dich_vu,gia,year(h.ngay_lam_hop_dong) as nam_lam_hop_dong
from hopdong h
inner join hopdongchitiet hdct on h.id=hdct.id_hop_dong
inner join dichvudikem dvdk on hdct.id_dich_vu_di_kem=dvdk.id
 group by dvdk.id
 having nam_lam_hop_dong=2019 and So_luong_dich_vu>1;


update dichvudikem dvdk
inner join giagapdoi ggd on dvdk.id= ggd.id 
set dvdk.gia=dvdk.gia*2;




-- Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống, thông tin hiển thị bao gồm ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi.

select id,ho_ten,email,sdt,ngay_sinh,dia_chi
from nhanvien
union
select id,ho_ten,email,sdt,ngay_sinh,dia_chi
from khachhang