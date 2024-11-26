<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>注册</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/common.css">
    <style>
        .ds-login{
            background-color: rgba(255,255,255,0.8);
            width: 400px;
            height: 650px;
            margin: 100px auto;
            padding: 30px 50px;
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
		<h2 style="text-align: center;">注册</h2>
        <div style="text-align: center;color: green">${successMsg}</div>
        <div style="text-align: center;color: red">${errorMsg}</div>
		<form action="<%=request.getContextPath() %>/RegisterServlet" method="post">
			<input id="no" type="text" name="no" required="required" class="input" placeholder="请输入学号">
			<input id="name" type="text" name="name" required="required" class="input" placeholder="请输入姓名">
			<input id="password" type="password" name="password" required="required" class="input" placeholder="请输入密码">
			<input id="address" type="text" name="address" required="required" class="input" placeholder="请输入家庭住址" >
			<input id="nationality" type="text" name="nationality" required="required" class="input" placeholder="请输入民族" >
			<input id="department" type="text" name="department" required="required" class="input" placeholder="请输入院系" >
			<input id="major" type="text" name="major" required="required" class="input" placeholder="请输入专业">
			<input id="classes" type="text" name="classes" required="required" class="input" placeholder="请输入班级">
			<input id="inDate" type="date" name="inDate" required="required" class="input" placeholder="请输入入学日期">
			<button class="input">注册</button>
			<br>
			<br>
			<a href="<%=request.getContextPath()%>/login.jsp" class="button_go_login">去登录</a>
		</form>
	</div>
</body>
</html>