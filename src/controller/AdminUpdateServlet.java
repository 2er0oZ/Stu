package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Admin;
import service.AdminService;
/**
 * 更新管理员Servlet
 */
@WebServlet("/AdminUpdateServlet")
public class AdminUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    // 创建业务处理类对象
    private AdminService adminService = new AdminService();
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 在request中获取管理员信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String realname = request.getParameter("realname");
        String sex = request.getParameter("sex");

        // 创建管理员对象
        Admin admin = new Admin();
        
        // 把信息添加到对象中
        admin.setUsername(username);
        admin.setPassword(password);
        admin.setRealname(realname);
        admin.setSex(sex);

        // 执行更新操作
        int update = adminService.update(admin);
        if (update > 0) {  // 成功
            request.setAttribute("successMsg", "更新成功");
        } else {  // 失败
            request.setAttribute("errorMsg", "更新失败");
            request.setAttribute("admin", admin);
        }
        request.getRequestDispatcher("adminUpdate.jsp").forward(request, response);

    }

}
