<%@ page import="entity.Admin" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>头部</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/common.css">
</head>
<body>
    <nav class="nav">
        <span class="nav-title">
            学生管理系统
        </span>
        <a class="item" href="#" onclick="parent.location.href = '../studentList.jsp'">
            <span>学生管理</span>
        </a>
        <a class="item" href="#" onclick="parent.location.href = '../adminList.jsp'">
            <span>管理员管理</span>
        </a>
        <a class="item" href="#" onclick="parent.location.href = '<%=request.getContextPath()%>/LogoutServlet'">
            <span>退出登录</span>
        </a>
    </nav>
</body>
</html>
