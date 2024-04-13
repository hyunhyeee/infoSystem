<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 82105
  Date: 2024-04-10
  Time: 오전 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>수강신청 내역</title>
</head>
<body>
<table border="1" width="800px" height="500px">
    <tr height="10%">
        <th width="10%">년도</th>
        <th width="5%">학기</th>
        <th width="20%">교과코드</th>
        <th width="30%">교과목명</th>
        <th width="10%">교과구분</th>
        <th width="20%">담당교수</th>
        <th width="5%">학점</th>
    </tr>
    <c:forEach items="${id_courseInquiries}" var="courseInquiry">
            <tr align="center" >
                <td><c:out value="${courseInquiry.year}" /></td>
                <td><c:out value="${courseInquiry.semester}" /></td>
                <td><c:out value="${courseInquiry.sub_Code}" /></td>
                <td><c:out value="${courseInquiry.sub_Name}" /></td>
                <td><c:out value="${courseInquiry.sub_Classification}" /></td>
                <td><c:out value="${courseInquiry.professor}" /></td>
                <td><c:out value="${courseInquiry.credit}" /></td>
            </tr>
    </c:forEach>
</table>
</body>
</html>
