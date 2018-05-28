/*
Navicat MySQL Data Transfer

Source Server         : mydb
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : dev

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-05-28 10:53:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for casuser
-- ----------------------------
DROP TABLE IF EXISTS `casuser`;
CREATE TABLE `casuser` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of casuser
-- ----------------------------
INSERT INTO `casuser` VALUES ('1', 'zmh', '123');
