<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page="../../include/title.jsp" />

<link href="<c:url value='/resources/css/admin/search_menu.css' />" rel="stylesheet" type="text/css">

</head>
<body>

	<jsp:include page="../../include/header.jsp" />
	
	<jsp:include page="../include/nav.jsp" />
	
	<section>
	
		<div id="section_wrap">
			
			<div class="word">
			
				<h3>MENU SEARCH RESULTS</h3>
			
			</div>
			
			<div class="menu_list">
				
				<table>
					<thead>
						<tr>
							<th>메뉴 이름</th>
							<th>가격</th>
							<th>판매 여부</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${adminMenuDtos}">
						<tr>
							<td>
							<c:url value='/menu/admin/menuDetail' var='detail_url'>
								<c:param name="b_no" value="${item.m_no}"/>
							</c:url>
							<a href="${detail_url}">${item.m_name}</a>
							</td>
							<td>${item.m_pay}</td>
							<td>${item.m_marketing}</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				
			</div>
		
		</div>

	</section>
	
	<jsp:include page="../../include/footer.jsp" />

</body>
</html>