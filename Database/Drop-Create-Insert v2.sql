DROP TABLE IF EXISTS `currency`.`audit`;
DROP TABLE IF EXISTS `currency`.`bank_currency`;
DROP TABLE IF EXISTS `currency`.`currency`;
DROP TABLE IF EXISTS `currency`.`bank`;
DROP TABLE IF EXISTS `currency`.`user`;



CREATE TABLE IF  NOT  EXISTS `currency`.`bank` (
  `id` BIGINT(8) UNSIGNED  NOT NULL AUTO_INCREMENT,
  `short_name` VARCHAR(15) NOT NULL,
  `description` VARCHAR(155) NULL,
  PRIMARY KEY (`id`));

  
CREATE TABLE IF  NOT  EXISTS `currency`.`currency` (
  `id` BIGINT(8) UNSIGNED  NOT NULL AUTO_INCREMENT,
  `short_name` VARCHAR(10) NOT NULL,
  `description` VARCHAR(85) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `short_name_UNIQUE` (`SHORT_NAME` ASC));
  
 
CREATE TABLE IF  NOT  EXISTS `currency`.`bank_currency` (
  `id` BIGINT(8) UNSIGNED  NOT NULL AUTO_INCREMENT,
  `bank_id` BIGINT(8) UNSIGNED  NOT NULL,
  `currency_id` BIGINT(8) UNSIGNED  NOT NULL,	
  `bank_buys_value` DOUBLE NOT NULL,
  `bank_sells_Value` DOUBLE NOT NULL,
  `currency_date` DATE NOT NULL,
  `creation_date` DATETIME NOT NULL,
  `update_date` DATETIME NULL,
  `deleted` TINYINT(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
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
  `id` BIGINT(8) UNSIGNED  NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `full_name` VARCHAR(45) NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC));

	
CREATE TABLE `audit` (
	`id` BIGINT(8) UNSIGNED  NOT NULL AUTO_INCREMENT,
	`bank_currency_id` BIGINT(8) UNSIGNED  NOT NULL,
	`changetype` enum('NEW','EDIT','DELETE') NOT NULL,
	`changetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`changeuser` varchar(45),
	PRIMARY KEY (`id`),
	KEY `ix_bank_currency_id` (`bank_currency_id`),
	KEY `ix_changetype` (`changetype`),
	KEY `ix_changetime` (`changetime`),
	CONSTRAINT `FK_audit_bank_currency_id` FOREIGN KEY (`bank_currency_id`) REFERENCES `bank_currency` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;	

/* DEFINING AUDIT TRIGGERS*/

DELIMITER $$
	
CREATE
	TRIGGER `bank_currency_after_insert` AFTER INSERT 
	ON `bank_currency` 
	FOR EACH ROW BEGIN
	
	DECLARE vUser varchar(50);
	   -- Find username of person performing the DELETE into table
	   SELECT USER() INTO vUser;

		IF NEW.deleted THEN
			SET @changetype = 'DELETE';
		ELSE
			SET @changetype = 'NEW';
		END IF;
    
		INSERT INTO `currency`.`audit` (bank_currency_id, changetype, changetime, changeuser) VALUES (NEW.id, @changetype, SYSDATE(), vUser);
		
END$$
    
CREATE
	TRIGGER `bank_currency_after_update` AFTER UPDATE 
	ON `bank_currency` 
	FOR EACH ROW BEGIN
	
	DECLARE vUser varchar(50);
	   -- Find username of person performing the DELETE into table
	   SELECT USER() INTO vUser;

		IF NEW.deleted THEN
			SET @changetype = 'DELETE';
		ELSE
			SET @changetype = 'EDIT';	
		END IF;
    
		INSERT INTO `currency`.`audit` (bank_currency_id, changetype, changetime, changeuser) VALUES (NEW.id, @changetype, SYSDATE(), vUser);
		
END$$

/* -- delete is no longer possible because of foreign key in audit table. Delete will be only logical
CREATE TRIGGER bank_currency_after_delete
	AFTER DELETE
	   ON `currency`.`bank_currency` FOR EACH ROW

	BEGIN

	   DECLARE vUser varchar(50);

	   -- Find username of person performing the DELETE into table
	   SELECT USER() INTO vUser;

	   -- Insert record into audit table
	   
		INSERT INTO `currency`.`audit` (bank_currency_id, changetype, changetime, changeuser) 
        VALUES (OLD.id, @changetype, SYSDATE(), vUser);
	END; $$
  */  
DELIMITER ;    


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
INSERT INTO `currency`.`currency` (`short_name`, `description`) VALUES ('RON', 'Romanian Leu');
INSERT INTO `currency`.`currency` (`short_name`, `description`) VALUES ('USD', 'United Stats Dolar');
INSERT INTO `currency`.`currency` (`short_name`, `description`) VALUES ('CAD', 'Canadian Dolar');
INSERT INTO `currency`.`currency` (`short_name`, `description`) VALUES ('EUR', 'European Union Euro');
INSERT INTO `currency`.`currency` (`short_name`, `description`) VALUES ('GBP', 'Great Britain Pound');
INSERT INTO `currency`.`currency` (`short_name`, `description`) VALUES ('BGN', 'Bulgarian Leva');
INSERT INTO `currency`.`currency` (`short_name`, `description`) VALUES ('AUD', 'Australian dollar');
INSERT INTO `currency`.`currency` (`short_name`, `description`) VALUES ('DKK', 'Danish Krone');
INSERT INTO `currency`.`currency` (`short_name`, `description`) VALUES ('CHF', 'Swiss Franc');
INSERT INTO `currency`.`currency` (`short_name`, `description`) VALUES ('HUF', 'Hungarian forint');
INSERT INTO `currency`.`currency` (`short_name`, `description`) VALUES ('JPY', 'Japanese Yen');
INSERT INTO `currency`.`currency` (`short_name`, `description`) VALUES ('NOK', 'Norwegian Krone');
INSERT INTO `currency`.`currency` (`short_name`, `description`) VALUES ('SEK', 'Swedish Krona');



/* inserting currencies for every bank*/

INSERT INTO `currency`.`bank_currency` (`bank_id`, `currency_id`, `bank_buys_value`, `bank_sells_Value`, `currency_date`, `creation_date`) VALUES ('1', '1', '4.5754', '4.7443', SYSDATE(), SYSDATE());
INSERT INTO `currency`.`bank_currency` (`bank_id`, `currency_id`, `bank_buys_value`, `bank_sells_Value`, `currency_date`, `creation_date`) VALUES ('1', '2', '3.4343', '3.6435', SYSDATE(), SYSDATE());
INSERT INTO `currency`.`bank_currency` (`bank_id`, `currency_id`, `bank_buys_value`, `bank_sells_Value`, `currency_date`, `creation_date`) VALUES ('1', '3', '2.2232', '2.4343', SYSDATE(), SYSDATE());
INSERT INTO `currency`.`bank_currency` (`bank_id`, `currency_id`, `bank_buys_value`, `bank_sells_Value`, `currency_date`, `creation_date`) VALUES ('1', '4', '4.5734', '5.3434', SYSDATE(), SYSDATE());
INSERT INTO `currency`.`bank_currency` (`bank_id`, `currency_id`, `bank_buys_value`, `bank_sells_Value`, `currency_date`, `creation_date`) VALUES ('2', '1', '1.0102', '1.2332', SYSDATE(), SYSDATE());
INSERT INTO `currency`.`bank_currency` (`bank_id`, `currency_id`, `bank_buys_value`, `bank_sells_Value`, `currency_date`, `creation_date`) VALUES ('2', '2', '0.1910', '0.2130', SYSDATE(), SYSDATE());
INSERT INTO `currency`.`bank_currency` (`bank_id`, `currency_id`, `bank_buys_value`, `bank_sells_Value`, `currency_date`, `creation_date`) VALUES ('2', '3', '4.5743', '9.2032', SYSDATE(), SYSDATE());
INSERT INTO `currency`.`bank_currency` (`bank_id`, `currency_id`, `bank_buys_value`, `bank_sells_Value`, `currency_date`, `creation_date`) VALUES ('2', '4', '3.8998', '3.9583', SYSDATE(), SYSDATE());
INSERT INTO `currency`.`bank_currency` (`bank_id`, `currency_id`, `bank_buys_value`, `bank_sells_Value`, `currency_date`, `creation_date`) VALUES ('3', '1', '4.1939', '4.2938', SYSDATE(), SYSDATE());
INSERT INTO `currency`.`bank_currency` (`bank_id`, `currency_id`, `bank_buys_value`, `bank_sells_Value`, `currency_date`, `creation_date`) VALUES ('3', '2', '5.2938', '5.3928', SYSDATE(), SYSDATE());
INSERT INTO `currency`.`bank_currency` (`bank_id`, `currency_id`, `bank_buys_value`, `bank_sells_Value`, `currency_date`, `creation_date`) VALUES ('3', '3', '88.3232', '89.3833', SYSDATE(), SYSDATE());
INSERT INTO `currency`.`bank_currency` (`bank_id`, `currency_id`, `bank_buys_value`, `bank_sells_Value`, `currency_date`, `creation_date`) VALUES ('3', '4', '54.3233', '53.2323', SYSDATE(), SYSDATE());


/* inserting users*/
INSERT INTO `currency`.`user` (`username`, `full_name`, `password`) VALUES ('user', 'user', 'user');
INSERT INTO `currency`.`user` (`username`, `full_name`, `password`) VALUES ('admin', 'admin', 'admin');

