<%@page import="bean.Admin"%>
<%@page import="service.AdminService"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>管理员管理</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/common.css">
</head>
<body>
    <iframe src="<%=request.getContextPath()%>/common/head.jsp" class="top"></iframe>
    <div class="main">
        <div class="content">
            <div class="table_div">
	            <form action="<%=request.getContextPath() %>/adminList.jsp" method="get">
	                <label for="username">用户名</label>
	                <input class="input" id="username" name="username" type="text"
	                       value="<%=request.getParameter("username") != null ? request.getParameter("username") : "" %>">
	                <button class="button_action">搜索</button>
	            </form>
                <a href="<%=request.getContextPath() %>/adminAdd.jsp" class="button_atag" style="float: left">添加管理员</a>
                <br><br>
                <div class="table_box">
                    <table class="table" style="width: 100%">
                        <thead>
                            <th>用户名</th>
                            <th>密码</th>
                            <th>真实姓名</th>
                            <th>性别</th>
                            <th>创建时间</th>
                            <th>操作</th>
                        </thead>
                        <tbody>
                            <%
                            String username = request.getParameter("username");
                            
                            AdminService adminService = new AdminService();

                            // 查询所有管理员
                            List<Admin> admins = adminService.getAllAdmin(username);

                            request.setAttribute("admins", admins);
                            %>
                            <c:forEach var="item" items="${admins}">
                                <tr>
                                    <td>${item.username}</td>
                                    <td>${item.password}</td>
                                    <td>${item.realname}</td>
                                    <td>${item.sex}</td>
                                    <td>${item.createTime}</td>
                                    <td>
                                        <a href="<%=request.getContextPath() %>/adminUpdate.jsp?username=${item.username}">更新</a> |
                                        <a href="<%=request.getContextPath() %>/AdminDeleteServlet?username=${item.username}">删除</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
