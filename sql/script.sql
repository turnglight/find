CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `sno` varchar(12) NOT NULL DEFAULT '' COMMENT '用户序列号',
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '名称',
  `nickname` varchar(20) NOT NULL DEFAULT '' COMMENT '昵称',
  `password` varchar(64) NOT NULL DEFAULT '' COMMENT '密码',
  `status` int(2) NOT NULL DEFAULT '0' COMMENT '用户状态',
  `online_status` int(2) DEFAULT NULL COMMENT '在线状态',
  `level` int(2) NOT NULL DEFAULT '0' COMMENT '用户等级',
  `vip_state` int(2) DEFAULT NULL COMMENT '是否VIP',
  `phone` varchar(20) NOT NULL DEFAULT '' COMMENT '手机号码',
  `wxno` varchar(20) NOT NULL DEFAULT '' COMMENT '微信号',
  `last_login_time` datetime DEFAULT NULL COMMENT '最近登录时间',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `user_detail` (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `sno` varchar(12) NOT NULL COMMENT '用户序列号',
  `via` varchar(100) NOT NULL DEFAULT '' COMMENT '头像',
  `photos` text COMMENT '照片',
  `voice` varchar(100) NOT NULL DEFAULT '' COMMENT '语音',
  `video` varchar(100) NOT NULL DEFAULT '' COMMENT '视频',
  `signature` varchar(50) DEFAULT NULL COMMENT '个性签名',
  `gender` int(2) NOT NULL COMMENT '性别',
  `age` int(2) NOT NULL COMMENT '年龄',
  `height` int(2) NOT NULL COMMENT '身高',
  `weight` int(2) NOT NULL COMMENT '体重',
  `hobby` varchar(30) NOT NULL DEFAULT '' COMMENT '爱好',
  `edu` varchar(10) NOT NULL DEFAULT '' COMMENT '教育程度',
  `smoking` int(2) NOT NULL DEFAULT '0' COMMENT '是否抽烟',
  `drink` int(2) NOT NULL DEFAULT '0' COMMENT '是否饮酒',
  `region` varchar(20) DEFAULT NULL COMMENT '所在地区',
  `school` varchar(20) DEFAULT NULL COMMENT '学校',
  `profession` varchar(20) NOT NULL DEFAULT '' COMMENT '专业',
  `school_year` varchar(20) NOT NULL DEFAULT '' COMMENT '学年',
  `career` varchar(10) NOT NULL DEFAULT '' COMMENT '职业',
  `phone` varchar(20) NOT NULL DEFAULT '' COMMENT '电话号码',
  `lng` decimal(12,9) NOT NULL DEFAULT '0.000000000' COMMENT '经度',
  `lat` decimal(11,9) NOT NULL DEFAULT '0.000000000' COMMENT '维度',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

