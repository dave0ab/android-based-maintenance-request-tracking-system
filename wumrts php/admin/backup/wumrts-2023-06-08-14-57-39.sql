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
) ENGINE=InnoDB AUTO_INCREMENT=122 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (2,'mm','25d55ad283aa400af464c76d713c07ad','Maintenance Manager','dave0ab@gmail.com','','2023-06-08 12:15:30','Allowed','2023-05-22'),(101,'wdu1200619','25d55ad283aa400af464c76d713c07ad','client','dawitghiwot28@gmail.com','','','Allowed','2023-06-05 20:57:09'),(102,'wdu1202268 ','25d55ad283aa400af464c76d713c07ad','client','zewdutafs@gmail.com','','','Allowed','2023-06-05 20:59:26'),(103,'WDU1204641','25d55ad283aa400af464c76d713c07ad','client','helariseyfu@gmail.com','','','Allowed','2023-06-05 21:00:03'),(104,'wdu1200498','25d55ad283aa400af464c76d713c07ad','client','birhanegetachew106@gmail.com','h5d27fcptw','2023-06-05 21:34:09','Allowed','2023-06-05 21:00:31'),(105,'fawdu1202268','25d55ad283aa400af464c76d713c07ad','Facility Manager','zewdutfes21@gmail.com','','','Allowed','2023-06-05 21:01:17'),(106,'wdu111917','25d55ad283aa400af464c76d713c07ad','Technician','habtdamub14@gmail.com','','','Allowed','2023-06-05 21:01:37'),(107,'facwdu1202268','25d55ad283aa400af464c76d713c07ad','Facility Manager','zewdafes21@gmail.com','','','Allowed','2023-06-05 21:06:30'),(108,'dwdu111917','25d55ad283aa400af464c76d713c07ad','Technician','habtbde14@gmail.com','','','Allowed','2023-06-05 21:09:36'),(109,'fadwdu1202268','25d55ad283aa400af464c76d713c07ad','Facility Manager','zewdutafes21@gmail.com','','','Allowed','2023-06-05 21:10:00'),(110,'cwdu111917','25d55ad283aa400af464c76d713c07ad','Technician','habtamduabe14@gmail.com','','','Allowed','2023-06-05 21:12:10'),(111,'tecwdu1200498','25d55ad283aa400af464c76d713c07ad','Technician','birhanegetachew2210@gmail.com','','','Allowed','2023-06-05 21:12:49'),(112,'tewdu1204641','25d55ad283aa400af464c76d713c07ad','Technician','helariseyfu6@gmail.com','','','Allowed','2023-06-05 21:13:24'),(113,'wdu12','25d55ad283aa400af464c76d713c07ad','client','dawitghiwot@gmail.com','','','Allowed','2023-06-06 09:37:44'),(114,'fa','25d55ad283aa400af464c76d713c07ad','Facility Manager','dawd@esfa.com','','','Allowed','2023-06-06 09:39:09'),(115,'tech','25d55ad283aa400af464c76d713c07ad','Technician','wresdgf@dgfhg.com','','','Not Allowed','2023-06-06 09:43:39'),(116,'fawdu1204641','25d55ad283aa400af464c76d713c07ad','Facility Manager','helariseyfu8@gmail.com','','','Allowed','2023-06-07 21:34:18'),(117,'fawdu1200498','25d55ad283aa400af464c76d713c07ad','Facility Manager','birhanegetachew210@gmail.com','','','Allowed','2023-06-07 21:37:32'),(118,'fawdu111917','25d55ad283aa400af464c76d713c07ad','Facility Manager','habtamuabe14@gmail.com','','','Allowed','2023-06-07 21:40:48'),(119,'tewdu1204642','25d55ad283aa400af464c76d713c07ad','Technician','helariseyfu66@gmail.com','','','Not Allowed','2023-06-07 21:41:15'),(120,'wdu120','25f9e794323b453885f5181f1b624d0b','client','getachewu@gmail.com','','','Allowed','2023-06-08 14:51:17'),(121,'wdu1200','25d55ad283aa400af464c76d713c07ad','client','ebiniam12@gmail.com','','','Not Allowed','2023-06-08 15:26:40');
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
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `backup`
--

LOCK TABLES `backup` WRITE;
/*!40000 ALTER TABLE `backup` DISABLE KEYS */;
INSERT INTO `backup` VALUES (28,'wumrts-2023-06-06-09-32-32','C:/xampp/htdocs/wumrts/admin/backup/wumrts-2023-06-06-09-32-32.sql','2023-06-06 10:32:32'),(29,'wumrts-2023-06-07-20-27-46','C:/xampp/htdocs/wumrts/admin/backup/wumrts-2023-06-07-20-27-45.sql','2023-06-07 21:27:46'),(30,'wumrts-2023-06-08-13-47-08','C:/xampp/htdocs/wumrts/admin/backup/wumrts-2023-06-08-13-47-08.sql','2023-06-08 14:47:08');
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
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facility_manager`
--

LOCK TABLES `facility_manager` WRITE;
/*!40000 ALTER TABLE `facility_manager` DISABLE KEYS */;
INSERT INTO `facility_manager` VALUES (50,'Zewdu','Tafes','fawdu1202268','Male',2147483647,'http://192.168.43.228:80//wumrts/admin/profilepicture/gBHoBmL9dwt2qThQ.jpg','ictd101'),(51,'Zewdu','Tafes','facwdu1202268','Male',2147483647,'http://192.168.43.228:80//wumrts/admin/profilepicture/gBHoBmL9dwt2qThQ.jpg','constd101'),(52,'Zewdu','Tafes','fadwdu1202268','Male',2147483647,'http://192.168.43.228:80//wumrts/admin/profilepicture/gBHoBmL9dwt2qThQ.jpg','dormd101'),(53,'dawit','g','fa','Male',2147483647,'http://192.168.43.228:80//wumrts/admin/profilepicture/gBHoBmL9dwt2qThQ.jpg','ictd101'),(54,'helari','seyfu','fawdu1204641','Female',2147483647,'http://192.168.43.228:80//wumrts/admin/profilepicture/gBHoBmL9dwt2qThQ.jpg','ictd101'),(55,'birhane','getachew','fawdu1200498','Female',2147483647,'http://192.168.43.228:80//wumrts/admin/profilepicture/gBHoBmL9dwt2qThQ.jpg','ictd101'),(56,'Habtamu','Abebaw','fawdu111917','Male',2147483647,'http://192.168.43.228:80//wumrts/admin/profilepicture/gBHoBmL9dwt2qThQ.jpg','ictd101');
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
  `logdate` varchar(100) NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=324 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log`
--

LOCK TABLES `log` WRITE;
/*!40000 ALTER TABLE `log` DISABLE KEYS */;
INSERT INTO `log` VALUES (1,'','username=  activate account of=WDU1204641',''),(2,'','username=  activate account of=WDU1204641','2023-06-04 11:26:03'),(3,'','username=  activate account of=wdu111917','2023-06-04 11:27:27'),(284,'fawdu1202268','username=fawdu1202268 logged in to the system ','2023-06-08 12:43:44'),(285,'WDU1204641','username=WDU1204641 logged in to the system ','2023-06-08 12:46:09'),(286,'WDU1204641','username=WDU1204641 = Requested for ICT maintenances = 76 76 796 +251928371065 helariictd101 yiseralgni Printer Ict Directoret','2023-06-08 12:47:40'),(287,'fawdu1202268','username=fawdu1202268 = Assigned technician for the request = 307  assigned technician =wdu111917','2023-06-08 12:50:13'),(288,'wdu111917','username=wdu111917 logged in to the system ','2023-06-08 12:50:56'),(289,'wdu111917','username=wdu111917 = Reported for the request = 307detailes= hshsdnn ictd101 307 wdu111917 ','2023-06-08 12:53:16'),(290,'WDU1204641','username=WDU1204641 logged in to the system ','2023-06-08 12:54:23'),(291,'WDU1204641','username=WDU1204641 = Reported for the request = 307detailes= alalekelgnim ictd101 307 WDU1204641 ','2023-06-08 12:57:41'),(292,'fawdu1202268','username=fawdu1202268 = Reassigned technician for the request = 307assigned technician =wdu111917','2023-06-08 12:58:29'),(293,'wdu111917','username=wdu111917 = Reported for the request = 307detailes= now I have finished ictd101 307 wdu111917 ','2023-06-08 13:00:51'),(294,'wdu1200498','username=wdu1200498 = Requested for Construction maintenances = 23 w23 +251901744117 wdu1200498 water pump siltblashbgni endserulgni ','2023-06-08 13:05:19'),(295,'WDU1204641','username=WDU1204641 logged in to the system ','2023-06-08 13:06:54'),(296,'WDU1204641','username=WDU1204641 = Requested for ICT maintenances = 87 67 87 +251928371065 helariictd101 yiseralgni Printer Ict Directoret','2023-06-08 13:08:06'),(297,'WDU1204641','username=WDU1204641 = Requested for Construction maintenances = 23 et +251928371065 WDU1204641 wrtuju','2023-06-08 13:09:27'),(298,'fawdu1202268','username=fawdu1202268 logged in to the system ','2023-06-08 13:10:48'),(299,'fawdu1202268','username=fawdu1202268 = Assigned technician for the request = 309  assigned technician =wdu111917','2023-06-08 13:14:10'),(300,'wdu111917','username=wdu111917 logged in to the system ','2023-06-08 13:14:47'),(301,'wdu111917','username=wdu111917 = Reported for the request = 309detailes= cereshalehu ictd101 309 wdu111917 ','2023-06-08 13:16:22'),(302,'WDU1204641','username=WDU1204641 logged in to the system ','2023-06-08 13:16:45'),(303,'WDU1204641','username=WDU1204641 = Reported for the request = 309detailes= alabagg ictd101 309 WDU1204641 ','2023-06-08 13:17:50'),(304,'fawdu1202268','username=fawdu1202268 = Reassigned technician for the request = 309assigned technician =wdu111917','2023-06-08 13:20:28'),(305,'wdu111917','username=wdu111917 logged in to the system ','2023-06-08 13:21:03'),(306,'facwdu1202268','username=facwdu1202268 logged in to the system ','2023-06-08 14:26:30'),(307,'mm','username=mm logged in to the system ','2023-06-08 14:45:19'),(308,'mm','username=mm backedup the database','2023-06-08 14:47:08'),(309,'mm','username=mm logged in to the system ','2023-06-08 14:52:55'),(310,'mm','username=mm  activate account of=wdu120','2023-06-08 14:53:26'),(311,'wdu120','username=wdu120 logged in to the system ','2023-06-08 14:53:44'),(312,'wdu120','username=wdu120 = Requested for ICT maintenances = 56 76 876 +251928371069 Mrgetachewuictd101 yiseralgni Printer Ict Directoret','2023-06-08 14:56:52'),(313,'fawdu1202268','username=fawdu1202268 logged in to the system ','2023-06-08 15:00:01'),(314,'fawdu1202268','username=fawdu1202268 = Assigned technician for the request = 311  assigned technician =wdu111917','2023-06-08 15:03:08'),(315,'wdu1200498','username=wdu1200498 logged in to the system ','2023-06-08 15:06:21'),(316,'wdu1200498','username=wdu1200498 = Requested for ICT maintenances = 12 24 1 +251901744117 birhaneictd101 gughhg Laptop Ict Directoret','2023-06-08 15:07:14'),(317,'fawdu1202268','username=fawdu1202268 logged in to the system ','2023-06-08 15:08:28'),(318,'wdu120','username=wdu120 logged in to the system ','2023-06-08 15:14:43'),(319,'wdu111917','username=wdu111917 logged in to the system ','2023-06-08 15:15:20'),(320,'wdu120','username=wdu120 logged in to the system ','2023-06-08 15:30:16'),(321,'wdu120','username=wdu120 logged in to the system ','2023-06-08 15:30:47'),(322,'wdu120','username=wdu120 = Requested for ICT maintenances = v12 12 hp12 +251928371069 Mrgetachewuictd101 I want to Desktop Ict Directoret','2023-06-08 15:31:45'),(323,'mm','username=mm logged in to the system ','2023-06-08 15:54:02');
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
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reports`
--

LOCK TABLES `reports` WRITE;
/*!40000 ALTER TABLE `reports` DISABLE KEYS */;
INSERT INTO `reports` VALUES (68,'280','cwdu111917','','i have maintained','constd101','http://192.168.43.228:80//wumrts/technician/upload/2023006005020021.docx','2023-06-05','not seen','Not Reassigned'),(79,'307','wdu111917','','hshsdnn','ictd101','http://192.168.43.228:80//wumrts/technician/upload/2023006008011053.docx','2023-06-08','not seen','Reassigned'),(80,'307','','WDU1204641','alalekelgnim','ictd101','http://192.168.43.228:80//wumrts/technician/upload/2023006008011057.docx','2023-06-08','not seen','Reassigned'),(81,'307','wdu111917','','now I have finished','ictd101','http://192.168.43.228:80//wumrts/technician/upload/2023006008012000.docx','2023-06-08','not seen','Not Reassigned'),(82,'309','wdu111917','','cereshalehu','ictd101','http://192.168.43.228:80//wumrts/technician/upload/2023006008012016.docx','2023-06-08','not seen','Reassigned'),(83,'309','','WDU1204641','alabagg','ictd101','http://192.168.43.228:80//wumrts/technician/upload/2023006008012017.docx','2023-06-08','not seen','Reassigned');
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
) ENGINE=InnoDB AUTO_INCREMENT=145 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request_sender`
--

LOCK TABLES `request_sender` WRITE;
/*!40000 ALTER TABLE `request_sender` DISABLE KEYS */;
INSERT INTO `request_sender` VALUES (138,'Dawit','Gebrehiwot','wdu1200619','+251920743743','Male','http://192.168.43.228:80//wumrts/request_sender/upload/JkvwNjCeHC0XsXbf.jpg','http://192.168.43.228:80//wumrts/request_sender/upload1/j7KHidBPy8k23aRi.jpg','Human resources','2023-06-05'),(139,'Zewdu','tafes','wdu1202268 ','+251955328432','Male','http://192.168.43.228:80//wumrts/request_sender/upload/aX3HMEwi48lytZRk.jpg','http://192.168.43.228:80//wumrts/request_sender/upload1/f7MdvgDfJXhPwBoH.jpg','Drivers','2023-06-05'),(140,'helari','seyfu','WDU1204641','+251928371065','Female','http://192.168.43.228:80//wumrts/request_sender/upload/YTHFSi6rkJ89nb5i.jpg','http://192.168.43.228:80//wumrts/request_sender/upload1/tI5Q3Ed2KjFetlNz.jpg','Dormitory','2023-06-05'),(141,'birhane','getachew','wdu1200498','+251901744117','Female','http://192.168.43.228:80//wumrts/request_sender/upload/V6sJJVzCr4WidqM6.jpg','http://192.168.43.228:80//wumrts/request_sender/upload1/rYZHd8HfjJ56eRxE.jpg','Administrator office','2023-06-05'),(142,'dawit','g','wdu12','+251920743743','Male','http://192.168.43.228:80//wumrts/request_sender/upload/OVRUwXVPp5otneNP.jpg','http://192.168.43.228:80//wumrts/request_sender/upload1/Y8NfApw2lUIYWRPV.jpg','Clinic worker','2023-06-06'),(143,'Mrgetachewu','gh','wdu120','+251928371069','Female','http://192.168.43.228:80//wumrts/request_sender/upload/Jr5Nt0FAItpKjxPV.jpg','http://192.168.43.228:80//wumrts/request_sender/upload1/RFEpNJE4IyiMbDaX.jpg','Dormitory','2023-06-08'),(144,'Habtamu','Abe','wdu1200','+251912232326','Male','http://192.168.43.228:80//wumrts/request_sender/upload/KzEhfrrq5AOJLf2H.jpg','http://192.168.43.228:80//wumrts/request_sender/upload1/5sc4WOAbmUedaCMQ.jpg','Administrator office','2023-06-08');
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
) ENGINE=InnoDB AUTO_INCREMENT=314 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requests`
--

LOCK TABLES `requests` WRITE;
/*!40000 ALTER TABLE `requests` DISABLE KEYS */;
INSERT INTO `requests` VALUES (291,'wdu12','wdu12','dhshhh','bbjn','+251920743743','','','','dhanan','','Dormitory','dormd101','Not Assigned','Not Assigned','Not Assigned','Not Assigned','00:00:00','','2023-06-07','http://192.168.43.228:80//wumrts/request_sender/upload_dormitory_files/2023006007008044.docx','not reported','not reported'),(293,'wdu12','wdu12','uhh','vbb','+251920743743','','','','bbbnn','','Dormitory','dormd101','Not Assigned','Not Assigned','Not Assigned','Not Assigned','00:00:00','','2023-06-07','http://192.168.43.228:80//wumrts/request_sender/upload_dormitory_files/2023006007008048.docx','not reported','not reported'),(305,'wdu12','wdu12','hxfjfi','heyeyd','+251920743743','','','','nchc','','Dormitory','dormd101','Not Assigned','Not Assigned','Not Assigned','Not Assigned','00:00:00','','2023-06-08','http://192.168.43.228:80//wumrts/request_sender/upload_dormitory_files/2023006008011021.docx','not reported','not reported'),(307,'WDU1204641','helari','76','76','+251928371065','58',' \n  \n PRINTER NETWORK \n  \n  \n ','','yiseralgni','http://192.168.43.228:80//wumrts/request/upload/ku7f2yCQEweUSDcR.jpg','Printer','ictd101','wdu111917','Habtamu','+251919857064','Completed','00:00:00','23/06/08','2023-06-08','','reported','reported'),(308,'wdu1200498','wdu1200498','23','w23','+251901744117','','','','water pump siltblashbgni endserulgni ','','Construction','constd101','Not Assigned','Not Assigned','Not Assigned','Not Assigned','00:00:00','','2023-06-08','http://192.168.43.228:80//wumrts/request_sender/upload_construction_files/2023006008012005.docx','not reported','not reported'),(309,'WDU1204641','helari','87','67','+251928371065','5',' \n  \n PRINTER NETWORK \n  \n  \n ','','yiseralgni','http://192.168.43.228:80//wumrts/request/upload/z4KyXSpgmPMSCtYA.jpg','Printer','ictd101','wdu111917','Habtamu','+251919857064','Reassigned','00:00:00','23/06/09','2023-06-08','','reported','reported'),(310,'WDU1204641','WDU1204641','23','et','+251928371065','','','','wrtuju','','Construction','constd101','Not Assigned','Not Assigned','Not Assigned','Not Assigned','00:00:00','','2023-06-08','http://192.168.43.228:80//wumrts/request_sender/upload_construction_files/2023006008012009.docx','not reported','not reported'),(311,'wdu120','Mrgetachewu','56','76','+251928371069','8',' \n  \n  \n CONNECT PRINTER TO PRINTER \n  \n ','','yiseralgni','http://192.168.43.228:80//wumrts/request/upload/oGKjuTQmUjpiDG5g.jpg','Printer','ictd101','wdu111917','Habtamu','+251919857064','Assigned','00:00:00','23/06/09','2023-06-08','','not reported','not reported'),(312,'wdu1200498','birhane','12','24','+251901744117','1','LAPTOP HARDWARE MAINTENANCE \n  \n  \n  \n  \n ','','gughhg','http://192.168.43.228:80//wumrts/request/upload/Nbv1OHnaFBGeg22A.jpg','Laptop','ictd101','Not Assigned','Not Assigned','Not Assigned','Not Assigned','00:00:00','','2023-06-08','','not reported','not reported'),(313,'wdu120','Mrgetachewu','v12','12','+251928371069','1','DESKTOP HARDWARE MAINTENANCE \n  \n  \n  \n  \n ','','I want to','http://192.168.43.228:80//wumrts/request/upload/6dp0ZF6m5jsvE5NV.jpg','Desktop','ictd101','Not Assigned','Not Assigned','Not Assigned','Not Assigned','00:00:00','','2023-06-08','','not reported','not reported');
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
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `technician`
--

LOCK TABLES `technician` WRITE;
/*!40000 ALTER TABLE `technician` DISABLE KEYS */;
INSERT INTO `technician` VALUES (21,'Habtamu','Abebaw','wdu111917','Male','+251919857064','http://192.168.43.228:80//wumrts/technician/upload1/8IaJ9XJnJzsUYDLQ.jpg','ictd101',5),(22,'Habtamu','Abebaw','dwdu111917','Male','+251919857064','http://192.168.43.228:80//wumrts/admin/profilepicture/gBHoBmL9dwt2qThQ.jpg','dormd101',0),(23,'Habtamu','Abebaw','cwdu111917','Male','+251919857064','http://192.168.43.228:80//wumrts/admin/profilepicture/gBHoBmL9dwt2qThQ.jpg','constd101',1),(24,'birhane','getachew','tecwdu1200498','Female','+251901744117','http://192.168.43.228:80//wumrts/admin/profilepicture/gBHoBmL9dwt2qThQ.jpg','ictd101',4),(25,'tech','techi','tewdu1204641','Female','+251928371065','http://192.168.43.228:80//wumrts/admin/profilepicture/gBHoBmL9dwt2qThQ.jpg','ictd101',5),(26,'dave','ff','tech','Male','+251920743743','http://192.168.43.228:80//wumrts/admin/profilepicture/gBHoBmL9dwt2qThQ.jpg','ictd101',2),(27,'helari','seyfu','tewdu1204642','Female','+251928371065','http://192.168.43.228:80//wumrts/admin/profilepicture/gBHoBmL9dwt2qThQ.jpg','ictd101',0);
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

-- Dump completed on 2023-06-08 15:57:39
