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
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
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
        <div class="panel panel-info">
          <div class="panel-heading"><h2 class="form-heading">${corporateGroup.name} details:</h2></div>
          <div class="panel-body">
            <form:form method="POST" modelAttribute="corporateGroup" class="form-horizontal">
                <div class="form-group">
                    <label class="control-label col-sm-2" for="name">Name:</label>
                     <div class="col-sm-10">
                        <form:input path="name" type="text" class="form-control" disabled="true"/>
                     </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="email">Email:</label>
                    <div class="col-sm-10">
                        <form:input path="email" type="text" class="form-control" disabled="true"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="createdDate">Created Date:</label>
                    <div class="col-sm-10">
                        <form:input path="createdDate" type="text" class="form-control" disabled="true"/>
                    </div>
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form:form>
          </div>
        </div>
        <div class="panel panel-info">
            <div class="panel-heading"><h2 class="form-heading">${corporateGroup.name} members:</h2><a href="${corporateGroupContextPath}/add/${corporateGroup.id}/user" class="btn btn-success" role="button">Add new Corporate Member</a></div>
                <div class="panel-body">
                    <table class="table">
                        <tr>
                            <th>ID</th>
                            <th>FIRST NAME</th>
                            <th>SECOND NAME</th>
                            <th>EMAIL</th>
                            <th>CREATE DATE</th>
                            <th>ACTIONS</th>
                        </tr>
                        <c:forEach items="${users.content}" var="user">
                        <tr>
                            <td>
                                <c:out value="${user.id}" />
                            </td>
                            <td>
                                <c:out value="${user.firstName}" />
                            </td>
                            <td>
                                <c:out value="${user.secondName}" />
                            </td>
                            <td>
                                <c:out value="${user.email}" />
                            </td>
                            <td>
                                <c:out value="${user.createdDate}" />
                            </td>
                            <td>
                                <a href="${corporateGroupContextPath}/view/${corporateGroup.id}" class="btn btn-info" role="button">View</a>
                                <a href="${corporateGroupContextPath}/edit/${corporateGroup.id}" class="btn btn-warning" role="button">Edit</a>
                                <button class="btn btn-danger delete-user" dbid="${user.id}">Delete</button>
                            </td>
                        </tr>
                        </c:forEach>
                    </table>
                    <nav aria-label="Page navigation">
                      <ul class="pagination pagination-lg">
                        <li>
                          <a href="?page=0" aria-label="First">
                            <span aria-hidden="true">&laquo;&laquo;</span>
                          </a>
                        </li>
                        <li>
                          <a href="?page=${pageNumber == 0 ? 0 : pageNumber - 1}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                          </a>
                        </li>
                        <li class="active"><a href="?page=${pageNumber}"><span><c:out value="${pageNumber + 1}"/></span></a></li>
                        <li>
                          <a href="?page=${pageNumber >= endIndex ? endIndex : pageNumber + 1}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                          </a>
                        </li>
                        <li>
                          <a href="?page=${endIndex}" aria-label="last">
                            <span aria-hidden="true">&raquo;&raquo;</span>
                          </a>
                        </li>
                      </ul>
                    </nav>
                </div>
            </div>
        </div>
    </c:if>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${contextPath}/resources/js/corporate-groups/view.js"></script>
</body>
</html>
