<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ include file="header.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Welcome</title>

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
        <div class="panel-group">
            <div class="panel panel-primary">
              <div class="panel-heading">Informations:</div>
              <div class="panel-body">
                This webside was developed by Mateusz Gasior using:
                <ul>
                  <li>SpringFramework</li>
                  <li>Hibernate</li>
                  <li>Bootstrap</li>
                  <li>MySQL Database</li>
                  <li>MySQL Workbench</li>
                  <li>IntelliJ IDEA Community Edition</li>
                  <li>Ubuntu 17.04</li>
                </ul>
              </div>
            </div>
            <div class="panel panel-warning">
              <div class="panel-heading">Comments:</div>
              <div class="panel-body">
                There are some comments in developed code and mismatches according to the developer tech challenge paper.
                <ul>
                  <li>
                      There was no specification about who should be able to edit which properties of groups and members.
                      It was assumed that only users that have role ROLE_USER will be avalaible to do it.
                      The only restriction for password for already added user - there is no way to do this.
                   </li>
                  <li>
                      There was also a requirement about search functionality upon members in corporate group.
                      Due to lack of specification this requirement was abandoned.
                  </li>
                  <li>
                      Most of the fields in database is not required and can be set to null. It was decision made due to lack of specification.
                      Created date fields in database are generated by Hibernate just before persist routine.
                  </li>
                  <li>
                      In terms of previous bullet point validation of the forms is also very simple but it's prepared to extensions.
                  </li>
                </ul>
              </div>
            </div>

            <div class="panel panel-danger">
              <div class="panel-heading">Reservations:</div>
              <div class="panel-body">None</div>
            </div>
        </div>
    </c:if>

</div>
<!-- /container -->
</body>
</html>
