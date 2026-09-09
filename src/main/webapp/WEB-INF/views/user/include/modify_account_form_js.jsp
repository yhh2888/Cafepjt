<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">

	function modifyAccountForm() {
		console.log('modifyAccountForm()');
		
		let form = document.modify_account_form;	
		if (form.u_m_pw.value == '') {
			alert('INPUT USER PW.');
			form.u_m_pw.focus();
			
		} else if (form.u_m_phone.value == '') {
			alert('INPUT USER PHONE.');
			form.u_m_phone.focus();
		
		} else {
			form.submit();
		}
		
	}

</script>