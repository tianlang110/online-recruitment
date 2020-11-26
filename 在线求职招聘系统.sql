create table user
(
	userid int  not null AUTO_INCREMENT,
	username varchar(20) not null,
	password varchar(120) not null,
	usertype int not null,
	constraint user_pk
		primary key (userid)
);

create unique index user_username_uindex
	on user (username);

create table seeker
(
    userid    int         not null
        primary key,
    name      varchar(20) not null,
    sex       varchar(2)  null,
    age       int         null,
    phone     varchar(20) null,
    email     varchar(30) null,
    education varchar(10) null,
    post      varchar(40) null,
    salary    varchar(20) null,
    resume varchar(60) null
);

create table company
(
	userid int not null,
	name varchar(40) not null,
	address varchar(60) null,
	introduction varchar(600) null,
	constraint company_pk
		primary key (userid)
);

create table admin
(
	userid int not null,
	name varchar(20) not null,
	constraint admin_pk
		primary key (userid)
);

create table post
(
	companyid int not null,
	postid int not null AUTO_INCREMENT,
	name varchar(20) not null,
	type varchar(20) null,
	salary varchar(20) null,
	requirement varchar(120) null,
	introduction varchar(300) null,
	constraint post_pk
		primary key (postid)
);

create table candidate
(
	seekerid int not null,
	postid int not null,
	id int not null AUTO_INCREMENT,
	time date null,
	state varchar(20) not null,
	constraint candidate_pk
		primary key (id)
);

create table recruit
(
	id int not null AUTO_INCREMENT,
	companyid int not null,
	seekerid int not null,
	time date null,
	state varchar(20) not null,
	constraint recruit_pk
		primary key (id)
);

create table jobfair
(
	id int not null AUTO_INCREMENT,
	name varchar(20) not null,
	time date null,
	address varchar(40) null,
	introduction varchar(400) null,
	constraint jobfair_pk
		primary key (id)
);

create table parttimejob
(
	id int not null AUTO_INCREMENT,
	name varchar(20) not null,
	phone varchar(20) null,
	address varchar(40) null,
	introduction varchar(400) null,
	constraint parttimejob_pk
		primary key (id)
);

insert into user(username,password,usertype) values('admin','$2a$10$yHpEcp4XYW5GMA.HQ.yaMuQ8gIAuuY2pfWk1Kymx.fZqV1UeYF79e',0);
insert into admin(userid, name) VALUES (1,'超级管理员');