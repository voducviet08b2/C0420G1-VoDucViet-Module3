create database furama_project;
use furama_project;

create table ViTri(
id int primary key auto_increment,
ten_vi_tri varchar(45) not null
);




create table user(
username varchar(255) primary key,
password varchar(255)
);

create table role(
id int primary key auto_increment,
role_name varchar(255)
);

create table user_role(
user_role_id int primary key auto_increment,
role_id int,
username varchar(255),
foreign key (role_id) references role(id),
foreign key (username) references user(username)
);


create table TrinhDo(
id int primary key auto_increment,
trinh_do varchar(45) not null
);

create table BoPhan(
id int primary key auto_increment,
ten_bo_phan varchar(45) not null
);

create table NhanVien(
id int primary key auto_increment,
ho_ten varchar(40) not null,
ngay_sinh date,
so_cmnd varchar(45),
luong varchar(15),
sdt varchar(15),
email varchar(30),
dia_chi varchar(100),
id_vi_tri int,
id_trinh_do int,
id_bo_phan int,
foreign key (id_vi_tri) references ViTri(id),
foreign key (id_trinh_do) references TrinhDo(id),
foreign key (id_bo_phan) references BoPhan(id)
);

create table LoaiDichVu(
id int primary key auto_increment,
ten_loai_dich_vu varchar(40) not null
);

create table KieuThue(
id int primary key auto_increment,
ten_kieu_thue varchar(40) not null,
gia int
);

create table DichVu(
id int primary key auto_increment,
ten_dich_vu varchar(40) not null,
dien_tich int,
so_tang int,
so_nguoi_toi_da varchar(15),
chi_phi_thue varchar(15),
trang_thai varchar(30),
id_kieu_thue int,
id_loai_dich_vu int,
foreign key (id_kieu_thue) references KieuThue(id),
foreign key (id_loai_dich_vu) references LoaiDichVu(id)
);

create table LoaiKhach(
id int primary key auto_increment,
ten_loai_khach varchar(40) not null
);

create table KhachHang(
id int primary key auto_increment,
ho_ten varchar(40) not null,
ngay_sinh date,
so_cmnd varchar(15),
sdt varchar(15),
email varchar(50),
dia_chi varchar(100),
id_loai_khach int,
foreign key (id_loai_khach) references LoaiKhach(id)
);

create table HopDong(
id int primary key auto_increment,
ngay_lam_hop_dong date,
ngay_ket_thuc date,
tien_dat_coc int,
tong_tien int,
id_nhan_vien int,
id_khach_hang int,
id_dich_vu int,
foreign key (id_nhan_vien) references NhanVien(id),
foreign key (id_khach_hang) references KhachHang(id),
foreign key (id_dich_vu) references DichVu(id)
);

create table DichVuDiKem(
id int primary key auto_increment,
ten_dich_vu_di_kem varchar(45),
gia int,
don_vi int,
trang_thai_kha_dung varchar(45)
);

create table HopDongChiTiet(
id int primary key auto_increment,
id_hop_dong int,
id_dich_vu_di_kem int,
so_luong int,
foreign key (id_hop_dong) references HopDong(id),
foreign key (id_dich_vu_di_kem) references DichVuDiKem(id)
);
