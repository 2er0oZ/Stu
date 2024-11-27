package controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import service.StudentService;
import util.DateUtil;

/**
 * 更新学生Servlet
 */
@WebServlet("/StudentUpdateServlet")
public class StudentUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentService studentService = new StudentService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
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
        //学生属性
        String userType = (String) request.getSession().getAttribute("userType");
        
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

        // 执行更新操作
        int update = studentService.update(student);
        
        if (update > 0) {  // 成功
        	request.setAttribute("successMsg", "更新成功"); // 更新成功
            if ("student".equals(userType)) {
                // 学生更新成功
                response.sendRedirect("index.jsp?no=" + URLEncoder.encode(no, "UTF-8") + "&updateStatus=success");
            } else if ("admin".equals(userType)) {
                // 管理员更新成功
            	request.getRequestDispatcher("studentUpdate.jsp").forward(request, response);
            }
            System.out.println("update数据：" + update);
        } else {  // 失败
            if ("student".equals(userType)) {
            	request.setAttribute("errorMsg", "更新失败");
                // 学生更新失败
                response.sendRedirect("index.jsp?no=" + URLEncoder.encode(no, "UTF-8") + "&updateStatus=failure");
            } else if ("admin".equals(userType)) {
                // 管理员更新失败
            	request.setAttribute("errorMsg", "更新失败");
                request.setAttribute("student", student);
                request.getRequestDispatcher("studentUpdate.jsp").forward(request, response);
            }
            System.out.println("update数据：" + update);
        }
    }

}
