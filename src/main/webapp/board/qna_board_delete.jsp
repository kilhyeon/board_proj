<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/delete.css">
</head>
<body>
<%-- 	${page }
	<br>${board_num } --%>

	<section id="passForm">
		<form name="deleteForm" action="boardDeletePro.do?board_num=${board_num }" method="post">
			<input type="hidden" name="page" value=${page } />
				<ul>
					<li id="pass">
						<label>글 비밀번호 : </label>
						<input name="BOARD_PASS" type="password">
					</li>
					<li id="btn">
						<input type="submit" value="삭제" />&nbsp;&nbsp;
						<input type="button" value="돌아가기" onClick="javascript:history.go(-1)" />
					</li>
				</ul>
		</form>
	</section>

</body>
</html>