<%--
  Created by IntelliJ IDEA.
  User: 82105
  Date: 2024-04-10
  Time: 오후 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>수강신청 확인</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/registeredCourse.css" >
</head>
<body>

<p class="checkCourseinput"> [${courseInquiry.sub_Name}] 과목이 수강신청되었습니다. </p>
<p> <a class="checkCourse" href="${pageContext.request.contextPath}/courseInquiry"> 수강신청 과목 보기</a> </p>
<p> <a class="addCourse" href="${pageContext.request.contextPath}/signUpCourse"> 추가 수강신청하기</a> </p>
</body>
</html>
