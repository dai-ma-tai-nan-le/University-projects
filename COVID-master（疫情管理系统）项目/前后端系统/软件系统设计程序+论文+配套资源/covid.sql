/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.5.54 : Database - covid
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`covid` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `covid`;

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `id` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `charge` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `department` */

insert  into `department`(`id`,`name`,`charge`) values (1,'财务部','王刚'),(2,'人力资源部','李师'),(3,'后勤部','王二霞'),(4,'客服部','刘晓华'),(5,'研发部','李海红'),(6,'技术部','刘苏哈');

/*Table structure for table `emp_health` */

DROP TABLE IF EXISTS `emp_health`;

CREATE TABLE `emp_health` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `sex` int(1) DEFAULT NULL,
  `phonenum` bigint(20) DEFAULT NULL,
  `temp` float(4,1) DEFAULT NULL,
  `risk` varchar(30) DEFAULT NULL,
  `health` varchar(30) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `depart` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `de` (`depart`),
  CONSTRAINT `de` FOREIGN KEY (`depart`) REFERENCES `department` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `emp_health` */

insert  into `emp_health`(`id`,`name`,`sex`,`phonenum`,`temp`,`risk`,`health`,`content`,`createTime`,`depart`) values (2,'刘先生',1,15143355464,36.5,'否','正常','','2021-03-31 14:03:52','后勤部'),(3,'吴雷师',0,15151549751,37.0,'否','正常','无','2021-03-13 20:16:30','客服部'),(4,'刘腾键',1,13415135795,36.5,'否','正常','','2021-03-13 19:54:40','客服部'),(5,'刘腾键',1,13415135795,36.5,'否','感冒','','2021-03-13 19:54:40','研发部'),(6,'刘胜虎',1,123414234123,39.0,'否','低烧','','2021-04-05 22:41:39','技术部'),(7,'王继红',0,13513534534,38.0,'否','与新冠肺炎有关的其他症状，如流涕，咽痛，肌痛，腹泻等','','2021-04-06 13:39:38','客服部'),(8,'刘小姐',1,231123123,23.0,'是','呼吸困难','','2021-04-06 15:34:42','后勤部'),(9,'111',1,111111111,11.0,'111','正常','11','2021-04-10 16:03:01','研发部'),(10,'刘渲',1,13514124567,37.0,'否','正常','','2021-04-15 14:29:15','后勤部'),(11,'王佳',0,13512314534,37.5,'否','正常','','2021-04-15 14:42:55','人力资源部'),(12,'刘腾键',1,13512365456,36.5,'否','乏力','','2021-04-15 14:46:49','技术部');

/*Table structure for table `emp_iden` */

DROP TABLE IF EXISTS `emp_iden`;

CREATE TABLE `emp_iden` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `sex` int(2) DEFAULT NULL,
  `idcard` varchar(20) DEFAULT NULL,
  `idate` date DEFAULT NULL,
  `place` varchar(100) DEFAULT NULL,
  `phonenum` bigint(100) DEFAULT NULL,
  `register` datetime DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `depart` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `emp_iden_ibfk_1` (`depart`),
  CONSTRAINT `emp_iden_ibfk_1` FOREIGN KEY (`depart`) REFERENCES `department` (`name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `emp_iden` */

insert  into `emp_iden`(`id`,`name`,`sex`,`idcard`,`idate`,`place`,`phonenum`,`register`,`status`,`depart`) values (1,'李先生',1,'440524196002152100','2020-11-13','广州市第一附属医院',13457896457,'2020-11-14 15:31:44','确诊','财务部'),(2,'蔡二思',1,'440634199004050312','2021-03-22','深圳市福田区第一医院',NULL,'2021-03-03 11:33:31','确诊','财务部'),(3,'王金枝',0,NULL,'2021-02-01','深圳市福田区第一医院',NULL,NULL,'疑似','后勤部'),(4,'季王红',0,'440578199505150547','2021-03-02','佛山市三水人民医院',13411234457,NULL,'治愈',NULL),(5,'李王思',1,'440578199902150351','2021-01-07','佛山市三水人民医院',13453456785,'2021-04-06 16:05:11','疑似','人力资源部'),(6,'王二会',1,'440582198005040800','2021-02-19','深圳市中心医院',13457891231,'2020-04-09 16:22:26','疑似','后勤部'),(7,'于雪师',1,'440578198905213551','2020-12-12','深圳市中心医院',1581456785,'2021-04-06 16:05:11','死亡','人力资源部'),(10,'阿斯顿',0,NULL,'2021-04-01','汕头市李嘉诚医院',13531342457,'2021-04-02 14:49:15','治愈','财务部'),(11,'士大夫',0,'34124','2021-03-31','广州市暨南大学第一附属医院',13411213257,'2021-04-02 14:49:32','死亡','客服部'),(12,'吴开师',1,'440578199807050321','2021-03-18','佛山市三水人民医院',13412823457,'2021-04-06 16:05:11','疑似','人力资源部');

/*Table structure for table `emp_is` */

DROP TABLE IF EXISTS `emp_is`;

CREATE TABLE `emp_is` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `sex` int(3) DEFAULT NULL,
  `phone` bigint(20) DEFAULT NULL,
  `temp` float(10,2) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `place` varchar(100) DEFAULT NULL,
  `begin` datetime DEFAULT NULL,
  `end` datetime DEFAULT NULL,
  `leaved` varchar(100) DEFAULT NULL,
  `arrived` varchar(100) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `depart` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `dep` (`depart`),
  CONSTRAINT `dep` FOREIGN KEY (`depart`) REFERENCES `department` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `emp_is` */

insert  into `emp_is`(`id`,`name`,`sex`,`phone`,`temp`,`type`,`place`,`begin`,`end`,`leaved`,`arrived`,`content`,`depart`) values (1,'黎香湖',0,12341231231,35.00,'酒店隔离','广州市广州南站如家酒店','2021-04-06 00:00:00','2021-04-20 00:00:00','广东汕头','广东东莞',NULL,'人力资源部'),(2,'王老二',1,13545479653,38.50,'酒店集中隔离','广州市火车站快捷酒店','2021-04-14 00:00:00','2021-04-28 00:00:00','广东汕头','广东东莞','','后勤部'),(3,'蔡司',1,13452342356,36.60,'酒店集中隔离','深圳市宝安区平和小区','2020-11-23 00:00:00','2020-12-07 00:00:00','重庆市','湖南长沙','','研发部'),(5,'蔡司',1,13452342356,35.60,'居家隔离','深圳市宝安区平和小区','2021-01-09 00:00:00','2021-01-23 00:00:00','重庆市','湖南长沙','','研发部');

/*Table structure for table `material_manage` */

DROP TABLE IF EXISTS `material_manage`;

CREATE TABLE `material_manage` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `isImp` int(11) DEFAULT NULL,
  `charge` varchar(255) DEFAULT NULL,
  `cnum` bigint(20) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=134 DEFAULT CHARSET=utf8;

/*Data for the table `material_manage` */

insert  into `material_manage`(`id`,`name`,`count`,`type`,`isImp`,`charge`,`cnum`,`updateTime`) values (113,'KN94口罩',150,'个',1,'孙迪',13415135777,'2021-03-31 13:54:36'),(114,'N95口罩',220,'个',1,'孙迪',13415135777,'2021-04-06 16:14:45'),(123,'防护服',30,'个',1,'王旭',15148796568,'2021-04-22 14:21:56'),(125,'酒精消毒棉片',200,'盒',1,'李建',13431357964,'2021-03-31 13:54:06'),(126,'抽纸纸巾',20,'箱',0,'李玉',13534654675,'2021-04-22 19:29:30'),(133,'防护眼罩',30,'个',1,'杨迪',123123123123,'2021-04-23 17:00:52');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `depart` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`depart`) values (1,'admin','e10adc3949ba59abbe56e057f20f883e','人力资源部'),(3,'root','e10adc3949ba59abbe56e057f20f883e','后勤部'),(12,'994091246','d7d7b53081e1e3ecbd28c30c34b4bcd3','技术部');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
