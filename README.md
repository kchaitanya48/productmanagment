CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE
utf8_general_ci ;
USE `mydb` ;
-- -----------------------------------------------------
-- Table `mydb`.`Customers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`users` (
`user_id` INT NOT NULL ,
`name` TEXT NOT NULL ,
`password` VARCHAR(256) NULL ,
`role` VARCHAR(45) NULL,
PRIMARY KEY (`user_id`) )
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `mydb`.`Orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Orders` (
`ID` INT NOT NULL ,
`user_id` INT NULL ,
PRIMARY KEY (`ID`) ,
INDEX `fk_Order_1_idx` (`user_id` ASC) ,
CONSTRAINT `fk_Order_1`
FOREIGN KEY (`user_id` )
REFERENCES `mydb`.`users` (`user_id` )
ON DELETE NO ACTION
ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`Products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Products` (
`ID` INT NOT NULL ,
`Name` VARCHAR(45) NOT NULL ,
`Description` TEXT NULL ,

`Price` INT NOT NULL,
PRIMARY KEY (`ID`) )
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `mydb`.`OrderItems`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`OrderItems` (
`ID` INT NOT NULL ,
`Order_ID` INT NOT NULL ,
`Product_ID` INT NOT NULL ,
`Quantity` INT NOT NULL ,
PRIMARY KEY (`ID`) ,
INDEX `fk_OrderItem_1_idx` (`Order_ID` ASC) ,
INDEX `fk_OrderItem_2_idx` (`Product_ID` ASC) ,
CONSTRAINT `fk_OrderItem_1`
FOREIGN KEY (`Order_ID` )
REFERENCES `mydb`.`Orders` (`ID` )
ON DELETE NO ACTION
ON UPDATE NO ACTION,
CONSTRAINT `fk_OrderItem_2`
FOREIGN KEY (`Product_ID` )
REFERENCES `mydb`.`Products` (`ID` )
ON DELETE NO ACTION
ON UPDATE NO ACTION)
ENGINE = InnoDB;
USE `mydb` ;
