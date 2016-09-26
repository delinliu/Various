<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link href="<%=request.getContextPath()%>/css/bootstrap.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/contract.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/list-contract.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/css/bootstrap-datetimepicker.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/bootstrap-table.css"
	rel="stylesheet">

<script src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script
	src="<%=request.getContextPath()%>/js/bootstrap-datetimepicker.js"
	charset="UTF-8"></script>
<script
	src="<%=request.getContextPath()%>/js/bootstrap-datetimepicker.zh-CN.js"
	charset="UTF-8"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap-table.js"
	charset="UTF-8"></script>
<script src="<%=request.getContextPath()%>/js/list-contracts.js"
	charset="UTF-8"></script>
</head>
<body>
	<div class="container text-center">
		<div class="row">
			<ul class="nav nav-pills nav-stacked col-md-2" role="tablist"
				style="padding-top: 50px">
				<li role="presentation"><a
					href="<%=request.getContextPath()%>/create-contract">新建合同登记表</a></li>
				<li role="presentation" class="active"><a
					href="<%=request.getContextPath()%>/list-contracts">查看合同登记表</a></li>
			</ul>
			<div class="text-center col-md-10">
				<h1>查看合同登记表</h1>
				<table id="contract-table">

				</table>
			</div>
		</div>
	</div>
</body>
</html>