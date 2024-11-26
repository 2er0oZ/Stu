package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Admin;
import bean.Student;
import service.AdminService;
import service.StudentService;

/**
 * 登录Servlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminService adminService = new AdminService();
	private StudentService studentService = new StudentService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 在request中获取登录信息
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String type = request.getParameter("type");
		
		if (type.equals("student")) {

			Student student = studentService.getStudentByNo(username);
			// 登录判断
			if (student != null) {
				// 登录成功
				if (student.getPassword().equals(password)) {
					request.getSession().setAttribute("student", student);
					// 跳转到首页
					response.sendRedirect("index.jsp");
				} else {
					// 密码错误
					request.setAttribute("errorMsg", "密码错误");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			} else {
				// 未找到用户
				request.setAttribute("errorMsg", "学号不存在");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} else if (type.equals("admin")) {
			Admin loginUser = adminService.getAdminByUsername(username);
			// 登录判断
			if (loginUser != null) {
				// 登录成功
				if (loginUser.getPassword().equals(password)) {
					request.getSession().setAttribute("admin", loginUser);
					// 跳转到首页
					response.sendRedirect("studentList.jsp");
				} else {
					// 密码错误
					request.setAttribute("errorMsg", "密码错误");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			} else {
				// 未找到用户
				request.setAttribute("errorMsg", "用户名不存在");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} else {
			// 用户类型错误
			request.setAttribute("errorMsg", "用户名类型错误");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}
}
