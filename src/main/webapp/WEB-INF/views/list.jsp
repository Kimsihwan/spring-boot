<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="/js/list.js"></script>
<title>List</title>
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
						<button id="createBtn" type="button" class="btn btn-info btn-sm" data-toggle="modal">
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
							<tbody id="tbody">
							</tbody>
						</table>						
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="bootstrap.jsp"%>
	<%@ include file="modal.jsp"%>
</body>
</html>