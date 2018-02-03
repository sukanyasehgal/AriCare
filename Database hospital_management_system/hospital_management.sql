CREATE DATABASE  IF NOT EXISTS `hospital_management` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `hospital_management`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: hospital_management
-- ------------------------------------------------------
-- Server version	5.0.22-community-nt

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
-- Not dumping tablespaces as no INFORMATION_SCHEMA.FILES table on this server
--

--
-- Table structure for table `pill_details`
--

DROP TABLE IF EXISTS `pill_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pill_details` (
  `pill_id` int(11) NOT NULL auto_increment,
  `doctor_id` int(11) default NULL,
  `patient_id` int(11) default NULL,
  `pill_name` varchar(20) default NULL,
  `start_date` varchar(10) default NULL,
  `end_date` varchar(10) default NULL,
  `dosage_time` time default NULL,
  `dosage` int(11) default NULL,
  PRIMARY KEY  (`pill_id`),
  KEY `doctor_id` (`doctor_id`),
  KEY `patient_id` (`patient_id`),
  CONSTRAINT `pill_details_ibfk_1` FOREIGN KEY (`doctor_id`) REFERENCES `doctor_profile` (`doctor_id`),
  CONSTRAINT `pill_details_ibfk_2` FOREIGN KEY (`patient_id`) REFERENCES `patient_profile` (`patient_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pill_details`
--

LOCK TABLES `pill_details` WRITE;
/*!40000 ALTER TABLE `pill_details` DISABLE KEYS */;
INSERT INTO `pill_details` VALUES (1,1,1,'rosaday','2016-05-18','2016-06-16','08:00:00',1),(2,2,2,'acetaminophen','2016-05-26','2016-06-30','09:00:00',2),(3,3,3,'Terbinafine','2016-05-25','2016-06-30','09:00:00',1),(4,5,4,'valparin','2016-05-24','2016-04-16','08:00:00',1),(5,4,5,'alendronate','2016-05-24','2016-04-24','08:00:00',2),(6,6,5,'thyronome','2016-05-09','2016-06-08','09:30:00',1);
/*!40000 ALTER TABLE `pill_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctor_profile`
--

DROP TABLE IF EXISTS `doctor_profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `doctor_profile` (
  `doctor_id` int(11) NOT NULL auto_increment,
  `doctor_name` varchar(20) default NULL,
  `phone_number` bigint(10) default NULL,
  `address` varchar(80) default NULL,
  `qualification` varchar(30) default NULL,
  `timings` varchar(20) default NULL,
  `specialization` varchar(15) default NULL,
  `image` varchar(60) default NULL,
  `email_id` varchar(40) default NULL,
  PRIMARY KEY  (`doctor_id`),
  KEY `phone_number` (`phone_number`),
  CONSTRAINT `doctor_profile_ibfk_1` FOREIGN KEY (`phone_number`) REFERENCES `login_details` (`phone_number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor_profile`
--

LOCK TABLES `doctor_profile` WRITE;
/*!40000 ALTER TABLE `doctor_profile` DISABLE KEYS */;
INSERT INTO `doctor_profile` VALUES (1,'KG Singla',7654567645,' Aricare Hospital\r\nInfotech Centre,\r\nOld Delhi Road Gurgaon-122015','MBBS','9 to 6','cardiology','d2.jpg','keshavbatra1992@gmail.com'),(2,'Jyoti Mishra',8765432109,' Aricare Hospital\r\nInfotech Centre,\r\nOld Delhi Road Gurgaon-122015','MBBS','9 to 6','Nephrology','d3.jpg','keshavbatra1992@gmail.com'),(3,'Jaya',8768977775,' Aricare Hospital\r\nInfotech Centre,\r\nOld Delhi Road Gurgaon-122015','MBBS','9 to 6','neurology','d1.jpg','keshavbatra1992@gmail.com'),(4,'Sunil Khosla',7666678875,' Aricare Hospital\r\nInfotech Centre,\r\nOld Delhi Road Gurgaon-122015','MBBS','9 to 6','Dermatology','d4.jpg','keshavbatra1992@gmail.com'),(5,'Riya',8998789654,' Aricare Hospital\r\nInfotech Centre,\r\nOld Delhi Road Gurgaon-122015','MBBS','9 to 6','Orthopedics','slider3.jpg','sakshikansal91@gmail.com'),(6,'Rina',8766778966,' Aricare Hospital\r\nInfotech Centre,\r\nOld Delhi Road Gurgaon-122015','MBBS','9 to 6','cardiology','slider1.jpg','sakshikansal91@gmail.com');
/*!40000 ALTER TABLE `doctor_profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `appointment_details`
--

DROP TABLE IF EXISTS `appointment_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `appointment_details` (
  `appointment_id` int(11) NOT NULL auto_increment,
  `patient_id` int(11) default NULL,
  `doctor_id` int(11) default NULL,
  `patient_name` varchar(20) default NULL,
  `doctor_name` varchar(20) default NULL,
  `timing` time default NULL,
  `date` date default NULL,
  PRIMARY KEY  (`appointment_id`),
  KEY `patient_id` (`patient_id`),
  KEY `doctor_id` (`doctor_id`),
  CONSTRAINT `appointment_details_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `patient_profile` (`patient_id`),
  CONSTRAINT `appointment_details_ibfk_2` FOREIGN KEY (`doctor_id`) REFERENCES `doctor_profile` (`doctor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment_details`
--

LOCK TABLES `appointment_details` WRITE;
/*!40000 ALTER TABLE `appointment_details` DISABLE KEYS */;
INSERT INTO `appointment_details` VALUES (1,1,1,'John','KG Singla','10:00:00','2016-06-02'),(2,2,2,'Tiya','Jyoti Mishra','11:00:00','2016-06-09'),(3,3,3,'Harry','Jaya','10:00:00','2016-06-08'),(4,4,4,'Mahira','Sunil Khosla','03:30:00','2016-06-01'),(5,5,5,'Ritesh','Riya','03:00:00','2016-05-31'),(6,5,6,'Ritesh','Rina','05:00:00','2016-06-08');
/*!40000 ALTER TABLE `appointment_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login_details`
--

DROP TABLE IF EXISTS `login_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login_details` (
  `phone_number` bigint(10) NOT NULL default '0',
  `password` varchar(100) NOT NULL,
  `role` varchar(8) NOT NULL,
  PRIMARY KEY  (`phone_number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login_details`
--

LOCK TABLES `login_details` WRITE;
/*!40000 ALTER TABLE `login_details` DISABLE KEYS */;
INSERT INTO `login_details` VALUES (7344335768,'$2a$10$GOJQAaMT8ViJ7MClWfjRC.tyGUWOy8tphnnopOMmrv96E7067C3Ty','patient'),(7654567645,'$2a$10$y8GddQVsbYCJE8l7q0CsZeDTHy2AfvqdqUdfREWwzEKoC0bPT5BFa','doctor'),(7666678875,'$2a$10$uEiSu2BEGeTO.5jiBHC2LegADZ64msA3yGUAvU0Vx1kizWRc6tS22','doctor'),(7896533631,'$2a$10$bmAb5eDZLLzo81zNEVIUJuJgwOW5X5nG1X2o8Lc2Z39vpW9TerHGq','patient'),(8686868686,'$2a$10$GCNsuoaw6LesRbzjDGk28uayFOm4NUt8vdnqMjX4bWBO1uxvJDcKq','doctor'),(8765432109,'$2a$10$kMm88Hd62GCFxmUaIwoRGu3prbsCUcICyWG3KxzPdLvUye686nlHm','doctor'),(8765489053,'$2a$10$zozg1L9ZelLrWT.YNgrkUujxTemHzJxE./ExxXp1SOOR72NL2WH1K','patient'),(8765890954,'$2a$10$YbkPy79PfYq7EHvZDsIDPuOwg4Es.y/PWRGq7JfIO9ZJrDO.yNvOe','patient'),(8766778966,'$2a$10$lSMzKZmfK7hqdDqnSXA9UejovFd40h2dOwaEUVlEBQqgnU6WWSZ52','doctor'),(8768977775,'$2a$10$IWQf3wTlVbcLYN2rbPA8Z.QqvajAC1e/8oCzlWLJOq4bwimh2qjzS','doctor'),(8998789654,'$2a$10$.4m4saHsUX0e9DTLVW8mzu7hjLZEJScmRa10uoUe7N7GBXZ59gkfe','doctor'),(9876543210,'$2a$10$hcPOnQOqyeJq9d0RRW6WLe4bRFLSYeHAdR1CmqddPOdf2kKCEI8US','patient'),(9879879870,'$2a$10$j4efKug8.69p5RmL/APHyOTH1Q1UEndQF.uUWK/2ODBTeeCVTLHpq','admin'),(9911000000,'$2a$10$cK/4RnSbE7nCd940SQjCG.A6.6DXnoMTllnLeoSkpUXnoOMyoE.5W','doctor');
/*!40000 ALTER TABLE `login_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient_profile`
--

DROP TABLE IF EXISTS `patient_profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient_profile` (
  `patient_id` int(11) NOT NULL auto_increment,
  `patient_name` varchar(20) default NULL,
  `phone_number` bigint(10) default NULL,
  `address` varchar(60) default NULL,
  `email_id` varchar(30) default NULL,
  PRIMARY KEY  (`patient_id`),
  KEY `phone_number` (`phone_number`),
  CONSTRAINT `patient_profile_ibfk_1` FOREIGN KEY (`phone_number`) REFERENCES `login_details` (`phone_number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_profile`
--

LOCK TABLES `patient_profile` WRITE;
/*!40000 ALTER TABLE `patient_profile` DISABLE KEYS */;
INSERT INTO `patient_profile` VALUES (1,'John',9876543210,'House no. 546 Sector 22A Gurgaon.','keshavbatra1992@gmail.com'),(2,'Tiya',8765890954,'D-342 Milestone 14/5 Old Delhi','sakshikansal91@gmail.com'),(3,'Harry',8765489053,'House no. 890 Sector 18 Gurgaon.','keshavbatra09@gmail.com'),(4,'Mahira',7896533631,'D-675 New Friends Colony Ludhiana','kaurmandeep77777@gmail.com'),(5,'Ritesh',7344335768,'House no. 785 Sector 31 Gurgaon.','keshavbatra1992@gmail.com');
/*!40000 ALTER TABLE `patient_profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `newsletter`
--

DROP TABLE IF EXISTS `newsletter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `newsletter` (
  `news_id` int(11) NOT NULL auto_increment,
  `subject` varchar(500) default NULL,
  `content` varchar(1000) default NULL,
  PRIMARY KEY  (`news_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `newsletter`
--

LOCK TABLES `newsletter` WRITE;
/*!40000 ALTER TABLE `newsletter` DISABLE KEYS */;
INSERT INTO `newsletter` VALUES (1,'Clean and green week at AriCare Feb 1, 2016 to Feb 29,2016','AriCare, always focused on benefitting environment and building an eco-friendly campus, conducted a green month from 1st, 2016 to 29th Feb, 2016. Activities which were carried out during this week included: planting trees, installing water-retentive rooftop gardens, installing large expanses of glass for natural light, replacing existing urinals with waterless urinals, installing energy-efficient heating and cooling systems, and using a major portion of recycled and recyclable materials for majority purposes.'),(2,'Celebrating World Health Day April 7, 2016','On the occasion of World Health Day, AriCare organised a walkathon covering 3 kms around Gurgaon, and a &#147;Free Health Check-up Camp&#148; in the hospital premises for the general people.'),(3,'11th annual conference on Cardiac Care March 27, 2016 to March 28, 2016','AriCare organized the 11th Asian Association of Cardiac Nursing Conference on 27th and 28th March 2016 at the Auditorium of National Library, based on the theme &#147;Clinical Excellence in Cardiac care&#148;.');
/*!40000 ALTER TABLE `newsletter` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-06-01 16:18:47
