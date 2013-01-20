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
  `start_time` datetime NOT NULL,
  `end_time` datetime DEFAULT NULL,
  PRIMARY KEY (`game_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_game`
--

LOCK TABLES `tbl_game` WRITE;
/*!40000 ALTER TABLE `tbl_game` DISABLE KEYS */;
INSERT INTO `tbl_game` VALUES (5,'2013-01-21 01:08:00','2013-01-21 01:08:00'),(6,'2013-01-21 01:08:07','2013-01-21 01:08:07'),(7,'2013-01-21 01:09:15','2013-01-21 01:09:15'),(8,'2013-01-21 01:12:08','2013-01-21 01:12:08'),(9,'2013-01-21 01:12:14','2013-01-21 01:12:14');
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_game_producer_parameter`
--

LOCK TABLES `tbl_game_producer_parameter` WRITE;
/*!40000 ALTER TABLE `tbl_game_producer_parameter` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_game_retail_parameter`
--

LOCK TABLES `tbl_game_retail_parameter` WRITE;
/*!40000 ALTER TABLE `tbl_game_retail_parameter` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_game_wholesale_parameter`
--

LOCK TABLES `tbl_game_wholesale_parameter` WRITE;
/*!40000 ALTER TABLE `tbl_game_wholesale_parameter` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_user`
--

LOCK TABLES `tbl_user` WRITE;
/*!40000 ALTER TABLE `tbl_user` DISABLE KEYS */;
INSERT INTO `tbl_user` VALUES (13,'jiangliwu','100200','?','?','2010052827','?',0,0,NULL,0,0,0);
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
  CONSTRAINT `user` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `game` FOREIGN KEY (`game_id`) REFERENCES `tbl_game` (`game_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
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

-- Dump completed on 2013-01-21  1:17:14
