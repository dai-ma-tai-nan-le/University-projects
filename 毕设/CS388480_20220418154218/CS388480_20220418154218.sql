DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`(
	   `student_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生ID',
`student_number` varchar(64) NOT NULL UNIQUE comment '学号',
`full_name` varchar(64) comment '姓名',
`gender` varchar(64) comment '性别',
`grade` varchar(64) comment '年级',
`major` varchar(64) comment '专业',
`class_name` varchar(64) comment '班级名称',
`teacher_number` int(11) DEFAULT 0 comment '教师编号',
`examine_state` varchar(16) DEFAULT '已通过' NOT NULL comment '审核状态',
`recommend` int(11) DEFAULT '0' NOT NULL comment '智能推荐',
`user_id` int(11) DEFAULT '0' NOT NULL comment '用户ID',
`create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
 `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',

	   PRIMARY KEY (student_id)
	)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '学生';

DROP TABLE IF EXISTS `daily_plan`;
CREATE TABLE `daily_plan`(
	   `daily_plan_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '每日计划ID',
`student_user` int(11) DEFAULT 0 comment '学生用户',
`student_number` varchar(64) comment '学号',
`full_name` varchar(64) comment '姓名',
`date` date comment '日期',
`class_name` varchar(64) comment '班级名称',
`completion` varchar(64) comment '完成情况',
`self_scoring` varchar(64) comment '自我打分',
`teacher_number` int(11) DEFAULT 0 comment '教师编号',
`mission_today` text comment '今日任务',
`recommend` int(11) DEFAULT '0' NOT NULL comment '智能推荐',
`create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
 `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',

	   PRIMARY KEY (daily_plan_id)
	)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '每日计划';
insert into `daily_plan` values (1,0,'学号1','姓名1','2022-4-25','班级名称1','完成情况1','自我打分1',0,'今日任务1','0','2022-04-25 15:44:26','2022-04-25 15:44:26');
insert into `daily_plan` values (2,0,'学号2','姓名2','2022-4-25','班级名称2','完成情况2','自我打分2',0,'今日任务2','0','2022-04-25 15:44:26','2022-04-25 15:44:26');
insert into `daily_plan` values (3,0,'学号3','姓名3','2022-4-25','班级名称3','完成情况3','自我打分3',0,'今日任务3','0','2022-04-25 15:44:26','2022-04-25 15:44:26');
insert into `daily_plan` values (4,0,'学号4','姓名4','2022-4-25','班级名称4','完成情况4','自我打分4',0,'今日任务4','0','2022-04-25 15:44:26','2022-04-25 15:44:26');
insert into `daily_plan` values (5,0,'学号5','姓名5','2022-4-25','班级名称5','完成情况5','自我打分5',0,'今日任务5','0','2022-04-25 15:44:26','2022-04-25 15:44:26');
insert into `daily_plan` values (6,0,'学号6','姓名6','2022-4-25','班级名称6','完成情况6','自我打分6',0,'今日任务6','0','2022-04-25 15:44:26','2022-04-25 15:44:26');
insert into `daily_plan` values (7,0,'学号7','姓名7','2022-4-25','班级名称7','完成情况7','自我打分7',0,'今日任务7','0','2022-04-25 15:44:26','2022-04-25 15:44:26');
insert into `daily_plan` values (8,0,'学号8','姓名8','2022-4-25','班级名称8','完成情况8','自我打分8',0,'今日任务8','0','2022-04-25 15:44:26','2022-04-25 15:44:26');

DROP TABLE IF EXISTS `weekly_plan`;
CREATE TABLE `weekly_plan`(
	   `weekly_plan_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '每周计划ID',
`student_user` int(11) DEFAULT 0 comment '学生用户',
`student_number` varchar(64) comment '学号',
`full_name` varchar(64) comment '姓名',
`zhou_hao` varchar(64) comment '周号',
`class_name` varchar(64) comment '班级名称',
`start_time` datetime comment '开始时间',
`end_time` datetime comment '结束时间',
`completion` varchar(64) comment '完成情况',
`self_scoring` varchar(64) comment '自我打分',
`teacher_number` int(11) DEFAULT 0 comment '教师编号',
`tasks_this_week` text comment '本周任务',
`recommend` int(11) DEFAULT '0' NOT NULL comment '智能推荐',
`create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
 `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',

	   PRIMARY KEY (weekly_plan_id)
	)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '每周计划';
insert into `weekly_plan` values (1,0,'学号1','姓名1','周号1','班级名称1','2022-4-25 15:44:26','2022-4-25 15:44:26','完成情况1','自我打分1',0,'本周任务1','0','2022-04-25 15:44:26','2022-04-25 15:44:26');
insert into `weekly_plan` values (2,0,'学号2','姓名2','周号2','班级名称2','2022-4-25 15:44:26','2022-4-25 15:44:26','完成情况2','自我打分2',0,'本周任务2','0','2022-04-25 15:44:26','2022-04-25 15:44:26');
insert into `weekly_plan` values (3,0,'学号3','姓名3','周号3','班级名称3','2022-4-25 15:44:26','2022-4-25 15:44:26','完成情况3','自我打分3',0,'本周任务3','0','2022-04-25 15:44:26','2022-04-25 15:44:26');
insert into `weekly_plan` values (4,0,'学号4','姓名4','周号4','班级名称4','2022-4-25 15:44:26','2022-4-25 15:44:26','完成情况4','自我打分4',0,'本周任务4','0','2022-04-25 15:44:26','2022-04-25 15:44:26');
insert into `weekly_plan` values (5,0,'学号5','姓名5','周号5','班级名称5','2022-4-25 15:44:26','2022-4-25 15:44:26','完成情况5','自我打分5',0,'本周任务5','0','2022-04-25 15:44:26','2022-04-25 15:44:26');
insert into `weekly_plan` values (6,0,'学号6','姓名6','周号6','班级名称6','2022-4-25 15:44:26','2022-4-25 15:44:26','完成情况6','自我打分6',0,'本周任务6','0','2022-04-25 15:44:26','2022-04-25 15:44:26');
insert into `weekly_plan` values (7,0,'学号7','姓名7','周号7','班级名称7','2022-4-25 15:44:26','2022-4-25 15:44:26','完成情况7','自我打分7',0,'本周任务7','0','2022-04-25 15:44:26','2022-04-25 15:44:26');
insert into `weekly_plan` values (8,0,'学号8','姓名8','周号8','班级名称8','2022-4-25 15:44:26','2022-4-25 15:44:26','完成情况8','自我打分8',0,'本周任务8','0','2022-04-25 15:44:26','2022-04-25 15:44:26');

DROP TABLE IF EXISTS `summary_of_experience`;
CREATE TABLE `summary_of_experience`(
	   `summary_of_experience_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '心得总结ID',
`student_user` int(11) DEFAULT 0 comment '学生用户',
`student_number` varchar(64) comment '学号',
`full_name` varchar(64) comment '姓名',
`class_name` varchar(64) comment '班级名称',
`zhou_hao` varchar(64) comment '周号',
`summary_of_this_week` longtext comment '本周总结',
`recommend` int(11) DEFAULT '0' NOT NULL comment '智能推荐',
`create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
 `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',

	   PRIMARY KEY (summary_of_experience_id)
	)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '心得总结';
insert into `summary_of_experience` values (1,0,'学号1','姓名1','班级名称1','周号1','此处可上传文字、图片、视频、超链接、表格等内容区1','0','2022-04-25 15:44:26','2022-04-25 15:44:26');
insert into `summary_of_experience` values (2,0,'学号2','姓名2','班级名称2','周号2','此处可上传文字、图片、视频、超链接、表格等内容区2','0','2022-04-25 15:44:26','2022-04-25 15:44:26');
insert into `summary_of_experience` values (3,0,'学号3','姓名3','班级名称3','周号3','此处可上传文字、图片、视频、超链接、表格等内容区3','0','2022-04-25 15:44:26','2022-04-25 15:44:26');
insert into `summary_of_experience` values (4,0,'学号4','姓名4','班级名称4','周号4','此处可上传文字、图片、视频、超链接、表格等内容区4','0','2022-04-25 15:44:26','2022-04-25 15:44:26');
insert into `summary_of_experience` values (5,0,'学号5','姓名5','班级名称5','周号5','此处可上传文字、图片、视频、超链接、表格等内容区5','0','2022-04-25 15:44:26','2022-04-25 15:44:26');
insert into `summary_of_experience` values (6,0,'学号6','姓名6','班级名称6','周号6','此处可上传文字、图片、视频、超链接、表格等内容区6','0','2022-04-25 15:44:26','2022-04-25 15:44:26');
insert into `summary_of_experience` values (7,0,'学号7','姓名7','班级名称7','周号7','此处可上传文字、图片、视频、超链接、表格等内容区7','0','2022-04-25 15:44:26','2022-04-25 15:44:26');
insert into `summary_of_experience` values (8,0,'学号8','姓名8','班级名称8','周号8','此处可上传文字、图片、视频、超链接、表格等内容区8','0','2022-04-25 15:44:26','2022-04-25 15:44:26');

DROP TABLE IF EXISTS `relax_the_world`;
CREATE TABLE `relax_the_world`(
	   `relax_the_world_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '放松天地ID',
`title` varchar(64) comment '标题',
`type` varchar(64) comment '类型',
`teacher_number` int(11) DEFAULT 0 comment '教师编号',
`release_time` date comment '发布时间',
`content` longtext comment '内容',
`recommend` int(11) DEFAULT '0' NOT NULL comment '智能推荐',
`create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
 `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',

	   PRIMARY KEY (relax_the_world_id)
	)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '放松天地';
insert into `relax_the_world` values (1,'标题1','类型1',0,'2022-4-25','此处可上传文字、图片、视频、超链接、表格等内容区1','0','2022-04-25 15:44:26','2022-04-25 15:44:26');
insert into `relax_the_world` values (2,'标题2','类型2',0,'2022-4-25','此处可上传文字、图片、视频、超链接、表格等内容区2','0','2022-04-25 15:44:26','2022-04-25 15:44:26');
insert into `relax_the_world` values (3,'标题3','类型3',0,'2022-4-25','此处可上传文字、图片、视频、超链接、表格等内容区3','0','2022-04-25 15:44:26','2022-04-25 15:44:26');
insert into `relax_the_world` values (4,'标题4','类型4',0,'2022-4-25','此处可上传文字、图片、视频、超链接、表格等内容区4','0','2022-04-25 15:44:26','2022-04-25 15:44:26');
insert into `relax_the_world` values (5,'标题5','类型5',0,'2022-4-25','此处可上传文字、图片、视频、超链接、表格等内容区5','0','2022-04-25 15:44:26','2022-04-25 15:44:26');
insert into `relax_the_world` values (6,'标题6','类型6',0,'2022-4-25','此处可上传文字、图片、视频、超链接、表格等内容区6','0','2022-04-25 15:44:26','2022-04-25 15:44:26');
insert into `relax_the_world` values (7,'标题7','类型7',0,'2022-4-25','此处可上传文字、图片、视频、超链接、表格等内容区7','0','2022-04-25 15:44:26','2022-04-25 15:44:26');
insert into `relax_the_world` values (8,'标题8','类型8',0,'2022-4-25','此处可上传文字、图片、视频、超链接、表格等内容区8','0','2022-04-25 15:44:26','2022-04-25 15:44:26');

DROP TABLE IF EXISTS `student_information`;
CREATE TABLE `student_information`(
	   `student_information_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生信息ID',
`class_number` varchar(64) comment '班级号',
`student_number` varchar(64) comment '学号',
`student_name` varchar(64) comment '学生姓名',
`telephone` varchar(16) comment '电话',
`major` varchar(64) comment '专业',
`teacher_number` int(11) DEFAULT 0 comment '教师编号',
`recommend` int(11) DEFAULT '0' NOT NULL comment '智能推荐',
`create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
 `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',

	   PRIMARY KEY (student_information_id)
	)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '学生信息';
insert into `student_information` values (1,'班级号1','学号1','学生姓名1','18945782351','专业1',0,'0','2022-04-25 15:44:26','2022-04-25 15:44:26');
insert into `student_information` values (2,'班级号2','学号2','学生姓名2','18945782352','专业2',0,'0','2022-04-25 15:44:26','2022-04-25 15:44:26');
insert into `student_information` values (3,'班级号3','学号3','学生姓名3','18945782353','专业3',0,'0','2022-04-25 15:44:26','2022-04-25 15:44:26');
insert into `student_information` values (4,'班级号4','学号4','学生姓名4','18945782354','专业4',0,'0','2022-04-25 15:44:26','2022-04-25 15:44:26');
insert into `student_information` values (5,'班级号5','学号5','学生姓名5','18945782355','专业5',0,'0','2022-04-25 15:44:26','2022-04-25 15:44:26');
insert into `student_information` values (6,'班级号6','学号6','学生姓名6','18945782356','专业6',0,'0','2022-04-25 15:44:26','2022-04-25 15:44:26');
insert into `student_information` values (7,'班级号7','学号7','学生姓名7','18945782357','专业7',0,'0','2022-04-25 15:44:26','2022-04-25 15:44:26');
insert into `student_information` values (8,'班级号8','学号8','学生姓名8','18945782358','专业8',0,'0','2022-04-25 15:44:26','2022-04-25 15:44:26');

DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`(
	   `teacher_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '教师ID',
`teacher_number` varchar(64) NOT NULL UNIQUE comment '教师编号',
`teacher_name` varchar(64) comment '教师姓名',
`gender` varchar(64) comment '性别',
`courses_taught` varchar(64) comment '所教课程',
`class_name` text comment '班级名称',
`examine_state` varchar(16) DEFAULT '已通过' NOT NULL comment '审核状态',
`recommend` int(11) DEFAULT '0' NOT NULL comment '智能推荐',
`user_id` int(11) DEFAULT '0' NOT NULL comment '用户ID',
`create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
 `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',

	   PRIMARY KEY (teacher_id)
	)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '教师';

DROP TABLE IF EXISTS `next_day_plan`;
CREATE TABLE `next_day_plan`(
	   `next_day_plan_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '次日计划ID',
`student_user` int(11) DEFAULT 0 comment '学生用户',
`student_number` varchar(64) comment '学号',
`full_name` varchar(64) comment '姓名',
`date` date comment '日期',
`class_name` varchar(64) comment '班级名称',
`completion` varchar(64) comment '完成情况',
`self_scoring` varchar(64) comment '自我打分',
`teacher_number` int(11) DEFAULT 0 comment '教师编号',
`next_day_task` text comment '次日任务',
`recommend` int(11) DEFAULT '0' NOT NULL comment '智能推荐',
`create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
 `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',

	   PRIMARY KEY (next_day_plan_id)
	)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '次日计划';
insert into `next_day_plan` values (1,0,'学号1','姓名1','2022-4-25','班级名称1','完成情况1','自我打分1',0,'次日任务1','0','2022-04-25 15:44:26','2022-04-25 15:44:26');
insert into `next_day_plan` values (2,0,'学号2','姓名2','2022-4-25','班级名称2','完成情况2','自我打分2',0,'次日任务2','0','2022-04-25 15:44:26','2022-04-25 15:44:26');
insert into `next_day_plan` values (3,0,'学号3','姓名3','2022-4-25','班级名称3','完成情况3','自我打分3',0,'次日任务3','0','2022-04-25 15:44:26','2022-04-25 15:44:26');
insert into `next_day_plan` values (4,0,'学号4','姓名4','2022-4-25','班级名称4','完成情况4','自我打分4',0,'次日任务4','0','2022-04-25 15:44:26','2022-04-25 15:44:26');
insert into `next_day_plan` values (5,0,'学号5','姓名5','2022-4-25','班级名称5','完成情况5','自我打分5',0,'次日任务5','0','2022-04-25 15:44:26','2022-04-25 15:44:26');
insert into `next_day_plan` values (6,0,'学号6','姓名6','2022-4-25','班级名称6','完成情况6','自我打分6',0,'次日任务6','0','2022-04-25 15:44:26','2022-04-25 15:44:26');
insert into `next_day_plan` values (7,0,'学号7','姓名7','2022-4-25','班级名称7','完成情况7','自我打分7',0,'次日任务7','0','2022-04-25 15:44:26','2022-04-25 15:44:26');
insert into `next_day_plan` values (8,0,'学号8','姓名8','2022-4-25','班级名称8','完成情况8','自我打分8',0,'次日任务8','0','2022-04-25 15:44:26','2022-04-25 15:44:26');

DROP TABLE IF EXISTS `access_token`;
CREATE TABLE `access_token` (
  `token_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '临时访问牌ID',
  `token` varchar(64) DEFAULT NULL COMMENT '临时访问牌',
  `info` text,
  `maxage` int(2) NOT NULL DEFAULT '2' COMMENT '最大寿命：默认2小时',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间：',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间：',
  `user_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '用户编号:',
  PRIMARY KEY (`token_id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='临时访问牌';
insert into `access_token` values ('57','5accf85cb6a7f06f0aa2968deadaec1b',null,'2',"2022-01-14 07:32:09.000 ","2022-01-14 07:32:09.000 ",'1');
insert into `access_token` values ('58','46ff1d4d07714f046ba07b34bffe0af9',null,'2',"2022-01-14 07:32:09.000 ","2022-01-14 07:32:09.000 ",'1');
insert into `access_token` values ('59','ed9d6cba9826fda1beafcd9326be7a86',null,'2',"2022-01-14 07:32:09.000 ","2022-01-14 07:32:09.000 ",'1');
insert into `access_token` values ('60','c99763c1833ea0785d9e2b81da3fd28f',null,'2',"2022-01-14 07:32:09.000 ","2022-01-14 07:32:09.000 ",'1');
insert into `access_token` values ('61','33fbfaccd6d1cb9143e4129bd919d4b0',null,'2',"2022-01-14 07:32:09.000 ","2022-01-14 07:32:09.000 ",'1');
insert into `access_token` values ('62','493e13da5f293ba67a56a0fe3e1fa6cf',null,'2',"2022-01-14 07:32:09.000 ","2022-01-14 07:32:09.000 ",'1');
insert into `access_token` values ('63','c4b48e9e2160db09c703041a8fee0a1f',null,'2',"2022-01-14 07:32:09.000 ","2022-01-14 07:32:09.000 ",'1');
insert into `access_token` values ('64','d13cdaefd3823c360c959a02a262f71d',null,'2',"2022-01-14 07:32:09.000 ","2022-01-14 07:32:09.000 ",'1');
insert into `access_token` values ('65','6c6ff426fd77ea5a2025ce5ed2e42c8a',null,'2',"2022-01-14 07:32:09.000 ","2022-01-14 07:32:09.000 ",'1');
insert into `access_token` values ('66','80930065a61ffcdd5cbb75f60932973c',null,'2',"2022-01-14 07:32:09.000 ","2022-01-14 07:32:09.000 ",'1');
insert into `access_token` values ('67','94114763cf2e3b020495d8a27096d4ef',null,'2',"2022-01-14 07:32:09.000 ","2022-01-14 07:32:09.000 ",'1');
insert into `access_token` values ('68','761052c551c97c9317bc3aa475c85b84',null,'2',"2022-01-14 07:32:09.000 ","2022-01-14 07:32:09.000 ",'1');
insert into `access_token` values ('69','7c44ef14131a0ba7c16aa16cef104065',null,'2',"2022-01-14 07:32:09.000 ","2022-01-14 07:32:09.000 ",'1');
insert into `access_token` values ('70','96380f3d9542c80d04bdade1cf7635a5',null,'2',"2022-01-14 07:32:09.000 ","2022-01-14 07:32:09.000 ",'1');
insert into `access_token` values ('71','bfdc7acfcbf5763fda81945b60961222',null,'2',"2022-01-14 07:32:09.000 ","2022-01-14 07:32:09.000 ",'1');
insert into `access_token` values ('72','170a598e51ae8ae2badde20a42fe171d',null,'2',"2022-01-14 07:32:09.000 ","2022-01-14 07:32:09.000 ",'1');
insert into `access_token` values ('73','c82c357488c75926a92d8a9608d4b367',null,'2',"2022-01-14 07:32:09.000 ","2022-01-14 07:32:09.000 ",'1');
insert into `access_token` values ('74','4d35290c023f407a820f37dbbb1ceb09',null,'2',"2022-01-14 07:32:09.000 ","2022-01-14 07:32:09.000 ",'1');
insert into `access_token` values ('75','8d19162776682b695c0f62f3c7a92fec',null,'2',"2022-01-14 07:32:09.000 ","2022-01-14 07:32:09.000 ",'1');
insert into `access_token` values ('76','a7ea2cdc9a2be179e19200e593ad5a69',null,'2',"2022-01-14 07:32:09.000 ","2022-01-14 07:32:09.000 ",'1');
insert into `access_token` values ('77','c79a554f9832adc01f19682c5d576bc4',null,'2',"2022-01-14 07:32:09.000 ","2022-01-14 07:32:09.000 ",'1');
insert into `access_token` values ('78','1c7d95001fa09951a679841c8100ad1f',null,'2',"2022-01-14 07:32:09.000 ","2022-01-14 07:32:09.000 ",'1');
insert into `access_token` values ('79','776da1bcdd01ddb3cbf0a37fa13fc5b0',null,'2',"2022-01-14 07:32:09.000 ","2022-01-14 07:32:09.000 ",'1');
insert into `access_token` values ('80','d336e88e57c329d0166931292c1fac41',null,'2',"2022-01-14 07:32:09.000 ","2022-01-14 07:32:09.000 ",'1');
insert into `access_token` values ('81','37a40f526a6c82fc6110b512802d35bf',null,'2',"2022-01-14 07:32:09.000 ","2022-01-14 07:32:09.000 ",'1');
insert into `access_token` values ('82','691ad331771f4109206d58aeee572371',null,'2',"2022-01-14 07:32:09.000 ","2022-01-14 07:32:09.000 ",'1');
insert into `access_token` values ('83','9942e458886219960d3344b4a6a6fbec',null,'2',"2022-01-14 07:32:09.000 ","2022-01-14 07:32:09.000 ",'1');
insert into `access_token` values ('84','e9939a8b7ccf9f548f0bbb5664981f96',null,'2',"2022-01-14 07:32:09.000 ","2022-01-14 07:32:09.000 ",'1');
insert into `access_token` values ('85','f5b27912060d1909bef61fab9d96faae',null,'2',"2022-01-14 07:32:09.000 ","2022-01-14 07:32:09.000 ",'1');
insert into `access_token` values ('86','7c5888682f1d449eb1b62f0054a79fbf',null,'2',"2022-01-14 07:32:09.000 ","2022-01-14 07:32:09.000 ",'1');
insert into `access_token` values ('87','00dfdc6ac21c4a9da80fd71c990764d1',null,'2',"2022-01-14 07:32:09.000 ","2022-01-14 07:32:09.000 ",'1');
insert into `access_token` values ('88','3cce592bc72840ab932ce96d85a194da',null,'2',"2022-01-14 07:32:09.000 ","2022-01-14 07:32:09.000 ",'1');
insert into `access_token` values ('89','43fdaa989a644ad683ef4b4d488e8629',null,'2',"2022-01-14 07:32:09.000 ","2022-01-14 07:32:09.000 ",'1');
insert into `access_token` values ('90','d6a3cecadacff0dbd6b43b25372cc2a2',null,'2',"2022-01-14 07:32:09.000 ","2022-01-14 07:32:09.000 ",'1');
insert into `access_token` values ('91','5570bc5b07b3589f4ef8553bd46eb0d1',null,'2',"2022-01-14 07:32:09.000 ","2022-01-14 07:32:09.000 ",'1');
insert into `access_token` values ('92','5570bc5b07b3589f4ef8553bd46eb0d1',null,'2',"2022-01-14 07:32:09.000 ","2022-01-14 07:32:09.000 ",'1');
insert into `access_token` values ('93','26c553bd2ee2ab6605d18dfd310d85f9',null,'2',"2022-01-14 07:32:09.000 ","2022-01-14 07:32:09.000 ",'1');
insert into `access_token` values ('94','3fd52f81236ed2c37ff91a6696d4e47a',null,'2',"2022-01-14 07:32:09.000 ","2022-01-14 07:32:09.000 ",'1');
insert into `access_token` values ('95','893332e9ee67d60d8312b3700c58a359',null,'2',"2022-01-14 07:32:09.000 ","2022-01-14 07:32:09.000 ",'1');
insert into `access_token` values ('96','b7844068ade535b2e517df4a40948703',null,'2',"2022-01-14 07:32:09.000 ","2022-01-14 07:32:09.000 ",'1');
insert into `access_token` values ('97','179b37a5e1893c3af6b946bd5a1c8625',null,'2',"2022-01-14 07:32:09.000 ","2022-01-14 07:32:09.000 ",'1');
insert into `access_token` values ('98','3a47b8a040a83ebbc9194cb255dc668c',null,'2',"2022-01-14 07:32:09.000 ","2022-01-14 07:32:09.000 ",'1');
insert into `access_token` values ('99','afa60196afb77dcc2b520ed13a817560',null,'2',"2022-01-14 07:32:09.000 ","2022-01-14 07:32:09.000 ",'1');
insert into `access_token` values ('100','7fc6d9b324f8c0a3a1784d04ef132692',null,'2',"2022-01-14 07:32:09.000 ","2022-01-14 07:32:09.000 ",'1');
DROP TABLE IF EXISTS `auth`;
CREATE TABLE `auth` (
  `auth_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '授权ID：',
  `user_group` varchar(64) DEFAULT NULL COMMENT '用户组：',
  `mod_name` varchar(64) DEFAULT NULL COMMENT '模块名：',
  `table_name` varchar(64) DEFAULT NULL COMMENT '表名：',
  `page_title` varchar(255) DEFAULT NULL COMMENT '页面标题：',
  `path` varchar(255) DEFAULT NULL COMMENT '路由路径：',
  `position` varchar(32) DEFAULT NULL COMMENT '位置：',
  `mode` varchar(32) NOT NULL DEFAULT '_blank' COMMENT '跳转方式：',
  `add` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '是否可增加：',
  `del` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '是否可删除：',
  `set` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '是否可修改：',
  `get` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '是否可查看：',
  `field_add` varchar(500) DEFAULT NULL COMMENT '添加字段：',
  `field_set` varchar(500) DEFAULT NULL COMMENT '修改字段：',
  `field_get` varchar(500) DEFAULT NULL COMMENT '查询字段：',
  `table_nav_name` varchar(255) DEFAULT NULL COMMENT '跨表导航名称：',
  `table_nav` varchar(255) DEFAULT NULL COMMENT '跨表导航：',
  `option` text COMMENT '配置：',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间：',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间：',
  PRIMARY KEY (`auth_id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='定制授权';
DROP TABLE IF EXISTS `upload`;
CREATE TABLE `upload` (
  `upload_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '上传ID',
  `name` varchar(64) DEFAULT NULL COMMENT '文件名',
  `path` varchar(255) DEFAULT NULL COMMENT '访问路径',
  `file` varchar(255) DEFAULT NULL COMMENT '文件路径',
  `display` varchar(255) DEFAULT NULL COMMENT '显示顺序',
  `father_id` int(11) DEFAULT '0' COMMENT '父级ID',
  `dir` varchar(255) DEFAULT NULL COMMENT '文件夹',
  `type` varchar(32) DEFAULT NULL COMMENT '文件类型',
  PRIMARY KEY (`upload_id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
insert into `upload` values ('1','movie.mp4','/upload/movie.mp4','',null,'0',null,'video');
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户ID：[0,8388607]用户获取其他与用户相关的数据',
  `state` smallint(1) unsigned NOT NULL DEFAULT '1' COMMENT '账户状态：[0,10](1可用|2异常|3已冻结|4已注销)',
  `user_group` varchar(32) DEFAULT NULL COMMENT '所在用户组：[0,32767]决定用户身份和权限',
  `login_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '上次登录时间：',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号码：[0,11]用户的手机号码，用于找回密码时或登录时',
  `phone_state` smallint(1) unsigned NOT NULL DEFAULT '0' COMMENT '手机认证：[0,1](0未认证|1审核中|2已认证)',
  `username` varchar(16) NOT NULL DEFAULT '' COMMENT '用户名：[0,16]用户登录时所用的账户名称',
  `nickname` varchar(16) DEFAULT '' COMMENT '昵称：[0,16]',
  `password` varchar(64) NOT NULL DEFAULT '' COMMENT '密码：[0,32]用户登录所需的密码，由6-16位数字或英文组成',
  `email` varchar(64) DEFAULT '' COMMENT '邮箱：[0,64]用户的邮箱，用于找回密码时或登录时',
  `email_state` smallint(1) unsigned NOT NULL DEFAULT '0' COMMENT '邮箱认证：[0,1](0未认证|1审核中|2已认证)',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像地址：[0,255]',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间：',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户账户：用于保存用户登录信息';
insert into `user` values ('1','1','管理员',"2022-04-19 07:32:09.000 ",null,'0','admin','admin','bfd59291e825b5f2bbf1eb76569f8fe7','','0','/api/upload/avatar.jpg',"2022-04-19 07:32:09.000 ");
DROP TABLE IF EXISTS `user_group`;
CREATE TABLE `user_group` (
  `group_id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户组ID：[0,8388607]',
  `display` smallint(4) unsigned NOT NULL DEFAULT '100' COMMENT '显示顺序：[0,1000]',
  `name` varchar(16) NOT NULL DEFAULT '' COMMENT '名称：[0,16]',
  `description` varchar(255) DEFAULT NULL COMMENT '描述：[0,255]描述该用户组的特点或权限范围',
  `source_table` varchar(255) DEFAULT NULL COMMENT '来源表：',
  `source_field` varchar(255) DEFAULT NULL COMMENT '来源字段：',
  `source_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '来源ID：',
  `register` smallint(1) unsigned DEFAULT '0' COMMENT '注册位置:',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间：',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间：',
  PRIMARY KEY (`group_id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户组：用于用户前端身份和鉴权';
DROP TABLE IF EXISTS `hits`;
CREATE TABLE `hits` (
  `hits_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '点赞ID：',
  `user_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '点赞人：',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间：',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间：',
  `source_table` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '来源表：',
  `source_field` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '来源字段：',
  `source_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '来源ID：',
  PRIMARY KEY (`hits_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;
insert into `auth` values ('1','学生','学生','student','学生','/student/table','','_blank','0','0','0','0','student_number,full_name,gender,grade,major,class_name,teacher_number','student_number,full_name,gender,grade,major,class_name,teacher_number','student_number,full_name,gender,grade,major,class_name,teacher_number',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('2','学生','学生','student','学生详情','/student/view','','_blank','0','0','0','0','student_number,full_name,gender,grade,major,class_name,teacher_number','student_number,full_name,gender,grade,major,class_name,teacher_number','student_number,full_name,gender,grade,major,class_name,teacher_number',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('3','学生','每日计划','daily_plan','每日计划','/daily_plan/table','','_blank','1','1','1','1','class_name,mission_today,full_name,date,student_number','mission_today,completion,self_scoring','class_name,full_name,date,student_number,mission_today,self_scoring,completion',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('4','学生','每日计划','daily_plan','每日计划详情','/daily_plan/view','','_blank','1','1','1','1','class_name,mission_today,full_name,date,student_number','mission_today,completion,self_scoring','class_name,mission_today,completion,full_name,date,student_number,,student_user,self_scoring',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('5','学生','每周计划','weekly_plan','每周计划','/weekly_plan/table','','_blank','1','1','1','1','tasks_this_week,start_time,end_time,zhou_hao,class_name,full_name,student_number,','completion,tasks_this_week,start_time,end_time,zhou_hao,self_scoring','tasks_this_week,start_time,end_time,zhou_hao,class_name,full_name,student_number,self_scoring,completion',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('6','学生','每周计划','weekly_plan','每周计划详情','/weekly_plan/view','','_blank','1','1','1','1','tasks_this_week,start_time,end_time,zhou_hao,class_name,full_name,student_number,','completion,tasks_this_week,start_time,end_time,zhou_hao,self_scoring','completion,tasks_this_week,start_time,end_time,zhou_hao,class_name,full_name,student_number,,student_user,self_scoring',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('7','学生','心得总结','summary_of_experience','心得总结','/summary_of_experience/table','','_blank','1','1','1','1','summary_of_this_week,class_name,zhou_hao,full_name,student_number','summary_of_this_week','summary_of_this_week,class_name,zhou_hao,full_name,student_number',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('8','学生','心得总结','summary_of_experience','心得总结详情','/summary_of_experience/view','','_blank','1','1','1','1','summary_of_this_week,class_name,zhou_hao,full_name,student_number','summary_of_this_week','student_user,student_number,full_name,class_name,zhou_hao,summary_of_this_week',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('9','学生','放松天地','relax_the_world','放松天地','/relax_the_world/table','','_blank','0','0','0','1','title,type,teacher_number,release_time,content','title,type,teacher_number,release_time,content','title,type,teacher_number,release_time,content',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('10','学生','放松天地','relax_the_world','放松天地详情','/relax_the_world/view','','_blank','0','0','0','1','title,type,teacher_number,release_time,content','title,type,teacher_number,release_time,content','title,type,teacher_number,release_time,content',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('11','学生','学生信息','student_information','学生信息','/student_information/table','','_blank','0','0','0','0','class_number,student_number,student_name,telephone,major,teacher_number','class_number,student_number,student_name,telephone,major,teacher_number','class_number,student_number,student_name,telephone,major,teacher_number',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('12','学生','学生信息','student_information','学生信息详情','/student_information/view','','_blank','0','0','0','0','class_number,student_number,student_name,telephone,major,teacher_number','class_number,student_number,student_name,telephone,major,teacher_number','class_number,student_number,student_name,telephone,major,teacher_number',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('13','学生','教师','teacher','教师','/teacher/table','','_blank','0','0','0','0','teacher_number,teacher_name,gender,courses_taught,class_name','teacher_number,teacher_name,gender,courses_taught,class_name','teacher_number,teacher_name,gender,courses_taught,class_name',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('14','学生','教师','teacher','教师详情','/teacher/view','','_blank','0','0','0','0','teacher_number,teacher_name,gender,courses_taught,class_name','teacher_number,teacher_name,gender,courses_taught,class_name','teacher_number,teacher_name,gender,courses_taught,class_name',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('15','学生','次日计划','next_day_plan','次日计划','/next_day_plan/table','','_blank','1','1','1','1','full_name,student_number,next_day_task,class_name,date','completion,next_day_task,date,self_scoring','full_name,student_number,next_day_task,class_name,date,self_scoring,completion',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('16','学生','次日计划','next_day_plan','次日计划详情','/next_day_plan/view','','_blank','1','1','1','1','full_name,student_number,next_day_task,class_name,date','completion,next_day_task,date,self_scoring','full_name,student_number,completion,next_day_task,class_name,date,student_user,self_scoring',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('17','学生','评论','comment','评论列表','/comment/table','','_blank','0','0','0','0','','','',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('18','学生','评论','comment','评论详情','/comment/view','','_blank','0','0','0','0','','','',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('19','学生','评论','comment','我的评论','/comment/list','','_blank','0','0','0','0','','','',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('20','学生','评论','comment','评论详情','/comment/details','','_blank','0','0','0','0','','','',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('21','教师','学生','student','学生','/student/table','','_blank','0','0','0','0','student_number,full_name,gender,grade,major,class_name,teacher_number','student_number,full_name,gender,grade,major,class_name,teacher_number','student_number,full_name,gender,grade,major,class_name,teacher_number',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('22','教师','学生','student','学生详情','/student/view','','_blank','0','0','0','0','student_number,full_name,gender,grade,major,class_name,teacher_number','student_number,full_name,gender,grade,major,class_name,teacher_number','student_number,full_name,gender,grade,major,class_name,teacher_number',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('23','教师','每日计划','daily_plan','每日计划','/daily_plan/table','','_blank','0','0','0','1','student_user,student_number,full_name,date,class_name,completion,self_scoring,teacher_number,mission_today','student_user,student_number,full_name,date,class_name,completion,self_scoring,teacher_number,mission_today','full_name,date,student_number,class_name',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('24','教师','每日计划','daily_plan','每日计划详情','/daily_plan/view','','_blank','0','0','0','1','student_user,student_number,full_name,date,class_name,completion,self_scoring,teacher_number,mission_today','student_user,student_number,full_name,date,class_name,completion,self_scoring,teacher_number,mission_today','student_user,student_number,full_name,date,class_name,completion,self_scoring,teacher_number,mission_today',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('25','教师','每周计划','weekly_plan','每周计划','/weekly_plan/table','','_blank','0','0','0','1','student_user,student_number,full_name,zhou_hao,class_name,start_time,end_time,completion,self_scoring,teacher_number,tasks_this_week','student_user,student_number,full_name,zhou_hao,class_name,start_time,end_time,completion,self_scoring,teacher_number,tasks_this_week','zhou_hao,full_name,student_number,class_name',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('26','教师','每周计划','weekly_plan','每周计划详情','/weekly_plan/view','','_blank','0','0','0','1','student_user,student_number,full_name,zhou_hao,class_name,start_time,end_time,completion,self_scoring,teacher_number,tasks_this_week','student_user,student_number,full_name,zhou_hao,class_name,start_time,end_time,completion,self_scoring,teacher_number,tasks_this_week','student_user,student_number,full_name,zhou_hao,class_name,start_time,end_time,completion,self_scoring,teacher_number,tasks_this_week',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('27','教师','心得总结','summary_of_experience','心得总结','/summary_of_experience/table','','_blank','0','0','0','0','student_user,student_number,full_name,class_name,zhou_hao,summary_of_this_week','student_user,student_number,full_name,class_name,zhou_hao,summary_of_this_week','student_user,student_number,full_name,class_name,zhou_hao,summary_of_this_week',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('28','教师','心得总结','summary_of_experience','心得总结详情','/summary_of_experience/view','','_blank','0','0','0','0','student_user,student_number,full_name,class_name,zhou_hao,summary_of_this_week','student_user,student_number,full_name,class_name,zhou_hao,summary_of_this_week','student_user,student_number,full_name,class_name,zhou_hao,summary_of_this_week',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('29','教师','放松天地','relax_the_world','放松天地','/relax_the_world/table','','_blank','1','1','1','1','title,type,teacher_number,release_time,content','title,type,teacher_number,release_time,content','title,type,teacher_number,release_time,content',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('30','教师','放松天地','relax_the_world','放松天地详情','/relax_the_world/view','','_blank','1','1','1','1','title,type,teacher_number,release_time,content','title,type,teacher_number,release_time,content','title,type,teacher_number,release_time,content',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('31','教师','学生信息','student_information','学生信息','/student_information/table','','_blank','1','1','1','1','class_number,student_number,student_name,telephone,major,teacher_number','class_number,student_number,student_name,telephone,major,teacher_number','telephone,major,,student_number,,student_name,class_number',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('32','教师','学生信息','student_information','学生信息详情','/student_information/view','','_blank','1','1','1','1','class_number,student_number,student_name,telephone,major,teacher_number','class_number,student_number,student_name,telephone,major,teacher_number','class_number,student_number,student_name,telephone,major,teacher_number',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('33','教师','教师','teacher','教师','/teacher/table','','_blank','0','0','0','0','teacher_number,teacher_name,gender,courses_taught,class_name','teacher_number,teacher_name,gender,courses_taught,class_name','teacher_number,teacher_name,gender,courses_taught,class_name',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('34','教师','教师','teacher','教师详情','/teacher/view','','_blank','0','0','0','0','teacher_number,teacher_name,gender,courses_taught,class_name','teacher_number,teacher_name,gender,courses_taught,class_name','teacher_number,teacher_name,gender,courses_taught,class_name',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('35','教师','次日计划','next_day_plan','次日计划','/next_day_plan/table','','_blank','0','0','0','1','student_user,student_number,full_name,date,class_name,completion,self_scoring,teacher_number,next_day_task','student_user,student_number,full_name,date,class_name,completion,self_scoring,teacher_number,next_day_task','full_name,student_number,class_name,date',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('36','教师','次日计划','next_day_plan','次日计划详情','/next_day_plan/view','','_blank','0','0','0','1','student_user,student_number,full_name,date,class_name,completion,self_scoring,teacher_number,next_day_task','student_user,student_number,full_name,date,class_name,completion,self_scoring,teacher_number,next_day_task','student_user,student_number,full_name,date,class_name,completion,self_scoring,teacher_number,next_day_task',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('37','教师','评论','comment','评论列表','/comment/table','','_blank','0','0','0','0','','','',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('38','教师','评论','comment','评论详情','/comment/view','','_blank','0','0','0','0','','','',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('39','教师','评论','comment','我的评论','/comment/list','','_blank','0','0','0','0','','','',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('40','教师','评论','comment','评论详情','/comment/details','','_blank','0','0','0','0','','','',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('41','管理员','学生','student','学生','/student/table','','_blank','1','1','1','1','student_number,full_name,gender,grade,major,class_name,teacher_number','student_number,full_name,gender,grade,major,class_name,teacher_number','student_number,full_name,gender,grade,major,class_name,teacher_number',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('42','管理员','学生','student','学生详情','/student/view','','_blank','1','1','1','1','student_number,full_name,gender,grade,major,class_name,teacher_number','student_number,full_name,gender,grade,major,class_name,teacher_number','student_number,full_name,gender,grade,major,class_name,teacher_number',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('43','管理员','每日计划','daily_plan','每日计划','/daily_plan/table','','_blank','1','1','1','1','student_user,student_number,full_name,date,class_name,completion,self_scoring,teacher_number,mission_today','student_user,student_number,full_name,date,class_name,completion,self_scoring,teacher_number,mission_today','student_user,student_number,full_name,date,class_name,completion,self_scoring,teacher_number,mission_today',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('44','管理员','每日计划','daily_plan','每日计划详情','/daily_plan/view','','_blank','1','1','1','1','student_user,student_number,full_name,date,class_name,completion,self_scoring,teacher_number,mission_today','student_user,student_number,full_name,date,class_name,completion,self_scoring,teacher_number,mission_today','student_user,student_number,full_name,date,class_name,completion,self_scoring,teacher_number,mission_today',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('45','管理员','每周计划','weekly_plan','每周计划','/weekly_plan/table','','_blank','1','1','1','1','student_user,student_number,full_name,zhou_hao,class_name,start_time,end_time,completion,self_scoring,teacher_number,tasks_this_week','student_user,student_number,full_name,zhou_hao,class_name,start_time,end_time,completion,self_scoring,teacher_number,tasks_this_week','student_user,student_number,full_name,zhou_hao,class_name,start_time,end_time,completion,self_scoring,teacher_number,tasks_this_week',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('46','管理员','每周计划','weekly_plan','每周计划详情','/weekly_plan/view','','_blank','1','1','1','1','student_user,student_number,full_name,zhou_hao,class_name,start_time,end_time,completion,self_scoring,teacher_number,tasks_this_week','student_user,student_number,full_name,zhou_hao,class_name,start_time,end_time,completion,self_scoring,teacher_number,tasks_this_week','student_user,student_number,full_name,zhou_hao,class_name,start_time,end_time,completion,self_scoring,teacher_number,tasks_this_week',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('47','管理员','心得总结','summary_of_experience','心得总结','/summary_of_experience/table','','_blank','1','1','1','1','student_user,student_number,full_name,class_name,zhou_hao,summary_of_this_week','student_user,student_number,full_name,class_name,zhou_hao,summary_of_this_week','student_user,student_number,full_name,class_name,zhou_hao,summary_of_this_week',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('48','管理员','心得总结','summary_of_experience','心得总结详情','/summary_of_experience/view','','_blank','1','1','1','1','student_user,student_number,full_name,class_name,zhou_hao,summary_of_this_week','student_user,student_number,full_name,class_name,zhou_hao,summary_of_this_week','student_user,student_number,full_name,class_name,zhou_hao,summary_of_this_week',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('49','管理员','放松天地','relax_the_world','放松天地','/relax_the_world/table','','_blank','1','1','1','1','title,type,teacher_number,release_time,content','title,type,teacher_number,release_time,content','title,type,teacher_number,release_time,content',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('50','管理员','放松天地','relax_the_world','放松天地详情','/relax_the_world/view','','_blank','1','1','1','1','title,type,teacher_number,release_time,content','title,type,teacher_number,release_time,content','title,type,teacher_number,release_time,content',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('51','管理员','学生信息','student_information','学生信息','/student_information/table','','_blank','1','1','1','1','class_number,student_number,student_name,telephone,major,teacher_number','class_number,student_number,student_name,telephone,major,teacher_number','class_number,student_number,student_name,telephone,major,teacher_number',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('52','管理员','学生信息','student_information','学生信息详情','/student_information/view','','_blank','1','1','1','1','class_number,student_number,student_name,telephone,major,teacher_number','class_number,student_number,student_name,telephone,major,teacher_number','class_number,student_number,student_name,telephone,major,teacher_number',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('53','管理员','教师','teacher','教师','/teacher/table','','_blank','1','1','1','1','teacher_number,teacher_name,gender,courses_taught,class_name','teacher_number,teacher_name,gender,courses_taught,class_name','teacher_number,teacher_name,gender,courses_taught,class_name',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('54','管理员','教师','teacher','教师详情','/teacher/view','','_blank','1','1','1','1','teacher_number,teacher_name,gender,courses_taught,class_name','teacher_number,teacher_name,gender,courses_taught,class_name','teacher_number,teacher_name,gender,courses_taught,class_name',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('55','管理员','次日计划','next_day_plan','次日计划','/next_day_plan/table','','_blank','1','1','1','1','student_user,student_number,full_name,date,class_name,completion,self_scoring,teacher_number,next_day_task','student_user,student_number,full_name,date,class_name,completion,self_scoring,teacher_number,next_day_task','student_user,student_number,full_name,date,class_name,completion,self_scoring,teacher_number,next_day_task',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('56','管理员','次日计划','next_day_plan','次日计划详情','/next_day_plan/view','','_blank','1','1','1','1','student_user,student_number,full_name,date,class_name,completion,self_scoring,teacher_number,next_day_task','student_user,student_number,full_name,date,class_name,completion,self_scoring,teacher_number,next_day_task','student_user,student_number,full_name,date,class_name,completion,self_scoring,teacher_number,next_day_task',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('57','管理员','评论','comment','评论列表','/comment/table','','_blank','0','0','0','0','','','',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('58','管理员','评论','comment','评论详情','/comment/view','','_blank','0','0','0','0','','','',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('59','管理员','评论','comment','我的评论','/comment/list','','_blank','0','0','0','0','','','',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('60','管理员','评论','comment','评论详情','/comment/details','','_blank','0','0','0','0','','','',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('61','游客','学生','student','学生','/student/table','','_blank','1','0','0','0','gender,full_name,major,class_name,grade,student_number','student_number,full_name,gender,grade,major,class_name,teacher_number','student_number,full_name,gender,grade,major,class_name,teacher_number',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('62','游客','学生','student','学生详情','/student/view','','_blank','1','0','0','0','gender,full_name,major,class_name,grade,student_number','student_number,full_name,gender,grade,major,class_name,teacher_number','student_number,full_name,gender,grade,major,class_name,teacher_number',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('63','游客','每日计划','daily_plan','每日计划','/daily_plan/table','','_blank','0','0','0','0','student_user,student_number,full_name,date,class_name,completion,self_scoring,teacher_number,mission_today','student_user,student_number,full_name,date,class_name,completion,self_scoring,teacher_number,mission_today','student_user,student_number,full_name,date,class_name,completion,self_scoring,teacher_number,mission_today',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('64','游客','每日计划','daily_plan','每日计划详情','/daily_plan/view','','_blank','0','0','0','0','student_user,student_number,full_name,date,class_name,completion,self_scoring,teacher_number,mission_today','student_user,student_number,full_name,date,class_name,completion,self_scoring,teacher_number,mission_today','student_user,student_number,full_name,date,class_name,completion,self_scoring,teacher_number,mission_today',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('65','游客','每周计划','weekly_plan','每周计划','/weekly_plan/table','','_blank','0','0','0','0','student_user,student_number,full_name,zhou_hao,class_name,start_time,end_time,completion,self_scoring,teacher_number,tasks_this_week','student_user,student_number,full_name,zhou_hao,class_name,start_time,end_time,completion,self_scoring,teacher_number,tasks_this_week','student_user,student_number,full_name,zhou_hao,class_name,start_time,end_time,completion,self_scoring,teacher_number,tasks_this_week',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('66','游客','每周计划','weekly_plan','每周计划详情','/weekly_plan/view','','_blank','0','0','0','0','student_user,student_number,full_name,zhou_hao,class_name,start_time,end_time,completion,self_scoring,teacher_number,tasks_this_week','student_user,student_number,full_name,zhou_hao,class_name,start_time,end_time,completion,self_scoring,teacher_number,tasks_this_week','student_user,student_number,full_name,zhou_hao,class_name,start_time,end_time,completion,self_scoring,teacher_number,tasks_this_week',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('67','游客','心得总结','summary_of_experience','心得总结','/summary_of_experience/table','','_blank','0','0','0','0','student_user,student_number,full_name,class_name,zhou_hao,summary_of_this_week','student_user,student_number,full_name,class_name,zhou_hao,summary_of_this_week','student_user,student_number,full_name,class_name,zhou_hao,summary_of_this_week',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('68','游客','心得总结','summary_of_experience','心得总结详情','/summary_of_experience/view','','_blank','0','0','0','0','student_user,student_number,full_name,class_name,zhou_hao,summary_of_this_week','student_user,student_number,full_name,class_name,zhou_hao,summary_of_this_week','student_user,student_number,full_name,class_name,zhou_hao,summary_of_this_week',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('69','游客','放松天地','relax_the_world','放松天地','/relax_the_world/table','','_blank','0','0','0','0','title,type,teacher_number,release_time,content','title,type,teacher_number,release_time,content','title,type,teacher_number,release_time,content',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('70','游客','放松天地','relax_the_world','放松天地详情','/relax_the_world/view','','_blank','0','0','0','0','title,type,teacher_number,release_time,content','title,type,teacher_number,release_time,content','title,type,teacher_number,release_time,content',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('71','游客','学生信息','student_information','学生信息','/student_information/table','','_blank','0','0','0','0','class_number,student_number,student_name,telephone,major,teacher_number','class_number,student_number,student_name,telephone,major,teacher_number','class_number,student_number,student_name,telephone,major,teacher_number',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('72','游客','学生信息','student_information','学生信息详情','/student_information/view','','_blank','0','0','0','0','class_number,student_number,student_name,telephone,major,teacher_number','class_number,student_number,student_name,telephone,major,teacher_number','class_number,student_number,student_name,telephone,major,teacher_number',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('73','游客','教师','teacher','教师','/teacher/table','','_blank','0','0','0','0','teacher_number,teacher_name,gender,courses_taught,class_name','teacher_number,teacher_name,gender,courses_taught,class_name','teacher_number,teacher_name,gender,courses_taught,class_name',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('74','游客','教师','teacher','教师详情','/teacher/view','','_blank','0','0','0','0','teacher_number,teacher_name,gender,courses_taught,class_name','teacher_number,teacher_name,gender,courses_taught,class_name','teacher_number,teacher_name,gender,courses_taught,class_name',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('75','游客','次日计划','next_day_plan','次日计划','/next_day_plan/table','','_blank','0','0','0','0','student_user,student_number,full_name,date,class_name,completion,self_scoring,teacher_number,next_day_task','student_user,student_number,full_name,date,class_name,completion,self_scoring,teacher_number,next_day_task','student_user,student_number,full_name,date,class_name,completion,self_scoring,teacher_number,next_day_task',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('76','游客','次日计划','next_day_plan','次日计划详情','/next_day_plan/view','','_blank','0','0','0','0','student_user,student_number,full_name,date,class_name,completion,self_scoring,teacher_number,next_day_task','student_user,student_number,full_name,date,class_name,completion,self_scoring,teacher_number,next_day_task','student_user,student_number,full_name,date,class_name,completion,self_scoring,teacher_number,next_day_task',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('77','游客','评论','comment','评论列表','/comment/table','','_blank','0','0','0','0','','','',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('78','游客','评论','comment','评论详情','/comment/view','','_blank','0','0','0','0','','','',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('79','游客','评论','comment','我的评论','/comment/list','','_blank','0','0','0','0','','','',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `auth` values ('80','游客','评论','comment','评论详情','/comment/details','','_blank','0','0','0','0','','','',null,'0','{}',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `user_group` values ('1','100','学生',null,'student','student_id','0','1',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `user_group` values ('2','100','教师',null,'teacher','teacher_id','0','0',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `user_group` values ('3','100','管理员',null,'','','0',null,"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
insert into `user_group` values ('4','100','游客',null,'','','0','0',"2022-04-25 07:44:26.000 ","2022-04-25 07:44:26.000 ");
