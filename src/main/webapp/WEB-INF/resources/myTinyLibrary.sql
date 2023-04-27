-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';


-- -----------------------------------------------------
-- Schema MYTINYLIBRARY
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `MYTINYLIBRARY` DEFAULT CHARACTER SET utf8mb3 ;
USE `MYTINYLIBRARY` ;

-- -----------------------------------------------------
-- Table `MYTINYLIBRARY`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MYTINYLIBRARY`.`user` (
  `id` VARCHAR(25) NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  `email` VARCHAR(30) NOT NULL,
  `joindate` TIMESTAMP NOT NULL DEFAULT now(),
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `MYTINYLIBRARY`.`authors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MYTINYLIBRARY`.`authors` (
  `idx` INT NOT NULL AUTO_INCREMENT,
  `id` VARCHAR(25) NOT NULL,
  `author_name` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`idx`),
  INDEX `id` (`id` ASC) VISIBLE,
  CONSTRAINT `authors_id_to_user_id`
    FOREIGN KEY (`id`)
    REFERENCES `MYTINYLIBRARY`.`user` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `MYTINYLIBRARY`.`book`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MYTINYLIBRARY`.`book` (
  `isbn` CHAR(20) NOT NULL,
  `type` VARCHAR(20) NULL DEFAULT 'book',
  `title` VARCHAR(100) NOT NULL,
  `author` VARCHAR(50) NOT NULL,
  `author_idx` INT NULL DEFAULT NULL,
  `price` INT NOT NULL,
  `desc` TEXT NULL DEFAULT NULL,
  `img` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`isbn`),
  INDEX `author_idx` (`author_idx` ASC) VISIBLE,
  CONSTRAINT `book_author_idx_to_authors_idx`
    FOREIGN KEY (`author_idx`)
    REFERENCES `MYTINYLIBRARY`.`authors` (`idx`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `MYTINYLIBRARY`.`reserveInfo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MYTINYLIBRARY`.`reserveInfo` (
  `idx` INT NOT NULL AUTO_INCREMENT,
  `isbn` CHAR(20) NOT NULL,
  `user_id` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`idx`),
  UNIQUE INDEX `idx_UNIQUE` (`idx` ASC) VISIBLE,
  INDEX `reserveInfo_isbn_to_book_isbn_idx` (`isbn` ASC) VISIBLE,
  INDEX `reserveInfo_user_id_to_user_id_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `reserveInfo_isbn_to_book_isbn`
    FOREIGN KEY (`isbn`)
    REFERENCES `MYTINYLIBRARY`.`book` (`isbn`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `reserveInfo_user_id_to_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `MYTINYLIBRARY`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `MYTINYLIBRARY` ;

-- -----------------------------------------------------
-- Table `MYTINYLIBRARY`.`comicbook`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MYTINYLIBRARY`.`comicbook` (
  `isbn` CHAR(20) NOT NULL,
  `color` TINYINT(1) NULL DEFAULT '0',
  INDEX `isbn` (`isbn` ASC) VISIBLE,
  UNIQUE INDEX `isbn_UNIQUE` (`isbn` ASC) VISIBLE,
  CONSTRAINT `comicbook_isbn_to_book_isbn`
    FOREIGN KEY (`isbn`)
    REFERENCES `MYTINYLIBRARY`.`book` (`isbn`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `MYTINYLIBRARY`.`magazine`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MYTINYLIBRARY`.`magazine` (
  `isbn` CHAR(20) NOT NULL,
  `publicated_month` DATE NULL DEFAULT NULL,
  `month_cycle` INT NULL DEFAULT '1',
  INDEX `isbn` (`isbn` ASC) VISIBLE,
  UNIQUE INDEX `isbn_UNIQUE` (`isbn` ASC) VISIBLE,
  CONSTRAINT `magazine_isbn_to_book_isbn`
    FOREIGN KEY (`isbn`)
    REFERENCES `MYTINYLIBRARY`.`book` (`isbn`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
