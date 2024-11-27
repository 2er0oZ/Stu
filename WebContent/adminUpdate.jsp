<%@page import="bean.Admin"%>
<%@page import="service.AdminService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>更新管理员</title>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/common.css">
</head>
<body>
    <iframe src="<%=request.getContextPath()%>/common/head.jsp" class="top"></iframe>
    <div class="main">
        <div class="content">
            <div class="form_div">
                <a href="<%=request.getContextPath() %>/adminList.jsp" class="button_back">返回</a>
                <br>
                <br>
                <div style="text-align: center;color: green">${successMsg}</div>
                <div style="text-align: center;color: red">${errorMsg}</div>
                <%
                    // 在request中获取出需要修改的管理员的username
                    String adminUsername = request.getParameter("username");

                    // 根据username查询管理员详情
                    AdminService adminService = new AdminService();
                    Admin admin = adminService.getAdminByUsername(adminUsername);
                    request.setAttribute("admin", admin);
                %>
                <div class="form_box">
                    <form action="<%=request.getContextPath() %>/AdminUpdateServlet" method="post" class="form">
                        <table class="table">
                            <tr>
                                <td colspan="2" style="text-align: center;">
                                    <h2>更新管理员</h2>
                                </td>
                            </tr>
                            <input id="username" type="text" name="username" required="required" value="<%=adminUsername %>" hidden>
                            <tr>
                                <td>
                                    <label for="password">密码</label>
                                </td>
                                <td>
                                    <input id="password" type="text" name="password" required="required" value="${admin.password}" class="input">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="realname">真实姓名</label>
                                </td>
                                <td>
                                    <input id="realname" type="text" name="realname" required="required" value="${admin.realname}" class="input">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="sex">性别</label>
                                </td>
                                <td>
                                    <input id="sex" type="text" name="sex" required="required" value="${admin.sex}" class="input">
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" style="text-align: center;">
                                    <button class="button_action">更新</button>
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>
            </div>
		</div>
    </div>
</body>
</html>
