-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Grupo-14-BDD-OO2-2021` DEFAULT CHARACTER SET utf8 ;
USE `Grupo-14-BDD-OO2-2021` ;

-- -----------------------------------------------------
-- Table `Grupo-14-BDD-OO2-2021`.`Perfil`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Grupo-14-BDD-OO2-2021`.`Perfil` (
  `idPerfil` INT NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(45) NULL,
  PRIMARY KEY (`idPerfil`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Grupo-14-BDD-OO2-2021`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Grupo-14-BDD-OO2-2021`.`Usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  `tipoDocumento` VARCHAR(45) NULL,
  `numeroDocumento` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `nomUsuario` VARCHAR(45) NULL,
  `contraseña` VARCHAR(45) NULL,
  `idPerfil` INT NOT NULL,
  PRIMARY KEY (`idUsuario`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
