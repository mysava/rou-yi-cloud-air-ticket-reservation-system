/*
 Navicat Premium Data Transfer

 Source Server         : 企业项目开发
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : ry-cloud

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 04/06/2022 15:03:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for flight
-- ----------------------------
DROP TABLE IF EXISTS `flight`;
CREATE TABLE `flight`  (
  `flightid` int(0) NOT NULL AUTO_INCREMENT COMMENT '航班号',
  `aircraftid` int(0) NOT NULL COMMENT '飞机编号',
  `departure` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '出发地',
  `destination` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '目的地',
  `departuretime` datetime(0) NULL DEFAULT NULL COMMENT '出发时间',
  `arrivaltime` datetime(0) NULL DEFAULT NULL COMMENT '到达时间',
  `original price` decimal(10, 2) NULL DEFAULT NULL COMMENT '票价',
  `passengercapacity` int(0) NULL DEFAULT NULL COMMENT '客容量',
  PRIMARY KEY (`flightid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
