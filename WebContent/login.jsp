<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/common.css">
    <style>
        .ds-login{
            background-color: rgba(255,255,255,0.8);
            width: 400px;
            height: 350px;
            margin: 150px auto;
            padding: 50px;
            box-sizing: border-box;
        }
        .input {
            box-sizing: border-box;
            padding: 0px 10px;
            width: 100%;
            height: 30px;
            border: 1px solid #bebebe;
            margin-top: 20px;
        }
    </style>
</head>
<body>
<nav class="nav">
    <span class="nav-title">
        学生管理系统
    </span>
</nav>
<div class="ds-login">
    <h2 style="text-align: center;">登录</h2>
    <div style="text-align: center;color: red"><%=request.getAttribute("errorMsg") != null ? request.getAttribute("errorMsg") : "" %></div>
    <form action="<%=request.getContextPath() %>/LoginServlet" method="post">
        <input id="username" class="input" type="text" name="username" placeholder="请输入用户名或学号" required>
        <input id="password" class="input" type="password" name="password" placeholder="请输入密码" required>
        <br>
        <br>
        <input id="student" type="radio" name="type" value="student" checked required/> <label for="student">学生</label>
       	<input id="admin" type="radio" name="type" value="admin" required/>  <label for="admin">管理员</label>
        <button class="input">登录</button>
        <br>
        <br>
		<a href="<%=request.getContextPath()%>/register.jsp" class="button_go_login">注册</a>
    </form>
</div>
</body>
</html>