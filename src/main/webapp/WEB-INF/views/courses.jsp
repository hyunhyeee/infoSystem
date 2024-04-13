<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 82105
  Date: 2024-04-12
  Time: 오후 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>학년별 이수 과목 조회</title>
</head>
<body>
<table border="1" width="700px" height="300px">
    <tr height="25%">
        <th width="25%">년도</th>
        <th width="20%">학기</th>
        <th width="20%">취득학점</th>
        <th width="35%">상세보기</th>
    </tr>
    <tr align="center" height="20%">
        <td>2023</td>
        <td>1</td>
        <td>
            <c:set var="total1" value="0" />
            <c:forEach items="${id_courses}" var="course">
                <c:if test="${course.year == 2023 && course.semester == 1}">
                    <c:set var="total1" value="${total1 + course.credit}" />
                </c:if>
            </c:forEach>
            ${total1}
        </td>
        <td><a href="${pageContext.request.contextPath}/viewDetails/23-1"> 23-1 상세보기 </a></td>
    </tr>
    <tr align="center" height="20%">
        <td>2023</td>
        <td>2</td>
        <td>
            <c:set var="total2" value="0" />
            <c:forEach items="${id_courses}" var="course">
                <c:if test="${course.year == 2023 && course.semester == 2}">
                    <c:set var="total2" value="${total2 + course.credit}" />
                </c:if>
            </c:forEach>
            ${total2}
        </td>
        <td><a href="${pageContext.request.contextPath}/viewDetails/23-2"> 23-2 상세보기 </a></td>
    </tr>
    <tr align="center" height="20%">
        <td>2024</td>
        <td>1</td>
        <td>
            <c:set var="total3" value="0" />
            <c:forEach items="${id_courses}" var="course">
                <c:if test="${course.year == 2024 && course.semester == 1}">
                    <c:set var="total3" value="${total3 + course.credit}" />
                </c:if>
            </c:forEach>
            ${total3}
        </td>
        <td><a href="${pageContext.request.contextPath}/viewDetails/24-1"> 24-1 상세보기 </a></td>
    </tr>
    <tr align="center" height="20%">
        <td>총계</td>
        <td></td>
        <td>
            <c:set var="total4" value="0" />
            <c:set var="total4" value="${total1 + total2 + total3}" />
            ${total4}
        </td>
        <td></td>
    </tr>
</table>
</body>
</html>
