<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/shopping.css">
</head>
<script>
	//비동기로
	//서버에게 요청 작성자를 파라미터로 보낼 테니 중복여부 확인해줘
	// 응답을 받아서
	// 등록된 사용자라면 vlaue=1로 바꾸는 코드를 짠다.
</script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<body>
	<div id="wrap" align="center">
		<h1>게시글 등록</h1>
		<form name="frm" method="post" action="bbswrAction"
			encType="multipart/form-data">
			<!--  encType을 적어 줘야만 첨부파일이 서버로 전송된다. -->
			<table>
				<tr>
					<th>작성자</th>
					<td><input type="text" id="id" name="name"> * 필수 
						<input type="button" id="chkname" value="등록여부확인"> 
						<input type="hidden" name="duplexChk" vlaue="0"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pass"> * 필수 (게시물 수정
						삭제시 필요합니다.)</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" size="70" name="title"> * 필수</td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea cols="70" rows="15" name="content"></textarea></td>
				</tr>

				<tr>
					<th>첨부파일</th>
					<td><input type="file" name="file"></td>
					<!-- 파일한개만 올리는 샘플. -->
				</tr>
				<tr>
					<th>첨부파일</th>
					<td><input type="file" name="file"></td>
					<!-- 파일한개만 올리는 샘플. -->
				</tr>
			</table>
			<br> <br> <input type="submit" value="등록"> <input
				type="reset" value="다시 작성"> <input type="button" value="목록"">
		</form>
	</div>
	<script type="text/javascript">
		//비동기로
		//서버에게 요청 작성자를 파라미터로 보낼 테니 중복여부 확인해줘
		// 응답을 받아서
		// 등록된 사용자라면 vlaue=1로 바꾸는 코드를 짠다. 

		/*	$(document).ready(function () {
		 $("#chkname").on("click", function () {
		 alert("aaa");
		 });
		 });*/
		// https://techislife.tistory.com/20
		$(document).ready(function() {
			$("#chkname").click(function() {
				
				var userid = $("#id").val();
				alert(userid);
				$.ajax({
					async : true,
					type : 'POST',
					data : {
						userid : userid,
						pwd : "1234"
					},
				//	data : JSON.stringify({ userid : userid,
				//	      	 pwd : "1234"}),
					url : "idcheck",
					dataType : "text",
				//	contentType: "application/json; charset=UTF-8",  //json으로 보낼때 서버도 맞춰야 함 @RequestBody
					success : function(data) {
						if (data > 0) {
							alert("아이디가 존재합니다. 다른 아이디를 입력해주세요.");
							/*     //아이디가 존제할 경우 빨깡으로 , 아니면 파랑으로 처리하는 디자인
							     $("#divInputId").addClass("has-error")
							     $("#divInputId").removeClass("has-success")
							     $("#userid").focus();*/
						} else {
							alert("사용가능한 아이디입니다.");
							//아이디가 존제할 경우 빨깡으로 , 아니면 파랑으로 처리하는 디자인
							/*    $("#divInputId").addClass("has-success")
							    $("#divInputId").removeClass("has-error")
							    $("#userpwd").focus();
							    //아이디가 중복하지 않으면  idck = 1 
							    idck = 1;*/
						}
					},
					error : function(error) {
						alert("error : " + error);
					}
				});

			});
		});

	</script>
</body>
</html>