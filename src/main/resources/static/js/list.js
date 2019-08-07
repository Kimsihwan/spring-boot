var action = '';
var url = '';
var type = '';
var bno = 0;

$(function() {
	CreateBtn();
	ListLoad();
	SubmitBtn();
});

function ListLoad() {
	// 비동기 통신
	$.ajax({
		// URL 선언
		url : "/data",
		// GET 선언
		type : "GET",
		// 오류시 알림창 띄우기
		error : function() {
			alert("통신실패!!!!");
		},
		// 성공시 매개변수로 result를 받음
		success : function(result) {
			// result의 크기만큼 돌려줌
			for ( var str in result) {
				// tr 태그를 생성해서 id에 tbody에 추가
				var tr = $("<tr></tr>").appendTo("#tbody");
				// tr에 td를 추가 후 내용을 데이터 값
				$("<td></td>").text(result[str]['bno']).appendTo(tr);
				$("<td></td>").text(result[str]['subject']).appendTo(tr);
				$("<td></td>").text(result[str]['writer']).appendTo(tr);
				$("<td></td>").text(FormatToUnixtime(result[str]['reg_date']))
						.appendTo(tr);
			}
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
	return u.getUTCFullYear() + '-' + ('0' + u.getUTCMonth()).slice(-2) + '-'
			+ ('0' + u.getUTCDate()).slice(-2)
};