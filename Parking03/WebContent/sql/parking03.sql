/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.7.25-log : Database - parking03
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`parking03` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `parking03`;

/*Table structure for table `t_admin` */

DROP TABLE IF EXISTS `t_admin`;

CREATE TABLE `t_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) DEFAULT NULL,
  `userPassword` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_admin` */

insert  into `t_admin`(`id`,`userName`,`userPassword`) values (1,'admin','admin'),(2,'arrayli','123456'),(3,'lisi','123456');

/*Table structure for table `t_che` */

DROP TABLE IF EXISTS `t_che`;

CREATE TABLE `t_che` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hao` varchar(255) DEFAULT NULL,
  `leixing` varchar(255) DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_che` */

insert  into `t_che`(`id`,`hao`,`leixing`,`picture`,`info`,`uid`) values (1,'沪B HJ521','(广汽本田)INSPIRE','/upload/1558247998493.JPG','这是B621最牛逼的人',2),(2,'京A 00001','劳斯莱斯幻影','/upload/1558266716171.JPG','这是一个大客户',3),(3,'陕A 00001','奥迪Q5','/upload/1558266791117.jpg','B621扛把子',1),(4,'浙A 00008','兰博基尼','/upload/1558428424699.JPG','这是一个大客户',4);

/*Table structure for table `t_chefei` */

DROP TABLE IF EXISTS `t_chefei`;

CREATE TABLE `t_chefei` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hao` varchar(255) DEFAULT NULL,
  `jdate` varchar(255) DEFAULT NULL,
  `ldate` varchar(255) DEFAULT NULL,
  `cost` int(11) DEFAULT NULL,
  `adate` varchar(255) DEFAULT NULL,
  `hours` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

/*Data for the table `t_chefei` */

insert  into `t_chefei`(`id`,`hao`,`jdate`,`ldate`,`cost`,`adate`,`hours`,`price`) values (1,'京A 00001','2019-01-05 10:36:50','2019-01-05 14:36:50',10,'2019-01-05 14:36:50',4,10),(2,'京A 88888','2019-01-10 10:36:50','2019-01-10 13:36:50',8,'2019-01-10 13:36:50',3,8),(3,'沪A 13456','2019-01-14 10:36:50','2019-01-14 14:36:50',10,'2019-01-14 14:36:50',4,10),(4,'浙A 00008','2019-01-18 10:36:50','2019-01-18 13:36:50',6,'2019-01-18 13:36:50',3,6),(5,'浙G TY894','2019-01-25 10:36:50','2019-01-25 12:36:50',5,'2019-01-25 12:36:50',2,5),(6,'陕A 00001','2019-02-01 10:36:50','2019-02-01 14:36:50',10,'2019-01-05 14:36:50',4,10),(7,'陕D VX421','2019-02-02 10:36:50','2019-02-02 13:36:50',7,'2019-01-10 13:36:50',3,7),(8,'京C 56234','2019-02-03 10:36:50','2019-02-03 14:36:50',8,'2019-01-14 14:36:50',4,8),(9,'沪D KL456','2019-02-15 10:36:50','2019-02-15 13:36:50',4,'2019-01-18 13:36:50',3,4),(10,'陕A 00001','2019-03-01 10:36:50','2019-03-01 14:36:50',10,'2019-01-05 14:36:50',4,10),(11,'陕D VX421','2019-03-02 10:36:50','2019-03-02 13:36:50',7,'2019-01-10 13:36:50',3,7),(12,'京C 56234','2019-03-03 10:36:50','2019-03-03 14:36:50',8,'2019-01-14 14:36:50',4,8),(13,'沪D KL456','2019-03-15 10:36:50','2019-03-15 13:36:50',4,'2019-01-18 13:36:50',3,4),(14,'浙G TY894','2019-03-15 10:36:50','2019-03-15 13:36:50',4,'2019-01-18 13:36:50',3,4),(15,'陕A 00001','2019-04-01 10:36:50','2019-04-01 14:36:50',10,'2019-01-05 14:36:50',4,10),(16,'陕D VX421','2019-04-02 10:36:50','2019-04-02 13:36:50',7,'2019-01-10 13:36:50',3,7),(17,'京C 56234','2019-04-03 10:36:50','2019-04-03 14:36:50',8,'2019-01-14 14:36:50',4,8),(18,'沪D KL456','2019-04-15 10:36:50','2019-04-15 13:36:50',4,'2019-01-18 13:36:50',3,4),(19,'浙G TY894','2019-04-15 10:36:50','2019-04-15 13:36:50',4,'2019-01-18 13:36:50',3,4),(20,'陕B XY234','2019-04-01 10:36:50','2019-04-01 14:36:50',10,'2019-01-05 14:36:50',4,10),(21,'沪R NB781','2019-04-02 10:36:50','2019-04-02 13:36:50',7,'2019-01-10 13:36:50',3,7),(22,'浙L 84564','2019-04-03 10:36:50','2019-04-03 14:36:50',8,'2019-01-14 14:36:50',4,8),(23,'陕H QW123','2019-04-15 10:36:50','2019-04-15 13:36:50',4,'2019-01-18 13:36:50',3,4),(24,'陕V 41562','2019-04-20 10:36:50','2019-04-20 13:36:50',4,'2019-01-18 13:36:50',3,4),(25,'陕A 00001','2019-05-19 19:53:19','2019-05-21 16:28:01',50,'2019-05-21 16:28:07',45,25);

/*Table structure for table `t_chewei` */

DROP TABLE IF EXISTS `t_chewei`;

CREATE TABLE `t_chewei` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hao` varchar(255) DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  `quyu` varchar(255) DEFAULT NULL,
  `chepai` varchar(255) DEFAULT NULL,
  `adate` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `t_chewei` */

insert  into `t_chewei`(`id`,`hao`,`info`,`quyu`,`chepai`,`adate`) values (1,'A001','A001','A区','京A 00001','2019-05-19 19:52:22'),(2,'A002','A002','A区',NULL,NULL),(3,'A003','A003','B区','浙A 00008','2019-05-21 16:47:31'),(4,'B001','B001','C区',NULL,NULL),(5,'B002','B002','B区',NULL,NULL),(6,'B003','B003','C区',NULL,NULL),(7,'A004','A004','C区',NULL,NULL),(8,'A005','A005','B区',NULL,NULL),(9,'B005','B005','A区',NULL,NULL),(10,'B006','B006','C区',NULL,NULL);

/*Table structure for table `t_parkingtype` */

DROP TABLE IF EXISTS `t_parkingtype`;

CREATE TABLE `t_parkingtype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_parkingtype` */

/*Table structure for table `t_price` */

DROP TABLE IF EXISTS `t_price`;

CREATE TABLE `t_price` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `price` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `t_price` */

insert  into `t_price`(`id`,`price`,`type`,`info`) values (1,'5','A','(白天停车6:00-18:000) 2小时（含2小时）'),(2,'10','B','(白天停车6:00-18:000) 2小时以上至4小时以内（含4小时）'),(3,'15','C','(白天停车6:00-18:000) 4小时以上'),(4,'8','D','(夜晚停车) 4小时以内（含4小时）'),(5,'10','E','(夜晚停车) 4小时以上'),(6,'20','F','(昼夜交替停车) 12小时以内(包含12小时)'),(7,'25','G','(24小时停车) 24小时停放的车辆合计收费'),(8,'300','H','(长期固定车位停车) 长期固定停放的车辆，按每月收费，每月收费');

/*Table structure for table `t_userinfo` */

DROP TABLE IF EXISTS `t_userinfo`;

CREATE TABLE `t_userinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `age` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `money` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_userinfo` */

insert  into `t_userinfo`(`id`,`username`,`pwd`,`age`,`tel`,`money`,`type`) values (1,'arrayli','123456','22','18629550754',950,'vip'),(2,'zhangsan','123456','23','18629550754',980,'vip'),(3,'lisi','123456','23','18629550754',500,'ordinary'),(4,'zhaoliu','12345678','23','18629550754',0,'vip');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
