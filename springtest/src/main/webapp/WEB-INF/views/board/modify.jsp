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
		<form method="post" action="<%=request.getContextPath()%>/board/modify">
			<input type="text" name="num" value="${board.num}" readonly>
			<br>
			<input type="text" name="title" value="${board.title}" >
			<br>
			<input type="text" name="writer" value="${board.writer}" readonly>
			<br>
			<input type="text" name="registerDate" value="${board.registerDate}" readonly>
			<br>
			<input type="text" name="views" value="${board.views}" readonly>
			<br>
			<textarea name="content")>
			${board.content}
			</textarea>
			<a href="<%=request.getContextPath()%>/board/list" type="button"><button>목록</button></a>
			<a href="<%=request.getContextPath()%>/board/register" type="button"><button>등록</button></a>
			<button>수정하기</button></a>
		</form>
	</c:if>
</c:if>