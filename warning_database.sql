CREATE DATABASE  IF NOT EXISTS `warning` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `warning`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: warning
-- ------------------------------------------------------
-- Server version	5.7.12-log

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
-- Table structure for table `atm`
--

DROP TABLE IF EXISTS `atm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `atm` (
  `atm_id` int(11) NOT NULL AUTO_INCREMENT,
  `atm_latitude` double NOT NULL,
  `atm_longitude` double NOT NULL,
  `atm_title` varchar(100) NOT NULL,
  `atm_snippet` varchar(200) NOT NULL,
  PRIMARY KEY (`atm_id`),
  KEY `Fk_Category_Atm_idx` (`atm_title`)
) ENGINE=InnoDB AUTO_INCREMENT=129 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atm`
--

LOCK TABLES `atm` WRITE;
/*!40000 ALTER TABLE `atm` DISABLE KEYS */;
INSERT INTO `atm` VALUES (1,21.003471,105.848996,'AgriBank','54, Lê Thanh Nghị, Phường Bách Khoa, Quận Hai Bà Trưng, Hà Nội, Việt Nam'),(2,21.00124,105.847903,'AgriBank','Trong Viện Đại học Mở, Nguyễn Hiền, TT Bách Khoa, Bách Khoa, Hai Bà Trưng'),(3,21.008916,105.829766,'AgriBank','Ngõ 82 Phạm Ngọc Thạch, Quang Trung, Đống Đa, Hà Nội, Việt Nam'),(4,21.018128,105.812023,'AgriBank','27 Huỳnh Thúc Kháng, Thành Công, Đống Đa, Hà Nội, Việt Nam'),(5,21.02255,105.818865,'AgriBank','2, Láng Hạ, Quận Ba Đình, Hà Nội, Việt Nam'),(6,21.026763,105.801975,'AgriBank','1194, Đường Láng, Phường Láng Thượng, Quận Đống Đa, Hà Nội'),(7,20.998305,105.812678,'AgriBank','212 Nguyễn Trãi, Thượng Đình, Thanh Xuân, Hà Nội, Việt Nam'),(8,21.00161,105.817601,'AgriBank','52, Nguyễn Trãi, Thượng Đình, Thanh Xuân, Hà Nội'),(9,20.996063,105.861636,'AgriBank','201 Minh Khai, Hai Bà Trưng, Hà Nội, Việt Nam'),(10,20.997371,105.850025,'AgriBank','486, Bạch Mai, Phường Trương Định, Quận Hai Bà Trưng, Trương Định, Hai Bà Trưng, Hà Nội'),(11,21.003732,105.841566,'VietinBank','55 Giải Phóng, Hai Bà Trưng, Hà Nội'),(12,21.004969,105.845352,'VietinBank','Trường đại học Bách Khoa Hà Nội, Bách Khoa, Hai Bà Trưng, Hà Nội'),(13,21.002652,105.836056,'VietinBank','79, Phố Lương Định Của, Phường Phương Mai, Quận Đống Đa, Hà Nội'),(14,21.006484,105.838859,'VietinBank','7, Đường Đào Duy Anh, Phường Phương Mai, Quận Đống Đa, Hà Nội'),(15,21.009302,105.851139,'VietinBank','Kiốt Số 1, Phố Huế, Phường Cầu Dền, Quận Hai Bà Trưng, Hà Nội'),(16,21.038625,105.81596,'VietinBank','121, Đường Văn Cao, Phường Liễu Giai, Quận Ba Đình, Hà Nội'),(17,21.019669,105.767684,'VietinBank','Khu Nhà B6, Phường Mỹ Đình I, Huyện Từ Liêm, Hà Nội, Việt Nam'),(18,21.028522,105.778734,'VietinBank','Bến Xe Khách Mỹ Đình, Đường Phạm Hùng, Xã Mỹ Đình, Huyện Từ Liêm, Hà Nội'),(19,21.045978,105.796552,'VietinBank','239, Đường Hoàng Quốc Việt, Phường Nghĩa Tân, Quận Cầu Giấy, Hà Nội'),(20,21.045793,105.790174,'VietinBank','1, Nguyễn Phong Sắc, Nghĩa Tân, Cầu Giấy, Hà Nội'),(21,20.998692,105.845518,'VietcomBank','217, Trần Đại Nghĩa, Bách Khoa, Hai Bà Trưng, Hà Nội'),(22,21.003434,105.836339,'VietcomBank','Số 75 Phương Mai, Đống Đa, Hà Nội, Việt Nam'),(23,21.005992,105.831395,'VietcomBank','Số 105 A2 Khương Thượng, Đông Tác, Trung Tự, Đống Đa, Hà Nội'),(24,21.020673,105.84806,'VietcomBank','Số 58 Trần Quốc Toản, Trần Hưng Đạo, Hoàn Kiếm, Hà Nội, Việt Nam'),(25,21.020908,105.852262,'VietcomBank','Số 49 Hàng Bài, Hoàn Kiếm, Hà Nội, Việt Nam'),(26,21.026122,105.856448,'VietcomBank','Số 36, Phố Lý Thái Tổ, Phường Lý Thái Tổ, Quận Hoàn Kiếm, Hà Nội, Việt Nam'),(27,21.032352,105.851774,'VietcomBank','Số 110, Phố Cầu Gỗ, Phường Hàng Bạc, Quận Hoàn Kiếm, Hà Nội, Việt Nam'),(28,21.030557,105.843313,'VietcomBank','Số 34B, Phố Trần Phú, Phường Điện Biên, Quận Ba Đình, Hà Nội, Việt Nam'),(29,21.031421,105.855757,'VietcomBank','Số 22, Phố Lò Sũ, Phường Lý Thái Tổ, Quận Hoàn Kiếm, Hà Nội, Việt Nam'),(30,21.044565,105.842172,'VietcomBank','Số 50B, Phố Châu Long, Phường Trúc Bạch, Quận Ba Đình, Hà Nội, Việt Nam'),(31,21.024306,105.854749,'VietcomBank','31-33, Phố Ngô Quyền, Phường Hàng Bài, Quận Hoàn Kiếm, Hà Nội, Việt Nam'),(32,21.01713,105.814975,'VietcomBank','6B, Phố Láng Hạ, Phường Thành Công, Quận Ba Đình, Hà Nội, Việt Nam'),(33,21.024653,105.819259,'VietcomBank','Số 172, Ngọc Khánh, Giảng Võ, Ba Đình, Hà Nội, Việt Nam'),(34,21.046213,105.796092,'VietcomBank','Số 98, Hoàng Quốc Việt, Nghĩa Đô, Cầu Giấy, Hà Nội, Việt Nam'),(35,20.989381,105.845964,'VietcomBank','Số 106, Phố Nguyễn An Ninh, Phường Tương Mai, Quận Hoàng Mai, Tương Mai, Hoàng Mai, Hà Nội'),(36,21.001907,105.845386,'TechcomBank','Ngân Hàng Tmcp Kỹ Thương Việt Nam (Techcombank) - Pgd Bách Khoa'),(37,21.013426,105.81932,'TechcomBank','Số 192, Thái Hà, Đống Đa, Hà Nội, Việt Nam'),(38,21.024653,105.819259,'TechcomBank','Số 172, Ngọc Khánh, Giảng Võ, Ba Đình, Hà Nội, Việt Nam'),(39,21.032477,105.799083,'TechcomBank','Số 157, Cầu Giấy, Quan Hoa, Cầu Giấy, Hà Nội, Việt Nam'),(40,21.037292,105.801726,'TechcomBank','Số 112, Nguyễn Khánh Toàn, Phường Quan Hoa, Quận Cầu Giấy, Hà Nội, Việt Nam'),(41,21.035387,105.792291,'TechcomBank','Số 333, Cầu Giấy, Hà Nội, Việt Nam'),(42,21.046552,105.796016,'TechcomBank','Số 98, Đường Hoàng Quốc Việt, Phường Nghĩa Đô, Quận Cầu Giấy, Hà Nội'),(43,20.990272,105.801911,'TechcomBank','Số 467, Nguyễn Trãi, Tnh Xuân Nam Thanh Xuân Hà, Thanh Xuân Nam, Thanh Xuân, Hanoi'),(44,21.033671,105.778412,'TechcomBank','Số 9, Trần Bình, Mai Dịch, Cầu Giấy, Hà Nội'),(45,21.023167,105.801553,'TechcomBank','Số 126, Chùa Láng, Phường Láng Thượng, Quận Đống Đa, Hà Nội, Việt Nam'),(46,21.022777,105.808105,'TechcomBank','Số 35, Chùa Láng, Phường Láng Thượng, Quận Đống Đa, Hà Nội, Việt Nam'),(47,20.998695,105.846115,'VP Bank','Số 168, Phố Trần Đại Nghĩa, Phường Đồng Tâm, Quận Hai Bà Trưng, Hà Nội, Việt Nam'),(48,20.989071,105.841328,'VP Bank','667-669 Giải Phóng, Giáp Bát, Hoàng Mai, Hà Nội, Việt Nam'),(49,21.004969,105.845352,'VP Bank','Trường đại học Bách Khoa Hà Nội, Bách Khoa, Hai Bà Trưng, Hà Nội'),(50,21.003524,105.847906,'VP Bank','Số 92, Lê Thanh Nghị, Bách Khoa, Hai Bà Trưng, Hà Nội'),(51,21.009958,105.851229,'VP Bank','Số 362, Đường Phố Huế, Phường Phố Huế, Quận Hai Bà Trưng, Hà Nội'),(52,21.043169,105.823161,'VP Bank','Số 152 Thụy Khuê, Tây Hồ, Hà Nội, Việt Nam'),(53,21.022133,105816120,'VP Bank','Số 07, Đường Thành Công, Phường Thành Công, Quận Ba Đình, Hà Nội'),(54,21.023861,105.846548,'VP Bank','Số 4, Phố Dã Tượng, Phường Trần Hưng Đạo, Quận Hoàn Kiếm, Hà Nội'),(55,21.030692,105.855052,'VP Bank','Số 30, Phố Lý Thái Tổ, Phường Lý Thái Tổ, Quận Hoàn Kiếm, Hà Nội'),(56,21.006668,105.80567,'VP Bank','Tòa Nhà 18T2 Khu ĐT Phố Lê Văn Lương,, Trung Hòa Nhân Chính, Thanh Xuân, Hà Nội'),(57,21.000965,105.845145,'BIDV','Số 119, Đường Trần Đại Nghĩa, Quận Hai Bà Trưng, Hà Nội'),(58,20.999881,105.837583,'BIDV','Tòa nhà HH1, Ngõ 102 Trường Chinh, Phương Mai, Đống Đa, Hà Nội, Việt Nam'),(59,21.003058,105.830063,'BIDV','Nhà E4, 1 Tôn Thất Tùng, Trung Tự, Đống Đa, Hà Nội, Việt Nam'),(60,21.021212,105.849963,'BIDV','Số 64,Bà Triệu, Quận Hoàn Kiếm, Hà Nội'),(61,21.024105,105.853775,'BIDV','Số 24, Đường Hai Bà Trưng, Quận Hoàn Kiếm, Hà Nội, Việt Nam'),(62,21.017805,105.851666,'BIDV','Số 179, Đường Phố Huế, Quận Hoàn Kiếm, Hà Nội'),(63,21.010826,105.799828,'BIDV','Số 111, Đường Trần Duy Hưng, Quận Cầu Giấy, Hà Nội, Việt Nam'),(64,21.034322,105.795706,'BIDV','Số 263, Cầu Giấy, Dịch Vọng, Cầu Giấy, Hà Nội, Việt Nam'),(65,21.04631,105.786192,'BIDV','Số 106, Đường Hoàng Quốc Việt, Quận Cầu Giấy, Hà Nội, Việt Nam'),(66,21.046494,105.792787,'BIDV','Số 120, Đường Hoàng Quốc Việt, Quận Cầu Giấy, Hà Nội, Việt Nam'),(67,20.984685,105.846709,'BIDV','Số 489, Đường Trương Định, Quận Hoàng Mai, Hà Nội, Việt Nam'),(68,21.00593,105.830923,'SacomBank','Số 2, Tôn Thất Tùng, Kim Liên, Đống Đa, Hà Nội, Việt Nam'),(69,21.025393,105.821957,'SacomBank','Số 148, Giảng Võ, Ba Đình, Hà Nội, Việt Nam'),(70,21.043481,105.821443,'SacomBank','Số 153, Thụy Khuê, Tây Hồ, Hà Nội, Việt Nam'),(71,21.023435,105.852939,'SacomBank','Số 27, Hàng Bài, Hoàn Kiếm, Hà Nội'),(72,21.026312,105.850876,'SacomBank','Số 11, Tràng Thi, Hàng Trống, Hoàn Kiếm, Hà Nội'),(73,21.022012,105.850496,'SacomBank','Số 45, Bà Triệu, Hàng Bài, Hoàn Kiếm, Hà Nội'),(74,21.032436,105.850461,'SacomBank','Số 47, Phố Lương Văn Can, Phường Hàng Gai, Quận Hoàn Kiếm, Hà Nội'),(75,21.032478,105.854584,'SacomBank','Số 90, Phố Nguyễn Hữu Huân, Phường Lý Thái Tổ, Quận Hoàn Kiếm, Hà Nội'),(76,21.015327,105.853633,'SacomBank','Số 66, Hòa Mã, Ngô Thì Nhậm, Hai Bà Trưng, Hà Nội'),(77,21.032474,105.854521,'SacomBank','Số 90, Nguyễn Hữu Huân, Lý Thái Tổ, Hoàn Kiếm, Hà Nội'),(78,21.031357,105.840931,'Dong A Bank','Số 28, Đường Điện Biên Phủ, Phường Điện Biên, Quận Ba Đình, Hà Nội'),(79,21.022381,105.819306,'Dong A Bank','Số 3 Láng Hạ, Thành Công, Ba Đình, Hà Nội, Việt Nam'),(80,20.989884,105.801814,'Dong A Bank','Số 473, Đường Nguyễn Trãi, Phường Thanh Xuân Nam, Quận Thanh Xuân, Hà Nội'),(81,21.021356,105.850082,'Dong A Bank','60 Bà Triệu, Hàng Bài, Hoàn Kiếm, Hà Nội, Việt Nam'),(82,21.005383,105.851589,'Dong A Bank','Số 173, Đường Bạch Mai, Phường Cầu Dền, Quận Hai Bà Trưng, Hà Nội'),(83,20.995697,105.860275,'Dong A Bank','Số 199, Minh Khai, Hai Bà Trưng, Hà Nội'),(84,21.01778,105.829934,'Dong A Bank','Số 473, Đường Nguyễn Trãi, Quận Thanh Xuân,Tp Hà Nội'),(85,21.013469,105.82779,'Dong A Bank','Số 181, Phố Nguyễn Lương Bằng, Quận Đống Đa, Hà Nội'),(86,21.034936,105.789285,'Dong A Bank','Số 31 Trần Thái Tông, Dịch Vọng Hậu, Cầu Giấy, Hà Nội, Việt Nam'),(87,21.042382,105.840442,'Dong A Bank','Số 11, Phố Nguyễn Biểu, Quận Ba Đình, Tp Hà Nội, Việt Nam'),(109,21.005051,105.850667,'OCB','Số 208, Đường Bạch Mai, Phường Cầu Dền, Quận Hai Bà Trưng, Hà Nội'),(110,21.00444,105.840626,'OCB','Số 1, Phố Phương Mai, Phường Phương Mai, Quận Đống Đa, Hà Nội'),(111,20.99695,105.849827,'OCB','Số 512, Đường Bạch Mai, Phường Trương Định, Quận Hai Bà Trưng, Hà Nội'),(112,21.01215,105.849283,'OCB','Số 191, Phố Bà Triệu, Phường Lê Đại Hành, Quận Hai Bà Trưng, Hà Nội'),(113,21.008355,105.823603,'OCB','Số 224, Đường Tây Sơn, Phường Trung Liệt, Quận Đống Đa, Hà Nội'),(114,21.027327,105.824732,'OCB','Số 185, Phố Giảng Võ, Phường Cát Linh, Quận Đống Đa, Hà Nội'),(115,21.030561,105.84644,'OCB','Số 17, Phố Hàng Da, Phường Hàng Bông, Quận Hoàn Kiếm, Hà Nội'),(116,21.00379,105.821783,'OCB','Số 319, Đường Tây Sơn, Phường Ngã Tư Sở, Quận Đống Đa, Hà Nội'),(117,21.03222,105.798639,'OCB','Số 157, Đường Cầu Giấy, Phường Quan Hoa, Quận Cầu Giấy, Hà Nội'),(118,21.037308,105.801809,'ACB','Số 96, Nguyễn Khánh Toàn, Quan Hoa, Cầu Giấy, Hà Nội, Việt Nam'),(119,21.008333,105.852539,'ACB','Số 499, Trần Khát Chân, Phường Thanh Nhàn, Quận Hai Bà Trưng, TP Hà Nội'),(120,21.012183,105.858761,'ACB','Số 166, Lo Duc Street, Hai Ba Trung District, Ha Noi City'),(121,21.02774,105.812301,'ACB','Số 33, Nguyễn Chí Thanh, Ba Đình, Hà Nội'),(122,21.021037,105.844,'ACB','Số 97, Trần Quốc Toản, Hoàn Kiếm, Hà Nội'),(123,21.042144,105.825528,'ACB','Số 115, Đường Thụy Khuê, Q Tây Hồ, Tp Hà Nội'),(124,21.002401,105.822411,'ACB','Số 321, Trường Chinh, Thanh Xuân, Hà Nội'),(125,21.025142,105.822059,'ACB','Số 211, Giảng Võ, Cát Linh, Đống Đa, Hà Nội'),(126,21.029793,105.835244,'ACB','Số 32, Tôn Đức Thắng Q. Đống Đa, Tp. Hà Nội'),(127,21.007417,105.805493,'ACB','Số 52, Nguyễn Thị Định, Nhân Chính, Thanh Xuân, Hà Nội'),(128,21.032171,105.839969,'OCB','Số 28A, Đường Điện Biên Phủ, Phường Điện Biên, Quận Ba Đình, Hà Nội, Việt Nam');
/*!40000 ALTER TABLE `atm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `banking_atm`
--

DROP TABLE IF EXISTS `banking_atm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `banking_atm` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `banking_atm_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `banking_atm`
--

LOCK TABLES `banking_atm` WRITE;
/*!40000 ALTER TABLE `banking_atm` DISABLE KEYS */;
INSERT INTO `banking_atm` VALUES (10,'ATM AgriBank'),(11,'ATM VietinBank'),(12,'ATM VietcomBank'),(13,'ATM TechcomBank'),(14,'ATM VP Bank'),(15,'ATM BIDV'),(16,'ATM SacomBank'),(17,'ATM Dong A Bank'),(18,'ATM Dong Phuong Bank (OCB)'),(19,'ATM A Chau Bank ( ACB )');
/*!40000 ALTER TABLE `banking_atm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coffee`
--

DROP TABLE IF EXISTS `coffee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coffee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `coffee_latitude` double NOT NULL,
  `coffee_longtitude` double NOT NULL,
  `coffee_title` varchar(100) NOT NULL,
  `coffee_snippet` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coffee`
--

LOCK TABLES `coffee` WRITE;
/*!40000 ALTER TABLE `coffee` DISABLE KEYS */;
INSERT INTO `coffee` VALUES (30,21.032647,105.788877,'Jima Cafe','70 Trần Thái Tông, Dịch Vọng Hậu, Cầu Giấy, Hà Nội, Việt Nam'),(31,21.033021,105.854542,'Cafe Hạnh','Ngõ 39 Nguyễn Hữu Huân, Quận Hoàn Kiếm, Hà Nội'),(32,21.015539,105.855096,'Cora Cafe','24 Hòa Mã , Quận Hai Bà Trưng, Hà Nội'),(33,21.02885,105.842909,'Xcoffee','11 Điện Biên Phủ, Cửa Nam, Hoàn Kiếm, Hà Nội, Việt Nam'),(34,21.031799,105.852429,'Ifeel cafe','19 Đinh Tiên Hoàng, Hàng Bạc, Hoàn Kiếm, Hà Nội, Việt Nam'),(35,21.032086,105.851912,'Cafe Dinh','13 Đinh Tiên Hoàng, Hàng Bạc, Hoàn Kiếm, Hà Nội, Việt Nam'),(36,21.032183,105.851932,'Trung Nguyen Coffee','7 Đinh Tiên Hoàng, Hàng Bạc, Hoàn Kiếm, Hà Nội, Việt Nam'),(37,21.032242,105.85118,'Cafe Pho Co','11 Hàng Gai, Hàng Trống, Hoàn Kiếm Hàng Trống Hoàn Kiếm Hà Nội, VietNam'),(38,21.032194,105.851426,'Coffee Club','3 Lê Thái Tổ, Hàng Trống, Hoàn Kiếm, Hà Nội, Việt Nam'),(39,21.032533,105.850889,'Rock Billy Coffee','54, Đường Lương Văn Can, Phường Hàng Đào, Quận Hoàn Kiếm, Thành Phố Hà Nội, Việt Nam'),(40,21.031216,105.85587,'Tony’s Cofee','29 Lò Sũ Lý Thái Tổ, Lý Thái Tổ, Hoàn Kiếm, HANOI CITY 100000, Việt Nam'),(41,21.032336,105.855264,'Music Coffee','7 Hàng Thùng, Lý Thái Tổ, Hoàn Kiếm, Hà Nội 100000, Việt Nam'),(42,21.024065,105.853098,'The Coffee House','23M Hai Bà Trưng, Quận Hoàn Kiếm, Hà Nội'),(43,21.020904,105.833412,'Dep Coffee','21 Đường ven hồ Văn Chương, Thổ Quan, Đống Đa, Hà Nội, Việt Nam'),(44,21.013647,105.850411,'Trieu Viet Vuong Coffee','152 Triệu Việt Vương, Hai Bà Trưng, Hà Nội, Việt Nam'),(45,21.013569,105.850103,'Aha Coffee','Số 46, Tô Hiến Thành, P. Bùi Thị Xuân, Q. Hai Bà Trưng, Hà Nội Việt Nam'),(46,21.01365,105.850472,'Toan Coffee','127 Triệu Việt Vương, Bùi Thị Xuân, Hai Bà Trưng, Hà Nội, Việt Nam'),(47,21.013512,105.850496,'Paris Gateaux','22 Tô Hiến Thành, Lê Đại Hành, Hai Bà Trưng, Hà Nội, Việt Nam'),(48,21.013715,105.85054,'Pho Hoa Coffee','121 Triệu Việt Vương, Bùi Thị Xuân, Hai Bà Trưng, Hà Nội, Việt Nam'),(49,21.014093,105.850508,'Tho Coffee','117 Triệu Việt Vương, Bùi Thị Xuân, Hai Bà Trưng, Hà Nội, Việt Nam'),(50,20.992962,105.849466,'Likes Cafe','2 ngõ Trại Cá 118 Trương Định, đường Trương Định, phường Trương Định, Hai Bà Trưng, Hà Nội, Việt Nam'),(51,20.9922,105.849939,'131 Coffee','131, Đường Trương Định, Quận Hai Bà Trưng, Hà Nội, Việt Nam'),(52,21.001856,105.849388,'Cay Xang Cafe','101 E5 Ngõ 29 Tạ Quang Bửu, Bách Khoa, Hai Bà Trưng,Hà Nội, Việt Nam'),(53,21.014032,105.851649,'Trung Coffee','155 Huế, Ngô Thì Nhậm, Hai Bà Trưng, Hà Nội, Việt Nam'),(54,21.013291,105.850297,'Zodi Cafe','156 Triệu Việt Vương, Bùi Thị Xuân, Hai Bà Trưng, Hà Nội, Việt Nam'),(55,21.015244,105.850296,'Big Ben Cafe','32 Tuệ Tĩnh Bùi Thị Xuân Hai Bà Trưng Bùi Thị Xuân Hai Bà Trưng Hà Nội Vietnam, Việt Nam'),(56,21.017047,105.850451,'Thai Cafe','27 Triệu Việt Vương, Bùi Thị Xuân, Hai Bà Trưng, Hà Nội, Việt Nam'),(57,21.005767,105.845804,'Moc Coffee','Trần Đại Nghĩa, Hai Bà Trưng, Hà Nội, Việt Nam'),(58,21.010592,105.848962,'Starbucks Coffee Ba Trieu','314 Bà Triệu, Lê Đại Hành, Hai Bà Trưng, Hà Nội, Việt Nam'),(59,20.986849,105.859019,'Phim 3D Bach Khoa Coffee','Số 11 ngách 4 ngõ 33, Lê Thanh Nghị, Quận Hai Bà Trưng, Hà Nội, Việt Nam'),(60,21.036339,105.783149,'Starbucks Coffee IPH','241 Xuân Thủy, Dịch Vọng Hậu Cầu Giấy Hà Nội, Việt Nam'),(61,21.04635,105.79532,'Highlands Coffee Somerset','106 Hoàng Quốc Việt, Nghĩa Đô, Cầu Giấy, Hà Nội, Việt Nam'),(62,21.034924,105.79604,'Urban Station Coffee','262 Cầu Giấy, Quan Hoa, Cầu Giấy, Hà Nội, Việt Nam'),(63,21.041064,105.797757,'Helio Coffee Vietnam Museum of Ethnology','66 Nguyễn Văn Huyên, Quan Hoa, Cầu Giấy, Hà Nội, Việt Nam'),(64,21.040789,105.792316,'Trinh Ca Coffee','Ngõ 215 Tô Hiệu, Cầu Giấy, Hanoi, Việt Nam'),(65,21.021646,105.809258,'Star cofee','62 Nguyễn Chí Thanh, Láng Thượng, Đống Đa, Hà Nội, Việt Nam'),(66,21.022246,105.825781,'Nha Am coffee','Số 2, Ngõ 45 Hào Nam, Ô Chợ Dừa, Đống Đa, Hanoi, Việt Nam'),(67,21.017419,105.813314,'Trung Nguyen coffee','19 Huỳnh Thúc Kháng, Láng Hạ, Đống Đa, Hà Nội, Việt Nam'),(68,21.017542,105.806628,'Maxx coffee','74 Nguyễn Chí Thanh, Láng Thượng, Đống Đa, Hà Nội, Việt Nam');
/*!40000 ALTER TABLE `coffee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `petrol_station`
--

DROP TABLE IF EXISTS `petrol_station`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `petrol_station` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `petrol_latitude` double NOT NULL,
  `petrol_longitude` double NOT NULL,
  `petrol_title` varchar(100) NOT NULL,
  `petrol_snippet` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=147 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `petrol_station`
--

LOCK TABLES `petrol_station` WRITE;
/*!40000 ALTER TABLE `petrol_station` DISABLE KEYS */;
INSERT INTO `petrol_station` VALUES (121,21.022818,105.819689,'Cửa hàng xăng dầu Thành Công','1A, Láng Hạ, Phường Thành Công, Quận Ba Đình, Hà Nội'),(122,21.015371,105.809192,'Cây Xăng Vũ Ngọc Phan','Vũ Ngọc Phan, Láng Hạ, Đống Đa, Hà Nội, Việt Nam'),(123,21.044411,105.846093,'Cửa hàng xăng dầu số 5 (Có xăng RON A95)','Số 1, Hàng Bún, Phường Nguyễn Trung Trực, Quận Ba Đình, Hà Nội'),(124,20.997802,105.867372,'Cửa hàng Xăng Dầu Petrolimex','Số 484 Minh Khai, Vĩnh Tuy, Hai Bà Trưng, Hà Nội, Việt Nam'),(125,21.002075,105.849227,'Cửa hàng xăng dầu Bách Khoa','Số 29 Tạ Quang Bửu, Khu tập thể Bách Khoa, Bách Khoa, Hai Bà Trưng, Hà Nội, Việt Nam'),(126,21.01995,105.816227,'Cửa hàng xăng dầu số 19','Số 1, Thành Công, Phường Thành Công, Quận Ba Đình, Hà Nội, Việt Nam'),(127,21.050121,105.807204,'Cửa hàng xăng dầu Lạc Long Quân','Số 163, Lạc Long Quân, Phường Nghĩa Đô, Quận Cầu Giấy, Hà Nội, Việt Nam'),(128,21.036166,105.785811,'Cửa hàng xăng Cầu Giấy','Số 171, Xuân Thủy, Phường Quan Hoa, Quận Cầu Giấy, Hà Nội, Việt Nam'),(129,21.000753,105.828396,'Đại lý công ty xăng dầu quân đội','Số 171 Trường Chinh, Khương Mai, Thanh Xuân, Hà Nội, Việt Nam'),(130,21.046427,105.790455,'Cửa hàng xăng dầu Nghĩa Tân','Số 148, Hoàng Quốc Việt, Phường Nghĩa Tân, Quận Cầu Giấy, Hà Nội'),(131,21.046016,105.791648,'Cửa hàng xăng dầu số 62','Số 389, Hoàng Quốc Việt, Phường Nghĩa Tân, Quận Cầu Giấy, Hà Nội'),(132,21.019457,105.832448,'Cửa hàng xăng dầu','Số 233, Khâm Thiên, Thổ Quan, Đống Đa, Hà Nội, Việt Nam'),(133,21.020608,105.80144,'Cửa hàng xăng dầu đường Láng','Số 902, Đường Láng, Phường Láng Hạ, Quận Đống Đa, Hà Nội, Việt Nam'),(134,20.985254,105.841194,'Cây xăng - 18 Giải Phóng','Số 18, Giải Phóng, Phường Phương Mai, Quận Đống Đa, Hà Nội, Việt Nam'),(135,21.01353,105.815642,'Trạm xăng dầu Thái Thịnh','Số 194, Thái Thịnh, Láng Hạ, Đống Đa, Hà Nội, Việt Nam'),(136,20.995907,105.860958,'Cây Xăng 199 Minh Khai','Số 199, Minh Khai, Hai Bà Trưng, Hà Nội, Việt Nam'),(137,21.020114,105.816285,'Xí Nghiệp Bán Lẻ Xăng Dầu Hà Nội','S1, Phố Thành Công, Phường Thành Công, Quận Ba Đình, Hà Nội, Việt Nam'),(138,21.013534,105.81565,'Cửa hàng xăng dầu PV','Số Số 194, Thái Thịnh, Phường Láng Hạ, Quận Đống Đa, Hà Nội, Việt Nam'),(139,20.997798,105.867367,'Cửa Hàng Xăng Dầu Petrolimex','Số 484 Minh Khai, Vĩnh Tuy, Hai Bà Trưng, Hà Nội, Việt Nam'),(140,20.997799,105.86737,'Cửa hàng xăng dầu Minh Khai','Số 505, Minh Khai, Phường Vĩnh Tuy, Quận Hai Bà Trưng, Hà Nội'),(141,20.998619,105.85118,'Của hàng xăng dầu Mai Hương','Số 17 Hồng Mai, Bạch Mai, Hai Bà Trưng, Hà Nội, Việt Nam'),(142,21.009239,105.854593,'Cây xăng Trần Khát Chân','Số 438 Trần Khát Chân, Phố Huế, Hai Bà Trưng, Hà Nội, Việt Nam'),(143,21.006704,105.816193,'Cửa Hàng Xăng Dầu Số 31 (Petrolimex)','Số 111 Láng, Thịnh Quang, Đống Đa, Hà Nội, Việt Nam'),(144,21.003,105.85476,'Cửa hàng bán lẻ xăng dầu Phú Thụy','Số 48, Thanh Nhàn, Phường Thanh Nhàn, Quận Hai Bà Trưng, Hà Nội, Việt Nam'),(145,21.019093,105.858355,'Cây xăng số 4','Số 9,Phố Trần Hưng Đạo, Quận Hoàn Kiếm, Hoàn Kiếm, Hà Nội, Việt Nam'),(146,21.025748,105.859629,'Trạm xăng Trần Quang Khải','Số 214, Trần Quang Khải, Tràng Tiền, Hoàn Kiếm, Hà Nội, Việt Nam');
/*!40000 ALTER TABLE `petrol_station` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_device_ui_id` varchar(45) NOT NULL,
  `user_lat` double DEFAULT NULL,
  `user_lng` double DEFAULT NULL,
  `lock_user` varchar(45) DEFAULT NULL,
  `token` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`user_device_ui_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('874b9b1ee49f021f',21.0182346,105.9425029,NULL,'fyxtNYanRXM:APA91bGXtI4iNQoToF-DWqr8vg8Ifc9B0Ju4Uzxc78LeN43uI3KcKxhuS6A7V8ZZ4hByF6saTcP-Kc37f8lzFTisMUCqFhqKofGLmjVj106ZfuNYPdCXKvlYBUw-tCgtGt4YY_Oi7TCc');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `warning`
--

DROP TABLE IF EXISTS `warning`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `warning` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `warning_latitude` double NOT NULL,
  `warning_longitude` double NOT NULL,
  `warning_address` varchar(100) NOT NULL,
  `warning_category_id` int(11) NOT NULL,
  `warning_create_time` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Fk_Warning_Category_idx` (`warning_category_id`),
  CONSTRAINT `Fk_Warning_Category` FOREIGN KEY (`warning_category_id`) REFERENCES `warning_category` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `warning`
--

LOCK TABLES `warning` WRITE;
/*!40000 ALTER TABLE `warning` DISABLE KEYS */;
INSERT INTO `warning` VALUES (3,21.0182506,105.9424894,'64 QL5, BÃ¬nh Minh, TrÃ¢u Quá»³, Gia LÃ¢m, HÃ  Ná»i, Vietnam',2,'08/31/2016 23:04:28');
/*!40000 ALTER TABLE `warning` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `warning_category`
--

DROP TABLE IF EXISTS `warning_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `warning_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `warning_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `warning_category`
--

LOCK TABLES `warning_category` WRITE;
/*!40000 ALTER TABLE `warning_category` DISABLE KEYS */;
INSERT INTO `warning_category` VALUES (1,'TẮC ĐƯỜNG'),(2,'TAI NẠN');
/*!40000 ALTER TABLE `warning_category` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-01 17:10:38
