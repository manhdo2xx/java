create database quanlycuahangsach

use quanlycuahangsach


create table books (
	book_id int auto_increment primary key,
	name nvarchar(255) not null,
	loaisach nvarchar(255),
	tacgia_id int,
	nhaxuatban_id int,
	namxuatban date,
	soluong int,
	giatien double
)

create table tacgia (
	tacgia_id int auto_increment primary key,
	name nvarchar(255) not null
)

create table loaisach (
	loaisach nvarchar(255) primary key not null
)

create table nhaxuatban (
	nhaxuatban_id int auto_increment primary key,
	nhaxuatban nvarchar(255) not null
)

create table khachhang (
	khachhang_id int  auto_increment primary key,
	name nvarchar(255) not null,
	namsinh datetime,
	sdt varchar(10),
	diachi nvarchar(255)
)

create table hoadon (
	hoadon_id int auto_increment primary key,
	khachhang_id int,
	ngaylap datetime,
	tongtien double
)

create table chitiethoadon (
	hoadon_id int not null,
	book_id int,
	soluong int,
	thanhtien double
)

-- thêm khoá ngoại

alter table chitiethoadon add constraint FK_CHITIETHOADON_HOADON foreign key (hoadon_id) references hoadon(hoadon_id)
alter table chitiethoadon add constraint FK_CHITIETHOADON_SACH foreign key (book_id) references books(book_id)
alter table hoadon add constraint FK_HOADON_KHACHHANG foreign key (khachhang_id) references khachhang(khachhang_id)
alter table books add constraint FK_SACH_LOAISACH foreign key (loaisach) references loaisach(loaisach)
alter table books add constraint FK_SACH_TACGIA foreign key (tacgia_id) references tacgia(tacgia_id)
alter table books add constraint FK_SACH_NHAXUATBAN foreign key (nhaxuatban_id) references nhaxuatban(nhaxuatban_id)



