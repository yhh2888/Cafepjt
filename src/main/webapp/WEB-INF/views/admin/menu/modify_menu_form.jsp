<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page="../../include/title.jsp" />

<link href="<c:url value='/resources/css/admin/modify_menu_form.css' />" rel="stylesheet" type="text/css">

<jsp:include page="../include/modify_menu_form_js.jsp" />

</head>
<body>

	<jsp:include page="../../include/header.jsp" />
	
	<jsp:include page="../include/nav.jsp" />
	
	<section>
	
		<div id="section_wrap">
			
			<div class="word">
			
				<h3>MODIFY MENU FORM</h3>
			
			</div>
			
			<div class="modify_menu_form">
				
				<form
					action="<c:url value='/menu/admin/modifyMenuConfirm' />"
					name="modify_menu_form"
					method="post" 
					enctype="multipart/form-data"
					>
					
					<input type="hidden" name="m_no" value="${adminMenuDto.m_no}">
					
					<input type="text" name="m_name" value="${adminMenuDto.m_name}" placeholder="INPUT MENU NAME"><br>
					<input type="text" name="m_pay" value="${adminMenuDto.m_pay}" placeholder="INPUT MENU AUTHOR"><br>
					<input type="text" name="m_marketing" value="${adminMenuDto.m_marketing}" placeholder="INPUT MENU PUBLISHER"><br>
					<input type="file" name="file"><br>
					<input type="button" value="modify menu" onclick="modifyMenuForm();">
					<input type="reset" value="reset">
				</form>
				
			</div>
		
		</div>

	</section>
	
	<jsp:include page="../../include/footer.jsp" />

</body>
</html>