-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.12-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for bakery_store
CREATE DATABASE IF NOT EXISTS `bakery_store` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `bakery_store`;

-- Dumping structure for table bakery_store.order
CREATE TABLE IF NOT EXISTS `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL DEFAULT 0,
  `user_id` int(11) NOT NULL DEFAULT 0,
  `quantity` int(10) unsigned NOT NULL DEFAULT 0,
  `unit_price` int(10) unsigned NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `fk_order_product` (`product_id`),
  KEY `fk_order_user` (`user_id`),
  CONSTRAINT `fk_order_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_order_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table bakery_store.order: ~3 rows (approximately)
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` (`id`, `product_id`, `user_id`, `quantity`, `unit_price`) VALUES
	(1, 1, 1, 2, 200000),
	(2, 2, 1, 1, 250000),
	(3, 3, 1, 3, 200000);
/*!40000 ALTER TABLE `order` ENABLE KEYS */;

-- Dumping structure for table bakery_store.product
CREATE TABLE IF NOT EXISTS `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL DEFAULT '',
  `price` int(10) unsigned NOT NULL,
  `image_link` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

-- Dumping data for table bakery_store.product: ~6 rows (approximately)
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`id`, `name`, `price`, `image_link`) VALUES
	(1, 'Strawberry Cake', 200000, 'cake0001.png'),
	(2, 'Chocolate Cake', 250000, 'cake0002.png'),
	(3, 'Fruit Cake', 300000, 'cake0003.png'),
	(4, 'Cheese Cake', 250000, 'cake0004.png'),
	(5, 'Apple Pie', 150000, 'cake0005.png'),
	(6, 'Berry Pie', 200000, 'cake0006.png');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;

-- Dumping structure for table bakery_store.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL DEFAULT '',
  `password` varchar(100) COLLATE utf8mb4_vietnamese_ci NOT NULL DEFAULT '',
  `name` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

-- Dumping data for table bakery_store.user: ~2 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `username`, `password`, `name`) VALUES
	(1, 'admin', '$2a$10$CwIcVMZMki94jgHRmE.FGOQx8E7WKhlj6EGYmXkL4N2.78i/w1fzK', 'Nhi'),
	(2, 'user', '$2a$10$13xQQ2hEjgNCh5uIZzApbO8EsdmaOOi8zMSNuMefKJEu8PPWPBVXW', 'Nhi');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
