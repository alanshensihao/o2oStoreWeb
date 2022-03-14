--
--	Current Databse: `o2o`
--

CREATE DATABASE `o2o`;
use o2o;

DROP TABLE IF EXISTS `tb_area`;
CREATE TABLE `tb_area`(
	`area_id` INT(2) NOT NULL AUTO_INCREMENT, -- area maximum 100 stores
    `area_name` VARCHAR(200) NOT NULL, -- name length, auto adjustment
    `priority` INT(2) NOT NULL DEFAULT '0',
    `create_time` datetime DEFAULT NULL,
    `last_edit_time` datetime DEFAULT NULL, --  datetime vs timestamp, datetime range is larger, timestamp adaptive time region
    PRIMARY KEY(`area_id`), 
    UNIQUE KEY `UK_AREA`(`area_name`) 
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8; -- MyISAM or InnoDB

SELECT *
FROM tb_area;

#### personInfo database ####

use o2o;
create table `tb_person_info` (
	`user_id` INT(10) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(32) DEFAULT NULL,
    `profile_img` varchar(1024) DEFAULT NULL,
    `email` VARCHAR(1024) DEFAULT NULL,
    `gender` VARCHAR(1024) DEFAULT NULL,
    `entable_status` INT(2) NOT NULL DEFAULT '0' COMMENT '0: disable ecommerce store, : enable ecommerce store',
    `user_type` INT(2) NOT NULL DEFAULT '1' COMMENT '1: customer, 2: store owner, 3: admin',
    `create_time` datetime DEFAULT NULL,
    `last_edit_time` datetime DEFAULT NULL,
    PRIMARY KEY(`user_id`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8;

use o2o;
CREATE TABLE `tb_head_line` (
	`line_id` INT(100) NOT NULL AUTO_INCREMENT,
    `line_name` VARCHAR(1000) DEFAULT NULL,
    `link_link` VARCHAR(2000) NOT NULL,
    `line_img` VARCHAR(2000) NOT NULL,
    `priority` INT(2) DEFAULT NULL,
    `enable_status` INT(2) NOT NULL DEFAULT '0',
    `create_time` DATETIME DEFAULT NULL,
    `last_edit_time` DATETIME DEFAULT NULL,
    PRIMARY KEY(`line_id`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8;

SELECT *
from `tb_head_line`;

### shop table creation ###
CREATE TABLE `tb_shop_category` (
		`shop_category_id` INT(11) NOT NULL AUTO_INCREMENT,
        `shop_category_name` VARCHAR(100) NOT NULL DEFAULT '',
        `shop_category_desc` VARCHAR(1000) DEFAULT '',
        `shop_category_img` VARCHAR(2000) DEFAULT NULL,
        `priority` INT(2) NOT NULL DEFAULT '0',
        `create_time` DATETIME DEFAULT NULL,
        `last_edit_time` DATETIME DEFAULT NULL,
        `parent_id` INT(11) DEFAULT NULL,
        PRIMARY KEY(`shop_category_id`),
        CONSTRAINT `fk_shop_category_self` FOREIGN KEY (`parent_id`) REFERENCES `tb_shop_category`(`shop_category_id`)
) ENGINE = InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET utf8;

SELECT *
from `tb_shop_category`;

DROP TABLE IF EXISTS `tb_shop`;
### shop instance class table ###
CREATE TABLE `tb_shop` (
	`shop_id` INT(10) NOT NULL AUTO_INCREMENT,
    `owner_id` INT(10) NOT NULL COMMENT 'shop owner',
    `area_id` INT(5) DEFAULT NULL,
    `shop_category_id` INT(11) NOT NULL,
    `shop_name` VARCHAR(256) NOT NULL,
    `shop_desc` VARCHAR(1024) DEFAULT NULL,
    `shop_addr` VARCHAR(200) DEFAULT NULL,
    `phone` VARCHAR(128) DEFAULT NULL,
    `shop_img` VARCHAR(1024) DEFAULT NULL,
    `priority` INT(3) DEFAULT '0',
    `create_time` DATETIME DEFAULT NULL,
    `last_edit_time` DATETIME DEFAULT NULL,
    `enable_status` INT(2) NOT NULL DEFAULT '0',
    `advice` VARCHAR(256) DEFAULT NULL,
    PRIMARY KEY (`shop_id`),
    KEY `fk_shop_area` (`area_id`),
    KEY `fk_shop_profile` (`owner_id`),
    KEY `fk_shop_shopcate` (`shop_category_id`),
    CONSTRAINT `fk_shop_area` FOREIGN KEY (`area_id`) REFERENCES `tb_area`(`area_id`),
    CONSTRAINT `fk_shop_profile` FOREIGN KEY(`owner_id`) REFERENCES `tb_person_info`(`user_id`),
    CONSTRAINT `fk_shop_shopcate` FOREIGN KEY(`shop_category_id`) REFERENCES `tb_shop_category`(`shop_category_id`)
) ENGINE = InnoDB AUTO_INCREMENT= 1 DEFAULT CHARSET=utf8;

SELECT *
from `tb_shop`;
DESCRIBE `tb_shop_category`;
DESCRIBE `tb_shop`;

CREATE TABLE `tb_product` (
  `product_id` int(100) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(100) NOT NULL,
  `product_desc` varchar(2000) DEFAULT NULL,
  `img_addr` varchar(2000) DEFAULT '',
  `normal_price` varchar(100) DEFAULT NULL,
  `promotion_price` varchar(100) DEFAULT NULL,
  `priority` int(2) NOT NULL DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `last_edit_time` datetime DEFAULT NULL,
  `enable_status` int(2) NOT NULL DEFAULT '0',
  `product_category_id` int(11) DEFAULT NULL,
  `shop_id` int(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`product_id`),
  KEY `fk_product_procate` (`product_category_id`),
  KEY `fk_product_shop` (`shop_id`),
  CONSTRAINT `fk_product_procate` FOREIGN KEY (`product_category_id`) REFERENCES `tb_product_category` (`product_category_id`),
  CONSTRAINT `fk_product_shop` FOREIGN KEY (`shop_id`) REFERENCES `tb_shop` (`shop_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

CREATE TABLE `tb_product_category` (
	`product_category_id` INT(11) NOT NULL AUTO_INCREMENT,
    `product_category_name` VARCHAR(100) NOT NULL,
    `priority` INT(2) DEFAULT '0',
    `create_time` DATETIME DEFAULT NULL,
    `shop_id` INT(20) NOT NULL DEFAULT '0',
    PRIMARY KEY (`product_category_id`),
    KEY `fk_procate_shop` (`shop_id`),
    CONSTRAINT `fk_procate_shop` FOREIGN KEY (`shop_id`) REFERENCES `tb_shop`(`shop_id`)
) ENGINE = InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET = utf8;

CREATE TABLE `tb_product_img` (
	`product_img_id` INT(20) NOT NULL AUTO_INCREMENT,
    `img_addr` VARCHAR(2000) NOT NULL,
    `img_desc` VARCHAR(2000) DEFAULT NULL,
    `priority` INT(2) DEFAULT '0',
    `create_time` DATETIME DEFAULT NULL,
    `product_id` INT(20) DEFAULT NULL,
    PRIMARY KEY (`product_img_id`),
    KEY `fk_proming_product` (`product_id`),
    CONSTRAINT `fk_proimg_product` FOREIGN KEY (`product_id`) REFERENCES `tb_product`(`product_id`)
) ENGINE = InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET = utf8;

INSERT INTO `tb_area` VALUES(1,"east end",1,NULL,NULL);
INSERT INTO `tb_area` VALUES(2,"west end",2,NULL,NULL);
INSERT INTO `tb_area` VALUES(3,"north end",3,NULL,NULL);

SELECT area_id,area_name,priority,create_time,last_edit_time
FROM tb_area 
ORDER BY priority DESC;

DELETE FROM `tb_person_info`
WHERE `user_id` = NULL;


SELECT *
FROM `tb_person_info`;

SELECT *
FROM `tb_shop_category`;

INSERT INTO `tb_person_info` VALUES(1,"test",NULL,"test",1,1,2,NULL,NULL);
INSERT INTO `tb_person_info` VALUES(NULL,"test2",NULL,"test",0,1,2,NULL,NULL);

INSERT INTO `tb_shop_category` VALUES(1,"chatime","coffe/tea","test",1,NULL,NULL,NULL);
INSERT INTO `tb_shop` VALUES(1,1,1,1,"test","test","test","test","test",0, curdate(),curdate(),1,"test");

SELECT *
FROM tb_area;

SELECT *
FROM tb_shop;

DELETE FROM `tb_shop`
WHERE `shop_id` = 1;
