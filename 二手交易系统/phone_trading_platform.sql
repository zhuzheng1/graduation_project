/*
Navicat MySQL Data Transfer

Source Server         : mysql_databases
Source Server Version : 80020
Source Host           : localhost:3306
Source Database       : phone_trading_platform

Target Server Type    : MYSQL
Target Server Version : 80020
File Encoding         : 65001

Date: 2021-06-01 12:37:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` varchar(32) COLLATE utf8_bin NOT NULL,
  `admin_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `admin_password` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `admin_qq` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `admin_phone` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('f84c65ec9f3147118fc8cb833eddee5a', 'admin01', '202cb962ac59075b964b07152d234b70', '984023748', '15073849920');

-- ----------------------------
-- Table structure for collect
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect` (
  `goods_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of collect
-- ----------------------------
INSERT INTO `collect` VALUES ('35ad5d847f8d45c7824ed37d7fcc95a2', 'f84c65ec9f3147118fc8cb833eddee5b');
INSERT INTO `collect` VALUES ('35ad5d847f8d45c7824ed37d7fcc95a2', '04777871ea9e47abb910f91191ae0ea3');
INSERT INTO `collect` VALUES ('4a9551617e444f5394292319701b078e', '04777871ea9e47abb910f91191ae0ea3');
INSERT INTO `collect` VALUES ('f574a313219e4570b482d6a9ef8e3abf', '04777871ea9e47abb910f91191ae0ea3');
INSERT INTO `collect` VALUES ('7b51d9b3e46241d28517ea0c1185a28d', '04777871ea9e47abb910f91191ae0ea3');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goods_id` varchar(32) COLLATE utf8_bin NOT NULL,
  `user_id` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `goods_image` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `goods_title` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `goods_detail` text CHARACTER SET utf8 COLLATE utf8_bin,
  `goods_type` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `goods_price` int DEFAULT NULL,
  `goods_place` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `goods_phone` varchar(11) COLLATE utf8_bin DEFAULT NULL,
  `goods_qq` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `goods_status` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('7b51d9b3e46241d28517ea0c1185a28d', 'f84c65ec9f3147118fc8cb833eddee5b', 'http://localhost:8080/static/goods/7b51d9b3e46241d28517ea0c1185a28d.png', '华为P40Pro', 0xE58D8EE4B8BA50343050726FEFBC8CE785A7E79BB8E69CBAE4B889E58D81E5808DE694BEE5A4A7EFBC8CE4BDA0E580BCE5BE97E68BA5E69C89, '华为', '5980', '湖南省衡阳市晶珠广场', '15073849920', '999999999', '1');
INSERT INTO `goods` VALUES ('35ad5d847f8d45c7824ed37d7fcc95a2', 'f84c65ec9f3147118fc8cb833eddee5b', 'http://localhost:8080/static/goods/35ad5d847f8d45c7824ed37d7fcc95a2.png', '华为P40', 0xE58D8EE4B8BA503430EFBC8CE785A7E79BB8E69CBAE4B889E58D81E5808DE694BEE5A4A7EFBC8CE4BDA0E580BCE5BE97E68BA5E69C89, '华为', '4980', '湖南省衡阳市晶珠广场', '15073849920', '999999999', '1');
INSERT INTO `goods` VALUES ('f574a313219e4570b482d6a9ef8e3abf', '04777871ea9e47abb910f91191ae0ea3', 'http://localhost:8080//static/goods/f574a313219e4570b482d6a9ef8e3abf.jpg', 'aa', 0x617367676733343534793736356A686766686A3536696A79746A68, 'aa', '2365', 'aa', '12343253634', 'aa', '1');
INSERT INTO `goods` VALUES ('2f5f5593f3d6412a97f5533401167037', '04777871ea9e47abb910f91191ae0ea3', 'http://localhost:8080//static/goods/2f5f5593f3d6412a97f5533401167037.jpg', 'bb', 0x666733773534363534756A3634383735383738753536, 'bb', '5555', 'bb', '23543653754', '436537ytrh5465', '0');
INSERT INTO `goods` VALUES ('4a9551617e444f5394292319701b078e', '04777871ea9e47abb910f91191ae0ea3', 'http://localhost:8080//static/goods/4a9551617e444f5394292319701b078e.png', 'vivo x60', 0x7361646173646473E59083E69292E693A6E68BAD, 'vivo', '63', '地球', '11242141441', '121241d1w2321', '1');

-- ----------------------------
-- Table structure for status
-- ----------------------------
DROP TABLE IF EXISTS `status`;
CREATE TABLE `status` (
  `goods_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `new_old` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `item_status` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `origin` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of status
-- ----------------------------
INSERT INTO `status` VALUES ('2f5f5593f3d6412a97f5533401167037', '全新', '主配齐全', '个人');
INSERT INTO `status` VALUES ('35ad5d847f8d45c7824ed37d7fcc95a2', '9成新', '无拆无修', '商家');
INSERT INTO `status` VALUES ('4a9551617e444f5394292319701b078e', '8成新', '正品发票', '个人');
INSERT INTO `status` VALUES ('7b51d9b3e46241d28517ea0c1185a28d', '8成新', '正品发票', '个人');
INSERT INTO `status` VALUES ('f574a313219e4570b482d6a9ef8e3abf', '8成新', '正品发票', '个人');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `user_image` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `user_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `user_password` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `user_qq` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `user_phone` varchar(11) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('04777871ea9e47abb910f91191ae0ea3', 'http://localhost:8080/static/user/04777871ea9e47abb910f91191ae0ea3.png', 'abc', '202cb962ac59075b964b07152d234b70', '984023748', '13246546765');
INSERT INTO `user` VALUES ('587a6828e8d74ca89c0b426846d54e9c', 'http://localhost:8080/static/user/587a6828e8d74ca89c0b426846d54e9c.png', '李四', '202cb962ac59075b964b07152d234b70', '984023748', '15073849920');
INSERT INTO `user` VALUES ('f84c65ec9f3147118fc8cb833eddee5b', 'http://localhost:8080/static/default/default.jpg', '张三', '202cb962ac59075b964b07152d234b70', '984023748', '15073849920');
