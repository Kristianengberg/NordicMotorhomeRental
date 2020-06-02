-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema NMR_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema NMR_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `NMR_db` DEFAULT CHARACTER SET utf8 ;
USE `NMR_db` ;

-- -----------------------------------------------------
-- Table `NMR_db`.`Accessories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `NMR_db`.`Accessories` (
  `Accessory_id` INT NOT NULL AUTO_INCREMENT,
  `AccessoryType` VARCHAR(45) NULL DEFAULT NULL,
  `Price` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`Accessory_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `NMR_db`.`Customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `NMR_db`.`Customer` (
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
-- Table `NMR_db`.`Employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `NMR_db`.`Employee` (
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
-- Table `NMR_db`.`Motorhome`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `NMR_db`.`Motorhome` (
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
-- Table `NMR_db`.`Invoice`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `NMR_db`.`Invoice` (
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
    REFERENCES `NMR_db`.`Accessories` (`Accessory_id`),
  CONSTRAINT `fk_Invoice_Customer1`
    FOREIGN KEY (`Customer_id_fk`)
    REFERENCES `NMR_db`.`Customer` (`Customer_id`),
  CONSTRAINT `fk_Invoice_Motorhome1`
    FOREIGN KEY (`Motorhome_LicensPlateNo`)
    REFERENCES `NMR_db`.`Motorhome` (`LicensPlateNo`))
ENGINE = InnoDB
AUTO_INCREMENT = 30
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
