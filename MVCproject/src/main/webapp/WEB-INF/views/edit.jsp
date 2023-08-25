<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시물 수정</title>
</head>
<body>
    <h2>게시물 수정</h2>
    
    <form action="${pageContext.request.contextPath}/update/${board.bno}" method="post">
        <label for="title">제목:</label>
        <input type="text" id="title" name="title" value="${board.title}">
        <br>
        <label for="content">내용:</label>
        <textarea id="content" name="content">${board.content}</textarea>
        <br>
        <input type="submit" value="수정">
    </form>
    
    <p><a href="${pageContext.request.contextPath}/detail/${board.bno}">돌아가기</a></p>
</body>
</html>
