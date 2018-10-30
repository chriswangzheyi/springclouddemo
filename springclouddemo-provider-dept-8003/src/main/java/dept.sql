/*
Navicat MySQL Data Transfer

Source Server         : 本机测试
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : mldn8002

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-09-09 20:13:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `dept`
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `deptno` bigint(20) NOT NULL AUTO_INCREMENT,
  `dname` varchar(50) DEFAULT NULL,
  `loc` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`deptno`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('1', '开发部', 'mldn8003');
INSERT INTO `dept` VALUES ('2', '财务部', 'mldn8003');
INSERT INTO `dept` VALUES ('3', '市场部', 'mldn8003');
INSERT INTO `dept` VALUES ('4', '后勤部', 'mldn8003');
INSERT INTO `dept` VALUES ('5', '公关部', 'mldn8003');
