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
) ENGINE=InnoDB AUTO_INCREMENT=116 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (2,'mm','25d55ad283aa400af464c76d713c07ad','Maintenance Manager','dave0ab@gmail.com','','2023-05-24 16:34:36','Allowed','2023-05-22'),(101,'wdu1200619','25d55ad283aa400af464c76d713c07ad','client','dawitghiwot28@gmail.com','','','Not Allowed','2023-06-05 20:57:09'),(102,'wdu1202268 ','25d55ad283aa400af464c76d713c07ad','client','zewdutafs@gmail.com','','','Not Allowed','2023-06-05 20:59:26'),(103,'WDU1204641','25d55ad283aa400af464c76d713c07ad','client','helariseyfu@gmail.com','','','Allowed','2023-06-05 21:00:03'),(104,'wdu1200498','25d55ad283aa400af464c76d713c07ad','client','birhanegetachew106@gmail.com','h5d27fcptw','2023-06-05 21:34:09','Allowed','2023-06-05 21:00:31'),(105,'fawdu1202268','25d55ad283aa400af464c76d713c07ad','Facility Manager','zewdutfes21@gmail.com','','','Allowed','2023-06-05 21:01:17'),(106,'wdu111917','25d55ad283aa400af464c76d713c07ad','Technician','habtamub14@gmail.com','','','Allowed','2023-06-05 21:01:37'),(107,'facwdu1202268','25d55ad283aa400af464c76d713c07ad','Facility Manager','zewdafes21@gmail.com','','','Allowed','2023-06-05 21:06:30'),(108,'dwdu111917','25d55ad283aa400af464c76d713c07ad','Technician','habtbe14@gmail.com','','','Allowed','2023-06-05 21:09:36'),(109,'fadwdu1202268','25d55ad283aa400af464c76d713c07ad','Facility Manager','zewdutafes21@gmail.com','','','Allowed','2023-06-05 21:10:00'),(110,'cwdu111917','25d55ad283aa400af464c76d713c07ad','Technician','habtamuabe14@gmail.com','','','Allowed','2023-06-05 21:12:10'),(111,'tecwdu1200498','9d9b54aa6918828f61173b6a72e7a68e','Technician','birhanegetachew2210@gmail.com','','','Allowed','2023-06-05 21:12:49'),(112,'tewdu1204641','25d55ad283aa400af464c76d713c07ad','Technician','helariseyfu6@gmail.com','','','Allowed','2023-06-05 21:13:24'),(113,'wdu12','25d55ad283aa400af464c76d713c07ad','client','dawitghiwot@gmail.com','','','Allowed','2023-06-06 09:37:44'),(114,'fa','25d55ad283aa400af464c76d713c07ad','Facility Manager','dawd@esfa.com','','','Allowed','2023-06-06 09:39:09'),(115,'tech','883c0e4be03cb83115659a2f9d7eeafd','Technician','wresdgf@dgfhg.com','','','Allowed','2023-06-06 09:43:39');
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
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `backup`
--

LOCK TABLES `backup` WRITE;
/*!40000 ALTER TABLE `backup` DISABLE KEYS */;
INSERT INTO `backup` VALUES (20,'wumrts-2023-06-05-17-58-39','C:/xampp/htdocs/wumrts/admin/backup/wumrts-2023-06-05-17-58-39.sql','2023-06-05 18:58:39'),(21,'wumrts-2023-06-05-20-13-33','C:/xampp/htdocs/wumrts/admin/backup/wumrts-2023-06-05-20-13-33.sql','2023-06-05 21:13:33'),(22,'wumrts-2023-06-05-20-13-47','C:/xampp/htdocs/wumrts/admin/backup/wumrts-2023-06-05-20-13-46.sql','2023-06-05 21:13:47'),(23,'wumrts-2023-06-06-08-50-13','C:/xampp/htdocs/wumrts/admin/backup/wumrts-2023-06-06-08-50-13.sql','2023-06-06 09:50:13'),(24,'wumrts-2023-06-06-09-30-54','C:/xampp/htdocs/wumrts/admin/backup/wumrts-2023-06-06-09-30-54.sql','2023-06-06 10:30:54'),(25,'wumrts-2023-06-06-09-31-46','C:/xampp/htdocs/wumrts/admin/backup/wumrts-2023-06-06-09-31-45.sql','2023-06-06 10:31:46'),(26,'wumrts-2023-06-06-09-32-06','C:/xampp/htdocs/wumrts/admin/backup/wumrts-2023-06-06-09-32-06.sql','2023-06-06 10:32:06'),(27,'wumrts-2023-06-06-09-32-11','C:/xampp/htdocs/wumrts/admin/backup/wumrts-2023-06-06-09-32-11.sql','2023-06-06 10:32:11');
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
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facility_manager`
--

LOCK TABLES `facility_manager` WRITE;
/*!40000 ALTER TABLE `facility_manager` DISABLE KEYS */;
INSERT INTO `facility_manager` VALUES (50,'Zewdu','Tafes','fawdu1202268','Male',2147483647,'http://192.168.43.228:80//wumrts/admin/profilepicture/gBHoBmL9dwt2qThQ.jpg','ictd101'),(51,'Zewdu','Tafes','facwdu1202268','Male',2147483647,'http://192.168.43.228:80//wumrts/admin/profilepicture/gBHoBmL9dwt2qThQ.jpg','constd101'),(52,'Zewdu','Tafes','fadwdu1202268','Male',2147483647,'http://192.168.43.228:80//wumrts/admin/profilepicture/gBHoBmL9dwt2qThQ.jpg','dormd101'),(53,'dawit','g','fa','Male',2147483647,'http://192.168.43.228:80//wumrts/admin/profilepicture/gBHoBmL9dwt2qThQ.jpg','constd101');
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
) ENGINE=InnoDB AUTO_INCREMENT=154 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log`
--

LOCK TABLES `log` WRITE;
/*!40000 ALTER TABLE `log` DISABLE KEYS */;
INSERT INTO `log` VALUES (1,'','username=  activate account of=WDU1204641',''),(2,'','username=  activate account of=WDU1204641','2023-06-04 11:26:03'),(3,'','username=  activate account of=wdu111917','2023-06-04 11:27:27'),(4,'mm','username=mm  activate account of=wdu111917','2023-06-04 11:29:26'),(5,'mm','username=mm created account for dasdasd@gmail.com','2023-06-04 11:52:55'),(6,'wdu12','username=wdu12wdu12= Requested for Construction maintenances = bhjj cyhbb 0920743743 wdu12Construction Directoret sdbsbsmakavv','2023-06-04 12:03:33'),(7,'wdu12','username=wdu12 = Requested for ICT maintenances = hbjn bbbb bbbnkn 0920743743 dawitictd101 bxjzsn Desktop Ict Directoret','2023-06-04 12:13:48'),(8,'','username= = Assigned technician for the request = 257assigned technician =tewdu111917','2023-06-04 12:23:30'),(9,'fa','username=fa = Assigned technician for the request = 261assigned technician =tech1','2023-06-04 12:25:21'),(10,'wdu12','username=wdu12  changed its profile picture','2023-06-04 13:01:01'),(11,'wdu12','username=wdu12 = Requested for dormitory maintenances = th hhej jsksjj 0920743743 wdu12Dormitory Directoret nnsbbssb','2023-06-04 13:01:35'),(12,'wdu12','username=wdu12 = Requested for ICT maintenances = jwjej bhj vvb 0920743743 dawitictd101 sbnsnn Desktop Ict Directoret','2023-06-04 13:04:31'),(13,'wdu12','username=wdu12 = Requested for ICT maintenances = hgjmn tyghvnbhfgn ftvtug 0920743743 dawitictd101 hfvjv Desktop Ict Directoret','2023-06-04 13:07:08'),(14,'wdu12','username=wdu12 = Requested for ICT maintenances = ejdj hzbn jzjn 0920743743 dawitictd101 nzjs Desktop Ict Directoret','2023-06-04 13:07:46'),(15,'fa','username=fa = Assigned technician for the request = 264assigned technician =tewdu111917','2023-06-04 13:08:36'),(16,'fa','username=fa = Assigned technician for the request = 270assigned technician =tewdu111917','2023-06-04 13:09:19'),(17,'mm','username=mm backedup the database','2023-06-04 14:07:20'),(18,'mm','username=mm  activate account of=wdu111917','2023-06-04 14:36:56'),(19,'mm','username=mmchanged password ','2023-06-04 14:37:28'),(20,'wdu111917','username=wdu111917 = Requested for dormitory maintenances = B15 8 +251919857064 wdu111917Dormitory Directoret bsbdbbdbb','2023-06-04 19:48:20'),(21,'WDU1204641','username=WDU1204641 = Requested for Construction maintenances = 65 87 +251928371065 WDU1204641 hyyy','2023-06-04 19:48:39'),(22,'wdu1202268','username=wdu1202268 = Requested for Construction maintenances = 3 4 +251955328432 wdu1202268 ggh','2023-06-04 19:48:53'),(23,'wdu111917','username=wdu111917 = Requested for Construction maintenances = 21 12 +251919857064 wdu111917 hi every','2023-06-04 19:49:16'),(24,'wdu1200498','username=wdu1200498 = Requested for Construction maintenances = 23 06 +251901744117 wdu1200498 additional message ','2023-06-04 19:49:34'),(25,'WDU1204641','username=WDU1204641 = Requested for ICT maintenances = 8 7 0928371065 +251928371065 helariictd101 hhhjj Printer Ict Directoret','2023-06-04 19:49:40'),(26,'mm','username=mm  deactivate account of=wdu111917','2023-06-04 20:06:38'),(27,'mm','username=mm  activate account of=wdu111917','2023-06-04 20:06:47'),(28,'mm','username=mm  deactivate account of=wdu111917','2023-06-04 20:06:57'),(29,'fa','username=fa = changed its profile picture ','2023-06-04 20:25:18'),(30,'mm','username=mm  activated account of=fa','2023-06-04 20:44:41'),(31,'mm','username=mm  deactivated account of=fa','2023-06-04 20:45:36'),(32,'mm','username=mm  activated account of=fa','2023-06-04 20:45:40'),(33,'mm','username=mm  deactivated account of=fa','2023-06-04 20:45:54'),(34,'mm','username=mm  deactivate account of=wdu12','2023-06-04 20:53:56'),(35,'mm','username=mm  activate account of=wdu111917','2023-06-04 20:56:02'),(36,'mm','username=mm  activate account of=wdu12','2023-06-05 18:50:04'),(37,'mm','username=mm backedup the database','2023-06-05 18:58:39'),(38,'WDU1204641','username=WDU1204641 = Requested for Construction maintenances = 65 65 +251928371065 WDU1204641 hshshshhw','2023-06-05 19:12:32'),(39,'wdu1200498','username=wdu1200498 = Requested for ICT maintenances = 23 12 2 +251901744117 birhaneictd101 sfghhjb Laptop Ict Directoret','2023-06-05 19:14:09'),(40,'mm','username=mm  activate account of=wdu120','2023-06-05 19:18:13'),(41,'mm','username=mm  activate account of=wdu120','2023-06-05 19:18:31'),(42,'mm','username=mm  deactivate account of=wdu120','2023-06-05 19:18:57'),(43,'mm','username=mm  activate account of=wdu120','2023-06-05 19:19:12'),(44,'fawdu1202268','username=fawdu1202268logged in to the system ','2023-06-05 19:32:40'),(45,'wdu1200498','username=wdu1200498 logged in to the system ','2023-06-05 19:33:40'),(46,'wdu1200498','username=wdu1200498 logged in to the system ','2023-06-05 19:49:18'),(47,'WDU1204641','username=WDU1204641 logged in to the system ','2023-06-05 19:49:44'),(48,'wdu12','username=wdu12 logged in to the system ','2023-06-05 20:06:27'),(49,'wdu1200498','username=wdu1200498 logged in to the system ','2023-06-05 20:17:49'),(50,'tewdu1200498','username=tewdu1200498 logged in to the system ','2023-06-05 20:27:17'),(51,'tewdu1200498','username=tewdu1200498 logged in to the system ','2023-06-05 20:27:18'),(52,'tewdu1200498','username=tewdu1200498 logged in to the system ','2023-06-05 20:27:18'),(53,'mm','username=mm logged in to the system ','2023-06-05 20:33:22'),(54,'mm','username=mm  activated account of=fa','2023-06-05 20:34:23'),(55,'fa','username=fa logged in to the system ','2023-06-05 20:34:40'),(56,'fawdu1200498','username=fawdu1200498 logged in to the system ','2023-06-05 20:36:00'),(57,'fawdu1200498','username=fawdu1200498 = Assigned technician for the request = 267  assigned technician =tewdu1200498','2023-06-05 20:36:24'),(58,'tewdu1200498','username=tewdu1200498 logged in to the system ','2023-06-05 20:36:46'),(59,'fawdu1200498','username=fawdu1200498 logged in to the system ','2023-06-05 20:41:36'),(60,'','username= = changed report status of =65to seen ','2023-06-05 20:42:49'),(61,'','username= = changed report status of =65to seen ','2023-06-05 20:42:53'),(62,'','username= = changed report status of =65to seen ','2023-06-05 20:42:56'),(63,'fawdu1200498','username=fawdu1200498 = Reassigned technician for the request = 267assigned technician =tewdu1200498','2023-06-05 20:43:04'),(64,'','username= = changed report status of =65to seen ','2023-06-05 20:43:07'),(65,'','username= = changed report status of =65to seen ','2023-06-05 20:44:31'),(66,'','username= = changed report status of =65to seen ','2023-06-05 20:45:45'),(67,'fawdu1200498','username=fawdu1200498 logged in to the system ','2023-06-05 20:46:22'),(68,'','username= = changed report status of =65to seen ','2023-06-05 20:46:30'),(69,'','username= = changed report status of =65to seen ','2023-06-05 20:46:32'),(70,'','username= = changed report status of =65to seen ','2023-06-05 20:46:33'),(71,'','username= = changed report status of =65to seen ','2023-06-05 20:46:33'),(72,'fawdu1200498','username=fawdu1200498 = changed report status of =65to seen ','2023-06-05 20:46:55'),(73,'tewdu1200498','username=tewdu1200498 logged in to the system ','2023-06-05 20:47:24'),(74,'mm','username=mm logged in to the system ','2023-06-05 20:59:56'),(75,'mm','username=mm logged in to the system ','2023-06-05 21:00:19'),(76,'mm','username=mm  activate account of=WDU1204641','2023-06-05 21:00:31'),(77,'mm','username=mm logged in to the system ','2023-06-05 21:00:38'),(78,'mm','username=mm logged in to the system ','2023-06-05 21:00:45'),(79,'WDU1204641','username=WDU1204641 logged in to the system ','2023-06-05 21:00:52'),(80,'mm','username=mm  activate account of=wdu1200498','2023-06-05 21:01:03'),(81,'mm','username=mm created account for fawdu1202268','2023-06-05 21:01:21'),(82,'wdu1200498','username=wdu1200498 logged in to the system ','2023-06-05 21:01:22'),(83,'mm','username=mm created account for wdu111917','2023-06-05 21:01:41'),(84,'WDU1204641','username=WDU1204641 = Requested for ICT maintenances = 67 76 5567 +251928371065 helariictd101 gvgcddf Laptop Ict Directoret','2023-06-05 21:01:50'),(85,'wdu111917','username=wdu111917 logged in to the system ','2023-06-05 21:03:21'),(86,'fawdu1202268','username=fawdu1202268 logged in to the system ','2023-06-05 21:03:32'),(87,'wdu111917','username=wdu111917 = changed its password ','2023-06-05 21:03:56'),(88,'WDU1204641','username=WDU1204641 = Requested for Construction maintenances = yffd hgff +251928371065 WDU1204641 gglllnvvc','2023-06-05 21:04:05'),(89,'fawdu1202268','username=fawdu1202268 = changed its password ','2023-06-05 21:04:09'),(90,'wdu1200498','username=wdu1200498 = Requested for ICT maintenances = 22 244 2 +251901744117 birhaneictd101  tolo yiseralgni  Scanner Ict Directoret','2023-06-05 21:04:29'),(91,'mm','username=mm logged in to the system ','2023-06-05 21:05:17'),(92,'mm','username=mm logged in to the system ','2023-06-05 21:05:28'),(93,'mm','username=mm created account for facwdu1202268','2023-06-05 21:06:35'),(94,'wdu1200498','username=wdu1200498 = Requested for Construction maintenances = 12 34 +251901744117 wdu1200498 work to  electric dameg','2023-06-05 21:07:36'),(95,'facwdu1202268','username=facwdu1202268 logged in to the system ','2023-06-05 21:08:13'),(96,'facwdu1202268','username=facwdu1202268 = changed its password ','2023-06-05 21:08:46'),(97,'mm','username=mm logged in to the system ','2023-06-05 21:09:13'),(98,'mm','username=mm created account for dwdu111917','2023-06-05 21:09:40'),(99,'mm','username=mm created account for fadwdu1202268','2023-06-05 21:10:04'),(100,'dwdu111917','username=dwdu111917 logged in to the system ','2023-06-05 21:10:34'),(101,'dwdu111917','username=dwdu111917 = changed its password ','2023-06-05 21:10:57'),(102,'mm','username=mm logged in to the system ','2023-06-05 21:11:14'),(103,'mm','username=mm logged in to the system ','2023-06-05 21:11:15'),(104,'mm','username=mm logged in to the system ','2023-06-05 21:11:20'),(105,'fadwdu1202268','username=fadwdu1202268 logged in to the system ','2023-06-05 21:11:55'),(106,'mm','username=mm created account for cwdu111917','2023-06-05 21:12:13'),(107,'fadwdu1202268','username=fadwdu1202268 = changed its password ','2023-06-05 21:12:19'),(108,'mm','username=mm created account for tecwdu1200498','2023-06-05 21:12:53'),(109,'cwdu111917','username=cwdu111917 logged in to the system ','2023-06-05 21:13:00'),(110,'mm','username=mm created account for tewdu1204641','2023-06-05 21:13:27'),(111,'cwdu111917','username=cwdu111917 = changed its password ','2023-06-05 21:13:29'),(112,'mm','username=mm backedup the database','2023-06-05 21:13:33'),(113,'mm','username=mm backedup the database','2023-06-05 21:13:47'),(114,'fawdu1202268','username=fawdu1202268 logged in to the system ','2023-06-05 21:13:47'),(115,'wdu111917','username=wdu111917 logged in to the system ','2023-06-05 21:14:23'),(116,'wdu111917','username=wdu111917  changed its profile picture','2023-06-05 21:14:54'),(117,'tewdu1204641','username=tewdu1204641 logged in to the system ','2023-06-05 21:15:29'),(118,'fawdu1202268','username=fawdu1202268 = Assigned technician for the request = 279  assigned technician =wdu111917','2023-06-05 21:15:48'),(119,'fawdu1202268','username=fawdu1202268 logged in to the system ','2023-06-05 21:15:59'),(120,'fawdu1202268','username=fawdu1202268 = Assigned technician for the request = 281  assigned technician =wdu111917','2023-06-05 21:16:02'),(121,'WDU1204641','username=WDU1204641 logged in to the system ','2023-06-05 21:16:36'),(122,'mm','username=mm logged in to the system ','2023-06-05 21:16:47'),(123,'facwdu1202268','username=facwdu1202268 logged in to the system ','2023-06-05 21:17:00'),(124,'wdu111917','username=wdu111917 logged in to the system ','2023-06-05 21:17:11'),(125,'WDU1204641','username=WDU1204641 = Reported for the request = 279detailes= hhahahahaahahhahaah ictd101 279 WDU1204641 ','2023-06-05 21:17:46'),(126,'facwdu1202268','username=facwdu1202268 = Assigned technician for the request = 280  assigned technician =cwdu111917','2023-06-05 21:18:01'),(127,'wdu1200498','username=wdu1200498 logged in to the system ','2023-06-05 21:18:02'),(128,'facwdu1202268','username=facwdu1202268 = Assigned technician for the request = 282  assigned technician =cwdu111917','2023-06-05 21:18:15'),(129,'fawdu1202268','username=fawdu1202268 logged in to the system ','2023-06-05 21:19:23'),(130,'cwdu111917','username=cwdu111917 logged in to the system ','2023-06-05 21:19:59'),(131,'wdu1200498','username=wdu1200498 = Requested for dormitory maintenances = 12 22 +251901744117 wdu1200498Dormitory Directoret locker teblashtobgnal endserulgni','2023-06-05 21:20:20'),(132,'fawdu1202268','username=fawdu1202268 = Reassigned technician for the request = 279assigned technician =wdu111917','2023-06-05 21:21:50'),(133,'WDU1204641','username=WDU1204641 = Reported for the request = 279detailes= ggggggg ictd101 279 WDU1204641 ','2023-06-05 21:22:01'),(134,'wdu1200498','username=wdu1200498 = Reported for the request = 283detailes= not finished  dormd101 283 wdu1200498 ','2023-06-05 21:22:28'),(135,'wdu111917','username=wdu111917 logged in to the system ','2023-06-05 21:22:38'),(136,'wdu1200498','username=wdu1200498 = Requested for ICT maintenances = shheh  sbhsh +251901744117 birhaneictd101 zbsbsb Desktop Ict Directoret','2023-06-05 21:22:58'),(137,'fawdu1202268','username=fawdu1202268 = Assigned technician for the request = 284  assigned technician =wdu111917','2023-06-05 21:23:40'),(138,'fawdu1202268','username=fawdu1202268 = Reassigned technician for the request = 284assigned technician =wdu111917','2023-06-05 21:27:03'),(139,'wdu1200498','username=wdu1200498 logged in to the system ','2023-06-05 21:30:51'),(140,'wdu1200498','username=wdu1200498 logged in to the system ','2023-06-05 21:36:57'),(141,'mm','username=mm logged in to the system ','2023-06-06 09:38:20'),(142,'mm','username=mm created account for fa','2023-06-06 09:39:09'),(143,'mm','username=mm created account for tech','2023-06-06 09:43:40'),(144,'mm','username=mm  activate account of=wdu12','2023-06-06 09:43:51'),(145,'wdu12','username=wdu12 logged in to the system ','2023-06-06 09:44:13'),(146,'mm','username=mm logged in to the system ','2023-06-06 09:50:06'),(147,'mm','username=mm backedup the database','2023-06-06 09:50:13'),(148,'mm','username=mm restored the database','2023-06-06 10:08:20'),(149,'mm','username=mm  deactivate account of=wdu1202268 ','2023-06-06 10:30:24'),(150,'mm','username=mm backedup the database','2023-06-06 10:30:54'),(151,'mm','username=mm backedup the database','2023-06-06 10:31:46'),(152,'mm','username=mm backedup the database','2023-06-06 10:32:06'),(153,'mm','username=mm backedup the database','2023-06-06 10:32:11');
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
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reports`
--

LOCK TABLES `reports` WRITE;
/*!40000 ALTER TABLE `reports` DISABLE KEYS */;
INSERT INTO `reports` VALUES (66,'279','','WDU1204641','hhahahahaahahhahaah','ictd101','http://192.168.43.228:80//wumrts/technician/upload/2023006005020017.docx','2023-06-05','not seen','Reassigned'),(67,'279','wdu111917','','have maintained','ictd101','http://192.168.43.228:80//wumrts/technician/upload/2023006005020019.docx','2023-06-05','not seen','Reassigned'),(68,'280','cwdu111917','','i have maintained','constd101','http://192.168.43.228:80//wumrts/technician/upload/2023006005020021.docx','2023-06-05','not seen','Not Reassigned'),(69,'279','','WDU1204641','ggggggg','ictd101','http://192.168.43.228:80//wumrts/technician/upload/2023006005020022.docx','2023-06-05','not seen','Not Reassigned'),(70,'282','cwdu111917','','yes it havevbeen maintained ','constd101','http://192.168.43.228:80//wumrts/technician/upload/2023006005020022.docx','2023-06-05','not seen','Not Reassigned'),(71,'283','','wdu1200498','not finished ','dormd101','http://192.168.43.228:80//wumrts/technician/upload/2023006005020022.docx','2023-06-05','not seen','Not Reassigned'),(72,'281','wdu111917','','','ictd101','http://192.168.43.228:80//wumrts/technician/upload/2023006005020023.docx','2023-06-05','not seen','Not Reassigned'),(73,'284','wdu111917','','ya it wase maintend','ictd101','http://192.168.43.228:80//wumrts/technician/upload/2023006005020024.docx','2023-06-05','not seen','Reassigned'),(74,'284','wdu111917','','if any cause you can ask me','ictd101','http://192.168.43.228:80//wumrts/technician/upload/2023006005020028.docx','2023-06-05','not seen','Not Reassigned');
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
) ENGINE=InnoDB AUTO_INCREMENT=143 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request_sender`
--

LOCK TABLES `request_sender` WRITE;
/*!40000 ALTER TABLE `request_sender` DISABLE KEYS */;
INSERT INTO `request_sender` VALUES (138,'Dawit','Gebrehiwot','wdu1200619','+251920743743','Male','http://192.168.43.228:80//wumrts/request_sender/upload/JkvwNjCeHC0XsXbf.jpg','http://192.168.43.228:80//wumrts/request_sender/upload1/j7KHidBPy8k23aRi.jpg','Human resources','2023-06-05'),(139,'Zewdu','tafes','wdu1202268 ','+251955328432','Male','http://192.168.43.228:80//wumrts/request_sender/upload/aX3HMEwi48lytZRk.jpg','http://192.168.43.228:80//wumrts/request_sender/upload1/f7MdvgDfJXhPwBoH.jpg','Drivers','2023-06-05'),(140,'helari','seyfu','WDU1204641','+251928371065','Female','http://192.168.43.228:80//wumrts/request_sender/upload/YTHFSi6rkJ89nb5i.jpg','http://192.168.43.228:80//wumrts/request_sender/upload1/tI5Q3Ed2KjFetlNz.jpg','Dormitory','2023-06-05'),(141,'birhane','getachew','wdu1200498','+251901744117','Female','http://192.168.43.228:80//wumrts/request_sender/upload/V6sJJVzCr4WidqM6.jpg','http://192.168.43.228:80//wumrts/request_sender/upload1/rYZHd8HfjJ56eRxE.jpg','Administrator office','2023-06-05'),(142,'dawit','g','wdu12','+251920743743','Male','http://192.168.43.228:80//wumrts/request_sender/upload/OVRUwXVPp5otneNP.jpg','http://192.168.43.228:80//wumrts/request_sender/upload1/Y8NfApw2lUIYWRPV.jpg','Clinic worker','2023-06-06');
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
) ENGINE=InnoDB AUTO_INCREMENT=285 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requests`
--

LOCK TABLES `requests` WRITE;
/*!40000 ALTER TABLE `requests` DISABLE KEYS */;
INSERT INTO `requests` VALUES (279,'WDU1204641','helari','67','76','+251928371065','',' \n  \n INSTALLING DIFFERENT SOFTWARE \n  \n  \n ','','gvgcddf','http://192.168.43.228:80//wumrts/request/upload/w0phYFD3uZvQAyJc.jpg','Laptop','ictd101','wdu111917','Habtamu','+251919857064','Completed','00:00:00','23/06/05','2023-06-05','','reported','reported'),(280,'WDU1204641','WDU1204641','yffd','hgff','+251928371065','','','','gglllnvvc','','Construction','constd101','cwdu111917','Habtamu','+251919857064','Completed','00:00:00','23/06/05','2023-06-05','http://192.168.43.228:80//wumrts/request_sender/upload_construction_files/2023006005020004.docx','reported','not reported'),(281,'wdu1200498','birhane','22','244','+251901744117','1','SCANNER HARDWARE MAINTENANCE \n  \n  \n  \n  \n ','',' tolo yiseralgni ','http://192.168.43.228:80//wumrts/request/upload/KPuWNwxHVZ70fTu2.jpg','Scanner','ictd101','wdu111917','Habtamu','+251919857064','Completed','00:00:00','23/06/05','2023-06-05','','reported','not reported'),(282,'wdu1200498','wdu1200498','12','34','+251901744117','','','','work to  electric dameg','','Construction','constd101','cwdu111917','Habtamu','+251919857064','Completed','00:00:00','23/06/05','2023-06-05','http://192.168.43.228:80//wumrts/request_sender/upload_construction_files/2023006005020007.docx','reported','not reported'),(283,'wdu1200498','wdu1200498','12','22','+251901744117','','','','locker teblashtobgnal endserulgni','','Dormitory','dormd101','Not Assigned','Not Assigned','Not Assigned','Completed','00:00:00','','2023-06-05','http://192.168.43.228:80//wumrts/request_sender/upload_dormitory_files/2023006005020020.docx','not reported','reported'),(284,'wdu1200498','birhane','shheh','','+251901744117','','DESKTOP HARDWARE MAINTENANCE \n INSTALLING POWER GEEZ \n  \n  \n  \n ','','zbsbsb','http://192.168.43.228:80//wumrts/request/upload/YKHMZaufBg1uehd3.jpg','Desktop','ictd101','wdu111917','Habtamu','+251919857064','Completed','00:00:00','23/06/05','2023-06-05','','reported','not reported');
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
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `technician`
--

LOCK TABLES `technician` WRITE;
/*!40000 ALTER TABLE `technician` DISABLE KEYS */;
INSERT INTO `technician` VALUES (21,'Habtamu','Abebaw','wdu111917','Male','+251919857064','http://192.168.43.228:80//wumrts/technician/upload1/8IaJ9XJnJzsUYDLQ.jpg','ictd101',1),(22,'Habtamu','Abebaw','dwdu111917','Male','+251919857064','http://192.168.43.228:80//wumrts/admin/profilepicture/gBHoBmL9dwt2qThQ.jpg','dormd101',0),(23,'Habtamu','Abebaw','cwdu111917','Male','+251919857064','http://192.168.43.228:80//wumrts/admin/profilepicture/gBHoBmL9dwt2qThQ.jpg','constd101',0),(24,'birhane','getachew','tecwdu1200498','Female','+251901744117','http://192.168.43.228:80//wumrts/admin/profilepicture/gBHoBmL9dwt2qThQ.jpg','ictd101',0),(25,'tech','techi','tewdu1204641','Female','+251928371065','http://192.168.43.228:80//wumrts/admin/profilepicture/gBHoBmL9dwt2qThQ.jpg','ictd101',0),(26,'dave','ff','tech','Male','+251920743743','http://192.168.43.228:80//wumrts/admin/profilepicture/gBHoBmL9dwt2qThQ.jpg','constd101',0);
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

-- Dump completed on 2023-06-06 10:32:32
