<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인</title>
</head>
<body>
    <header>
    </header>
    <section>
        <h2>로그인</h2>
        <form action="${pageContext.request.contextPath}/login" method="post">
            <label for="username">아이디:</label>
            <input type="text" id="username" name="username" required><br>
            <label for="password">비밀번호:</label>
            <input type="password" id="password" name="password" required><br>
            <button type="submit">로그인</button>
        </form>
    </section>
    <footer>
    </footer>
</body>
</html>
