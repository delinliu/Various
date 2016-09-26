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
)

select * from contract;
select * from paynode;
select * from receivenode;