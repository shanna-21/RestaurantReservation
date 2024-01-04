-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 04, 2024 at 01:30 PM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `laperah`
--

-- --------------------------------------------------------

--
-- Table structure for table `labranch`
--

CREATE TABLE `labranch` (
  `BranchID` varchar(5) NOT NULL,
  `RestaurantTypeID` varchar(10) NOT NULL,
  `Location` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `labranch`
--

INSERT INTO `labranch` (`BranchID`, `RestaurantTypeID`, `Location`) VALUES
('BAN', 'Main', 'Bandung'),
('JAK', 'Main', 'Jakarta'),
('BAL', 'Main', 'Bali'),
('SUR', 'Sub', 'Surabaya'),
('SAM', 'Sub', 'Samarinda'),
('PAD', 'Sub', 'Padang');

-- --------------------------------------------------------

--
-- Table structure for table `lamenu`
--

CREATE TABLE `lamenu` (
  `MenuID` int(10) NOT NULL,
  `MenuName` varchar(50) NOT NULL,
  `MenuPrice` int(100) NOT NULL,
  `MenuType` varchar(10) NOT NULL,
  `AmountOrdered` int(11) DEFAULT NULL,
  `Backstory` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `lamenu`
--

INSERT INTO `lamenu` (`MenuID`, `MenuName`, `MenuPrice`, `MenuType`, `AmountOrdered`, `Backstory`) VALUES
(1, 'Batagor Tanah Tinggi', 80000, 'Special', 0, NULL),
(2, 'Nasi Uduk Kota Besar', 98000, 'Special', 0, NULL),
(3, 'Babi Guling', 132000, 'Special', 0, NULL),
(4, 'Rujak Cingur', 95000, 'LocalSur', 0, NULL),
(5, 'Nasi Kuning Samarinda', 95000, 'LocalSam', 0, NULL),
(6, 'Rendang Istimewa', 60000, 'LocalPad', 0, NULL),
(7, 'Nasi Goreng', 60000, 'General', 0, NULL),
(8, 'Ayam Goreng', 72000, 'General', 0, NULL),
(9, 'Mie Goreng', 55000, 'General', 0, NULL),
(10, 'Soto Ayam', 65000, 'General', 0, NULL),
(11, 'Rawon', 75000, 'General', 2, NULL),
(12, 'Sate Ayam', 50000, 'General', 0, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `lareservation`
--

CREATE TABLE `lareservation` (
  `ReservationType` varchar(50) NOT NULL,
  `MaximumCap` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `lareservation`
--

INSERT INTO `lareservation` (`ReservationType`, `MaximumCap`) VALUES
('Romantic', 2),
('General', 4),
('Family', 10);

-- --------------------------------------------------------

--
-- Table structure for table `larestaurant`
--

CREATE TABLE `larestaurant` (
  `RestaurantID` int(5) NOT NULL,
  `BranchID` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `larestaurant`
--

INSERT INTO `larestaurant` (`RestaurantID`, `BranchID`) VALUES
(700, 'BAN'),
(701, 'JAK'),
(702, 'BAL'),
(703, 'SUR'),
(704, 'SAM'),
(705, 'PAD');

-- --------------------------------------------------------

--
-- Table structure for table `lastaff`
--

CREATE TABLE `lastaff` (
  `EmployeeID` int(10) NOT NULL,
  `EmployeeName` varchar(50) NOT NULL,
  `BranchID` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `lastaff`
--

INSERT INTO `lastaff` (`EmployeeID`, `EmployeeName`, `BranchID`) VALUES
(500, 'Shanna', 'BAN'),
(501, 'Kevin', 'JAK'),
(502, 'Axelle', 'BAL'),
(503, 'Naomi', 'SUR'),
(504, 'Tepani', 'SAM'),
(505, 'Shane', 'PAD');

-- --------------------------------------------------------

--
-- Table structure for table `latransaction`
--

CREATE TABLE `latransaction` (
  `TransactionID` int(255) NOT NULL,
  `RestaurantID` int(5) NOT NULL,
  `ReservationType` varchar(50) NOT NULL,
  `BookedSeats` int(5) NOT NULL,
  `EmployeeID` int(5) NOT NULL,
  `CustomerName` varchar(50) DEFAULT NULL,
  `BookedTables` int(11) DEFAULT NULL,
  `Status` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `latransaction`
--

INSERT INTO `latransaction` (`TransactionID`, `RestaurantID`, `ReservationType`, `BookedSeats`, `EmployeeID`, `CustomerName`, `BookedTables`, `Status`) VALUES
(1000, 700, 'Romantic', 2, 500, 'Opang', 5, 'In Reserve'),
(1001, 700, 'General', 4, 500, 'Ken', 5, 'In Reserve'),
(1002, 700, 'Family', 10, 500, 'Jo', 5, 'In Reserve'),
(1003, 701, 'General', 3, 501, 'Toni', 5, 'In Reserve'),
(1004, 701, 'Romantic', 1, 501, 'Hendi', 5, 'In Reserve'),
(1005, 701, 'Family', 6, 501, 'Finn', 5, 'In Reserve'),
(1006, 700, 'General', 3, 500, 'EcelGeming', 4, 'Finalized');

-- --------------------------------------------------------

--
-- Table structure for table `latransactiondetails`
--

CREATE TABLE `latransactiondetails` (
  `TransactiondetailsID` int(255) NOT NULL,
  `MenuID` int(10) NOT NULL,
  `Amount` int(10) NOT NULL,
  `TransactionID` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `latransactiondetails`
--

INSERT INTO `latransactiondetails` (`TransactiondetailsID`, `MenuID`, `Amount`, `TransactionID`) VALUES
(1000000000, 1, 1, 1000),
(1000000001, 7, 2, 1000),
(1000000002, 8, 3, 1000),
(1000000003, 9, 4, 1000),
(1000000004, 10, 5, 1001),
(1000000005, 11, 6, 1001),
(1000000006, 11, 2, 1006);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `lamenu`
--
ALTER TABLE `lamenu`
  ADD PRIMARY KEY (`MenuID`);

--
-- Indexes for table `larestaurant`
--
ALTER TABLE `larestaurant`
  ADD PRIMARY KEY (`RestaurantID`);

--
-- Indexes for table `lastaff`
--
ALTER TABLE `lastaff`
  ADD PRIMARY KEY (`EmployeeID`);

--
-- Indexes for table `latransaction`
--
ALTER TABLE `latransaction`
  ADD PRIMARY KEY (`TransactionID`);

--
-- Indexes for table `latransactiondetails`
--
ALTER TABLE `latransactiondetails`
  ADD PRIMARY KEY (`TransactiondetailsID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `lamenu`
--
ALTER TABLE `lamenu`
  MODIFY `MenuID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `larestaurant`
--
ALTER TABLE `larestaurant`
  MODIFY `RestaurantID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=706;

--
-- AUTO_INCREMENT for table `lastaff`
--
ALTER TABLE `lastaff`
  MODIFY `EmployeeID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=506;

--
-- AUTO_INCREMENT for table `latransaction`
--
ALTER TABLE `latransaction`
  MODIFY `TransactionID` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1007;

--
-- AUTO_INCREMENT for table `latransactiondetails`
--
ALTER TABLE `latransactiondetails`
  MODIFY `TransactiondetailsID` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1000000007;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
