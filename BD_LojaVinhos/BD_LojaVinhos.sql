CREATE DATABASE  IF NOT EXISTS `lojavinhos` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `lojavinhos`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: lojavinhos
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `regiao`
--

DROP TABLE IF EXISTS `regiao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `regiao` (
  `codRegiao` bigint NOT NULL,
  `nomeRegiao` varchar(100) NOT NULL,
  `descricaoRegiao` text,
  PRIMARY KEY (`codRegiao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `regiao`
--

LOCK TABLES `regiao` WRITE;
/*!40000 ALTER TABLE `regiao` DISABLE KEYS */;
INSERT INTO `regiao` VALUES (1,'Napa Valley','Califórnia, EUA'),(2,'Côte de Nuits','Burgundy, França'),(3,'Sauternes','França'),(4,'Porto','Portugal'),(5,'Grands-Échezeaux Grand Cru','França');
/*!40000 ALTER TABLE `regiao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vinho`
--

DROP TABLE IF EXISTS `vinho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vinho` (
  `codVinho` bigint NOT NULL,
  `nomeVinho` varchar(50) NOT NULL,
  `tipoVinho` varchar(30) NOT NULL,
  `anoVinho` int NOT NULL,
  `descricaoVinho` text,
  `codVinicola` bigint NOT NULL,
  PRIMARY KEY (`codVinho`),
  KEY `codVinicola` (`codVinicola`),
  CONSTRAINT `vinho_ibfk_1` FOREIGN KEY (`codVinicola`) REFERENCES `vinicola` (`codVinicola`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vinho`
--

LOCK TABLES `vinho` WRITE;
/*!40000 ALTER TABLE `vinho` DISABLE KEYS */;
INSERT INTO `vinho` VALUES (1,'Cabernet Sauvignon','Tinto',2015,'Um dos Melhores vinhos do Mundo em 2019 segundo Wine Style Award, custando em torno de US$645',1),(2,'La Tâche Grand Cru','Suave',2000,'Saboroso e suave, perfeito para ocasiões especiais, custando em torno de US$4,5 mil',2),(3,'Sangiovese Toscana','Branco',2006,'Feito com uvas brancas com seu sabor adocicado, custando em torno de US$475',3),(4,'Sauternes','Rosé',2001,'Excelente vinho para comemoraçoes festivas, custando em torno de US$800',4),(5,'Very Old Single Harvest Port','Licoroso',1968,'Com uma concentração maior, uma ou duas taças são suficientes, custando em torno de US$250',5);
/*!40000 ALTER TABLE `vinho` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vinicola`
--

DROP TABLE IF EXISTS `vinicola`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vinicola` (
  `codVinicola` bigint NOT NULL,
  `nomeVinicola` varchar(100) NOT NULL,
  `decricaoVinicola` text,
  `foneVinicola` varchar(15) DEFAULT NULL,
  `emailVinicola` varchar(15) DEFAULT NULL,
  `codRegiao` bigint NOT NULL,
  PRIMARY KEY (`codVinicola`),
  KEY `codRegiao` (`codRegiao`),
  CONSTRAINT `vinicola_ibfk_1` FOREIGN KEY (`codRegiao`) REFERENCES `regiao` (`codRegiao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vinicola`
--

LOCK TABLES `vinicola` WRITE;
/*!40000 ALTER TABLE `vinicola` DISABLE KEYS */;
INSERT INTO `vinicola` VALUES (1,'Zuccardi Valle de Uco','A melhor Vinicula do mundo em 2021','32248011','ZVU@hotmail.com',1),(2,'Bodega Garzón','Bodega Garzón é uma das Bodegas com mais tradição. Vinhos de qualidade para o desfrute de todos os sentidos.','32248022','BG@hotmail.com',2),(3,'Domäne Wachau','Nos tornamos uma das vinícolas mais importantes sob a gestão de Roman Horvath MW e Heinz Frischengruber.','32248033','DW@hotmail.com',3),(4,'Montes','Vinícola Montes a 5ª melhor do mundo','32248044','MC@hotmail.com',4),(5,'Robert Mondavi','Robert Mondavi é um ícone da viticultura, toda tradição do velho mundo com a modernidade.','32248055','RM@hotmail.com',5);
/*!40000 ALTER TABLE `vinicola` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-18 10:17:02
