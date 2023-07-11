/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : xszlglxt

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 30/05/2023 16:46:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for accomplishment
-- ----------------------------
DROP TABLE IF EXISTS `accomplishment`;
CREATE TABLE `accomplishment`  (
  `accomplishment_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '成就ID',
  `username` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '成就名称',
  `condition` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '成就简介',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`accomplishment_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '成就' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of accomplishment
-- ----------------------------
INSERT INTO `accomplishment` VALUES (1, 'xuesheng1', '铁杵成针', '总计完成时间大于1000分钟获得', '2023-04-26 19:45:42');
INSERT INTO `accomplishment` VALUES (2, 'xuesheng1', '乘风破浪', '单项计划完成时间大于100分钟获得', '2023-04-26 23:13:34');
INSERT INTO `accomplishment` VALUES (7, 'xuesheng2', '铁杵成针', '总计完成时间大于1000分钟获得', '2023-05-11 14:16:44');
INSERT INTO `accomplishment` VALUES (8, 'xuesheng1', '有条不紊', '单项计划完成1次获得', '2023-05-16 16:39:43');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论ID',
  `id` int(11) NOT NULL COMMENT '交流id/问题id',
  `type` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类型',
  `username` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `reusername` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '回复对象',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评论内容',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间：',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间：',
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 88 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '评论' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (2, 2, '交流', 'xuesheng1', 'xuesheng5', '还得是你呀', '2023-04-12 16:57:15', '2023-04-12 16:57:15');
INSERT INTO `comment` VALUES (11, 5, '交流', 'xuesheng1', 'xuesheng1', '方式改好承诺加快绿啊积分经发局电脑卡觉得就是快乐就是觉得数据搜集佛沙克v金额哦卡卡是劳动纠纷0尔尔克v建瓯市积分就OK表达式的金卡就是咖啡v比较少的看不了视频【3而偶分v笔记本迫使', '2023-04-13 11:36:18', '2023-04-13 11:36:18');
INSERT INTO `comment` VALUES (6, 5, '交流', 'xuesheng1', 'xuesheng1', '还得是你', '2023-04-12 20:28:55', '2023-04-12 20:28:55');
INSERT INTO `comment` VALUES (9, 7, '交流', 'xuesheng2', 'xuesheng1', '百度v阿基诺绿坝考虑', '2023-04-12 20:48:11', '2023-04-12 20:48:11');
INSERT INTO `comment` VALUES (10, 7, '交流', 'xuesheng1', 'xuesheng1', '上次给v阿卡v吧', '2023-04-13 11:28:05', '2023-04-13 11:28:05');
INSERT INTO `comment` VALUES (8, 5, '交流', 'xuesheng1', 'xuesheng1', '奥斯本v包括大家可别哪里拿你的卡上女的北京埃里克夫卡了你那就发我发票是积分卡书看完', '2023-04-12 20:29:15', '2023-04-12 20:29:15');
INSERT INTO `comment` VALUES (12, 11, '评论', 'xuesheng1', 'xuesheng1', 'v还得看LL:MVniDOP', '2023-04-13 12:09:00', '2023-04-13 12:09:28');
INSERT INTO `comment` VALUES (13, 9, '评论', 'xuesheng1', 'xuesheng2', '女抗拉性能了你calm给瓦片发', '2023-04-13 12:11:24', '2023-04-13 12:11:24');
INSERT INTO `comment` VALUES (14, 9, '评论', 'xuesheng1', 'xuesheng2', '给vu奥i机构额哦哦哦饿哦饿哦欸欸欸额', '2023-04-13 12:33:50', '2023-04-13 12:33:50');
INSERT INTO `comment` VALUES (15, 10, '评论', 'xuesheng1', 'xuesheng1', '叭叭叭', '2023-04-13 13:04:17', '2023-04-13 13:04:17');
INSERT INTO `comment` VALUES (16, 7, '交流', 'xuesheng1', 'xuesheng1', '啊', '2023-04-13 13:16:19', '2023-04-13 13:16:19');
INSERT INTO `comment` VALUES (17, 9, '评论', 'xuesheng2', 'xuesheng1', '女款的拉力八零v', '2023-04-13 13:23:56', '2023-04-13 13:23:56');
INSERT INTO `comment` VALUES (18, 9, '评论', 'xuesheng1', 'xuesheng2', '啊哈哈哈哈哈\n', '2023-04-13 13:28:39', '2023-04-13 13:28:39');
INSERT INTO `comment` VALUES (19, 9, '评论', 'xuesheng2', 'xuesheng2', '萨法', '2023-04-13 13:56:01', '2023-04-13 13:56:01');
INSERT INTO `comment` VALUES (54, 9, '评论', 'admin', 'xuesheng2', '法国色鬼', '2023-04-14 15:14:13', '2023-04-14 15:14:13');
INSERT INTO `comment` VALUES (55, 7, '交流', 'jiaoshi1', 'xuesheng1', '法国时尚', '2023-04-14 15:35:35', '2023-04-14 15:35:35');
INSERT INTO `comment` VALUES (22, 8, '交流', 'xuesheng2', 'xuesheng1', 'vguaovaiowvui', '2023-04-13 13:59:20', '2023-04-13 13:59:20');
INSERT INTO `comment` VALUES (71, 69, '回答', 'xuesheng1', 'xuesheng2', '在一个纳斯卡率你把VS你看了', '2023-04-21 22:13:24', '2023-04-21 22:13:24');
INSERT INTO `comment` VALUES (53, 7, '交流', 'admin', 'xuesheng1', '可以\n', '2023-04-14 15:08:16', '2023-04-14 15:08:16');
INSERT INTO `comment` VALUES (72, 6, '问题', 'jiaoshi1', 'xuesheng2', '做梦！！！', '2023-04-22 20:21:19', '2023-04-22 20:21:19');
INSERT INTO `comment` VALUES (76, 6, '问题', 'xuesheng1', 'xuesheng2', 'hvbanksvdao', '2023-04-22 22:15:17', '2023-04-22 22:15:17');
INSERT INTO `comment` VALUES (77, 76, '回答', 'xuesheng1', 'xuesheng1', 'vaikljbdan;l', '2023-04-22 22:15:24', '2023-04-22 22:15:24');
INSERT INTO `comment` VALUES (84, 81, '回答', 'xuesheng1', 'jiaoshi1', 'fafgag ', '2023-04-22 22:36:25', '2023-04-22 22:36:25');
INSERT INTO `comment` VALUES (86, 5, '交流', 'xuesheng1', 'xuesheng1', '算法', '2023-05-09 23:44:04', '2023-05-09 23:44:04');
INSERT INTO `comment` VALUES (68, 67, '回答', 'xuesheng1', 'xuesheng1', '倦怠v啊v女女女女v男女降低v就拿巨大而v就杰佛啊开发局i哦啊v举报佛v骄傲就卡斯奥罗斯科大家激发哎i爱我i发货v哈尽快', '2023-04-21 21:58:01', '2023-04-21 21:58:01');
INSERT INTO `comment` VALUES (69, 6, '问题', 'xuesheng2', 'xuesheng2', '是否van看完\n', '2023-04-21 21:58:39', '2023-04-21 21:58:39');
INSERT INTO `comment` VALUES (73, 72, '回答', 'xuesheng1', 'jiaoshi1', '没毛病...', '2023-04-22 20:22:01', '2023-04-22 20:22:01');
INSERT INTO `comment` VALUES (74, 72, '回答', 'jiaoshi1', 'xuesheng1', '.................', '2023-04-22 20:22:21', '2023-04-22 20:22:21');
INSERT INTO `comment` VALUES (75, 72, '回答', 'xuesheng2', 'jiaoshi1', 'hvalsvboaiop;', '2023-04-22 21:30:06', '2023-04-22 21:30:06');
INSERT INTO `comment` VALUES (87, 5, '交流', 'xuesheng1', 'xuesheng1', 'asfaf', '2023-05-11 14:01:52', '2023-05-11 14:01:52');
INSERT INTO `comment` VALUES (83, 3, '问题', 'xuesheng1', 'xuesheng1', 'vdjkavbajklv', '2023-04-22 22:36:21', '2023-04-22 22:36:21');
INSERT INTO `comment` VALUES (81, 3, '问题', 'jiaoshi1', 'xuesheng1', 'gags ', '2023-04-22 22:22:21', '2023-04-22 22:22:21');

-- ----------------------------
-- Table structure for communication
-- ----------------------------
DROP TABLE IF EXISTS `communication`;
CREATE TABLE `communication`  (
  `communication_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '解惑ID',
  `plan_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '计划名称',
  `username` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分享用户名',
  `reusername` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '被分享的人',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '心得内容',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间：',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间：',
  PRIMARY KEY (`communication_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '解惑' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of communication
-- ----------------------------
INSERT INTO `communication` VALUES (5, '计算机网络', 'xuesheng1', 'xuesheng1', 'hjKAXbcUjklc ', '2023-04-12 12:32:56', '2023-04-12 12:32:56');
INSERT INTO `communication` VALUES (7, '计算机网络', 'xuesheng1', '计科', 'hjKAXbcUjklc ', '2023-04-12 19:16:22', '2023-04-12 19:16:22');
INSERT INTO `communication` VALUES (8, '计算机网络', 'xuesheng1', '计算机院', 'hjKAXbcUjklc ', '2023-04-13 13:58:58', '2023-04-26 21:00:30');
INSERT INTO `communication` VALUES (9, '计算机网络', 'xuesheng1', '学校', 'hjKAXbcUjklc ', '2023-04-13 14:00:54', '2023-04-13 14:00:54');
INSERT INTO `communication` VALUES (2, '跑步', 'xuesheng5', 'xuesheng1', '给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了', '2023-04-09 14:46:36', '2023-04-09 14:46:36');
INSERT INTO `communication` VALUES (3, '跑步', 'xuesheng1', '计科1401', '给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了', '2023-04-11 17:19:44', '2023-04-11 17:19:44');
INSERT INTO `communication` VALUES (4, '跑步', 'xuesheng1', 'xuesheng5', '给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了', '2023-04-12 12:23:31', '2023-04-12 12:23:31');

-- ----------------------------
-- Table structure for experience
-- ----------------------------
DROP TABLE IF EXISTS `experience`;
CREATE TABLE `experience`  (
  `experience_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '心得ID',
  `username` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `plan_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学习计划名称',
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '结束时间',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '心得内容',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`experience_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '心得' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of experience
-- ----------------------------
INSERT INTO `experience` VALUES (1, 'xuesheng1', '跑步', '2023-03-28 13:54:01', '2023-03-28 13:55:10', '给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了给v房地产别扭啊松开拍摄了，出类拔萃v就是你看吗和v读完i骄傲可怕死了', '2023-03-28 21:55:20', '2023-04-04 22:30:27');
INSERT INTO `experience` VALUES (2, 'xuesheng1', '政治', '2023-03-28 13:58:34', '2023-03-28 15:58:36', '', '2023-03-28 21:58:41', '2023-04-25 12:39:50');
INSERT INTO `experience` VALUES (8, 'xuesheng9', '政治', '2023-03-28 20:58:34', '2023-03-28 22:35:21', '莫得心得,心得莫有', '2023-03-28 22:18:20', '2023-04-26 20:33:22');
INSERT INTO `experience` VALUES (9, 'xuesheng3', 'sj', '2023-03-28 20:58:34', '2023-03-28 22:35:21', '水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水', '2023-03-29 22:18:20', '2023-03-29 20:07:19');
INSERT INTO `experience` VALUES (10, 'xuesheng1', '计算机网络', '2023-03-30 12:21:19', '2023-03-30 12:22:22', 'hjKAXbcUjklc ', '2023-03-30 12:22:28', '2023-03-30 12:22:28');
INSERT INTO `experience` VALUES (11, 'xuesheng1', '计算机网络', '2023-04-05 12:21:19', '2023-04-05 12:30:22', 'hjKAXbcUjklc ', '2023-04-05 12:22:28', '2023-04-24 23:34:58');
INSERT INTO `experience` VALUES (12, 'xuesheng1', '计算机网络', '2023-04-05 12:22:28', '2023-04-05 13:22:28', 'hjKAXbcUjklc ', '2023-04-06 12:22:28', '2023-04-24 23:34:17');
INSERT INTO `experience` VALUES (13, 'xuesheng1', '计算机网络', '2023-04-06 12:22:28', '2023-04-06 12:29:28', 'hjKAXbcUjklc ', '2023-04-15 12:22:28', '2023-04-24 23:34:24');
INSERT INTO `experience` VALUES (14, 'xuesheng1', '计算机网络', '2023-04-06 12:22:28', '2023-04-06 15:22:28', 'hjKAXbcUjklc ', '2023-04-17 12:22:28', '2023-04-24 15:41:32');
INSERT INTO `experience` VALUES (15, 'xuesheng1', '计算机网络', '2023-04-06 12:22:28', '2023-04-06 13:22:28', 'hjKAXbcUjklc ', '2023-04-22 12:22:28', '2023-04-24 13:52:04');
INSERT INTO `experience` VALUES (16, 'xuesheng1', '计算机网络', '2023-04-06 12:22:28', '2023-04-06 13:22:28', 'hjKAXbcUjklc ', '2023-04-23 12:22:28', '2023-04-24 13:22:56');
INSERT INTO `experience` VALUES (17, 'xuesheng1', '政治', '2023-04-06 12:22:28', '2023-04-06 13:22:28', 'hjKAXbcUjklc ', '2023-04-23 12:22:28', '2023-04-24 13:22:56');
INSERT INTO `experience` VALUES (18, 'xuesheng1', '四级', '2023-04-27 23:13:32', '2023-04-27 23:14:29', '', '2023-04-27 23:15:37', '2023-04-27 23:15:37');
INSERT INTO `experience` VALUES (19, 'xuesheng1', '四级', '2023-05-08 15:19:44', '2023-05-08 15:47:27', '', '2023-05-08 15:47:33', '2023-05-08 15:47:33');
INSERT INTO `experience` VALUES (20, 'xuesheng1', '四级', '2023-05-09 17:12:39', '2023-05-09 17:15:11', '', '2023-05-09 17:20:11', '2023-05-09 17:43:50');
INSERT INTO `experience` VALUES (21, 'xuesheng1', '四级', '2023-05-09 22:22:49', '2023-05-09 22:25:16', '', '2023-05-09 22:25:18', '2023-05-09 22:25:18');
INSERT INTO `experience` VALUES (22, 'xuesheng2', '四级', '2023-05-11 14:13:47', '2023-05-11 14:13:50', '', '2023-05-11 14:13:52', '2023-05-11 14:13:52');
INSERT INTO `experience` VALUES (23, 'xuesheng1', '论文', '2023-05-20 23:50:15', '2023-05-20 23:50:37', '', '2023-05-20 23:50:54', '2023-05-20 23:50:54');
INSERT INTO `experience` VALUES (24, 'xuesheng1', '四级', '2023-05-21 07:39:43', '2023-05-21 07:40:50', '好累啊\n', '2023-05-21 07:41:10', '2023-05-21 07:41:10');
INSERT INTO `experience` VALUES (25, 'xuesheng1', '四级', '2023-05-21 19:03:03', '2023-05-21 19:05:46', ' 玻璃门，你们', '2023-05-21 19:06:02', '2023-05-21 19:06:02');

-- ----------------------------
-- Table structure for goal_plan
-- ----------------------------
DROP TABLE IF EXISTS `goal_plan`;
CREATE TABLE `goal_plan`  (
  `goal_plan_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '目标计划ID',
  `username` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `goal_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '目标名称',
  `goal_describe` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '目标描述',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '结束时间',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`goal_plan_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '目标计划' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goal_plan
-- ----------------------------
INSERT INTO `goal_plan` VALUES (1, 'xuesheng1', '考研', '北京信息科技大学', '2023-12-24 16:10:55', '2023-03-07 16:10:55', '2023-03-27 19:08:32');
INSERT INTO `goal_plan` VALUES (2, 'xuesheng1', '四级', '必过', '2023-12-24 16:10:55', '2023-03-07 16:10:55', '2023-03-07 16:10:55');
INSERT INTO `goal_plan` VALUES (3, 'xuesheng2', '考研', '北京信息科技大学', '2023-12-24 16:10:55', '2023-03-07 16:10:55', '2023-03-07 16:10:55');
INSERT INTO `goal_plan` VALUES (4, 'xuesheng3', '考研', '北京信息科技大学', '2023-12-24 16:10:55', '2023-03-07 16:10:55', '2023-03-07 16:10:55');
INSERT INTO `goal_plan` VALUES (5, 'xuesheng4', '考研', '北京信息科技大学', '2023-12-24 16:10:55', '2023-03-07 16:10:55', '2023-03-07 16:10:55');
INSERT INTO `goal_plan` VALUES (6, 'xuesheng5', '考研', '北京信息科技大学', '2023-12-24 16:10:55', '2023-03-07 16:10:55', '2023-03-07 16:10:55');
INSERT INTO `goal_plan` VALUES (7, 'xuesheng6', '考研', '北京信息科技大学', '2023-12-24 16:10:55', '2023-03-07 16:10:55', '2023-03-07 16:10:55');
INSERT INTO `goal_plan` VALUES (8, 'xuesheng7', '考研', '北京信息科技大学', '2023-12-24 16:10:55', '2023-03-07 16:10:55', '2023-03-07 16:10:55');
INSERT INTO `goal_plan` VALUES (9, 'xuesheng8', '考研', '北京信息科技大学', '2023-12-24 16:10:55', '2023-03-07 16:10:55', '2023-03-07 16:10:55');
INSERT INTO `goal_plan` VALUES (10, 'xuesheng9', '考研', '北京信息科技大学', '2023-12-24 16:10:55', '2023-03-07 16:10:55', '2023-03-07 16:10:55');
INSERT INTO `goal_plan` VALUES (11, 'xuesheng10', '考研', '北京信息科技大学', '2023-12-24 16:10:55', '2023-03-07 16:10:55', '2023-03-07 16:10:55');
INSERT INTO `goal_plan` VALUES (12, 'xuesheng1', '考公', '上岸', '2023-12-24 16:10:55', '2023-03-07 16:10:55', '2023-03-07 16:10:55');
INSERT INTO `goal_plan` VALUES (14, 'xuesheng1', '阿斯顿', '十大', '2023-03-16 00:00:00', '2023-03-25 12:21:37', '2023-03-25 15:37:50');
INSERT INTO `goal_plan` VALUES (18, 'xuesheng1', '公认为', '', NULL, '2023-03-25 14:29:19', '2023-03-25 14:29:19');
INSERT INTO `goal_plan` VALUES (19, 'xuesheng1', '和别人沟通的', '', '2023-03-25 00:00:00', '2023-03-25 14:30:47', '2023-03-25 14:50:27');
INSERT INTO `goal_plan` VALUES (20, 'xuesheng1', '发个图', '', '2023-03-16 00:00:00', '2023-03-25 14:46:16', '2023-03-25 15:59:00');
INSERT INTO `goal_plan` VALUES (22, 'xuesheng1', '公交上我', '华国锋v苏', '2023-03-31 00:00:00', '2023-03-25 16:00:38', '2023-03-25 16:01:29');

-- ----------------------------
-- Table structure for hits
-- ----------------------------
DROP TABLE IF EXISTS `hits`;
CREATE TABLE `hits`  (
  `hits_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '点赞ID：',
  `id` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '交流id/评论id/问题id',
  `type` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id类型',
  `username` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '点赞用户名',
  `likes` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否点赞',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间：',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间：',
  PRIMARY KEY (`hits_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 69 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hits
-- ----------------------------
INSERT INTO `hits` VALUES (1, 2, '交流', 'xuesheng1', 1, '2023-04-11 21:55:29', '2023-04-12 12:27:42');
INSERT INTO `hits` VALUES (3, 3, '交流', 'xuesheng1', 1, '2023-04-12 11:37:16', '2023-04-12 12:28:18');
INSERT INTO `hits` VALUES (4, 4, '交流', 'xuesheng1', 1, '2023-04-12 12:28:16', '2023-04-12 12:28:31');
INSERT INTO `hits` VALUES (5, 5, '交流', 'xuesheng1', 1, '2023-04-12 12:33:11', '2023-05-09 17:26:13');
INSERT INTO `hits` VALUES (7, 7, '交流', 'xuesheng2', 1, '2023-04-12 20:43:01', '2023-04-12 20:47:53');
INSERT INTO `hits` VALUES (8, 7, '交流', 'xuesheng1', 1, '2023-04-12 20:43:08', '2023-04-12 20:47:44');
INSERT INTO `hits` VALUES (9, 6, '评论', 'xuesheng1', 1, '2023-04-12 21:10:25', '2023-04-13 11:22:20');
INSERT INTO `hits` VALUES (10, 8, '评论', 'xuesheng1', 1, '2023-04-12 21:31:34', '2023-04-12 21:31:34');
INSERT INTO `hits` VALUES (11, 9, '评论', 'xuesheng2', 1, '2023-04-12 22:01:41', '2023-04-12 22:01:41');
INSERT INTO `hits` VALUES (12, 9, '评论', 'xuesheng1', 0, '2023-04-12 22:01:50', '2023-04-13 13:39:24');
INSERT INTO `hits` VALUES (13, 10, '评论', 'xuesheng1', 0, '2023-04-13 11:28:12', '2023-04-13 11:29:03');
INSERT INTO `hits` VALUES (14, 11, '评论', 'xuesheng1', 0, '2023-04-13 11:50:06', '2023-04-13 13:04:42');
INSERT INTO `hits` VALUES (15, 13, '评论', 'xuesheng1', 1, '2023-04-13 13:53:21', '2023-04-13 13:53:21');
INSERT INTO `hits` VALUES (16, 14, '评论', 'xuesheng1', 1, '2023-04-13 13:53:26', '2023-04-13 13:53:26');
INSERT INTO `hits` VALUES (17, 13, '评论', 'xuesheng2', 0, '2023-04-13 13:53:34', '2023-04-13 13:53:37');
INSERT INTO `hits` VALUES (18, 18, '评论', 'xuesheng1', 1, '2023-04-13 13:53:46', '2023-04-13 13:53:46');
INSERT INTO `hits` VALUES (19, 14, '评论', 'xuesheng2', 1, '2023-04-13 13:54:07', '2023-04-13 13:54:07');
INSERT INTO `hits` VALUES (20, 16, '评论', 'xuesheng1', 0, '2023-04-13 13:57:47', '2023-04-13 13:57:50');
INSERT INTO `hits` VALUES (50, 53, '评论', 'admin', 1, '2023-04-14 15:08:23', '2023-04-14 15:08:23');
INSERT INTO `hits` VALUES (51, 7, '交流', 'admin', 1, '2023-04-14 15:12:53', '2023-04-14 15:34:11');
INSERT INTO `hits` VALUES (52, 16, '评论', 'admin', 0, '2023-04-14 15:33:57', '2023-04-14 15:33:57');
INSERT INTO `hits` VALUES (56, 6, '问题', 'xuesheng1', 0, '2023-04-21 21:46:37', '2023-05-09 19:07:07');
INSERT INTO `hits` VALUES (58, 6, '交流', 'xuesheng1', 0, '2023-04-21 21:47:11', '2023-04-21 21:47:11');
INSERT INTO `hits` VALUES (59, 67, '回答', 'xuesheng2', 0, '2023-04-21 22:02:00', '2023-04-21 22:02:01');
INSERT INTO `hits` VALUES (60, 68, '回答', 'xuesheng2', 0, '2023-04-21 22:02:05', '2023-04-21 22:02:05');
INSERT INTO `hits` VALUES (61, 69, '回答', 'xuesheng2', 0, '2023-04-21 22:02:09', '2023-04-21 22:02:10');
INSERT INTO `hits` VALUES (62, 70, '回答', 'xuesheng2', 0, '2023-04-21 22:04:30', '2023-04-21 22:04:30');
INSERT INTO `hits` VALUES (63, 6, '问题', 'xuesheng2', 1, '2023-04-21 22:07:51', '2023-04-21 22:07:51');
INSERT INTO `hits` VALUES (64, 6, '问题', 'jiaoshi1', 1, '2023-04-22 20:05:32', '2023-04-22 20:23:42');
INSERT INTO `hits` VALUES (65, 72, '回答', 'jiaoshi1', 1, '2023-04-22 20:23:40', '2023-04-22 20:23:40');
INSERT INTO `hits` VALUES (66, 73, '回答', 'jiaoshi1', 0, '2023-04-22 20:23:46', '2023-04-22 20:23:46');
INSERT INTO `hits` VALUES (67, 3, '问题', 'xuesheng1', 0, '2023-04-22 23:50:58', '2023-04-22 23:50:59');
INSERT INTO `hits` VALUES (68, 7, '交流', 'jiaoshi1', 0, '2023-05-08 19:03:13', '2023-05-08 19:03:15');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `notice_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '通知ID',
  `title` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主题',
  `type` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类型 如公告、通知、消息、快报',
  `username` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '发布人用户名',
  `re_username` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '接收方',
  `publish_time` datetime(0) NOT NULL COMMENT '发布时间',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
  `level` int(11) NULL DEFAULT 0 COMMENT '级别（置顶）',
  `received_num` int(11) NULL DEFAULT 0 COMMENT '确认收到人数',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`notice_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 55 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '通知' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES (1, '今日招聘', '公告', 'jiaoshi1', '计算机院', '2023-04-04 22:35:56', '1、北京中科天成文化传媒有限公司，10:00，会议号：628271689\n企业简介：北京中科天成文化传媒有限公司是一家集平面媒体代理、文化交流、展览展示、广告创意及发布、品牌和活动策划于一体的现代化、专业文化传媒公司。目前本公司主打《科学中国人》期刊。\n专业需求：不限专业\n岗位职责：\n负责销售公司旗下新媒体及合作杂志广告，广告客户的开发、服务、维护工作，建立与企事业客户的良好合作关系；\n负责搜集新客户的资料并进行沟通，开发新客户；\n与客户进行有效沟通了解、分析客户需求，依托公司平台资源为客户制定可行的品牌策划及多元化的推广方案；\n负责销售合同的签定，及时收回款项；\n按合同约定，与公司其他部门人员协作，为客户做好后期相关品牌宣传及推广服务；\n负责公司承办的各类相关会议/活动的招商及洽谈赞助工作\n薪资待遇：责任底薪4500元/月（3500元/月＋房补1000）＋高提成10%～20%＋各类奖金+五险一金和绩效奖励（月奖、季度奖、年终奖等）；\n\n2、北京永和大王餐饮有限公司，10:00，通方楼B301\n企业简介： 北京永和大王餐饮有限公司，为外商独资的全国快餐连锁企业，是快乐蜂（中国）餐饮管理有限公司旗下知名中华美食快餐品牌，品牌成立以来，坚守传统，不断创新。品牌连续荣获中国烹饪协会评定的“中国餐饮百强”、“中国十大快餐品牌”荣誉；连续荣获北京市商务局、北京市烹饪协会、《北京商报》社评定的“北京十大商业品牌”、“北京餐饮五十强”、“北京市放心餐厅”荣誉。\n需求专业：见习经理，不限专业（管理类、语言类优先）\n薪资待遇：实习期4000-4300，五险一金。\n\n请有意向的同学带好简历积极参会@全体成员 ', 0, 1, '2023-04-04 22:35:56', '2023-04-09 12:53:46');
INSERT INTO `notice` VALUES (2, '今日招聘', '公告', 'jiaoshi2', '经管院', '2023-04-04 22:37:01', '河北昊泽化工有限公司，10:30，通方楼 A203\n企业简介：河北昊泽化工有限公司成立于2014年，公司位于国家级化工园区——渤海之滨的河北沧州临港经济技术开发区。地理优越，交通便利，东距国际化大港口——黄骅港20公里，北距天津滨海新区50公里，距北京230公里。荣乌高速、石黄高速、沿海高速环绕四周，朔黄铁路、邯黄铁路贯穿东西，具备海运，高速公路、铁路等各种运输条件。\n需求专业：电气、自动化、机械、化工、经济管理、文秘、计算机、工商管理、人力资源、法律、英语、国际贸易类\n薪资待遇：本科毕业生6000元以上，研究生8000元以上，博士生10000元以上极具竞争力且不断增长的薪酬待遇和完善的福利（双休、五险一金、补充商业保险、绩效奖金、工龄工资、研发项目奖励、年终奖、节日生日福利、差补餐补、通讯补助、员工体检、定期团建活动、婚假、产假、丧假、法定假）\n请各位毕业生积极参会。@全体成员', 0, 0, '2023-04-04 22:37:01', '2023-04-06 20:37:51');
INSERT INTO `notice` VALUES (6, '今日招聘', '公告', 'jiaoshi1', '112233', '2023-04-05 18:01:12', '河北昊泽化工有限公司，10:30，通方楼 A203\n企业简介：河北昊泽化工有限公司成立于2014年，公司位于国家级化工园区——渤海之滨的河北沧州临港经济技术开发区。地理优越，交通便利，东距国际化大港口——黄骅港20公里，北距天津滨海新区50公里，距北京230公里。荣乌高速、石黄高速、沿海高速环绕四周，朔黄铁路、邯黄铁路贯穿东西，具备海运，高速公路、铁路等各种运输条件。\n需求专业：电气、自动化、机械、化工、经济管理、文秘、计算机、工商管理、人力资源、法律、英语、国际贸易类\n薪资待遇：本科毕业生6000元以上，研究生8000元以上，博士生10000元以上极具竞争力且不断增长的薪酬待遇和完善的福利（双休、五险一金、补充商业保险、绩效奖金、工龄工资、研发项目奖励、年终奖、节日生日福利、差补餐补、通讯补助、员工体检、定期团建活动、婚假、产假、丧假、法定假）\n请各位毕业生积极参会。@全体成员', 0, 0, '2023-04-05 18:01:12', '2023-04-06 20:37:55');
INSERT INTO `notice` VALUES (7, 'jiaoshi1提醒您', '提醒', 'jiaoshi1', 'xuesheng1', '2023-04-05 22:34:54', '对不起，由于你发布的心得内容与我们相关政策不符，我们已经删除了您2023-04-05 12:22:28时创建的计算机网络的心得记录，请您端正自身，如有疑问，请联系你的老师或管理员。', 0, 1, '2023-04-05 22:34:54', '2023-05-07 23:31:38');
INSERT INTO `notice` VALUES (8, 'jiaoshi1提醒您', '提醒', 'jiaoshi1', 'xuesheng1', '2023-04-06 11:46:33', '对不起，由于你创建的计划与我们相关政策不符，我们已经删除了您计划名称为政治1的计划，请您端正自身。如有疑问，请联系你的老师或管理员。', 0, 1, '2023-04-06 11:46:33', '2023-04-08 13:11:05');
INSERT INTO `notice` VALUES (9, '计划学习提醒', '提醒', 'jiaoshi1', 'xuesheng1', '2023-04-06 14:09:01', '您今天还没有开始学习您计划名称为项目的计划，请坚持每天学习，不断进步。学习不是一蹴而就的，需要持之以恒。', 0, 0, '2023-04-06 14:09:01', '2023-04-08 13:09:32');
INSERT INTO `notice` VALUES (23, '计划学习提醒', '提醒', 'jiaoshi1', 'xuesheng1', '2023-04-06 14:38:47', '您今天还没有开始学习您计划名称为四级的计划，或者你的学习时间没有超过20分钟，请坚持每天学习，不断进步。学习不是一蹴而就的，需要持之以恒。', 0, 0, '2023-04-06 14:38:47', '2023-04-06 14:38:47');
INSERT INTO `notice` VALUES (29, '计划学习提醒', '提醒', 'jiaoshi1', 'xuesheng10', '2023-04-06 15:00:22', '您今天还没有开始学习您计划名称为项目的计划，或者你的学习时间没有超过20分钟，请坚持每天学习，不断进步。学习不是一蹴而就的，需要持之以恒。', 0, 0, '2023-04-06 15:00:22', '2023-04-06 15:00:22');
INSERT INTO `notice` VALUES (32, '删除提醒', '提醒', 'jiaoshi1', 'xuesheng1', '2023-04-06 15:16:13', '对不起，由于你创建的未来目标与我们相关政策不符，我们已经删除了您目标名称为四级的未来目标，请您端正自身。如有疑问，请联系你的老师或管理员。', 0, 1, '2023-04-06 15:16:13', '2023-04-08 13:31:42');
INSERT INTO `notice` VALUES (34, '目标激励', '提醒', 'jiaoshi1', 'xuesheng1', '2023-04-06 16:07:36', '坚持一件事情并不容易，你需要让自己感到好奇。将目标视为一个探险过程，你会发现完成目标的过程十分有趣，而且付出努力并达成目标的感觉也是无与伦比。距离您目标名称为考公的目标还剩余261天。请坚持每天学习。完成目标有很多的方法，但最好的方法之一就是让目标对你个人有意义。确保你从目标中获得的回报是符合你的需要和价值观的，这样就能够真正激励你超越自己的极限，达成目标。', 0, 0, '2023-04-06 16:07:36', '2023-04-07 11:37:52');
INSERT INTO `notice` VALUES (35, '计划学习提醒', '提醒', 'jiaoshi1', 'xuesheng1', '2023-04-13 15:23:55', '您今天还没有开始学习您计划名称为四级的计划，或者你的学习时间没有超过20分钟，请坚持每天学习，不断进步。学习不是一蹴而就的，需要持之以恒。', 0, 0, '2023-04-13 15:23:55', '2023-04-13 15:23:55');
INSERT INTO `notice` VALUES (36, '计划学习提醒', '提醒', 'jiaoshi1', 'xuesheng1', '2023-04-13 15:25:43', '您今天还没有开始学习您计划名称为四级的计划，或者你的学习时间没有超过20分钟，请坚持每天学习，不断进步。学习不是一蹴而就的，需要持之以恒。', 0, 0, '2023-04-13 15:25:43', '2023-04-13 15:25:43');
INSERT INTO `notice` VALUES (37, '计划学习提醒', '提醒', 'jiaoshi1', 'xuesheng1', '2023-04-13 15:31:07', '您今天还没有开始学习您计划名称为四级的计划，或者你的学习时间没有超过20分钟，请坚持每天学习，不断进步。学习不是一蹴而就的，需要持之以恒。', 0, 0, '2023-04-13 15:31:07', '2023-04-13 15:31:07');
INSERT INTO `notice` VALUES (38, '提删除醒', '提醒', 'admin', 'xuesheng1', '2023-04-14 16:36:54', 'xuesheng1你好：由于你在计算机网络中回复的评论与我们相关政策不符，我们已经删除了您发布的评论，请您端正自身。如有疑问，请联系你的老师或管理员。', 0, 0, '2023-04-14 16:36:54', '2023-04-14 16:46:09');
INSERT INTO `notice` VALUES (39, '提删除醒', '提醒', 'admin', 'xuesheng1', '2023-04-14 16:46:49', 'xuesheng1你好：由于你在xuesheng1分享的名为计算机网络的心得中发布的评论与我们相关政策不符，我们已经删除了您发布的评论，请您端正自身。如有疑问，请联系你的老师或管理员。', 0, 0, '2023-04-14 16:46:49', '2023-04-14 16:46:49');
INSERT INTO `notice` VALUES (40, '提删除醒', '提醒', 'admin', 'xuesheng1', '2023-04-14 16:59:51', 'xuesheng1你好：由于你分享的名为计算机网络的心得与我们相关政策不符，我们已经删除了您分享的心得，请您端正自身。如有疑问，请联系你的老师或管理员。', 0, 0, '2023-04-14 16:59:51', '2023-04-14 16:59:51');
INSERT INTO `notice` VALUES (41, '删除提醒', '提醒', 'xuesheng1', 'xuesheng3', '2023-04-18 18:54:56', 'xuesheng3你好：由于你在我(xuesheng1)创建的名为四级的自习室内长时间没有学习过，与我最初创建该自习室的初衷不符，我已经把您从我的自习室移除了。请您端正自身。', 0, 0, '2023-04-18 18:54:56', '2023-04-18 18:54:56');
INSERT INTO `notice` VALUES (42, '删除提醒', '提醒', 'xuesheng1', 'xuesheng3', '2023-04-18 19:15:04', 'xuesheng3你好：由于你在我(xuesheng1)创建的名为四级的自习室内长时间没有学习过，与我最初创建该自习室的初衷不符，我已经把您从我的自习室移除。', 0, 0, '2023-04-18 19:15:04', '2023-04-18 19:15:04');
INSERT INTO `notice` VALUES (43, '邀请通知', '通知', 'xuesheng3', 'xuesheng1', '2023-04-19 12:51:57', '我正在xuesheng1创建的名为四级！DCFSA的自习室里学习，快来加入一起组队学习吧~自习室加入码：437b16c0。', 0, 0, '2023-04-19 12:51:57', '2023-04-19 12:54:08');
INSERT INTO `notice` VALUES (44, '邀请通知', '通知', 'xuesheng1', 'xuesheng3', '2023-04-19 12:55:17', '我正在xuesheng1创建的名为四级！DCFSA的自习室里学习，快来加入一起组队学习吧~自习室加入码：437b16c0。', 0, 0, '2023-04-19 12:55:17', '2023-04-19 12:55:17');
INSERT INTO `notice` VALUES (45, '邀请通知', '通知', 'xuesheng1', 'xuesheng4', '2023-04-19 12:56:28', '我正在xuesheng1创建的名为四级！DCFSA的自习室里学习，快来加入一起组队学习吧~自习室加入码：437b16c0。', 0, 0, '2023-04-19 12:56:28', '2023-04-19 12:56:28');
INSERT INTO `notice` VALUES (46, '解散通知', '通知', 'xuesheng5', 'xuesheng5', '2023-04-19 14:02:41', 'xuesheng5你好。由于无法预料的突发情况，房主xuesheng5不得不把其创建的名为23考研的自习室解散，我非常抱歉给您带来不便，感谢您一直以来的帮助。谢谢！', 0, 0, '2023-04-19 14:02:41', '2023-04-19 14:02:41');
INSERT INTO `notice` VALUES (47, '解散通知', '通知', 'xuesheng5', '112233', '2023-04-19 14:02:41', '112233你好。由于无法预料的突发情况，房主xuesheng5不得不把其创建的名为23考研的自习室解散，我非常抱歉给您带来不便，感谢您一直以来的帮助。谢谢！', 0, 0, '2023-04-19 14:02:41', '2023-04-19 14:02:41');
INSERT INTO `notice` VALUES (48, '解散通知', '通知', 'xuesheng5', 'xuesheng5', '2023-04-19 14:06:52', 'xuesheng5你好。由于特殊的突发情况，房主xuesheng5不得不把其创建的名为23考研的自习室解散，我非常抱歉给您带来不便，感谢您一直以来的帮助。谢谢！', 0, 0, '2023-04-19 14:06:52', '2023-04-19 14:06:52');
INSERT INTO `notice` VALUES (49, '解散通知', '通知', 'xuesheng5', '112233', '2023-04-19 14:06:52', '112233你好。由于特殊的突发情况，房主xuesheng5不得不把其创建的名为23考研的自习室解散，我非常抱歉给您带来不便，感谢您一直以来的帮助。谢谢！', 0, 0, '2023-04-19 14:06:52', '2023-04-19 14:06:52');
INSERT INTO `notice` VALUES (50, '删除提醒', '提醒', 'xuesheng1', 'xuesheng2', '2023-04-21 20:47:54', 'xuesheng2你好。因为你在我创建的名为null的自习室内发布的某个问题违反了我创建该自习室时的初衷，所以我删除了该问题，请您端正自身。如有疑问，请联系我。', 0, 0, '2023-04-21 20:47:54', '2023-04-21 20:48:33');
INSERT INTO `notice` VALUES (51, '解散通知', '通知', 'jiaoshi1', 'xuesheng8', '2023-04-22 12:46:53', 'xuesheng8你好。由于你创建的自习室与我们相关政策不符，我们已经把你创建的名为啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊的自习室解散，我非常抱歉给您带来不便。', 0, 0, '2023-04-22 12:46:53', '2023-04-22 12:46:53');
INSERT INTO `notice` VALUES (53, '提删除醒', '提醒', 'jiaoshi1', 'xuesheng1', '2023-04-22 22:35:07', 'xuesheng1你好：由于你在xuesheng1创建的名为四级！DCFSA的自习室中发布的回答与我们相关政策不符，我们已经删除了您发布的回答，请您端正自身。如有疑问，请联系你的老师或管理员。', 1, 1, '2023-04-22 22:35:07', '2023-05-09 17:46:02');
INSERT INTO `notice` VALUES (54, '提删除醒', '提醒', 'xuesheng1', 'jiaoshi1', '2023-04-22 22:35:34', 'jiaoshi1你好：由于你在xuesheng1创建的名为四级！DCFSA的自习室中发布的回答与我们相关政策不符，我们已经删除了您发布的回答，请您端正自身。如有疑问，请联系你的老师或管理员。', 0, 0, '2023-04-22 22:35:34', '2023-05-07 23:35:28');

-- ----------------------------
-- Table structure for room_people
-- ----------------------------
DROP TABLE IF EXISTS `room_people`;
CREATE TABLE `room_people`  (
  `room_people_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '加入自习室ID',
  `id` int(11) NOT NULL COMMENT '自习室id',
  `username` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `homeowner` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否是房主，1为房主，0不是',
  `seen` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '专注内容是否对自习室好友可见，1可见，0不可见',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`room_people_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '自习室' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of room_people
-- ----------------------------
INSERT INTO `room_people` VALUES (1, 1, 'xuesheng2', 0, 0, '2023-04-15 23:15:19', '2023-04-18 17:20:10');
INSERT INTO `room_people` VALUES (3, 2, 'xuesheng4', 1, 1, '2023-04-16 15:30:50', '2023-04-16 16:49:14');
INSERT INTO `room_people` VALUES (4, 3, 'xuesheng5', 1, 1, '2023-04-16 15:32:13', '2023-04-19 14:53:10');
INSERT INTO `room_people` VALUES (5, 4, 'xuesheng6', 1, 1, '2023-04-16 15:32:13', '2023-04-16 16:49:22');
INSERT INTO `room_people` VALUES (6, 5, 'xuesheng7', 1, 1, '2023-04-16 17:52:33', '2023-04-16 17:52:54');
INSERT INTO `room_people` VALUES (7, 6, 'xuesheng8', 1, 1, '2023-04-16 17:52:33', '2023-04-16 17:52:54');
INSERT INTO `room_people` VALUES (8, 1, 'xuesheng9', 0, 1, '2023-04-16 17:55:07', '2023-04-18 18:28:51');
INSERT INTO `room_people` VALUES (9, 1, 'xuesheng10', 0, 1, '2023-04-16 19:01:12', '2023-04-16 19:01:26');
INSERT INTO `room_people` VALUES (10, 3, '112233', 0, 1, '2023-04-16 15:32:13', '2023-04-16 16:49:22');
INSERT INTO `room_people` VALUES (11, 1, 'xuesheng1', 1, 1, '2023-04-16 19:32:49', '2023-05-21 07:39:33');
INSERT INTO `room_people` VALUES (13, 1, 'xuesheng3', 0, 1, '2023-04-18 19:16:49', '2023-04-18 19:16:49');

-- ----------------------------
-- Table structure for sleepclock
-- ----------------------------
DROP TABLE IF EXISTS `sleepclock`;
CREATE TABLE `sleepclock`  (
  `clock_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '打卡ID',
  `username` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `sleep_time` datetime(0) NULL DEFAULT NULL COMMENT '睡眠打卡时间',
  PRIMARY KEY (`clock_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '打卡' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sleepclock
-- ----------------------------
INSERT INTO `sleepclock` VALUES (1, 'xuesheng1', '2023-03-20 21:13:13');
INSERT INTO `sleepclock` VALUES (2, 'xuesheng1', '2023-03-21 22:14:41');
INSERT INTO `sleepclock` VALUES (3, 'xuesheng1', '2023-03-22 20:14:49');
INSERT INTO `sleepclock` VALUES (4, 'xuesheng1', '2023-03-23 23:14:57');
INSERT INTO `sleepclock` VALUES (5, 'xuesheng1', '2023-03-24 18:15:01');
INSERT INTO `sleepclock` VALUES (6, 'xuesheng1', '2023-03-25 19:15:04');
INSERT INTO `sleepclock` VALUES (7, 'xuesheng1', '2023-03-26 22:15:07');
INSERT INTO `sleepclock` VALUES (8, 'xuesheng1', '2023-03-27 23:15:09');
INSERT INTO `sleepclock` VALUES (9, 'xuesheng1', '2023-04-08 22:15:48');
INSERT INTO `sleepclock` VALUES (10, 'xuesheng1', '2023-04-09 18:15:46');
INSERT INTO `sleepclock` VALUES (11, 'xuesheng1', '2023-04-11 18:15:52');
INSERT INTO `sleepclock` VALUES (12, 'xuesheng1', '2023-04-20 23:18:00');
INSERT INTO `sleepclock` VALUES (13, 'xuesheng1', '2023-04-22 20:19:54');
INSERT INTO `sleepclock` VALUES (14, 'xuesheng1', '2023-04-25 23:10:49');
INSERT INTO `sleepclock` VALUES (22, 'xuesheng1', '2023-05-09 21:22:59');
INSERT INTO `sleepclock` VALUES (24, 'xuesheng1', '2023-05-20 23:49:30');
INSERT INTO `sleepclock` VALUES (25, 'xuesheng1', '2023-05-21 19:06:21');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `stu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生ID',
  `stu_number` int(11) NOT NULL COMMENT '学号',
  `stu_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `gender` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `academy` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学院',
  `major` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业',
  `class_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班级名称',
  `tea_number` int(11) NULL DEFAULT 0 COMMENT '教师编号',
  `username` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '用户名',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`stu_id`) USING BTREE,
  UNIQUE INDEX `stu_number`(`stu_number`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '学生' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, 1, '参加哦怕 ', '男', '计算机院', '计科', '计科1401', 11, 'xuesheng1', '2023-03-07 16:10:55', '2023-03-21 23:24:51');
INSERT INTO `student` VALUES (2, 21, '参加哦怕 ', '男', '计算机院', '计科', '计科1402', 11, 'xuesheng2', '2023-03-07 16:10:55', '2023-04-04 17:00:10');
INSERT INTO `student` VALUES (3, 3, '参加哦怕 ', '男', '计算机院', '计科', '计科1403', 11, 'xuesheng3', '2023-03-07 16:10:55', '2023-04-04 17:00:12');
INSERT INTO `student` VALUES (4, 4, '参加哦怕 ', '男', '计算机院', '计科', '计科1404', 13, 'xuesheng4', '2023-03-07 16:10:55', '2023-04-04 17:00:14');
INSERT INTO `student` VALUES (5, 5, '参加哦怕 ', '男', '计算机院', '计科', '计科1501', 11, 'xuesheng5', '2023-03-07 16:10:55', '2023-04-04 17:00:17');
INSERT INTO `student` VALUES (6, 6, '参加哦怕 ', '男', '计算机院', '计科', '计科1503', 11, 'xuesheng6', '2023-03-07 16:10:55', '2023-04-04 17:00:23');
INSERT INTO `student` VALUES (7, 7, '参加哦怕 ', '男', '计算机院', '计科', '计科1401', 11, 'xuesheng7', '2023-03-07 16:10:55', '2023-03-18 11:06:08');
INSERT INTO `student` VALUES (8, 8, '参加哦怕 ', '男', '计算机院', '计科', '计科1501', 11, 'xuesheng8', '2023-03-07 16:10:55', '2023-04-04 17:00:28');
INSERT INTO `student` VALUES (9, 9, '参加哦怕 ', '男', '经管院', '经管', '计科1601', 13, 'xuesheng9', '2023-03-07 16:10:55', '2023-04-25 22:48:42');
INSERT INTO `student` VALUES (10, 10, '从讲哦安排', '男', '经管院', '经管', '计科1701', 13, 'xuesheng10', '2023-03-07 16:10:55', '2023-04-25 22:48:44');
INSERT INTO `student` VALUES (15, 156, 'joapj', NULL, '计算机院', '计科', '计科1504', 18, '112233', '2023-03-20 11:00:06', '2023-04-28 15:59:21');

-- ----------------------------
-- Table structure for student_information
-- ----------------------------
DROP TABLE IF EXISTS `student_information`;
CREATE TABLE `student_information`  (
  `stu_information_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生信息ID',
  `class_number` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班级号',
  `stu_number` int(11) NULL DEFAULT NULL COMMENT '学号',
  `stu_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学生姓名',
  `tel` int(11) NULL DEFAULT 0 COMMENT '电话',
  `major` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业',
  `tea_number` int(11) NULL DEFAULT 0 COMMENT '教师编号',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`stu_information_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '学生信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_information
-- ----------------------------

-- ----------------------------
-- Table structure for study_plan
-- ----------------------------
DROP TABLE IF EXISTS `study_plan`;
CREATE TABLE `study_plan`  (
  `study_plan_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学习计划ID',
  `plan_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '计划名称',
  `time_trend` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '计时方向',
  `plan_time` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '计划时长/分钟',
  `today_num` int(11) NULL DEFAULT 0 COMMENT '今日完成次数',
  `total_num` int(11) NULL DEFAULT 0 COMMENT '总完成次数',
  `today_time` int(11) NULL DEFAULT 0 COMMENT '今日时长/分钟',
  `total_time` int(11) NULL DEFAULT 0 COMMENT '总时长/分钟',
  `username` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '\r\n更新时间',
  PRIMARY KEY (`study_plan_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '学习计划' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of study_plan
-- ----------------------------
INSERT INTO `study_plan` VALUES (1, '四级', '倒计时', 120, 3, 47, 3, 423, 'xuesheng1', '2023-03-07 16:10:55', '2023-05-21 19:05:45');
INSERT INTO `study_plan` VALUES (2, '考研408', '正倒计时', 180, 1, 17, 14, 359, 'xuesheng1', '2023-03-07 16:10:55', '2023-04-23 18:56:44');
INSERT INTO `study_plan` VALUES (3, '计算机网络', '倒计时', 120, 3, 17, 30, 361, 'xuesheng1', '2023-03-07 16:10:55', '2023-04-23 18:56:38');
INSERT INTO `study_plan` VALUES (4, '高数', '倒计时', 120, 1, 18, 19, 356, 'xuesheng1', '2023-03-07 16:10:55', '2023-04-23 18:57:00');
INSERT INTO `study_plan` VALUES (5, '跑步', '正倒计时', 120, 5, 23, 15, 357, 'xuesheng1', '2023-03-07 16:10:55', '2023-04-23 18:56:54');
INSERT INTO `study_plan` VALUES (6, '政治', '倒计时', 120, 1, 18, 90, 357, 'xuesheng1', '2023-03-07 16:10:55', '2023-04-23 18:57:11');
INSERT INTO `study_plan` VALUES (7, '四级', '正倒计时', 120, 1, 16, 0, 356, 'xuesheng2', '2023-03-07 16:10:55', '2023-05-11 14:13:50');
INSERT INTO `study_plan` VALUES (8, '408', '倒计时', 120, NULL, 15, 120, 356, 'xuesheng2', '2023-03-07 16:10:55', '2023-04-18 11:23:12');
INSERT INTO `study_plan` VALUES (9, '政治', '倒计时', 120, NULL, 15, NULL, 356, 'xuesheng2', '2023-03-07 16:10:55', '2023-03-23 21:52:20');
INSERT INTO `study_plan` VALUES (10, '高数', '正倒计时', 120, NULL, 15, NULL, 356, 'xuesheng2', '2023-03-07 16:10:55', '2023-03-23 21:52:20');
INSERT INTO `study_plan` VALUES (11, '四级', '倒计时', 120, NULL, 15, NULL, 356, 'xuesheng3', '2023-03-07 16:10:55', '2023-03-23 21:52:20');
INSERT INTO `study_plan` VALUES (12, '高数', '正倒计时', 120, NULL, 15, NULL, 356, 'xuesheng3', '2023-03-07 16:10:55', '2023-03-23 21:52:20');
INSERT INTO `study_plan` VALUES (13, '政治', '倒计时', 120, NULL, 15, NULL, 356, 'xuesheng3', '2023-03-07 16:10:55', '2023-03-23 21:52:20');
INSERT INTO `study_plan` VALUES (14, '运动 ', '倒计时', 120, NULL, 15, NULL, 356, 'xuesheng3', '2023-03-07 16:10:55', '2023-03-23 21:52:20');
INSERT INTO `study_plan` VALUES (15, '408', '倒计时', 120, NULL, 15, NULL, 356, 'xuesheng3', '2023-03-07 16:10:55', '2023-03-23 21:52:20');
INSERT INTO `study_plan` VALUES (16, '四级', '正倒计时', 120, NULL, 15, NULL, 356, 'xuesheng4', '2023-03-07 16:10:55', '2023-03-23 21:52:20');
INSERT INTO `study_plan` VALUES (17, '音乐', '倒计时', 120, NULL, 15, NULL, 356, 'xuesheng4', '2023-03-07 16:10:55', '2023-03-23 21:52:20');
INSERT INTO `study_plan` VALUES (18, '逛街', '正倒计时', 120, NULL, 15, NULL, 356, 'xuesheng4', '2023-03-07 16:10:55', '2023-03-23 21:52:20');
INSERT INTO `study_plan` VALUES (19, '游戏', '倒计时', 120, NULL, 15, NULL, 356, 'xuesheng4', '2023-03-07 16:10:55', '2023-03-23 21:52:20');
INSERT INTO `study_plan` VALUES (20, '四级', '倒计时', 120, NULL, 15, NULL, 356, 'xuesheng5', '2023-03-07 16:10:55', '2023-03-23 21:52:20');
INSERT INTO `study_plan` VALUES (21, '上分', '正倒计时', 120, NULL, 15, NULL, 356, 'xuesheng5', '2023-03-07 16:10:55', '2023-03-23 21:51:20');
INSERT INTO `study_plan` VALUES (22, '直播', '倒计时', 120, NULL, 15, NULL, 356, 'xuesheng5', '2023-03-07 16:10:55', '2023-03-23 21:52:20');
INSERT INTO `study_plan` VALUES (23, '四级', '倒计时', 120, NULL, 15, NULL, 356, 'xuesheng6', '2023-03-07 16:10:55', '2023-03-23 21:52:20');
INSERT INTO `study_plan` VALUES (24, '钢琴', '正倒计时', 120, NULL, 15, NULL, 356, 'xuesheng6', '2023-03-07 16:10:55', '2023-03-23 21:52:20');
INSERT INTO `study_plan` VALUES (25, '四级', '倒计时', 120, NULL, 15, NULL, 356, 'xuesheng7', '2023-03-07 16:10:55', '2023-03-23 21:52:20');
INSERT INTO `study_plan` VALUES (26, '兼职', '倒计时', 120, NULL, 15, NULL, 356, 'xuesheng7', '2023-03-07 16:10:55', '2023-03-23 21:52:20');
INSERT INTO `study_plan` VALUES (27, '篮球', '正倒计时', 120, NULL, 15, NULL, 356, 'xuesheng7', '2023-03-07 16:10:55', '2023-03-23 21:52:20');
INSERT INTO `study_plan` VALUES (28, '四级', '倒计时', 120, NULL, 15, NULL, 356, 'xuesheng8', '2023-03-07 16:10:55', '2023-03-23 21:52:20');
INSERT INTO `study_plan` VALUES (29, '足球', '正倒计时', 120, NULL, 15, NULL, 356, 'xuesheng8', '2023-03-07 16:10:55', '2023-03-23 21:52:20');
INSERT INTO `study_plan` VALUES (30, '四级', '倒计时', 120, NULL, 15, NULL, 356, 'xuesheng9', '2023-03-07 16:10:55', '2023-03-23 21:52:20');
INSERT INTO `study_plan` VALUES (31, '作业', '正倒计时', 120, NULL, 15, NULL, 356, 'xuesheng9', '2023-03-07 16:10:55', '2023-03-23 21:52:20');
INSERT INTO `study_plan` VALUES (32, '四级', '倒计时', 120, NULL, 1, NULL, 3, 'xuesheng10', '2023-03-07 16:10:55', '2023-04-15 16:04:10');
INSERT INTO `study_plan` VALUES (33, '上课', '正倒计时', 120, NULL, 1, NULL, 5, 'xuesheng10', '2023-03-07 16:10:55', '2023-04-15 16:04:12');
INSERT INTO `study_plan` VALUES (34, '项目', '倒计时', 120, 0, 1, NULL, 6, 'xuesheng10', '2023-03-07 16:10:55', '2023-04-15 16:04:24');
INSERT INTO `study_plan` VALUES (38, '论文', '倒计时', 23, 1, 2, 0, 0, 'xuesheng1', '2023-05-16 16:33:16', '2023-05-20 23:50:36');

-- ----------------------------
-- Table structure for study_room
-- ----------------------------
DROP TABLE IF EXISTS `study_room`;
CREATE TABLE `study_room`  (
  `study_room_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自习室ID',
  `code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '加入码',
  `type` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '是否公开',
  `room_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '自习室名称',
  `room_introduce` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '自习室简介',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '密码：由6-16位数字或英文组成',
  `join_num` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '加入人数',
  `limit_num` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '限定人数',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`study_room_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '自习室' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of study_room
-- ----------------------------
INSERT INTO `study_room` VALUES (1, '437b16c0', '公开', '四级！DCFSA', '必过----加油！！！', 'd41d8cd98f00b204e9800998ecf8427e', 6, 50, '2023-04-15 23:15:19', '2023-04-15 23:15:19');
INSERT INTO `study_room` VALUES (2, '15f0f66e', '公开', '23考研', '上岸', 'd41d8cd98f00b204e9800998ecf8427e', 1, 50, '2023-04-16 15:30:50', '2023-04-16 15:30:50');
INSERT INTO `study_room` VALUES (3, '146fae5w', '公开', '23考研', '上岸管道施工施工', 'e10adc3949ba59abbe56e057f20f883e', 2, 50, '2023-04-16 15:30:50', '2023-04-16 15:30:50');
INSERT INTO `study_room` VALUES (4, '7846fb56', '公开', '四级', '过过过', 'e10adc3949ba59abbe56e057f20f883e', 1, 50, '2023-04-16 15:32:13', '2023-04-16 15:32:13');
INSERT INTO `study_room` VALUES (5, '16035faf', '公开', '哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈', '哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈', 'd41d8cd98f00b204e9800998ecf8427e', 1, 299, '2023-04-16 17:52:33', '2023-04-16 17:52:33');
INSERT INTO `study_room` VALUES (6, 'ca6bb4bc', '公开', '啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊', '去钱去钱去钱钱钱钱去钱钱钱去钱去钱钱去钱钱钱去钱钱钱钱去去钱钱去请求去钱钱钱钱钱钱钱钱钱钱钱钱钱钱钱', 'd41d8cd98f00b204e9800998ecf8427e', 1, 300, '2023-04-16 17:55:07', '2023-04-16 17:55:07');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `tea_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '教师ID',
  `tea_number` int(11) NOT NULL COMMENT '教师编号',
  `tea_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '教师姓名',
  `gender` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `courses` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所教课程',
  `faculties` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所在专业/院系/年级',
  `examine_state` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '已通过' COMMENT '审核状态',
  `username` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`tea_id`) USING BTREE,
  UNIQUE INDEX `tea_number`(`tea_number`) USING BTREE,
  INDEX `user_id`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '教师' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (2, 1, '物价持续四 ', '男', '数据结构', '计算机院', '通过', 'jiaoshi1', '2023-03-07 16:10:55', '2023-04-14 13:36:10');
INSERT INTO `teacher` VALUES (3, 12, '物价持续6', '男', '计算机', '计算机院', '通过', 'jiaoshi2', '2023-03-07 16:10:55', '2023-03-17 14:05:32');
INSERT INTO `teacher` VALUES (4, 11, '物价持续四 ', '男', '计算机', '计算机院', '通过', 'jiaoshi3', '2023-03-07 16:10:55', '2023-03-17 14:05:35');
INSERT INTO `teacher` VALUES (5, 13, '物价持续四 ', '男', '计算机', '经管院', '通过', 'jiaoshi4', '2023-03-07 16:10:55', '2023-03-18 11:06:55');
INSERT INTO `teacher` VALUES (6, 14, '物价持续2', '男', '计算机', '计算机院', '通过', 'jiaoshi5', '2023-03-07 16:10:55', '2023-03-17 14:05:41');
INSERT INTO `teacher` VALUES (7, 15, '物价持续四 ', '男', '计算机', '计算机院', '未通过', 'jiaoshi6', '2023-03-07 16:10:55', '2023-03-17 22:09:57');
INSERT INTO `teacher` VALUES (8, 16, '物价持续2', '男', '计算机', '计算机院', '通过', 'jiaoshi7', '2023-03-07 16:10:55', '2023-03-17 14:05:48');
INSERT INTO `teacher` VALUES (9, 17, '物价持续四 ', '男', '计算机', '计算机院', '通过', 'jiaoshi8', '2023-03-07 16:10:55', '2023-03-17 14:05:51');
INSERT INTO `teacher` VALUES (10, 18, '物价持续6', '男', '计算机', '计算机院', '通过', 'jiaoshi9', '2023-03-07 16:10:55', '2023-03-17 14:05:55');
INSERT INTO `teacher` VALUES (11, 19, '物价持续四 ', '男', '计算机', '计算机院', '通过', 'jiaoshi10', '2023-03-07 16:10:55', '2023-03-17 14:05:58');
INSERT INTO `teacher` VALUES (15, 156, '骄傲就', NULL, NULL, '经管院', '未通过', '111111', '2023-03-20 11:01:05', '2023-03-20 11:01:05');

-- ----------------------------
-- Table structure for upclock
-- ----------------------------
DROP TABLE IF EXISTS `upclock`;
CREATE TABLE `upclock`  (
  `clock_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '打卡ID',
  `username` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `up_time` datetime(0) NULL DEFAULT NULL COMMENT '起床打卡时间',
  PRIMARY KEY (`clock_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '打卡' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of upclock
-- ----------------------------
INSERT INTO `upclock` VALUES (1, 'xuesheng1', '2023-03-07 04:41:40');
INSERT INTO `upclock` VALUES (2, 'xuesheng1', '2023-03-08 05:45:26');
INSERT INTO `upclock` VALUES (3, 'xuesheng1', '2023-03-18 07:46:48');
INSERT INTO `upclock` VALUES (4, 'xuesheng1', '2023-03-19 09:53:36');
INSERT INTO `upclock` VALUES (5, 'xuesheng1', '2023-03-20 10:02:22');
INSERT INTO `upclock` VALUES (6, 'xuesheng1', '2023-03-21 07:07:05');
INSERT INTO `upclock` VALUES (7, 'xuesheng1', '2023-03-22 11:10:29');
INSERT INTO `upclock` VALUES (8, 'xuesheng1', '2023-03-23 10:48:55');
INSERT INTO `upclock` VALUES (9, 'xuesheng1', '2023-03-24 09:49:33');
INSERT INTO `upclock` VALUES (10, 'xuesheng1', '2023-03-25 08:50:22');
INSERT INTO `upclock` VALUES (11, 'xuesheng1', '2023-04-17 08:50:22');
INSERT INTO `upclock` VALUES (12, 'xuesheng3', '2023-04-17 06:50:22');
INSERT INTO `upclock` VALUES (13, 'xuesheng2', '2023-04-17 08:50:22');
INSERT INTO `upclock` VALUES (14, 'xuesheng1', '2023-04-18 10:44:14');
INSERT INTO `upclock` VALUES (15, 'xuesheng1', '2023-04-18 10:44:23');

-- ----------------------------
-- Table structure for upload
-- ----------------------------
DROP TABLE IF EXISTS `upload`;
CREATE TABLE `upload`  (
  `upload_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '上传ID',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件名',
  `id` int(11) NULL DEFAULT NULL COMMENT '自习室ID',
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '上传者',
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '唯一编码',
  `type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件类型',
  `docSize` double(16, 2) NOT NULL COMMENT '文件大小',
  `downloadNum` int(11) UNSIGNED NULL DEFAULT 0 COMMENT '下载次数',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`upload_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of upload
-- ----------------------------
INSERT INTO `upload` VALUES (3, '功能图.docx', 1, 'xuesheng1', '8da563ce13a644c1ab30e0d37736943e', 'docx', 76257.00, 1, '2023-04-20 12:53:46', '2023-04-21 11:58:24');
INSERT INTO `upload` VALUES (4, '无名---图灵书下载网址.txt', 1, 'xuesheng1', '51d10ed284e1446282915eca61f51b51', 'txt', 1.00, 0, '2023-04-20 12:54:47', '2023-04-20 12:56:27');
INSERT INTO `upload` VALUES (5, 'xszlglxt数据库.docx', 1, 'xuesheng1', '0881f8fd51034b109630031431a3025d', 'docx', 24356.00, 0, '2023-04-20 12:55:32', '2023-04-20 12:55:32');
INSERT INTO `upload` VALUES (6, '学习计划sql语句.docx', 1, 'xuesheng2', 'ac51adbe6f214c04b95e434a19446e77', 'docx', 17824.00, 0, '2023-04-20 13:06:31', '2023-04-20 13:06:31');
INSERT INTO `upload` VALUES (7, '用户管理sql语句.docx', 1, 'xuesheng2', 'be04594e7507401abd1fddc2da32afe2', 'docx', 21149.00, 0, '2023-04-20 13:17:52', '2023-04-20 13:17:52');
INSERT INTO `upload` VALUES (10, '用户管理sql语句.docx', 1, 'xuesheng1', '4e7f7339d31146be9ed113d20339c1ac', 'docx', 21149.00, 0, '2023-04-20 15:05:00', '2023-04-20 15:05:00');
INSERT INTO `upload` VALUES (12, '雨声.mp3', -1, 'admin', '/music/01208cd20639417bb775a8dc3dac12a2===雨声.mp3', 'mp3', 823632.00, 0, '2023-04-27 14:20:03', '2023-04-27 14:53:29');
INSERT INTO `upload` VALUES (13, '夏日海浪.mp3', -1, 'admin', '/music/f5452e7f36df40e58606bd1080828efc===夏日海浪.mp3', 'mp3', 510790.00, 0, '2023-04-27 14:20:35', '2023-04-27 14:53:35');
INSERT INTO `upload` VALUES (11, '时钟滴答.mp3', -1, 'admin', '/music/2e256607659948699d65bfc1dfbc399a===时钟滴答.mp3', 'mp3', 995287.00, 0, '2023-04-27 14:20:38', '2023-04-27 14:53:38');
INSERT INTO `upload` VALUES (14, '热带雨林.mp3', -1, 'admin', '/music/290cf8f9c0b8415eb4a3cb0fe5b854b8===热带雨林.mp3', 'mp3', 626983.00, 0, '2023-04-27 14:20:40', '2023-04-27 14:53:40');
INSERT INTO `upload` VALUES (18, '小河流水.mp3', -1, 'admin', '/music/9975ce81062549d48194ffe10bcfd686===小河流水.mp3', 'mp3', 4898525.00, 0, '2023-04-27 14:31:03', '2023-04-27 14:53:43');
INSERT INTO `upload` VALUES (20, 'despair.mp3', -1, 'xuesheng1', '/music/9bbec123e0da49588a9e60d7482180a2===despair.mp3', 'mp3', 3812249.00, 0, '2023-04-27 23:05:23', '2023-04-27 23:05:23');
INSERT INTO `upload` VALUES (21, 'wake.mp3', -1, 'xuesheng1', '/music/0be9bb1a79094f72b6176b7f88907d56===wake.mp3', 'mp3', 4080161.00, 0, '2023-04-27 23:06:06', '2023-04-27 23:06:06');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户ID：[0,8388607]用户获取其他与用户相关的数据',
  `user_group` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所在用户组：[0,32767]决定用户身份和权限',
  `login_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '登录时间：',
  `phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码：[0,11]用户的手机号码，用于找回密码时或登录时',
  `username` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '用户名：[0,16]用户登录时所用的账户名称',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '密码：[0,32]用户登录所需的密码，由6-16位数字或英文组成',
  `status` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号状态',
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '邮箱：[0,64]用户的邮箱，用于找回密码时或登录时',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像地址：[0,255]',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间：',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 42 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户账户：用于保存用户登录信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '管理员', '2023-05-07 22:02:02', NULL, 'admin', 'e10adc3949ba59abbe56e057f20f883e', '可用', '', '/img/gly.jpg', '2023-03-03 10:36:41');
INSERT INTO `user` VALUES (2, '教师', '2023-05-20 23:47:14', '15612345611', 'jiaoshi1', 'e10adc3949ba59abbe56e057f20f883e', '可用', '31@qq.com', '/img/fe64d9c7bee4498e89409d3d44d4e120===1.jpg', '2023-03-07 16:10:55');
INSERT INTO `user` VALUES (3, '教师', '2023-03-07 16:10:55', '15612345611', 'jiaoshi2', 'e10adc3949ba59abbe56e057f20f883e', '可用', '', '', '2023-03-07 16:10:55');
INSERT INTO `user` VALUES (4, '教师', '2023-03-07 16:10:55', '15612345611', 'jiaoshi3', 'e10adc3949ba59abbe56e057f20f883e', '可用', '', '', '2023-03-07 16:10:55');
INSERT INTO `user` VALUES (5, '教师', '2023-03-07 16:10:55', '15612345611', 'jiaoshi4', 'e10adc3949ba59abbe56e057f20f883e', '可用', '', '', '2023-03-07 16:10:55');
INSERT INTO `user` VALUES (6, '教师', '2023-03-07 16:10:55', '15612345611', 'jiaoshi5', 'e10adc3949ba59abbe56e057f20f883e', '可用', '', '', '2023-03-07 16:10:55');
INSERT INTO `user` VALUES (7, '教师', '2023-03-17 22:08:29', '15612345611', 'jiaoshi6', 'e10adc3949ba59abbe56e057f20f883e', '禁用', '', '', '2023-03-07 16:10:55');
INSERT INTO `user` VALUES (8, '教师', '2023-03-07 16:10:55', '15612345611', 'jiaoshi7', 'e10adc3949ba59abbe56e057f20f883e', '可用', '', '', '2023-03-07 16:10:55');
INSERT INTO `user` VALUES (9, '教师', '2023-03-07 16:10:55', '15612345611', 'jiaoshi8', 'e10adc3949ba59abbe56e057f20f883e', '可用', '', '', '2023-03-07 16:10:55');
INSERT INTO `user` VALUES (10, '教师', '2023-03-07 16:10:55', '15612345611', 'jiaoshi9', 'e10adc3949ba59abbe56e057f20f883e', '可用', '', '', '2023-03-07 16:10:55');
INSERT INTO `user` VALUES (11, '教师', '2023-03-07 16:10:55', '15612345611', 'jiaoshi10', 'e10adc3949ba59abbe56e057f20f883e', '可用', '', '', '2023-03-07 16:10:55');
INSERT INTO `user` VALUES (12, '学生', '2023-05-20 23:41:21', '15612345611', 'xuesheng1', 'e10adc3949ba59abbe56e057f20f883e', '可用', '3132935841@qq.com', '/img/git.png', '2023-03-07 16:10:55');
INSERT INTO `user` VALUES (13, '学生', '2023-05-11 14:13:18', '15612345611', 'xuesheng2', 'e10adc3949ba59abbe56e057f20f883e', '可用', '31@qq.com', '', '2023-03-07 16:10:55');
INSERT INTO `user` VALUES (14, '学生', '2023-04-18 18:54:47', '15612345611', 'xuesheng3', 'e10adc3949ba59abbe56e057f20f883e', '可用', '31@qq.com', '', '2023-03-07 16:10:55');
INSERT INTO `user` VALUES (15, '学生', '2023-04-21 18:11:11', '15612345611', 'xuesheng4', 'e10adc3949ba59abbe56e057f20f883e', '可用', '31@qq.com', '', '2023-03-07 16:10:55');
INSERT INTO `user` VALUES (16, '学生', '2023-04-19 14:01:54', '15612345611', 'xuesheng5', 'e10adc3949ba59abbe56e057f20f883e', '可用', '31@qq.com', '', '2023-03-07 16:10:55');
INSERT INTO `user` VALUES (17, '学生', '2023-04-18 22:50:21', '15612345611', 'xuesheng6', 'e10adc3949ba59abbe56e057f20f883e', '可用', '31@qq.com', '', '2023-03-07 16:10:55');
INSERT INTO `user` VALUES (18, '学生', '2023-04-16 22:26:49', '15612345611', 'xuesheng7', 'e10adc3949ba59abbe56e057f20f883e', '可用', '31@qq.com', '', '2023-03-07 16:10:55');
INSERT INTO `user` VALUES (19, '学生', '2023-03-07 16:10:55', '15612345611', 'xuesheng8', 'e10adc3949ba59abbe56e057f20f883e', '可用', '31@qq.com', '', '2023-03-07 16:10:55');
INSERT INTO `user` VALUES (20, '学生', '2023-04-15 16:14:01', '15612345611', 'xuesheng9', 'e10adc3949ba59abbe56e057f20f883e', '禁用', '31@qq.com', '', '2023-03-07 16:10:55');
INSERT INTO `user` VALUES (21, '学生', '2023-04-15 16:14:09', '15612345611', 'xuesheng10', 'e10adc3949ba59abbe56e057f20f883e', '可用', '31@qq.com', '', '2023-03-07 16:10:55');
INSERT INTO `user` VALUES (40, '学生', NULL, NULL, '112233', 'e10adc3949ba59abbe56e057f20f883e', '可用', '31@qq.com', '', '2023-03-20 11:00:06');
INSERT INTO `user` VALUES (41, '教师', '2023-03-20 22:27:25', NULL, '111111', 'e10adc3949ba59abbe56e057f20f883e', '可用', '1704503784@qq.com', '', '2023-03-20 11:01:05');

-- ----------------------------
-- Table structure for user_group
-- ----------------------------
DROP TABLE IF EXISTS `user_group`;
CREATE TABLE `user_group`  (
  `group_id` int(8) NOT NULL AUTO_INCREMENT COMMENT '用户组ID：[0,8388607]',
  `name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '名称：[0,16]',
  `source_table` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '来源表：',
  `source_field` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '来源字段：',
  `source_id` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '来源ID：',
  `register` int(1) UNSIGNED NULL DEFAULT 0 COMMENT '注册位置:',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间：',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间：',
  PRIMARY KEY (`group_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户组：用于用户前端身份和鉴权' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_group
-- ----------------------------
INSERT INTO `user_group` VALUES (1, '学生', 'student', 'student_id', 0, 1, '2023-03-07 16:10:55', '2023-03-07 16:10:55');
INSERT INTO `user_group` VALUES (2, '教师', 'teacher', 'teacher_id', 0, 0, '2023-03-07 16:10:55', '2023-03-07 16:10:55');
INSERT INTO `user_group` VALUES (3, '管理员', '', '', 0, NULL, '2023-03-07 16:10:55', '2023-03-07 16:10:55');

-- ----------------------------
-- Table structure for wt
-- ----------------------------
DROP TABLE IF EXISTS `wt`;
CREATE TABLE `wt`  (
  `wt_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '解惑ID',
  `id` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '自习室Id',
  `username` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发布人',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '问题/解答内容',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间：',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间：',
  PRIMARY KEY (`wt_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '解惑' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wt
-- ----------------------------
INSERT INTO `wt` VALUES (6, 1, 'xuesheng2', '四级怎么能6个小时就过？', '2023-04-21 20:50:12', '2023-04-21 20:50:12');
INSERT INTO `wt` VALUES (3, 1, 'xuesheng1', '前端怎么学习啊？', '2023-04-21 17:31:49', '2023-04-21 17:31:49');
INSERT INTO `wt` VALUES (4, 2, 'xuesheng4', '考研怎么上岸？', '2023-04-21 18:13:42', '2023-04-21 18:15:20');
INSERT INTO `wt` VALUES (5, 2, 'xuesheng4', '需要考研应该怎么学习？', '2023-04-21 18:16:29', '2023-04-21 18:16:29');

-- ----------------------------
-- Table structure for xs_notice
-- ----------------------------
DROP TABLE IF EXISTS `xs_notice`;
CREATE TABLE `xs_notice`  (
  `xsnotice_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生通知ID',
  `notice_id` int(11) NOT NULL COMMENT '通知id',
  `username` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '用户名',
  `level` int(11) NULL DEFAULT 0 COMMENT '级别（置顶）',
  `received` int(11) NULL DEFAULT 0 COMMENT '是否确认收到',
  PRIMARY KEY (`xsnotice_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 50 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '通知' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of xs_notice
-- ----------------------------
INSERT INTO `xs_notice` VALUES (1, 7, 'xuesheng1', 0, 1);
INSERT INTO `xs_notice` VALUES (40, 8, 'xuesheng1', 0, 1);
INSERT INTO `xs_notice` VALUES (41, 9, 'xuesheng1', 0, 0);
INSERT INTO `xs_notice` VALUES (42, 34, 'xuesheng1', 0, 0);
INSERT INTO `xs_notice` VALUES (43, 23, 'xuesheng1', 0, 0);
INSERT INTO `xs_notice` VALUES (44, 32, 'xuesheng1', 0, 1);
INSERT INTO `xs_notice` VALUES (45, 33, 'xuesheng1', 0, 0);
INSERT INTO `xs_notice` VALUES (46, 1, 'xuesheng1', 0, 1);
INSERT INTO `xs_notice` VALUES (47, 41, 'xuesheng3', 0, 0);
INSERT INTO `xs_notice` VALUES (48, 53, 'xuesheng1', 0, 1);
INSERT INTO `xs_notice` VALUES (49, 43, 'xuesheng1', 0, 0);

SET FOREIGN_KEY_CHECKS = 1;
