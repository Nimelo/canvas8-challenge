<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="corporateGroupContextPath" value="${contextPath}/corporate-groups"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Corporate Groups</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2>Welcome ${pageContext.request.userPrincipal.name}</h2>
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
        <a href="${corporateGroupContextPath}/${group.id}/add" class="btn btn-success" role="button">Add new Corporate Group</a>
    </c:if>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
