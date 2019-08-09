<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>List</title>
<script>
	// 이전 버튼 이벤트
	function fn_prev(page, range, rangeSize) {
		var page = ((range - 2) * rangeSize) + 1;
		var range = range - 1;
		
		var url = "${pageContext.request.contextPath}/list";
		url = url + "?page=" + page;
		url = url + "&range=" + range;
		
		location.href = url;
	}
	
	// 페이지 번호 클릭
	function fn_pagination(page, range, rangeSize, searchType, keyword) {
		var url = "${pageContext.request.contextPath}/list"; 
		url = url + "?page=" + page;
		url = range + "?range=" + range;
		
		location.href = url;
	}
	
	// 다음 버튼 이벤트
	function fn_next(page, range, rangeSize) {
		sdadsa
	}
</script>
</head>
<body>
	<div class="page-wrapper">
		<div class="container-fluid">
			<!-- 게시판 넓이 -->
			<div class="col-lg-8">
				<div class="col-lg-12">
					<h1 class="page-header">게시판 관리</h1>
				</div>
				<div class="row">
					<div class="col-lg-12">
						<button type="button" class="btn btn-outline btn-primary pull-right" onclick="location.href='/insert'">
							<i class="fa fa-edit fa-fw"></i> 게시글 작성
						</button>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">게시글</div>
					<div class="panel-body">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>No</th>
									<th>Subject</th>
									<th>Writer</th>
									<th>Date</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="l">
									<tr onclick="location.href='/detail/${l.bno}'">
										<td>${l.bno}</td>
										<td>${l.subject}</td>
										<td>${l.writer}</td>
										<td>
											<fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${l.reg_date}" />
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="bootstrap.jsp"%>
</body>
</html>