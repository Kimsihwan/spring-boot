<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<<script type="text/javascript">
var upbno = ${detail.bno};
console.log(bno);
</script>
<!-- Modal -->
<div class="modal fade" id="myModal" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">게시글 수정</h4>
			</div>
			<div class="modal-body">
				<table class="table">
					<tr>
						<td>글작성자</td>
						<td><input class="form-control" id="writer" type="text" value="${detail.writer}"></td>
					</tr>
					<tr>
						<td>제목</td>
						<td><input class="form-control" id="subject" type="text" value="${detail.subject}"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td><input class="form-control" id="contents" type="text" value="${detail.content}"></td>						
					</tr>					
				</table>
			</div>
			<div class="modal-footer">
				<button id="modalSubmit" type="button" class="btn btn-success">Submit</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>