/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.1.49-community : Database - hr
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hr` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `hr`;

/*Table structure for table `attendance` */

DROP TABLE IF EXISTS `attendance`;

CREATE TABLE `attendance` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `employee_number` int(10) DEFAULT NULL,
  `day` date DEFAULT NULL,
  `time_type` enum('上午','下午','加班') DEFAULT NULL,
  `start_time` time DEFAULT NULL,
  `start_type` enum('正常','迟到','未签到') DEFAULT '未签到',
  `end_time` time DEFAULT NULL,
  `end_type` enum('正常','早退','未签到') DEFAULT '未签到',
  `work_type` enum('上班','请假') DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `attendance` */

insert  into `attendance`(`id`,`employee_number`,`day`,`time_type`,`start_time`,`start_type`,`end_time`,`end_type`,`work_type`,`notes`) values (1,1001,'2017-07-07','下午','17:01:33','迟到','17:25:15','早退',NULL,NULL),(2,1001,'2017-07-08','上午','08:53:43','正常','11:20:46','早退',NULL,NULL),(3,1001,'2017-07-08','下午','14:25:17','正常',NULL,'未签到',NULL,NULL),(4,1009,'2017-07-10','上午','10:29:35','迟到',NULL,'未签到',NULL,NULL),(5,1009,'2017-07-10','下午','16:42:01','迟到','16:42:25','早退',NULL,NULL),(6,1009,'2017-07-10','加班','19:31:46','正常',NULL,'未签到',NULL,NULL),(7,1009,'2017-07-11','上午','09:21:13','迟到',NULL,'未签到',NULL,NULL),(8,1009,'2017-07-12','上午','09:09:53','迟到',NULL,'未签到',NULL,NULL),(9,1009,'2017-07-12','下午','15:31:03','迟到',NULL,'未签到',NULL,NULL),(10,1001,'2017-07-12','下午','15:34:58','迟到',NULL,'未签到',NULL,NULL),(11,1007,'2017-07-12','下午','15:51:24','迟到',NULL,'未签到',NULL,NULL),(12,1008,'2017-07-12','下午','16:48:03','迟到',NULL,'未签到',NULL,NULL),(13,1009,'2017-07-12','加班','21:02:35','迟到',NULL,'未签到',NULL,NULL),(14,1010,'2017-07-12','加班','21:24:34','迟到',NULL,'未签到',NULL,NULL),(15,1001,'2019-06-09','加班','19:36:01','正常',NULL,'未签到',NULL,NULL);

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `department_number` int(10) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `manager` varchar(10) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `department` */

insert  into `department`(`id`,`department_number`,`name`,`manager`,`telephone`,`address`,`notes`) values (1,2001,'急诊科','王生安','0923-3456180','住院楼101',''),(2,2002,'骨科','贺易','0923-3456324','门诊楼304',''),(3,2003,'内分泌科  ','周卓浩','0923-3456909','门诊楼205',''),(4,2004,'神经内科 ','何刚名','0923-3456231','门诊楼109',''),(5,2005,'神经外科','王成文 ','0923-3456782','门诊楼102',''),(6,2006,'消化内科 ','严席华','0923-3456098','门诊楼201',''),(7,2007,'检验科','云介融 ','0923-3456143','医技楼104',''),(8,2008,'体检中心 ','范湖','0923-3456677','医技楼203',''),(9,2009,'放射科  ','吴敬序','0923-3456489','医技楼305',''),(10,2010,'护理部    ','凌月青','0923-3456210','住院楼109',''),(11,2011,'康复理疗科 ','丁频佟','0923-3456724','医技楼208',''),(12,2012,'药剂科','王缘','0923-3456423','医技楼302',''),(13,2013,'人事部','李烨','0923-2456123','办公楼108',''),(14,2014,'xx部门',NULL,'11111110000','四川','管理员');

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `employee_number` int(10) DEFAULT NULL,
  `name` varchar(10) DEFAULT NULL,
  `gender` enum('男','女') DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `telephone` varchar(15) DEFAULT '',
  `email` varchar(30) DEFAULT '',
  `address` varchar(50) DEFAULT NULL,
  `photo` varchar(50) DEFAULT '',
  `education` varchar(20) DEFAULT '',
  `department_number` int(10) DEFAULT NULL,
  `position_number` int(10) DEFAULT NULL,
  `in_time` date DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `notes` varchar(255) DEFAULT '',
  PRIMARY KEY (`id`),
  KEY `department_number` (`department_number`),
  KEY `title_number` (`position_number`),
  KEY `employee_number` (`employee_number`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `employee` */

insert  into `employee`(`id`,`employee_number`,`name`,`gender`,`birthday`,`telephone`,`email`,`address`,`photo`,`education`,`department_number`,`position_number`,`in_time`,`password`,`notes`) values (1,1001,'admin','男','1995-10-18','15678015439','564559079@qq.com','四川','','本科',2013,3009,'2017-02-22','25d55ad283aa400af464c76d713c07ad','管理员0'),(2,1007,'李烨','女','1996-03-04','18907327612','',NULL,'','',2001,3003,'2017-01-10','25d55ad283aa400af464c76d713c07ad',''),(3,1008,'刘旭亮','男','1995-06-06','13464238971','','','','',2007,3003,'2017-06-28','25d55ad283aa400af464c76d713c07ad',''),(4,1009,'张彤','男','1995-09-24','15810239904','','','','',2013,3009,'2017-02-06','25d55ad283aa400af464c76d713c07ad',''),(5,1010,'杨杰','男','1995-01-26','17871239756','','','','',2013,3010,'2017-05-12','25d55ad283aa400af464c76d713c07ad',''),(6,1011,'唐治涛','男','1995-03-29','18832013916','','河北沧州',NULL,'大学本科',2007,3003,'2017-07-05','25d55ad283aa400af464c76d713c07ad',''),(7,1012,'张璐','男','1997-03-04','18832050264','','河北张家口',NULL,'大学本科',2013,3009,'2017-07-05','25d55ad283aa400af464c76d713c07ad',''),(8,1013,'郭怀检','男','1996-04-16','11111110000','564559079@qq.com','四川','','本科',2013,3001,'2019-06-19','25d55ad283aa400af464c76d713c07ad','管理员4'),(14,1018,'郭怀检','男',NULL,'11111110000','1001','四川','','本科',2002,3001,'2019-06-19','25d55ad283aa400af464c76d713c07ad','管理员4');

/*Table structure for table `history` */

DROP TABLE IF EXISTS `history`;

CREATE TABLE `history` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `employee_number` int(10) DEFAULT NULL,
  `name` varchar(10) DEFAULT NULL,
  `gender` enum('男','女') DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `telephone` varchar(20) DEFAULT '',
  `email` varchar(30) DEFAULT '',
  `address` varchar(50) DEFAULT '',
  `photo` varchar(50) DEFAULT '',
  `education` varchar(20) DEFAULT '',
  `in_time` date DEFAULT NULL,
  `out_time` date DEFAULT NULL,
  `department_number` int(10) DEFAULT NULL,
  `position_number` int(10) DEFAULT NULL,
  `status` enum('离职','在职','退休') DEFAULT NULL,
  `home` varchar(100) DEFAULT '',
  `notes` varchar(255) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `history` */

insert  into `history`(`id`,`employee_number`,`name`,`gender`,`birthday`,`telephone`,`email`,`address`,`photo`,`education`,`in_time`,`out_time`,`department_number`,`position_number`,`status`,`home`,`notes`) values (1,1001,'admin','男','1995-10-18','15678015439','','','','','2017-02-22',NULL,2001,3002,'在职','',''),(2,1002,'王秀英','女','1992-03-08','15590678821','','','','本科','2011-04-29','2017-07-04',2011,3004,'离职','','管理员2'),(3,1003,'李强','男','1993-12-22','18929778634','','','','','2010-05-06','2017-07-05',2010,3007,'退休','',''),(4,1004,'刘洋','男','1991-07-26','13807987324','','','','本科','2009-12-23','2017-07-04',2009,3005,'退休','',''),(5,1005,'李敏','女','1991-01-03','13791826142','','','','','2010-03-29','2017-07-05',2008,3004,'退休','',''),(6,1006,'王伟 ','女','1990-06-12','13986207926','','','','','2010-10-12','2017-07-06',2012,3005,'离职','',''),(7,1007,'李烨','女','1996-03-04','18907327612','','','','本科','2017-01-10',NULL,2001,3003,'离职','',''),(8,1008,'刘旭亮','男','1995-06-00','13464238971','','','','','2017-06-28',NULL,2002,3001,'在职','',''),(9,1009,'张彤','男','1995-09-24','15810239904','','','','','2017-02-06',NULL,2002,3003,'在职','',''),(10,1010,'杨杰','男','1995-01-26','17871239756','','','','','2017-05-12',NULL,2003,3003,'在职','',''),(11,1011,'唐治涛','男','1995-03-29','18832013916','819564344@qq.com','河北沧州','','大学本科','2017-07-05',NULL,2010,3006,'在职','',''),(12,1012,'张璐','男','1997-03-11','18832050264','1215959210@qq.com','河北省张家口','','本科','2017-07-05',NULL,2009,3004,'在职','',''),(13,1013,'郭怀检','男','2019-06-20','11111110000','1001','四川','','本科','2019-06-19',NULL,2013,3001,'在职','','管理员2'),(14,1014,'郭怀检11','男','2019-06-06','11111110000','1001','四川','','本科','2019-06-19',NULL,2008,3005,'离职','','管理员2'),(20,1015,'1001','男','2019-06-23','11111110000','1001','四川','','本科','2019-06-19',NULL,2009,3002,'离职','','1212');

/*Table structure for table `lea` */

DROP TABLE IF EXISTS `lea`;

CREATE TABLE `lea` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `employee_number` int(10) DEFAULT NULL,
  `department_number` int(10) DEFAULT NULL,
  `start_time` date DEFAULT NULL,
  `end_time` date DEFAULT NULL,
  `days` varchar(10) DEFAULT NULL,
  `reason` varchar(100) DEFAULT NULL,
  `type` enum('事假','病假') DEFAULT NULL,
  `manager` varchar(10) DEFAULT NULL,
  `status` enum('已批准','未批准') DEFAULT '未批准',
  `notes` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `lea` */

insert  into `lea`(`id`,`employee_number`,`department_number`,`start_time`,`end_time`,`days`,`reason`,`type`,`manager`,`status`,`notes`) values (1,1007,2007,'2017-07-11','2017-07-12','1','家中有事','事假',NULL,'未批准',NULL),(2,1008,2007,'2017-07-10','2017-07-12','2','偶感风寒','病假',NULL,'已批准',NULL),(3,1011,2007,'2017-07-11','2017-07-11','1','回家看看','事假',NULL,'已批准',NULL),(7,1008,2007,'2017-07-14','2017-07-17','3','真的有点事','事假',NULL,'已批准',NULL),(8,1009,2013,'2017-07-05','2017-07-06','1','回家看看','事假',NULL,'已批准',NULL),(9,1012,2013,'2017-07-08','2017-07-08','1','摊上事了','事假',NULL,'未批准',NULL),(10,1012,2013,'2017-07-13','2017-07-14','1','真的有点事','事假',NULL,'已批准',NULL),(11,1001,NULL,'2019-06-10','2019-06-14','2','2222','病假',NULL,'未批准',NULL),(12,1001,NULL,'2019-06-19','2019-06-20','1','111111','事假',NULL,'未批准',NULL),(13,1001,NULL,'2019-06-20','2019-06-21','1','0000','事假',NULL,'未批准',NULL),(14,1001,NULL,'2019-06-21','2019-06-23','3','3333','事假',NULL,'未批准',NULL);

/*Table structure for table `move` */

DROP TABLE IF EXISTS `move`;

CREATE TABLE `move` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `employee_number` int(10) DEFAULT NULL,
  `before` int(10) DEFAULT NULL,
  `after` int(10) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `manager` varchar(10) DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `move` */

insert  into `move`(`id`,`employee_number`,`before`,`after`,`time`,`manager`,`notes`) values (1,1011,2010,2011,'2017-07-10 20:40:20','张彤',NULL),(3,1007,2001,2007,'2017-07-11 09:53:34','张彤',NULL),(4,1015,2011,2008,'2019-06-19 15:06:10','admin',NULL);

/*Table structure for table `overtime` */

DROP TABLE IF EXISTS `overtime`;

CREATE TABLE `overtime` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `department_number` int(10) DEFAULT NULL,
  `employee_number` int(10) DEFAULT NULL,
  `day` date DEFAULT NULL,
  `start_time` time DEFAULT NULL,
  `end_time` time DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

/*Data for the table `overtime` */

insert  into `overtime`(`id`,`department_number`,`employee_number`,`day`,`start_time`,`end_time`,`notes`) values (1,2007,1007,'2017-07-12',NULL,NULL,NULL),(2,2001,1008,'2017-07-12',NULL,NULL,NULL),(3,2013,1012,'2017-07-12',NULL,NULL,NULL),(4,2003,1010,'2017-07-12',NULL,NULL,NULL),(8,2011,1011,'2017-07-14',NULL,NULL,NULL),(9,2002,1008,'2019-06-12',NULL,NULL,NULL),(10,2002,1008,'2019-06-07',NULL,NULL,NULL),(11,2002,1001,'2016-10-12',NULL,NULL,NULL),(21,2013,1001,'2019-06-27',NULL,NULL,NULL);

/*Table structure for table `position` */

DROP TABLE IF EXISTS `position`;

CREATE TABLE `position` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `position_number` int(10) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `level` enum('部门主任','部门员工','人事部主任','人事部员工') DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `position_number` (`position_number`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `position` */

insert  into `position`(`id`,`position_number`,`name`,`level`,`notes`) values (1,3001,'主任医师','部门主任',''),(2,3002,'副主任医师','部门员工',''),(3,3003,'医师','部门员工',''),(4,3004,'主任技师','部门主任',''),(5,3005,'副主任技师','部门员工',''),(6,3006,'技师','部门员工',''),(7,3007,'护士长','部门主任',''),(8,3008,'护士','部门员工',''),(9,3009,'人事部主任','人事部主任',''),(10,3010,'人事部员工','人事部员工',''),(11,3011,'主任1','部门主任','管理员2');

/*Table structure for table `tab_menu` */

DROP TABLE IF EXISTS `tab_menu`;

CREATE TABLE `tab_menu` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `parent_id` int(10) unsigned DEFAULT NULL COMMENT '上级菜单id',
  `menu_type` varchar(1) NOT NULL COMMENT '菜单形式，0:空菜单，1:有连接菜单',
  `menu_name` varchar(100) NOT NULL COMMENT '菜单名称',
  `menu_url` varchar(255) DEFAULT NULL COMMENT '菜单调用url',
  `permis_id` bigint(20) unsigned DEFAULT NULL COMMENT '菜单与权限对应关系',
  `menu_order` int(10) unsigned NOT NULL COMMENT '菜单排序',
  `menu_flag` varchar(1) NOT NULL COMMENT '是否展现0：展现，1：关闭',
  `menu_icon` varchar(100) DEFAULT NULL COMMENT '菜单图标',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='菜单表';

/*Data for the table `tab_menu` */

insert  into `tab_menu`(`id`,`parent_id`,`menu_type`,`menu_name`,`menu_url`,`permis_id`,`menu_order`,`menu_flag`,`menu_icon`) values (1,0,'0','个人信息','#',NULL,1,'0','fa-newspaper-o'),(2,0,'0','员工','#',NULL,2,'0',NULL),(3,0,'0','部门','#',NULL,3,'0',NULL),(4,1,'1','查看个人信息','employee/information',NULL,4,'0',NULL),(5,1,'1','修改个人信息','employee/onseself/1/toUpdate.do',NULL,5,'0',NULL),(6,2,'0','员工管理','#',NULL,6,'0','fa-user-md'),(7,2,'0','考勤管理','#',NULL,7,'0','fa-calendar'),(8,2,'0','请假管理','#',NULL,8,'0','fa-bookmark'),(9,3,'0','部门管理','#',NULL,9,'0','fa-sitemap'),(10,6,'1','在职员工管理','employee/listPage.do?pageNo=1',24,10,'0',NULL),(11,6,'1','离休人员管理','history/retirelistPage.do?pageNo=1',20,11,'0',NULL),(12,7,'1','考勤管理','attendance/list.do',19,12,'0',NULL),(13,7,'1','加班管理','overtime/listPage.do?pageNo=1',3,13,'0',NULL),(14,8,'1','未批准列表','leave/notlist.do',13,14,'0',NULL),(15,8,'1','已批准列表','leave/yeslist.do',14,15,'0',NULL),(16,8,'1','请假列表','leave/list.do',15,16,'0',NULL),(17,9,'1','部门管理','department/listPage.do?pageNo=1',1,17,'0',NULL),(18,9,'1','职称管理','position/listPage.do?pageNo=1',2,18,'0',NULL),(19,1,'1','申请请假','leave/toAdd.do',16,19,'0',NULL),(20,1,'1','查看请假记录','leave/oneself.do?pageNo=1',NULL,20,'0',NULL);

/*Table structure for table `tab_permis` */

DROP TABLE IF EXISTS `tab_permis`;

CREATE TABLE `tab_permis` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(100) NOT NULL COMMENT '权限名称',
  `permission_sign` varchar(255) NOT NULL COMMENT '权限标识,程序中判断使用,如"user:create"',
  `permission_desc` varchar(255) DEFAULT NULL COMMENT '权限描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='权限表';

/*Data for the table `tab_permis` */

insert  into `tab_permis`(`id`,`permission_name`,`permission_sign`,`permission_desc`) values (1,'部门管理','depart:query','部门管理查询'),(2,'职称管理','position:query','职称管理查询'),(3,'加班管理','overtime:list','加班管理查询'),(4,'部门管理','depart:del','部门管理删除'),(6,'部门管理','depart:add:show','部门新增展现'),(8,'部门管理','depart:add:submit','部门新增提交'),(10,'部门管理','depart:update:show','部门更新展现'),(12,'部门管理','depart:update:submit','部门更新提交'),(13,'请假管理','leave:nolist','请假管理未批准列表'),(14,'请假管理','leave:yeslist','请假管理已批准列表'),(15,'请假管理','leave:list','请假管理列表'),(16,'请假管理','leave:add','请假管理新增'),(17,'请假管理','leave:new','请假管理新增提交'),(18,'请假管理','leave:update','请假管理更新'),(19,'考勤管理','attendance:list','考勤管理列表'),(20,'离退休管理','history:list','离退休管理列表'),(21,'离退休管理','history:detail','离退休管理明细'),(22,'离退休管理','history:update','离退休管理更新'),(23,'离退休管理','history:update:submit','离退休管理更新提交'),(24,'员工档案管理','employee:list','员工档案管理列表'),(25,'员工调动记录','move:list','员工调动记录列表'),(26,'加班管理','overtime:list','员工加班记录列表'),(27,'加班管理','overtime:add:show','员工加班新增界面'),(28,'加班管理','overtime:add:submit','员工加班新增提交'),(29,'加班管理','overtime:update:show','员工加班更新界面'),(30,'加班管理','overtime:update:submit','员工加班更新提交'),(31,'加班管理','overtime:del','员工加班删除');

/*Table structure for table `tab_role` */

DROP TABLE IF EXISTS `tab_role`;

CREATE TABLE `tab_role` (
  `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `role_sign` varchar(100) DEFAULT NULL COMMENT '角色标识，如:admin',
  `role_desc` varchar(255) DEFAULT NULL COMMENT '角色说明',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='角色表';

/*Data for the table `tab_role` */

insert  into `tab_role`(`id`,`role_name`,`role_sign`,`role_desc`) values (1,'管理员角色','ADMIN','管理员角色'),(2,'工程师角色','EMPLOYEE','工程师角色');

/*Table structure for table `tab_role_permis` */

DROP TABLE IF EXISTS `tab_role_permis`;

CREATE TABLE `tab_role_permis` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) unsigned NOT NULL COMMENT '角色id',
  `permis_id` bigint(20) unsigned NOT NULL COMMENT '权限id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='角色权限表';

/*Data for the table `tab_role_permis` */

insert  into `tab_role_permis`(`id`,`role_id`,`permis_id`) values (1,1,1),(2,1,2),(4,1,4),(6,1,6),(8,1,8),(10,1,10),(12,1,12),(14,1,3),(16,1,13),(18,1,14),(20,1,15),(22,1,16),(24,1,17),(26,1,18),(28,1,19),(30,1,20),(32,1,21),(34,1,22),(36,1,23),(38,1,24),(40,1,25),(42,1,26),(44,1,27),(46,1,28),(48,1,29),(50,1,30),(51,2,16),(52,1,31);

/*Table structure for table `tab_user_permis` */

DROP TABLE IF EXISTS `tab_user_permis`;

CREATE TABLE `tab_user_permis` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_code` varchar(100) NOT NULL COMMENT '用户code',
  `permis_id` bigint(20) unsigned NOT NULL COMMENT '权限id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户权限表';

/*Data for the table `tab_user_permis` */

insert  into `tab_user_permis`(`id`,`user_code`,`permis_id`) values (1,'1011',3),(2,'1001',2);

/*Table structure for table `tab_user_role` */

DROP TABLE IF EXISTS `tab_user_role`;

CREATE TABLE `tab_user_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_code` varchar(10) NOT NULL COMMENT '用户code值',
  `role_id` bigint(20) unsigned NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户角色表';

/*Data for the table `tab_user_role` */

insert  into `tab_user_role`(`id`,`user_code`,`role_id`) values (1,'1011',2),(2,'1001',1),(3,'1007',2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
