<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 게시판</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/view.css">
</head>
<body>
board_re_ref : ${article.board_re_ref}<br>
board_re_lev : ${article.board_re_lev}<br>
board_re_seq : ${article.board_re_seq}<br>

	<!-- 게시판 수정 -->
	<section id="articleForm">
		<h2>글 내용 상세보기</h2>
		<section id="basicInfoArea">
			제 목 : ${article.board_subject}
		</section>
		<section id="fileForm">
			첨부파일 :
			<c:if test="${article.board_file ne null }">
				<a href="fileDownload.do?file_name=${article.board_file}">${article.board_file}</a>
			</c:if>			
		</section>
		<section id="articleContentArea">${article.board_content }</section>
	</section>
	<section id="commandList">
														<!-- &page=${page} 없으면 목록에서 1번으로 돌아감 -->
		<a href="boardReplyForm.do?board_num=${article.board_num}&page=${page}">[답변]</a>
		<a href="boardModifyForm.do?board_num=${article.board_num}&page=${page}">[수정]</a>
		<a href="boardDeleteForm.do?board_num=${article.board_num}&page=${page}">[삭제]</a>
		<a href="boardList.do?page=${page}">[목록]</a>&nbsp;&nbsp;
	</section>
</body>
</html>