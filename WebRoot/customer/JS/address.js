var hostpath=location.protocol+"//"+location.host+"/WatchWorld/"; //获取url根目录
$(document).ready(function(){
	getAddress();
});

function getAddress()
{
	$.ajax({
		type: "post",
		url: hostpath+"customer/address/getData",
		success: function(data)
		{
			$("#addressItem input").val(data);
		}
	});
}

function submitForm()
{
	$.ajax({
		type: "post",
		url: hostpath+"customer/address/saveData",
		data: $("#addressForm").serialize(),
		async: false,
		success: function(data)
		{
			alert(data);
		}
	});
}