-- MySQL dump 10.13  Distrib 8.0.27, for Linux (x86_64)
--
-- Host: localhost    Database: dementia
-- ------------------------------------------------------
-- Server version	8.0.27-0ubuntu0.20.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `activity`
--

DROP TABLE IF EXISTS `activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `activity` (
  `activity_id` int NOT NULL,
  `activity` varchar(255) DEFAULT NULL,
  `details` varchar(255) DEFAULT NULL,
  `pid` varchar(255) DEFAULT NULL,
  `record_date_time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`activity_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity`
--

LOCK TABLES `activity` WRITE;
/*!40000 ALTER TABLE `activity` DISABLE KEYS */;
/*!40000 ALTER TABLE `activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctor` (
  `did` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone_no` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (24);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login_details`
--

DROP TABLE IF EXISTS `login_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login_details` (
  `id` bigint NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_3rrmdu8mjdvqic8v0qc8vyip9` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login_details`
--

LOCK TABLES `login_details` WRITE;
/*!40000 ALTER TABLE `login_details` DISABLE KEYS */;
INSERT INTO `login_details` VALUES (1,'akshil','akshil'),(3,'$2a$10$jHX8fsv1nK3xjhdjPrklCOmMGMSF3b8W3J/fAOp2lkb2AQXg/FIOC','abc'),(6,'$2a$10$LTGPz8LFSrNSQ4P09TbOg.y4VhuqIEezKlQFQfdIeaeUryvtZGuo2','xyz'),(7,'$2a$10$N0e1aNdB2iM8w9SYtfDjYORvYX7IGDKlnaK27OKf8af4X6xz685PC','qwe'),(8,'$2a$10$xGHKCKrtNGOgUk2D622clOtvUzdnO1K2me6oqK47X2FlD71z3KK7q','qjwe');
/*!40000 ALTER TABLE `login_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient` (
  `uhid` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `pc_phone_no` varchar(255) DEFAULT NULL,
  `phone_no` varchar(255) DEFAULT NULL,
  `primary_contact_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uhid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES ('10','asdfghj',34,'male','abc','987654321','123456789','xvy'),('13','asdfghj',34,'male','abc','987654321','123456789','xvy'),('14','asdfghj',34,'male','abc','987654321','123456789','xvy'),('16','asdfghj',34,'male','abc','987654321','123456789','xvy'),('18','asdfghj',34,'male','abc','987654321','123456789','xvy'),('19','asdfghj',34,'male','abc','987654321','123456789','xvy'),('90','asdfghj',34,'male','abc','987654321','123456789','xvy');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient_queue_info`
--

DROP TABLE IF EXISTS `patient_queue_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient_queue_info` (
  `pid` varchar(255) NOT NULL,
  `age` int DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `insert_in_queue_time` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_queue_info`
--

LOCK TABLES `patient_queue_info` WRITE;
/*!40000 ALTER TABLE `patient_queue_info` DISABLE KEYS */;
INSERT INTO `patient_queue_info` VALUES ('21600344-aef7-4042-972b-9650e439916c',34,'male','26/10/2021 16:27:34','abc'),('ec4025ee-1dfb-48f2-a39d-e39905e26536',34,'male','26/10/2021 16:26:38','abc');
/*!40000 ALTER TABLE `patient_queue_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `survey`
--

DROP TABLE IF EXISTS `survey`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `survey` (
  `section_id` varchar(255) NOT NULL,
  `pid` varchar(255) DEFAULT NULL,
  `response_json` varchar(255) DEFAULT NULL,
  `timestamp` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`section_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `survey`
--

LOCK TABLES `survey` WRITE;
/*!40000 ALTER TABLE `survey` DISABLE KEYS */;
/*!40000 ALTER TABLE `survey` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `survey_questions`
--

DROP TABLE IF EXISTS `survey_questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `survey_questions` (
  `survey_id` int NOT NULL,
  `section_body` longtext,
  `section_no` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `version` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`survey_id`),
  UNIQUE KEY `UK6vxvgkaab6gs9qefe1he0jqbl` (`section_no`,`version`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `survey_questions`
--

LOCK TABLES `survey_questions` WRITE;
/*!40000 ALTER TABLE `survey_questions` DISABLE KEYS */;
INSERT INTO `survey_questions` VALUES (18,'{\n  \"section\" : \"5\",\n  \"version\" : \"5\",\n  \"title\" : \"Question for the informant about patients memory\",\n  \"listOfQuestions\" : [ {\n    \"question\" : \"Does he/she have a problem with his/her memory or thinking?\",\n    \"options\" : [ \"yes\", \"No\" ]\n  }, {\n    \"question\" : \"Does he/she have a problem with his/her memory or thinking?\",\n    \"options\" : [ \"yes\", \"No\" ]\n  } ]\n}','5','Question for the informant about patients memory','5'),(19,'{\n  \"title\" : \"Question for the informant about patients memory\",\n  \"listOfQuestions\" : [ {\n    \"question\" : \"Does he/she have a problem with his/her memory or thinking?\",\n    \"options\" : [ \"yes\", \"No\" ]\n  }, {\n    \"question\" : \"Does he/she have a problem with his/her memory or thinking?\",\n    \"options\" : [ \"yes\", \"No\" ]\n  } ]\n}',NULL,'Question for the informant about patients memory',NULL),(21,'[ {\n  \"question\" : \"Does he/she have a problem with his/her memory or thinking?\",\n  \"options\" : [ \"yes\", \"No\" ]\n}, {\n  \"question\" : \"Does he/she have a problem with his/her memory or thinking?\",\n  \"options\" : [ \"yes\", \"No\" ]\n} ]','5','Question for the informant about patients memory','6'),(23,'[ {\n  \"question\" : \"Does he/she have a problem with his/her memory or thinking?\",\n  \"options\" : [ \"yes\", \"No\" ]\n}, {\n  \"question\" : \"Does he/she have a problem with his/her memory or thinking?\",\n  \"options\" : [ \"yes\", \"No\" ]\n} ]','1','Question for the informant about patients memory','1');
/*!40000 ALTER TABLE `survey_questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `survey_response`
--

DROP TABLE IF EXISTS `survey_response`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `survey_response` (
  `pid` int NOT NULL,
  `survey_id` int NOT NULL,
  `response_json` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pid`,`survey_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `survey_response`
--

LOCK TABLES `survey_response` WRITE;
/*!40000 ALTER TABLE `survey_response` DISABLE KEYS */;
/*!40000 ALTER TABLE `survey_response` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uhid_pid`
--

DROP TABLE IF EXISTS `uhid_pid`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `uhid_pid` (
  `pid` varchar(255) NOT NULL,
  `uhidenc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uhid_pid`
--

LOCK TABLES `uhid_pid` WRITE;
/*!40000 ALTER TABLE `uhid_pid` DISABLE KEYS */;
INSERT INTO `uhid_pid` VALUES ('21600344-aef7-4042-972b-9650e439916c','NiCWGOdeGJD0JGMfIGES6w=='),('22655da7-4913-4af3-bd6b-2af12a2899c4','RPU43eCtsTqhcDa4sMeNlg=='),('78cf3560-1494-4208-8d29-11100374f25e','9Xoa0qDRCE/N6ssPgAUWHg=='),('9b5ddbd6-7732-43be-a354-0bf0424fc62e','hQRniPGA0SCFM6uB1ZI2mQ=='),('adbe5801-cf68-4a48-b5ab-72a9b5f46c73','ZIkWk9P9yfHa4HwVcedfKw=='),('e8166553-6fc0-45a5-a6dc-2191fd4a2522','fTjEJu3+Qyp45IuZf2MDpA=='),('ec4025ee-1dfb-48f2-a39d-e39905e26536','xucoVaVEjzy2of/D+E5HNQ==');
/*!40000 ALTER TABLE `uhid_pid` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visit`
--

DROP TABLE IF EXISTS `visit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `visit` (
  `visit_id` int NOT NULL,
  `did` varchar(255) DEFAULT NULL,
  `pid` varchar(255) DEFAULT NULL,
  `follow_up_date` date DEFAULT NULL,
  `visit_date_time` datetime(6) DEFAULT NULL,
  `visit_details_json` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`visit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visit`
--

LOCK TABLES `visit` WRITE;
/*!40000 ALTER TABLE `visit` DISABLE KEYS */;
INSERT INTO `visit` VALUES (1,NULL,NULL,NULL,'2021-10-26 16:35:20.000000','dkjsbfjksdbfjksdbf'),(2,'21','ec4025ee-1dfb-48f2-a39d-e39905e26536',NULL,'2021-10-26 16:38:04.000000','dkjsbfjksdbfjksdbf');
/*!40000 ALTER TABLE `visit` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-11 10:41:35
