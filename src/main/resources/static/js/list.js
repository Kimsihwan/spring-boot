var action = '';
var url = '';
var type = '';
var bno = 0;
var startList = '${idx}';
var listSize = '${pagination.range}';

$(function() {	
	CreateBtn();
	ListLoad();
	SubmitBtn();
});

// 페이지 번호 클릭
function fn_pagination(page, range, rangeSize, searchType, keyword) {
	var url = "/list";
	url = url + "?page=" + page;
	url = url + "&range=" + range;

	location.href = url;
}

function ListLoad() {
	// 비동기 통신
	$.ajax({
		// URL 선언
		url : '/get_Board?page=' + page + '&range=' + range,		
		// GET 선언
		type : "POST",
		data : {
			'bno' : bno
		},
		// 오류시 알림창 띄우기
		error : function() {
			alert("통신실패!!!!");
		},
		// 성공시 매개변수로 result를 받음
		success : function(result) {
			console.log(result);
			$("#tbody").children().remove();
			var a = '';
			$.each(result, function(key, value) {				
				a += "<tr onclick=location.href='/detail/" + value.bno + "'>";
				a += '<td>' + value.bno + '</td>';
				a += '<td>' + value.subject + '</td>';
				a += '<td>' + value.writer + '</td>';
				a += '<td>' + FormatToUnixtime(value.reg_date) + '</td>';
				a += '</tr>';
			});
			$("#tbody").html(a);
		}
	});
};

function SubmitBtn() {
	// Modal의 Submit 버튼 클릭
	$("#modalSubmit").click(function() {

		if (action == 'create') {
			bno = 0;
			url = '/insertProc';
		}
		var data = {
			"subject" : $("#subject").val(),
			"writer" : $("#writer").val(),
			"content" : $("#content").val()
		};

		$.ajax({
			url : url,
			type : type,
			data : data
		});

		location.reload();
	});
};

function CreateBtn() {
	// 새 글 쓰기 버튼 클릭
	$("#createBtn").click(function() {
		action = 'create';
		type = 'POST'
		$("#modal-title").text("새 글 작성");
		$("#myModal").modal();
	});
};

function FormatToUnixtime(unixtime) {
	var u = new Date(unixtime);
	return u.getUTCFullYear() + '-' + ('0' + u.getUTCMonth()).slice(-2) + '-' + ('0' + u.getUTCDate()).slice(-2)
};