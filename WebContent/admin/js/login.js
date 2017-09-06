$(function(){
	$('#login').dialog({
		width:400,
		length:200,
		collapsible:true,
		title:'用户登录',
		iconCls:'icon-man',
			button:[{
				text:'登录',
				iconCls:'icon-ok',
				handler:function()
				{
					var isValid=$('form');
					if(isValid){
						$.ajax({
							type:'psot',
							url:'/webproject/login.do',
							data:$('form').serialize(),
							success:function(data){
							if(data==1)
								{
								
								}else{
							 $.messager.alert('警告','警告消息');    
								}
							}
						})
					}
					}
			},{
				text:'退出',
				iconCls:'icon-cancel',
				handler:function()
				{
					
				}
				
			}]
	})
	
})