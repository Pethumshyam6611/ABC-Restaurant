-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: abc_restaurant
-- ------------------------------------------------------
-- Server version	8.0.39

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
-- Table structure for table `facilities`
--

DROP TABLE IF EXISTS `facilities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `facilities` (
  `facilitiyid` int NOT NULL AUTO_INCREMENT,
  `facility_name` varchar(100) DEFAULT NULL,
  `description` varchar(300) DEFAULT NULL,
  `facility_img` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`facilitiyid`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facilities`
--

LOCK TABLES `facilities` WRITE;
/*!40000 ALTER TABLE `facilities` DISABLE KEYS */;
INSERT INTO `facilities` VALUES (9,'Private Dining Room','Our exclusive private dining room offers an intimate and sophisticated setting, perfect for business meetings or private celebrations. Enjoy a personalized menu and attentive service in a secluded atmosphere.','Images/digital-lavender-style-interior-design.jpg'),(10,'Bar & Lounge','Enjoy the fresh air while dining al fresco on our beautiful outdoor terrace. Whether itâs a sunny day or a cool evening, our terrace provides a cozy and scenic atmosphere for all occasions.','Images/friends-toasting-beer-celebrate.jpg'),(11,'Parking Lot','Convenient and secure parking available for all our guests, with easy access to the restaurant. Our lot is monitored 24/7 to ensure safety and comfort.','Images/empty-underground-parking-bay.jpg'),(12,'Live Music Stage','Experience live music performances while you dine in a vibrant atmosphere. Our stage hosts talented local artists to add a touch of entertainment to your dining experience.','Images/people-with-gothic-style-costumes-make-up-performing-drama-world-theatre-day.jpg'),(13,'Kids Play Area','Let your children have fun in a safe and interactive play area. Equipped with modern games and toys, itâs designed to keep the little ones entertained while you relax.','Images/strong-man-bouldering.jpg'),(15,'Swimming Pool','Relax by our outdoor swimming pool, complete with temperature control to ensure comfort all year round. The perfect spot for a refreshing dip or lounging poolside.','Images/view-luxurious-hotel-pool.jpg');
/*!40000 ALTER TABLE `facilities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gallery`
--

DROP TABLE IF EXISTS `gallery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gallery` (
  `galleryid` int NOT NULL AUTO_INCREMENT,
  `gallery_img` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`galleryid`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gallery`
--

LOCK TABLES `gallery` WRITE;
/*!40000 ALTER TABLE `gallery` DISABLE KEYS */;
INSERT INTO `gallery` VALUES (14,'Images/3d-render-interior-restaurant.jpg'),(15,'Images/grilled-meat-fresh-tomato-cheeseburger-rustic-wooden-table-generated-by-artificial-intelligence.jpg'),(16,'Images/skillful-asian-chef-prepares-meals-lively-street-stall.jpg'),(17,'Images/view-luxurious-hotel-pool.jpg'),(18,'Images/digital-lavender-style-interior-design.jpg'),(19,'Images/people-enjoying-mexican-barbecue (1).jpg'),(20,'Images/group-friends-eating-restaurant.jpg'),(21,'Images/friends-eating-conversating-restaurant.jpg');
/*!40000 ALTER TABLE `gallery` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu` (
  `productid` int NOT NULL AUTO_INCREMENT,
  `category` varchar(60) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `product_img` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`productid`)
) ENGINE=InnoDB AUTO_INCREMENT=98 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (14,'Drinks','Mojito','Minty, Zesty, Refreshing, Sparkling, Cool, Invigorating',700,'Images/282e9e19-5b05-41fe-a4c3-e23169a4eb80.png'),(15,'Drinks','Faluda','Sweet, Creamy, Refreshing, Exotic, Flavorful, Chilled',650,'Images/fc18edf2-6b03-4a96-8318-5bf1e79ec283.png'),(16,'Main Course','Pizza','Savory, Cheesy, Crispy, Zesty, Delicious, Hot',2000,'Images/20220211142754-margherita-9920_5a73220e-4a1a-4d33-b38f-26e98e3cd986.jpg'),(17,'Main Course','Fried Rice','Flavorful, Savory, Spicy, Aromatic, Satisfying, Delicious',1000,'Images/c72c2d20-69de-4a0e-9a8e-bc3532d8f2dd.png'),(18,'Main Course','Steak','Juicy, Tender, Savory, Succulent, Grilled, Flavorful',1000,'Images/30be601a-afb8-4c11-b1bf-01e43dcd1dce.png'),(19,'Dessert','Ice Cream','Creamy, Sweet, Rich, Chilled, Smooth, Decadent',500,'Images/26c7c268-4d85-4326-b979-22757ff56473.png'),(20,'Dessert','Cheese Cake','Creamy, Rich, Tangy, Sweet, Smooth, Lush',900,'Images/fd6ed69c-faa3-4b51-8a61-81bc330fc0ef (1).png');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oder`
--

DROP TABLE IF EXISTS `oder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `oder` (
  `oderid` int NOT NULL AUTO_INCREMENT,
  `food_names_with_qt` varchar(500) DEFAULT NULL,
  `useridp` int NOT NULL,
  `type` varchar(100) DEFAULT NULL,
  `total_price` double DEFAULT NULL,
  `status` varchar(100) DEFAULT NULL,
  `datetime` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`oderid`),
  KEY `useridp_idx` (`useridp`),
  CONSTRAINT `useridp` FOREIGN KEY (`useridp`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oder`
--

LOCK TABLES `oder` WRITE;
/*!40000 ALTER TABLE `oder` DISABLE KEYS */;
INSERT INTO `oder` VALUES (2,'Faluda(3)',2,'dine in',1950,'pending','2024-09-10 18:55:17');
/*!40000 ALTER TABLE `oder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `offers`
--

DROP TABLE IF EXISTS `offers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `offers` (
  `offerid` int NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `description` varchar(300) DEFAULT NULL,
  `price` varchar(100) DEFAULT NULL,
  `offer_img` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`offerid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `offers`
--

LOCK TABLES `offers` WRITE;
/*!40000 ALTER TABLE `offers` DISABLE KEYS */;
INSERT INTO `offers` VALUES (2,'Coca-Cola Combo Offer','By one get one free','1000','Images/cocacola offer.png'),(10,'Triple Pizza Pack','30% Off','2000','Images/Annotation 2024-09-11 101044.png');
/*!40000 ALTER TABLE `offers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservations`
--

DROP TABLE IF EXISTS `reservations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservations` (
  `reservationid` int NOT NULL AUTO_INCREMENT,
  `userid` int DEFAULT NULL,
  `message` varchar(600) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  `number_of_people` int DEFAULT NULL,
  `status` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`reservationid`),
  KEY `userid_idx` (`userid`),
  CONSTRAINT `userid` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservations`
--

LOCK TABLES `reservations` WRITE;
/*!40000 ALTER TABLE `reservations` DISABLE KEYS */;
INSERT INTO `reservations` VALUES (2,2,NULL,'2024-12-07','14:00:00',6,'pending'),(4,2,NULL,'2024-09-18','08:18:00',5,'pending'),(5,2,NULL,'2024-09-12','20:20:00',3,'pending'),(6,2,'Puka','2024-09-13','21:06:00',4,'pending'),(7,2,'Birthday Celebration','2024-09-11','19:00:00',4,'Pending'),(8,2,'Birthday Celebration','2024-09-11','19:00:00',4,'Pending'),(9,2,'Family Dinner','2024-09-13','20:00:00',3,'Pending'),(10,2,'Birthday Celebration','2024-09-11','19:00:00',4,'Pending'),(11,2,'Birthday Celebration','2024-09-11','19:00:00',4,'Pending'),(12,2,'Birthday Celebration','2024-09-11','19:00:00',4,'Pending'),(13,2,'Business Meeting','2024-09-12','13:00:00',6,'Confirmed'),(14,2,'Birthday Celebration','2024-09-11','19:00:00',4,'Pending'),(15,2,'Birthday Celebration','2024-09-11','19:00:00',4,'Pending'),(16,2,'Family Dinner','2024-09-13','20:00:00',3,'Pending'),(17,2,'Birthday Celebration','2024-09-11','19:00:00',4,'Pending'),(18,2,'Birthday Celebration','2024-09-11','19:00:00',4,'Pending'),(19,2,'Birthday Celebration','2024-09-11','19:00:00',4,'Pending'),(20,2,'Business Meeting','2024-09-12','13:00:00',6,'Confirmed'),(21,2,'Birthday Celebration','2024-09-11','19:00:00',4,'Pending'),(22,2,'Birthday Celebration','2024-09-11','19:00:00',4,'Pending'),(23,2,'Family Dinner','2024-09-13','20:00:00',3,'Pending'),(24,2,'Birthday Celebration','2024-09-11','19:00:00',4,'Pending'),(25,2,'Birthday Celebration','2024-09-11','19:00:00',4,'Pending'),(26,2,'Birthday Celebration','2024-09-11','19:00:00',4,'Pending'),(27,2,'Business Meeting','2024-09-12','13:00:00',6,'Confirmed'),(28,2,'Birthday Celebration','2024-09-11','19:00:00',4,'Pending'),(29,2,'Birthday Celebration','2024-09-11','19:00:00',4,'Pending'),(30,2,'Family Dinner','2024-09-13','20:00:00',3,'Pending'),(31,2,'Birthday Celebration','2024-09-11','19:00:00',4,'Pending'),(32,2,'Birthday Celebration','2024-09-11','19:00:00',4,'Pending'),(33,2,'Birthday Celebration','2024-09-11','19:00:00',4,'Pending'),(34,2,'Business Meeting','2024-09-12','13:00:00',6,'Confirmed');
/*!40000 ALTER TABLE `reservations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `userid` int NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(10) DEFAULT NULL,
  `role` varchar(20) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `phone` int DEFAULT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `phone_UNIQUE` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Pethuma','1111','Admin','example@example.com',1234567890),(2,'Pethum Shyam','6611','Customer','pethumshayam66@gmail.com',772910692),(3,'Akash','0000','Staff','akashuvindu@gmail.com',779090900);
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

-- Dump completed on 2024-09-11 11:52:53
