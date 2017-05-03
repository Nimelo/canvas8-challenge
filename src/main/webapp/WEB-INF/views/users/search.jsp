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
    <form:form method="POST" modelAttribute="searchQuery" class="form-horizontal" action="${contextPath}/users/search">
        <div class="row">
            <table class="table">
                <tr>
                    <th>FIRST NAME</th>
                    <th>SECOND NAME</th>
                    <th>EMAIL</th>
                    <th>CORPORATE GROUP</th>
                </tr>
                <tr>
                    <td>
                        <div class="">
                            <form:input path="firstName" type="text" class="form-control" placeholder="First name" autofocus="true"/>
                        </div>
                    </td>
                    <td>
                        <div class="">
                            <form:input path="secondName" type="text" class="form-control" placeholder="Second name"/>
                        </div>
                    </td>
                    <td>
                        <div class="">
                            <form:input path="email" type="text" class="form-control" placeholder="Email"/>
                        </div>
                    </td>
                    <td>
                        <div class="">
                            <form:input path="corporateGroupId" class="hidden"/>
                            <select id="corporateGroups" class="form-control" onchange="corporateGroupOnClickHandler()">
                                <option value="0" label="All"/>
                                <c:forEach items="${corporateGroups}" var="group">
                                    <option value="${group.id}" label="${group.name}"/>
                                </c:forEach>
                            </select>
                        </div>
                        <script type="text/javascript">
                            $(function(){
                                var value = $('#corporateGroupId').val();
                                $('#corporateGroups option[value=' + value + ']').attr('selected','selected');
                            });
                           function corporateGroupOnClickHandler() {
                            var selectedValue = $('#corporateGroups').find(':selected').val();
                            $('#corporateGroupId').val(selectedValue);
                           }
                        </script>
                    </td>
                </tr>
            </table>


            <div class="col col-sm-offset-4 col-sm-4">
                <button class="btn btn-lg btn-success btn-block" type="submit">Search</button>
            </div>
        </div>
    </form:form>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <h3>Filtered Users:</h3>
        <table class="table">
            <tr>
                <th>ID</th>
                <th>FIRST NAME</th>
                <th>SECOND NAME</th>
                <th>EMAIL</th>
                <th>CREATE DATE</th>
                <th>CORPORATE GROUP</th>
            </tr>
            <c:forEach items="${users}" var="user">
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
                   <c:out value="${user.corporateGroup.name}" />
                </td>
            </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
</body>
</html>
