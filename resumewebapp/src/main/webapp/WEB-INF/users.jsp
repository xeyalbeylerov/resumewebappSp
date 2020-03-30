
<%@ page import="com.company.entity.User" %>

<%@ page import="java.util.List" %>

<%--jstl tags--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--Spring tags--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="assets/css/users.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>JSP Page</title>
</head>
<body>
<%--<%if(session.getAttribute("loggedInUser")!=null){%>--%>
<%--<%User user=(User)session.getAttribute("loggedInUser");--%>
    <%--out.print("Welcome "+user.getName());--%>
<%--}--%>
<%--%>--%>
<%
//    UserDaoInter userDao = Context.instanceUserDao();
//
//    String name = request.getParameter("name");
//    String surname = request.getParameter("surname");
//
//    String nationalityIdStr = request.getParameter("nid");
//    Integer nationalityId = null;
//    if (nationalityIdStr != null && !nationalityIdStr.trim().isEmpty()) {
//        nationalityId = Integer.parseInt(nationalityIdStr);
//    }
////    out.print("name " + name);
////    out.print("surname " + surname);
////    out.print("nation " + nationalityId);
//    List<User> lists = userDao.getAll(name, surname, nationalityId);
    List<User> lists=(List<User>)request.getAttribute("list");


%>
<div class="container">
    <div>
        <!--Form here -->
        <%--<form action="users" method="get" class="form-inline">--%>
        <f:form action="usersm" method="GET" modelAttribute="user">
            <div class="form-group mb-2">
                <label for="name" class="sr-only">name </label>
                <f:input path="name"
                         class="form-control"
                         id="name"
                         placeholder="type name here"/>
                <form:errors path="name" cssClass="error"/>
            </div>
            <div class="form-group mx-sm-3 mb-2">
                <label for="surname" class="sr-only">surname</label>
                <f:input path="surname"
                         class="form-control"
                         id="surname"
                         placeholder="type surname here"/>
                <form:errors path="surname" cssClass="error"/>
            </div>
            <div class="form-group mb-2">
                <f:button type="submit" class="btn btn-primary" value="Search">Search</f:button>
            </div>
        </f:form>

        <div>
            <!--Table here -->
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col" class="text-center">name</th>
                    <th scope="col" class="text-center">surname</th>
                    <th scope="col" class="text-center">nationality</th>
                    <th scope="col" class="text-center"></th>
                    <th scope="col" class="text-center"></th>
                    <th scope="col" class="text-center"></th>
                </tr>
                </thead>
                <tbody>
                <%--<%for (User list : lists) {%>--%>
                <c:forEach items="${users}" var="u" >
                    <tr>
                        <td>${u.name}</td>
                        <td>${u.surname}</td>
                        <td>${u.nationality.name}</td>
                        <td style="width:5px">

                            <input type="hidden" name="id" value="${u.id}"/>
                            <input type="hidden" name="action" value="delete"/>
                            <button class="btn btn-danger" type="submit" value="delete"
                                    data-toggle="modal" data-target="#exampleModal"
                                    onclick="setIdForDelete(${u.id})">
                                <i class="fas fa-trash-alt"></i>
                            </button>
                        </td>
                        <td style="width:5px">
                            <form action="userdetail" method="GET">
                                <input type="hidden" name="id" value="${u.id}"/>
                                <input type="hidden" name="action" value="update"/>
                                <button class="btn btn-secondary" type="submit" value="update">
                                    <i class="fas fa-pen-square"></i>
                                </button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                <%--<%}%>--%>
                </tbody>
            </table>
        </div>
    </div>
</div>
<!--Delete Modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="deleteModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="deleteModalLabel">Delete user</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Are you sure?
            </div>
            <div class="modal-footer">
                <form action="userdetail" method="post">
                    <input type="hidden" name="id" id="idForDeleteModal" value=""/>
                    <input type="hidden" name="action" value="delete"/>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-danger">Delete</button>
                </form>
            </div>

        </div>
    </div>
</div>
<script src="assets/js/users.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
</body>
</html>
