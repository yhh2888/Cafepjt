<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page="../../include/title.jsp" />

<link href="<c:url value='/resources/css/admin/menu_detail.css' />" rel="stylesheet" type="text/css">

<jsp:include page="../include/menu_detail_js.jsp" />

</head>
<body>

	<jsp:include page="../../include/header.jsp" />
	
	<jsp:include page="../include/nav.jsp" />
	
	<section>
	
		<div id="section_wrap">
			
			<div class="word">
			
				<h3>MENU DETAIL</h3>
			
			</div>
			
			<div class="menu_detail">
				<ul>
					<li>
						<table>
							<tr>
								<td>메뉴 이름</td>
								<td>${adminMenuDto.m_name}</td>
							</tr>
							<tr>
								<td>가격</td>
								<td>${adminMenuDto.m_pay}</td>
							</tr>
							<tr>
								<td>판매 여부</td>
								<td>${adminMenuDto.m_marketing}</td>
							</tr>
							<tr>
								<td>등록일</td>
								<td>${adminMenuDto.m_reg_date}</td>
							</tr>
							<tr>
								<td>수정일</td>
								<td>${adminMenuDto.m_mod_date}</td>
							</tr>
						</table>
					</li>
				</ul>
			</div>
			
			<div class="buttons">
				<c:url value='/menu/admin/modifyMenuForm' var='modify_url'>
					<c:param name="b_no" value="${adminMenuDto.m_no}"/>
				</c:url>
				<a href="${modify_url}">메뉴수정</a>
				<a href="#none" onclick="deleteMenu(${adminMenuDto.m_no}, '${adminMenuDto.m_name}');">메뉴삭제</a>				
			</div>
		
		</div>

	</section>
	
	<jsp:include page="../../include/footer.jsp" />

</body>
</html>