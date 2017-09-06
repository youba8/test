window.onload=function(){
	
	document.querySelector('#check_user').onclick=function(){
		var uname=document.querySelector('#uname').value;
		var xmlhttp=new XMLHttpRequest();
		xmlhttp.open("get", "checkname.do?uname="+uname, true);
		xmlhttp.send(null);
		
		
		xmlhttp.onreadystatechange=function(){
			if(xmlhttp.readyState==4){
			if(xmlhttp.status==200){
				var date=xmlhttp.responseText;
				var sp=document.querySelector('#sp');
				if(date==1){
					sp.innerHTML('shibai');
				}else(date==0)
				{
					sp.innerHTML('chenggong');
				}
			}
		}
		}
			
	}		
}
		
	
