-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema NMR_db
-- -----------------------------------------------------
DROP DATABASE IF EXISTS `NMR_db`;
-- -----------------------------------------------------
-- Schema NMR_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `NMR_db` DEFAULT CHARACTER SET utf8 ;
USE `NMR_db` ;

-- -----------------------------------------------------
-- Table `NMR_db`.`Customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `NMR_db`.`Customer` (
  `Customer_id` INT NOT NULL AUTO_INCREMENT,
  `CustomerName` VARCHAR(45) NULL,
  `Address` VARCHAR(45) NULL,
  `Zipcode` VARCHAR(45) NULL,
  `Phone` INT NULL,
  `Email` VARCHAR(45) NULL,
  `CustomerType` VARCHAR(45) NULL,
  PRIMARY KEY (`Customer_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `NMR_db`.`Motorhome`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `NMR_db`.`Motorhome` (
  `LicensPlateNo` VARCHAR(10) NOT NULL,
  `Model` VARCHAR(45) NULL,
  `Beds` INT NULL,
  `Accessible` VARCHAR(45) NULL,
  `Km` DOUBLE NULL,
  `Price` DOUBLE NULL,
  `EngineBlockNo` INT NULL,
  PRIMARY KEY (`LicensPlateNo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `NMR_db`.`Accessories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `NMR_db`.`Accessories` (
  `Accessory_id` INT NOT NULL AUTO_INCREMENT,
  `AccessoryType` VARCHAR(45) NULL,
  `Price` DOUBLE NULL,
  PRIMARY KEY (`Accessory_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `NMR_db`.`Employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `NMR_db`.`Employee` (
  `Employee_id` INT NOT NULL AUTO_INCREMENT,
  `EmpName` VARCHAR(45) NULL,
  `Position` VARCHAR(45) NULL,
  `Address` VARCHAR(45) NULL,
  `Zipcode` VARCHAR(45) NULL,
  `Phone` INT NULL,
  `Email` VARCHAR(45) NULL,
  PRIMARY KEY (`Employee_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `NMR_db`.`Invoice`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `NMR_db`.`Invoice` (
  `Invoice_id` INT NOT NULL AUTO_INCREMENT,
  `DateStart` DATE NULL,
  `DateEnd` DATE NULL,
  `PickUp` VARCHAR(45) NULL,
  `DropOff` VARCHAR(45) NULL,
  `TotalPrice` DOUBLE NULL,
  `Employee_id_fk` INT NOT NULL,
  `Customer_id_fk` INT NOT NULL,
  `Accessory_id_fk` INT NOT NULL,
  `Motorhome_LicensPlateNo` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`Invoice_id`),
  INDEX `fk_Invoice_Employee_idx` (`Employee_id_fk` ASC) VISIBLE,
  INDEX `fk_Invoice_Customer1_idx` (`Customer_id_fk` ASC) VISIBLE,
  INDEX `fk_Invoice_Accessories1_idx` (`Accessory_id_fk` ASC) VISIBLE,
  INDEX `fk_Invoice_Motorhome1_idx` (`Motorhome_LicensPlateNo` ASC) VISIBLE,
  CONSTRAINT `fk_Invoice_Employee`
    FOREIGN KEY (`Employee_id_fk`)
    REFERENCES `NMR_db`.`Employee` (`Employee_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Invoice_Customer1`
    FOREIGN KEY (`Customer_id_fk`)
    REFERENCES `NMR_db`.`Customer` (`Customer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Invoice_Accessories1`
    FOREIGN KEY (`Accessory_id_fk`)
    REFERENCES `NMR_db`.`Accessories` (`Accessory_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Invoice_Motorhome1`
    FOREIGN KEY (`Motorhome_LicensPlateNo`)
    REFERENCES `NMR_db`.`Motorhome` (`LicensPlateNo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO employee (EmpName, Position, Address, Zipcode, Phone, Email)
	VALUES ("Erik Hansen", "Sales", "Klostergade 2", "2820 Gentofte", "23546765", "eh@nmr.dk"),
		("Sally Jensen", "Sales", "Blommevej 93", "2870 Dyssegård", "23546769", "sj@nmr.dk"),
        ("Klaus Møller", "Sales", "Svinget 6", "22791 Dragør", "23546763", "km@nmr.dk"),
        ("Connie Clausen", "Sales", "Hjørnet 1", "2770 Kastrup", "23546761", "eh@nmr.dk"),
        ("Flemming Sørensen", "Repairs", "Elmevej 66", "2800 Kongens Lyngby", "23546768", "fs@nmr.dk"),
        ("Gregers Jørn", "Cleaning", "Mågegade 12", "2740 Skovlunde", "23546764", "gj@nmr.dk");
        
INSERT INTO Motorhome 
	VALUES ("NK 34982", "A", 2, "YES", "56984.00", "1500.00", 13273),
			("SL 84632", "A", 4, "YES", "13833.00", "2500.00", 75633),
            ("BL 73410", "A", 6, "YES", "73538.00", "4500.00", 98254),
            ("KP 65233", "B", 2, "YES", "64538.00", "2000.00", 83726),
            ("BA 92527", "B", 4, "YES", "33984.00", "3500.00", 65667),
            ("RT 27546", "B", 6, "YES", "23415.00", "5500.00", 99833);
        
INSERT INTO customer (CustomerName, Address, Zipcode, Phone, Email, CustomerType)
			VALUES ("Lars Larsen","Nørrebrogade 165", "2200 KBH N", 34536725, "ll@mail.dk", "Privat"),
					("Bent Eskildsen","Horsekildevej 27", "2500 Valby", 76452493, "be@mail.dk", "Privat"),
                    ("Søren Sejr","Gaden 69", "2650 Hvidovre", 89653728, "sns@mail.dk", "Privat"),
                    ("Ellen Erling","Vestervang 73", "2635 Ishøj", 76584930, "ee@mail.dk", "Privat"),
                    ("Spejderklubben","Markvej 64", "3520 Farum", 65748392, "spejderne@mail.dk", "Erhverv"),
                    ("Oldingene","Borgmester Alle 92", "3150 Hellebæk", 22323452, "old@mail.dk", "Erhverv");
                    
INSERT INTO invoice (DateStart, DateEnd, PickUp, DropOff, TotalPrice, Employee_id_fk, Customer_id_fk, Motorhome_LicensPlateNo, Accessory_id_fk)
	VALUES ("2019-07-12", "2019-07-26", "YES", "NO", "9300.00", 3, 2, "BL 73410", 3),
			("2019-05-04", "2019-05-25", "NO", "NO", "9300.00", 1, 4, "RT 27546", 3),
			("2019-06-21", "2019-07-05", "YES", "YES", "11300.00", 2, 3, "KP 65233", 2); 
            
INSERT INTO accessories (AccessoryType, Price)
	VALUES ("Mountainbike", "250.00"),
		   ("Folding bike", "150.00"),
           ("Golfset", "300.00"),
           ("Tent small", "50.00"),
           ("Tent large", "95.00");


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
