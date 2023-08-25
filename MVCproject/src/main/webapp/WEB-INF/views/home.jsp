<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Main Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/home.css">
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
        <h2>메인페이지
         <c:choose>
        <c:when test="${sessionScope.loggedInUser ne null}">
            <h3>${sessionScope.loggedInUser}님 안녕하세요!</h3>
        </c:when>
    </c:choose>
        </h2>
    <c:if test="${not empty param.successMessage}">
        <script type="text/javascript">
            alert("${param.successMessage}");
        </script>
    </c:if>
  <section>
    <h2>맛있는 제육볶음</h2>
      <table>
        <tr>
            <td>
   		     
                <img src="https://as2.ftcdn.net/v2/jpg/05/03/84/63/1000_F_503846375_nlWRuEOishlgOk0W5d5anaZrUC13HZWd.jpg" alt="상품 이미지">
                <p>달콤한 제육볶음</p>
                <p>7000 원</p>
            </td>
            <td>
              
                <img src="https://i.namu.wiki/i/wH3sFo1pf9_OpgpBA5ARLa6QWgN5Ll1bI57Oa9X1gemY7fpMv9y0drc2vsevGs93W-JXt8ICa1zr8_20QO2zUb79h1FuXs2UpP8dMQp3YQ1oVcOUqVNyPCclrJH-QUZRWMUIFo2oCsvOXylv-DgQng.webp" alt="상품 이미지">
                <p>매콤한 제육볶음</p>
                <p>6000 원</p>
            </td>
            <td>

                <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b1/Larimichthys_polyactis.jpg/450px-Larimichthys_polyactis.jpg" alt="상품 이미지">
                <p>생선</p>
                <p>3000 원</p>
            </td>
        </tr>
    </table>
</section>	
</body>
</html>
