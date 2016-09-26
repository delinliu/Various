drop database contract;
create database contract;

use contract;

create table contract_financial_flow_dict(
	id int auto_increment primary key,
    name varchar(128)
);
insert into contract_financial_flow_dict(name)
values ('收入'), ('支出');

create table contract_object_dict(
	id int auto_increment primary key,
    name varchar(128)
);
insert into contract_object_dict(name)
values ('产品'), ('软件'), ('设备'), ('文档'), ('服务');
insert into contract_object_dict(id, name) values(-1, '其他');

create table contract_funds_type_dict(
	id int auto_increment primary key,
    name varchar(128)
);
insert into contract_funds_type_dict(name)
values ('设计费'), ('外协费'), ('专用费'), ('事务费'), ('专家咨询费');

create table contract_departments_dict(
	id int auto_increment primary key,
    name varchar(128)
);
insert into contract_departments_dict(name)
values ('民机系统部'), ('民机管理部'), ('电子部'), ('软件部');

create table contract_currency_dict(
	id int auto_increment primary key,
    name varchar(128)
);
insert into contract_currency_dict(name)
values ('人民币'), ('美元'), ('欧元');
insert into contract_currency_dict(id, name) values(-1, 'N/A');

create table contract_archive_materials_dict(
	id int auto_increment primary key,
    name varchar(128)
);
insert into contract_archive_materials_dict(name)
values  ('供应商资质材料'), ('供应商选择报告'),
 ('合同谈判记录表'), ('合同预先评审表'), ('合同书面(或会议)评审意见表'),
 ('合同审批表'), ('合同');
insert into contract_archive_materials_dict(id, name) values(-1, '其他');

create table contract_pay_times_type_dict(
	id int auto_increment primary key,
    name varchar(128)
);
insert into contract_pay_times_type_dict(name)
values ('首付款'), ('进度款'), ('尾款'),
 ('一次性款项'), ('维保款');
 
create table contract_pay_times_pay_type_dict(
	id int auto_increment primary key,
    name varchar(128)
);
insert into contract_pay_times_pay_type_dict(name)
values ('挂账'), ('预付'), ('决算款');