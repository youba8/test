$(function(){
	$('#pagination').pagination({
		pageSize:5,
		firstBtnText:'首页',
		lastBtnText:'尾页',
		prevBtnText:'上一页',
		nextBtnText:'下一页',
		remote: {
			url:'pagination.do',
			totalName:'totalnumber',
		  	success:function(pageinfo){
		  		$('#content').empty();
		  		var ul="<ul>";
		  		$(pageinfo.data).each(function(goods){
		  			ul+="<li>" + goods.gtitle+"</li>";
		  		}) 
		  		ul+="</ul>";
		  		$('#content').append(ul);
		  	}
	  }
	  
});

	
})