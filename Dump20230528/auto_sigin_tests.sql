-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: auto_sigin
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tests`
--

DROP TABLE IF EXISTS `tests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tests` (
  `tests` int NOT NULL AUTO_INCREMENT,
  `testsid` int NOT NULL,
  `userid` int NOT NULL,
  `name` varchar(45) NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`tests`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tests`
--

LOCK TABLES `tests` WRITE;
/*!40000 ALTER TABLE `tests` DISABLE KEYS */;
INSERT INTO `tests` VALUES (31,0,5,'1.О языке Питон','2023-05-27 22:24:43'),(32,0,5,'1.О языке Питон','2023-05-27 22:25:23'),(33,0,5,'1.О языке Питон','2023-05-28 04:49:50'),(34,0,3,'1.О языке Питон','2023-05-28 04:51:49'),(35,0,5,'1','2023-05-28 14:39:20'),(36,0,5,'1. О языке Питон','2023-05-28 15:13:14'),(37,0,5,'1. О языке Питон','2023-05-28 15:17:58'),(38,0,5,'1. О языке Питон','2023-05-28 15:19:15'),(39,0,5,'1. О языке Питон','2023-05-28 15:21:39'),(40,0,5,'1. О языке Питон','2023-05-28 15:22:07'),(41,0,5,'1. О языке Питон','2023-05-28 15:22:25'),(42,0,5,'1. О языке Питон','2023-05-28 15:24:00'),(43,0,5,'1. О языке Питон','2023-05-28 15:24:14'),(44,0,5,'1. О языке Питон','2023-05-28 15:24:33'),(45,0,5,'1. О языке Питон','2023-05-28 15:24:46'),(46,0,5,'1. О языке Питон','2023-05-28 15:25:12'),(47,0,5,'1. О языке Питон','2023-05-28 15:26:20'),(48,0,5,'1. О языке Питон','2023-05-28 15:29:20'),(49,0,5,'1. О языке Питон','2023-05-28 15:31:10'),(50,0,5,'1. О языке Питон','2023-05-28 15:31:57'),(51,0,5,'1. О языке Питон','2023-05-28 15:33:12'),(52,0,5,'1. О языке Питон','2023-05-28 15:33:40'),(53,0,5,'1. О языке Питон','2023-05-28 15:35:55'),(54,0,5,'1. О языке Питон','2023-05-28 15:36:40');
/*!40000 ALTER TABLE `tests` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-28 15:39:11
