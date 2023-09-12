USE [master]
GO
/****** Object:  Database [LOANS]    Script Date: 9/12/2023 7:49:29 AM ******/
CREATE DATABASE [LOANS]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'LOANS', FILENAME = N'E:\sql\Data\LOANS.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'LOANS_log', FILENAME = N'E:\sql\Log\LOANS_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [LOANS] SET COMPATIBILITY_LEVEL = 140
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [LOANS].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [LOANS] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [LOANS] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [LOANS] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [LOANS] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [LOANS] SET ARITHABORT OFF 
GO
ALTER DATABASE [LOANS] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [LOANS] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [LOANS] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [LOANS] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [LOANS] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [LOANS] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [LOANS] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [LOANS] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [LOANS] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [LOANS] SET  DISABLE_BROKER 
GO
ALTER DATABASE [LOANS] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [LOANS] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [LOANS] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [LOANS] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [LOANS] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [LOANS] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [LOANS] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [LOANS] SET RECOVERY FULL 
GO
ALTER DATABASE [LOANS] SET  MULTI_USER 
GO
ALTER DATABASE [LOANS] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [LOANS] SET DB_CHAINING OFF 
GO
ALTER DATABASE [LOANS] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [LOANS] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [LOANS] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [LOANS] SET QUERY_STORE = OFF
GO
USE [LOANS]
GO
/****** Object:  Table [dbo].[Fee]    Script Date: 9/12/2023 7:49:29 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Fee](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[type] [varchar](255) NULL,
	[amount] [decimal](10, 2) NULL,
	[frequency] [varchar](255) NULL,
	[due_date] [date] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Installment]    Script Date: 9/12/2023 7:49:29 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Installment](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[loan_application_id] [int] NULL,
	[due_date] [date] NULL,
	[amount] [decimal](18, 2) NULL,
	[installment_amount] [decimal](18, 2) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoanApplication]    Script Date: 9/12/2023 7:49:29 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoanApplication](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[amount] [decimal](18, 2) NOT NULL,
	[duration] [int] NOT NULL,
	[start_date] [date] NOT NULL
) ON [PRIMARY]
GO
USE [master]
GO
ALTER DATABASE [LOANS] SET  READ_WRITE 
GO
