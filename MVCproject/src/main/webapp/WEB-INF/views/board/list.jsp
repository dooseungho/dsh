<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시판 목록</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/home.css">
</head>
<body>
    <header>
        <nav>
            <ul>
                <li>제육볶음</li>
                <li>홈</li>
                <li>문의하기</li>
            </ul>
        </nav>
        <div>
            <%-- 로그인/회원가입/로그아웃 버튼 및 세션 처리 --%>
        </div>
    </header>
    <section>
        <table>
            <tr>
                <th>글번호</th>
                <th>제목</th>
                <th>내용</th>
                <th>작성자</th>
                <th>작성일</th>
                <th>조회수</th>
            </tr>
            <%-- 문의글 목록 표시 --%>
            <c:forEach items="${boards}" var="board">
                <tr>
                    <td>${board.bno}</td>
                    <td>${board.title}</td>
                    <td>${board.content}</td>
                    <td>${board.member_id}</td>
                    <td>${board.post.date}</td>
                    <td>${board.views}</td>
                </tr>
            </c:forEach>
        </table>
        <button>글쓰기</button>
        <%-- 페이지 번호 표시 --%>
    </section>
</body>
</html>
