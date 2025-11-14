/*
 Navicat Premium Data Transfer

 Source Server         : Blog
 Source Server Type    : MySQL
 Source Server Version : 50715 (5.7.15)
 Source Host           : localhost:3306
 Source Schema         : tumo

 Target Server Type    : MySQL
 Target Server Version : 50715 (5.7.15)
 File Encoding         : 65001

 Date: 25/11/2023 21:53:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_article
-- ----------------------------
DROP TABLE IF EXISTS `tb_article`;
CREATE TABLE `tb_article` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `title` varchar(400) DEFAULT NULL COMMENT '标题',
  `author` varchar(100) NOT NULL COMMENT '作者',
  `des` mediumtext COMMENT '文章描述',
  `content` mediumtext COMMENT '内容',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='文章表';

-- ----------------------------
-- Records of tb_article
-- ----------------------------
BEGIN;
INSERT INTO `tb_article` (`id`, `title`, `author`, `des`, `content`, `create_time`) VALUES (1, 'How to write an article?', 'tycoding', '<h1 id=\"h1-how-to-write-an-article-\" style=\"font-family: Roboto, sans-serif;\">How to write an article?</h1><h2 id=\"h2-markdown-rules\" style=\"font-family: Roboto, sans-serif;\"><a name=\"Markdown rules\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>Markdown rules</h2><p><span style=\"font-weight: bolder;\">For example</span></p><p><a href=\"https://tycoding.cn/\">https://tycoding.cn</a></p>', '<h1 id=\"h1-how-to-write-an-article-\"><a name=\"How to write an article?\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>How to write an article?</h1><h2 id=\"h2-markdown-rules\"><a name=\"Markdown rules\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>Markdown rules</h2><p><strong>For example</strong></p>\n<p><a href=\"https://tycoding.cn\">https://tycoding.cn</a></p>\n<pre><code class=\"lang-java\">public static void main(String[] args) {\n        System.out.println(\"Hello World\");\n}\n</code></pre>\n<p><img src=\"http://img.api.tycoding.cn/1568958650973.jpeg\" alt=\"\">\n<table>\n<thead>\n<tr>\n<th>Name</th>\n<th>Link</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td>Github</td>\n<td><a href=\"https://github.com/TyCoding\">https://github.com/TyCoding</a></td>\n</tr>\n<tr>\n<td>Blog</td>\n<td><a href=\"https://tycoding.cn\">https://tycoding.cn</a></td>\n</tr>\n</tbody>\n</table>\n<ul>\n<li>list one</li><li>list two</li><li>list there</li></ul>\n<h1 id=\"h1-contact\"><a name=\"Contact\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>Contact</h1><ul>\n<li><a href=\"http://www.tycoding.cn\">Blog@TyCoding’s blog</a></li><li><a href=\"https://github.com/TyCoding\">GitHub@TyCoding</a></li><li><a href=\"https://www.zhihu.com/people/tomo-83-82/activities\">ZhiHu@TyCoding</a></li><li>QQ Group: 671017003</li></ul>\n', '2019-09-22 14:57:51');
INSERT INTO `tb_article` (`id`, `title`, `author`, `des`, `content`, `create_time`) VALUES (2, 'How to write an article? --2', 'tycoding', '<h1 id=\"h1-how-to-write-an-article-\" style=\"font-family: Roboto, sans-serif;\">How to write an article?</h1><h2 id=\"h2-markdown-rules\" style=\"font-family: Roboto, sans-serif;\"><a name=\"Markdown rules\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>Markdown rules</h2><h1><p style=\"color: rgb(96, 98, 102); font-size: 14px;\"><span style=\"font-weight: bolder;\">For example</span></p><p style=\"color: rgb(96, 98, 102); font-size: 14px;\"><a href=\"https://tycoding.cn/\">https://tycoding.cn</a></p></h1>', '<h1 id=\"h1-how-to-write-an-article-\"><a name=\"How to write an article?\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>How to write an article?</h1><h2 id=\"h2-markdown-rules\"><a name=\"Markdown rules\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>Markdown rules</h2><p><strong>For example</strong></p>\n<p><a href=\"https://tycoding.cn\">https://tycoding.cn</a></p>\n<pre><code class=\"lang-java\">public static void main(String[] args) {\n        System.out.println(\"Hello World\");\n}\n</code></pre>\n<p><img src=\"http://img.api.tycoding.cn/1568958650973.jpeg\" alt=\"\">\n<table>\n<thead>\n<tr>\n<th>Name</th>\n<th>Link</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td>Github</td>\n<td><a href=\"https://github.com/TyCoding\">https://github.com/TyCoding</a></td>\n</tr>\n<tr>\n<td>Blog</td>\n<td><a href=\"https://tycoding.cn\">https://tycoding.cn</a></td>\n</tr>\n</tbody>\n</table>\n<ul>\n<li>list one</li><li>list two</li><li>list there</li></ul>\n<h1 id=\"h1-contact\"><a name=\"Contact\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>Contact</h1><ul>\n<li><a href=\"http://www.tycoding.cn\">Blog@TyCoding’s blog</a></li><li><a href=\"https://github.com/TyCoding\">GitHub@TyCoding</a></li><li><a href=\"https://www.zhihu.com/people/tomo-83-82/activities\">ZhiHu@TyCoding</a></li><li>QQ Group: 671017003</li></ul>\n', '2019-09-22 14:58:31');
INSERT INTO `tb_article` (`id`, `title`, `author`, `des`, `content`, `create_time`) VALUES (3, 'How to write an article? --3', 'tycoding', '<h1 id=\"h1-how-to-write-an-article-\" style=\"font-family: Roboto, sans-serif;\">How to write an article?</h1><h2 id=\"h2-markdown-rules\" style=\"font-family: Roboto, sans-serif;\"><a name=\"Markdown rules\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>Markdown rules</h2><p><span style=\"font-weight: bolder;\">For example</span></p><p><a href=\"https://tycoding.cn/\">https://tycoding.cn</a></p>', '<h1 id=\"h1-how-to-write-an-article-\"><a name=\"How to write an article?\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>How to write an article?</h1><h2 id=\"h2-markdown-rules\"><a name=\"Markdown rules\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>Markdown rules</h2><p><strong>For example</strong></p>\n<p><a href=\"https://tycoding.cn\">https://tycoding.cn</a></p>\n<pre><code class=\"lang-java\">public static void main(String[] args) {\n        System.out.println(\"Hello World\");\n}\n</code></pre>\n<p><img src=\"http://img.api.tycoding.cn/1568958650973.jpeg\" alt=\"\">\n<table>\n<thead>\n<tr>\n<th>Name</th>\n<th>Link</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td>Github</td>\n<td><a href=\"https://github.com/TyCoding\">https://github.com/TyCoding</a></td>\n</tr>\n<tr>\n<td>Blog</td>\n<td><a href=\"https://tycoding.cn\">https://tycoding.cn</a></td>\n</tr>\n</tbody>\n</table>\n<ul>\n<li>list one</li><li>list two</li><li>list there</li></ul>\n<h1 id=\"h1-contact\"><a name=\"Contact\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>Contact</h1><ul>\n<li><a href=\"http://www.tycoding.cn\">Blog@TyCoding’s blog</a></li><li><a href=\"https://github.com/TyCoding\">GitHub@TyCoding</a></li><li><a href=\"https://www.zhihu.com/people/tomo-83-82/activities\">ZhiHu@TyCoding</a></li><li>QQ Group: 671017003</li></ul>\n', '2019-09-22 14:58:54');
COMMIT;

-- ----------------------------
-- Table structure for tb_article_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_article_category`;
CREATE TABLE `tb_article_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `article_id` bigint(20) NOT NULL COMMENT '文章ID',
  `category_id` bigint(20) NOT NULL COMMENT '分类ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='文章&&分类关联表';

-- ----------------------------
-- Records of tb_article_category
-- ----------------------------
BEGIN;
INSERT INTO `tb_article_category` (`id`, `article_id`, `category_id`) VALUES (1, 1, 1);
INSERT INTO `tb_article_category` (`id`, `article_id`, `category_id`) VALUES (2, 2, 1);
INSERT INTO `tb_article_category` (`id`, `article_id`, `category_id`) VALUES (3, 3, 1);
INSERT INTO `tb_article_category` (`id`, `article_id`, `category_id`) VALUES (4, 2, 1);
INSERT INTO `tb_article_category` (`id`, `article_id`, `category_id`) VALUES (5, 1, 4);
COMMIT;

-- ----------------------------
-- Table structure for tb_article_tag
-- ----------------------------
DROP TABLE IF EXISTS `tb_article_tag`;
CREATE TABLE `tb_article_tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `article_id` bigint(20) NOT NULL COMMENT '文章ID',
  `tag_id` bigint(20) NOT NULL COMMENT '标签ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='文章&&标签关联表';

-- ----------------------------
-- Records of tb_article_tag
-- ----------------------------
BEGIN;
INSERT INTO `tb_article_tag` (`id`, `article_id`, `tag_id`) VALUES (1, 1, 4);
INSERT INTO `tb_article_tag` (`id`, `article_id`, `tag_id`) VALUES (2, 2, 4);
INSERT INTO `tb_article_tag` (`id`, `article_id`, `tag_id`) VALUES (3, 3, 1);
INSERT INTO `tb_article_tag` (`id`, `article_id`, `tag_id`) VALUES (4, 3, 4);
INSERT INTO `tb_article_tag` (`id`, `article_id`, `tag_id`) VALUES (5, 2, 1);
COMMIT;

-- ----------------------------
-- Table structure for tb_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_category`;
CREATE TABLE `tb_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(100) DEFAULT NULL COMMENT '分类名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='分类表';

-- ----------------------------
-- Records of tb_category
-- ----------------------------
BEGIN;
INSERT INTO `tb_category` (`id`, `name`) VALUES (1, '测试');
INSERT INTO `tb_category` (`id`, `name`) VALUES (2, '随笔');
INSERT INTO `tb_category` (`id`, `name`) VALUES (3, '心情');
INSERT INTO `tb_category` (`id`, `name`) VALUES (4, 'springboot');
COMMIT;

-- ----------------------------
-- Table structure for tb_comment
-- ----------------------------
DROP TABLE IF EXISTS `tb_comment`;
CREATE TABLE `tb_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `article_id` bigint(20) DEFAULT NULL COMMENT '文章ID',
  `nickname` varchar(20) DEFAULT NULL COMMENT '给谁留言',
  `content` text COMMENT '留言内容',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `ip` varchar(20) DEFAULT NULL COMMENT 'IP地址',
  `device` varchar(100) DEFAULT NULL COMMENT '设备',
  `address` varchar(100) DEFAULT NULL COMMENT '地址',
  `create_time` datetime DEFAULT NULL COMMENT '留言时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='评论表';

-- ----------------------------
-- Records of tb_comment
-- ----------------------------
BEGIN;
INSERT INTO `tb_comment` (`id`, `article_id`, `nickname`, `content`, `email`, `ip`, `device`, `address`, `create_time`) VALUES (1, 13, 'tycoding', '测试留言', 'tytumo@163.com', '172.0.0.1', 'Mac OS', '北京市-海淀区', '2020-06-27 16:25:42');
INSERT INTO `tb_comment` (`id`, `article_id`, `nickname`, `content`, `email`, `ip`, `device`, `address`, `create_time`) VALUES (2, 13, 'test1', '测试留言', 'test@163.com', '172.0.0.1', 'Mac OS', '北京市-海淀区', '2020-06-27 16:56:19');
INSERT INTO `tb_comment` (`id`, `article_id`, `nickname`, `content`, `email`, `ip`, `device`, `address`, `create_time`) VALUES (4, 13, '1', 'sd', '2', '127.0.0.1', 'Chrome 8,Mac OS X', '内网IP|0|0|内网IP|内网IP', '2020-06-28 18:35:23');
INSERT INTO `tb_comment` (`id`, `article_id`, `nickname`, `content`, `email`, `ip`, `device`, `address`, `create_time`) VALUES (5, 13, '1', '1', '1', '127.0.0.1', 'Chrome 8,Mac OS X', '内网IP|0|0|内网IP|内网IP', '2020-06-28 18:58:29');
INSERT INTO `tb_comment` (`id`, `article_id`, `nickname`, `content`, `email`, `ip`, `device`, `address`, `create_time`) VALUES (6, 2, '123', 'tt', '12312', '127.0.0.1', 'Chrome 9,Mac OS X', '内网IP|0|0|内网IP|内网IP', '2021-09-11 15:26:41');
COMMIT;

-- ----------------------------
-- Table structure for tb_link
-- ----------------------------
DROP TABLE IF EXISTS `tb_link`;
CREATE TABLE `tb_link` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(100) DEFAULT NULL COMMENT '连接名称',
  `url` varchar(200) DEFAULT NULL COMMENT '连接URL',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='友链表';

-- ----------------------------
-- Records of tb_link
-- ----------------------------
BEGIN;
INSERT INTO `tb_link` (`id`, `name`, `url`) VALUES (1, 'Blog', 'http://tycoding.cn');
INSERT INTO `tb_link` (`id`, `name`, `url`) VALUES (2, 'Github', 'https://github.com/tycoding');
COMMIT;

-- ----------------------------
-- Table structure for tb_log
-- ----------------------------
DROP TABLE IF EXISTS `tb_log`;
CREATE TABLE `tb_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `username` varchar(20) DEFAULT NULL COMMENT '操作用户',
  `operation` varchar(20) DEFAULT NULL COMMENT '操作描述',
  `time` bigint(20) DEFAULT NULL COMMENT '耗时(毫秒)',
  `method` varchar(100) DEFAULT NULL COMMENT '操作方法',
  `params` varchar(255) DEFAULT NULL COMMENT '操作参数',
  `ip` varchar(20) DEFAULT NULL COMMENT 'IP地址',
  `create_time` datetime DEFAULT NULL COMMENT '操作时间',
  `location` varchar(20) DEFAULT NULL COMMENT '操作地点',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8 COMMENT='系统日志表';

-- ----------------------------
-- Records of tb_log
-- ----------------------------
BEGIN;
INSERT INTO `tb_log` (`id`, `username`, `operation`, `time`, `method`, `params`, `ip`, `create_time`, `location`) VALUES (87, 'tycoding', '新增文章', 1, 'cn.tycoding.biz.controller.ArticleController.add()', ' sysArticle\"SysArticle(id=14, title=1, author=tycoding, des=1, content=1, create...', '127.0.0.1', '2020-06-28 23:07:41', '内网IP|0|0|内网IP|内网IP');
INSERT INTO `tb_log` (`id`, `username`, `operation`, `time`, `method`, `params`, `ip`, `create_time`, `location`) VALUES (88, 'tycoding', '更新文章', 1, 'cn.tycoding.biz.controller.ArticleController.update()', ' sysArticle\"SysArticle(id=14, title=123, author=tycoding, des=1, content=1, crea...', '127.0.0.1', '2020-06-28 23:07:55', '内网IP|0|0|内网IP|内网IP');
COMMIT;

-- ----------------------------
-- Table structure for tb_login_log
-- ----------------------------
DROP TABLE IF EXISTS `tb_login_log`;
CREATE TABLE `tb_login_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `username` varchar(20) DEFAULT NULL COMMENT '用户名',
  `ip` varchar(20) DEFAULT NULL COMMENT 'IP地址',
  `location` varchar(255) DEFAULT NULL COMMENT '登录地点',
  `create_time` datetime DEFAULT NULL COMMENT '登录时间',
  `device` varchar(255) DEFAULT NULL COMMENT '登录设备',
  `user_type` varchar(255) DEFAULT NULL COMMENT '管理员类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_login_log
-- ----------------------------
BEGIN;
INSERT INTO `tb_login_log` (`id`, `username`, `ip`, `location`, `create_time`, `device`, `user_type`) VALUES (1, 'tycoding', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2021-09-16 14:42:56', 'Chrome 9 -- Mac OS X', '1');
INSERT INTO `tb_login_log` (`id`, `username`, `ip`, `location`, `create_time`, `device`, `user_type`) VALUES (2, 'tycoding', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2021-09-16 15:05:34', 'Chrome 9 -- Mac OS X', '1');
INSERT INTO `tb_login_log` (`id`, `username`, `ip`, `location`, `create_time`, `device`, `user_type`) VALUES (3, 'tycoding', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2021-09-16 15:54:07', 'Chrome 9 -- Mac OS X', '1');
INSERT INTO `tb_login_log` (`id`, `username`, `ip`, `location`, `create_time`, `device`, `user_type`) VALUES (4, 'tycoding', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2021-09-16 16:15:24', 'Chrome 9 -- Mac OS X', '1');
INSERT INTO `tb_login_log` (`id`, `username`, `ip`, `location`, `create_time`, `device`, `user_type`) VALUES (5, 'tycoding', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2021-09-16 16:15:43', 'Chrome 9 -- Mac OS X', '1');
INSERT INTO `tb_login_log` (`id`, `username`, `ip`, `location`, `create_time`, `device`, `user_type`) VALUES (6, 'tycoding', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2021-09-16 16:20:56', 'Chrome 9 -- Mac OS X', '1');
INSERT INTO `tb_login_log` (`id`, `username`, `ip`, `location`, `create_time`, `device`, `user_type`) VALUES (7, 'admin', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2021-09-16 16:51:47', 'Chrome 9 -- Mac OS X', '1');
INSERT INTO `tb_login_log` (`id`, `username`, `ip`, `location`, `create_time`, `device`, `user_type`) VALUES (8, 'tycoding', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2021-10-01 12:27:41', 'Chrome 9 -- Mac OS X', '1');
INSERT INTO `tb_login_log` (`id`, `username`, `ip`, `location`, `create_time`, `device`, `user_type`) VALUES (9, 'tycoding', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2021-10-01 12:27:52', 'Chrome 9 -- Mac OS X', '1');
INSERT INTO `tb_login_log` (`id`, `username`, `ip`, `location`, `create_time`, `device`, `user_type`) VALUES (10, 'tycoding', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2021-10-01 12:29:11', 'Chrome 9 -- Mac OS X', '1');
INSERT INTO `tb_login_log` (`id`, `username`, `ip`, `location`, `create_time`, `device`, `user_type`) VALUES (11, 'tycoding', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2021-10-01 12:33:19', 'Chrome 9 -- Mac OS X', '1');
INSERT INTO `tb_login_log` (`id`, `username`, `ip`, `location`, `create_time`, `device`, `user_type`) VALUES (12, 'tycoding', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2021-10-01 12:46:59', 'Chrome 9 -- Mac OS X', '1');
INSERT INTO `tb_login_log` (`id`, `username`, `ip`, `location`, `create_time`, `device`, `user_type`) VALUES (13, 'tycoding', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2021-10-01 12:52:45', 'Chrome 9 -- Mac OS X', '1');
INSERT INTO `tb_login_log` (`id`, `username`, `ip`, `location`, `create_time`, `device`, `user_type`) VALUES (14, 'tycoding', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2021-10-01 13:48:23', 'Chrome 9 -- Mac OS X', '1');
INSERT INTO `tb_login_log` (`id`, `username`, `ip`, `location`, `create_time`, `device`, `user_type`) VALUES (15, 'tycoding', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2021-10-01 14:19:03', 'Chrome 9 -- Mac OS X', '1');
INSERT INTO `tb_login_log` (`id`, `username`, `ip`, `location`, `create_time`, `device`, `user_type`) VALUES (16, 'tycoding', '127.0.0.1', '内网IP|0|0|内网IP|内网IP', '2021-10-01 14:19:43', 'Chrome 9 -- Mac OS X', '1');
COMMIT;

-- ----------------------------
-- Table structure for tb_sys_log
-- ----------------------------
DROP TABLE IF EXISTS `tb_sys_log`;
CREATE TABLE `tb_sys_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '操作管理员名称',
  `operation` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '操作',
  `operation_time` bigint(255) DEFAULT NULL COMMENT '操作时间',
  `status` int(255) DEFAULT NULL COMMENT '日志类型 1为操作日志，2位登录日志',
  `result` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=134 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of tb_sys_log
-- ----------------------------
BEGIN;
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (1, 'admin', '登录', 1652005341326, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (2, 'admin', '登录', 1652005764885, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (3, 'admin', '登录', 1652005957047, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (4, 'admin', '登录', 1652005990215, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (5, 'admin', '登录', 1652006045326, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (6, 'admin', '登录', 1652006125271, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (7, 'admin', '登录', 1652006190420, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (8, 'admin', '登录', 1652006227652, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (9, 'admin', '登录', 1652007329273, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (10, 'admin', '登录', 1652062263188, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (11, 'admin', '登录', 1652064484629, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (12, 'admin', '登录', 1652082140129, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (13, 'admin', '登录', 1652082168931, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (14, 'admin', '登录', 1652082183899, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (15, 'admin', '登录', 1652082255974, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (16, 'admin', '登录', 1652147160130, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (17, 'admin', '退出登录', 1652147172655, 1, '退出登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (18, 'admin', '登录', 1652147222209, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (19, 'admin', '退出登录', 1652147226209, 1, '退出登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (20, 'admin', '登录', 1652147660855, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (21, 'admin', '退出登录', 1652149490785, 1, '退出登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (22, 'admin', '登录', 1652149513138, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (23, 'admin', '退出登录', 1652149520433, 1, '退出登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (24, 'admin', '登录', 1652149583181, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (25, 'admin', '退出登录', 1652149587622, 1, '退出登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (26, 'admin', '登录', 1652149670369, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (27, 'admin', '退出登录', 1652149673977, 1, '退出登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (28, 'admin', '登录', 1652149925956, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (29, 'admin', '退出登录', 1652150156896, 1, '退出登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (30, 'admin', '登录', 1652150551011, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (31, 'admin', '登录', 1652151389675, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (32, 'admin', '退出登录', 1652151523301, 1, '退出登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (33, 'admin', '登录', 1652151575883, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (34, 'admin', '登录', 1652161733435, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (35, 'admin', '登录', 1652169127368, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (36, 'admin', '退出登录', 1652169795239, 1, '退出登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (37, 'admin', '登录', 1652169805785, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (38, 'admin', '退出登录', 1652169843876, 1, '退出登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (39, 'admin', '登录', 1652169850766, 2, '登录null');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (40, 'admin', '登录', 1652169851939, 2, '登录null');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (41, 'admin', '登录', 1652169857949, 2, '登录null');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (42, 'admin', '登录', 1652169865143, 2, '登录null');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (43, 'admin', '登录', 1652169879970, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (44, 'admin', '退出登录', 1652170243442, 1, '退出登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (45, 'admin', '登录', 1652170716921, 2, '登录null');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (46, '', '登录', 1652171497439, 2, '登录失败');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (47, 'admin', '登录', 1652171540340, 2, '登录失败');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (48, 'admin', '登录', 1652171551951, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (49, 'admin', '登录', 1652236592286, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (50, 'admin', '登录', 1652248709171, 2, '登录失败');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (51, 'admin', '登录', 1652248752034, 2, '登录失败');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (52, 'admin', '登录', 1652248795308, 2, '登录失败');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (53, 'admin', '登录', 1652248796450, 2, '登录失败');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (54, 'admin', '登录', 1652248799502, 2, '登录失败');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (55, 'admin', '登录', 1652249666759, 2, '登录失败');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (56, 'admin', '登录', 1652250384180, 2, '登录失败');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (57, 'admin', '登录', 1652251442146, 2, '登录失败');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (58, 'admin', '登录', 1652252258094, 2, '登录失败');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (59, 'admin', '登录', 1652252509783, 2, '登录失败');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (60, 'admin', '登录', 1652253392351, 2, '登录失败');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (61, 'admin', '登录', 1652253501786, 2, '登录失败');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (62, 'admin', '登录', 1652253725088, 2, '登录失败');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (63, 'admin', '登录', 1652254003986, 2, '登录失败');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (64, 'admin', '登录', 1652254320981, 2, '登录失败');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (65, 'admin', '登录', 1652254819838, 2, '登录失败');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (66, 'admin', '登录', 1652254985035, 2, '登录失败');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (67, 'admin', '登录', 1652255000370, 2, '登录失败');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (68, 'admin', '登录', 1652255286207, 2, '登录失败');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (69, 'admin', '登录', 1652255310911, 2, '登录失败');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (70, 'admin', '登录', 1652319432541, 2, '登录失败');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (71, 'admin', '登录', 1652319463125, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (72, 'admin', '退出登录', 1652320520565, 1, '退出登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (73, 'admin', '登录', 1652320527951, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (74, 'admin', '退出登录', 1652320530703, 1, '退出登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (75, 'admin', '登录', 1652320584689, 2, '登录失败');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (76, 'admin', '登录', 1652320605086, 2, '登录失败');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (77, 'admin', '登录', 1652320655039, 2, '登录失败');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (78, 'admin', '登录', 1652320660239, 2, '登录失败');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (79, 'admin', '登录', 1652320689495, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (80, 'admin', '退出登录', 1652320699480, 1, '退出登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (81, 'admin', '登录', 1652320709150, 2, '登录失败');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (82, 'admin', '登录', 1652336066732, 2, '登录失败');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (83, 'admin', '登录', 1652336466794, 2, '登录失败');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (84, 'admin', '登录', 1652336487264, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (85, 'admin', '退出登录', 1652342148978, 1, '退出登录non null key required');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (86, 'admin', '退出登录', 1652342155533, 1, '退出登录non null key required');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (87, 'admin', '登录', 1652342189401, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (88, 'admin', '登录', 1652342241901, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (89, 'admin', '登录', 1669259560781, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (90, 'admin', '登录', 1669259659483, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (91, 'admin', '登录', 1669259789580, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (92, 'admin', '登录', 1669277844060, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (93, 'admin', '登录', 1669277934597, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (94, 'admin', '登录', 1669278189030, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (95, 'admin', '登录', 1669278349254, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (96, 'admin', '登录', 1669278809474, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (97, 'admin', '登录', 1669278819531, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (98, 'admin', '登录', 1669278844655, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (99, 'admin', '登录', 1669886615420, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (100, 'admin', '登录', 1669886636936, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (101, 'admin', '登录', 1669886802209, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (102, 'admin', '登录', 1669887124527, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (103, 'admin', '登录', 1669887199967, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (104, 'admin', '登录', 1669887243842, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (105, 'admin', '登录', 1669887317428, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (106, 'admin', '登录', 1669959727533, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (107, 'admin', '登录', 1669962992300, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (108, 'admin', '登录', 1669963060082, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (109, 'admin', '登录', 1669963934157, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (110, 'admin', '登录', 1669964175760, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (111, 'admin', '登录', 1669964291433, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (112, 'admin', '登录', 1669966450681, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (113, 'admin', '登录', 1669967517554, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (114, 'admin', '登录', 1669967698452, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (115, 'admin', '登录', 1669969501524, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (116, 'admin', '退出登录', 1669972237657, 1, '退出登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (117, 'admin', '退出登录', 1669972408924, 1, '退出登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (118, 'admin', '登录', 1669972516503, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (119, 'admin', '退出登录', 1669972521552, 1, '退出登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (120, 'admin', '登录', 1669972689664, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (121, 'admin', '退出登录', 1669972743196, 1, '退出登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (122, 'admin', '登录', 1669972800415, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (123, 'admin', '退出登录', 1669972807798, 1, '退出登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (124, '', '登录', 1669972826077, 2, '登录失败');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (125, 'admin', '登录', 1669972842682, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (126, 'admin', '退出登录', 1669972848853, 1, '退出登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (127, 'zjh', '登录', 1679361615346, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (128, 'zjh', '登录', 1679361662101, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (129, 'zjh', '登录', 1679361694399, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (130, 'zjh', '登录', 1679362737638, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (131, 'zjh', '登录', 1679364034090, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (132, 'zjh', '登录', 1679366488133, 2, '登录成功');
INSERT INTO `tb_sys_log` (`id`, `username`, `operation`, `operation_time`, `status`, `result`) VALUES (133, 'zjh', '登录', 1680138710020, 2, '登录成功');
COMMIT;

-- ----------------------------
-- Table structure for tb_sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `tb_sys_menu`;
CREATE TABLE `tb_sys_menu` (
  `id` int(20) NOT NULL COMMENT '主键',
  `name` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '菜单名称',
  `permission` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '权限参数',
  `path` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '菜单路径',
  `icon` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '图标',
  `parent_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '父id',
  `sort` varchar(255) COLLATE utf8mb4_bin DEFAULT '0' COMMENT '排序值',
  `type` int(255) DEFAULT '1' COMMENT '类型1 菜单 2 按钮',
  `status` int(255) DEFAULT '1',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of tb_sys_menu
-- ----------------------------
BEGIN;
INSERT INTO `tb_sys_menu` (`id`, `name`, `permission`, `path`, `icon`, `parent_id`, `sort`, `type`, `status`, `create_time`) VALUES (1, '首页', 'home', '/home', 'icon-shouye', 0, '0', 1, 1, NULL);
INSERT INTO `tb_sys_menu` (`id`, `name`, `permission`, `path`, `icon`, `parent_id`, `sort`, `type`, `status`, `create_time`) VALUES (2, '系统管理', 'systemManger', '/systemManager', 'icon-ziyuanxhdpi', 0, '0', 1, 1, NULL);
INSERT INTO `tb_sys_menu` (`id`, `name`, `permission`, `path`, `icon`, `parent_id`, `sort`, `type`, `status`, `create_time`) VALUES (3, '用户管理', 'userManager', '/systemManager/userManager', NULL, 2, '0', 1, 1, NULL);
INSERT INTO `tb_sys_menu` (`id`, `name`, `permission`, `path`, `icon`, `parent_id`, `sort`, `type`, `status`, `create_time`) VALUES (4, '角色管理', 'roleManager', '/systemManager/roleManager', NULL, 2, '0', 1, 1, NULL);
INSERT INTO `tb_sys_menu` (`id`, `name`, `permission`, `path`, `icon`, `parent_id`, `sort`, `type`, `status`, `create_time`) VALUES (5, '日志管理', 'logManager', '/logManager', 'icon-rizhiguanli', 0, '0', 1, 1, NULL);
INSERT INTO `tb_sys_menu` (`id`, `name`, `permission`, `path`, `icon`, `parent_id`, `sort`, `type`, `status`, `create_time`) VALUES (6, '操作日志', 'operationManager', '/logManager/operationManager', NULL, 5, '0', 1, 1, NULL);
INSERT INTO `tb_sys_menu` (`id`, `name`, `permission`, `path`, `icon`, `parent_id`, `sort`, `type`, `status`, `create_time`) VALUES (7, '登录日志', 'loginLog', '/logManager/loginLog', NULL, 5, '0', 1, 1, NULL);
COMMIT;

-- ----------------------------
-- Table structure for tb_sys_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_sys_role`;
CREATE TABLE `tb_sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '角色名称',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `status` bigint(20) DEFAULT '1' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of tb_sys_role
-- ----------------------------
BEGIN;
INSERT INTO `tb_sys_role` (`id`, `name`, `create_time`, `status`) VALUES (1, 'zjh', 1636616761142, 9);
INSERT INTO `tb_sys_role` (`id`, `name`, `create_time`, `status`) VALUES (2, 'zjh', 1636616922457, 9);
INSERT INTO `tb_sys_role` (`id`, `name`, `create_time`, `status`) VALUES (3, '赵建华测试', 1636617040627, 9);
INSERT INTO `tb_sys_role` (`id`, `name`, `create_time`, `status`) VALUES (4, 'zjh', 1636617105671, 9);
INSERT INTO `tb_sys_role` (`id`, `name`, `create_time`, `status`) VALUES (5, 'zjh', 1636617228746, 9);
INSERT INTO `tb_sys_role` (`id`, `name`, `create_time`, `status`) VALUES (6, '测试菜单', 1637139148014, 1);
INSERT INTO `tb_sys_role` (`id`, `name`, `create_time`, `status`) VALUES (7, 'zjh', 1638781015105, 1);
INSERT INTO `tb_sys_role` (`id`, `name`, `create_time`, `status`) VALUES (8, 'zjh', 1638781030405, 1);
INSERT INTO `tb_sys_role` (`id`, `name`, `create_time`, `status`) VALUES (9, 'zjh', 1638781101119, 1);
INSERT INTO `tb_sys_role` (`id`, `name`, `create_time`, `status`) VALUES (10, 'zjh', 1638781125136, 1);
INSERT INTO `tb_sys_role` (`id`, `name`, `create_time`, `status`) VALUES (11, '赵建华测试', 1639810495877, 1);
INSERT INTO `tb_sys_role` (`id`, `name`, `create_time`, `status`) VALUES (12, '超级管理员', 1639921641585, 1);
COMMIT;

-- ----------------------------
-- Table structure for tb_sys_role_menu_relation
-- ----------------------------
DROP TABLE IF EXISTS `tb_sys_role_menu_relation`;
CREATE TABLE `tb_sys_role_menu_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '权限id',
  `create_time` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of tb_sys_role_menu_relation
-- ----------------------------
BEGIN;
INSERT INTO `tb_sys_role_menu_relation` (`id`, `role_id`, `menu_id`, `create_time`) VALUES (5, 4, 1, 1636617111954);
INSERT INTO `tb_sys_role_menu_relation` (`id`, `role_id`, `menu_id`, `create_time`) VALUES (6, 4, 2, 1636617111954);
INSERT INTO `tb_sys_role_menu_relation` (`id`, `role_id`, `menu_id`, `create_time`) VALUES (7, 4, 3, 1636617111954);
INSERT INTO `tb_sys_role_menu_relation` (`id`, `role_id`, `menu_id`, `create_time`) VALUES (8, 4, 4, 1636617111954);
INSERT INTO `tb_sys_role_menu_relation` (`id`, `role_id`, `menu_id`, `create_time`) VALUES (9, 5, 1, 1636617229081);
INSERT INTO `tb_sys_role_menu_relation` (`id`, `role_id`, `menu_id`, `create_time`) VALUES (10, 5, 2, 1636617229081);
INSERT INTO `tb_sys_role_menu_relation` (`id`, `role_id`, `menu_id`, `create_time`) VALUES (11, 5, 3, 1636617229081);
INSERT INTO `tb_sys_role_menu_relation` (`id`, `role_id`, `menu_id`, `create_time`) VALUES (12, 5, 4, 1636617229081);
INSERT INTO `tb_sys_role_menu_relation` (`id`, `role_id`, `menu_id`, `create_time`) VALUES (13, 6, 1, 1637139148038);
INSERT INTO `tb_sys_role_menu_relation` (`id`, `role_id`, `menu_id`, `create_time`) VALUES (14, 6, 5, 1637139148038);
INSERT INTO `tb_sys_role_menu_relation` (`id`, `role_id`, `menu_id`, `create_time`) VALUES (15, 6, 6, 1637139148038);
INSERT INTO `tb_sys_role_menu_relation` (`id`, `role_id`, `menu_id`, `create_time`) VALUES (16, 7, 1, 1638781015123);
INSERT INTO `tb_sys_role_menu_relation` (`id`, `role_id`, `menu_id`, `create_time`) VALUES (17, 7, 2, 1638781015123);
INSERT INTO `tb_sys_role_menu_relation` (`id`, `role_id`, `menu_id`, `create_time`) VALUES (18, 7, 3, 1638781015123);
INSERT INTO `tb_sys_role_menu_relation` (`id`, `role_id`, `menu_id`, `create_time`) VALUES (19, 7, 4, 1638781015123);
INSERT INTO `tb_sys_role_menu_relation` (`id`, `role_id`, `menu_id`, `create_time`) VALUES (20, 8, 1, 1638781030716);
INSERT INTO `tb_sys_role_menu_relation` (`id`, `role_id`, `menu_id`, `create_time`) VALUES (21, 8, 2, 1638781030716);
INSERT INTO `tb_sys_role_menu_relation` (`id`, `role_id`, `menu_id`, `create_time`) VALUES (22, 8, 3, 1638781030716);
INSERT INTO `tb_sys_role_menu_relation` (`id`, `role_id`, `menu_id`, `create_time`) VALUES (23, 8, 4, 1638781030716);
INSERT INTO `tb_sys_role_menu_relation` (`id`, `role_id`, `menu_id`, `create_time`) VALUES (24, 9, 1, 1638781101130);
INSERT INTO `tb_sys_role_menu_relation` (`id`, `role_id`, `menu_id`, `create_time`) VALUES (25, 9, 2, 1638781101130);
INSERT INTO `tb_sys_role_menu_relation` (`id`, `role_id`, `menu_id`, `create_time`) VALUES (26, 9, 3, 1638781101130);
INSERT INTO `tb_sys_role_menu_relation` (`id`, `role_id`, `menu_id`, `create_time`) VALUES (27, 9, 4, 1638781101130);
INSERT INTO `tb_sys_role_menu_relation` (`id`, `role_id`, `menu_id`, `create_time`) VALUES (28, 10, 1, 1638781125147);
INSERT INTO `tb_sys_role_menu_relation` (`id`, `role_id`, `menu_id`, `create_time`) VALUES (29, 10, 2, 1638781125147);
INSERT INTO `tb_sys_role_menu_relation` (`id`, `role_id`, `menu_id`, `create_time`) VALUES (30, 10, 3, 1638781125147);
INSERT INTO `tb_sys_role_menu_relation` (`id`, `role_id`, `menu_id`, `create_time`) VALUES (31, 10, 4, 1638781125147);
INSERT INTO `tb_sys_role_menu_relation` (`id`, `role_id`, `menu_id`, `create_time`) VALUES (34, 11, 5, 1639810589811);
INSERT INTO `tb_sys_role_menu_relation` (`id`, `role_id`, `menu_id`, `create_time`) VALUES (35, 11, 6, 1639810589811);
INSERT INTO `tb_sys_role_menu_relation` (`id`, `role_id`, `menu_id`, `create_time`) VALUES (36, 3, 1, 1639812758119);
INSERT INTO `tb_sys_role_menu_relation` (`id`, `role_id`, `menu_id`, `create_time`) VALUES (37, 3, 2, 1639812758119);
INSERT INTO `tb_sys_role_menu_relation` (`id`, `role_id`, `menu_id`, `create_time`) VALUES (38, 3, 3, 1639812758119);
INSERT INTO `tb_sys_role_menu_relation` (`id`, `role_id`, `menu_id`, `create_time`) VALUES (39, 3, 4, 1639812758119);
INSERT INTO `tb_sys_role_menu_relation` (`id`, `role_id`, `menu_id`, `create_time`) VALUES (40, 12, 1, 1639921641600);
INSERT INTO `tb_sys_role_menu_relation` (`id`, `role_id`, `menu_id`, `create_time`) VALUES (41, 12, 2, 1639921641600);
INSERT INTO `tb_sys_role_menu_relation` (`id`, `role_id`, `menu_id`, `create_time`) VALUES (42, 12, 3, 1639921641600);
INSERT INTO `tb_sys_role_menu_relation` (`id`, `role_id`, `menu_id`, `create_time`) VALUES (43, 12, 4, 1639921641600);
INSERT INTO `tb_sys_role_menu_relation` (`id`, `role_id`, `menu_id`, `create_time`) VALUES (44, 12, 5, 1639921641600);
INSERT INTO `tb_sys_role_menu_relation` (`id`, `role_id`, `menu_id`, `create_time`) VALUES (45, 12, 6, 1639921641600);
INSERT INTO `tb_sys_role_menu_relation` (`id`, `role_id`, `menu_id`, `create_time`) VALUES (46, 12, 7, 1639921641600);
COMMIT;

-- ----------------------------
-- Table structure for tb_sys_user_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `tb_sys_user_role_relation`;
CREATE TABLE `tb_sys_user_role_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(20) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of tb_sys_user_role_relation
-- ----------------------------
BEGIN;
INSERT INTO `tb_sys_user_role_relation` (`id`, `user_id`, `role_id`, `create_time`, `update_time`) VALUES (1, 6, 3, 1636708554045, 0);
INSERT INTO `tb_sys_user_role_relation` (`id`, `user_id`, `role_id`, `create_time`, `update_time`) VALUES (2, 5, 6, 1637139318735, 0);
INSERT INTO `tb_sys_user_role_relation` (`id`, `user_id`, `role_id`, `create_time`, `update_time`) VALUES (4, 9, 12, 1639921711052, NULL);
COMMIT;

-- ----------------------------
-- Table structure for tb_tag
-- ----------------------------
DROP TABLE IF EXISTS `tb_tag`;
CREATE TABLE `tb_tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(100) DEFAULT NULL COMMENT '标签名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='标签表';

-- ----------------------------
-- Records of tb_tag
-- ----------------------------
BEGIN;
INSERT INTO `tb_tag` (`id`, `name`) VALUES (1, '随笔');
INSERT INTO `tb_tag` (`id`, `name`) VALUES (4, '测试');
COMMIT;

-- ----------------------------
-- Table structure for tb_test
-- ----------------------------
DROP TABLE IF EXISTS `tb_test`;
CREATE TABLE `tb_test` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '测试主键id',
  `test` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of tb_test
-- ----------------------------
BEGIN;
INSERT INTO `tb_test` (`id`, `test`) VALUES (1, '2222');
INSERT INTO `tb_test` (`id`, `test`) VALUES (2, '23333');
COMMIT;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `avatar` varchar(200) DEFAULT NULL COMMENT '头像',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `des` varchar(100) DEFAULT NULL COMMENT '介绍',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `admin_type` bigint(20) NOT NULL DEFAULT '1' COMMENT '管理员类型',
  `update_time` bigint(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of tb_user
-- ----------------------------
BEGIN;
INSERT INTO `tb_user` (`id`, `username`, `password`, `avatar`, `email`, `des`, `create_time`, `admin_type`, `update_time`) VALUES (2, 'test', 'zjh', '/img/avatar/20180414165815.jpg', NULL, NULL, 20200626165508, 2, 1636111984303);
INSERT INTO `tb_user` (`id`, `username`, `password`, `avatar`, `email`, `des`, `create_time`, `admin_type`, `update_time`) VALUES (3, 'test2', 'd256d670b614b1f54cecfb3874c025f1', '/img/avatar/20180414165815.jpg', '12tycoding@11.com', NULL, 20200627165513, 3, NULL);
INSERT INTO `tb_user` (`id`, `username`, `password`, `avatar`, `email`, `des`, `create_time`, `admin_type`, `update_time`) VALUES (4, '123', 'd256d670b614b1f54cecfb3874c025f1', '/img/avatar/20180414165815.jpg', '123@11.com', NULL, 20200627165513, 1, NULL);
INSERT INTO `tb_user` (`id`, `username`, `password`, `avatar`, `email`, `des`, `create_time`, `admin_type`, `update_time`) VALUES (5, 'admin1', '123456', NULL, NULL, NULL, 20210916163149, 1, NULL);
INSERT INTO `tb_user` (`id`, `username`, `password`, `avatar`, `email`, `des`, `create_time`, `admin_type`, `update_time`) VALUES (6, 'zjh', '111111', NULL, NULL, NULL, NULL, 1, 1637134033508);
INSERT INTO `tb_user` (`id`, `username`, `password`, `avatar`, `email`, `des`, `create_time`, `admin_type`, `update_time`) VALUES (7, 'cscompany', '111111', '1', '111', '123123', 1639816153109, 1, NULL);
INSERT INTO `tb_user` (`id`, `username`, `password`, `avatar`, `email`, `des`, `create_time`, `admin_type`, `update_time`) VALUES (9, 'admin', '111111', '1', '111', '123123', 1639921711032, 1, NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
