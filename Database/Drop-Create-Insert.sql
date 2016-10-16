DROP TABLE IF EXISTS `currency`.`bank_currency`;
DROP TABLE IF EXISTS `currency`.`currency`;
DROP TABLE IF EXISTS `currency`.`bank`;
DROP TABLE IF EXISTS `currency`.`user`;


CREATE TABLE IF  NOT  EXISTS `currency`.`bank` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `short_name` VARCHAR(15) NOT NULL,
  `description` VARCHAR(155) NULL,
  PRIMARY KEY (`id`));

  
CREATE TABLE IF  NOT  EXISTS `currency`.`currency` (
  `id`  INT NOT NULL AUTO_INCREMENT,
  `SHORT_NAME` VARCHAR(10) NOT NULL,
  `DESCRIPTION` VARCHAR(85) NULL,
  `BANK_BUYS_VALUE` DOUBLE NOT NULL,
  `BANK_SELLS_VALUE` DOUBLE NOT NULL,
  `CURRENCY_DATE` DATE NOT NULL,
  `CREATION_DATE` DATETIME NOT NULL,
  `UPDATE_DATE` DATETIME NULL,
  
  PRIMARY KEY (`id`),
  UNIQUE INDEX `short_name_UNIQUE` (`SHORT_NAME` ASC));
  
 
CREATE TABLE IF  NOT  EXISTS `currency`.`bank_currency` (
  `id_bank_currency` INT NOT NULL AUTO_INCREMENT,
  `bank_id` INT NULL,
  `currency_id` INT NULL,
  PRIMARY KEY (`id_bank_currency`),
  INDEX `bank_id_idx` (`bank_id` ASC),
  INDEX `currency_id_idx` (`currency_id` ASC),
  CONSTRAINT `bank_id`
    FOREIGN KEY (`bank_id`)
    REFERENCES `currency`.`bank` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `currency_id`
    FOREIGN KEY (`currency_id`)
    REFERENCES `currency`.`currency` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `currency`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `full_name` VARCHAR(45) NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC));

	

	/* inserting rows */
	
		/* inserting banks*/
INSERT INTO `currency`.`bank` (`short_name`, `description`) VALUES ('ING', 'ING BANK');
INSERT INTO `currency`.`bank` (`short_name`, `description`) VALUES ('BNR', 'Banca Nationala a Romaniei');
INSERT INTO `currency`.`bank` (`short_name`, `description`) VALUES ('BCR', 'Banca Comerciala Romana');
INSERT INTO `currency`.`bank` (`short_name`, `description`) VALUES ('BRD', 'Banca Romana de Dezvoltare');
INSERT INTO `currency`.`bank` (`short_name`, `description`) VALUES ('OTP', 'OTP Bank');
INSERT INTO `currency`.`bank` (`short_name`, `description`) VALUES ('CEC', 'Casa de Economii si Consemnatiuni');
INSERT INTO `currency`.`bank` (`short_name`, `description`) VALUES ('Eximbank', 'Eximbank');
INSERT INTO `currency`.`bank` (`short_name`, `description`) VALUES ('Idea', 'Idea Bank');

/* inserting currencies*/
INSERT INTO `currency`.`currency` (`short_name`, `description`, `currency_date`, `creation_date`) VALUES ('RON', 'Romanian Leu', SYSDATE(), SYSDATE());
INSERT INTO `currency`.`currency` (`short_name`, `description`, `currency_date`, `creation_date`) VALUES ('USD', 'United Stats Dolar', SYSDATE(), SYSDATE());
INSERT INTO `currency`.`currency` (`short_name`, `description`, `currency_date`, `creation_date`) VALUES ('CAD', 'Canadian Dolar', SYSDATE(), SYSDATE());
INSERT INTO `currency`.`currency` (`short_name`, `description`, `currency_date`, `creation_date`) VALUES ('EUR', 'European Union Euro', SYSDATE(), SYSDATE());
INSERT INTO `currency`.`currency` (`short_name`, `description`, `currency_date`, `creation_date`) VALUES ('GBP', 'Great Britain Pound', SYSDATE(), SYSDATE());
INSERT INTO `currency`.`currency` (`short_name`, `description`, `currency_date`, `creation_date`) VALUES ('BGN', 'Bulgarian Leva', SYSDATE(), SYSDATE());

/* inserting users*/
INSERT INTO `currency`.`user` (`username`, `full_name`, `password`) VALUES ('user', 'user', 'user');
INSERT INTO `currency`.`user` (`username`, `full_name`, `password`) VALUES ('admin', 'admin', 'admin');

