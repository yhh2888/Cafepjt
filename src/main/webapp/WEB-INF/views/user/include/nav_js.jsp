<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<script type="text/javascript">

	function searchMenuForm() {
		console.log('searchMenuForm() CALLED!!')
		
		let form = document.search_menu_form;
		if(form.m_name.value === '') {
			alert('Enter the name of menu you are looking for.')
			form.m_name.focus();
			
		} else {
			form.submit();
		}
		
	}


</script>    
