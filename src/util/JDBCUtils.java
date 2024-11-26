package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 数据库连接工具类
 */
public class JDBCUtils {
	
	private static String url = "jdbc:mysql://localhost:3306/student?&serverTimezone=Asia/Shanghai";
	private static String username = "root";
	private static String password = "123456";
	
	static{
		try {
			// 加载驱动类
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取数据库连接方法
	 */
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 关闭资源方法
	 */
	public static void closeAll(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
		try {
			//如果resultSet不空，关闭resultSet
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//如果preparedStatement不为空，关闭preparedStatement
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
