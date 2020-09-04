<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
	  <div class="header">
        <div class="wrap">
            <div class="box-menu">
                <div class="top-menu">
                    <ul>
                        <li><a href="<%=request.getContextPath()%>/user/login">로그인</a></li>                                                    
                        <li><a href="<%=request.getContextPath()%>/user/signup">회원가입</a></li>
                        <li><a href="#">마이페이지</a></li>
                        <a href = "<%=request.getContextPath() %>/busForm">버스예매</a>"
                    </ul>
                </div>
                <div class="side-menu">
                    <h1>회원가입</h1>
                </div> 
            </div>
        </div>
    </div>
</nav>