<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>403</title>
</head>
<body>
<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <div class="panel panel-danger">
          <div class="panel-heading">Handled 403</div>
          <div class="panel-body">
            <div>Your roles are:</div>
            <c:forEach items="${roles}" var="role">
                <tr>
                    <td><c:out value="${role.role}"/></td>
                </tr>
            </c:forEach>
          </div>
        </div>
    </c:if>
    <c:if test="${pageContext.request.userPrincipal.name == null}">
        <div>"${msg}"</div>
    </c:if>
</div>
</body>
</html>
