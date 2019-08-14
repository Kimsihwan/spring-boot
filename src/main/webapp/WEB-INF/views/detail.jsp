<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="/js/comment.js"></script>
<title>Detail</title>
<script>var bno = '${detail.bno}';</script>
</head>
<body>
	<h2>게시글 상세</h2>
	<div class="container">
		<form action="/insertProc" method="post">
			<div class="form-group">
				<label>게시글 번호</label>
				<p>${detail.bno}</p>
			</div>
			<div class="form-group">
				<label>제목</label>
				<p>${detail.subject}</p>
			</div>
			<div class="form-group">
				<label>작성자</label>
				<p>${detail.writer}</p>
			</div>
			<div class="form-group">
				<label>작성날짜</label>
				<p>${detail.reg_date}</p>
			</div>
			<div class="form-group">
				<label>내용</label>
				<p>${detail.content}</p>
			</div>
		</form>
		<div class="btn-group btn-group-sm" role="group" style="float: right;">
			<button type="button" class="btn btn-default" onclick="location.href='/delete/${detail.bno}'">삭제</button>
			<button id="updateBtn" type="button" class="btn btn-default" data-toggle="modal">수정</button>
			<button class="btn btn-primary" onclick="location.href='/update/${detail.bno}'">모달아님수정</button>
			<button type="button" class="btn btn-default" onclick="location.href='/list'">목록</button>
		</div>
	</div>
	<div class="container">
		<label for="content">comment</label>
		<form name="commentInsertForm">
			<div class="input-group">
				<input type="hidden" name="bno" value="${detail.bno}" /> <input type="text" class="form-control" id="content" name="content" placeholder="내용을 입력하세요."> <span class="input-group-btn">
					<button class="btn btn-default" type="button" id="commentInsertBtn" name="commentInsertBtn">등록</button>
				</span>
			</div>
		</form>
	</div>
	<div class="container">
		<div class="commentList"></div>
	</div>

	<%@ include file="bootstrap.jsp"%>
	<%@ include file="update.jsp"%>
</body>
</html>
