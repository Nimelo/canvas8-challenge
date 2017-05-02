<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
        <h2>Welcome ${pageContext.request.userPrincipal.name}</h2>
        <div class="panel panel-primary">
          <div class="panel-heading"><h2 class="form-heading">Add new Corporate Group</h2></div>
          <div class="panel-body">
            <form:form method="POST" modelAttribute="corporateGroup" class="form-horizontal">
                <spring:bind path="name">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <label class="control-label col-sm-2" for="name">Name:</label>
                         <div class="col-sm-10">
                            <form:input path="name" type="text" class="form-control" placeholder="Corporate Group" autofocus="true"/>
                            <form:errors path="name" class="control-label"></form:errors>
                         </div>
                    </div>
                </spring:bind>
                <spring:bind path="email">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <label class="control-label col-sm-2" for="email">Email:</label>
                        <div class="col-sm-10">
                            <form:input path="email" type="text" class="form-control" placeholder="email@domain"/>
                            <form:errors path="email" class="control-label"></form:errors>
                        </div>
                    </div>
                </spring:bind>

                <div class="form-group">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <div class="col-sm-offset-4 row">
                        <div class="col col-sm-4">
                            <a href="${corporateGroupContextPath}/list" class="btn btn-lg btn-danger btn-block" role="button">Cancel (Go to List)</a>
                        </div>
                        <div class="col col-sm-4">
                            <button class="btn btn-lg btn-success btn-block" type="submit">Add</button>
                        </div>
                    </div>
                </div>
            </form:form>
          </div>
        </div>
    </c:if>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
