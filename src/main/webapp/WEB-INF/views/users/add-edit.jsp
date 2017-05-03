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
        <c:if test="${editMode == true}">
        <div class="panel panel-warning">
        <div class="panel-heading"><h2 class="form-heading">Edit mode:</h2></div>
        </c:if>
        <c:if test="${editMode == false}">
        <div class="panel panel-success">
        <div class="panel-heading"><h2 class="form-heading">Add mode:</h2></div>
        </c:if>
          <div class="panel-body">
            <form:form method="POST" modelAttribute="user" class="form-horizontal" action="${contextPath}/users/add-edit">
                <form:input path="id" type="hidden"/>
                <form:input path="createdDate" type="hidden"/>

                <spring:bind path="firstName">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <label class="control-label col-sm-2" for="firstName">First Name:</label>
                         <div class="col-sm-10">
                            <form:input path="firstName" type="text" class="form-control" placeholder="John" autofocus="true"/>
                            <form:errors path="firstName" class="control-label"></form:errors>
                         </div>
                    </div>
                </spring:bind>

                <spring:bind path="secondName">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <label class="control-label col-sm-2" for="secondName">Second Name:</label>
                         <div class="col-sm-10">
                            <form:input path="secondName" type="text" class="form-control" placeholder="Nimelson"/>
                            <form:errors path="secondName" class="control-label"></form:errors>
                         </div>
                    </div>
                </spring:bind>

                <spring:bind path="email">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <label class="control-label col-sm-2" for="email">Email:</label>
                         <div class="col-sm-10">
                            <form:input path="email" type="text" class="form-control" placeholder="JohnNimelson@uk.com"/>
                            <form:errors path="email" class="control-label"></form:errors>
                         </div>
                    </div>
                </spring:bind>
                <c:if test="${editMode != true}">
                <spring:bind path="password">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <label class="control-label col-sm-2" for="password">Password:</label>
                         <div class="col-sm-10">
                            <form:input path="password" type="password" class="form-control" placeholder="Password"/>
                            <form:errors path="password" class="control-label"></form:errors>
                         </div>
                    </div>
                </spring:bind>

                <spring:bind path="passwordConfirm">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <label class="control-label col-sm-2" for="passwordConfirm">Password confirm:</label>
                         <div class="col-sm-10">
                            <form:input path="passwordConfirm" type="password" class="form-control" placeholder="Confirm your password"/>
                            <form:errors path="passwordConfirm" class="control-label"></form:errors>
                         </div>
                    </div>
                </spring:bind>
                </c:if>
                <spring:bind path="locked">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <label class="control-label col-sm-2" for="locked">Locked:</label>
                         <div class="col-sm-10">
                            <form:checkbox path="locked" class="form-control"/>
                            <form:errors path="locked" class="control-label"></form:errors>
                         </div>
                    </div>
                </spring:bind>

                <spring:bind path="enabled">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <label class="control-label col-sm-2" for="enabled">Enabled:</label>
                         <div class="col-sm-10">
                            <form:checkbox path="enabled" class="form-control"/>
                            <form:errors path="enabled" class="control-label"></form:errors>
                         </div>
                    </div>
                </spring:bind>

                <spring:bind path="postCode">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <label class="control-label col-sm-2" for="postCode">Post Code:</label>
                         <div class="col-sm-10">
                            <form:input path="postCode" type="text" class="form-control" placeholder="MK430AL"/>
                            <form:errors path="postCode" class="control-label"></form:errors>
                         </div>
                    </div>
                </spring:bind>

                <spring:bind path="expiryDate">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <label class="control-label col-sm-2" for="expiryDate">Expiry Date:</label>
                         <div class="col-sm-10">
                            <form:input path="expiryDate" type="text" class="form-control" placeholder="MM/dd/yyyy"/>
                            <form:errors path="expiryDate" class="control-label"></form:errors>
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
                            <button class="btn btn-lg btn-success btn-block" type="submit">Update</button>
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
