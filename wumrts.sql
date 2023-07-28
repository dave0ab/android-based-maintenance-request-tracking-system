-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 28, 2023 at 06:33 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `wumrts`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `id` int(100) NOT NULL,
  `wuid` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `role` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `token` varchar(100) NOT NULL,
  `tokenExpire` varchar(100) NOT NULL,
  `status` varchar(100) NOT NULL,
  `dateCreated` varchar(100) NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`id`, `wuid`, `password`, `role`, `email`, `token`, `tokenExpire`, `status`, `dateCreated`) VALUES
(1, 'wdu12', '81dc9bdb52d04dc20036dbd8313ed055', 'client', 'yimertesfaye21@gmail.com', '1c6dnuaxlk', '2023-05-22 17:06:46', 'Allowed', '2023-05-22'),
(2, 'mm', '81dc9bdb52d04dc20036dbd8313ed055', 'Maintenance Manager', 'dave0ab@gmail.com', '', '2023-05-24 16:34:36', 'Allowed', '2023-05-22'),
(5, 'fa', '81dc9bdb52d04dc20036dbd8313ed055', 'Facility Manager', 'dawit7ghiwot28@gmail.com', 'bao6ugk85m', '2023-05-22 17:05:21', 'Allowed', '2023-05-22'),
(8, 'tech1', '81dc9bdb52d04dc20036dbd8313ed055', 'Technician', '', 'lc51uaresd', '2023-05-24 16:12:28', 'Allowed', '2023-05-22'),
(18, 'tech', '81dc9bdb52d04dc20036dbd8313ed055', 'Technician', '', 'lc51uaresd', '2023-05-24 16:12:28', 'Allowed', '2023-05-22'),
(66, 'wdu1200619', '25d55ad283aa400af464c76d713c07ad', 'client', 'dave000ab@gmail.com ', '', '', 'Allowed', '2023-06-01 09:33:14'),
(67, 'wdu1202268', '25d55ad283aa400af464c76d713c07ad', 'client', 'zewdutafes21@gmail.com', '', '', 'Allowed', '2023-06-01 09:36:37'),
(68, 'wdu1200498', '25d55ad283aa400af464c76d713c07ad', 'client', 'birhanegetachew106@gmail.com', '', '', 'Allowed', '2023-06-01 09:37:11'),
(69, 'WDU1204641', '25d55ad283aa400af464c76d713c07ad', 'client', 'helariseyfu@gmail.com', '', '', 'Allowed', '2023-06-01 09:40:12'),
(70, 'wdu111917', '5e8667a439c68f5145dd2fcbecf02209', 'client', 'habtamuabe14@gmail.com', '', '', 'Allowed', '2023-06-01 09:41:05'),
(71, 'fawdu111917', '5e8667a439c68f5145dd2fcbecf02209', 'Facility Manager', 'habtamuabe@gmail.com', '', '', 'Allowed', '2023-06-01 09:54:15'),
(72, 'fawdu1200498', '25d55ad283aa400af464c76d713c07ad', 'Facility Manager', 'birhanegetachew210@gmail.com', '', '', 'Allowed', '2023-06-01 09:54:29'),
(73, 'fawdu1204641', '81dc9bdb52d04dc20036dbd8313ed055', 'Facility Manager', 'helariseyfu5@gmail.com', '', '', 'Allowed', '2023-06-01 09:54:52'),
(74, 'fawdu1202268', '25d55ad283aa400af464c76d713c07ad', 'Facility Manager', 'zewdutafes@gmail.com', '', '', 'Allowed', '2023-06-01 09:55:29'),
(75, 'tawdu1202268', '25d55ad283aa400af464c76d713c07ad', 'Technician', 'zewdutafess21@gmail.com', '', '', 'Allowed', '2023-06-01 09:57:27'),
(76, 'tewdu111917', '5e8667a439c68f5145dd2fcbecf02209', 'Technician', 'habtamu@gmail.com', '', '', 'Allowed', '2023-06-01 09:57:38'),
(77, 'tewdu1204641', '01cbdbd8211e80fb3f35a844f4f77fb5', 'Technician', 'helariseyfu6@gmail.com', '', '', 'Allowed', '2023-06-01 09:57:41'),
(78, 'tewdu1200498', '25d55ad283aa400af464c76d713c07ad', 'Technician', 'birhanegetachew097@gmail.com', '', '', 'Allowed', '2023-06-01 09:58:21'),
(79, 'facwdu1202268', '25d55ad283aa400af464c76d713c07ad', 'Facility Manager', 'zewdutafe21@gmail.com', '', '', 'Allowed', '2023-06-02 09:53:56'),
(80, 'cotewdu111917', '5e8667a439c68f5145dd2fcbecf02209', 'Technician', 'habtam@gmail.com', '', '', 'Allowed', '2023-06-02 09:55:51');

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(100) NOT NULL,
  `fname` varchar(100) NOT NULL,
  `lname` varchar(100) NOT NULL,
  `wuid` varchar(100) NOT NULL,
  `sex` varchar(100) NOT NULL,
  `phone` varchar(100) NOT NULL,
  `imagepath` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `fname`, `lname`, `wuid`, `sex`, `phone`, `imagepath`) VALUES
(6, 'dawit', '', 'mm', '', '0', 'http://192.168.43.228:80//wumrts/admin/upload1/4fYXjR5GUiao9DnF.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `backup`
--

CREATE TABLE `backup` (
  `id` int(110) NOT NULL,
  `backupname` varchar(110) NOT NULL,
  `backuppath` varchar(110) NOT NULL,
  `datecreated` varchar(100) NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `backup`
--

INSERT INTO `backup` (`id`, `backupname`, `backuppath`, `datecreated`) VALUES
(10, 'wumrts-2023-06-03-18-36-02', 'C:/xampp/htdocs/wumrts/admin/backup/wumrts-2023-06-03-18-36-02.sql', ''),
(11, 'wumrts-2023-06-03-18-37-23', 'C:/xampp/htdocs/wumrts/admin/backup/wumrts-2023-06-03-18-37-23.sql', ''),
(12, 'wumrts-2023-06-03-18-37-41', 'C:/xampp/htdocs/wumrts/admin/backup/wumrts-2023-06-03-18-37-41.sql', ''),
(13, 'wumrts-2023-06-03-18-37-59', 'http://192.168.43.228:80//wumrts/admin/backup/wumrts-2023-06-03-18-37-59.sql', ''),
(14, 'wumrts-2023-06-03-21-13-55', 'http://192.168.43.228:80//wumrts/admin/backup/wumrts-2023-06-03-21-13-55.sql', ''),
(15, 'wumrts-2023-06-08-15-00-59', 'C:/xampp/htdocs/wumrts/admin/backup/wumrts-2023-06-08-15-00-58.sql', ''),
(16, 'wumrts-2023-06-08-15-01-05', 'C:/xampp/htdocs/wumrts/admin/backup/wumrts-2023-06-08-15-01-05.sql', ''),
(17, 'wumrts-2023-06-08-15-02-00', 'C:/xampp/htdocs/wumrts/admin/backup/wumrts-2023-06-08-15-02-00.sql', ''),
(18, 'wumrts-2023-06-08-15-20-14', 'C:/xampp/htdocs/wumrts/admin/backup/wumrts-2023-06-08-15-20-14.sql', ''),
(19, 'wumrts-2023-06-08-15-21-53', 'C:/xampp/htdocs/wumrts/admin/backup/wumrts-2023-06-08-15-21-53.sql', ''),
(20, 'wumrts-2023-06-08-15-22-10', 'C:/xampp/htdocs/wumrts/admin/backup/wumrts-2023-06-08-15-22-09.sql', '');

-- --------------------------------------------------------

--
-- Table structure for table `directorates`
--

CREATE TABLE `directorates` (
  `id` int(100) NOT NULL,
  `did` varchar(100) NOT NULL,
  `dname` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `directorates`
--

INSERT INTO `directorates` (`id`, `did`, `dname`) VALUES
(1, 'ictd101', 'Ict Directoret'),
(2, 'constd101', 'Construction Directoret'),
(3, 'dormd101', 'Dormitory Directoret');

-- --------------------------------------------------------

--
-- Table structure for table `facility_manager`
--

CREATE TABLE `facility_manager` (
  `id` int(100) NOT NULL,
  `fname` varchar(100) NOT NULL,
  `lname` varchar(100) NOT NULL,
  `wuid` varchar(100) NOT NULL,
  `sex` varchar(100) NOT NULL,
  `phone` varchar(100) NOT NULL,
  `imagepath` varchar(100) NOT NULL,
  `directoret` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `facility_manager`
--

INSERT INTO `facility_manager` (`id`, `fname`, `lname`, `wuid`, `sex`, `phone`, `imagepath`, `directoret`) VALUES
(31, 'birhane', '', 'fa', '', '2147483647', 'http://192.168.43.228:80//wumrts/facility_manager/upload1/RDif0EaPTk6m6fG2.jpg', 'ictd101'),
(40, 'Habtamu', 'Abebaw', 'fawdu111917', 'Male', '2147483647', 'http://192.168.43.228:80//wumrts/facility_manager/upload1/BFndd2d1bHAxM5s8.jpg', 'ictd101'),
(41, 'birhane', 'getachew ', 'fawdu1200498', 'Female', '2147483647', 'http://192.168.43.228:80//wumrts/facility_manager/upload1/epnsnyZXZH4N1PkN.jpg', 'dormd101'),
(42, 'helari', 'seyfu', 'fawdu1204641', 'Female', '2147483647', 'http://192.168.43.228:80//wumrts/facility_manager/upload1/XOGYUC1oW8PBhDI7.jpg', 'constd101'),
(43, 'Zewdu', 'Tafes', 'fawdu1202268', 'Male', '2147483647', 'http://192.168.43.228:80//wumrts/facility_manager/upload1/Yvm6EsrwZQNSMvUj.jpg', 'ictd101'),
(44, 'Zewdu', 'Tafes', 'facwdu1202268', 'Male', '2147483647', 'http://192.168.43.228:80//wumrts/facility_manager/upload1/3PtODK6uB48gk8eG.jpg', 'constd101'),
(48, 'dawa', 'jsjsn', 'wse', 'Male', '2147483647', 'http://192.168.43.228:80//wumrts/facility_manager/upload1/koS1Etk6Ik01tLb6.jpg', 'dormd101');

-- --------------------------------------------------------

--
-- Table structure for table `inventory`
--

CREATE TABLE `inventory` (
  `id` int(100) NOT NULL,
  `wuid` varchar(100) NOT NULL,
  `device` varchar(100) NOT NULL,
  `serial_no` varchar(100) NOT NULL,
  `qr_data` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `inventory`
--

INSERT INTO `inventory` (`id`, `wuid`, `device`, `serial_no`, `qr_data`) VALUES
(8, '﻿wd', 'wd', 'wd', 'wd'),
(9, 'wdu12', 'laptop', 'qr1234', 'abc123');

-- --------------------------------------------------------

--
-- Table structure for table `log`
--

CREATE TABLE `log` (
  `id` int(100) NOT NULL,
  `wuid` varchar(100) NOT NULL,
  `logdata` varchar(1000) NOT NULL,
  `datecreated` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `log`
--

INSERT INTO `log` (`id`, `wuid`, `logdata`, `datecreated`) VALUES
(1, 'mm', 'username=mm backedup the database', ''),
(2, 'mm', 'username=mm backedup the database', ''),
(3, 'mm', 'username=mm logged in to the system ', ''),
(4, 'mm', 'username=mm backedup the database', ''),
(5, 'mm', 'username=mm logged in to the system ', ''),
(6, 'mm', 'username=mm backedup the database', ''),
(7, 'mm', 'username=mm backedup the database', ''),
(8, 'mm', 'username=mm backedup the database', ''),
(9, 'mm', 'username=mm restored the database', ''),
(10, 'wdu12', 'username=wdu12 logged in to the system ', ''),
(11, 'mm', 'username=mm restored the database', ''),
(12, 'mm', 'username=mm inserted inventory data ', ''),
(13, 'mm', 'username=mm inserted inventory data ', ''),
(14, 'mm', 'username=mm inserted inventory data ', ''),
(15, 'mm', 'username=mm inserted inventory data ', ''),
(16, 'mm', 'username=mm inserted inventory data ', ''),
(17, 'mm', 'username=mm inserted inventory data ', ''),
(18, 'mm', 'username=mm inserted inventory data ', ''),
(19, 'mm', 'username=mm inserted inventory data ', ''),
(20, 'mm', 'username=mm inserted inventory data ', ''),
(21, 'wdu12', 'username=wdu12 logged in to the system ', ''),
(22, 'wdu12', 'username=wdu12 = Requested for ICT maintenances = g vdh  0920743743 dawitictd101  Desktop Ict Directoret', ''),
(23, 'wdu12', 'username=wdu12 = Requested for ICT maintenances = hh b bb b 0920743743 dawitictd101  Desktop Ict Directoret', ''),
(24, 'wdu12', 'username=wdu12 = Requested for ICT maintenances = yxyd fvg fyyd 0920743743 dawitictd101  Desktop Ict Directoret', ''),
(25, 'wdu12', 'username=wdu12 = Requested for ICT maintenances =    0920743743 dawitictd101 hbbnbb Desktop Ict Directoret', ''),
(26, 'wdu12', 'username=wdu12 = Requested for ICT maintenances = hdj bb 123 0920743743 dawitictd101  Desktop Ict Directoret', ''),
(27, 'wdu12', 'username=wdu12 logged in to the system ', ''),
(28, 'wdu12', 'username=wdu12 = Requested for ICT maintenances = thanks ed  fcc 0920743743 dawitictd101  Laptop Ict Directoret', ''),
(29, 'wdu12', 'username=wdu12 = Requested for ICT maintenances = xff   0920743743 dawitictd101 eerr Desktop Ict Directoret', ''),
(30, 'wdu12', 'username=wdu12 = Requested for ICT maintenances = th   0920743743 dawitictd101  Desktop Ict Directoret', ''),
(31, 'wdu12', 'username=wdu12 = Requested for ICT maintenances = ff  ed 0920743743 dawitictd101  Desktop Ict Directoret', ''),
(32, 'wdu12', 'username=wdu12 = Requested for ICT maintenances = sdd  qr1234 0920743743 dawitictd101  Desktop Ict Directoret', ''),
(33, 'fa', 'username=fa logged in to the system ', ''),
(34, 'fa', 'username=fa logged in to the system ', ''),
(35, 'fa', 'username=fa = Assigned technician for the request = 272  assigned technician =tech', ''),
(36, 'tech', 'username=tech logged in to the system ', ''),
(37, 'tech', 'username=tech logged in to the system ', ''),
(38, 'fa', 'username=fa logged in to the system ', ''),
(39, 'fa', 'username=fa logged in to the system ', ''),
(40, 'mm', 'username=mm logged in to the system ', ''),
(41, 'wdu12', 'username=wdu12 logged in to the system ', ''),
(42, 'fa', 'username=fa logged in to the system ', ''),
(43, 'tech', 'username=tech logged in to the system ', ''),
(44, 'fawdu1200498', 'username=fawdu1200498 logged in to the system ', ''),
(45, 'fawdu1202268', 'username=fawdu1202268 logged in to the system ', ''),
(46, 'facwdu1202268', 'username=facwdu1202268 logged in to the system ', ''),
(47, 'tech', 'username=tech logged in to the system ', ''),
(48, 'fa', 'username=fa logged in to the system ', ''),
(49, 'fa', 'username=fa = Assigned technician for the request = 271  assigned technician =tewdu111917', ''),
(50, 'fa', 'username=fa = Assigned technician for the request = 270  assigned technician =tech', ''),
(51, 'fa', 'username=fa = Assigned technician for the request = 269  assigned technician =tawdu1202268', ''),
(52, 'tech', 'username=tech logged in to the system ', ''),
(53, 'tech', 'username=tech logged in to the system ', '');

-- --------------------------------------------------------

--
-- Table structure for table `reports`
--

CREATE TABLE `reports` (
  `id` int(100) NOT NULL,
  `request_id` varchar(100) NOT NULL,
  `tech_wuid` varchar(100) NOT NULL,
  `sender_wuid` varchar(100) NOT NULL,
  `message` varchar(100) NOT NULL,
  `directorate` varchar(100) NOT NULL,
  `document_path` varchar(100) NOT NULL,
  `reported_date` date NOT NULL DEFAULT current_timestamp(),
  `status` varchar(100) NOT NULL,
  `reassign_status` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `reports`
--

INSERT INTO `reports` (`id`, `request_id`, `tech_wuid`, `sender_wuid`, `message`, `directorate`, `document_path`, `reported_date`, `status`, `reassign_status`) VALUES
(60, '258', '', 'WDU1204641', 'hdhdhdhdh', 'constd101', 'http://192.168.43.228:80//wumrts/technician/upload/2023006002010019.docx', '2023-06-02', 'not seen', 'Reassigned'),
(61, '258', 'cotewdu111917', '', 'i maintained the window', 'constd101', 'http://192.168.43.228:80//wumrts/technician/upload/2023006002010019.docx', '2023-06-02', 'not seen', 'Reassigned'),
(62, '260', 'cotewdu111917', '', 'done', 'constd101', 'http://192.168.43.228:80//wumrts/technician/upload/2023006002013025.docx', '2023-06-02', 'not seen', 'Reassigned'),
(63, '260', '', 'WDU1204641', 'not finished', 'constd101', 'http://192.168.43.228:80//wumrts/technician/upload/2023006002013027.docx', '2023-06-02', 'not seen', 'Reassigned'),
(64, '260', 'cotewdu111917', '', 'i have done already', 'constd101', 'http://192.168.43.228:80//wumrts/technician/upload/2023006002013029.docx', '2023-06-02', 'not seen', 'Not Reassigned');

-- --------------------------------------------------------

--
-- Table structure for table `requests`
--

CREATE TABLE `requests` (
  `id` int(100) NOT NULL,
  `sender_wuid` varchar(1000) NOT NULL,
  `name` varchar(1000) NOT NULL,
  `buildingno` varchar(1000) NOT NULL,
  `officeno` varchar(1000) NOT NULL,
  `phone` varchar(1000) NOT NULL,
  `quantity` varchar(100) NOT NULL,
  `checkboxrequests` longtext NOT NULL,
  `facility_manager_id` varchar(100) NOT NULL,
  `additionalmessage` varchar(1000) NOT NULL,
  `imagepath` varchar(1000) NOT NULL,
  `thing_to_fix` varchar(100) NOT NULL,
  `directoret` varchar(100) NOT NULL,
  `technician` varchar(1000) NOT NULL,
  `techname` varchar(100) NOT NULL,
  `techphone` varchar(100) NOT NULL,
  `task_status` varchar(100) NOT NULL,
  `assigned_time` time NOT NULL,
  `assigned_date` varchar(100) NOT NULL,
  `requested_date` varchar(100) NOT NULL,
  `document_path` varchar(100) NOT NULL,
  `report_status` varchar(100) NOT NULL,
  `report_status_client` varchar(100) NOT NULL,
  `fa_phone` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `requests`
--

INSERT INTO `requests` (`id`, `sender_wuid`, `name`, `buildingno`, `officeno`, `phone`, `quantity`, `checkboxrequests`, `facility_manager_id`, `additionalmessage`, `imagepath`, `thing_to_fix`, `directoret`, `technician`, `techname`, `techphone`, `task_status`, `assigned_time`, `assigned_date`, `requested_date`, `document_path`, `report_status`, `report_status_client`, `fa_phone`) VALUES
(255, 'wdu1200498', 'birhane', '60', '23', '+251901744117', '1', ' \n INSTALLING POWER GEEZ \n INSTALLING DIFFERENT SOFTWARE \n  \n  \n ', '', 'tolo yiseralgni ', 'http://192.168.43.228:80//wumrts/request/upload/xYPYhEtCYFxwAYrj.jpg', 'Laptop', 'ictd101', 'tawdu1202268', 'Zewdu', '+251955328432', 'Assigned', '00:00:00', '23/06/04', '2023-06-02', '', 'not reported', 'not reported', ''),
(256, 'WDU1204641', 'helari', '56', '6', '+251928371065', '', '', '', 'ydyydy', '', 'Construction', 'constd101', 'Not Assigned', 'Not Assigned', 'Not Assigned', 'Not Assigned', '00:00:00', '', '2023-06-02', 'http://192.168.43.228:80//wumrts/request_sender/upload_construction_files/2023006002010008.docx', 'not reported', 'not reported', ''),
(257, 'wdu1200498', 'birhane', '40', '233', '+251901744117', '1', 'DESKTOP HARDWARE MAINTENANCE \n  \n  \n  \n  \n ', '', 'aschekay tolo yisrulgni', 'http://192.168.43.228:80//wumrts/request/upload/9uRmJI7gP6gCqLHS.jpg', 'Desktop', 'ictd101', 'Not Assigned', 'Not Assigned', 'Not Assigned', 'Not Assigned', '00:00:00', '', '2023-06-02', '', 'not reported', 'not reported', ''),
(258, 'WDU1204641', 'helari', '66', '66', '+251928371065', '', '', '', 'hdjdjjdjr', '', 'Construction', 'constd101', 'cotewdu111917', 'Habtamu', '+251919857064', 'Reassigned', '00:00:00', '23/06/02', '2023-06-02', 'http://192.168.43.228:80//wumrts/request_sender/upload_construction_files/2023006002010016.docx', 'reported', 'reported', ''),
(259, 'wdu1200498', 'birhane', '46', '024', '+251901744117', '1', 'PRINTER HARDWARE MAINTENANCE \n INSTALLING PRINTER SOFTWARE \n  \n  \n  \n ', '', 'tolo yiseralgni ', 'http://192.168.43.228:80//wumrts/request/upload/qs9oe1RtLAh2KxnG.jpg', 'Printer', 'ictd101', 'tewdu111917', 'Habtamu', '+251919857064', 'Assigned', '00:00:00', '23/06/02', '2023-06-02', '', 'not reported', 'not reported', ''),
(260, 'WDU1204641', 'helari', '65', '76', '+251928371065', '', '', '', 'hshshshshshsh', '', 'Construction', 'constd101', 'cotewdu111917', 'Habtamu', '+251919857064', 'Completed', '00:00:00', '23/06/02', '2023-06-02', 'http://192.168.43.228:80//wumrts/request_sender/upload_construction_files/2023006002013020.docx', 'reported', 'reported', ''),
(261, 'wdu1200498', 'birhane', '40', '356', '+251901744117', '1', 'LAPTOP HARDWARE MAINTENANCE \n  \n INSTALLING DIFFERENT SOFTWARE \n  \n  \n ', '', 'sfghjkjj', 'http://192.168.43.228:80//wumrts/request/upload/WKps0boCzn5wHkn8.jpg', 'Laptop', 'ictd101', 'Not Assigned', 'Not Assigned', 'Not Assigned', 'Not Assigned', '00:00:00', '', '2023-06-03', '', 'not reported', 'not reported', ''),
(262, 'wdu12', 'dawit', 'green', '7', '0920743743', '', '', '', 'ebakachu afetenut', '', 'Construction', 'constd101', 'Not Assigned', 'Not Assigned', 'Not Assigned', 'Not Assigned', '00:00:00', '', '2023-06-04', 'http://192.168.43.228:80//wumrts/request_sender/upload_construction_files/2023006002021031.docx', 'not reported', 'not reported', ''),
(263, 'wdu12', 'dawit', 'g', 'vdh', '0920743743', '', ' \n  \n  \n  \n  \n ', '', '', 'http://192.168.43.228:80//wumrts/request/upload/AZUKFbxtHrjeaAOq.jpg', 'Desktop', 'ictd101', 'Not Assigned', 'Not Assigned', 'Not Assigned', 'Not Assigned', '00:00:00', '', '2023-06-15', '', 'not reported', 'not reported', ''),
(264, 'wdu12', 'dawit', 'hh b', 'bb', '0920743743', '9', ' \n  \n  \n  \n  \n ', '', '', 'http://192.168.43.228:80//wumrts/request/upload/Zo1Uwg5dmnkHGx2Z.jpg', 'Desktop', 'ictd101', 'Not Assigned', 'Not Assigned', 'Not Assigned', 'Not Assigned', '00:00:00', '', '2023-06-15', '', 'not reported', 'not reported', ''),
(265, 'wdu12', 'dawit', 'yxyd', 'fvg', '0920743743', '56', ' \n  \n  \n  \n  \n ', '', '', 'http://192.168.43.228:80//wumrts/request/upload/8Bm868Ln3udVCbaE.jpg', 'Desktop', 'ictd101', 'Not Assigned', 'Not Assigned', 'Not Assigned', 'Not Assigned', '00:00:00', '', '2023-06-15', '', 'not reported', 'not reported', ''),
(266, 'wdu12', 'dawit', '', '', '0920743743', '', ' \n INSTALLING POWER GEEZ \n INSTALLING DIFFERENT SOFTWARE \n  \n  \n ', '', 'hbbnbb', 'http://192.168.43.228:80//wumrts/request/upload/4sTXdWCQZku1QYA8.jpg', 'Desktop', 'ictd101', 'Not Assigned', 'Not Assigned', 'Not Assigned', 'Not Assigned', '00:00:00', '', '2023-06-15', '', 'not reported', 'not reported', ''),
(267, 'wdu12', 'dawit', 'hdj', 'bb', '0920743743', '99', ' \n  \n  \n  \n  \n ', '', '', 'http://192.168.43.228:80//wumrts/request/upload/uQLeDBLdtjA15eam.jpg', 'Desktop', 'ictd101', 'Not Assigned', 'Not Assigned', 'Not Assigned', 'Not Assigned', '00:00:00', '', '2023-06-15', '', 'not reported', 'not reported', ''),
(268, 'wdu12', 'dawit', 'thanks ed', '', '0920743743', '', ' \n  \n  \n  \n  \n ', '', '', 'http://192.168.43.228:80//wumrts/request/upload/fWWzPu9yJk48r5r5.jpg', 'Laptop', 'ictd101', 'Not Assigned', 'Not Assigned', 'Not Assigned', 'Not Assigned', '00:00:00', '', '2023-06-15', '', 'not reported', 'not reported', ''),
(269, 'wdu12', 'dawit', 'xff', '', '0920743743', '', ' \n  \n  \n  \n INSTALLING MS-OFFICE \n ', 'fa', 'eerr', 'http://192.168.43.228:80//wumrts/request/upload/IpUIdnN1y3KY5dHB.jpg', 'Desktop', 'ictd101', 'tawdu1202268', 'Zewdu', '+251955328432', 'Assigned', '00:00:00', '23/06/17', '2023-06-15', '', 'not reported', 'not reported', '2147483647'),
(270, 'wdu12', 'dawit', 'th', '', '0920743743', '', ' \n  \n  \n  \n  \n ', 'fa', '', 'http://192.168.43.228:80//wumrts/request/upload/T5s2SQiZXm5yknYn.jpg', 'Desktop', 'ictd101', 'tech', 'dawa', '6888', 'Assigned', '00:00:00', '23/06/22', '2023-06-15', '', 'not reported', 'not reported', ''),
(271, 'wdu12', 'dawit', 'ff', '', '0920743743', '', ' \n  \n  \n  \n  \n ', 'fa', '', 'http://192.168.43.228:80//wumrts/request/upload/YcWzz6cbZAltS3Hp.jpg', 'Desktop', 'ictd101', 'tewdu111917', 'Habtamu', '+251919857064', 'Assigned', '00:00:00', '23/06/22', '2023-06-15', '', 'not reported', 'not reported', ''),
(272, 'wdu12', 'dawit', 'sdd', '', '0920743743', '', ' \n INSTALLING POWER GEEZ \n  \n  \n  \n ', 'fa', '', 'http://192.168.43.228:80//wumrts/request/upload/HLqB1QZqYn4iBnn3.jpg', 'Desktop', 'ictd101', 'tech', 'dawa', '6888', 'Assigned', '00:00:00', '23/06/17', '2023-06-15', '', 'not reported', 'not reported', '');

-- --------------------------------------------------------

--
-- Table structure for table `request_sender`
--

CREATE TABLE `request_sender` (
  `id` int(100) NOT NULL,
  `fname` varchar(100) NOT NULL,
  `lname` varchar(100) NOT NULL,
  `wuid` varchar(100) NOT NULL,
  `phone` varchar(100) NOT NULL,
  `sex` varchar(100) NOT NULL,
  `imagepath` varchar(100) NOT NULL,
  `wuidimage` varchar(100) NOT NULL,
  `job_title` varchar(100) NOT NULL,
  `date` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `request_sender`
--

INSERT INTO `request_sender` (`id`, `fname`, `lname`, `wuid`, `phone`, `sex`, `imagepath`, `wuidimage`, `job_title`, `date`) VALUES
(77, 'dawit', 'gebrehiwot', 'wdu12', '0920743743', 'Male', 'http://192.168.43.228:80//wumrts/request_sender/upload1/djoTbyEMFTPPJCHA.jpg', 'http://192.168.43.228:80//wumrts/request_sender/upload1/PrhRB5CIlHVC6qqZ.jpg', 'Proctor', '2023-03-16'),
(119, 'Dawit', 'Gebrehiwot ', 'wdu1200619', '+251920743743', 'Male', 'http://192.168.43.228:80//wumrts/request_sender/upload/J5htnNibO8wQQTzH.jpg', 'http://192.168.43.228:80//wumrts/request_sender/upload1/cWUmJXXjDmtNf0NK.jpg', 'Teacher', '2023-06-01'),
(120, 'Zewdu', 'Tafes', 'wdu1202268', '+251955328432', 'Male', 'http://192.168.43.228:80//wumrts/request_sender/upload/hdgGzMSOLabFgOK4.jpg', 'http://192.168.43.228:80//wumrts/request_sender/upload1/8okN7TPEw1bLNmMi.jpg', 'Communication center', '2023-06-01'),
(121, 'birhane', 'getachew', 'wdu1200498', '+251901744117', 'Female', 'http://192.168.43.228:80//wumrts/request_sender/upload/oQ7sn4YwfiEs8J1s.jpg', 'http://192.168.43.228:80//wumrts/request_sender/upload1/SCD9BLGMX6VW372U.jpg', 'Administrator office', '2023-06-01'),
(122, 'helari', 'seyfu', 'WDU1204641', '+251928371065', 'Female', 'http://192.168.43.228:80//wumrts/request_sender/upload/doZaDieuwUSwT484.jpg', 'http://192.168.43.228:80//wumrts/request_sender/upload1/IVlXXwK0tpC3OaCk.jpg', 'Dormitory', '2023-06-01'),
(123, 'Habtamu', ' Abebaw', 'wdu111917', '+251919857064', 'Male', 'http://192.168.43.228:80//wumrts/request_sender/upload/gui6n8wUsw0LUYu6.jpg', 'http://192.168.43.228:80//wumrts/request_sender/upload1/LpAmYW8y1hyzq5ek.jpg', 'Lecturer', '2023-06-01'),
(133, 'dawa', 'jsjjs', 'dave12', '+251920764661', 'Male', 'http://192.168.43.228:80//wumrts/request_sender/upload/Z0g2avOjwGtZvdUR.jpg', 'http://192.168.43.228:80//wumrts/request_sender/upload1/2kRCztOwbwVVFexd.jpg', 'Lecturer', '2023-06-03'),
(134, 'dawa', 'jsjjs', 'davffe12', '+251920764661', 'Male', 'http://192.168.43.228:80//wumrts/request_sender/upload/EJ2WSagzvAxrf84o.jpg', 'http://192.168.43.228:80//wumrts/request_sender/upload1/tNPY5A8kR1jBrD8w.jpg', 'Lecturer', '2023-06-03');

-- --------------------------------------------------------

--
-- Table structure for table `technician`
--

CREATE TABLE `technician` (
  `id` int(100) NOT NULL,
  `fname` varchar(100) NOT NULL,
  `lname` varchar(100) NOT NULL,
  `wuid` varchar(100) NOT NULL,
  `sex` varchar(100) NOT NULL,
  `phone` varchar(100) NOT NULL,
  `imagepath` varchar(100) NOT NULL,
  `directoret` varchar(100) NOT NULL,
  `ongoingJobs` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `technician`
--

INSERT INTO `technician` (`id`, `fname`, `lname`, `wuid`, `sex`, `phone`, `imagepath`, `directoret`, `ongoingJobs`) VALUES
(13, 'dawa', 'tt', 'tech1', 'Male', '09877564', 'http://192.168.43.228:80//wumrts/maintenance_manager/profilepicture/Qj22xd0AaueAG1Tp.jpg', 'ictd101', 4),
(14, 'dawa', '12&-', 'tech', 'Male', '6888', 'http://192.168.43.228:80//wumrts/technician/upload1/cluwWYV8e5TeU4cl.jpg', 'ictd101', 4),
(15, 'Zewdu', 'Tafes', 'tawdu1202268', 'Male', '+251955328432', 'http://192.168.43.228:80//wumrts/technician/upload1/TIpwt0gXWCBqYfUr.jpg', 'ictd101', 4),
(16, 'Habtamu', 'Abebaw', 'tewdu111917', 'Male', '+251919857064', 'http://192.168.43.228:80//wumrts/technician/upload1/Itd1SjUZNi5tDyNc.jpg', 'ictd101', 8),
(17, 'helari', 'seyfu', 'tewdu1204641', 'Female', '+251928371065', 'http://192.168.43.228:80//wumrts/technician/upload1/Xz6cKjlzsvy2Zjf1.jpg', 'constd101', 1),
(18, 'birhane', 'getachew ', 'tewdu1200498', 'Female', '+251901744117', 'http://192.168.43.228:80//wumrts/technician/upload1/6OPcbj8Q6sv0DRmD.jpg', 'dormd101', 11),
(19, 'Habtamu', 'Abebaw', 'cotewdu111917', 'Male', '+251919857064', 'http://192.168.43.228:80//wumrts/technician/upload1/uhdZrvUCVHkcRE5e.jpg', 'constd101', 4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `wuid` (`wuid`);

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `wuid` (`wuid`);

--
-- Indexes for table `backup`
--
ALTER TABLE `backup`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `directorates`
--
ALTER TABLE `directorates`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `facility_manager`
--
ALTER TABLE `facility_manager`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `wuid` (`wuid`);

--
-- Indexes for table `inventory`
--
ALTER TABLE `inventory`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `serial_no` (`serial_no`),
  ADD UNIQUE KEY `qr_data` (`qr_data`);

--
-- Indexes for table `log`
--
ALTER TABLE `log`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `reports`
--
ALTER TABLE `reports`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `requests`
--
ALTER TABLE `requests`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `request_sender`
--
ALTER TABLE `request_sender`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`wuid`);

--
-- Indexes for table `technician`
--
ALTER TABLE `technician`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `wuid` (`wuid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=97;

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `backup`
--
ALTER TABLE `backup`
  MODIFY `id` int(110) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `directorates`
--
ALTER TABLE `directorates`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `facility_manager`
--
ALTER TABLE `facility_manager`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT for table `inventory`
--
ALTER TABLE `inventory`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `log`
--
ALTER TABLE `log`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;

--
-- AUTO_INCREMENT for table `reports`
--
ALTER TABLE `reports`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=65;

--
-- AUTO_INCREMENT for table `requests`
--
ALTER TABLE `requests`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=273;

--
-- AUTO_INCREMENT for table `request_sender`
--
ALTER TABLE `request_sender`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=135;

--
-- AUTO_INCREMENT for table `technician`
--
ALTER TABLE `technician`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
