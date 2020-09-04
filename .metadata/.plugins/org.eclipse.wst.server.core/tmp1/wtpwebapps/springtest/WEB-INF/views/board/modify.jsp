<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:if test="${board eq null }">
	<h1>해당 게시물은 없는 게시물입니다.</h1>
</c:if>
<c:if test="${board ne null }">
	<c:if test="${board.isDel == 'Y'.charAt(0)}">
		<h1>해당 게시물은 삭제되었습니다.</h1>
	</c:if>
	<c:if test="${board.isDel == 'N'.charAt(0)}">
		<form method="post" action="<%=request.getContextPath()%>/board/modify" enctype="multipart/form-data">
			<div class="board-header detail">
				<span class="float-left">작성자:${board.writer}</span>
				<span>${board.registerDate}</span>
				<span class="float-right">조회:${board.views}</span>
			</div>
			<div class="board-title detail form-group">
				<input value="${board.title}" class="form-control" name="title">
			</div>
			<div class="board-content detail form-group">
				<textarea class="form-control modify" name="content">${board.content}</textarea>
			</div>
			<c:if test="${board.file != null }">
				<div class="board-file detail form-group">
					<span class="file-name">${board.oriFile}</span>
					<span class="btn-file-del"><i class="fas fa-times"></i></span>
					<input type="hidden" name="file" value="${board.file}">
				</div>
			</c:if>
			<div class="float-right btn-groups">
				<a href="<%=request.getContextPath()%>/board/list"><button class="btn btn-outline-success" type="button">목록</button></a>
				<a href="#"><button class="btn btn-outline-success">수정</button></a>
			</div>
			<div class="board-add-file detail form-group">
				<input type="file" name="file2">
			</div>
			
			<input type="hidden" name="num" value="${board.num}" readonly>
			<input type="hidden" name="writer" value="${board.writer}" readonly>
			<input type="hidden" name="registerDate" value="${board.registerDate}" readonly>
			<input type="hidden" name="views" value="${board.views}" readonly>
		</form>
	</c:if>
</c:if>
<script>
	$(function(){
		$('.btn-file-del').click(function(){
			$('.board-file').empty();
		})
		$('input[name=file2]').change(function(){
			if($('input[name=file]').val()=='' ||
				$('input[name=file]').val()== null ||
				typeof ($('input[name=file]').val())=='undefined')
				return;
			$(this).val('');
			alert('첨부파일은 하나만 등록가능합니다.')
		})
	})
</script>