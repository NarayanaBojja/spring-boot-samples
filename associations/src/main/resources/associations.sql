CREATE SCHEMA `associations` ;

 CREATE TABLE `associations`.`person_details` (
  `id` int(11) NOT NULL,
  `email` varchar(45) NOT NULL,
  `mobile` bigint(20) NOT NULL,
  `adrdress` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) 

CREATE TABLE `associations`.`person` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `full_name` VARCHAR(45) NOT NULL,
  `age` INT NOT NULL,
  `person_detail_id` INT NOT NULL,
  PRIMARY KEY (`id`, `person_detail_id`),
  CONSTRAINT `FK_Persion_Det_ID`
    FOREIGN KEY (`id`)
    REFERENCES `associations`.`person_details` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);