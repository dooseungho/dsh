<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시물보기</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/detail.css">
</head>
<body>
    <h2>게시물 보기</h2>
    
    <c:if test="${board != null}">
        <table>
            <tr>
                <th>글번호</th>
                <td>${board.bno}</td>
            </tr>
            <tr>
                <th>제목</th>
                <td>${board.title}</td>
            </tr>
            <tr>
                <th>내용</th>
                <td>${board.content}</td>
            </tr>
            <tr>
                <th>작성일</th>
                <td>${board.post_date}</td>
            </tr>
            <tr>
                <th>조회수</th>
                <td>${board.views}</td>
            </tr>
        </table>
    </c:if>
    
    <c:if test="${board == null}">
        <p>찾을수없습니다</p>
    </c:if>
    
<!-- detail.jsp -->
<a href="${pageContext.request.contextPath}/edit/${board.bno}">
    <button>수정하기</button>
</a>

	 <a href="${pageContext.request.contextPath}/delete/${board.bno}">
        <button>삭제하기</button>
    </a>
	<p><a href="${pageContext.request.contextPath}/contact">뒤로가기</a></p>


</body>
</html>
