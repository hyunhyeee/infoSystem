<%--
  Created by IntelliJ IDEA.
  User: 82105
  Date: 2024-04-10
  Time: 오후 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>수강신청</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/signUpCourse.css" >
</head>
<body>
<p class="textinput">수강신청하기</p>
<sf:form method="post" action="${pageContext.request.contextPath}/registerCourse" modelAttribute="courseInquiry">
    <table class="formtable">
        <tr>
            <td class="label"> 년도:</td>
            <td><sf:input class="control" type="text" path="year"/> <br/>
                <sf:errors path="year" class="error" />
            </td>
        </tr>
        <tr>
            <td class="label"> 학기:</td>
            <td><sf:input class="control" type="text" path="semester"/> <br/>
                <sf:errors path="semester" class="error" />
            </td>
        </tr>
        <tr>
            <td class="label"> 과목코드:</td>
            <td><sf:input class="control" type="text" path="sub_Code"/> <br/>
                <sf:errors path="sub_Code" class="error" />
            </td>
        </tr>
        <tr>
            <td class="label"> 과목명:</td>
            <td><sf:input class="control" type="text" path="sub_Name"/> <br/>
                <sf:errors path="sub_Name" class="error" />
            </td>
        </tr>
        <tr>
            <td class="label"> 이수구분:</td>
            <td><sf:input class="control" type="text" path="sub_Classification"/> <br/>
                <sf:errors path="sub_Classification" class="error" />
            </td>
        </tr>
        <tr>
            <td class="label"> 교수명:</td>
            <td><sf:input class="control" type="text" path="professor"/> <br/>
                <sf:errors path="professor" class="error" />
            </td>
        </tr>
        <tr>
            <td class="label"> 학점:</td>
            <td><sf:input class="control" type="text" path="credit"/> <br/>
                <sf:errors path="credit" class="error" />
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="수강신청하기"/> </td>
        </tr>
    </table>
</sf:form>
</body>
</html>
