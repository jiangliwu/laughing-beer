-- MySQL dump 10.13  Distrib 5.5.27, for Win32 (x86)
--
-- Host: localhost    Database: beer
-- ------------------------------------------------------
-- Server version	5.5.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tbl_game`
--

DROP TABLE IF EXISTS `tbl_game`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_game` (
  `game_id` int(11) NOT NULL AUTO_INCREMENT,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `game_title` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `game_password` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `game_stauts` int(11) NOT NULL,
  `all_times` int(11) NOT NULL,
  `once_time` int(11) NOT NULL,
  `retail_number` int(11) DEFAULT NULL,
  `wholesale_number` int(11) DEFAULT NULL,
  `producer_number` int(11) DEFAULT NULL,
  PRIMARY KEY (`game_id`)
) ENGINE=InnoDB AUTO_INCREMENT=115 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_game`
--

LOCK TABLES `tbl_game` WRITE;
/*!40000 ALTER TABLE `tbl_game` DISABLE KEYS */;
INSERT INTO `tbl_game` VALUES (108,NULL,NULL,'helloWorld','vainner-no-password','2013-01-26 17:00:40',0,50,30,1,1,1),(109,NULL,NULL,'测试1111','vainner-no-password','2013-01-26 17:16:33',0,50,30,1,1,1),(110,NULL,NULL,'asdasdasd','vainner-no-password','2013-01-26 20:29:39',0,50,30,1,1,1),(111,NULL,NULL,'asdasdasd','vainner-no-password','2013-01-26 21:03:15',0,50,30,1,1,1),(112,NULL,NULL,'123123','vainner-no-password','2013-01-26 21:07:33',0,50,30,1,1,1),(113,NULL,NULL,'asdasd','vainner-no-password','2013-01-26 21:08:28',0,50,30,1,1,1),(114,NULL,NULL,'大家快来玩游戏啊','vainner-no-password','2013-03-24 03:20:46',0,50,30,1,1,1);
/*!40000 ALTER TABLE `tbl_game` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_game_producer_parameter`
--

DROP TABLE IF EXISTS `tbl_game_producer_parameter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_game_producer_parameter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `price` double NOT NULL DEFAULT '15',
  `cost` double NOT NULL DEFAULT '11',
  `delay_cost` double NOT NULL DEFAULT '1.2',
  `repertory_cost` double NOT NULL DEFAULT '0.15',
  `start_cost` double NOT NULL DEFAULT '30',
  `discount` double NOT NULL DEFAULT '50',
  `origin` double NOT NULL DEFAULT '30',
  `game_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_game_producer_parameter`
--

LOCK TABLES `tbl_game_producer_parameter` WRITE;
/*!40000 ALTER TABLE `tbl_game_producer_parameter` DISABLE KEYS */;
INSERT INTO `tbl_game_producer_parameter` VALUES (4,15,11,1.2,0.15,30,50,30,14),(5,15,11,1.2,0.15,30,50,30,15),(6,15,11,1.2,0.15,30,50,30,16),(7,15,11,1.2,0.15,30,50,30,17),(8,15,11,1.2,0.15,30,50,30,18),(9,15,11,1.2,0.15,30,50,30,19),(10,15,11,1.2,0.15,30,50,30,20),(11,15,11,1.2,0.15,30,50,30,21),(12,15,11,1.2,0.15,30,50,30,22),(13,15,11,1.2,0.15,30,50,30,23),(14,15,11,1.2,0.15,30,50,30,24),(15,15,11,1.2,0.15,30,50,30,25),(16,15,11,1.2,0.15,30,50,30,26),(17,15,11,1.2,0.15,30,50,30,27),(18,15,11,1.2,0.15,30,50,30,28),(19,15,11,1.2,0.15,30,50,30,29),(20,15,11,1.2,0.15,30,50,30,30),(21,15,11,1.2,0.15,30,50,30,31),(22,15,11,1.2,0.15,30,50,30,32),(23,15,11,1.2,0.15,30,50,30,33),(24,15,11,1.2,0.15,30,50,30,34),(25,15,11,1.2,0.15,30,50,30,35),(26,15,11,1.2,0.15,30,50,30,36),(27,15,11,1.2,0.15,30,50,30,37),(28,15,11,1.2,0.15,30,50,30,38),(29,15,11,1.2,0.15,30,50,30,39),(30,15,11,1.2,0.15,30,50,30,40),(31,15,11,1.2,0.15,30,50,30,41),(32,15,11,1.2,0.15,30,50,30,42),(33,15,11,1.2,0.15,30,50,30,43),(34,15,11,1.2,0.15,30,50,30,44),(35,15,11,1.2,0.15,30,50,30,45),(36,15,11,1.2,0.15,30,50,30,46),(37,15,11,1.2,0.15,30,50,30,47),(38,15,11,1.2,0.15,30,50,30,48),(39,15,11,1.2,0.15,30,50,30,49),(40,15,11,1.2,0.15,30,50,30,50),(41,15,11,1.2,0.15,30,50,30,51),(42,15,11,1.2,0.15,30,50,30,52),(43,15,11,1.2,0.15,30,50,30,53),(44,15,11,1.2,0.15,30,50,30,54),(45,15,11,1.2,0.15,30,50,30,55),(46,15,11,1.2,0.15,30,50,30,56),(47,15,11,1.2,0.15,30,50,30,57),(48,15,11,1.2,0.15,30,50,30,58),(49,15,11,1.2,0.15,30,50,30,59),(50,15,11,1.2,0.15,30,50,30,60),(51,15,11,1.2,0.15,30,50,30,61),(52,15,11,1.2,0.15,30,50,30,62),(53,15,11,1.2,0.15,30,50,30,63),(54,15,11,1.2,0.15,30,50,30,64),(55,15,11,1.2,0.15,30,50,30,65),(56,15,11,1.2,0.15,30,50,30,66),(57,15,11,1.2,0.15,30,50,30,67),(58,15,11,1.2,0.15,30,50,30,68),(59,15,11,1.2,0.15,30,50,30,69),(60,15,11,1.2,0.15,30,50,30,70),(61,15,11,1.2,0.15,30,50,30,71),(62,15,11,1.2,0.15,30,50,30,72),(63,15,11,1.2,0.15,30,50,30,73),(64,15,11,1.2,0.15,30,50,30,74),(65,15,11,1.2,0.15,30,50,30,75),(66,15,11,1.2,0.15,30,50,30,76),(67,15,11,1.2,0.15,30,50,30,77),(68,15,11,1.2,0.15,30,50,30,78),(69,15,11,1.2,0.15,30,50,30,79),(70,15,11,1.2,0.15,30,50,30,80),(71,15,11,1.2,0.15,30,50,30,81),(72,15,11,1.2,0.15,30,50,30,82),(73,15,11,1.2,0.15,30,50,30,83),(74,15,11,1.2,0.15,30,50,30,84),(75,15,11,1.2,0.15,30,50,30,85),(76,15,11,1.2,0.15,30,50,30,86),(77,15,11,1.2,0.15,30,50,30,87),(78,15,11,1.2,0.15,30,50,30,88),(79,15,11,1.2,0.15,30,50,30,89),(80,15,11,1.2,0.15,30,50,30,90),(81,15,11,1.2,0.15,30,50,30,91),(82,15,11,1.2,0.15,30,50,30,92),(83,15,11,1.2,0.15,30,50,30,93),(84,15,11,1.2,0.15,30,50,30,94),(85,15,11,1.2,0.15,30,50,30,95),(86,15,11,1.2,0.15,30,50,30,96),(87,15,11,1.2,0.15,30,50,30,97),(88,15,11,1.2,0.15,30,50,30,98),(89,15,11,1.2,0.15,30,50,30,99),(90,15,11,1.2,0.15,30,50,30,100),(91,15,11,1.2,0.15,30,50,30,101),(92,15,11,1.2,0.15,30,50,30,102),(93,15,11,1.2,0.15,30,50,30,103),(94,15,11,1.2,0.15,30,50,30,104),(95,15,11,1.2,0.15,30,50,30,105),(96,15,11,1.2,0.15,30,50,30,106),(97,15,11,1.2,0.15,30,50,30,107),(98,15,11,1.2,0.15,30,50,30,108),(99,15,11,1.2,0.15,30,50,30,109),(100,15,11,1.2,0.15,30,50,30,110),(101,15,11,1.2,0.15,30,50,30,111),(102,15,11,1.2,0.15,30,50,30,112),(103,15,11,1.2,0.15,30,50,30,113),(104,15,11,1.2,0.15,30,50,30,114);
/*!40000 ALTER TABLE `tbl_game_producer_parameter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_game_producer_record`
--

DROP TABLE IF EXISTS `tbl_game_producer_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_game_producer_record` (
  `game_retail_record_id` int(11) NOT NULL AUTO_INCREMENT,
  `this_time_buy` double DEFAULT NULL,
  `all_need` double DEFAULT NULL,
  `actual_sale` double DEFAULT NULL,
  `all_owe` double DEFAULT NULL,
  `delay_cost` double DEFAULT NULL,
  `begin_goods` double DEFAULT NULL,
  `receive_goods` double DEFAULT NULL,
  `end_goods` double DEFAULT NULL,
  `storage_cost` double DEFAULT NULL,
  `order_goods` double DEFAULT NULL,
  `this_time_profit` double DEFAULT NULL,
  `game_id` int(11) DEFAULT NULL,
  `times` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`game_retail_record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_game_producer_record`
--

LOCK TABLES `tbl_game_producer_record` WRITE;
/*!40000 ALTER TABLE `tbl_game_producer_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_game_producer_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_game_retail_parameter`
--

DROP TABLE IF EXISTS `tbl_game_retail_parameter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_game_retail_parameter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `price` double NOT NULL DEFAULT '30',
  `delay_cost` double NOT NULL DEFAULT '3',
  `repertory_cost` double NOT NULL DEFAULT '1',
  `order_cost` double NOT NULL DEFAULT '10',
  `transport_cost` double NOT NULL DEFAULT '10',
  `discount` double NOT NULL DEFAULT '50',
  `origin` double NOT NULL DEFAULT '12',
  `cost` double NOT NULL DEFAULT '20',
  `game_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_game_retail_parameter`
--

LOCK TABLES `tbl_game_retail_parameter` WRITE;
/*!40000 ALTER TABLE `tbl_game_retail_parameter` DISABLE KEYS */;
INSERT INTO `tbl_game_retail_parameter` VALUES (4,30,3,1,10,10,50,12,20,14),(5,30,3,1,10,10,50,12,20,15),(6,30,3,1,10,10,50,12,20,16),(7,30,3,1,10,10,50,12,20,17),(8,30,3,1,10,10,50,12,20,18),(9,30,3,1,10,10,50,12,20,19),(10,30,3,1,10,10,50,12,20,20),(11,30,3,1,10,10,50,12,20,21),(12,30,3,1,10,10,50,12,20,22),(13,30,3,1,10,10,50,12,20,23),(14,30,3,1,10,10,50,12,20,24),(15,30,3,1,10,10,50,12,20,25),(16,30,3,1,10,10,50,12,20,26),(17,30,3,1,10,10,50,12,20,27),(18,30,3,1,10,10,50,12,20,28),(19,30,3,1,10,10,50,12,20,29),(20,30,3,1,10,10,50,12,20,30),(21,30,3,1,10,10,50,12,20,31),(22,30,3,1,10,10,50,12,20,32),(23,30,3,1,10,10,50,12,20,33),(24,30,3,1,10,10,50,12,20,34),(25,30,3,1,10,10,50,12,20,35),(26,30,3,1,10,10,50,12,20,36),(27,30,3,1,10,10,50,12,20,37),(28,30,3,1,10,10,50,12,20,38),(29,30,3,1,10,10,50,12,20,39),(30,30,3,1,10,10,50,12,20,40),(31,30,3,1,10,10,50,12,20,41),(32,30,3,1,10,10,50,12,20,42),(33,30,3,1,10,10,50,12,20,43),(34,30,3,1,10,10,50,12,20,44),(35,30,3,1,10,10,50,12,20,45),(36,30,3,1,10,10,50,12,20,46),(37,30,3,1,10,10,50,12,20,47),(38,30,3,1,10,10,50,12,20,48),(39,30,3,1,10,10,50,12,20,49),(40,30,3,1,10,10,50,12,20,50),(41,30,3,1,10,10,50,12,20,51),(42,30,3,1,10,10,50,12,20,52),(43,30,3,1,10,10,50,12,20,53),(44,30,3,1,10,10,50,12,20,54),(45,30,3,1,10,10,50,12,20,55),(46,30,3,1,10,10,50,12,20,56),(47,30,3,1,10,10,50,12,20,57),(48,30,3,1,10,10,50,12,20,58),(49,30,3,1,10,10,50,12,20,59),(50,30,3,1,10,10,50,12,20,60),(51,30,3,1,10,10,50,12,20,61),(52,30,3,1,10,10,50,12,20,62),(53,30,3,1,10,10,50,12,20,63),(54,30,3,1,10,10,50,12,20,64),(55,30,3,1,10,10,50,12,20,65),(56,30,3,1,10,10,50,12,20,66),(57,30,3,1,10,10,50,12,20,67),(58,30,3,1,10,10,50,12,20,68),(59,30,3,1,10,10,50,12,20,69),(60,30,3,1,10,10,50,12,20,70),(61,30,3,1,10,10,50,12,20,71),(62,30,3,1,10,10,50,12,20,72),(63,30,3,1,10,10,50,12,20,73),(64,30,3,1,10,10,50,12,20,74),(65,30,3,1,10,10,50,12,20,75),(66,30,3,1,10,10,50,12,20,76),(67,30,3,1,10,10,50,12,20,77),(68,30,3,1,10,10,50,12,20,78),(69,30,3,1,10,10,50,12,20,79),(70,30,3,1,10,10,50,12,20,80),(71,30,3,1,10,10,50,12,20,81),(72,30,3,1,10,10,50,12,20,82),(73,30,3,1,10,10,50,12,20,83),(74,30,3,1,10,10,50,12,20,84),(75,30,3,1,10,10,50,12,20,85),(76,30,3,1,10,10,50,12,20,86),(77,30,3,1,10,10,50,12,20,87),(78,30,3,1,10,10,50,12,20,88),(79,30,3,1,10,10,50,12,20,89),(80,30,3,1,10,10,50,12,20,90),(81,30,3,1,10,10,50,12,20,91),(82,30,3,1,10,10,50,12,20,92),(83,30,3,1,10,10,50,12,20,93),(84,30,3,1,10,10,50,12,20,94),(85,30,3,1,10,10,50,12,20,95),(86,30,3,1,10,10,50,12,20,96),(87,30,3,1,10,10,50,12,20,97),(88,30,3,1,10,10,50,12,20,98),(89,30,3,1,10,10,50,12,20,99),(90,30,3,1,10,10,50,12,20,100),(91,30,3,1,10,10,50,12,20,101),(92,30,3,1,10,10,50,12,20,102),(93,30,3,1,10,10,50,12,20,103),(94,30,3,1,10,10,50,12,20,104),(95,30,3,1,10,10,50,12,20,105),(96,30,3,1,10,10,50,12,20,106),(97,30,3,1,10,10,50,12,20,107),(98,30,3,1,10,10,50,12,20,108),(99,30,3,1,10,10,50,12,20,109),(100,30,3,1,10,10,50,12,20,110),(101,30,3,1,10,10,50,12,20,111),(102,30,3,1,10,10,50,12,20,112),(103,30,3,1,10,10,50,12,20,113),(104,30,3,1,10,10,50,12,20,114);
/*!40000 ALTER TABLE `tbl_game_retail_parameter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_game_retail_record`
--

DROP TABLE IF EXISTS `tbl_game_retail_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_game_retail_record` (
  `game_retail_record_id` int(11) NOT NULL AUTO_INCREMENT,
  `this_time_buy` double DEFAULT NULL,
  `all_need` double DEFAULT NULL,
  `actual_sale` double DEFAULT NULL,
  `all_owe` double DEFAULT NULL,
  `delay_cost` double DEFAULT NULL,
  `begin_goods` double DEFAULT NULL,
  `receive_goods` double DEFAULT NULL,
  `total_recive_goods` double DEFAULT NULL,
  `total_up_owe_goods` double DEFAULT NULL,
  `end_goods` double DEFAULT NULL,
  `storage_cost` double DEFAULT NULL,
  `order_goods` double DEFAULT NULL,
  `total_order_goods` double DEFAULT NULL,
  `this_time_profit` double DEFAULT NULL,
  `game_id` int(11) DEFAULT NULL,
  `times` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`game_retail_record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_game_retail_record`
--

LOCK TABLES `tbl_game_retail_record` WRITE;
/*!40000 ALTER TABLE `tbl_game_retail_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_game_retail_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_game_wholesale_parameter`
--

DROP TABLE IF EXISTS `tbl_game_wholesale_parameter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_game_wholesale_parameter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `price` double NOT NULL DEFAULT '20',
  `delay_cost` double NOT NULL DEFAULT '1.5',
  `repertory_cost` double NOT NULL DEFAULT '0.3',
  `order_cost` double NOT NULL DEFAULT '15',
  `transport_cost` double NOT NULL DEFAULT '15',
  `discount` double NOT NULL DEFAULT '50',
  `origin` double NOT NULL DEFAULT '20',
  `cost` double NOT NULL DEFAULT '15',
  `game_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_game_wholesale_parameter`
--

LOCK TABLES `tbl_game_wholesale_parameter` WRITE;
/*!40000 ALTER TABLE `tbl_game_wholesale_parameter` DISABLE KEYS */;
INSERT INTO `tbl_game_wholesale_parameter` VALUES (4,20,1.5,0.3,15,15,50,20,15,14),(5,20,1.5,0.3,15,15,50,20,15,15),(6,20,1.5,0.3,15,15,50,20,15,16),(7,20,1.5,0.3,15,15,50,20,15,17),(8,20,1.5,0.3,15,15,50,20,15,18),(9,20,1.5,0.3,15,15,50,20,15,19),(10,20,1.5,0.3,15,15,50,20,15,20),(11,20,1.5,0.3,15,15,50,20,15,21),(12,20,1.5,0.3,15,15,50,20,15,22),(13,20,1.5,0.3,15,15,50,20,15,23),(14,20,1.5,0.3,15,15,50,20,15,24),(15,20,1.5,0.3,15,15,50,20,15,25),(16,20,1.5,0.3,15,15,50,20,15,26),(17,20,1.5,0.3,15,15,50,20,15,27),(18,20,1.5,0.3,15,15,50,20,15,28),(19,20,1.5,0.3,15,15,50,20,15,29),(20,20,1.5,0.3,15,15,50,20,15,30),(21,20,1.5,0.3,15,15,50,20,15,31),(22,20,1.5,0.3,15,15,50,20,15,32),(23,20,1.5,0.3,15,15,50,20,15,33),(24,20,1.5,0.3,15,15,50,20,15,34),(25,20,1.5,0.3,15,15,50,20,15,35),(26,20,1.5,0.3,15,15,50,20,15,36),(27,20,1.5,0.3,15,15,50,20,15,37),(28,20,1.5,0.3,15,15,50,20,15,38),(29,20,1.5,0.3,15,15,50,20,15,39),(30,20,1.5,0.3,15,15,50,20,15,40),(31,20,1.5,0.3,15,15,50,20,15,41),(32,20,1.5,0.3,15,15,50,20,15,42),(33,20,1.5,0.3,15,15,50,20,15,43),(34,20,1.5,0.3,15,15,50,20,15,44),(35,20,1.5,0.3,15,15,50,20,15,45),(36,20,1.5,0.3,15,15,50,20,15,46),(37,20,1.5,0.3,15,15,50,20,15,47),(38,20,1.5,0.3,15,15,50,20,15,48),(39,20,1.5,0.3,15,15,50,20,15,49),(40,20,1.5,0.3,15,15,50,20,15,50),(41,20,1.5,0.3,15,15,50,20,15,51),(42,20,1.5,0.3,15,15,50,20,15,52),(43,20,1.5,0.3,15,15,50,20,15,53),(44,20,1.5,0.3,15,15,50,20,15,54),(45,20,1.5,0.3,15,15,50,20,15,55),(46,20,1.5,0.3,15,15,50,20,15,56),(47,20,1.5,0.3,15,15,50,20,15,57),(48,20,1.5,0.3,15,15,50,20,15,58),(49,20,1.5,0.3,15,15,50,20,15,59),(50,20,1.5,0.3,15,15,50,20,15,60),(51,20,1.5,0.3,15,15,50,20,15,61),(52,20,1.5,0.3,15,15,50,20,15,62),(53,20,1.5,0.3,15,15,50,20,15,63),(54,20,1.5,0.3,15,15,50,20,15,64),(55,20,1.5,0.3,15,15,50,20,15,65),(56,20,1.5,0.3,15,15,50,20,15,66),(57,20,1.5,0.3,15,15,50,20,15,67),(58,20,1.5,0.3,15,15,50,20,15,68),(59,20,1.5,0.3,15,15,50,20,15,69),(60,20,1.5,0.3,15,15,50,20,15,70),(61,20,1.5,0.3,15,15,50,20,15,71),(62,20,1.5,0.3,15,15,50,20,15,72),(63,20,1.5,0.3,15,15,50,20,15,73),(64,20,1.5,0.3,15,15,50,20,15,74),(65,20,1.5,0.3,15,15,50,20,15,75),(66,20,1.5,0.3,15,15,50,20,15,76),(67,20,1.5,0.3,15,15,50,20,15,77),(68,20,1.5,0.3,15,15,50,20,15,78),(69,20,1.5,0.3,15,15,50,20,15,79),(70,20,1.5,0.3,15,15,50,20,15,80),(71,20,1.5,0.3,15,15,50,20,15,81),(72,20,1.5,0.3,15,15,50,20,15,82),(73,20,1.5,0.3,15,15,50,20,15,83),(74,20,1.5,0.3,15,15,50,20,15,84),(75,20,1.5,0.3,15,15,50,20,15,85),(76,20,1.5,0.3,15,15,50,20,15,86),(77,20,1.5,0.3,15,15,50,20,15,87),(78,20,1.5,0.3,15,15,50,20,15,88),(79,20,1.5,0.3,15,15,50,20,15,89),(80,20,1.5,0.3,15,15,50,20,15,90),(81,20,1.5,0.3,15,15,50,20,15,91),(82,20,1.5,0.3,15,15,50,20,15,92),(83,20,1.5,0.3,15,15,50,20,15,93),(84,20,1.5,0.3,15,15,50,20,15,94),(85,20,1.5,0.3,15,15,50,20,15,95),(86,20,1.5,0.3,15,15,50,20,15,96),(87,20,1.5,0.3,15,15,50,20,15,97),(88,20,1.5,0.3,15,15,50,20,15,98),(89,20,1.5,0.3,15,15,50,20,15,99),(90,20,1.5,0.3,15,15,50,20,15,100),(91,20,1.5,0.3,15,15,50,20,15,101),(92,20,1.5,0.3,15,15,50,20,15,102),(93,20,1.5,0.3,15,15,50,20,15,103),(94,20,1.5,0.3,15,15,50,20,15,104),(95,20,1.5,0.3,15,15,50,20,15,105),(96,20,1.5,0.3,15,15,50,20,15,106),(97,20,1.5,0.3,15,15,50,20,15,107),(98,20,1.5,0.3,15,15,50,20,15,108),(99,20,1.5,0.3,15,15,50,20,15,109),(100,20,1.5,0.3,15,15,50,20,15,110),(101,20,1.5,0.3,15,15,50,20,15,111),(102,20,1.5,0.3,15,15,50,20,15,112),(103,20,1.5,0.3,15,15,50,20,15,113),(104,20,1.5,0.3,15,15,50,20,15,114);
/*!40000 ALTER TABLE `tbl_game_wholesale_parameter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_game_wholesaler_record`
--

DROP TABLE IF EXISTS `tbl_game_wholesaler_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_game_wholesaler_record` (
  `game_retail_record_id` int(11) NOT NULL AUTO_INCREMENT,
  `this_time_buy` double DEFAULT NULL,
  `all_need` double DEFAULT NULL,
  `actual_sale` double DEFAULT NULL,
  `all_owe` double DEFAULT NULL,
  `delay_cost` double DEFAULT NULL,
  `begin_goods` double DEFAULT NULL,
  `receive_goods` double DEFAULT NULL,
  `total_recive_goods` double DEFAULT NULL,
  `total_up_owe_goods` double DEFAULT NULL,
  `end_goods` double DEFAULT NULL,
  `storage_cost` double DEFAULT NULL,
  `order_goods` double DEFAULT NULL,
  `total_order_goods` double DEFAULT NULL,
  `this_time_profit` double DEFAULT NULL,
  `game_id` int(11) DEFAULT NULL,
  `times` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`game_retail_record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_game_wholesaler_record`
--

LOCK TABLES `tbl_game_wholesaler_record` WRITE;
/*!40000 ALTER TABLE `tbl_game_wholesaler_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_game_wholesaler_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_user`
--

DROP TABLE IF EXISTS `tbl_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `password` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `first_name` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `last_name` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `student_id` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `gender` varchar(1) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `grade` int(11) DEFAULT NULL,
  `play_game_times` int(11) DEFAULT '0',
  `last_login_time` datetime DEFAULT NULL,
  `use_tool_times` int(11) DEFAULT '0',
  `in_game` int(11) DEFAULT '0',
  `game_room_id` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_user`
--

LOCK TABLES `tbl_user` WRITE;
/*!40000 ALTER TABLE `tbl_user` DISABLE KEYS */;
INSERT INTO `tbl_user` VALUES (13,'jiangliwu','100200','速度','?','2010052827','?',0,0,NULL,0,0,0),(14,'vainner','100200','无','名','2010052829','男',0,0,NULL,0,0,0),(15,'ipple','100200','无','名','123123451','女',0,0,NULL,0,0,0);
/*!40000 ALTER TABLE `tbl_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_user_game`
--

DROP TABLE IF EXISTS `tbl_user_game`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_user_game` (
  `user_game_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `game_role` int(1) NOT NULL,
  `game_id` int(11) NOT NULL,
  `game_holder` int(1) NOT NULL,
  PRIMARY KEY (`user_game_id`),
  KEY `user_idx` (`user_id`),
  KEY `game_idx` (`game_id`),
  CONSTRAINT `game` FOREIGN KEY (`game_id`) REFERENCES `tbl_game` (`game_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_user_game`
--

LOCK TABLES `tbl_user_game` WRITE;
/*!40000 ALTER TABLE `tbl_user_game` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_user_game` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-03-24  3:25:53
