<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page = "../../include/title.jsp" />

<link href="<c:url value='/resources/css/user/menu_detail.css' />"  rel="stylesheet" type="text/css">


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
								<td>메뉴명</td>
								<td>${userMenuDto.m_name}</td>
							</tr>
							<tr>
								<td>메뉴가격</td>
								<td>${userMenuDto.m_pay}</td>
							</tr>
							<tr>
								<td>메뉴여부</td>
								<td>${userMenuDto.m_marketing}</td>
							</tr>
							
							<tr>
								<td>등록일</td>
								<td>${userMenuDto.m_reg_date}</td>
							</tr>
							<tr>
								<td>수정일</td>
								<td>${userMenuDto.m_mod_date}</td>
							</tr>
						</table>
					</li>
				</ul>
							
			</div>
		
		
		</div>

		
	</section>
	
	<jsp:include page="../../include/footer.jsp" />
	
</body>
</html>