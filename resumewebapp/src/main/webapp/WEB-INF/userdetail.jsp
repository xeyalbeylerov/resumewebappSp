<%@ page import="com.company.entity.User" %>
<%--<%@ page import="com.company.resume.UserRequestUtil" %>--%>
<%@ page import="com.company.entity.Skill" %>
<%@ page import="com.company.entity.UserSkill" %>


<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>JSP Page</title>
</head>
<body>
<%


    User u=(User) request.getAttribute("user");
//    User u = null;
//    try {
//        u = UserRequestUtil.processRequest(request, response);
//    } catch (Exception ex) {
//        response.sendRedirect("error.jsp?msg=" + ex.getMessage()+" Test");
//        return;
//    }

%>
<div class="position-fixed">
    <%--<div class="p-2 my-flex-item text-right">1dwdwd</div>--%>
    <form action="users" method="get">
        <input type="hidden" name="id" id="idForDeleteModal" value=""/>
        <input type="hidden" name="action" value="update"/>
               <button type="submit" class="btn btn-warning text-right">Update</button>
    </form>
</div>
<table class="table table-striped container" >
    <thead>
    <tr>
        <th scope="col" class="text-center" width="30%">#</th>
        <th scope="col" class="text-center" width="70%" >Details</th>

    </tr>
    </thead>
    <tbody>
    <tr scope="row">
        <td>Id</td>
        <td><%=u.getId()%>
        </td>
    </tr>
    <tr scope="row">
        <td>Name</td>
        <td><input class="form-control" type="text" name="name" value="<%=u.getName() == null ? "" : u.getName()%>"/></td>
        <%--<td><%=u.getName() == null ? "N/A" : u.getName()%>--%>
        <%--</td>--%>
    </tr>

    <tr scope="row">
        <td>Surname</td>
        <td><input class="form-control" type="text" name="name" value="<%=u.getSurname() == null ? "" : u.getSurname()%>"/></td>
        <%--<td><%=u.getSurname() == null ? "N/A" : u.getSurname()%>--%>
        <%--</td>--%>
    </tr>
    <tr scope="row">
        <td>Address</td>
        <td><input class="form-control" type="text" name="name" value="<%=u.getAddress() == null ? "" : u.getAddress()%>"/></td>
        <%--<td><%=u.getAddress() == null ? "N/A" : u.getAddress()%>--%>
        <%--</td>--%>
    </tr>
    <tr scope="row">
        <td>Email</td>
        <td><input class="form-control" type="email" name="name" value="<%=u.getEmail() == null ? "" : u.getEmail()%>"/></td>
        <%--<td><%=u.getEmail() == null ? "N/A" : u.getEmail()%>--%>
        <%--</td>--%>
    </tr>
    <tr scope="row">
        <td>Skills</td>

        <%--<td><input class="form-control" type="text" name="name" value="<%for(UserSkill skill:u.getSkills()){skill.getSkill() == null ? "" : skill.getSkill()}%>"/></td>--%>

    </tr>
    <tr scope="row">
        <td>Profile Description</td>
        <td><textarea id="w3mission" rows="3" cols="90" class="form-control" type="text" name="name" value="<%=u.getProfileDesc() == null ? "" : u.getProfileDesc()%>"> </textarea></td>
        <%--<td><%=u.getProfileDesc() == null ? "N/A" : u.getProfileDesc()%>--%>
        <%--</td>--%>
    </tr>
    <tr scope="row">
        <td>Birthdate</td>
        <td><input class="form-control" type="text" name="name" value="<%=u.getBirthDate() == null ? "" : u.getBirthDate()%>"/></td>
        <%--<td><%=u.getBirthDate() == null ? "N/A" : u.getBirthDate()%>--%>
        <%--</td>--%>
    </tr>
    <tr scope="row">
        <td>Birthplace</td>
        <td><input class="form-control" type="text" name="name" value="<%=u.getBirthPlace() == null ? "" : u.getBirthPlace()%>"/></td>
        <%--<td><%=u.getBirthPlace() == null ? "N/A" : u.getBirthPlace()%>--%>
        <%--</td>--%>
    </tr>
    <tr scope="row">
        <td>Phone</td>
        <td><input class="form-control" type="text" name="name" value="<%=u.getPhone() == null ? "" : u.getPhone()%>"/></td>
        <%--<td><%=u.getPhone() == null ? "N/A" : u.getPhone()%>--%>
        <%--</td>--%>
    </tr>
    <%

        //        } else {
//            out.print("Bele user yoxdur");
//        }
    %>
    </tbody>
</table>
</div>
</div>
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
