<%--
  Created by IntelliJ IDEA.
  User: nykim
  Date: 2024-03-20
  Time: 오후 4:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>로그인하기</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous"/>
</head>
<body>
<div class="container">
    <form class="form-signin" method="post" action="<c:url value="/login" />">
        <h2 class="form-signin-heading">Please sign in</h2>

        <c:if test="${not empty errorMsg}">
            <div style="color: #ff0000;"> <h5> ${errorMsg} </h5></div>
        </c:if>

        <c:if test="${not empty logoutMsg}">
            <div style="color: #0000ff;" > <h5> ${logoutMsg} </h5></div>
        </c:if>

        <p>
            <label for="username" class="sr-only">Username</label>
            <input type="text" id="username" name="username" class="form-control" placeholder="Username" required autofocus>
        </p>
        <p>
            <label for="password" class="sr-only">Password</label>
            <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
        </p>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"  />
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>
</div>
</body>

</html>

<!--"login.jsp"에서는 html폼 태그에서는 반드시 명시적으로 csrf 토큰을 보냄,
    but "signUoCourse.jsp"에서는 스프링 폼 태그를 이용해 토큰이 없음-->