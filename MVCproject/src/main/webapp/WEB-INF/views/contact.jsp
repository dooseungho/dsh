<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
    <meta http-equiv="X-UA-Compatible" content="ie=edge"> 
    <title>게시글</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/contact.css">
</head>
<body>
    <header>
        <nav>
            <ul>
                <li>제육볶음</li>
                <li><a href="${pageContext.request.contextPath}/">홈</a></li>
                <li><a href="${pageContext.request.contextPath}/contact">문의하기</a></li>
            </ul>
            <ul>
                <c:choose>
                    <c:when test="${sessionScope.loggedInUser ne null}">
                        <li><a href="${pageContext.request.contextPath}/logout">로그아웃</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="${pageContext.request.contextPath}/login">로그인</a></li>
                        <li><a href="${pageContext.request.contextPath}/register">회원가입</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </nav>
        <div>
        </div>
    </header>
    <h2>문의하기</h2>
    <c:choose>
        <c:when test="${sessionScope.loggedInUser ne null}">
            <h3>${sessionScope.loggedInUser}님 안녕하세요!</h3>
        </c:when>
    </c:choose>
    <section>
        <table>
            <tr>
                <th>글번호</th>
                <th>작성자</th>
                <th>제목</th>
                <th>내용</th>
                <th>작성일</th>
                <th>조회수</th>
                <th>동작</th> 
            </tr>
            <!-- 문의글 목록 표시 -->
            <c:forEach items="${boards}" var="board">
                <tr>
                    <td>${board.bno}</td>
                    <td>${board.member_id}</td>
                    <td><a href="${pageContext.request.contextPath}/board/${board.bno}">${board.title}</a></td>
                    <td>${board.content}</td>
                    <td>${board.post_date}</td>
                    <td>${board.views}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/edit/${board.bno}">수정</a>
                        <form action="${pageContext.request.contextPath}/delete/${board.bno}" method="post">
                            <button type="submit">삭제</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <a href="${pageContext.request.contextPath}/write">글쓰기</a>
    </section>
</body>
</html>
