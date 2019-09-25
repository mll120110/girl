/*
 Navicat Premium Data Transfer

 Source Server         : GIS126
 Source Server Type    : MySQL
 Source Server Version : 50626
 Source Host           : 10.1.7.126:3306
 Source Schema         : spring_boot

 Target Server Type    : MySQL
 Target Server Version : 50626
 File Encoding         : 65001

 Date: 25/09/2019 17:30:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bd_device
-- ----------------------------
DROP TABLE IF EXISTS `bd_device`;
CREATE TABLE `bd_device`  (
  `device_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '设备id',
  `device_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '设备name',
  `device_number` bigint(16) NOT NULL COMMENT '设备号',
  `state` int(10) NOT NULL COMMENT '状态0无效，1有效',
  `create_time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`device_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for bd_syn_terminal_data
-- ----------------------------
DROP TABLE IF EXISTS `bd_syn_terminal_data`;
CREATE TABLE `bd_syn_terminal_data`  (
  `meet_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键',
  `meet_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '会议名称',
  `meet_type` int(10) NOT NULL COMMENT '会议类型',
  `meet_service` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '会议服务地址url',
  `meet_account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '会议账户',
  `meet_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '会议密码',
  `meet_token` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '会议token',
  `isCheck` int(10) NOT NULL COMMENT '会议账户是否通过校验',
  `state` int(10) NOT NULL COMMENT '会议状态',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`meet_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for bd_user
-- ----------------------------
DROP TABLE IF EXISTS `bd_user`;
CREATE TABLE `bd_user`  (
  `user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户主键',
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户name',
  `state` int(10) NOT NULL COMMENT '用户状态',
  `create_time` datetime(0) NOT NULL,
  `update_time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `index_user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for re_user_device
-- ----------------------------
DROP TABLE IF EXISTS `re_user_device`;
CREATE TABLE `re_user_device`  (
  `user_device_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户与设备关系id',
  `user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `device_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `state` int(10) NOT NULL COMMENT '状态0无效，1有效',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_device_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for re_user_meet
-- ----------------------------
DROP TABLE IF EXISTS `re_user_meet`;
CREATE TABLE `re_user_meet`  (
  `re_user_meet_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键id',
  `user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'userid',
  `meet_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'meetid',
  `state` int(10) NOT NULL COMMENT '状态0无效，1有效',
  `create_time` datetime(0) NOT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`re_user_meet_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
