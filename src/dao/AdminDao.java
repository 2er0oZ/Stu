package dao;

import java.sql.*;
import java.util.List;

import bean.Admin;
import util.JDBCUtils;

import java.util.ArrayList;

public class AdminDao {

    /**
	 * 添加管理员
	 * @param admin
	 * @return
	 */
    public int add(Admin admin) {
        // 获取数据库连接
        Connection connection = JDBCUtils.getConnection();
        // 编写sql
        String sql = "insert into admin(username, password, realname, sex, create_time) values(?, ?, ?, ?, ?)";
        try {
            // 预编译sql
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            // 添加参数
            prepareStatement.setString(1, admin.getUsername());
            prepareStatement.setString(2, admin.getPassword());
            prepareStatement.setString(3, admin.getRealname());
            prepareStatement.setString(4, admin.getSex());
            prepareStatement.setDate(5, new Date(admin.getCreateTime().getTime()));
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
	 * 删除管理员
	 * @param username
	 * @return
	 */
    public int delete(String username) {
        // 获取数据库连接
        Connection connection = JDBCUtils.getConnection();
        // 编写sql
        String sql = "delete from admin where username = ?";
        try {
            // 预编译sql
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            // 添加参数
            prepareStatement.setString(1, username);

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
     * 更新管理员
     * @param admin
     * @return
     */
    public int update(Admin admin) {
        // 获取数据库连接
        Connection connection = JDBCUtils.getConnection();
        // 编写sql
        String sql = "update admin set password = ?,realname = ?,sex = ? where username = ?";
        try {
            // 预编译sql
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            // 添加参数
            prepareStatement.setString(1, admin.getPassword());
            prepareStatement.setString(2, admin.getRealname());
            prepareStatement.setString(3, admin.getSex());
            prepareStatement.setString(4, admin.getUsername());
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
	 * 获取管理员
	 * @return
	 */
    public List<Admin> getAllAdmin(String username) {
        // 获取数据库连接
        Connection connection = JDBCUtils.getConnection();
        // 编写sql
        String sql = "select * from admin where 1=1 ";
        // 拼接模糊查询条件
        if (username != null && !username.equals("")) {
        	sql += "and username like '%" + username + "%'";
        }

        try {
            // 预编译sql
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            // 执行sql
            ResultSet rs = prepareStatement.executeQuery();
            List<Admin> admins = new ArrayList<Admin>();
            while (rs.next()) {
                Admin admin = new Admin();
                admin.setUsername(rs.getString("username"));
                admin.setPassword(rs.getString("password"));
                admin.setRealname(rs.getString("realname"));
                admin.setSex(rs.getString("sex"));
                admin.setCreateTime(rs.getDate("create_time"));
                admins.add(admin);
            }
            // 关闭资源
            JDBCUtils.closeAll(connection, prepareStatement, rs);
            return admins;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /**
	 * 根据username获取管理员详情
	 * @param username
	 * @return
	 */
    public Admin getAdminByUsername(String username) {
        // 获取数据库连接
        Connection connection = JDBCUtils.getConnection();
        // 编写sql
        String sql = "select * from admin where username = ?";

        try {
            // 预编译sql
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, username);
            // 执行sql
            ResultSet rs = prepareStatement.executeQuery();
            Admin admin = null;
            while (rs.next()) {
                admin = new Admin();
                admin.setUsername(rs.getString("username"));
                admin.setPassword(rs.getString("password"));
                admin.setRealname(rs.getString("realname"));
                admin.setSex(rs.getString("sex"));
                admin.setCreateTime(rs.getDate("create_time"));
            }
            // 关闭资源
            JDBCUtils.closeAll(connection, prepareStatement, rs);
            return admin;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
