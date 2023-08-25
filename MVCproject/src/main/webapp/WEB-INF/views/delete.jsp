<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시물 삭제</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/delete.css">
</head>
<body>
    <h2>게시물 삭제</h2>
    
    <c:if test="${board != null}">
        <p>다음 게시물을 삭제하시겠습니까?</p>
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
        </table>
        <form action="${pageContext.request.contextPath}/delete/${board.bno}" method="post">
            <button type="submit">삭제</button>
        </form>
        <p><a href="${pageContext.request.contextPath}/contact">뒤로가기</a></p>
    </c:if>
    
    <c:if test="${board == null}">
        <p>찾을 수 없습니다.</p>
    </c:if>
</body>
</html>
