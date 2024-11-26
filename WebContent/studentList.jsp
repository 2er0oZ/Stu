<%@page import="bean.Student"%>
<%@page import="service.StudentService"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>学生管理</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/common.css">
</head>
<body>
    <iframe src="<%=request.getContextPath()%>/common/head.jsp" class="top"></iframe>
    <div class="main">
        <div class="content">
            <div class="table_div">
	            <form action="<%=request.getContextPath() %>/studentList.jsp" method="get">
	                <label for="no">学号</label>
	                <input class="input" id="no" name="no" type="text"
	                       value="<%=request.getParameter("no") != null ? request.getParameter("no") : "" %>">
	                <label for="name">姓名</label>
	                <input class="input" id="name" name="name" type="text"
	                       value="<%=request.getParameter("name") != null ? request.getParameter("name") : "" %>">
	                <button class="button_action">搜索</button>
	            </form>
                <a href="<%=request.getContextPath() %>/studentAdd.jsp" class="button_atag" style="float: left">添加学生</a>
                <br><br>
                <div class="table_box">
                    <table class="table" style="width: 100%">
                        <thead>
                            <th>学号</th>
                            <th>姓名</th>
                            <th>密码</th>
                            <th>家庭住址</th>
                            <th>民族</th>
                            <th>院系</th>
                            <th>专业</th>
                            <th>班级</th>
                            <th>入学日期</th>
                            <th>创建时间</th>
                            <th>操作</th>
                        </thead>
                        <tbody>
                            <%
                            String no = request.getParameter("no");
                            String name = request.getParameter("name");
                            
                            StudentService studentService = new StudentService();

                            // 查询所有学生
                            List<Student> students = studentService.getAllStudent(no, name);

                            request.setAttribute("students", students);
                            %>
                            <c:forEach var="item" items="${students}">
                                <tr>
                                    <td>${item.no}</td>
                                    <td>${item.name}</td>
                                    <td>${item.password}</td>
                                    <td>${item.address}</td>
                                    <td>${item.nationality}</td>
                                    <td>${item.department}</td>
                                    <td>${item.major}</td>
                                    <td>${item.classes}</td>
                                    <td>${item.inDate}</td>
                                    <td>${item.createTime}</td>
                                    <td>
                                        <a href="<%=request.getContextPath() %>/studentUpdate.jsp?no=${item.no}">更新</a> |
                                        <a href="<%=request.getContextPath() %>/StudentDeleteServlet?no=${item.no}">删除</a>
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
