<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>게시판</h1>
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>조회수</th>
      </tr>
    </thead>
	<tbody>	
	<c:forEach var="board" items="${list}">
	     <tr>
	       <td>${board.num}</td>
	       <td><a href="<%=request.getContextPath()%>/board/detail?num=${board.num}&page=${pm.criteria.page}&type=${pm.criteria.type}&search=${pm.criteria.search}">${board.title}</a></td>
	       <td>${board.writer}</td>
	       <td>${board.registerDate}</td>
	       <td>${board.views}</td>
	     </tr>
     </c:forEach>
     
   </tbody>
   <a href="<%=request.getContextPath()%>/board/register"><button>글쓰기</button></a>
 </table>