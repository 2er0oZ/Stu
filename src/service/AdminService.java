package service;

import java.util.List;

import dao.AdminDao;
import bean.Admin;

/**
 * 管理员业务处理类
 */
public class AdminService {

    // 创建数据库操作对象
    private AdminDao adminDao = new AdminDao();

    /**
     * 添加管理员
     * @param admin
     * @return
     */
    public int add(Admin admin) {
        return adminDao.add(admin);
    }

    /**
     * 删除管理员
     * @param username
     * @return
     */
    public int delete(String username) {
        return adminDao.delete(username);
    }

    /**
     * 更新管理员
     * @param admin
     * @return
     */
    public int update(Admin admin) {
        return adminDao.update(admin);
    }

    /**
     * 获取管理员
     * @return
     */
    public List<Admin> getAllAdmin(String username) {
        return adminDao.getAllAdmin(username);
    }

    /**
     * 根据username获取管理员详情
     * @param username
     * @return
     */
    public Admin getAdminByUsername(String username) {
        return adminDao.getAdminByUsername(username);
    }
}

