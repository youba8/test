$(function(){
	$('#btnsave').on('click',function(){
		console.log($("#uemail").val());
		$.ajax({
			type:'post',
			data:$('#f1').serialize(),
			url:'/webproject/userservlet.do?type=add',
			success:function(data){
				if(data=="1")
					{
					alert("123");
					$('#add').dialog('close');
					$('#tab').datagrid('reload');
					}
			}
		})
		
	})
	$('#btncancel').on('click',function(){
		$('#add').dialog('close');
		
	})
	$('#tab').datagrid({
		url:'/webproject/userservlet.do?type=list',
		title:'用户信息',
		iconCls:'icon-ok',
		collapsible:true,
		rownumbers:true,
		rownumber:true,
		toolbar:[{
			text:'编辑',iconCls:'icon-edit',handler:function(){
				$('#add').dialog('open');
			}
		},'-',{
			text:'删除',iconCls:'icon-remove',handler:function(){
				//$.messager.alert('删除','实现删除功能','info');
				var row = $('#tab').datagrid('getSelected');
			
				if(row.uroleid=="377D0AE90A804D289F301FB085A6E9AA")
					{
					$.messager.alert('警告','管理员用户不能被删除'); 
					$('#tab').datagrid('clearSelections');
					} 
//				if (row) {
//			         var rowindex = $('#tab').datagrid('getRowIndex', row);
//			         $.messager.alert('删除',row.uloginid,'info');
//				         $('#tab').datagrid('deleteRow', rowIndex);  
//				 }
				$.ajax({
					type: "POST",
					url:'/webproject/removeservlet.do',
					data:{type:"del",userid:row.userid,uroleid:row.uroleid}, 
					 success:function(data){
			                if(data=="1"){
			                	
			                    $('#tab').datagrid('reload');
			                    
			                }else{
			                	{$.messager.alert('提示','删除失败');   }
			                }
			            }
				})
				
			}
		},'-',{
			text:'添加',iconCls:'icon-add',handler:function(){
				
				$('#add').dialog('open');
				$('#add').dialog({
					title:'修改用户',
				})
			}
		}],
		columns:[[{
			field:'chk',checkbox:true
		},{
			field:'userid',title:'编号'
		},{
			field:'uemail',title:'邮箱'
		},{
			field:'uloginid',title:'账号'
		},{
			field:'upassword',title:'密码'
		},{
			field:'utel',title:'电话'
		},{
			field:'usex',title:'性别'
		},{
			field:'ustateid',title:'状态编号'
		},{
			field:'uroleid',title:'角色编号'
		}]]
	})
})