
Use QL_DIEMSV
go
-- Tao Bang Mon Hoc --
Create Table MonHoc
 (
   MaMH char(5) primary key,
   TenMH nvarchar(30) not null,
   SoTinChi int not null check ( (SoTinChi>0)and (SoTinChi<20) )
 )
 GO
--- Tao Bang He Dao Tao ---
Create Table HeDT
 (
   MaHeDT char(5) primary key,
   TenHeDT nvarchar(40) not null
 )
 GO

--- Tao Bang Khoa Hoc ---
Create Table KhoaHoc
 (
   MaKhoaHoc char(5) primary key,
   TenKhoaHoc nvarchar(20) not null
 )
 GO
--- Tao Bang Khoa --
Create Table Khoa
 (
   MaKhoa char(5) primary key,
   TenKhoa nvarchar(30) not null,
   DiaChi nvarchar(100) not null,
   DienThoai varchar(20) not null
 )
 GO
-- Tao Bang Lop ---
Create Table Lop
 (
   MaLop char(5) primary key,
   TenLop nvarchar(30) not null,
   MaKhoa char(5) foreign key references Khoa (MaKhoa),
   MaHeDT char(5) foreign key references HeDT (MaHeDT),
   MaKhoaHoc char(5) foreign key references KhoaHoc (MaKhoaHoc),
 )
 GO
--- Tao Bang Sinh Vien ---
Create Table SinhVien
 (
   MaSV char(15) primary key,
   TenSV nvarchar(20) ,
   GioiTinh bit ,
   NgaySinh datetime ,
   QueQuan nvarchar(50) ,
   MaLop char(5) foreign key references Lop(MaLop),
 )
 GO
--- Tao Bang Diem ---
Create Table Diem
 (
   MaSV char(15) foreign key references SinhVien(MaSV),
   MaMH char(5) foreign key references MonHoc (MaMH),
   HocKy int check(HocKy>0) not null,
   DiemLan1 int ,
   DiemLan2 int
)
GO

---Nhap Du Lieu Cho Bang He Dao Tao --
insert into HeDT values('ĐHCQ',N'Ðại Học')
insert into HeDT values('ĐTCĐ',N'Cao Ðẳng')

  Select * from HeDT
  GO

-- Nhap Du Lieu Bang Ma Khoa Hoc ---
insert into KhoaHoc values('D17',N'Ðại học khóa 2017')
insert into KhoaHoc values('D18',N'Ðại học khóa 2018')
insert into KhoaHoc values('D19',N'Ðại học khóa 2019')
insert into KhoaHoc values('D16',N'Ðại học khóa 2016')
insert into KhoaHoc values('D15',N'Ðại học khóa 2015')
insert into KhoaHoc values('D14',N'Ðại học khóa 2014')

  Select * from KhoaHoc
  GO

-- Nhap Du Lieu bang Khoa --
insert into Khoa values('CNTT',N'Công nghệ thông tin',N'Tầng 4 nhà B','043768888')

insert into Khoa values('DT',N'Ðiện tử',N'Tằng 6 nhà B','043768888')
insert into Khoa values('KT',N'Kinh Tế',N'Tầng 2 nhà C','043768888')

  Select * from Khoa
  GO
--- Nhap Du Lieu Cho Bang Lop --
insert into Lop values('CN03',N'D18CQCN03','CNTT','ĐHCQ','D18')
insert into Lop values('CN01',N'D18CQCN01','CNTT','ĐHCQ','D18')
insert into Lop values('CN02',N'D17CQCN02','CNTT','ĐHCQ','D17')
insert into Lop values('CN04',N'D15CQCN04','CNTT','ĐHCQ','D15')
insert into Lop values('KT01',N'D16CQKT01','KT','ĐHCQ','D16')

 select * from Lop
 GO
-- Nhap Du Lieu Bang Sinh Vien --
insert into SinhVien values('0241060218',N'Nguyễn Minh Một',1,'08/27/1999','Hải Dýõng','CN04')
insert into SinhVien values('0241060318',N'Nguyễn Minh Hai',1,'2/08/1999','Nam Dinh','CN04')
insert into SinhVien values('0241060818',N'Nguyễn Minh Bảy',1,'7/08/1999','Ha Noi','CN01')


select * from SinhVien
GO
-- Nhap Du Lieu Bang Mon Hoc --
insert into MonHoc values('SQL','SQL',5)
insert into MonHoc values('JV','Java',6)
insert into MonHoc values('CNPM','Công Nghệ phần mềm',4)
insert into MonHoc values('PTHT','Phân tích hệ thống',4)
insert into MonHoc values('Mang','Mạng máy tính',5)

  select * from MonHoc
  GO
-- Nhap Du Lieu Bang Diem --
insert into Diem(MaSV,MaMH,HocKy,DiemLan1) values('0241060218','SQL',5,7)
insert into Diem(MaSV,MaMH,HocKy,DiemLan1) values('0241060818','SQL',5,6)
insert into Diem(MaSV,MaMH,HocKy,DiemLan1) values('0241060318','CNPM',5,8)

insert into Diem values('0241060218','Mang',5,4,5)
insert into Diem values('0241060218','JV',5,4,4)
insert into Diem values('0241060818','JV',5,4,6)
insert into Diem values('0241060218','PTHT',4,2,5)
insert into Diem(MaSV,MaMH,HocKy,DiemLan1) values('0241060318','SQL',4,9)
insert into Diem(MaSV,MaMH,HocKy,DiemLan1) values('0241060218','SQL',4,8)
insert into Diem values('0241060318','Mang',5,3,4)
insert into Diem values('0241060818','Mang',5,4,4)
insert into Diem(MaSV,MaMH,HocKy,DiemLan1) values('0241060318','Mang',5,8)

  select * from Diem
  GO
  --12. CAC THAO TAC DU LIEU VOI CAC BANG
    -- 12.1 BANG SINH VIEN
       --A. THEM DU LIEU
          create PROCEDURE sp_insSINHVIEN
          (
          @MASV char(15),
          @TENSV nvarchar(20),
          @GIOITINH bit,
          @NGAYSINH DATETIME,
          @QueQuan nvarchar(50),
          @MALOP char(5)
          )
          AS
          BEGIN
          insert into SINHVIEN
          (
             MASV,
             TENSV,
             GIOITINH,
           NGAYSINH,
             QueQuan,
             MALOP
          )
           values (@MASV,@TENSV,@GIOITINH,@NGAYSINH,@QUEQUAN,@MALOP)
         END
	GO
          --TEST
              sp_insSINHVIEN '0241061298','BANG KIEU',1,'5/5/1997','HA NOI','CN01'
              SELECT * FROM SINHVIEN
GO
  --B. XOA DU LIEU
          create procedure sp_delSINHVIEN
          @MASV char(15)
          as
            delete from SINHVIEN
            where MASV=@MASV
   
             -- TEST
			 GO
              sp_delSINHVIEN '0241060218'
              select * from sinhvien

			  GO
      --C. HIEN THI DU LIEU
          create proc sp_showSINHVIEN
          as
            select * from SINHVIEN
  
              --TEST
                 sp_showSINHVIEN
   
      --D. SUA DU LIEU
	  GO
          create procedure sp_updateSINHVIEN
          (
           @MASV char(15),
           @TENSV nvarchar(20),
           @GIOITINH bit,
           @NGAYSINH DATETIME,
           @QUEQUAN nvarchar(50),
           @MALOP char(5)
          )
          as

          update SINHVIEN
            set  
               MASV=@MASV,
               TENSV=@TENSV,
           GIOITINH=@GIOITINH,
               NGAYSINH=@NGAYSINH,
               QUEQUAN=@QUEQUAN,
               MALOP=@MALOP
             where MASV=@MASV
         --- KIEM TRA
		 GO
         sp_updateSINHVIEN '0241060218','BANG KIEU',1,'5/5/1987','HA NOI','MT3'
         select * from SINHVIEN

		 -- 12.2 BANG LOP
     --A. THEM DU LIEU
	 GO
          create PROCEDURE sp_insLOP
          (
          @MALOP char(5),
          @TENLOP nvarchar(30),
          @MAKHOA CHAR(5),
          @MaHeDT CHAR(5),
          @MaKhoaHoc CHAR(5)
          )
          AS
          BEGIN
          insert into LOP
          (
             MALOP,
             TENLOP,
             MAKHOA,
           MaHeDT,
             MaKhoaHoc
             )
     
         values (@MALOP,@TENLOP,@MAKHOA,@MaHeDT,@MaKhoaHoc)
         END

          --TEST
        GO
           sp_insLOP 'KT04','D17CQKT04','KT','ĐHCQ','D17'
           select * from lop
		GO
		--B. XOA DU LIEU
          create procedure sp_delLOP
          @MALOP char(5)
          as
            delete from LOP
            where MALOP=@MALOP
          -- TEST
		  GO
            sp_delLOP 'KT04'
			--C. HIEN THI DU LIEU
			GO
          create proc sp_showLOP
          as
            select * from LOP

     
       --D. SUA DU LIEU
	   GO
          create procedure sp_updateLOP
          (
           @MALOP char(5),
           @TENLOP nvarchar(30),
           @MAKHOA CHAR(5),
           @MaHeDT CHAR(5),
           @MaKhoaHoc CHAR(5)
          )
          as

          update LOP
            set  
               MALOP=@MALOP,
               TENLOP=@TENLOP,
           MAKHOA=@MAKHOA,
               MaHeDT=@MaHeDT,
               MaKhoaHoc=@MaKhoaHoc
             where MALOP=@MALOP
			 GO

			 -- 12.3 BANG MON HOC
    
      --A. THEM DU LIEU
          create PROCEDURE sp_insMONHOC
          (
          @MaMH char(5),
          @TenMH nvarchar(30),
          @SoTrinh INT
          )
          AS
          BEGIN
          insert into MONHOC
          (
             MAMH,
             TENMH,
             SOTRINH
           )
     
         values (@MAMH,@TENMH,@SOTRINH)
         END
      --B. XOA DU LIEU
	  GO
          create procedure sp_delMONHOC
          @MAMH char(5)
          as
            delete from MonHoc
            where MAMH=@MAMH
 
       --C. HIEN THI DU LIEU
	   GO
          create proc sp_showMONHOC
          as
            select * from MONHOC

     
       --D. SUA DU LIEU
	   GO
          create procedure sp_updateMONHOC
          (
           @MaMH char(5),
           @TenMH nvarchar(30),
           @SoTrinh INT
          )
          as

          update MONHOC
            set  
               MAMH=@MAMH,
               TENMH=@TENMH,
           SOTRINH=@SOTRINH
             where MAMH=@MAMH
			 GO
			 --- 12.4 BANG KHOA HOC
     --A. THEM DU LIEU
          create PROCEDURE sp_insKHOAHOC
          (
           @MaKhoaHoc char(5),
           @TenKhoaHoc nvarchar(20)
          )
          AS
          BEGIN
          insert into KHOAHOC
          (
             MaKhoaHoc,
             TenKhoaHoc
             )
     
         values (@MaKhoaHoc,@TenKhoaHoc)
         END
  
      --B. XOA DU LIEU
	  GO
          create procedure sp_delKHOAHOC
          @MaKhoaHoc char(5)
          as
            delete from KHOAHOC
            where MaKhoaHoc=@MaKhoaHoc
 
       --C. HIEN THI DU LIEU
	   GO
          create proc sp_showKHOAHOC
          as
            select * from KHOAHOC

     
       --D. SUA DU LIEU
	   GO
          create procedure sp_updateKHOAHOC
          (
            @MaKhoaHoc char(5),
            @TenKhoaHoc nvarchar(20)
          )
          as

          update KHOAHOC
            set  
               MaKhoaHoc=@MaKhoaHoc,
               TenKhoaHoc=@TenKhoaHoc
            where MaKhoaHoc=@MaKhoaHoc


			--- 12.5 BANG KHOA
     --A. THEM DU LIEU
	 GO
          create PROCEDURE sp_insKHOA
          (
            @MaKhoa char(5),
            @TenKhoa nvarchar(30),
            @DiaChi nvarchar(100),
            @DienThoai varchar(20)
          )
          AS
          BEGIN
          insert into KHOA
          (
             MaKhoa,
             TenKhoa,
             DiaChi,
           DienThoai
            )
     
         values (@MaKhoa,@TenKhoa,@DiaChi,@DienThoai)
         END
      --B. XOA DU LIEU
	  GO
          create procedure sp_delKHOA
          @MAKHOA char(5)
          as
            delete from KHOA
            where MAKHOA=@MAKHOA
 
       --C. HIEN THI DU LIEU
	   GO
          create proc sp_showKHOA
          as
            select * from KHOA

     
       --D. SUA DU LIEU
	   GO
         create procedure sp_updateKHOA
          (
            @MaKhoa char(5),
            @TenKhoa nvarchar(30),
            @DiaChi nvarchar(100),
            @DienThoai varchar(20)
          )
          as

          update KHOA
            set  
               MaKhoa=@MaKhoa,
               TenKhoa=@TenKhoa,
           DiaChi=@DiaChi,
               DienThoai=@DienThoai
             where MaKhoa=@MaKhoa
			 -- 12.7 BANG DIEM
      --A. THEM DU LIEU
	  GO
         create PROCEDURE sp_insDIEM
          (
          @MaSV char(15),
          @MaMH CHAR(5),
          @HocKy INT,
          @DiemLan1 INT,
          @DiemLan2 INT
          )
          AS
          BEGIN
          insert into DIEM
          (
             MASV,
             MAMH,
             HOCKY,
           DIEMLAN1,
             DIEmLAN2
             )
     
         values (@MaSV,@MaMH,@HocKy,@DiemLan1,@DiemLan2)
         END
      --B. XOA DU LIEU
	  GO
          create procedure sp_delDIEM
          @MASV char(15)
          as
            delete from DIEM
            where MASV=@MASV
 
       --C. HIEN THI DU LIEU
	   GO
          create proc sp_showDIEM
          as
            select * from DIEM

     
       --D. SUA DU LIEU
	   GO
          create procedure sp_updateDIEM
          (
           @MaSV char(15),
           @MaMH CHAR(5),
           @HocKy INT,
           @DiemLan1 INT,
           @DiemLan2 INT
          )
          as

          update DIEM
            set  
               MaSV=@MaSV,
               MaMH=@MaMH,
           HocKy=@HocKy,
               DiemLan1=@DiemLan1,
               DiemLan2=@DiemLan2
             where MaSV=@MaSV



