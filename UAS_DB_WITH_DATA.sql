-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 08, 2020 at 07:40 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `uas_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_jabatan`
--

CREATE TABLE `tb_jabatan` (
  `id` int(11) NOT NULL,
  `nama_jabatan` varchar(50) NOT NULL,
  `is_deleted` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_jabatan`
--

INSERT INTO `tb_jabatan` (`id`, `nama_jabatan`, `is_deleted`) VALUES
(1, 'Office Gil', 0),
(2, 'Dosen', 0),
(3, 'Dosen Honorer', 0),
(4, 'Jbatan 1', 1),
(5, 'Office Boy', 0),
(6, 'Program Studi', 0);

-- --------------------------------------------------------

--
-- Table structure for table `tb_jurusan`
--

CREATE TABLE `tb_jurusan` (
  `id` int(11) NOT NULL,
  `nama_jurusan` varchar(50) NOT NULL,
  `nama_prodi` varchar(50) NOT NULL,
  `is_deleted` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_jurusan`
--

INSERT INTO `tb_jurusan` (`id`, `nama_jurusan`, `nama_prodi`, `is_deleted`) VALUES
(1, 'Akuntansi', 'Alfred', 0),
(2, 'Management', 'Amir Syah', 0),
(3, 'Bisnis', 'Alfred', 0),
(4, 'Teknologi Informatika', 'Pak Ahmad Budi', 0),
(5, 'Sistem Informatika', 'Pak Ahmad Budi', 0);

-- --------------------------------------------------------

--
-- Table structure for table `tb_login`
--

CREATE TABLE `tb_login` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `user_id` int(11) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_login`
--

INSERT INTO `tb_login` (`id`, `name`, `username`, `user_id`, `password`) VALUES
(1, 'Alexander', '51170018', 51170018, '12345');

-- --------------------------------------------------------

--
-- Table structure for table `tb_matkul`
--

CREATE TABLE `tb_matkul` (
  `id` int(11) NOT NULL,
  `nama_matkul` varchar(50) NOT NULL,
  `dosen` varchar(50) NOT NULL,
  `ruang` varchar(50) NOT NULL,
  `jurusan` varchar(50) NOT NULL,
  `is_deleted` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_matkul`
--

INSERT INTO `tb_matkul` (`id`, `nama_matkul`, `dosen`, `ruang`, `jurusan`, `is_deleted`) VALUES
(1, 'Pemrograman Java', 'Pak Badrul', 'B-2', '', 1),
(2, 'Interaksi Manusia Komputer', 'Pak Ahmad Budi', '2.C', '', 1),
(3, 'Pelajaran APA SAja44', 'Amir Syah', 'B-2', '', 1),
(4, 'Pelajaran APA SAja24', 'Amir Syah', 'B-2', '', 1),
(5, 'Pemrograman Java', 'Pak Badrul', 'B-2', 'Teknologi Informatika', 0),
(6, 'Interaksi Manusia Komputer', 'Pak Ahmad Budi', 'B-2', 'Teknologi Informatika', 0);

-- --------------------------------------------------------

--
-- Table structure for table `tb_mhs`
--

CREATE TABLE `tb_mhs` (
  `id` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `nik` varchar(50) NOT NULL,
  `jurusan` varchar(50) NOT NULL,
  `tahun_akademik` varchar(4) NOT NULL,
  `is_deleted` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_mhs`
--

INSERT INTO `tb_mhs` (`id`, `nama`, `nik`, `jurusan`, `tahun_akademik`, `is_deleted`) VALUES
(1, 'Alexander Gracetantiono', '217001', 'Akuntansi', '17', 0),
(2, 'Joshua Pernandi E.', '218002', 'Akuntansi', '18', 0),
(3, 'Kiko Enak', '218003', 'Akuntansi', '18', 1),
(4, 'John Cena', '420004', 'Sistem Informasi', '20', 0),
(5, 'Michellin ', '019005', 'Teknologi Informatika', '17', 0),
(6, 'Endriko Juan', '519006', 'Sistem Informatika', '19', 0),
(7, 'Siddharta Prajna', '318007', 'Bisnis', '20', 0);

-- --------------------------------------------------------

--
-- Table structure for table `tb_nilai`
--

CREATE TABLE `tb_nilai` (
  `id` int(11) NOT NULL,
  `matkul` varchar(50) NOT NULL,
  `nik` varchar(50) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `uas` int(4) NOT NULL,
  `uts` int(4) NOT NULL,
  `harian` int(4) NOT NULL,
  `rerata` int(4) NOT NULL,
  `grade` varchar(2) NOT NULL,
  `is_deleted` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_nilai`
--

INSERT INTO `tb_nilai` (`id`, `matkul`, `nik`, `nama`, `uas`, `uts`, `harian`, `rerata`, `grade`, `is_deleted`) VALUES
(2, 'Pemrograman Java', '217001', 'Alexander Gracetantiono', 90, 75, 90, 90, 'A-', 0),
(3, 'Interaksi Manusia Komputer', '318007', 'Siddharta Prajna', 90, 80, 80, 80, 'A-', 1),
(4, 'Interaksi Manusia Komputer', '519006', 'Endriko Juan', 80, 80, 80, 80, 'A-', 0),
(5, 'Pemrograman Java', '420004', 'John Cena', 35, 35, 35, 35, 'D', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tb_ruang`
--

CREATE TABLE `tb_ruang` (
  `id` int(11) NOT NULL,
  `ruang_id` varchar(50) NOT NULL,
  `staff` varchar(50) NOT NULL,
  `is_deleted` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_ruang`
--

INSERT INTO `tb_ruang` (`id`, `ruang_id`, `staff`, `is_deleted`) VALUES
(1, 'B-2', 'Amir Syah', 0),
(2, '2.C', 'Amir Syah', 0),
(3, 'Basement-1', 'Amir Syah', NULL),
(4, 'C-2', 'Amir Syah', 0),
(5, 'D-2', 'Amir Syah', 0);

-- --------------------------------------------------------

--
-- Table structure for table `tb_staff`
--

CREATE TABLE `tb_staff` (
  `id` varchar(20) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `jabatan` varchar(50) NOT NULL,
  `tahun_masuk` varchar(4) NOT NULL,
  `is_deleted` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_staff`
--

INSERT INTO `tb_staff` (`id`, `nama`, `jabatan`, `tahun_masuk`, `is_deleted`) VALUES
('2175', 'Pak Badrul', 'Dosen', '17', 0),
('2191', 'Dr.Albert Enstein', 'Dosen', '18', 1),
('2192', 'DR Jokowow', 'Dosen', '19', 1),
('3193', 'Alfred', 'Dosen Honorer', '19', 0),
('5194', 'Amir Syah', 'Office Boy', '19', 0),
('6176', 'Pak Ahmad Budi', 'Program Studi', '17', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_jabatan`
--
ALTER TABLE `tb_jabatan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_jurusan`
--
ALTER TABLE `tb_jurusan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_login`
--
ALTER TABLE `tb_login`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_matkul`
--
ALTER TABLE `tb_matkul`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_mhs`
--
ALTER TABLE `tb_mhs`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_nilai`
--
ALTER TABLE `tb_nilai`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_ruang`
--
ALTER TABLE `tb_ruang`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_staff`
--
ALTER TABLE `tb_staff`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_jabatan`
--
ALTER TABLE `tb_jabatan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tb_jurusan`
--
ALTER TABLE `tb_jurusan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `tb_login`
--
ALTER TABLE `tb_login`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tb_matkul`
--
ALTER TABLE `tb_matkul`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tb_mhs`
--
ALTER TABLE `tb_mhs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `tb_nilai`
--
ALTER TABLE `tb_nilai`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `tb_ruang`
--
ALTER TABLE `tb_ruang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
