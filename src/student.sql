CREATE DATABASE IF NOT EXISTS student;
USE student;
-- 管理员
drop table if exists admin;
create table admin (
    username varchar(100) not null primary key comment '用户名',
    password varchar(100) not null comment '密码',
    realname varchar(20) not null comment '真实姓名',
    sex char(1) not null comment '性别',
    create_time datetime not null comment '创建时间'
) comment '管理员';

insert into admin(username, password, realname, sex, create_time) values ('admin', 'admin', '管理员', '男', '2024-10-27 10:52:34');

-- 学生
drop table if exists student;
create table student (
    no varchar(50) not null primary key comment '学号',
    name varchar(20) not null comment '姓名',
    password varchar(50) not null comment '密码',
    address varchar(50) not null comment '家庭住址',
    nationality varchar(10) not null comment '民族',
    department varchar(20) not null comment '院系',
    major varchar(20) not null comment '专业',
    classes varchar(20) not null comment '班级',
    in_date date not null comment '入学日期',
    create_time datetime not null comment '创建时间'
) comment '学生';
INSERT INTO student(no, name, password, address, nationality, department, major, classes, in_date, create_time) VALUES('S001', '张三', '123456', '北京', '汉族', '计算机学院', '计算机科学与技术', '1班', '2023-09-01', '2024-11-25 00:00:00');
INSERT INTO student(no, name, password, address, nationality, department, major, classes, in_date, create_time) VALUES('S002', '李四', '123456', '上海', '汉族', '电子工程学院', '电子信息工程', '2班', '2023-09-01', '2024-11-25 00:00:00');
INSERT INTO student(no, name, password, address, nationality, department, major, classes, in_date, create_time) VALUES('S003', '王五', '123456', '广州', '汉族', '经济管理学院', '经济学', '3班', '2023-09-01', '2024-11-25 00:00:00');
INSERT INTO student(no, name, password, address, nationality, department, major, classes, in_date, create_time) VALUES('S004', '赵六', '123456', '深圳', '汉族', '法学院', '法学', '4班', '2023-09-01', '2024-11-25 00:00:00');
INSERT INTO student(no, name, password, address, nationality, department, major, classes, in_date, create_time) VALUES('S005', '钱七', '123456', '杭州', '汉族', '外国语学院', '英语', '5班', '2023-09-01', '2024-11-25 00:00:00');
