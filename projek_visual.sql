-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Aug 23, 2020 at 06:25 PM
-- Server version: 5.6.16
-- PHP Version: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `projek_visual`
--

-- --------------------------------------------------------

--
-- Table structure for table `mst_barang`
--

CREATE TABLE IF NOT EXISTS `mst_barang` (
  `kd_barang` varchar(10) NOT NULL,
  `nama_barang` varchar(100) NOT NULL,
  `kategori_barang` varchar(20) NOT NULL,
  `merek` varchar(50) DEFAULT NULL,
  `ukuran` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`kd_barang`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mst_barang`
--

INSERT INTO `mst_barang` (`kd_barang`, `nama_barang`, `kategori_barang`, `merek`, `ukuran`) VALUES
('12314', 'Laptop', 'Barang Electronik', 'Toshiba', '20 X 10 cm'),
('123456', 'Meja bundar segitu', 'Barang Furniture', 'xxxxx', '50X50 cm'),
('1456', 'Kuris Tamu VIP', 'Barang Furniture', 'Tasmina', '12 x 20 m');

-- --------------------------------------------------------

--
-- Table structure for table `mst_lokasi`
--

CREATE TABLE IF NOT EXISTS `mst_lokasi` (
  `kd_lokasi` varchar(10) NOT NULL,
  `nama_lokasi` varchar(50) NOT NULL,
  PRIMARY KEY (`kd_lokasi`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mst_lokasi`
--

INSERT INTO `mst_lokasi` (`kd_lokasi`, `nama_lokasi`) VALUES
('G00011', 'Gudang berangkas'),
('GD001', 'Ruang Direksi');

-- --------------------------------------------------------

--
-- Table structure for table `mst_user`
--

CREATE TABLE IF NOT EXISTS `mst_user` (
  `id_user` varchar(10) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `nama` varchar(35) DEFAULT NULL,
  `jenis_kelamin` varchar(20) DEFAULT NULL,
  `alamat` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mst_user`
--

INSERT INTO `mst_user` (`id_user`, `username`, `password`, `nama`, `jenis_kelamin`, `alamat`) VALUES
('123', 'admin', 'admin', 'BOY', 'Laki - laki', 'Indramayu'),
('1234', 'asik', 'banget', 'ABOY', 'Laki - laki', '-'),
('12345', 'agus', 'agus', 'Redi', 'Perempuan', 'Jl. mangga dua'),
('1291', 'aboy', 'aboy', 'asep gendeng', 'Laki - laki', 'jl.kenangan masa lalu');

-- --------------------------------------------------------

--
-- Table structure for table `trx_inventaris_keluar`
--

CREATE TABLE IF NOT EXISTS `trx_inventaris_keluar` (
  `kd_inventaris_keluar` char(15) NOT NULL,
  `kd_inventaris_masuk` char(15) NOT NULL,
  `jumlah` double NOT NULL,
  `tanggal_keluar` date DEFAULT NULL,
  `keterangan` varchar(20) NOT NULL,
  `id_user` char(5) NOT NULL,
  PRIMARY KEY (`kd_inventaris_keluar`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trx_inventaris_keluar`
--

INSERT INTO `trx_inventaris_keluar` (`kd_inventaris_keluar`, `kd_inventaris_masuk`, `jumlah`, `tanggal_keluar`, `keterangan`, `id_user`) VALUES
('OUT0001', 'IN0001', 10, '2020-08-20', 'coba ket', '123'),
('OUT0002', 'IN0001', 1, '2020-08-23', 'rusak', '123'),
('OUT0003', 'IN0003', 1, '2020-08-23', '-', '123'),
('OUT0004', 'IN0003', 1, '2020-08-23', 'rusak terbanting', '123');

-- --------------------------------------------------------

--
-- Table structure for table `trx_inventaris_masuk`
--

CREATE TABLE IF NOT EXISTS `trx_inventaris_masuk` (
  `kd_inventaris_masuk` char(15) NOT NULL,
  `kd_barang` varchar(10) NOT NULL,
  `jumlah` float NOT NULL,
  `nilai_barang` float NOT NULL,
  `tanggal_masuk` date DEFAULT NULL,
  `id_user` varchar(10) NOT NULL,
  `kd_lokasi` char(10) NOT NULL,
  PRIMARY KEY (`kd_inventaris_masuk`,`kd_barang`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trx_inventaris_masuk`
--

INSERT INTO `trx_inventaris_masuk` (`kd_inventaris_masuk`, `kd_barang`, `jumlah`, `nilai_barang`, `tanggal_masuk`, `id_user`, `kd_lokasi`) VALUES
('IN0001', '12314', 20, 1000, '2020-08-20', '123', 'G00011'),
('IN0002', '1456', 1, 10000, '2020-08-23', '123', 'G00011'),
('IN0003', '1456', 1, 10000, '2020-08-23', '123', 'GD001');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
