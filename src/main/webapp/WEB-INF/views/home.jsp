<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./top.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<style>

.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

.b-example-divider {
	height: 3rem;
	background-color: rgba(0, 0, 0, .1);
	border: solid rgba(0, 0, 0, .15);
	border-width: 1px 0;
	box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em
		rgba(0, 0, 0, .15);
}

.b-example-vr {
	flex-shrink: 0;
	width: 1.5rem;
	height: 100vh;
}

.bi {
	vertical-align: -.125em;
	fill: currentColor;
}

.nav-scroller {
	position: relative;
	z-index: 2;
	height: 2.75rem;
	overflow-y: hidden;
}

.nav-scroller .nav {
	display: flex;
	flex-wrap: nowrap;
	padding-bottom: 1rem;
	margin-top: -1px;
	overflow-x: auto;
	text-align: center;
	white-space: nowrap;
	-webkit-overflow-scrolling: touch;
}
</style>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/sidebars.css">
</head>
<body>
	<div id='menuSide'>
		<div class="flex-shrink-0 p-3 bg-white" style="width: 280px;">
			<a href="/"
				class="d-flex align-items-center pb-3 mb-3 link-dark text-decoration-none border-bottom">
				<svg class="bi pe-none me-2" width="30" height="40">
					<use xlink:href="#bootstrap" /></svg> <span class="fs-5 fw-semibold">공부노트</span>
			</a>
			<ul class="list-unstyled ps-0">
				<li class="mb-1">
					<button
						class="btn btn-toggle d-inline-flex align-items-center rounded border-0 collapsed"
						data-bs-toggle="collapse" data-bs-target="#home-collapse"
						aria-expanded="true">Home</button>
					<div class="collapse show" id="home-collapse">
						<ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
							<li><a href="#"
								class="link-dark d-inline-flex text-decoration-none rounded">Overview</a></li>
							<li><a href="#"
								class="link-dark d-inline-flex text-decoration-none rounded">Updates</a></li>
							<li><a href="#"
								class="link-dark d-inline-flex text-decoration-none rounded">Reports</a></li>
						</ul>
					</div>
				</li>
				<li class="mb-1">
					<button
						class="btn btn-toggle d-inline-flex align-items-center rounded border-0 collapsed"
						data-bs-toggle="collapse" data-bs-target="#dashboard-collapse"
						aria-expanded="false">Dashboard</button>
					<div class="collapse" id="dashboard-collapse">
						<ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
							<li><a href="#"
								class="link-dark d-inline-flex text-decoration-none rounded">Overview</a></li>
							<li><a href="#"
								class="link-dark d-inline-flex text-decoration-none rounded">Weekly</a></li>
							<li><a href="#"
								class="link-dark d-inline-flex text-decoration-none rounded">Monthly</a></li>
							<li><a href="#"
								class="link-dark d-inline-flex text-decoration-none rounded">Annually</a></li>
						</ul>
					</div>
				</li>
				<li class="mb-1">
					<button
						class="btn btn-toggle d-inline-flex align-items-center rounded border-0 collapsed"
						data-bs-toggle="collapse" data-bs-target="#orders-collapse"
						aria-expanded="false">Orders</button>
					<div class="collapse" id="orders-collapse">
						<ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
							<li><a href="#"
								class="link-dark d-inline-flex text-decoration-none rounded">New</a></li>
							<li><a href="#"
								class="link-dark d-inline-flex text-decoration-none rounded">Processed</a></li>
							<li><a href="#"
								class="link-dark d-inline-flex text-decoration-none rounded">Shipped</a></li>
							<li><a href="#"
								class="link-dark d-inline-flex text-decoration-none rounded">Returned</a></li>
						</ul>
					</div>
				</li>
				<li class="border-top my-3"></li>
				<li class="mb-1">
					<button
						class="btn btn-toggle d-inline-flex align-items-center rounded border-0 collapsed"
						data-bs-toggle="collapse" data-bs-target="#account-collapse"
						aria-expanded="false">Account</button>
					<div class="collapse" id="account-collapse">
						<ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
							<li><a href="#"
								class="link-dark d-inline-flex text-decoration-none rounded">New...</a></li>
							<li><a href="#"
								class="link-dark d-inline-flex text-decoration-none rounded">Profile</a></li>
							<li><a href="#"
								class="link-dark d-inline-flex text-decoration-none rounded">Settings</a></li>
							<li><a href="#"
								class="link-dark d-inline-flex text-decoration-none rounded">Sign
									out</a></li>
						</ul>
					</div>
				</li>
			</ul>
		</div>

		<div class="b-example-divider b-example-vr"></div>


	</div>
	<section></section>
	<div id="loginDV">


		<c:choose>
			<c:when test="${session_userid != null }">
				<div id="loginInfohome">
					${session_userid} 님 로그인 <br> <a href="logout">[로그아웃]</a>
				</div>
			</c:when>
			<c:otherwise>
				<form id="loginFrm" action="login" method="post">
					
					<table>
						<tr>
							<td>ID</td>
							<td><input type="text" id="id" name="id" /></td>
						</tr>
						<tr>
							<td>PASS</td>
							<td><input type="passowrd" id="pass" name="pass" /></td>
						</tr>
						<tr>
							<td colspan=2><input type="submit" value="로그인" /> <input
								type="button" value="신규가입"> <input
								name="${_csrf.parameterName}" type="hidden"
								value="${_crsf.token}"></td>
						</tr>
					</table>
				</form>
			</c:otherwise>
		</c:choose>

	</div>
	<div id="zzz">
		<table id="tbl">
			<tbody>
				<tr>
					<td colspan=2 align=center>실시간검색어</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
<script type="text/javascript">
	var getData;
	$.ajax({
		type : 'GET',
		url : "top10/js",
		dataType : "",
		success : function(data) {
			console.log('성공 - ', data);
			getData = data;
			for (let i = 0; i < data.length; i++) {
				console.log(data[i][0] + "/" + data[i][1]);
				var innerHtml = "";
				innerHtml += '<tr>';
				innerHtml += '    <td>' + data[i][0] + '</td>';
				innerHtml += '    <td>' + data[i][1] + '</td>';
				innerHtml += '</tr>';
				$('#tbl > tbody').append(innerHtml);
			}
		},
		error : function(xhr) {
			console.log('실패 - ', xhr);
		}
	});

	$
			.ajax({
				type : "GET",
				url : "http://openapi.seoul.go.kr:8088/6d4d776b466c656533356a4b4b5872/json/RealtimeCityAir/1/99",
				data : {},
				success : function(response) {
					//console.log(typeof (response));
					let mise_list = response["RealtimeCityAir"]["row"];
					//console.log(response["RealtimeCityAir"]["row"]);
					for (let i = 0; i < mise_list.length; i++) {
						let mise = mise_list[i];
						let gu_name = mise["MSRSTE_NM"];
						let gu_mise = mise["IDEX_MVL"];
						console.log(gu_name, gu_mise);
						//	var innerHtml = "";
						//	innerHtml += '<tr>';
						//	innerHtml += '    <td>' + gu_name + '</td>';
						//	innerHtml += '    <td>' + gu_mise + '</td>';
						//	innerHtml += '</tr>';
						//	$('#tbl > tbody').append(innerHtml);
					}
				}
			});
</script>
</html>