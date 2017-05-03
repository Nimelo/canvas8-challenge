<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Welcome to Admin Side</title>
</head>
<body>
<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <h3>Sorry but you do not have required role. Your roles are:</h3>
        <c:forEach items="${roles}" var="role">
            <tr>
                <td><c:out value="${role.role}"/></td>
            </tr>
        </c:forEach>
    </c:if>
    <c:if test="${pageContext.request.userPrincipal.name == null}">
        <div>"${msg}"</div>
    </c:if>
</div>
</body>
</html>
