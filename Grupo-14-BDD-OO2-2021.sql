-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema grupo-14-bdd-oo2-2021
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema grupo-14-bdd-oo2-2021
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `grupo-14-bdd-oo2-2021` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `grupo-14-bdd-oo2-2021` ;

-- -----------------------------------------------------
-- Table `grupo-14-bdd-oo2-2021`.`perfil`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo-14-bdd-oo2-2021`.`perfil` (
  `id_perfil` INT NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id_perfil`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `grupo-14-bdd-oo2-2021`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo-14-bdd-oo2-2021`.`usuario` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `apellido` VARCHAR(255) NOT NULL,
  `contraseña` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `nom_usuario` VARCHAR(255) NOT NULL,
  `nombre` VARCHAR(255) NOT NULL,
  `numero_documento` INT NOT NULL,
  `tipo_documento` VARCHAR(255) NOT NULL,
  `id_perfil` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  INDEX `FK131gkl0dt1966rsw6dmesnsxw` (`id_perfil` ASC) VISIBLE,
  CONSTRAINT `FK131gkl0dt1966rsw6dmesnsxw`
    FOREIGN KEY (`id_perfil`)
    REFERENCES `grupo-14-bdd-oo2-2021`.`perfil` (`id_perfil`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
