-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 28, 2022 at 04:34 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pulsa_ali`
--

-- --------------------------------------------------------

--
-- Table structure for table `akun`
--

CREATE TABLE `akun` (
  `id_akun` int(11) NOT NULL,
  `nama` varchar(20) NOT NULL,
  `no_hp` varchar(15) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `saldo` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `akun`
--

INSERT INTO `akun` (`id_akun`, `nama`, `no_hp`, `alamat`, `password`, `saldo`) VALUES
(1, 'ali', '086458244968', 'poncol', '86318e52f5ed4801abe1d13d509443de', 1019300),
(2, 'febi', '08564138', 'bandengan', 'febi', 379500),
(3, 'j', 'j', 'j', '363b122c528f54df4a0446b6bab05515', 0),
(9, 'I', 'I', 'I', 'dd7536794b63bf90eccfd37f9b147d7f', 0);

--
-- Triggers `akun`
--
DELIMITER $$
CREATE TRIGGER `log_saldo` BEFORE UPDATE ON `akun` FOR EACH ROW BEGIN
IF new.saldo<old.saldo THEN
INSERT INTO log_saldo SET tgl=now(), log_saldo.transaksi = new.saldo-old.saldo,
ket = 'saldo berkurang',
saldo = new.saldo,
id_akun = old.id_akun;
ELSE 
INSERT INTO log_saldo SET tgl=now(), log_saldo.transaksi = new.saldo-old.saldo,
ket = 'saldo bertambah',
saldo = new.saldo,
id_akun = old.id_akun;
END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `log_saldo`
--

CREATE TABLE `log_saldo` (
  `tgl` datetime NOT NULL,
  `transaksi` int(11) NOT NULL,
  `ket` varchar(15) NOT NULL,
  `saldo` int(11) NOT NULL,
  `id_akun` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `log_saldo`
--

INSERT INTO `log_saldo` (`tgl`, `transaksi`, `ket`, `saldo`, `id_akun`) VALUES
('2022-12-20 22:50:22', 100000, 'saldo bertambah', 150000, 1),
('2022-12-20 22:56:28', -50000, 'saldo berkurang', 1450000, 2),
('2022-12-22 22:58:04', 100000, 'saldo bertambah', 250000, 1),
('2022-12-22 23:01:14', 50000, 'saldo bertambah', 1500000, 2),
('2022-12-22 23:04:36', -50100, 'saldo berkurang', 1449900, 2),
('2022-12-25 06:50:38', -50100, 'saldo berkurang', 1399800, 2),
('2022-12-25 06:57:09', 50000, 'saldo bertambah', 300000, 1),
('2022-12-25 06:57:22', 100000, 'saldo bertambah', 1499800, 2),
('2022-12-25 07:00:12', -20100, 'saldo berkurang', 1479700, 2),
('2022-12-25 07:03:02', -100100, 'saldo berkurang', 1379600, 2),
('2022-12-25 07:05:01', -200100, 'saldo berkurang', 99900, 1),
('2022-12-25 07:05:26', -1000100, 'saldo berkurang', 379500, 2),
('2022-12-28 08:09:42', -20100, 'saldo berkurang', 79800, 1),
('2022-12-28 08:09:48', -20100, 'saldo berkurang', 59700, 1),
('2022-12-28 08:10:48', -50100, 'saldo berkurang', 9600, 1),
('2022-12-28 08:27:25', 1000000, 'saldo bertambah', 1009600, 1),
('2022-12-28 08:27:56', -20100, 'saldo berkurang', 989500, 1),
('2022-12-28 09:01:21', -20100, 'saldo berkurang', 969400, 1),
('2022-12-28 09:03:59', -100100, 'saldo berkurang', 869300, 1),
('2022-12-28 10:02:02', 50000, 'saldo bertambah', 919300, 1),
('2022-12-28 10:02:15', 100000, 'saldo bertambah', 1019300, 1);

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE `pelanggan` (
  `no_pln` char(16) NOT NULL,
  `nama` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pelanggan`
--

INSERT INTO `pelanggan` (`no_pln`, `nama`) VALUES
('1', 'ian'),
('123456', 'riqqi'),
('2', 'adit'),
('a', 'abata'),
('aa', 'a'),
('ab', 'ian'),
('b', 'b'),
('c', 'a'),
('maghrib', 'maghriba');

-- --------------------------------------------------------

--
-- Table structure for table `saldo`
--

CREATE TABLE `saldo` (
  `nominal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `saldo`
--

INSERT INTO `saldo` (`nominal`) VALUES
(50000),
(100000),
(200000),
(300000),
(400000),
(500000),
(1000000);

-- --------------------------------------------------------

--
-- Table structure for table `token_listrik`
--

CREATE TABLE `token_listrik` (
  `harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `token_listrik`
--

INSERT INTO `token_listrik` (`harga`) VALUES
(20000),
(50000),
(100000),
(200000),
(500000),
(1000000),
(5000000),
(10000000);

-- --------------------------------------------------------

--
-- Table structure for table `trans_beli`
--

CREATE TABLE `trans_beli` (
  `no_trans_beli` int(11) NOT NULL,
  `nominal` int(11) NOT NULL,
  `id_akun` int(11) NOT NULL,
  `tgl` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `trans_beli`
--

INSERT INTO `trans_beli` (`no_trans_beli`, `nominal`, `id_akun`, `tgl`) VALUES
(3, 50000, 2, '2022-12-22 17:00:55'),
(6, 50000, 1, '2022-12-25 00:57:04'),
(7, 100000, 2, '2022-12-25 00:57:16'),
(8, 1000000, 1, '0000-00-00 00:00:00'),
(9, 50000, 1, '2022-12-28 10:02:02'),
(10, 100000, 1, '2022-12-28 10:02:15');

--
-- Triggers `trans_beli`
--
DELIMITER $$
CREATE TRIGGER `penambahan_saldo` BEFORE INSERT ON `trans_beli` FOR EACH ROW UPDATE akun SET akun.saldo=saldo+(new.nominal)
WHERE akun.id_akun = new.id_akun
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `trans_jual`
--

CREATE TABLE `trans_jual` (
  `no_trans_jual` int(11) NOT NULL,
  `no_pln` char(16) NOT NULL,
  `harga` int(11) NOT NULL,
  `bayar` int(11) NOT NULL,
  `id_akun` int(11) NOT NULL,
  `tgl` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `trans_jual`
--

INSERT INTO `trans_jual` (`no_trans_jual`, `no_pln`, `harga`, `bayar`, `id_akun`, `tgl`) VALUES
(1, '2', 50000, 53000, 2, '2022-12-22 17:04:04'),
(2, '2', 50000, 53000, 2, '2022-12-25 00:49:27'),
(3, '1', 20000, 0, 2, '2022-12-25 00:59:52'),
(4, '1', 100000, 1003000, 2, '2022-12-25 01:00:55'),
(5, '123456', 200000, 200000, 1, '2022-12-25 01:03:25'),
(6, '1', 1000000, 200000, 2, '2022-12-25 01:05:12'),
(7, '123456', 20000, 23000, 1, '2022-12-28 08:09:42'),
(8, '123456', 20000, 23000, 1, '2022-12-28 08:09:48'),
(9, '1', 50000, 53000, 1, '2022-12-28 08:10:48'),
(10, '123456', 20000, 23000, 1, '2022-12-28 08:27:56'),
(11, '123456', 20000, 23000, 1, '2022-12-28 09:01:21'),
(12, 'a', 100000, 103000, 1, '2022-12-28 09:03:59');

--
-- Triggers `trans_jual`
--
DELIMITER $$
CREATE TRIGGER `pengurangan_saldo` AFTER INSERT ON `trans_jual` FOR EACH ROW UPDATE akun SET akun.saldo=saldo-(new.harga+100)
WHERE akun.id_akun = new.id_akun
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `validasi_saldo_kurang` BEFORE INSERT ON `trans_jual` FOR EACH ROW BEGIN
IF (new.harga+100)>(SELECT saldo FROM akun WHERE akun.id_akun=new.id_akun )
THEN
SIGNAL SQLSTATE '45000'
SET MESSAGE_TEXT = "saldo anda tidak mencukupi untuk melakukan transaksi";
END IF;
END
$$
DELIMITER ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `akun`
--
ALTER TABLE `akun`
  ADD PRIMARY KEY (`id_akun`),
  ADD UNIQUE KEY `no_hp` (`no_hp`);

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`no_pln`);

--
-- Indexes for table `saldo`
--
ALTER TABLE `saldo`
  ADD PRIMARY KEY (`nominal`);

--
-- Indexes for table `token_listrik`
--
ALTER TABLE `token_listrik`
  ADD PRIMARY KEY (`harga`);

--
-- Indexes for table `trans_beli`
--
ALTER TABLE `trans_beli`
  ADD PRIMARY KEY (`no_trans_beli`);

--
-- Indexes for table `trans_jual`
--
ALTER TABLE `trans_jual`
  ADD PRIMARY KEY (`no_trans_jual`),
  ADD KEY `no_pln` (`no_pln`),
  ADD KEY `id_admin` (`id_akun`),
  ADD KEY `harga` (`harga`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `akun`
--
ALTER TABLE `akun`
  MODIFY `id_akun` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `saldo`
--
ALTER TABLE `saldo`
  MODIFY `nominal` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1000001;

--
-- AUTO_INCREMENT for table `trans_beli`
--
ALTER TABLE `trans_beli`
  MODIFY `no_trans_beli` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `trans_jual`
--
ALTER TABLE `trans_jual`
  MODIFY `no_trans_jual` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `trans_beli`
--
ALTER TABLE `trans_beli`
  ADD CONSTRAINT `trans_beli_ibfk_1` FOREIGN KEY (`id_akun`) REFERENCES `akun` (`id_akun`),
  ADD CONSTRAINT `trans_beli_ibfk_2` FOREIGN KEY (`nominal`) REFERENCES `saldo` (`nominal`);

--
-- Constraints for table `trans_jual`
--
ALTER TABLE `trans_jual`
  ADD CONSTRAINT `trans_jual_ibfk_1` FOREIGN KEY (`no_pln`) REFERENCES `pelanggan` (`no_pln`),
  ADD CONSTRAINT `trans_jual_ibfk_2` FOREIGN KEY (`id_akun`) REFERENCES `akun` (`id_akun`),
  ADD CONSTRAINT `trans_jual_ibfk_3` FOREIGN KEY (`harga`) REFERENCES `token_listrik` (`harga`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
