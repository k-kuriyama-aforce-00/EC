var $j = jQuery.noConflict();


function addTocart(event, form){
	event.preventDefault();
	
	var productId = form.productId.value;
	var purchaseNumber = form.purchaseNumber.value;
	$j.ajax({
		type:'POST',
		url:'../jp.co.aforce/cartin',
		data:{productId: productId, purchaseNumber:purchaseNumber},
		success:function(response){
			alert('カートに追加されました')
		},
		error: function(xhr, status, error){
			alert("カートにアイテムを追加できませんでした。");
		}
	});
}

