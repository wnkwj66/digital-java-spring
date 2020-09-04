<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <form method="post" action="<%=request.getContextPath() %>/board/modify" enctype="multipart/form-data">
	<div class="form-group">
		<label>게시글 번호</label>
		<input type="text" class="form-control" name="num" value="${board.num}" >
	</div>
	<div class="form-group">
		<label>게시글 제목</label>
		<input type="text" class="form-control" name="title" value="${board.title}" >
	</div>
	<div class="form-group">
		<label>작성자</label>
		<input type="text" class="form-control" name="writer" value="${board.writer}" >
	</div>
	<div class="form-group">
		<label>작성일</label>
		<input type="text" class="form-control" name="registerDate" value="${board.registerDate}">
	</div>
	<div class="form-group">
		<label>조회수</label>
		<input type="text" class="form-control" name="views" value="${board.views}" >
	</div>
	<div class="form-group">
		<label>내용</label>
		<textarea class="form-control" rows="5" name="content">${board.content}</textarea>
	</div>
	<div class = "box-file">
		<c:if test="${board.file !=null }">
			<span>${board.oriFile}</span>
			<button type="button" id="btn-file-close"><i class="fas fa-times"></i></button>
		</c:if>
		<input type="hidden" name="file" value="${board.file}">
	</div>
	<div>
		<input type="file" name="file2">
	</div>
	
	<button>수정</button>
</form>
<script>
	$(function(){
		$('#btn-file-close').click(function(){
			$('.box-file').css('display','none');
			$('input[name=file]').val(''); // input태그의 name이 file인 애를 빈값으로 만들어줘라
		})
		$('input[name=file2]').change(function(){
			if($('input[name=file]').val() != ''){
				$(this).val('')
				alert('첨부파일을 추가하려면 기존 파일을 삭제해야합니다.')
			}
		})
	})
		
</script>
