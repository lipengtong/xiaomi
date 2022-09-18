/*
 Navicat Premium Data Transfer

 Source Server         : qe
 Source Server Type    : MySQL
 Source Server Version : 50540
 Source Host           : localhost:3306
 Source Schema         : xiaomidb

 Target Server Type    : MySQL
 Target Server Version : 50540
 File Encoding         : 65001

 Date: 05/01/2022 15:39:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `cid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `order_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('2', '航天系列', '1', '1', '卫星、航母火箭等', '25/12/2018 09:53:55');
INSERT INTO `category` VALUES ('3', '手机 平板', '1', '0', '各种小米系手机', '25/12/2018 14:20:12');
INSERT INTO `category` VALUES ('4', '户外运动', '1', '2', ' 电视、冰箱、洗衣机等', '25/12/2018 14:20:42');
INSERT INTO `category` VALUES ('5', '儿童玩具', '1', '3', '各种玩具', '25/12/2018 16:38:14');
INSERT INTO `category` VALUES ('6', '智能产品', '1', '2', NULL, '26/12/2018 14:46:27');
INSERT INTO `category` VALUES ('7', '图书 内容', '1', '55', NULL, '25/12/2018 09:53:55');
INSERT INTO `category` VALUES ('8', '移动电源 电池 插线板', '1', '33', '1', '26/12/2018 14:48:16');
INSERT INTO `category` VALUES ('9', '耳机 音响', '1', '34', NULL, '26/12/2018 14:48:31');
INSERT INTO `category` VALUES ('10', '保护套 贴膜', '1', '35', NULL, '26/12/2018 14:48:47');
INSERT INTO `category` VALUES ('11', '线材 支架 存储卡', '1', '36', NULL, '26/12/2018 14:49:04');
INSERT INTO `category` VALUES ('12', '箱包 服饰 鞋 眼镜', '1', '37', NULL, '26/12/2018 14:49:19');
INSERT INTO `category` VALUES ('13', '米兔 生活周边', '1', '38', NULL, '26/12/2018 14:49:33');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `orders_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `uid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sum_price` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `count_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1627041657523', '1', '1000000', '0', NULL, '1');
INSERT INTO `orders` VALUES ('1627041785335', '1', '1000000', '0', NULL, '1');
INSERT INTO `orders` VALUES ('1627041858510', '1', '1000000', '0', NULL, '1');
INSERT INTO `orders` VALUES ('1627042090450', '1', '1000000', '0', NULL, '1');
INSERT INTO `orders` VALUES ('1627053490314', '3', '520', '0', NULL, '1');
INSERT INTO `orders` VALUES ('1627201595808', '3', '15520', '0', NULL, '2');
INSERT INTO `orders` VALUES ('1627546899529', '3', '15520', '0', NULL, '2');
INSERT INTO `orders` VALUES ('1631257045708', '1', '1005598', '0', NULL, '3');
INSERT INTO `orders` VALUES ('1631613012920', '1', '1005598', '0', NULL, '3');
INSERT INTO `orders` VALUES ('1640179149053', '2', '520.0', '0', NULL, '1');
INSERT INTO `orders` VALUES ('1640180326088', '2', '1000520.0', '0', NULL, '2');
INSERT INTO `orders` VALUES ('1640180314351', '2', '1000520.0', '0', NULL, '2');
INSERT INTO `orders` VALUES ('1640180322882', '2', '1000520.0', '0', NULL, '2');
INSERT INTO `orders` VALUES ('1640180424967', '2', '520.0', '0', NULL, '1');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `pid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `color` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `size` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `full_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `version` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('3', '2', '小浣熊干脆面1', '棕色1', '包1', '1', '好吃不贵', '童年的最爱', '638707ea-5ed9-4e10-afe1-d428570eb4eatimg.jpg', '1', '1.1', '26/12/2018 11:25:45');
INSERT INTO `product` VALUES ('4', '2', '神舟五号', '白色', '1993*365', '1000000', '中国骄傲', '国家一级机密SSS', '7ff58893-5fb1-4430-81b3-755c650ee8aatimg (1).jpg', '4', '神州5号', '25/12/2018 00:00:00');
INSERT INTO `product` VALUES ('9', '3', '小米笔记本Air 13.3', '银灰色', '13.3', '5399', '高性能轻薄笔记本\r\n设计制图、运行大型 3D 游戏，复杂任务也可以轻松驾驭。', 'i7处理器／8GB／独显\r\n第八代英特尔®酷睿™ i7处理器\r\n', 'e328db7b-41a4-40ac-b7f5-ecf8ec1d8c01220x220.jpg', NULL, 'air', '26/12/2018 15:22:42');
INSERT INTO `product` VALUES ('10', '6', '九号平衡车', '白色', '54.8*123', '520', '最高车速：	约16km/h\r\n最大扭矩：	整机35Nm*2', '\r\n电动机额定功率：	350W x 2\r\n电机控制方式：	正弦波矢量控制，电流+速度闭环控制算法', '42796f9f-687a-4a86-9802-780da5f9aa12T1PX200x200.jpg', '4', '1', '26/12/2018 15:26:09');
INSERT INTO `product` VALUES ('11', '6', '小米路由器4Q', '蓝色', '11', '199', 'MiNET 一键快连智能设备', '高增益全向3天线，覆盖广 ／ 红包 WiFi 赚取零用钱', '2d370544-b521-4ac7-8607-fdfa16361959pms_15291.jpg', '4', '1.1', '26/12/2018 15:28:15');
INSERT INTO `product` VALUES ('12', '3', '小米6X', '蓝色', '5.8', '4999', '64GB+64GB，赤焰红、樱花粉限时秒杀，到手价1419元', '「6GB+64GB 移动4G+版，加赠米家车载空气净化器」轻薄美观的拍照手机 / 前置2000万“治愈系”自拍 / 后置2000万 AI双摄 / 标配骁龙660 AIE处理器', '2f2f75e8-e044-4dd5-9b38-b3ee115ff4738619.jpg', '4', '1.1', '26/12/2018 15:30:48');
INSERT INTO `product` VALUES ('13', '4', '小米电视4A 43英寸 青春版', '白色', '43', '4999', '人工智能语音系统\r\n全高清屏\r\n64位四核处理器\r\n', '人工智能语音系统\r\n全高清屏\r\n64位四核处理器\r\n海量影视内容\r\n杜比音效\r\n1GB+8GB 大内存', '2aff3811-78fb-418e-acdc-90401cf166460.jpg', '0', '1.1', '27/12/2018 09:27:32');
INSERT INTO `product` VALUES ('14', '4', '小米电视4A 43英寸 老年版', '棕色', '43', '998', '人工智能语音系统', '人工智能语音系统', '0c955dfb-2d0f-454b-b87a-9a91a810a4410.jpg', '0', '1', '27/12/2018 09:29:40');
INSERT INTO `product` VALUES ('15', '4', '小米电视4A 43英寸 少年版', '棕色', '43', '15000', '人工智能语音系统', '人工智能语音系统', '876738db-7514-4fd1-972a-cb39a8dc55c80.jpg', '3', '1', '27/12/2018 09:30:22');
INSERT INTO `product` VALUES ('16', '4', '小米电视4A 43英寸 幼儿版', '蓝色', '43', '998', '海量影视内容', '海量影视内容', '985c95ec-b9b8-427c-bef9-a5d3e1fb15250.jpg', '2', 'air', '27/12/2018 09:31:05');
INSERT INTO `product` VALUES ('17', '4', '小米电视4A 43英寸 旗舰版', '棕色', '43', '5399', '杜比音效', '杜比音效', 'eaebf9ec-cdad-4d46-915f-67de08d655bd0.jpg', '3', '1.1', '26/12/2018 15:22:42');
INSERT INTO `product` VALUES ('18', '4', '米家互联网空调', '白色', '2882*123', '998', ' 米家互联网空调（一级能效）', ' 米家互联网空调（一级能效）', 'f3436d9a-cb89-423b-9b36-b1e5b77237cd20.jpg', '3', '1', '27/12/2018 09:33:45');
INSERT INTO `product` VALUES ('19', '4', '米家互联网空调（升级版）', '白色', '1993*365', '15000', ' 米家互联网空调（一级能效）', ' 米家互联网空调（一级能效）', 'af686cbe-a16b-41e8-a903-39346436a17520.jpg', '0', '123', '27/12/2018 09:34:33');
INSERT INTO `product` VALUES ('20', '4', ' 米家互联网空调(土豪版)', '蓝色', '1993*365', '15000', ' 米家互联网空调（一级能效', ' 米家互联网空调（一级能效', '54350161-4357-45f6-a71a-7387937caebe20.jpg', '1', '1', '27/12/2018 09:35:27');
INSERT INTO `product` VALUES ('21', '6', '小米手环1', '黑色', '1*132', '199', '心率、睡眠、记步，健康管理', '微信、QQ来电等消息内容直接显示 / 50米游泳防水 / 运动数据抬腕可见 / 心率、睡眠、记步，健康管理 / 长达20天续航能力', '8304a926-7272-4ee3-97cd-bbdb43ffe92f1338.jpg', '3', '1.1', '27/12/2018 10:23:07');
INSERT INTO `product` VALUES ('22', '6', '小米手环2', '棕色1', '包1', '199', '心率、睡眠、记步，健康管理 / 长达20天续航能力', '微信、QQ来电等消息内容直接显示 / 50米游泳防水 / 运动数据抬腕可见 / 心率、睡眠、记步，健康管理 / 长达20天续航能力', 'dcd05b4c-a59f-49dd-bc4d-097a8746f3351338.jpg', '0', '123', '27/12/2018 10:23:56');
INSERT INTO `product` VALUES ('23', '6', '小米手环3', '棕色', '包1', '998', '长达20天续航能力', '微信、QQ来电等消息内容直接显示 / 50米游泳防水 / 运动数据抬腕可见 / 心率、睡眠、记步，健康管理 / 长达20天续航能力', '4f0ff94a-e9c7-4096-a14e-44de82251b251338.jpg', '4', '123', '27/12/2018 10:24:23');
INSERT INTO `product` VALUES ('24', '6', '小米手环4', '棕色', '包1', '998', '微信、QQ来电等消息内容直接显示', '微信、QQ来电等消息内容直接显示 / 50米游泳防水 / 运动数据抬腕可见 / 心率、睡眠、记步，健康管理 / 长达20天续航能力', 'facdfa7b-6c4a-4340-8f60-0226f5452d1a1338.jpg', '2', '1', '27/12/2018 10:24:49');
INSERT INTO `product` VALUES ('25', '6', '小米手环5', '蓝色', '包1', '998', '50米游泳防水', '微信、QQ来电等消息内容直接显示 / 50米游泳防水 / 运动数据抬腕可见 / 心率、睡眠、记步，健康管理 / 长达20天续航能力', '895d28e2-bfab-46c6-8722-a60662315e4c1338.jpg', '1', '1.1', '27/12/2018 10:25:24');
INSERT INTO `product` VALUES ('26', '6', '小米米家行车记录仪1S', '棕色', '1993*365', '998', '索尼 IMX307图像传感器 ', '索尼 IMX307图像传感器 / 3D降噪 / IPS大屏 / 本地语音控制', '505294f3-0812-488d-a879-7361e133a6f0582.jpg', '1', '123', '27/12/2018 10:27:01');
INSERT INTO `product` VALUES ('27', '6', '小米米家行车记录仪2S', '棕色', '包1', '998', ' 3D降噪 / IPS大屏 / 本地语音控制', '索尼 IMX307图像传感器 / 3D降噪 / IPS大屏 / 本地语音控制', 'd71d279e-909b-4e37-a2b7-a9f02a82c052582.jpg', '2', '1.1', '27/12/2018 10:27:34');
INSERT INTO `product` VALUES ('28', '6', '小米米家行车记录仪3S', '棕色', '1993*365', '998', '小米米家行车记录仪1S', '小米米家行车记录仪1S', '58449bdb-7e58-4a2e-a579-9354bb0f8240582.jpg', '2', '1', '27/12/2018 10:28:00');
INSERT INTO `product` VALUES ('29', '6', '小米米家行车记录仪4S', '棕色', '43', '15000', '小米米家行车记录仪1S', '小米米家行车记录仪1S', 'cbc7a57a-b16e-4c1b-b512-0f53412da0e1582.jpg', '0', 'air', '27/12/2018 10:28:26');
INSERT INTO `product` VALUES ('30', '6', '小米米家行车记录仪5S', '白色', '包', '998', '小米米家行车记录仪1S', '小米米家行车记录仪1S', 'd673a98c-4721-47f7-b61b-ddaa3398da05582.jpg', '2', '123', '27/12/2018 10:29:01');

-- ----------------------------
-- Table structure for trolley
-- ----------------------------
DROP TABLE IF EXISTS `trolley`;
CREATE TABLE `trolley`  (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `orders_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`tid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of trolley
-- ----------------------------
INSERT INTO `trolley` VALUES (11, '1', '4', '1', '1631613012920');
INSERT INTO `trolley` VALUES (12, '1', '9', '1', '1631613012920');
INSERT INTO `trolley` VALUES (13, '1', '11', '1', '1631613012920');
INSERT INTO `trolley` VALUES (14, '3', '10', '1', '1627546899529');
INSERT INTO `trolley` VALUES (15, '3', '15', '1', '1627546899529');
INSERT INTO `trolley` VALUES (16, '2', '10', '1', '1640180424967');
INSERT INTO `trolley` VALUES (17, '2', '4', '1', '1640180326088');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `area` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `manager` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `photo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '张安', '0', '13113305869', '西安', '1', 'admin', '123456', '1.jpg', '23/11/2019 00:00:00');
INSERT INTO `user` VALUES ('2', '小王', '0', '110', '西安', '0', 'ad', '123456', NULL, NULL);
INSERT INTO `user` VALUES ('3', '仨', '1', '121', '线', '0', '人贩子', '123456', NULL, NULL);
INSERT INTO `user` VALUES ('4', '周思勇', '1', '18992787878', 'sx', '0', 'root', '147258', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
