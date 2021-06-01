/*
Navicat MySQL Data Transfer

Source Server         : mysql_databases
Source Server Version : 80020
Source Host           : localhost:3306
Source Database       : book_share_system_of_college

Target Server Type    : MYSQL
Target Server Version : 80020
File Encoding         : 65001

Date: 2021-04-30 16:25:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` char(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `real_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `sex` char(2) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `s_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `authority` int DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('030554c4b77941caafe99c9459a0e3eb', '测试01', '202cb962ac59075b964b07152d234b70', '张三', '男', '15073849920', '18408125', '1');

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `book_id` char(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `book_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `publisher` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `book_status` char(5) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('107cb2d3dc384c599742bc425215b0e2', 'eeee', 'e', 'e', 'ee', '在平台待借');
INSERT INTO `book` VALUES ('1a8d132a33564f13a5ace67c4256260f', 'dddd', 'd', 'dd', 'ddd', '在平台待借');
INSERT INTO `book` VALUES ('1b7c9fee295b4331bb5b21271270547c', 'aaaa', 'a', 'aa', 'aaa', '在平台待借');
INSERT INTO `book` VALUES ('4a71401f21114ee4bf5304636ca2125b', 'ffff', 'f', 'ff', 'fff', '在平台待借');
INSERT INTO `book` VALUES ('ade960fd18eb4a9e9d27abb92a5c0e33', 'bbbb', 'b', 'bb', 'bbb', '在平台待借');

-- ----------------------------
-- Table structure for borrow
-- ----------------------------
DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow` (
  `borrow_id` char(32) COLLATE utf8_bin NOT NULL,
  `user_id` char(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `book_id` char(32) COLLATE utf8_bin DEFAULT NULL,
  `borrow_start_time` datetime DEFAULT NULL,
  `borrow_end_time` datetime DEFAULT NULL,
  `borrow_status` int DEFAULT NULL,
  PRIMARY KEY (`borrow_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of borrow
-- ----------------------------
INSERT INTO `borrow` VALUES ('3db68bf5d6b24a38b82b1c356d13b51f', '937d45a896dc476ab9c607f1f0f12a57', '1b7c9fee295b4331bb5b21271270547c', '2021-04-29 22:37:52', '2021-04-28 00:00:00', '1');
INSERT INTO `borrow` VALUES ('53c34610157348f4bdf8ee1e60debece', '937d45a896dc476ab9c607f1f0f12a57', 'ade960fd18eb4a9e9d27abb92a5c0e33', '2021-04-29 22:39:31', '2021-04-30 00:00:00', '1');
INSERT INTO `borrow` VALUES ('90a0f67779cb48a29f43dda63d054d64', '6f7140bbae4c459aa93b6d6321023c48', 'ade960fd18eb4a9e9d27abb92a5c0e33', '2021-04-30 15:43:54', null, '0');
INSERT INTO `borrow` VALUES ('ef21a7a98b294ff5af0d6d66fbf005a7', '6f7140bbae4c459aa93b6d6321023c48', '1a8d132a33564f13a5ace67c4256260f', '2021-04-30 15:43:46', null, '0');
INSERT INTO `borrow` VALUES ('f83cf8d541a14447a81b31178ebec75f', '6f7140bbae4c459aa93b6d6321023c48', '1b7c9fee295b4331bb5b21271270547c', '2021-04-30 15:43:50', null, '0');

-- ----------------------------
-- Table structure for share
-- ----------------------------
DROP TABLE IF EXISTS `share`;
CREATE TABLE `share` (
  `share_book_id` char(32) COLLATE utf8_bin NOT NULL,
  `user_id` char(32) COLLATE utf8_bin DEFAULT NULL,
  `book_id` char(32) COLLATE utf8_bin DEFAULT NULL,
  `share_time` datetime DEFAULT NULL,
  `back_time` datetime DEFAULT NULL,
  `share_status` int DEFAULT NULL,
  PRIMARY KEY (`share_book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of share
-- ----------------------------
INSERT INTO `share` VALUES ('1a3900ee0e674af6b30ae8f263767d78', '937d45a896dc476ab9c607f1f0f12a57', '107cb2d3dc384c599742bc425215b0e2', '2021-04-29 22:15:37', '2021-05-14 16:00:00', '1');
INSERT INTO `share` VALUES ('1e010cb832b449548424ebaedfae5d4d', '937d45a896dc476ab9c607f1f0f12a57', '1b7c9fee295b4331bb5b21271270547c', '2021-04-29 21:39:34', '2021-04-13 16:00:00', '1');
INSERT INTO `share` VALUES ('4961b93e91714ccbb8bd75a377bb767f', '937d45a896dc476ab9c607f1f0f12a57', 'ade960fd18eb4a9e9d27abb92a5c0e33', '2021-04-29 21:40:00', '2021-04-30 00:00:00', '1');
INSERT INTO `share` VALUES ('4e423cfcf9b6437ca0e7e2f5f3f24321', '937d45a896dc476ab9c607f1f0f12a57', '1a8d132a33564f13a5ace67c4256260f', '2021-04-29 22:15:27', null, '0');
INSERT INTO `share` VALUES ('53680b4bd87641fd8e0f4e850940f759', '6f7140bbae4c459aa93b6d6321023c48', '4a71401f21114ee4bf5304636ca2125b', '2021-04-30 15:43:02', null, '0');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` char(32) COLLATE utf8_bin NOT NULL,
  `username` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `real_name` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `sex` char(2) COLLATE utf8_bin DEFAULT NULL,
  `phone` varchar(11) COLLATE utf8_bin DEFAULT NULL,
  `s_number` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `authority` int DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('030554c4b77941caafe99c9459a0e3ea', 'cocol', '202cb962ac59075b964b07152d234b70', 'cocol', '男', '15073849952', '18408124', '0');
INSERT INTO `user` VALUES ('6f7140bbae4c459aa93b6d6321023c48', 'demo', '202cb962ac59075b964b07152d234b70', 'demo', '女', '15073849920', '18408141', '0');
INSERT INTO `user` VALUES ('937d45a896dc476ab9c607f1f0f12a57', 'mike', '698d51a19d8a121ce581499d7b701668', 'mike', '男', '15073849920', '18408140', '0');
