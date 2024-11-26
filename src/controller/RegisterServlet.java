package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import service.StudentService;
import util.DateUtil;

import java.io.IOException;
import java.util.Date;

/**
 * 注册学生Servlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 实例化service
	private StudentService studentService = new StudentService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 在request中获取学生信息
        String no = request.getParameter("no");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String nationality = request.getParameter("nationality");
        String department = request.getParameter("department");
        String major = request.getParameter("major");
        String classes = request.getParameter("classes");
        Date inDate = DateUtil.parseYYYYMMDDHHMMSS(request.getParameter("inDate"));


		Student dbStudent = studentService.getStudentByNo(no);
		
		if (dbStudent == null) {
	        // 创建学生对象
	        Student student = new Student();
	        // 把信息添加到对象中
	        student.setNo(no);
	        student.setName(name);
	        student.setPassword(password);
	        student.setAddress(address);
	        student.setNationality(nationality);
	        student.setDepartment(department);
	        student.setMajor(major);
	        student.setClasses(classes);
	        student.setInDate(inDate);
	        
	        System.out.println(student);
	        
			// 执行添加操作
			int add = studentService.add(student);

			if (add > 0) {  // 成功
				request.setAttribute("successMsg", "注册成功！");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			} else {  // 失败
				request.setAttribute("errorMsg", "注册失败！");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("errorMsg", "学号已存在！");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}

	}

}
