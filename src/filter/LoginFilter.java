package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import bean.Admin;
import bean.Student;

@WebFilter(filterName = "LoginFilter", urlPatterns = "/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 查看session中有没有登录用户
        Admin loginUser = (Admin) request.getSession().getAttribute("admin");
        Student student = (Student) request.getSession().getAttribute("student");

        // 如果登录用户为空并且访问的不是登录或注册页面，就跳转到登录页面
        if (
            loginUser == null
            && student == null
            && !request.getRequestURI().equals(request.getContextPath() + "/login.jsp")
            && !request.getRequestURI().equals(request.getContextPath() + "/LoginServlet")
            && !request.getRequestURI().equals(request.getContextPath() + "/register.jsp")
            && !request.getRequestURI().equals(request.getContextPath() + "/RegisterServlet")
            && !request.getRequestURI().startsWith(request.getContextPath() + "/css/")
        ) {
            response.sendRedirect("login.jsp");
        } else {
            filterChain.doFilter(request, response);
        }
    }
}
