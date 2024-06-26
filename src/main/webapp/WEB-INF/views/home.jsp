<%--
  Created by IntelliJ IDEA.
  User: nykim
  Date: 2022/12/13
  Time: 12:55 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>학사 정보 시스템</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/home.css" >
  </head>
  <body>
  <p class="maintext">학사 정보 시스템</p>
  <p> <a class="page1" href="${pageContext.request.contextPath}/creditByGrade"> 학년별 이수 과목 조회 </a></p>
  <p> <a class="page2" href="${pageContext.request.contextPath}/signUpCourse"> 수강신청 </a></p>
  <p> <a class="page3" href="${pageContext.request.contextPath}/courseInquiry"> 수강신청 과목 조회 </a></p>

  <c:if test="${pageContext.request.userPrincipal.name != null}">
    <a class="logouttext" href="javascript:document.getElementById('logout').submit()">로그아웃하기</a>
  </c:if>

  <form id="logout"  action="<c:url value="/logout" />"method="post">
    <input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}" />
  </form>

  </body>
</html>
