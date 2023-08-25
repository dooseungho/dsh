<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
</head>
<body>
    <header>
    </header>
    <section>
        <h2>회원가입</h2>
        <form action="${pageContext.request.contextPath}/register" method="post">
            <label for="username">아이디:</label>
            <input type="text" id="username" name="username" required><br>
            <label for="password">비밀번호(6글자이상):</label>
            <input type="password" id="password" name="password" required><br>
            <button type="submit">회원가입</button>
        </form>
    </section>
    <footer>
    </footer>
</body>
</html>
