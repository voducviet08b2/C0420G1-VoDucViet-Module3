use furama_project;
insert into TrinhDo(trinh_do)
values 
('Trung Cấp'),
('Cao Đẳng'),
('Đại Học'),
('Sau Đại Học');

insert into ViTri(ten_vi_tri)
values 
('Lễ Tân'),
('Phục Vụ'),
('Chuyên Viên'),
('Giám sát'),
('Quản lý'),
('Giám Đốc');

insert into BoPhan(ten_bo_phan)
values 
('Sale-Marketing'),
('Hành chính'),
('Phục Vụ'),
('Quản Lý');

insert into LoaiKhach(ten_loai_khach)
values 
('Diamond'),
('Platinum'),
('Gold'),
('Silver'),
('Member');

insert into KieuThue(ten_kieu_thue,gia)
values 
('Thuê theo Năm',50000000),
('Thuê theo Tháng',5000000),
('Thuê theo ngày',500000),
('Thuê theo Giờ',50000);

insert into LoaiDichVu(ten_loai_dich_vu)
values 
('Villa'),
('House'),
('Room');

insert into NhanVien(ho_ten,ngay_sinh,so_cmnd,luong,sdt,email,dia_chi,id_vi_tri,id_trinh_do,id_bo_phan)
values
("Cao Ba Quat",12/3/2004,"3435345121",12000000,"2123453412","quat@gmail.com","Da Nang",1,2,1),
("Nong Dan",11/3/1990,"3435321",120000,"21453412","dam@gmail.com","Ha Noi",2,2,1),
("Dam ba long",1/3/2001,"3435121",2000000,"21234512","q@gmail.com","Hoi An",1,1,1),
("Phuc Long",12/3/1990,"3435121",12000,"21232","dghchdt@gmail.com","Da Nong",1,2,2),
("Tuong long",12/3/1998,"343345121",1200000,"23453412","mop@gmail.com","long",1,2,1);

insert into NhanVien(ho_ten,ngay_sinh,so_cmnd,luong,sdt,email,dia_chi,id_vi_tri,id_trinh_do,id_bo_phan)
values
("Huc Long",date '1990-12-02',"3435121",12000,"21232","dghchdt@gmail.com","Da Nong",1,2,2),
("Khuc Long",date '1990-12-02',"3435121",12000,"21232","dghchdt@gmail.com","Da Nong",1,2,2);

insert into KhachHang(ho_ten,ngay_sinh,so_cmnd,sdt,email,dia_chi,id_loai_khach)
values
("huc ",date '1990-12-12',"34355121","2123453412","quat@gmail.com","Da Nang",1),
("Phan Khai",date '1990-12-12',"34355121","2123453412","quat@gmail.com","Quang Tri",2);

insert into KhachHang(ho_ten,ngay_sinh,so_cmnd,sdt,email,dia_chi,id_loai_khach)
values
("huc loing",date '1996-12-12',"34355121","2123453412","quat@gmail.com","Da Nang",1),
("Phan Van Khai",date '2000-12-12',"34355121","2123453412","quat@gmail.com","Quang Tri",2),
("Nguyen Phu Trong",date '1990-12-12',"34355121","2123453412","quat@gmail.com","Thanh Hoa",2);

insert into KhachHang(ho_ten,ngay_sinh,so_cmnd,sdt,email,dia_chi,id_loai_khach)
values
("Rong troi",date '1992-12-12',"34355121","2123453412","quat@gmail.com","My",1),
("Captain america",date '2010-12-12',"34355121","2123453412","quat@gmail.com","Long Vuong",2),
("Spider man",date '1990-12-12',"34355121","2123453412","quat@gmail.com","Da Lat",2);

INSERT INTO `furama_project`.`dichvu` (`ten_dich_vu`, `dien_tich`, `so_tang`, `so_nguoi_toi_da`, `chi_phi_thue`, `trang_thai`, `id_kieu_thue`, `id_loai_dich_vu`) 
VALUES 
('house 1', '300', '2', '5', '2000000', 'Avaliable', '1', '1'),
('room 1', '100', '1', '12', '2000000', 'Avaliable', '1', '1'),
('villa 2', '700', '5', '2', '2000000', 'Avaliable', '1', '1')
;

INSERT INTO `furama_project`.`hopdong` (`ngay_lam_hop_dong`, `ngay_ket_thuc`, `tien_dat_coc`, `tong_tien`, `id_nhan_vien`, `id_khach_hang`, `id_dich_vu`)
 VALUES 
 ('2020-12-12', '2020-12-18', '500000', '5000000', '1', '2', '2'),
 ('2020-3-12', '2020-3-18', '600000', '6000000', '1', '2', '2'),
 ('2020-4-12', '2020-4-18', '300000', '3000000', '2', '1', '3'),
 ('2020-2-12', '2020-2-18', '200000', '2000000', '3', '1', '2')
 ;

INSERT INTO `furama_project`.`dichvudikem` (`ten_dich_vu_di_kem`, `gia`, `don_vi`, `trang_thai_kha_dung`)
 VALUES
 ('Massage', '50000', '5', 'avaliable'),
 ('Beer', '60000', '4', 'avaliable'),
 ('tennis', '50000', '3', 'avaliable'),
 ('golf', '50000', '2', 'avaliable')
 ;

INSERT INTO `furama_project`.`hopdong` (`ngay_lam_hop_dong`, `ngay_ket_thuc`, `tien_dat_coc`, `tong_tien`, `id_nhan_vien`, `id_khach_hang`, `id_dich_vu`) VALUES ('2018-01-12', '2018-02-12', '400000', '5000000', '1', '7', '2');
INSERT INTO `furama_project`.`hopdong` (`ngay_lam_hop_dong`, `ngay_ket_thuc`, `tien_dat_coc`, `tong_tien`, `id_nhan_vien`, `id_khach_hang`, `id_dich_vu`) VALUES ('2018-02-12', '2018-03-12', '400000', '5000000', '1', '8', '2');
INSERT INTO `furama_project`.`hopdong` (`ngay_lam_hop_dong`, `ngay_ket_thuc`, `tien_dat_coc`, `tong_tien`, `id_nhan_vien`, `id_khach_hang`, `id_dich_vu`) VALUES ('2018-03-12', '2018-04-12', '400000', '5000000', '1', '9', '1');


INSERT INTO `furama_project`.`hopdongchitiet` (`id_hop_dong`, `id_dich_vu_di_kem`, `so_luong`) VALUES ('1', '1', '5');
INSERT INTO `furama_project`.`hopdongchitiet` (`id_hop_dong`, `id_dich_vu_di_kem`, `so_luong`) VALUES ('2', '3', '2');
INSERT INTO `furama_project`.`hopdongchitiet` (`id_hop_dong`, `id_dich_vu_di_kem`, `so_luong`) VALUES ('3', '2', '3');
INSERT INTO `furama_project`.`hopdongchitiet` (`id_hop_dong`, `id_dich_vu_di_kem`, `so_luong`) VALUES ('1', '2', '3');