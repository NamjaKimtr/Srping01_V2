<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<title>Home</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/main.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
	crossorigin="anonymous"></script>
</head>
<style>
body {
	font-size: 12px;
}
nav {
	width: 1280px;
	height: 30px;
	background-color: bisque;
	display: inline-block;
	/*  border: 5px solid;*/
	padding: 0px 0px 0px 0px;
	Box-sizing: border-box;
}
nav>ul {
	/*border: 5px solid;*/
	margin-top: 2px;
	list-style: none;
}
nav>ul>li {
	display: inline-block;
}
nav>ul>li>a {
	text-decoration-line: none;
}
nav>ul>li>a:hover {
	text-decoration-line: none;
	background-color: cadetblue;
}
nav>ul>li>a:visit {
	text-decoration-line: none;
	background-color: cadetblue;
}
#header_2{
	width: 800px;
	margin: 0 auto;
}
</style>
<body>
	<div id="titleDV">Kim Teacher HomePage</div>
	<header>
		<div id="header_2">
			<div class="input-group mb-3">
				<input type="text" class="form-control"
					placeholder="검색어를 입력하세요."
					aria-label="Recipient's username" aria-describedby="button-addon2">
				<button class="btn btn-outline-secondary" type="button"
					id="button-addon2">검색</button>
			</div>
		</div>
	</header>
	<nav>
		<nav class="navbar navbar-expand-lg bg-light">
			<div class="container-fluid">
				<a class="navbar-brand" href="#">심심공</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="/cafe/">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="bbswrForm">글쓰기</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="bbsList">글목록</a>
						</li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" role="button"
							data-bs-toggle="dropdown" aria-expanded="false"> Dropdown </a>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item" href="#">Action</a></li>
								<li><a class="dropdown-item" href="#">Another action</a></li>
								<li><hr class="dropdown-divider"></li>
								<li><a class="dropdown-item" href="#">Something else
										here</a></li>
							</ul></li>
						<li class="nav-item"><a class="nav-link disabled">Disabled</a>
						</li>
					</ul>
					<div id="logininfo">
						<!--<sec:authorize access="isAnonymous()">			
								<a href='<c:url value="loginPage"/>'>LOGIN</a> 로그인 해주세요.			
						</sec:authorize>-->
				
						<!--
						<c:if test="${session_userid != null }">
							Login user : ${session_userid} 님 로그인 
							<a href="logout">[로그아웃]</a>
						</c:if>
				  -->
						<!-- 		<c:choose>
							<c:when test="${session_userid != null }"> 
								Login user : ${session_userid}
								<a href="logout">[로그아웃]</a>
								<c:if test="${session_levels == 'ROLE_ADMIN'}">
									<a href="#">[사용자관리]</a>
								</c:if>
							</c:when>
							<c:otherwise> [로그인하세요] </c:otherwise>
						</c:choose> -->
				
						<sec:authorize access="isAuthenticated()">
							[${session_userid}]님  Login
							<a href="logout">[로그아웃]</a>
						</sec:authorize>
				
						<sec:authorize access="hasRole('ROLE_ADMIN')">
							<a href="#">[관리자]</a>
						</sec:authorize>
				
				
						<sec:authorize access="isAnonymous()">
							<a href='<c:url value="loginPage"/>'>LOGIN</a> 로그인 해주세요.			
						</sec:authorize>
					</div>
				</div>
			</div>
		</nav>
	</nav>


</body>
</html>
