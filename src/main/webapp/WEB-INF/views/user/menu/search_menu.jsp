<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page = "../../include/title.jsp" />

<link href="<c:url value='/resources/css/include/full_list_of_menu.css'/>"  rel="stylesheet" type="text/css" >

</head>
<body>

	<jsp:include page = "../../include/header.jsp" />
	
	<jsp:include page ="../include/nav.jsp" />


	<section>
		<div id="section_wrap">
			
			<div class="word">
				<h3>LISTUP MENU FORM</h3>
			
			</div>
		
			<div class="menu_list" >
				<table>
					<thead>
						<tr>
							<th>메뉴 이름</th>
							<th>메뉴 금액</th>
							<th>메뉴 여부</th>
						</tr>
					</thead>
					
					<tbody>
						<c:forEach var="item" items="${menuDtos}">
						<tr>
							<td>
							<c:url value='/menu/user/menuDetail' var='detail_url'>
								<c:param name="m_no" value="${item.m_no}" />
							</c:url>
							<a href="${detail_url}">${item.m_no}</a>
							</td>
							<td>${item.m_pay}</td>
							<td>
							<c:choose>
								<c:when test="${item.m_marketing eq '0'}"><c:out value='판매중' /></c:when>
								<c:when test="${item.m_marketing eq '1'}"><c:out value='판매 불가' /></c:when>
								<c:otherwise><c:out value='X' /></c:otherwise>
							</c:choose>
							</td>
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