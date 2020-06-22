-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema NordicMotorhome_db
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema NordicMotorhome_db
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `NordicMotorhome_db`;
-- -----------------------------------------------------
-- Schema NordicMotorhome_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `NordicMotorhome_db` DEFAULT CHARACTER SET utf8 ;
USE `NordicMotorhome_db` ;

-- -----------------------------------------------------
-- Table `NMR_db`.`Accessories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `NordicMotorhome_db`.`Accessories` (
  `Accessory_id` INT NOT NULL AUTO_INCREMENT,
  `AccessoryType` VARCHAR(45) NULL DEFAULT NULL,
  `Price` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`Accessory_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `NordicMotorhome_db`.`Customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `NordicMotorhome_db`.`Customer` (
  `Customer_id` INT NOT NULL AUTO_INCREMENT,
  `CustomerName` VARCHAR(45) NULL DEFAULT NULL,
  `Address` VARCHAR(45) NULL DEFAULT NULL,
  `Zipcode` VARCHAR(45) NULL DEFAULT NULL,
  `Phone` INT NULL DEFAULT NULL,
  `Email` VARCHAR(45) NULL DEFAULT NULL,
  `CustomerType` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`Customer_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `NordicMotorhome_db`.`Employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `NordicMotorhome_db`.`Employee` (
  `Employee_id` INT NOT NULL AUTO_INCREMENT,
  `EmpName` VARCHAR(45) NULL DEFAULT NULL,
  `Position` VARCHAR(45) NULL DEFAULT NULL,
  `Address` VARCHAR(45) NULL DEFAULT NULL,
  `Zipcode` VARCHAR(45) NULL DEFAULT NULL,
  `Phone` INT NULL DEFAULT NULL,
  `Email` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`Employee_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `NordicMotorhome_db`.`Motorhome`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `NordicMotorhome_db`.`Motorhome` (
  `LicensPlateNo` VARCHAR(10) NOT NULL,
  `Model` VARCHAR(45) NULL DEFAULT NULL,
  `Beds` INT NULL DEFAULT NULL,
  `IsAccessible` VARCHAR(45) NULL DEFAULT NULL,
  `Km` DOUBLE NULL DEFAULT NULL,
  `Price` DOUBLE NULL DEFAULT NULL,
  `EngineBlockNo` INT NULL DEFAULT NULL,
  `DateStart` DATETIME NULL DEFAULT NULL,
  `DateFinish` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`LicensPlateNo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `NordicMotorhome_db`.`Invoice`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `NordicMotorhome_db`.`Invoice` (
  `Invoice_id` INT NOT NULL AUTO_INCREMENT,
  `DateStart` DATE NULL DEFAULT NULL,
  `DateEnd` DATE NULL DEFAULT NULL,
  `PickUp` VARCHAR(45) NULL DEFAULT NULL,
  `DropOff` VARCHAR(45) NULL DEFAULT NULL,
  `TotalPrice` DOUBLE NULL DEFAULT NULL,
  `Employee_id_fk` INT NULL DEFAULT NULL,
  `Customer_id_fk` INT NULL DEFAULT NULL,
  `Accessory_id_fk` INT NULL DEFAULT NULL,
  `Motorhome_LicensPlateNo` VARCHAR(10) NULL DEFAULT NULL,
  `InvoiceDone` TINYINT NULL DEFAULT NULL,
  PRIMARY KEY (`Invoice_id`),
  INDEX `fk_Invoice_Customer1_idx` (`Customer_id_fk` ASC) VISIBLE,
  INDEX `fk_Invoice_Accessories1_idx` (`Accessory_id_fk` ASC) VISIBLE,
  INDEX `fk_Invoice_Motorhome1_idx` (`Motorhome_LicensPlateNo` ASC) VISIBLE,
  CONSTRAINT `fk_Invoice_Accessories1`
    FOREIGN KEY (`Accessory_id_fk`)
    REFERENCES `NordicMotorhome_db`.`Accessories` (`Accessory_id`),
  CONSTRAINT `fk_Invoice_Customer1`
    FOREIGN KEY (`Customer_id_fk`)
    REFERENCES `NordicMotorhome_db`.`Customer` (`Customer_id`),
  CONSTRAINT `fk_Invoice_Motorhome1`
    FOREIGN KEY (`Motorhome_LicensPlateNo`)
    REFERENCES `NordicMotorhome_db`.`Motorhome` (`LicensPlateNo`))
ENGINE = InnoDB
AUTO_INCREMENT = 30
DEFAULT CHARACTER SET = utf8;


-- ------------------------- ACCESSORIES DUMMYDATA -----------------------------------
INSERT INTO `NordicMotorhome_db`.`Accessories` (`AccessoryType`, `Price`) VALUES ('Kugle gril', '450');
INSERT INTO `NordicMotorhome_db`.`Accessories` (`AccessoryType`, `Price`) VALUES ('Køkkengrej', '100');
INSERT INTO `NordicMotorhome_db`.`Accessories` (`AccessoryType`, `Price`) VALUES ('Parasol', '150');
INSERT INTO `NordicMotorhome_db`.`Accessories` (`AccessoryType`, `Price`) VALUES ('Overlevelsespakke', '2500');
INSERT INTO `NordicMotorhome_db`.`Accessories` (`AccessoryType`, `Price`) VALUES ('Skovhugger udstyr', '1400');
INSERT INTO `NordicMotorhome_db`.`Accessories` (`AccessoryType`, `Price`) VALUES ('Dummy data', '50');


-- ------------------------- CUSTOMER  DUMMYDATA -------------------------------------
INSERT INTO `NordicMotorhome_db`.`Customer` (`CustomerName`, `Address`, `Zipcode`, `Phone`, `Email`) VALUES ('Jesper Poulsen', 'Industrivej 10', '2200 Koebenhavn', '55555555', 'Poulsen@gmail.com');
INSERT INTO `NordicMotorhome_db`.`Customer` (`CustomerName`, `Address`, `Zipcode`, `Phone`, `Email`) VALUES ('Simon Simonsen', 'Industrivej 11', '2635 Ishoej', '11111111', 'Simonsen84@gmail.com');
INSERT INTO `NordicMotorhome_db`.`Customer` (`CustomerName`, `Address`, `Zipcode`, `Phone`, `Email`) VALUES ('David Davidsen', 'Industrivej 12', '2635 Ishoej', '22222222', 'Davidsen@gmail.com');
INSERT INTO `NordicMotorhome_db`.`Customer` (`CustomerName`, `Address`, `Zipcode`, `Phone`, `Email`) VALUES ('Mikael Skovsen', 'Hurtigvej 10', '2500 Valby', '33333333', 'Skovsen@hotmail.com');
INSERT INTO `NordicMotorhome_db`.`Customer` (`CustomerName`, `Address`, `Zipcode`, `Phone`, `Email`) VALUES ('Laura Little Larsen', 'Lindevej 14', '2500 Valby', '44444444', 'Little@little.dk');

-- ------------------------- MOTORHOME DUMMYDATA -------------------------------------
INSERT INTO `NordicMotorhome_db`.`Motorhome` (`LicensPlateNo`, `Model`, `Beds`, `IsAccessible`, `Km`, `Price`, `EngineBlockNo`) VALUES ('AA 92933', 'A', '2', 'YES', '2500', '650', '7283282');
INSERT INTO `NordicMotorhome_db`.`Motorhome` (`LicensPlateNo`, `Model`, `Beds`, `IsAccessible`, `Km`, `Price`, `EngineBlockNo`) VALUES ('AA 34253', 'A', '4', 'YES', '4250', '575', '6437283');
INSERT INTO `NordicMotorhome_db`.`Motorhome` (`LicensPlateNo`, `Model`, `Beds`, `IsAccessible`, `Km`, `Price`, `EngineBlockNo`) VALUES ('AA 83748', 'A', '6', 'YES', '3575', '600', '7364732');
INSERT INTO `NordicMotorhome_db`.`Motorhome` (`LicensPlateNo`, `Model`, `Beds`, `IsAccessible`, `Km`, `Price`, `EngineBlockNo`) VALUES ('AB 63723', 'B', '2', 'YES', '6529', '475', '3747263');
INSERT INTO `NordicMotorhome_db`.`Motorhome` (`LicensPlateNo`, `Model`, `Beds`, `IsAccessible`, `Km`, `Price`, `EngineBlockNo`) VALUES ('AB 62348', 'B', '4', 'YES', '4332', '525', '7463729');
INSERT INTO `NordicMotorhome_db`.`Motorhome` (`LicensPlateNo`, `Model`, `Beds`, `IsAccessible`, `Km`, `Price`, `EngineBlockNo`) VALUES ('AB 37283', 'B', '6', 'YES', '8734', '500', '2737493');
INSERT INTO `NordicMotorhome_db`.`Motorhome` (`LicensPlateNo`, `Model`, `Beds`, `IsAccessible`, `Km`, `Price`, `EngineBlockNo`) VALUES ('AC 73923', 'C', '2', 'YES', '10234', '475', '6783828');
INSERT INTO `NordicMotorhome_db`.`Motorhome` (`LicensPlateNo`, `Model`, `Beds`, `IsAccessible`, `Km`, `Price`, `EngineBlockNo`) VALUES ('AC 53729', 'C', '4', 'YES', '2623', '647', '6473832');
INSERT INTO `NordicMotorhome_db`.`Motorhome` (`LicensPlateNo`, `Model`, `Beds`, `IsAccessible`, `Km`, `Price`, `EngineBlockNo`) VALUES ('AC 83743', 'C', '6', 'YES', '32837', '345', '7364929');
INSERT INTO `NordicMotorhome_db`.`Motorhome` (`LicensPlateNo`, `Model`, `Beds`, `IsAccessible`, `Km`, `Price`, `EngineBlockNo`) VALUES ('AD 72738', 'D', '2', 'YES', '53626', '225', '5363820');
INSERT INTO `NordicMotorhome_db`.`Motorhome` (`LicensPlateNo`, `Model`, `Beds`, `IsAccessible`, `Km`, `Price`, `EngineBlockNo`) VALUES ('AD 90283', 'D', '4', 'YES', '23123', '478', '0983725');
INSERT INTO `NordicMotorhome_db`.`Motorhome` (`LicensPlateNo`, `Model`, `Beds`, `IsAccessible`, `Km`, `Price`, `EngineBlockNo`) VALUES ('AD 12345', 'D', '6', 'YES', '8263', '500', '1927312');
INSERT INTO `NordicMotorhome_db`.`Motorhome` (`LicensPlateNo`, `Model`, `Beds`, `IsAccessible`, `Km`, `Price`, `EngineBlockNo`) VALUES ('AE 92937', 'E', '2', 'YES', '1128', '400', '1928391');
INSERT INTO `NordicMotorhome_db`.`Motorhome` (`LicensPlateNo`, `Model`, `Beds`, `IsAccessible`, `Km`, `Price`, `EngineBlockNo`) VALUES ('AE 12387', 'E', '4', 'YES', '7263', '400', '1822792');
INSERT INTO `NordicMotorhome_db`.`Motorhome` (`LicensPlateNo`, `Model`, `Beds`, `IsAccessible`, `Km`, `Price`, `EngineBlockNo`) VALUES ('AE 82738', 'E', '6', 'YES', '7273', '123', '6372742');
INSERT INTO `NordicMotorhome_db`.`Motorhome` (`LicensPlateNo`, `Model`, `Beds`, `IsAccessible`, `Km`, `Price`, `EngineBlockNo`) VALUES ('AF 72638', 'F', '2', 'YES', '72637', '350', '7372735');
INSERT INTO `NordicMotorhome_db`.`Motorhome` (`LicensPlateNo`, `Model`, `Beds`, `IsAccessible`, `Km`, `Price`, `EngineBlockNo`) VALUES ('AF 63729', 'F', '4', 'YES', '25362', '350', '5781029');
INSERT INTO `NordicMotorhome_db`.`Motorhome` (`LicensPlateNo`, `Model`, `Beds`, `IsAccessible`, `Km`, `Price`, `EngineBlockNo`) VALUES ('AF 82739', 'F', '6', 'YES', '21342', '400', '0999832');
INSERT INTO `NordicMotorhome_db`.`Motorhome` (`LicensPlateNo`, `Model`, `Beds`, `IsAccessible`, `Km`, `Price`, `EngineBlockNo`) VALUES ('AG 21233', 'G', '2', 'YES', '19232', '375', '0732863');
INSERT INTO `NordicMotorhome_db`.`Motorhome` (`LicensPlateNo`, `Model`, `Beds`, `IsAccessible`, `Km`, `Price`, `EngineBlockNo`) VALUES ('AG 11234', 'G', '4', 'YES', '18273', '400', '1100283');
INSERT INTO `NordicMotorhome_db`.`Motorhome` (`LicensPlateNo`, `Model`, `Beds`, `IsAccessible`, `Km`, `Price`, `EngineBlockNo`) VALUES ('AG 88738', 'G', '6', 'YES', '86382', '250', '2272637');
INSERT INTO `NordicMotorhome_db`.`Motorhome` (`LicensPlateNo`, `Model`, `Beds`, `IsAccessible`, `Km`, `Price`, `EngineBlockNo`) VALUES ('AH 09902', 'H', '2', 'YES', '82382', '175', '8873372');
INSERT INTO `NordicMotorhome_db`.`Motorhome` (`LicensPlateNo`, `Model`, `Beds`, `IsAccessible`, `Km`, `Price`, `EngineBlockNo`) VALUES ('AH 00023', 'H', '4', 'YES', '11232', '475', '0000238');
INSERT INTO `NordicMotorhome_db`.`Motorhome` (`LicensPlateNo`, `Model`, `Beds`, `IsAccessible`, `Km`, `Price`, `EngineBlockNo`) VALUES ('AH 00012', 'H', '6', 'YES', '6637', '500', '1118273');
INSERT INTO `NordicMotorhome_db`.`Motorhome` (`LicensPlateNo`, `Model`, `Beds`, `IsAccessible`, `Km`, `Price`, `EngineBlockNo`) VALUES ('AI 00111', 'A', '2', 'YES', '26352', '499', '0002737');
INSERT INTO `NordicMotorhome_db`.`Motorhome` (`LicensPlateNo`, `Model`, `Beds`, `IsAccessible`, `Km`, `Price`, `EngineBlockNo`) VALUES ('AI 00776', 'A', '4', 'YES', '2232', '500', '8873823');
INSERT INTO `NordicMotorhome_db`.`Motorhome` (`LicensPlateNo`, `Model`, `Beds`, `IsAccessible`, `Km`, `Price`, `EngineBlockNo`) VALUES ('AI 11233', 'A', '6', 'YES', '22324', '475', '4232344');
INSERT INTO `NordicMotorhome_db`.`Motorhome` (`LicensPlateNo`, `Model`, `Beds`, `IsAccessible`, `Km`, `Price`, `EngineBlockNo`) VALUES ('AJ 77362', 'B', '2', 'YES', '78736', '350', '8843672');
INSERT INTO `NordicMotorhome_db`.`Motorhome` (`LicensPlateNo`, `Model`, `Beds`, `IsAccessible`, `Km`, `Price`, `EngineBlockNo`) VALUES ('AJ 22637', 'B', '4', 'YES', '2636', '300', '8836736');
INSERT INTO `NordicMotorhome_db`.`Motorhome` (`LicensPlateNo`, `Model`, `Beds`, `IsAccessible`, `Km`, `Price`, `EngineBlockNo`) VALUES ('AJ 77372', 'B', '6', 'YES', '2322', '400', '0093737');
INSERT INTO `NordicMotorhome_db`.`Motorhome` (`LicensPlateNo`, `Model`, `Beds`, `IsAccessible`, `Km`, `Price`, `EngineBlockNo`) VALUES ('AK 22239', 'C', '2', 'YES', '1111', '333', '3283923');
INSERT INTO `NordicMotorhome_db`.`Motorhome` (`LicensPlateNo`, `Model`, `Beds`, `IsAccessible`, `Km`, `Price`, `EngineBlockNo`) VALUES ('AK 23323', 'C', '4', 'YES', '2239', '394', '6662736');
INSERT INTO `NordicMotorhome_db`.`Motorhome` (`LicensPlateNo`, `Model`, `Beds`, `IsAccessible`, `Km`, `Price`, `EngineBlockNo`) VALUES ('AK 99938', 'C', '6', 'YES', '1992', '883', '5637272');

-- ---------------------------------- INVOICES DUMMYDATA -------------------------------------
INSERT INTO `NordicMotorhome_db`.`Invoice` (`DateStart`, `DateEnd`, `TotalPrice`, `Employee_id_fk`, `Customer_id_fk`, `Accessory_id_fk`, `Motorhome_LicensPlateNo`) VALUES ('2019-02-06', '2019-02-25', '10250', '1', '9', '7', 'AF 63729');
INSERT INTO `NordicMotorhome_db`.`Invoice` (`DateStart`, `DateEnd`, `TotalPrice`, `Employee_id_fk`, `Customer_id_fk`, `Accessory_id_fk`, `Motorhome_LicensPlateNo`) VALUES ('2019-05-09', '2019-05-20', '8500', '1', '13', '8', 'AH 00023');
INSERT INTO `NordicMotorhome_db`.`Invoice` (`DateStart`, `DateEnd`, `TotalPrice`, `Employee_id_fk`, `Customer_id_fk`, `Accessory_id_fk`, `Motorhome_LicensPlateNo`) VALUES ('2019-12-20', '2020-01-10', '15000', '1', '10', '8', 'AA 34253');

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
