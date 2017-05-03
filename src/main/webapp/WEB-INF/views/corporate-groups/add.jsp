<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
</body>
</html>
