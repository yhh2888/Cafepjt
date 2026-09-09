<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">

	function createAccountForm() {
		console.log('createAccountForm()');
		
		let form = document.create_account_form;
		if (form.u_m_id.value == '') {
			alert('INPUT USER ID.');
			form.u_m_id.focus();
			
		} else if (form.u_m_pw.value == '') {
			alert('INPUT USER PW.');
			form.u_m_pw.focus();
			
		} else if (form.u_m_name.value == '') {
			alert('INPUT USER NAME.');
			form.u_m_name.focus();
			
		} else if (form.u_m_phone.value == '') {
			alert('INPUT USER PHONE.');
			form.u_m_phone.focus();
		
		} else {
			form.submit();
		}
		
	}

</script>
    