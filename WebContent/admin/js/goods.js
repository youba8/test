$(function(){
	$('#cate').combobox({
		url:'/webproject/cate.do',
		valueField:'cid',
		textField:'cname',  
		onSelect:function(data){
			
		},
		onLoadSuccess:function(){
			var datas=$(this).combobox('getData');
			$(this).combobox('setValues',datas[0].cid);
			var cid=$(this).combobox('getValues')
			alert("123");
			loadGoods();
		},
	});
})
function loadGoods(){
	$('#tb').datagrid({
		
//		    url:'/webproject/good.do',
//			queryParams:{cid:cid},
//			title:'商品数据展示',
//			iconCls: 'icon-ok',
//            pagination:true,
//            columns:[[{
//    			field:'chk',checkbox:true
//    		},{
//    			field:'gid',title:'编号'
//    		},{
//    			field:'gtitle',title:'书名'
//    		},{
//    			field:'gauthor',title:'作者'
//    		},{
//    			field:'gsaleprice',title:'原价'
//    		},{
//    			field:'ginprice',title:'现价'
//    		},{
//    			field:'gclicks',title:'点击量'
//    		},{
//    			field:'gid',title:'状态编号'
//    		},{
//    			field:'cid',title:'角色编号'
//    		}]]
		
		
	})
}