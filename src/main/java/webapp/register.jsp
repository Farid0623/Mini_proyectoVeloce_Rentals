<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="layout/header.jsp"/>

<h3>${title}</h3>
<form action="${pageContext.request.contextPath}/users/form" method="post" class="mt-3">
    <div class="form-group row">
        <label for="username" class="col-sm-2 col-form-label">Name</label>
        <div class="col-sm-4">
            <input type="text" name="username" id="username" value="${user.name}" class="form-control">
        </div>
        <c:if test="${mistakes != null && mistakes.containsKey('username')}">
            <div class="col-sm-4">
                <div class="text-danger">${mistakes.username}</div>
            </div>
        </c:if>
    </div>
    <div class="form-group row">
        <label for="password" class="col-sm-2 col-form-label">Password</label>
        <div class="col-sm-4">
            <input type="password" name="password" id="password" value="${user.password}" class="form-control">
        </div>
        <c:if test="${mistakes != null && mistakes.containsKey('password')}">
            <div class="col-sm-4">
                <div class="text-danger">${mistakes.password}</div>
            </div>
        </c:if>
    </div>
    <div class="form-group row">
        <div class="col-sm-2"></div>
        <div class="col-sm-4">
            <input class="btn btn-primary" type="submit" value="Create">
        </div>
    </div>
    <input type="hidden" name="id" value="${user.id}">
</form>
<jsp:include page="layout/footer.jsp"/>


