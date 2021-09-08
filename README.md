# student_system
springboot+layui+mybatis构建的学生信息管理系统
#mysql 文件
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: student_web
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `c_no` int NOT NULL AUTO_INCREMENT,
  `c_name` varchar(20) NOT NULL,
  `c_credit` int NOT NULL,
  `c_time` varchar(45) NOT NULL,
  `c_teacher` varchar(20) NOT NULL,
  PRIMARY KEY (`c_no`),
  KEY `teacher_idx` (`c_teacher`),
  CONSTRAINT `teacher` FOREIGN KEY (`c_teacher`) REFERENCES `teacher` (`t_no`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (36,'土木',3,'周二下午','120004'),(37,'设计',2,'周三上午','120005'),(38,'高等数学',1,'周三上午','120006');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `file`
--

DROP TABLE IF EXISTS `file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `file` (
  `id` int NOT NULL AUTO_INCREMENT,
  `f_no` int NOT NULL,
  `f_name` varchar(200) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `f_no key_idx` (`f_no`),
  CONSTRAINT `f_no key` FOREIGN KEY (`f_no`) REFERENCES `course` (`c_no`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file`
--

LOCK TABLES `file` WRITE;
/*!40000 ALTER TABLE `file` DISABLE KEYS */;
INSERT INTO `file` VALUES (1,36,'第3章_数据链路层.pptx'),(3,36,'第3章_数据链路层.pptx(2)'),(4,36,'第3章_数据链路层.pptx(3)'),(5,36,'第2章练习题.docx'),(6,36,'第2章练习题.docx(2)'),(7,36,'第2章_物理层.pptx'),(8,36,'练习题答案.docx');
/*!40000 ALTER TABLE `file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scores`
--

DROP TABLE IF EXISTS `scores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `scores` (
  `id` int NOT NULL AUTO_INCREMENT,
  `s_no` varchar(20) NOT NULL,
  `c_no` int NOT NULL,
  `score` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `sno_key_idx` (`s_no`),
  KEY `cno_key_idx` (`c_no`),
  CONSTRAINT `cno_key` FOREIGN KEY (`c_no`) REFERENCES `course` (`c_no`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sno_key` FOREIGN KEY (`s_no`) REFERENCES `student` (`s_no`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scores`
--

LOCK TABLES `scores` WRITE;
/*!40000 ALTER TABLE `scores` DISABLE KEYS */;
INSERT INTO `scores` VALUES (1,'1',36,60),(2,'1',37,70),(3,'180007',36,60),(4,'180007',37,NULL);
/*!40000 ALTER TABLE `scores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `select_course`
--

DROP TABLE IF EXISTS `select_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `select_course` (
  `id` int NOT NULL AUTO_INCREMENT,
  `s_no` varchar(20) NOT NULL,
  `c_no` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `s_no key_idx` (`s_no`),
  KEY `c_no_idx` (`c_no`),
  CONSTRAINT `c_no` FOREIGN KEY (`c_no`) REFERENCES `course` (`c_no`),
  CONSTRAINT `s_no key` FOREIGN KEY (`s_no`) REFERENCES `student` (`s_no`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `select_course`
--

LOCK TABLES `select_course` WRITE;
/*!40000 ALTER TABLE `select_course` DISABLE KEYS */;
INSERT INTO `select_course` VALUES (1,'1',36),(2,'1',37),(3,'180007',36),(4,'180007',37);
/*!40000 ALTER TABLE `select_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `s_no` varchar(20) NOT NULL,
  `s_name` varchar(45) NOT NULL,
  `s_sex` enum('男','女') NOT NULL,
  `academy` varchar(45) NOT NULL,
  PRIMARY KEY (`s_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('1','李华','女','理学院'),('180007','赵三','男','信息学院'),('180008','李雷','男','信息学院'),('180010','张六','男','建筑学院'),('180011','李会','女','建筑学院'),('180012','钱三','女','建筑学院'),('180015','王为','男','文法学院'),('180016','a','女','文法学院');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
  `t_no` varchar(20) NOT NULL,
  `t_name` varchar(45) NOT NULL,
  `t_sex` enum('男','女') NOT NULL,
  `academy` varchar(45) NOT NULL,
  PRIMARY KEY (`t_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES ('120001','王计','女','文法学院'),('120002','张法','女','信息学院'),('120004','王敏','男','建筑学院'),('120005','赵柳','女','建筑学院'),('120006','张三','男','理学院'),('120008','wa','女','文法学院');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` varchar(20) NOT NULL,
  `password` varchar(45) NOT NULL,
  `type` enum('s','t','a','r') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('1','123456','s'),('120001','123456','t'),('120004','123456','t'),('180007','123456','s'),('180015','123456','s'),('180016','123456','s'),('root','123456','r'),('信息学院','123456','a'),('建筑学院','123456','a'),('文法学院','123456','a'),('理学院','123456','a');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-08 22:51:35
