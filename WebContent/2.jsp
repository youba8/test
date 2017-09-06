<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-2.14.min.js"></script>
<script type="text/javascript">
$(function(){
	$('#uname').on('input',function(){
		$.ajax({
			data:{'uname':$(this).val()},
			type:'GET',
			url:'/NewProject/checkemail.do',
			success:function(){
				if(data=='1'){
					$('span:first').html('12');
				}else if(data=='0'){
					$('span:first').html('123');
				}
			}
		})
		
	})
	
	
})
</script>
<title>Insert title here</title>
</head>
<body>
账号:<input type="text" id="uname"><span></span><br/>
密码:<input type="text" id="upassword">
</body>
</html>