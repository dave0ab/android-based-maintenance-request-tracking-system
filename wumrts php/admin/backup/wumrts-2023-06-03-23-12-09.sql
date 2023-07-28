-- MariaDB dump 10.17  Distrib 10.4.11-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: wumrts
-- ------------------------------------------------------
-- Server version	10.4.11-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `wuid` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `role` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `token` varchar(100) NOT NULL,
  `tokenExpire` varchar(100) NOT NULL,
  `status` varchar(100) NOT NULL,
  `dateCreated` varchar(100) NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`),
  UNIQUE KEY `wuid` (`wuid`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'wdu12','81dc9bdb52d04dc20036dbd8313ed055','client','yimertesfaye21@gmail.com','1c6dnuaxlk','2023-05-22 17:06:46','Allowed','2023-05-22'),(2,'mm','81dc9bdb52d04dc20036dbd8313ed055','Maintenance Manager','dave0ab@gmail.com','','2023-05-24 16:34:36','Allowed','2023-05-22'),(5,'fa','81dc9bdb52d04dc20036dbd8313ed055','Facility Manager','dawit7ghiwot28@gmail.com','bao6ugk85m','2023-05-22 17:05:21','Allowed','2023-05-22'),(8,'tech1','81dc9bdb52d04dc20036dbd8313ed055','Technician','','lc51uaresd','2023-05-24 16:12:28','Allowed','2023-05-22'),(18,'tech','81dc9bdb52d04dc20036dbd8313ed055','Technician','','lc51uaresd','2023-05-24 16:12:28','Allowed','2023-05-22'),(66,'wdu1200619','25d55ad283aa400af464c76d713c07ad','client','dave000ab@gmail.com ','','','Allowed','2023-06-01 09:33:14'),(67,'wdu1202268','25d55ad283aa400af464c76d713c07ad','client','zewdutafes21@gmail.com','','','Allowed','2023-06-01 09:36:37'),(68,'wdu1200498','25d55ad283aa400af464c76d713c07ad','client','birhanegetachew106@gmail.com','','','Allowed','2023-06-01 09:37:11'),(69,'WDU1204641','25d55ad283aa400af464c76d713c07ad','client','helariseyfu@gmail.com','','','Allowed','2023-06-01 09:40:12'),(70,'wdu111917','5e8667a439c68f5145dd2fcbecf02209','client','habtamuabe14@gmail.com','','','Allowed','2023-06-01 09:41:05'),(71,'fawdu111917','5e8667a439c68f5145dd2fcbecf02209','Facility Manager','habtamuabe@gmail.com','','','Allowed','2023-06-01 09:54:15'),(72,'fawdu1200498','25d55ad283aa400af464c76d713c07ad','Facility Manager','birhanegetachew210@gmail.com','','','Allowed','2023-06-01 09:54:29'),(73,'fawdu1204641','81dc9bdb52d04dc20036dbd8313ed055','Facility Manager','helariseyfu5@gmail.com','','','Allowed','2023-06-01 09:54:52'),(74,'fawdu1202268','25d55ad283aa400af464c76d713c07ad','Facility Manager','zewdutafes@gmail.com','','','Allowed','2023-06-01 09:55:29'),(75,'tawdu1202268','25d55ad283aa400af464c76d713c07ad','Technician','zewdutafess21@gmail.com','','','Allowed','2023-06-01 09:57:27'),(76,'tewdu111917','5e8667a439c68f5145dd2fcbecf02209','Technician','habtamu@gmail.com','','','Allowed','2023-06-01 09:57:38'),(77,'tewdu1204641','01cbdbd8211e80fb3f35a844f4f77fb5','Technician','helariseyfu6@gmail.com','','','Allowed','2023-06-01 09:57:41'),(78,'tewdu1200498','25d55ad283aa400af464c76d713c07ad','Technician','birhanegetachew097@gmail.com','','','Allowed','2023-06-01 09:58:21'),(79,'facwdu1202268','25d55ad283aa400af464c76d713c07ad','Facility Manager','zewdutafe21@gmail.com','','','Allowed','2023-06-02 09:53:56'),(80,'cotewdu111917','5e8667a439c68f5145dd2fcbecf02209','Technician','habtam@gmail.com','','','Allowed','2023-06-02 09:55:51');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `fname` varchar(100) NOT NULL,
  `lname` varchar(100) NOT NULL,
  `wuid` varchar(100) NOT NULL,
  `sex` varchar(100) NOT NULL,
  `phone` int(100) NOT NULL,
  `imagepath` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `wuid` (`wuid`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (6,'dawit','','mm','',0,'http://192.168.43.228:80//wumrts/admin/upload1/4fYXjR5GUiao9DnF.jpg');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `backup`
--

DROP TABLE IF EXISTS `backup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `backup` (
  `id` int(110) NOT NULL AUTO_INCREMENT,
  `backupname` varchar(110) NOT NULL,
  `backuppath` varchar(110) NOT NULL,
  `datecreated` varchar(100) NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `backup`
--

LOCK TABLES `backup` WRITE;
/*!40000 ALTER TABLE `backup` DISABLE KEYS */;
INSERT INTO `backup` VALUES (10,'wumrts-2023-06-03-18-36-02','C:/xampp/htdocs/wumrts/admin/backup/wumrts-2023-06-03-18-36-02.sql',''),(11,'wumrts-2023-06-03-18-37-23','C:/xampp/htdocs/wumrts/admin/backup/wumrts-2023-06-03-18-37-23.sql',''),(12,'wumrts-2023-06-03-18-37-41','C:/xampp/htdocs/wumrts/admin/backup/wumrts-2023-06-03-18-37-41.sql',''),(13,'wumrts-2023-06-03-18-37-59','http://192.168.43.228:80//wumrts/admin/backup/wumrts-2023-06-03-18-37-59.sql',''),(14,'wumrts-2023-06-03-21-13-55','http://192.168.43.228:80//wumrts/admin/backup/wumrts-2023-06-03-21-13-55.sql',''),(15,'wumrts-2023-06-03-21-14-35','http://192.168.43.228:80//wumrts/admin/backup/wumrts-2023-06-03-21-14-35.sql','');
/*!40000 ALTER TABLE `backup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `directorates`
--

DROP TABLE IF EXISTS `directorates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `directorates` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `did` varchar(100) NOT NULL,
  `dname` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `directorates`
--

LOCK TABLES `directorates` WRITE;
/*!40000 ALTER TABLE `directorates` DISABLE KEYS */;
INSERT INTO `directorates` VALUES (1,'ictd101','Ict Directoret'),(2,'constd101','Construction Directoret'),(3,'dormd101','Dormitory Directoret');
/*!40000 ALTER TABLE `directorates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facility_manager`
--

DROP TABLE IF EXISTS `facility_manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `facility_manager` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `fname` varchar(100) NOT NULL,
  `lname` varchar(100) NOT NULL,
  `wuid` varchar(100) NOT NULL,
  `sex` varchar(100) NOT NULL,
  `phone` int(100) NOT NULL,
  `imagepath` varchar(100) NOT NULL,
  `directoret` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `wuid` (`wuid`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facility_manager`
--

LOCK TABLES `facility_manager` WRITE;
/*!40000 ALTER TABLE `facility_manager` DISABLE KEYS */;
INSERT INTO `facility_manager` VALUES (31,'birhane','','fa','',0,'http://192.168.43.228:80//wumrts/facility_manager/upload1/RDif0EaPTk6m6fG2.jpg','ictd101'),(40,'Habtamu','Abebaw','fawdu111917','Male',2147483647,'http://192.168.43.228:80//wumrts/facility_manager/upload1/BFndd2d1bHAxM5s8.jpg','ictd101'),(41,'birhane','getachew ','fawdu1200498','Female',2147483647,'http://192.168.43.228:80//wumrts/facility_manager/upload1/epnsnyZXZH4N1PkN.jpg','dormd101'),(42,'helari','seyfu','fawdu1204641','Female',2147483647,'http://192.168.43.228:80//wumrts/facility_manager/upload1/XOGYUC1oW8PBhDI7.jpg','constd101'),(43,'Zewdu','Tafes','fawdu1202268','Male',2147483647,'http://192.168.43.228:80//wumrts/facility_manager/upload1/Yvm6EsrwZQNSMvUj.jpg','ictd101'),(44,'Zewdu','Tafes','facwdu1202268','Male',2147483647,'http://192.168.43.228:80//wumrts/facility_manager/upload1/3PtODK6uB48gk8eG.jpg','constd101'),(48,'dawa','jsjsn','wse','Male',2147483647,'http://192.168.43.228:80//wumrts/facility_manager/upload1/koS1Etk6Ik01tLb6.jpg','dormd101');
/*!40000 ALTER TABLE `facility_manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log`
--

DROP TABLE IF EXISTS `log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `log` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `wuid` varchar(100) NOT NULL,
  `logdata` varchar(1000) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log`
--

LOCK TABLES `log` WRITE;
/*!40000 ALTER TABLE `log` DISABLE KEYS */;
/*!40000 ALTER TABLE `log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reports`
--

DROP TABLE IF EXISTS `reports`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reports` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `request_id` varchar(100) NOT NULL,
  `tech_wuid` varchar(100) NOT NULL,
  `sender_wuid` varchar(100) NOT NULL,
  `message` varchar(100) NOT NULL,
  `directorate` varchar(100) NOT NULL,
  `document_path` varchar(100) NOT NULL,
  `reported_date` date NOT NULL DEFAULT current_timestamp(),
  `status` varchar(100) NOT NULL,
  `reassign_status` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reports`
--

LOCK TABLES `reports` WRITE;
/*!40000 ALTER TABLE `reports` DISABLE KEYS */;
INSERT INTO `reports` VALUES (60,'258','','WDU1204641','hdhdhdhdh','constd101','http://192.168.43.228:80//wumrts/technician/upload/2023006002010019.docx','2023-06-02','not seen','Reassigned'),(61,'258','cotewdu111917','','i maintained the window','constd101','http://192.168.43.228:80//wumrts/technician/upload/2023006002010019.docx','2023-06-02','not seen','Reassigned'),(62,'260','cotewdu111917','','done','constd101','http://192.168.43.228:80//wumrts/technician/upload/2023006002013025.docx','2023-06-02','not seen','Reassigned'),(63,'260','','WDU1204641','not finished','constd101','http://192.168.43.228:80//wumrts/technician/upload/2023006002013027.docx','2023-06-02','not seen','Reassigned'),(64,'260','cotewdu111917','','i have done already','constd101','http://192.168.43.228:80//wumrts/technician/upload/2023006002013029.docx','2023-06-02','not seen','Not Reassigned');
/*!40000 ALTER TABLE `reports` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `request_sender`
--

DROP TABLE IF EXISTS `request_sender`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `request_sender` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `fname` varchar(100) NOT NULL,
  `lname` varchar(100) NOT NULL,
  `wuid` varchar(100) NOT NULL,
  `phone` varchar(100) NOT NULL,
  `sex` varchar(100) NOT NULL,
  `imagepath` varchar(100) NOT NULL,
  `wuidimage` varchar(100) NOT NULL,
  `job_title` varchar(100) NOT NULL,
  `date` date NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`wuid`)
) ENGINE=InnoDB AUTO_INCREMENT=135 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request_sender`
--

LOCK TABLES `request_sender` WRITE;
/*!40000 ALTER TABLE `request_sender` DISABLE KEYS */;
INSERT INTO `request_sender` VALUES (77,'dawit','gebrehiwot','wdu12','0920743743','Male','http://192.168.43.228:80//wumrts/request_sender/upload1/djoTbyEMFTPPJCHA.jpg','http://192.168.43.228:80//wumrts/request_sender/upload1/PrhRB5CIlHVC6qqZ.jpg','Proctor','2023-03-16'),(119,'Dawit','Gebrehiwot ','wdu1200619','+251920743743','Male','http://192.168.43.228:80//wumrts/request_sender/upload/J5htnNibO8wQQTzH.jpg','http://192.168.43.228:80//wumrts/request_sender/upload1/cWUmJXXjDmtNf0NK.jpg','Teacher','2023-06-01'),(120,'Zewdu','Tafes','wdu1202268','+251955328432','Male','http://192.168.43.228:80//wumrts/request_sender/upload/hdgGzMSOLabFgOK4.jpg','http://192.168.43.228:80//wumrts/request_sender/upload1/8okN7TPEw1bLNmMi.jpg','Communication center','2023-06-01'),(121,'birhane','getachew','wdu1200498','+251901744117','Female','http://192.168.43.228:80//wumrts/request_sender/upload/oQ7sn4YwfiEs8J1s.jpg','http://192.168.43.228:80//wumrts/request_sender/upload1/SCD9BLGMX6VW372U.jpg','Administrator office','2023-06-01'),(122,'helari','seyfu','WDU1204641','+251928371065','Female','http://192.168.43.228:80//wumrts/request_sender/upload/doZaDieuwUSwT484.jpg','http://192.168.43.228:80//wumrts/request_sender/upload1/IVlXXwK0tpC3OaCk.jpg','Dormitory','2023-06-01'),(123,'Habtamu',' Abebaw','wdu111917','+251919857064','Male','http://192.168.43.228:80//wumrts/request_sender/upload/gui6n8wUsw0LUYu6.jpg','http://192.168.43.228:80//wumrts/request_sender/upload1/LpAmYW8y1hyzq5ek.jpg','Lecturer','2023-06-01'),(133,'dawa','jsjjs','dave12','+251920764661','Male','http://192.168.43.228:80//wumrts/request_sender/upload/Z0g2avOjwGtZvdUR.jpg','http://192.168.43.228:80//wumrts/request_sender/upload1/2kRCztOwbwVVFexd.jpg','Lecturer','2023-06-03'),(134,'dawa','jsjjs','davffe12','+251920764661','Male','http://192.168.43.228:80//wumrts/request_sender/upload/EJ2WSagzvAxrf84o.jpg','http://192.168.43.228:80//wumrts/request_sender/upload1/tNPY5A8kR1jBrD8w.jpg','Lecturer','2023-06-03');
/*!40000 ALTER TABLE `request_sender` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requests`
--

DROP TABLE IF EXISTS `requests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `requests` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
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
  `techphone` varchar(100) NOT NULL,
  `task_status` varchar(100) NOT NULL,
  `assigned_time` time NOT NULL,
  `assigned_date` varchar(100) NOT NULL,
  `requested_date` varchar(100) NOT NULL,
  `document_path` varchar(100) NOT NULL,
  `report_status` varchar(100) NOT NULL,
  `report_status_client` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=263 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requests`
--

LOCK TABLES `requests` WRITE;
/*!40000 ALTER TABLE `requests` DISABLE KEYS */;
INSERT INTO `requests` VALUES (255,'wdu1200498','birhane','60','23','+251901744117','1',' \n INSTALLING POWER GEEZ \n INSTALLING DIFFERENT SOFTWARE \n  \n  \n ','','tolo yiseralgni ','http://192.168.43.228:80//wumrts/request/upload/xYPYhEtCYFxwAYrj.jpg','Laptop','ictd101','tawdu1202268','Zewdu','+251955328432','Assigned','00:00:00','23/06/04','2023-06-02','','not reported','not reported'),(256,'WDU1204641','helari','56','6','+251928371065','','','','ydyydy','','Construction','constd101','Not Assigned','Not Assigned','Not Assigned','Not Assigned','00:00:00','','2023-06-02','http://192.168.43.228:80//wumrts/request_sender/upload_construction_files/2023006002010008.docx','not reported','not reported'),(257,'wdu1200498','birhane','40','233','+251901744117','1','DESKTOP HARDWARE MAINTENANCE \n  \n  \n  \n  \n ','','aschekay tolo yisrulgni','http://192.168.43.228:80//wumrts/request/upload/9uRmJI7gP6gCqLHS.jpg','Desktop','ictd101','Not Assigned','Not Assigned','Not Assigned','Not Assigned','00:00:00','','2023-06-02','','not reported','not reported'),(258,'WDU1204641','helari','66','66','+251928371065','','','','hdjdjjdjr','','Construction','constd101','cotewdu111917','Habtamu','+251919857064','Reassigned','00:00:00','23/06/02','2023-06-02','http://192.168.43.228:80//wumrts/request_sender/upload_construction_files/2023006002010016.docx','reported','reported'),(259,'wdu1200498','birhane','46','024','+251901744117','1','PRINTER HARDWARE MAINTENANCE \n INSTALLING PRINTER SOFTWARE \n  \n  \n  \n ','','tolo yiseralgni ','http://192.168.43.228:80//wumrts/request/upload/qs9oe1RtLAh2KxnG.jpg','Printer','ictd101','tewdu111917','Habtamu','+251919857064','Assigned','00:00:00','23/06/02','2023-06-02','','not reported','not reported'),(260,'WDU1204641','helari','65','76','+251928371065','','','','hshshshshshsh','','Construction','constd101','cotewdu111917','Habtamu','+251919857064','Completed','00:00:00','23/06/02','2023-06-02','http://192.168.43.228:80//wumrts/request_sender/upload_construction_files/2023006002013020.docx','reported','reported'),(261,'wdu1200498','birhane','40','356','+251901744117','1','LAPTOP HARDWARE MAINTENANCE \n  \n INSTALLING DIFFERENT SOFTWARE \n  \n  \n ','','sfghjkjj','http://192.168.43.228:80//wumrts/request/upload/WKps0boCzn5wHkn8.jpg','Laptop','ictd101','Not Assigned','Not Assigned','Not Assigned','Not Assigned','00:00:00','','2023-06-02','','not reported','not reported'),(262,'wdu12','dawit','green','7','0920743743','','','','ebakachu afetenut','','Construction','constd101','Not Assigned','Not Assigned','Not Assigned','Not Assigned','00:00:00','','2023-06-02','http://192.168.43.228:80//wumrts/request_sender/upload_construction_files/2023006002021031.docx','not reported','not reported');
/*!40000 ALTER TABLE `requests` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `technician`
--

DROP TABLE IF EXISTS `technician`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `technician` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `fname` varchar(100) NOT NULL,
  `lname` varchar(100) NOT NULL,
  `wuid` varchar(100) NOT NULL,
  `sex` varchar(100) NOT NULL,
  `phone` varchar(100) NOT NULL,
  `imagepath` varchar(100) NOT NULL,
  `directoret` varchar(100) NOT NULL,
  `ongoingJobs` int(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `wuid` (`wuid`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `technician`
--

LOCK TABLES `technician` WRITE;
/*!40000 ALTER TABLE `technician` DISABLE KEYS */;
INSERT INTO `technician` VALUES (13,'dawa','tt','tech1','Male','09877564','http://192.168.43.228:80//wumrts/maintenance_manager/profilepicture/Qj22xd0AaueAG1Tp.jpg','ictd101',1),(14,'dawa','12&-','tech','Male','6888','http://192.168.43.228:80//wumrts/technician/upload1/cluwWYV8e5TeU4cl.jpg','ictd101',1),(15,'Zewdu','Tafes','tawdu1202268','Male','+251955328432','http://192.168.43.228:80//wumrts/technician/upload1/TIpwt0gXWCBqYfUr.jpg','ictd101',3),(16,'Habtamu','Abebaw','tewdu111917','Male','+251919857064','http://192.168.43.228:80//wumrts/technician/upload1/Itd1SjUZNi5tDyNc.jpg','ictd101',7),(17,'helari','seyfu','tewdu1204641','Female','+251928371065','http://192.168.43.228:80//wumrts/technician/upload1/Xz6cKjlzsvy2Zjf1.jpg','constd101',1),(18,'birhane','getachew ','tewdu1200498','Female','+251901744117','http://192.168.43.228:80//wumrts/technician/upload1/6OPcbj8Q6sv0DRmD.jpg','dormd101',11),(19,'Habtamu','Abebaw','cotewdu111917','Male','+251919857064','http://192.168.43.228:80//wumrts/technician/upload1/uhdZrvUCVHkcRE5e.jpg','constd101',4);
/*!40000 ALTER TABLE `technician` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-04  0:12:09
