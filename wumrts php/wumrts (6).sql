-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 23, 2023 at 06:17 AM
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
  `dateCreated` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`id`, `wuid`, `password`, `role`, `email`, `token`, `tokenExpire`, `status`, `dateCreated`) VALUES
(1, 'wdu12', '81dc9bdb52d04dc20036dbd8313ed055', 'client', 'yimertesfaye21@gmail.com', '1c6dnuaxlk', '2023-05-22 17:06:46', 'Allowed', '2023-05-22'),
(2, 'mm', '81dc9bdb52d04dc20036dbd8313ed055', 'Maintenance Manager', 'dave0ab@gmail.com', 'ylg34cvefk', '2023-05-22 17:04:42', '', '2023-05-22'),
(5, 'fa', '81dc9bdb52d04dc20036dbd8313ed055', 'Facility Manager', 'dawitghiwot28@gmail.com', 'bao6ugk85m', '2023-05-22 17:05:21', '', '2023-05-22'),
(8, 'tech1', '81dc9bdb52d04dc20036dbd8313ed055', 'Technician', '', 'e5arm1z4ko', '2023-05-22 16:48:42', '', '2023-05-22'),
(12, 'sh182', '1234', 'client', '', 'e5arm1z4ko', '2023-05-22 16:48:42', '', '2023-05-22'),
(13, 'sh182dxj', '1234', 'client', '', 'e5arm1z4ko', '2023-05-22 16:48:42', '', '2023-05-22'),
(14, 'sh182dxjkgi', '1234', 'client', '', 'e5arm1z4ko', '2023-05-22 16:48:42', '', '2023-05-22'),
(15, 'sh182dxjkgig', '1234', 'client', '', 'e5arm1z4ko', '2023-05-22 16:48:42', '', '2023-05-22'),
(16, 'sh182vkdxjkgig', '1234', 'client', '', 'e5arm1z4ko', '2023-05-22 16:48:42', '', '2023-05-22'),
(17, 'dhb', ' bbnn', 'client', '', 'e5arm1z4ko', '2023-05-22 16:48:42', '', '2023-05-22'),
(18, 'tech', 'MTIzNA==', 'Technician', '', 'e5arm1z4ko', '2023-05-22 16:48:42', '', '2023-05-22'),
(21, 'mainmm', '1234 ', 'Facility Manager', '', 'e5arm1z4ko', '2023-05-22 16:48:42', '', '2023-05-22'),
(22, 'wdufa', '1234 ', 'Facility Manager', '', 'e5arm1z4ko', '2023-05-22 16:48:42', '', '2023-05-22'),
(23, 'tyrrgfg', 'dasdds', 'client', '', 'e5arm1z4ko', '2023-05-22 16:48:42', '', '2023-05-22'),
(29, 'ak2009-12/209', 'solomon@wumrts', 'client', 'solomonalebachew12@gmail.com', 'muxi2zgcbt', '2023-05-05 10:29:05', 'Allowed', '2023-05-22'),
(32, 'habtamuabe14@gmail.com', 'md0srjzf1b', 'client', 'habtamuabe14@gmail.com', '6bjoqgchtf', '2023-05-05 10:35:32', 'Allowed', '2023-05-22'),
(34, '1204641', '12345678', 'client', 'helariseyfu@gmail.com', '', '2023-04-06 09:40:23', 'Allowed', '2023-05-22'),
(35, 'WDU1200498', '12345678', 'client', 'birhanegetachew106@gmail.com', '', '2023-04-06 09:41:24', 'Allowed', '2023-05-22'),
(36, 'wdu', 'MTIzNA==', 'client', 'zewdutafes21@gmail.com', 'wlvi4m7h6u', '2023-04-06 09:59:09', 'Allowed', '2023-05-22'),
(37, 'eres5435456', '??', 'client', 'dtcfgvhb', '', '', 'Not Allowed', '2023-05-22'),
(38, 'eres543545gtyfg6', '??', 'client', 'dtcfgvhb', '', '', 'Not Allowed', '2023-05-22'),
(39, 'weeres543545gtyfg6', '??', 'client', 'dtcfgvhb', '', '', 'Not Allowed', '2023-05-22'),
(40, '3213123essad', 'MTIzNA==', 'client', 'csnmahjdasd', '', '', 'Not Allowed', '2023-05-22'),
(41, 'wdu11', 'MTIzNA==', 'client', 'habtamuabe14@gmail.com', '6bjoqgchtf', '2023-05-05 10:35:32', 'Allowed', '2023-05-22'),
(42, 'ወዩ/ 809011- አስ/15', 'c29sb21vbg==', 'client', 'solomonalebachew12@gmail.com', 'muxi2zgcbt', '2023-05-05 10:29:05', 'Not Allowed', '2023-05-22'),
(43, 'wu/8090/15', 'c29sb21vbg==', 'client', 'solomonalebachew12@gmail.com', '', '', 'Allowed', '2023-05-22');

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
  `phone` int(100) NOT NULL,
  `imagepath` varchar(100) NOT NULL,
  `directoret` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `facility_manager`
--

INSERT INTO `facility_manager` (`id`, `fname`, `lname`, `wuid`, `sex`, `phone`, `imagepath`, `directoret`) VALUES
(31, 'birhane', '', 'fa', '', 0, 'http://192.168.43.228//wumrts/maintenance_manager/profilepicture/9bpGXD637SvDfbwm.jpg', 'ictd101'),
(32, 'helari', '', 'wdu1204641', '', 0, '', ''),
(33, 'dawit', '', 'head', '', 9865643, '', ''),
(34, 'nahom', '', 'wdu10', '', 920743743, '', ''),
(35, 'dasd', 'dadas', 'dasd', 'Male', 388, 'http://192.168.43.228:80//wumrts/maintenance_manager/profilepicture/PKRV3XbJ7wnkxkKW.jpg', ''),
(36, 'dasd', 'dadas', 'dasdsdf', 'Male', 388, 'http://192.168.43.228:80//wumrts/maintenance_manager/profilepicture/16VwSd7laddORlMU.jpg', ''),
(37, 'dawit', 'gebre', 'wdufa', 'Male', 920743743, 'http://192.168.43.228//wumrts/maintenance_manager/profilepicture/9bpGXD637SvDfbwm.jpg', 'ictd101'),
(38, 'czc', 'sdad', 'mainmm', 'Male', 4234234, 'http://192.168.43.228:80//wumrts/maintenance_manager/profilepicture/IvW6LcUpPkRKTvst.jpg', 'constd101'),
(39, 'dfdsf', 'dfsdf', 'wdufacon', 'Male', 3454324, 'http://192.168.43.228:80//wumrts/maintenance_manager/profilepicture/qjFY4cYCjOwi8cST.jpg', 'dormd101');

-- --------------------------------------------------------

--
-- Table structure for table `log`
--

CREATE TABLE `log` (
  `id` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `maintenance_manager`
--

CREATE TABLE `maintenance_manager` (
  `id` int(100) NOT NULL,
  `fname` varchar(100) NOT NULL,
  `lname` varchar(100) NOT NULL,
  `wuid` varchar(100) NOT NULL,
  `sex` varchar(100) NOT NULL,
  `phone` int(100) NOT NULL,
  `imagepath` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `maintenance_manager`
--

INSERT INTO `maintenance_manager` (`id`, `fname`, `lname`, `wuid`, `sex`, `phone`, `imagepath`) VALUES
(6, 'dawit', '', 'mm', '', 0, 'http://192.168.43.228:80//wumrts/maintenance_manager/profilepicture/16VwSd7laddORlMU.jpg'),
(7, 'tfts', '', 'wdy778', '', 0, ''),
(8, 'QWDQWD', 'WDQDQWD', 'QWDQWD', 'Male', 98790, ''),
(9, 'sasa', 'acasca', 'ac13', 'Male', 880, 'http://192.168.43.228:80//wumrts/maintenance_manager/profilepicture/otxoh9JwgBqQTkbU.jpg'),
(15, 'dasd', 'dadas', 'dasd', 'Male', 388, 'http://192.168.43.228:80//wumrts/maintenance_manager/profilepicture/w4pR01OF3r21h5e2.jpg'),
(16, 'ew', 'sda', 'sadad', 'Male', 342423, 'http://192.168.43.228:80//wumrts/maintenance_manager/profilepicture/iWh2zR1C7F5B6Pak.jpg'),
(17, 'wda', 'dasdas', 'mainconst', 'Male', 334234, 'http://192.168.43.228:80//wumrts/maintenance_manager/profilepicture/6YfgHj5qHZcjdz2L.jpg'),
(19, 'dfdfsfdfdsfdfdfdfdf', 'vcvsfd', 'dfsrwer', 'Female', 624, 'http://192.168.43.228:80//wumrts/maintenance_manager/profilepicture/0oV7fDGu5emLnsuf.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `reports`
--

CREATE TABLE `reports` (
  `id` int(100) NOT NULL,
  `sender_wuid` varchar(100) NOT NULL,
  `technician_wuid` varchar(100) NOT NULL,
  `reported_by` varchar(100) NOT NULL,
  `request_id` int(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `message` varchar(100) NOT NULL,
  `status` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
  `priority` varchar(1000) NOT NULL,
  `additionalmessage` varchar(1000) NOT NULL,
  `imagepath` varchar(1000) NOT NULL,
  `thing_to_fix` varchar(100) NOT NULL,
  `directoret` varchar(100) NOT NULL,
  `technician` varchar(1000) NOT NULL,
  `techname` varchar(100) NOT NULL,
  `techphone` int(100) NOT NULL,
  `task_status` varchar(100) NOT NULL,
  `assigned_time` time NOT NULL,
  `assigned_date` varchar(100) NOT NULL,
  `requested_date` date NOT NULL DEFAULT current_timestamp(),
  `document_path` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `requests`
--

INSERT INTO `requests` (`id`, `sender_wuid`, `name`, `buildingno`, `officeno`, `phone`, `quantity`, `checkboxrequests`, `priority`, `additionalmessage`, `imagepath`, `thing_to_fix`, `directoret`, `technician`, `techname`, `techphone`, `task_status`, `assigned_time`, `assigned_date`, `requested_date`, `document_path`) VALUES
(193, 'wdu12', 'dawit', 'kdje', 'hhxhd bd', '0920743743', '59', 'DESKTOP HARDWARE MAINTENANCE \n  \n INSTALLING DIFFERENT SOFTWARE \n  \n INSTALLING MS-OFFICE \n ', '', 'snnsn', 'http://192.168.43.228:80//wumrts/request/upload/iOV8kTrLqRcD1mPx.jpg', 'Desktop', 'ictd101', 'tech', 'dawa', 6888, 'Assigned', '00:00:00', '10/04/23', '0000-00-00', ''),
(194, 'wdu12', 'dawit', 'kdsjsjsj', 'hhxhd bdbddbb', '0920743743', '5995959', 'DESKTOP HARDWARE MAINTENANCE \n  \n INSTALLING DIFFERENT SOFTWARE \n  \n INSTALLING MS-OFFICE \n ', '', 'snnsn Lexbxbd', 'http://192.168.43.228:80//wumrts/request/upload/WkpwLuk4yiUuISdv.jpg', 'Desktop', 'ictd101', 'tech', 'dawa', 6888, 'Assigned', '00:00:00', '29/03/23', '0000-00-00', 'http://192.168.43.228:80//wumrts/request_sender/upload_construction_files/2023003024020057.docx'),
(195, 'wdu12', 'dawit', 'daff', 'fdfsd', '0920743743', '', '', '', 'dsfsdf', '', '', 'constd101', 'Not Assigned', 'Not Assigned', 0, 'Not Assigned', '00:00:00', '', '0000-00-00', 'http://192.168.43.228:80//wumrts/request_sender/upload_construction_files/2023003024020057.docx'),
(196, 'wdu12', 'dawit', 'dasd', 'dasdasd', '0920743743', '', '', '', 'dadasda', '', '', 'dormd101', 'Not Assigned', 'Not Assigned', 0, 'Not Assigned', '00:00:00', '', '0000-00-00', 'http://192.168.43.228:80//wumrts/request_sender/upload_construction_files/2023003024021002.docx'),
(197, 'wdu12', 'dawit', 'dasd', 'dasdasd', '0920743743', '', '', '', 'dadasda', '', '', 'dormd101', 'Not Assigned', 'Not Assigned', 0, 'Not Assigned', '00:00:00', '', '0000-00-00', 'http://192.168.43.228:80//wumrts/request_sender/upload_construction_files/2023003024021002.docx'),
(198, 'wdu12', 'dawit', 'dasd', 'dasdasd', '0920743743', '', '', '', 'dadasda', '', '', 'dormd101', 'Not Assigned', 'Not Assigned', 0, 'Not Assigned', '00:00:00', '', '0000-00-00', 'http://192.168.43.228:80//wumrts/request_sender/upload_construction_files/2023003024021002.docx'),
(199, 'wdu12', 'dawit', 'dasd', 'dasdasd', '0920743743', '', '', '', 'dadasda', '', '', 'dormd101', 'Not Assigned', 'Not Assigned', 0, 'Not Assigned', '00:00:00', '', '0000-00-00', 'http://192.168.43.228:80//wumrts/request_sender/upload_construction_files/2023003024021002.docx'),
(200, 'wdu12', 'dawit', 'dasd', 'dasdasd', '0920743743', '', '', '', 'dadasda', '', '', 'dormd101', 'Not Assigned', 'Not Assigned', 0, 'Not Assigned', '00:00:00', '', '0000-00-00', 'http://192.168.43.228:80//wumrts/request_sender/upload_construction_files/2023003024021006.docx'),
(201, 'wdu12', 'dawit', 'dasd', 'dasdasd', '0920743743', '', '', '', 'dadasda', '', '', 'dormd101', 'Not Assigned', 'Not Assigned', 0, 'Not Assigned', '00:00:00', '', '0000-00-00', 'http://192.168.43.228:80//wumrts/request_sender/upload_construction_files/2023003024021007.docx'),
(202, 'wdu12', 'dawit', 'dasd', 'dasdasd', '0920743743', '', '', '', 'dadasda', '', '', 'dormd101', 'Not Assigned', 'Not Assigned', 0, 'Not Assigned', '00:00:00', '', '0000-00-00', 'http://192.168.43.228:80//wumrts/request_sender/upload_construction_files/2023003024021007.docx'),
(203, 'wdu12', 'dawit', 'fdsf', 'sfdsfdsfdfds', '0920743743', '', '', '', 'fdsfdsf', '', '', 'dormd101', 'Not Assigned', 'Not Assigned', 0, 'Not Assigned', '00:00:00', '', '0000-00-00', 'http://192.168.43.228:80//wumrts/request_sender/upload_construction_files/2023003024021010.docx'),
(204, 'wdu12', 'dawit', 'fujhgjhj', 'xsbjkhabc', '0920743743', '23121', 'DESKTOP HARDWARE MAINTENANCE \n INSTALLING POWER GEEZ \n  \n  \n  \n ', '', 'sdad', 'http://192.168.43.228:80//wumrts/request/upload/Trip1hwZh33kPGUC.jpg', 'Desktop', 'ictd101', 'tech1', 'dawa', 9877564, 'Assigned', '00:00:00', '', '0000-00-00', ''),
(205, 'wdu12', 'dawit', 'fujhgjhj', 'xsbjkhabc', '0920743743', '23121', 'DESKTOP HARDWARE MAINTENANCE \n INSTALLING POWER GEEZ \n  \n  \n  \n ', '', 'sdad', 'http://192.168.43.228:80//wumrts/request/upload/zyv1Bm4ODJaxpFj1.jpg', 'Desktop', 'ictd101', 'tech', 'dawa', 6888, 'Assigned', '00:00:00', '', '0000-00-00', ''),
(206, 'wdu12', 'dawit', 'hgugjkj', '1121', '0920743743', '', '', '', 'jasd', '', '', 'dormd101', 'Not Assigned', 'Not Assigned', 0, 'Not Assigned', '00:00:00', '', '0000-00-00', 'http://192.168.43.228:80//wumrts/request_sender/upload_construction_files/2023004006008003.docx'),
(207, 'wdu128', 'dawit', 'hgugjkj', '1121', '0920743743', '', '', '', 'jasd', '', '', 'dormd101', 'Not Assigned', 'Not Assigned', 0, 'Not Assigned', '00:00:00', '', '0000-00-00', 'http://192.168.43.228:80//wumrts/request_sender/upload_dormitory_files/2023004006008004.docx'),
(208, 'wdu12', 'dawit', '12', '13', '0920743743', '0928371065', ' \n INSTALLING POWER GEEZ \n  \n  \n  \n ', '', 'hshhh', 'http://192.168.43.228:80//wumrts/request/upload/1XroWqjMCKn7LILQ.jpg', 'Desktop', 'ictd101', 'wdu122', 'wdu12', 67649, 'Not Assigned', '00:00:00', '03/04/23', '0000-00-00', ''),
(209, 'wdu11', 'hab', '67', '77', '+251919857964', '', 'DESKTOP HARDWARE MAINTENANCE \n  \n  \n  \n  \n ', '', '', 'http://192.168.43.228:80//wumrts/request/upload/eZndTvKJ2FvAGpB4.jpg', 'Desktop', 'ictd101', 'tech', 'dawa', 6888, 'Not Assigned', '00:00:00', '23/05/23', '0000-00-00', ''),
(210, 'wu/8090/15', 'Solomon', 'gu', 'hh', '+251910992146', '', 'DESKTOP HARDWARE MAINTENANCE \n  \n  \n  \n  \n ', '', 'rthh', 'http://192.168.43.228:80//wumrts/request/upload/CFbtrleHvh6MjAPb.jpg', 'Desktop', 'ictd101', 'tech', 'dawa', 6888, 'Assigned', '00:00:00', '03/05/23', '0000-00-00', ''),
(211, 'wdu12', 'dawit', 'sasdsa', 'sdasd', '0920743743', '', '', '', 'dasdasdasd', '', '', 'dormd101', 'tech1', 'dawa', 9877564, 'Assigned', '00:00:00', '24/05/23', '0000-00-00', 'http://192.168.43.228:80//wumrts/request_sender/upload_dormitory_files/2023005022020058.docx'),
(212, 'wdu12', 'dawit', 'sdsdsad2', '23123', '0920743743', '3', 'LAPTOP HARDWARE MAINTENANCE \n INSTALLING POWER GEEZ \n  \n  \n  \n ', '', 'dfsf', 'http://192.168.43.228:80//wumrts/request/upload/tsmc9cEUvzGHBc0Y.jpg', 'Laptop', 'ictd101', 'Not Assigned', 'Not Assigned', 0, 'Not Assigned', '00:00:00', '', '0000-00-00', ''),
(213, 'wdu12', 'dawit', 'rewrwr', '54355', '0920743743', '5345', 'SCANNER HARDWARE MAINTENANCE \n  \n  \n  \n  \n ', '', 'wetwjlt', 'http://192.168.43.228:80//wumrts/request/upload/v1vCZ20EayR4j2EW.jpg', 'Scanner', 'ictd101', 'Not Assigned', 'Not Assigned', 0, 'Not Assigned', '00:00:00', '', '0000-00-00', '');

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
(76, 'dawit', 'gebrehiwot', 'wd12', '0920743743', 'Male', 'http://192.168.43.228:80//wumrts/request_sender/upload/auontuXffzC79I7h.jpg', 'http://192.168.43.228:80//wumrts/request_sender/upload1/PrhRB5CIlHVC6qqZ.jpg', 'Proctor', '2023-03-16'),
(77, 'dawit', 'gebrehiwot', 'wdu12', '0920743743', 'Male', 'http://192.168.43.228:80//wumrts/request_sender/upload/HV0MWzEF94TdNHYI.jpg', 'http://192.168.43.228:80//wumrts/request_sender/upload1/PrhRB5CIlHVC6qqZ.jpg', 'Proctor', '2023-03-16'),
(79, 'djajw', 'jzjsj', 'hahsh12', '8959', 'Male', 'http://192.168.43.228:80//wumrts/request_sender/upload/afj8x4ZXcJ3LGm1c.jpg', 'http://192.168.43.228:80//wumrts/request_sender/upload1/kYMdT7dFtKKPQakx.jpg', 'JORANLALISM', '2023-03-21'),
(80, 'djajw', 'jzjsj', 'hahsh12shsh', '8959', 'Male', 'http://192.168.43.228:80//wumrts/request_sender/upload/fq5DwO6IEQ7w6e1M.jpg', 'http://192.168.43.228:80//wumrts/request_sender/upload1/pNQ5rMTJaO08Aup8.jpg', 'JORANLALISM', '2023-03-21'),
(82, 'shshsh', 'kzjdjsn', '526', '79497', 'Male', 'http://192.168.43.228:80//wumrts/request_sender/upload/cxKFyK96xQ36lU69.jpg', 'http://192.168.43.228:80//wumrts/request_sender/upload1/vl6WKIoiiDDOIGZI.jpg', 'CHILD CARE', '2023-03-21'),
(83, 'shshsh', 'kzjdjsn', '526shs', '794974', 'Male', 'http://192.168.43.228:80//wumrts/request_sender/upload/w9A2mUfjCAoIacVA.jpg', 'http://192.168.43.228:80//wumrts/request_sender/upload1/yt7Ae84c3GlWNou4.jpg', 'CHILD CARE', '2023-03-21'),
(84, 'shhsh', 'jshwb', 'tqtYsg', '4949', 'Male', 'http://192.168.43.228:80//wumrts/request_sender/upload/ZKOGkdRVroo7bcNV.jpg', 'http://192.168.43.228:80//wumrts/request_sender/upload1/wPDEjVygnmFK3yvw.jpg', 'PEDOLOGY', '2023-03-21'),
(85, 'sdad', 'dsadads', 'dadasd', '414132', 'Male', 'http://192.168.43.228:80//wumrts/request_sender/upload/fNio7W9XikK4ZKIR.jpg', 'http://192.168.43.228:80//wumrts/request_sender/upload1/n79nSrnQc63rdQzb.jpg', 'SOCIOLOGY', '2023-03-22'),
(86, 'hhh', 'bh', 'shsh23', '6469', 'Male', 'http://192.168.43.228:80//wumrts/request_sender/upload/SE5Jd3HINtKBwNu8.jpg', 'http://192.168.43.228:80//wumrts/request_sender/upload1/pPYHfC299B7ikDBK.jpg', '', '2023-03-22'),
(87, 'hhh', 'bh', 'shsh2sjs', '6469', 'Male', 'http://192.168.43.228:80//wumrts/request_sender/upload/i6PugsZx7F9CSUm6.jpg', 'http://192.168.43.228:80//wumrts/request_sender/upload1/o2NH6RBRCpYny8Ux.jpg', '', '2023-03-22'),
(88, 'xnndn', 'j was jd', 'sh182', '799', 'Female', 'http://192.168.43.228:80//wumrts/request_sender/upload/wdDSNj9Xpo3oC12P.jpg', 'http://192.168.43.228:80//wumrts/request_sender/upload1/z4cKOeZVriVpa6YI.jpg', 'PEDOLOGY', '2023-03-22'),
(89, 'xnndn', 'j was jd', 'sh182dxj', '799', 'Female', 'http://192.168.43.228:80//wumrts/request_sender/upload/HDMPLXAxthNRFOA0.jpg', 'http://192.168.43.228:80//wumrts/request_sender/upload1/jLZR6PWYsdLEsPZv.jpg', 'PEDOLOGY', '2023-03-22'),
(90, 'xnndn', 'j was jd', 'sh182dxjkgi', '799', 'Female', 'http://192.168.43.228:80//wumrts/request_sender/upload/EYLFwsQYmBW2fWXG.jpg', 'http://192.168.43.228:80//wumrts/request_sender/upload1/nL6gh3VbkhBD5GDz.jpg', 'PEDOLOGY', '2023-03-22'),
(91, 'xnndn', 'j was jd', 'sh182dxjkgig', '799', 'Female', 'http://192.168.43.228:80//wumrts/request_sender/upload/jxk752i6JXrypVaH.jpg', 'http://192.168.43.228:80//wumrts/request_sender/upload1/Be3UgVhyp5AmZYsk.jpg', 'PEDOLOGY', '2023-03-22'),
(92, 'xnndn', 'j was jd', 'sh182vkdxjkgig', '799', 'Female', 'http://192.168.43.228:80//wumrts/request_sender/upload/Xetj4vM9NTHqn3uF.jpg', 'http://192.168.43.228:80//wumrts/request_sender/upload1/RTttCEPepJCB1EcZ.jpg', 'PEDOLOGY', '2023-03-22'),
(93, 'bbc', 'xbb', 'dhb', '64661', 'Female', 'http://192.168.43.228:80//wumrts/request_sender/upload/aELtepSygDRZcUxa.jpg', 'http://192.168.43.228:80//wumrts/request_sender/upload1/s8CGH990h3DOQ380.jpg', 'CHILD CARE', '2023-03-23'),
(94, 'fgdfgg fddgdfgrtrete', 'fgdffg', 'tyrrgfgtet', '324324', 'Male', 'http://192.168.43.228:80//wumrts/request_sender/upload/eXR9RoelI1Tud0ot.jpg', 'http://192.168.43.228:80//wumrts/request_sender/upload1/YDmCP63cnwbVfgud.jpg', 'COTM', '2023-04-01'),
(95, 'Solomon', 'Alebachew', 'ak2009-12/209', '0910992146', 'Male', 'http://192.168.43.228:80//wumrts/request_sender/upload/YRjbmzXMiPO1TKgo.jpg', 'http://192.168.43.228:80//wumrts/request_sender/upload1/XDDf32iEv1ZorgM6.jpg', 'Teacher', '2023-04-04'),
(96, 'dwqdqwd', 'dwqdqd', 'daw12', '423', 'Male', 'http://192.168.43.228:80//wumrts/request_sender/upload/Uc2OP8EXUNmTkB1s.jpg', 'http://192.168.43.228:80//wumrts/request_sender/upload1/2td1xKzZ7viELjbR.jpg', 'Teacher', '2023-04-04'),
(97, 'ws12s1 21e2s12s2', 'vv', 'techdfddsfdsfa', '555', 'Male', 'http://192.168.43.228:80//wumrts/request_sender/upload/8U1ik03iiqTekAAs.jpg', 'http://192.168.43.228:80//wumrts/request_sender/upload1/GEjO8DITEzKOD7EF.jpg', 'Teacher', '2023-04-04'),
(98, 'Habtamu', 'Abebaw', 'habtamuabe14@gmail.com', '0919857064', 'Male', 'http://192.168.43.228:80//wumrts/request_sender/upload/yxi5gzz0zzeBKvlt.jpg', 'http://192.168.43.228:80//wumrts/request_sender/upload1/5QJGp0wZKalzsVQy.jpg', 'Teacher', '2023-04-06'),
(99, 'Zewdu', 'Tafes', 'wdu120', '0955328432', 'Select Gender', 'http://192.168.43.228:80//wumrts/request_sender/upload/IkcHvT1HplcC8tAp.jpg', 'http://192.168.43.228:80//wumrts/request_sender/upload1/f5S3UcGlJjnEJBQQ.jpg', 'Registrar person', '2023-04-06'),
(100, 'helari', 'seyfu', '1204641', '0928371065', 'Female', 'http://192.168.43.228:80//wumrts/request_sender/upload/puosA1BZ4OpBcW62.jpg', 'http://192.168.43.228:80//wumrts/request_sender/upload1/oDwQLyvFNGcsxO5T.jpg', 'Teacher', '2023-04-06'),
(101, 'birhane', 'getachew', 'WDU1200498', '0901744117', 'Female', 'http://192.168.43.228:80//wumrts/request_sender/upload/c7SR9z4izHalCIWB.jpg', 'http://192.168.43.228:80//wumrts/request_sender/upload1/jsTfdNFb0agUDJzu.jpg', 'Teacher', '2023-04-06'),
(102, 'Zewdu', 'Tafes', 'wdu', '0949416171', 'Male', 'http://192.168.43.228:80//wumrts/request_sender/upload/Qc6FBefhgyw7MEq1.jpg', 'http://192.168.43.228:80//wumrts/request_sender/upload1/WeTr1kNAPmq8vHx4.jpg', 'Registrar person', '2023-04-06'),
(103, 'gvnb', '  vnb', 'eres5435456', '74758', 'Male', 'http://192.168.43.228:80//wumrts/request_sender/upload/xeKntEWzCz9aTpql.jpg', 'http://192.168.43.228:80//wumrts/request_sender/upload1/5m34z9hMuH7eF3iC.jpg', 'Dormitory', '2023-04-23'),
(104, 'gvnb', '  vnb', 'eres543545gtyfg6', '74758', 'Female', 'http://192.168.43.228:80//wumrts/request_sender/upload/pknCretWgc0ArjfE.jpg', 'http://192.168.43.228:80//wumrts/request_sender/upload1/URpI8gbsNAR4iwoi.jpg', 'Student union', '2023-04-23'),
(105, 'gvnb', '  vnb', 'weeres543545gtyfg6', '74758', 'Female', 'http://192.168.43.228:80//wumrts/request_sender/upload/K7BDK3bOnrrKfwnz.jpg', 'http://192.168.43.228:80//wumrts/request_sender/upload1/59WyZ21EK1CppdOA.jpg', 'Administrator office', '2023-04-23'),
(106, 'tyfghvb', 'sadad', '3213123essad', '+251887678318', 'Male', 'http://192.168.43.228:80//wumrts/request_sender/upload/jUX1S835gV31uUBk.jpg', 'http://192.168.43.228:80//wumrts/request_sender/upload1/gjql5X6JRWvxLarF.jpg', 'Clinic worker', '2023-04-23'),
(107, 'hab', 'Abe', 'wdu11', '+251919857964', 'Male', 'http://192.168.43.228:80//wumrts/request_sender/upload/rDOPjWIpYXXSYOZD.jpg', 'http://192.168.43.228:80//wumrts/request_sender/upload1/qKgU0ElcHRVtS1z6.jpg', 'Lecturer', '2023-05-05'),
(108, 'ddae', 'wrg', 'ወዩ/ 809011- አስ/15', '+251910992146', 'Male', 'http://192.168.43.228:80//wumrts/request_sender/upload/hNcXao7Bm60Ilp5t.jpg', 'http://192.168.43.228:80//wumrts/request_sender/upload1/l24hbvuA89KY4FxO.jpg', 'Lecturer', '2023-05-05'),
(109, 'Solomon', 'Alebachew', 'wu/8090/15', '+251910992146', 'Male', 'http://192.168.43.228:80//wumrts/request_sender/upload/3YQ7Z2LfXKt1tivT.jpg', 'http://192.168.43.228:80//wumrts/request_sender/upload1/5yhuNhZ9Cpf851aR.jpg', 'Lecturer', '2023-05-05');

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
(10, 'wdu12', '1#+#', 'wdu122', 'Male', '67649', 'http://192.168.43.228:80//wumrts/maintenance_manager/profilepicture/cEgYs2XAsomx4xtv.jpg', 'dormd101', 1),
(13, 'dawa', 'tt', 'tech1', 'Male', '09877564', 'http://192.168.43.228:80//wumrts/maintenance_manager/profilepicture/Qj22xd0AaueAG1Tp.jpg', 'dormd101', 3),
(14, 'dawa', '12&-', 'tech', 'Male', '6888', 'http://192.168.43.228:80//wumrts/request_sender/upload/3YQ7Z2LfXKt1tivT.jpg', 'ictd101', 0);

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
-- Indexes for table `log`
--
ALTER TABLE `log`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `maintenance_manager`
--
ALTER TABLE `maintenance_manager`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `wuid` (`wuid`);

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
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT for table `directorates`
--
ALTER TABLE `directorates`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `facility_manager`
--
ALTER TABLE `facility_manager`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- AUTO_INCREMENT for table `log`
--
ALTER TABLE `log`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `maintenance_manager`
--
ALTER TABLE `maintenance_manager`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `requests`
--
ALTER TABLE `requests`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=214;

--
-- AUTO_INCREMENT for table `request_sender`
--
ALTER TABLE `request_sender`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=110;

--
-- AUTO_INCREMENT for table `technician`
--
ALTER TABLE `technician`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
