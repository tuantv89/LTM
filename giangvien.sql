-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 28, 2021 lúc 03:45 AM
-- Phiên bản máy phục vụ: 10.4.17-MariaDB
-- Phiên bản PHP: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `giangvien`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `giangvien`
--

CREATE TABLE `giangvien` (
  `id` int(20) NOT NULL,
  `hoten` varchar(50) NOT NULL,
  `sdt` varchar(50) NOT NULL,
  `bomon` varchar(50) NOT NULL,
  `khoa` varchar(50) NOT NULL,
  `diachi` varchar(50) NOT NULL,
  `hocham` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `giangvien`
--

INSERT INTO `giangvien` (`id`, `hoten`, `sdt`, `bomon`, `khoa`, `diachi`, `hocham`) VALUES
(1, 'Nguyen Manh Son', '012345678', 'Java OOP', 'CNTT-1', 'Ha Noi', 'Tien sy'),
(2, 'Nguyen Trong Khanh', '0123456789', 'Lap trinh mang', 'CNTT-1', 'Ha Noi', 'Giao su'),
(4, 'Hoang Xuan Dau', '1111111111', 'Co so ATTT', 'CNTT-1', 'Ha Noi', 'Giao su'),
(5, 'Nguyen Ngoc Diep', '6666666666', 'Quan li ATTT', 'CNTT-1', 'Ha Noi', 'Pho giao su');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `giangvien`
--
ALTER TABLE `giangvien`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `giangvien`
--
ALTER TABLE `giangvien`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
