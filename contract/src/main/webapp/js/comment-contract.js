function initCommentTable() {
	$('#comment-td-3').attr('contenteditable', true);
	var commentType = getSearchArgs('comment-type');
	var td1 = '';
	var td2 = '';
	switch (commentType) {
	case '1':
		td1 = '合同预登记审批记录';
		td2 = '合同管理员审核意见';
		break
	case '2':
		td1 = '合同预登记审批记录';
		td2 = '项目分管领导审核意见';
		break
	case '3':
		td1 = '合同正式登记审批记录';
		td2 = '合同管理员审核意见';
		break
	case '4':
		td1 = '合同正式登记审批记录';
		td2 = '项目分管领导审核意见';
		break
	}
	$('#comment-td-1').text(td1);
	$('#comment-td-2').text(td2);
	$('#comment-td-3').focus()
} 

function initCommentListener() {
	$('#comment-button').off('click').on('click', submitComment);
}

function submitComment() {
	var comment = $('#comment-td-3').text();
	console.log(comment)
	if(!comment){
		alert('请填写审核意见再提交。')
	}
	$.ajax({
		url : '/contract/comment-contract',
		type : 'post',
		contentType : 'application/json',
		data : JSON.stringify({
			CommentType : getSearchArgs('comment-type'),
			ContractID : getLastPathFromUrl(),
			Comment : comment
		}),
		dataType : 'json',
		success : function(data) {
			console.log(data);
		}
	})
}