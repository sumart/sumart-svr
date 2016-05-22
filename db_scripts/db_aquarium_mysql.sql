SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `db_aqua` ;
CREATE SCHEMA IF NOT EXISTS `db_aqua` DEFAULT CHARACTER SET utf8 ;
USE `db_aqua` ;

-- -----------------------------------------------------
-- Table `db_aqua`.`tbl_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_aqua`.`tbl_user` ;

CREATE  TABLE IF NOT EXISTS `db_aqua`.`tbl_user` (
  `id` VARCHAR(100) NOT NULL COMMENT '사용자 ID' ,
  `name` VARCHAR(30) NULL COMMENT '사용자 이름' ,
  `category` CHAR(2) NULL COMMENT '사용자 분류코드 : GU / GS / SA\nGU : 일반 사용자\nGS : 일반 상인\nSA : 슈퍼 어드민 (시스템관리자)' ,
  `cert_code` VARCHAR(100) NULL ,
  `phone_number` VARCHAR(30) NULL ,
  `device_type` VARCHAR(10) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
COMMENT = '		';


-- -----------------------------------------------------
-- Table `db_aqua`.`tbl_shop`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_aqua`.`tbl_shop` ;

CREATE  TABLE IF NOT EXISTS `db_aqua`.`tbl_shop` (
  `id` CHAR(32) NOT NULL ,
  `name` VARCHAR(45) NULL ,
  `tel_numbers` VARCHAR(100) NULL ,
  `tel_names` VARCHAR(200) NULL ,
  `open_hours` VARCHAR(100) NULL ,
  `biz_comment` VARCHAR(100) NULL ,
  `short_comment` VARCHAR(200) NULL ,
  `introduction` TEXT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_aqua`.`tbl_shop_staff`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_aqua`.`tbl_shop_staff` ;

CREATE  TABLE IF NOT EXISTS `db_aqua`.`tbl_shop_staff` (
  `tbl_user_id` INT NOT NULL ,
  `tbl_shop_id` INT NOT NULL ,
  `privilege` INT NULL COMMENT '권한코드' ,
  INDEX `fk_tbl_shop_member_tbl_user_idx` (`tbl_user_id` ASC) ,
  INDEX `fk_tbl_shop_member_tbl_shop1_idx` (`tbl_shop_id` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_aqua`.`tbl_location`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_aqua`.`tbl_location` ;

CREATE  TABLE IF NOT EXISTS `db_aqua`.`tbl_location` (
  `id` CHAR(32) NOT NULL ,
  `tbl_shop_id` INT NOT NULL ,
  `name` VARCHAR(45) NULL ,
  `lat` DOUBLE NULL ,
  `long` DOUBLE NULL ,
  `country` VARCHAR(10) NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_tbl_location_tbl_shop1_idx` (`tbl_shop_id` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_aqua`.`tbl_code_master`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_aqua`.`tbl_code_master` ;

CREATE  TABLE IF NOT EXISTS `db_aqua`.`tbl_code_master` (
  `table_name` VARCHAR(45) NOT NULL ,
  `column_name` VARCHAR(100) NOT NULL ,
  `type` VARCHAR(20) NULL ,
  `code` VARCHAR(45) NULL ,
  `name` VARCHAR(45) NULL ,
  `description` VARCHAR(200) NULL ,
  PRIMARY KEY (`column_name`, `table_name`) )
ENGINE = InnoDB
COMMENT = '	';

USE `db_aqua` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
