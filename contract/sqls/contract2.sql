drop database contract;
create database contract;

use contract;

create table contract(
	`ContractID` int auto_increment primary key,
    `Number` varchar(128),
    `Name` varchar(128),
    `FinancialFlow` int,
    `IsForeignContract` boolean,
    `Description` varchar(1024),
    `SubjectObjects` varchar(128),
    `SubjectObjectOther` varchar(128),
    `FundsType` int,
    `Departments` varchar(128),
    `Operator` varchar(128),
    `ProjectNumber` varchar(128),
    `BudgetNumber` varchar(128),
    `Money` varchar(128),
    `Currency` int,
    `StartDate` datetime,
    `EndDate` datetime,
    `TargetCompanyName` varchar(128),
    `ArchiveMaterials` varchar(128),
    `ArchiveMaterialOther` varchar(128)
);

create table paynode(
	`PayNodeID` int auto_increment primary key,
    `ContractID` int,
    `Type` int,
    `ExpectedMoney` varchar(128),
    `ExpectedCurrency` int,
    `PayCondition` varchar(128),
    `PayDate` datetime,
    `PayCredential` varchar(128),
    `ActualMoney` varchar(128),
    `ActualCurrency` int,
    `PayType` int,
    `CreatedTime` datetime default now(),
    `IsCredentialFiled` boolean,
    `Composition` varchar(128),
    foreign key (`ContractID`) references contract(`ContractID`)
);

create table receivenode(
	`ReceiveNodeID` int auto_increment primary key,
    `ContractID` int,
    `Type` int,
    `ExpectedMoney` varchar(128),
    `ExpectedCurrency` int,
    `ReceiveCondition` varchar(128),
    `ReceiveDate` datetime,
    `ActualMoney` varchar(128),
    `ActualCurrency` int,
    `InvoiceState` int,
    `InvoiceTime` datetime default now(),
    foreign key (`ContractID`) references contract(`ContractID`)
);

create table `account`(
	`AccountID` int auto_increment primary key,
    `Username` varchar(128) unique key,
    `Password` varchar(128),
    `Email` varchar(128)
);

create table `role`(
	`RoleID` int auto_increment primary key,
    `RoleName` varchar(128)
);

create table `account_role_rel`(
	`AccountID` int,
    `RoleID` int,
    foreign key (`AccountID`) references `account`(`AccountID`),
    foreign key (`RoleID`) references `role`(`RoleID`)
);

# 没有审核权限
insert into account(AccountID, Username, Password, Email)
values (1, 'delin', '123456', 'ldl434020@126.com');

# 全部权限
insert into account(AccountID, Username, Password, Email)
values (2, 'admin', '123456', null);

# 合同管理员
insert into account(AccountID, Username, Password, Email)
values (3, 'ContractMng1', '123456', null);
insert into account(AccountID, Username, Password, Email)
values (4, 'ContractMng2', '123456', null);

# 项目分管领导
insert into account(AccountID, Username, Password, Email)
values (5, 'ProjectMng1', '123456', null);
insert into account(AccountID, Username, Password, Email)
values (6, 'ProjectMng2', '123456', null);

insert into role(RoleID, RoleName)
values (1, 'ROLE_CONTRACT_MANAGER'), (2, 'ROLE_PROJECT_MANAGER');

insert into account_role_rel(AccountID, RoleID)
values (2, 1), (2, 2),
(3, 1), (4, 1),
(5, 2), (6, 2);

#select * from contract;
#select * from paynode;
#select * from receivenode;