<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="<c:url value='/resources/css/user/include/nav.css' />"  rel="stylesheet" type="text/css">

<jsp:include page="./nav_js.jsp" />


<nav>
	<div id="nav_wrap">
	
		<%
			Object object = session.getAttribute("loginedAdminMemberId");
			
			if(object != null) {
			String loginedAdminMemberId = String.valueOf(object);
		%>
			<div class="menu">
				<ul>
					<li><a href="<c:url value='/user/member/logoutConfirm' />">로그아웃</a></li>
					<li><a href="<c:url value='/user/menu/listupBooksForm'/>">메뉴 목록</a></li>
				</ul>
			
			</div>
			
		<%			
			} else {
		%>	
		
			<div class="menu">
				<ul>
					<li><a href="<c:url value='/user/member/loginForm' />">로그인</a></li>
					<li><a href="<c:url value='/user/member/createAccountForm' />">회원가입</a></li>
				</ul>
			
			</div>
		<%
			}
		
		%>
		
		<div class="search">
			<form 
				action="<c:url value='/user/menu/searchMenuConfirm' />"
				name="search_menu_form"
				method="get">
			<input type="text" name="m_name" placeholder="Enter the name of the menu you ar looking for.">
			<input type="button" value="search" onclick="searchMenuForm();">
			</form>
		</div>
	</div>
</nav>