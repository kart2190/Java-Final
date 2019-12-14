-- MariaDB dump 10.17  Distrib 10.4.10-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: Student
-- ------------------------------------------------------
-- Server version	10.4.10-MariaDB

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `Admin_id` int(11) DEFAULT NULL,
  `Student_Login_id` int(11) DEFAULT NULL,
  `Company_id` int(11) DEFAULT NULL,
  KEY `Student_Login_id` (`Student_Login_id`),
  KEY `Company_id` (`Company_id`),
  CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`Student_Login_id`) REFERENCES `students` (`Student_Login_id`),
  CONSTRAINT `admin_ibfk_2` FOREIGN KEY (`Company_id`) REFERENCES `company` (`Company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `Company_id` int(11) NOT NULL,
  `Company_Name` varchar(20) DEFAULT NULL,
  `Job_Category` varchar(20) DEFAULT NULL,
  `Job_Title` varchar(20) DEFAULT NULL,
  `Salary` int(11) DEFAULT NULL,
  `Location` varchar(20) DEFAULT NULL,
  `Positions` int(11) DEFAULT NULL,
  PRIMARY KEY (`Company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (2222,'Cerner','Software','Engineer',9500,'India',3);
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_company`
--

DROP TABLE IF EXISTS `student_company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_company` (
  `Student_Login_id` int(11) DEFAULT NULL,
  `Company_id` int(11) DEFAULT NULL,
  KEY `Student_Login_id` (`Student_Login_id`),
  KEY `Company_id` (`Company_id`),
  CONSTRAINT `student_company_ibfk_1` FOREIGN KEY (`Student_Login_id`) REFERENCES `students` (`Student_Login_id`),
  CONSTRAINT `student_company_ibfk_2` FOREIGN KEY (`Company_id`) REFERENCES `company` (`Company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_company`
--

LOCK TABLES `student_company` WRITE;
/*!40000 ALTER TABLE `student_company` DISABLE KEYS */;
INSERT INTO `student_company` VALUES (1111,2222);
/*!40000 ALTER TABLE `student_company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `students` (
  `Student_Login_id` int(11) NOT NULL,
  `Student_Password` varchar(20) DEFAULT NULL,
  `First_Name` varchar(20) DEFAULT NULL,
  `Sex` int(11) DEFAULT NULL,
  `Age` int(11) DEFAULT NULL,
  `Grad_Year` date DEFAULT NULL,
  `Percentage` int(11) DEFAULT NULL,
  `Last_Name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Student_Login_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (1111,'Password123','Karan',0,27,'2018-01-01',97,'Karthik');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-13  9:41:32
