package dao;

import util.JDBCUtils;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;

import bean.Student;

/**
 * 学生数据库操作类
 */
public class StudentDao {

    /**
	 * 添加学生
	 * @param student
	 * @return
	 */
	// 创建 Logger 实例
    private static final Logger LOGGER = Logger.getLogger(StudentDao.class.getName());
    static {
        // 配置日志处理器
        Handler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.SEVERE); // 设置处理器的日志级别
        LOGGER.addHandler(consoleHandler); // 将处理器添加到 Logger 实例
        LOGGER.setLevel(Level.SEVERE); // 设置 Logger 的日志级别
    }
    public int add(Student student) {
        // 获取数据库连接
        Connection connection = JDBCUtils.getConnection();
        // 编写sql
        String sql = "insert into student(no, name, password, address, nationality, department, major, classes, in_date, create_time) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            // 预编译sql
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            // 添加参数
            prepareStatement.setString(1, student.getNo());
            prepareStatement.setString(2, student.getName());
            prepareStatement.setString(3, student.getPassword());
            prepareStatement.setString(4, student.getAddress());
            prepareStatement.setString(5, student.getNationality());
            prepareStatement.setString(6, student.getDepartment());
            prepareStatement.setString(7, student.getMajor());
            prepareStatement.setString(8, student.getClasses());
            prepareStatement.setDate(9, new Date(student.getInDate().getTime()));
            prepareStatement.setDate(10, new Date(student.getCreateTime().getTime()));
            // 执行sql
            int rs = prepareStatement.executeUpdate();
            // 关闭资源
            JDBCUtils.closeAll(connection, prepareStatement, null);
            return rs;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }

    /**
	 * 删除学生
	 * @param no
	 * @return
	 */
    public int delete(String no) {
        // 获取数据库连接
        Connection connection = JDBCUtils.getConnection();
        // 编写sql
        String sql = "delete from student where no = ?";
        try {
            // 预编译sql
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            // 添加参数
            prepareStatement.setString(1, no);

            // 执行sql
            int rs = prepareStatement.executeUpdate();
            // 关闭资源
            JDBCUtils.closeAll(connection, prepareStatement, null);
            return rs;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 更新学生
     * @param student
     * @return
     */
    public int update(Student student) {
        Connection connection = JDBCUtils.getConnection();
        // 编写sql
        String sql = "update student set name = ?,password = ?,address = ?,nationality = ?,department = ?,major = ?,classes = ?,in_date = ? where no = ?";
        try {
            // 预编译sql
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            // 添加参数
            prepareStatement.setString(1, student.getName());
            prepareStatement.setString(2, student.getPassword());
            prepareStatement.setString(3, student.getAddress());
            prepareStatement.setString(4, student.getNationality());
            prepareStatement.setString(5, student.getDepartment());
            prepareStatement.setString(6, student.getMajor());
            prepareStatement.setString(7, student.getClasses());
            prepareStatement.setDate(8, new Date(student.getInDate().getTime()));
            prepareStatement.setString(9, student.getNo());
            // 执行sql
            int rs = prepareStatement.executeUpdate();
            // 关闭资源
            JDBCUtils.closeAll(connection, prepareStatement, null);
            return rs;
        } catch (SQLException e) {
        	LOGGER.log(Level.SEVERE, "更新学生信息时发生错误", e);
            e.printStackTrace();
        }
        return 0;
    }

    /**
	 * 获取学生
	 * @return
	 */
    public List<Student> getAllStudent(String no, String name) {
        // 获取数据库连接
        Connection connection = JDBCUtils.getConnection();
        // 编写sql
        String sql = "select * from student where 1=1 ";
        // 拼接模糊查询条件
        if (no != null && !no.equals("")) {
        	sql += "and no like '%" + no + "%'";
        }
        if (name != null && !name.equals("")) {
        	sql += "and name like '%" + name + "%'";
        }

        try {
            // 预编译sql
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            // 执行sql
            ResultSet rs = prepareStatement.executeQuery();
            List<Student> students = new ArrayList<Student>();
            while (rs.next()) {
                Student student = new Student();
                student.setNo(rs.getString("no"));
                student.setName(rs.getString("name"));
                student.setPassword(rs.getString("password"));
                student.setAddress(rs.getString("address"));
                student.setNationality(rs.getString("nationality"));
                student.setDepartment(rs.getString("department"));
                student.setMajor(rs.getString("major"));
                student.setClasses(rs.getString("classes"));
                student.setInDate(rs.getDate("in_date"));
                student.setCreateTime(rs.getDate("create_time"));
                students.add(student);
            }
            // 关闭资源
            JDBCUtils.closeAll(connection, prepareStatement, rs);
            return students;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /**
	 * 根据no获取学生详情
	 * @param no
	 * @return
	 */
    public Student getStudentByNo(String no) {
        // 获取数据库连接
        Connection connection = JDBCUtils.getConnection();
        // 编写sql
        String sql = "select * from student where no = ?";

        try {
            // 预编译sql
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, no);
            // 执行sql
            ResultSet rs = prepareStatement.executeQuery();
            Student student = null;
            while (rs.next()) {
                student = new Student();
                student.setNo(rs.getString("no"));
                student.setName(rs.getString("name"));
                student.setPassword(rs.getString("password"));
                student.setAddress(rs.getString("address"));
                student.setNationality(rs.getString("nationality"));
                student.setDepartment(rs.getString("department"));
                student.setMajor(rs.getString("major"));
                student.setClasses(rs.getString("classes"));
                student.setInDate(rs.getDate("in_date"));
                student.setCreateTime(rs.getDate("create_time"));
            }
            // 关闭资源
            JDBCUtils.closeAll(connection, prepareStatement, rs);
            return student;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}

