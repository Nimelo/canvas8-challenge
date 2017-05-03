<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="corporateGroupContextPath" value="${contextPath}/corporate-groups"/>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Corporate Groups</title>
</head>
<body>
<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <h3>Corporate Groups:</h3>
        <table class="table">
            <tr>
                <th>ID</th>
                <th>NAME</th>
                <th>EMAIL ADDRESS</th>
                <th>CREATED DATE</th>
                <th>ACTIONS</th>
            </tr>
            <c:forEach items="${corporateGroups}" var="group">
            <tr>
                <td>
                    <c:out value="${group.id}" />
                </td>
                <td>
                    <c:out value="${group.name}" />
                </td>
                <td>
                    <c:out value="${group.email}" />
                </td>
                <td>
                    <c:out value="${group.createdDate}" />
                </td>
                <td>
                    <a href="${corporateGroupContextPath}/${group.id}/view" class="btn btn-info" role="button">View</a>
                    <a href="${corporateGroupContextPath}/${group.id}/edit" class="btn btn-warning" role="button">Edit</a>
                    <a href="${corporateGroupContextPath}/${group.id}/delete" class="btn btn-danger" role="button">Delete</a>
                </td>
            </tr>
            </c:forEach>
        </table>
        <a href="${corporateGroupContextPath}/add" class="btn btn-success" role="button">Add new Corporate Group</a>
    </c:if>
</div>
</body>
</html>
