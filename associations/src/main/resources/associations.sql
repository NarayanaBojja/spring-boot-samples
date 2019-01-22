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
 
    CREATE TABLE `associations`.`hostel_owner` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `mobile` BIGINT NOT NULL,
  PRIMARY KEY (`id`));

  CREATE TABLE `associations`.`hostel_details` (
  `hid` INT NOT NULL AUTO_INCREMENT,
  `hostel_name` VARCHAR(45) NOT NULL,
  `owner_id` INT NOT NULL,
  PRIMARY KEY (`hid`),
  INDEX `FK_OWNER_ID_idx` (`owner_id` ASC),
  CONSTRAINT `FK_OWNER_ID`
    FOREIGN KEY (`owner_id`)
    REFERENCES `associations`.`hostel_owner` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
CREATE TABLE `associations`.`tags` (
  `id` BIGINT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));
  
  
CREATE TABLE `associations`.`posts` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
)

CREATE TABLE `associations`.`post_tags` (
  `post_id` bigint(20) NOT NULL,
  `tag_id` bigint(20) NOT NULL,
  PRIMARY KEY (`post_id`,`tag_id`),
  KEY `FK_tags_id_idx` (`tag_id`),
  CONSTRAINT `pid` FOREIGN KEY (`post_id`) REFERENCES `associations`.`posts` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tid` FOREIGN KEY (`tag_id`) REFERENCES `associations`.`tags` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
)
