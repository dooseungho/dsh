<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>글쓰기</title>
</head>
<body>
    <h2>글쓰기</h2>
    <form action="${pageContext.request.contextPath}/write" method="post">
        <label for="author">작성자:</label>
        <input type="text" id="author" name="author" value="${sessionScope.loggedInUser}" readonly><br>
        <label for="title">제목:</label>
        <input type="text" id="title" name="title" required><br>
        <label for="content">내용:</label>
        <textarea id="content" name="content" rows="5" cols="40" required></textarea><br>
        <button type="submit">작성하기</button>
    </form>
</body>
</html>
