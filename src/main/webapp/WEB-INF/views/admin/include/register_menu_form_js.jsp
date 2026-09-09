<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">

	function registerMenuForm() {
		console.log('registerMenuForm() CALLED!!');
		
		let form = document.register_menu_form;
		
		if (form.m_name.value === '') {
			alert('INPUT MENU NAME');
			form.m_name.focus();
			
		} else if (form.m_pay.value === '') {
			alert('INPUT MENU PAY');
			form.m_pay.focus();
			
		} else if (form.m_marketing.value === '') {
			alert('INPUT MENU MARKETING');
			form.m_marketing.focus();
			
		} else {
		    console.log(form.m_name.value);
		    console.log(form.m_pay.value);
		    console.log(form.m_marketing.value);
			form.submit();
			
		}
		
	}

</script>