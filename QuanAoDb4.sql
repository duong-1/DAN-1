create database QuanAoDb4
go
use QuanAoDb4
go
CREATE TABLE [NguoiDung] (
  [NguoiDungId] nvarchar(100) PRIMARY KEY,
  [HoTen] nvarchar(100),
  [NgaySinh] datetime,
  [MatKhau] nvarchar(100),
  [Phone] nvarchar(100),
  GioiTinh bit,
  DiaChi nvarchar(100),
  Email nvarchar(100)
)
GO

CREATE TABLE [QuyenHan] (
  [NguoiDungId] nvarchar(100) unique,
  [TenQuyen] nvarchar(100)
)
GO

CREATE TABLE [SanPham] (
  [SanPhamId] int IDENTITY(1,1) PRIMARY KEY,
  --[SanPhamChiTietId] int,
  [PhanLoai] nvarchar(100),
  [TenSanPham] nvarchar(100),
  [created_at] datetime,
  [update_at] datetime
)
GO

create table SanPhamSanPhamChiTiet(
SanPhamSanPhamChiTietId int identity(1,1) primary key,
SanPhamId int,
SanPhamChiTietId int,
TrangThai bit
)
GO

CREATE TABLE [SanPhamChiTiet] (
  [Id] int IDENTITY(1,1) PRIMARY KEY,
	MauSacId int,
	ChatLieuId int,
	HangId int,
	KichThuocId int,
  MaVachSanPham nvarchar(100),
  [GiaTien] float,
  [SoLuong] int,
  [TrangThai] bit,
  [MoTaSoBo] nvarchar(100),
  [MoTaChiTiet] nvarchar(100),
  Anh nvarchar(100)
)
GO

Create Table SanPhamDonHang(
SanPhamSanPhamChiTietId int,
HoaDonId int,
  SoLuong int,
)
Go

CREATE TABLE [KhachHang] (
  [KhachHangId] int identity(1,1) PRIMARY KEY,
  [HoTen] nvarchar(100),
  [DiaChi] nvarchar(100),
  [SoDienThoai] nvarchar(100)
)
GO
--CREATE TABLE [DonHang] (
--  [DonHangId] int IDENTITY(1,1) PRIMARY KEY,
--  --[SanPhamId] int,
--  --DonGia float,
--  --SoLuong int,
--  --ThanhTien float,
--  [NguoiDungId] nvarchar(100),
--  [TrangThai] bit,
--  [created_at] datetime,
--  [update_at] datetime
--)
--GO

--CREATE TABLE [HoaDonChiTiet] (
--  [HoaDonId] nvarchar(100) unique,
--  [TenSanPham] nvarchar(100),
--  [GiaTien] float,
--  [SoLuong] int,
--  [TrangThai] bit
--)
--GO

CREATE TABLE [HoaDon] (
  [HoaDonId] int IDENTITY(1,1) PRIMARY KEY,
  --[DonHangId] int,
  [PhuongThucThanhToanId] nvarchar(100),
  [NguoiTao] nvarchar(100),
  KhuyenMaiId int,
  TenKhachHang nvarchar(100),
  [TongTien] float,
  TrangThai bit,
  TrangThaiHienThi bit,
  KhachHangId int,
  [created_at] datetime,
  [update_at] datetime
)
GO


CREATE TABLE [PhuongThucThanhToan] (
  [id] nvarchar(100) PRIMARY KEY,
  [TenPhuongThuc] nvarchar(100)
)
GO

--CREATE TABLE [Anh] (
--  [id] nvarchar(100) PRIMARY KEY,
--  [image] nvarchar(100)
--)
GO

--CREATE TABLE [ThuocTinhSanPham] (
--  [id] nvarchar(100) PRIMARY KEY,
--  [MauSac] nvarchar(100),
--  [KichThuoc] nvarchar(100),
--  [ChatLieu] nvarchar(100),
--  [Hang] nvarchar(100)
--)
--GO

create table ChatLieu(
ChatLieuId int identity(1,1) primary key,
TenChatLieu nvarchar(100)
)

create table KichThuoc(
KichThuocId int identity(1,1) primary key,
TenKichThuoc nvarchar(100)
)

create table Hang(
HangId int identity(1,1) primary key,
TenHang nvarchar(100)
)

create table MauSac(
MauSacId int identity(1,1) primary key,
TenMauSac nvarchar(100)
)

create table KhuyenMai(
KhuyenMaiId int identity(1,1) primary key,
TenChuongTrinhKhuyenMai nvarchar(100),
MaKhuyenMai nvarchar(100),
HinhThucGiamGia bit,
MucGiamGia nvarchar(100),
SoLuong int,
  ThoiGianBatDau datetime,
  ThoiGianKetThuc datetime
)

alter table QuyenHan add foreign key (NguoiDungId) references NguoiDung(NguoiDungId)
 --alter table SanPham add foreign key (SanPhamChiTietId) references SanPhamChiTiet(Id)
--alter table DonHang add foreign key (SanPhamId) references SanPham(SanPhamId)
alter table SanPhamDonHang add foreign key (SanPhamSanPhamChiTietId) references SanPhamSanPhamChiTiet(SanPhamSanPhamChiTietId)

alter table SanPhamSanPhamChiTiet add foreign key (SanPhamId) references SanPham(SanPhamId)

alter table SanPhamSanPhamChiTiet add foreign key (SanPhamChiTietId) references SanPhamChiTiet(Id)

--alter table SanPhamDonHang add foreign key (DonHangId) references DonHang(DonHangId)

--alter table SanPhamChiTiet add foreign key (ThuocTinhSanPhamId) references ThuocTinhSanPham(id) 

--alter table SanPhamChiTiet add foreign key (AnhId) references Anh(id)

alter table SanPhamChiTiet add foreign key (MauSacId) references MauSac(MauSacId)

alter table SanPhamChiTiet add foreign key (HangId) references Hang(HangId)

alter table SanPhamChiTiet add foreign key (KichThuocId) references KichThuoc(KichThuocId)

alter table SanPhamChiTiet add foreign key (ChatLieuId) references ChatLieu(ChatLieuId)

alter table HoaDon add foreign key (NguoiTao) references NguoiDung(NguoiDungId)

--alter table HoaDonChiTiet add foreign key (HoaDonId) references HoaDon(HoaDonId)

--alter table HoaDon add foreign key (DonHangId) references DonHang(DonHangId)
alter table SanPhamDonHang add foreign key (HoaDonId) references HoaDon(HoaDonId)

alter table HoaDon add foreign key (PhuongThucThanhToanId) references PhuongThucThanhToan(id)

--alter table KhachHang add foreign key (DonHangId) references DonHang(DonHangId)
alter table HoaDon add foreign key (KhachHangId) references KhachHang(KhachHangId)

alter table HoaDon add foreign key (KhuyenMaiId) references KhuyenMai(KhuyenMaiId)

alter table KhuyenMai add TrangThai bit

alter table KhachHang add Gmail nvarchar(100)

alter table KhachHang add SoLanMuaHang int

alter table KhachHang add TongGiaTriDaMua float

select * from ChatLieu

select * from SanPham

insert into KhuyenMai(MaKhuyenMai,TenChuongTrinhKhuyenMai,HinhThucGiamGia,MucGiamGia,SoLuong,ThoiGianBatDau,ThoiGianKetThuc,TrangThai) 
values (?,?,?,?,?,?,?,?)

insert into MauSac(TenMauSac) values (N'Màu Đỏ')

update MauSac set TenMauSac = N'Xanh' where MauSacId = 1

select * from KhuyenMai where MaKhuyenMai = ?

select * from SanPhamSanPhamChiTiet  inner join SanPham on SanPhamSanPhamChiTiet.SanPhamId = SanPham.SanPhamId
inner join SanPhamChiTiet on SanPhamChiTiet.id = SanPhamSanPhamChiTiet.SanPhamChiTietId
inner join MauSac on SanPhamChiTiet.MauSacId = MauSac.MauSacId
inner join KichThuoc on SanPhamChiTiet.KichThuocId = KichThuoc.KichThuocId
inner join ChatLieu on SanPhamChiTiet.ChatLieuId = ChatLieu.ChatLieuId
inner join Hang on SanPhamChiTiet.HangId = Hang.HangId where SanPhamSanPhamChiTiet.TrangThai = 1


select * from SanPhamDonHang
inner join SanPhamSanPhamChiTiet on SanPhamDonHang.SanPhamSanPhamChiTietId = SanPhamSanPhamChiTiet.SanPhamSanPhamChiTietId
inner join DonHang on DonHang.DonHangId = SanPhamDonHang.DonHangId
inner join SanPhamChiTiet on SanPhamSanPhamChiTiet.SanPhamChiTietId = SanPhamChiTiet.Id
inner join SanPham on SanPhamSanPhamChiTiet.SanPhamId = SanPham.SanPhamId
inner join MauSac on SanPhamChiTiet.MauSacId = MauSac.MauSacId
inner join KichThuoc on SanPhamChiTiet.KichThuocId = KichThuoc.KichThuocId
inner join ChatLieu on SanPhamChiTiet.ChatLieuId = ChatLieu.ChatLieuId
inner join Hang on SanPhamChiTiet.HangId = Hang.HangId where SanPhamDonHang.DonHangId = 1

select * from HoaDon



select * from SanPhamDonHang
inner join SanPhamSanPhamChiTiet on SanPhamDonHang.SanPhamSanPhamChiTietId = SanPhamSanPhamChiTiet.SanPhamSanPhamChiTietId
inner join HoaDon on HoaDon.HoaDonId = SanPhamDonHang.HoaDonId
inner join SanPhamChiTiet on SanPhamSanPhamChiTiet.SanPhamChiTietId = SanPhamChiTiet.Id
inner join SanPham on SanPhamSanPhamChiTiet.SanPhamId = SanPham.SanPhamId
inner join MauSac on SanPhamChiTiet.MauSacId = MauSac.MauSacId
inner join KichThuoc on SanPhamChiTiet.KichThuocId = KichThuoc.KichThuocId
inner join ChatLieu on SanPhamChiTiet.ChatLieuId = ChatLieu.ChatLieuId
inner join Hang on SanPhamChiTiet.HangId = Hang.HangId

