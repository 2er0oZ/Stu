<%@page import="bean.Student"%>
<%@page import="service.StudentService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>更新学生信息</title>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/common.css">
</head>
<body>
    <iframe src="<%=request.getContextPath()%>/common/head.jsp" class="top"></iframe>
    <div class="main">
        <div class="content">
            <div class="form_div">
                <a href="<%=request.getContextPath() %>/studentList.jsp" class="button_back">返回</a>
                <br>
                <br>
                <div style="text-align: center;color: green">${successMsg}</div>
                <div style="text-align: center;color: red">${errorMsg}</div>
                <%
                    // 在request中获取出需要修改的学生的no
                    String studentNo = request.getParameter("no");

                    // 根据no查询学生详情
                    StudentService studentService = new StudentService();
                    Student student = studentService.getStudentByNo(studentNo);
                    request.setAttribute("student", student);
                %>
                <div class="form_box">
                    <form action="<%=request.getContextPath() %>/StudentUpdateServlet" method="post" class="form">
                        <table class="table">
                            <tr>
                                <td colspan="2" style="text-align: center;">
                                    <h2>更新学生信息</h2>
                                </td>
                            </tr>
                            <input id="no" type="text" name="no" required="required" value="<%=studentNo %>" hidden>
                            <tr>
                                <td>
                                    <label for="name">姓名</label>
                                </td>
                                <td>
                                    <input id="name" type="text" name="name" required="required" value="${student.name}" class="input">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="password">密码</label>
                                </td>
                                <td>
                                    <input id="password" type="text" name="password" required="required" value="${student.password}" class="input">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="address">家庭住址</label>
                                </td>
                                <td>
                                    <input id="address" type="text" name="address" required="required" value="${student.address}" class="input">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="nationality">民族</label>
                                </td>
                                <td>
                                    <input id="nationality" type="text" name="nationality" required="required" value="${student.nationality}" class="input">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="department">院系</label>
                                </td>
                                <td>
                                    <input id="department" type="text" name="department" required="required" value="${student.department}" class="input">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="major">专业</label>
                                </td>
                                <td>
                                    <input id="major" type="text" name="major" required="required" value="${student.major}" class="input">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="classes">班级</label>
                                </td>
                                <td>
                                    <input id="classes" type="text" name="classes" required="required" value="${student.classes}" class="input">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="inDate">入学日期</label>
                                </td>
                                <td>
                                    <input id="inDate" type="date" name="inDate" required="required" value="${student.inDate}" class="input">
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
