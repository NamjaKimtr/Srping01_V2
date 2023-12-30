<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>

	<table id="tbl">
	<thead>
		<td>지역이름</td>
		<td>미세먼지</td>
	</thead>
	<tbody id="tbody">
	
	</tbody>
		
	
	</table>

</body>
<script>
	$
			.ajax({
				type : "GET",
				url : "http://openapi.seoul.go.kr:8088/6d4d776b466c656533356a4b4b5872/json/RealtimeCityAir/1/99",
				data : {},
				success : function(response) {
					console.log(typeof(response));
					let mise_list = response["RealtimeCityAir"]["row"];
					console.log(response["RealtimeCityAir"]["row"]);
					
					for (let i = 0; i < mise_list.length; i++) {
						let mise = mise_list[i];
						let gu_name = mise["MSRSTE_NM"];
						let gu_mise = mise["IDEX_MVL"];
						console.log(gu_name, gu_mise);
						
						var innerHtml="";
						innerHtml += '<tr>';
						innerHtml += '    <td>'+gu_name+'</td>';
						innerHtml += '    <td>'+gu_mise+'</td>';
						innerHtml += '</tr>';						
						$('#tbl > tbody').append(innerHtml);						
					}
				}
			});
</script>
</html>