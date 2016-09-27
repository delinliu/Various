$(function() {
	getContractsFromServer();
});

function getContractsFromServer() {
	$.ajax({
		url : '/contract/get-contracts',
		success : function(data) {
			showContracts(data);
		}
	})
}

function showContracts(data) {
	var contracts = data.value;
	$('#contract-table').bootstrapTable({
		columns : [ {
			title : '合同编号',
			field : 'Number'
		}, {
			title : '合同名称',
			field : 'Name'
		}, {
			title : '经办人',
			field : 'Operator'
		}, {
			title : '操作',
			field : 'process',
			formatter : contractProcess,
			events : window.operateEvents = {
				'click .contract-view' : viewContract,
			}
		} ],
		classes : 'table',
		striped : 'true',
	}).bootstrapTable('load', contracts);
}

function contractProcess(value, row, index) {
	return '<span class="operator-wrapper contract-view">查看</span>' 
		+ '<span class="operator-wrapper contract-view">审核</span>';
}

function viewContract(e, value, row, index) {
	console.log(row);
	location.href = '/contract/view-contract/' + row['ContractId'];
}