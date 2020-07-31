<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div class="form-group">
		<div>${board.title}
			<div class="float-control">${board.writer}
			| ${board.registerDate}
			<span class="float-right">조회 ${board.views}</span>
			</div>
		</div>
		<div class="form-control">${board.content}</div>
		<a href="<%=request.getContextPath()%>/board/register"><button>글쓰기</button></a>
</div>
