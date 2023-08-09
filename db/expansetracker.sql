-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Aug 09, 2023 at 08:23 AM
-- Server version: 5.7.34
-- PHP Version: 7.4.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `expansetracker`
--

-- --------------------------------------------------------

--
-- Table structure for table `mst_expanses`
--

CREATE TABLE `mst_expanses` (
  `date` date DEFAULT NULL,
  `expense_amount` decimal(38,2) DEFAULT NULL,
  `create_at` datetime(6) NOT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `expanse_id` varchar(255) NOT NULL,
  `expanse_name` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `mst_users`
--

CREATE TABLE `mst_users` (
  `age` bigint(20) DEFAULT NULL,
  `create_at` datetime(6) NOT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `mst_expanses`
--
ALTER TABLE `mst_expanses`
  ADD PRIMARY KEY (`expanse_id`),
  ADD KEY `FK3ycidwo6bro7d8d5l6ljiyhyx` (`user_id`);

--
-- Indexes for table `mst_users`
--
ALTER TABLE `mst_users`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `UK_i5n452i71qk3nqn97pvc899wu` (`email`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `mst_expanses`
--
ALTER TABLE `mst_expanses`
  ADD CONSTRAINT `FK3ycidwo6bro7d8d5l6ljiyhyx` FOREIGN KEY (`user_id`) REFERENCES `mst_users` (`user_id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
