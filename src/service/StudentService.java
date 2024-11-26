package service;

import java.util.Date;
import java.util.List;
import bean.Student;

import dao.StudentDao;

/**
 * 学生业务处理类
 */
public class StudentService {

    // 创建数据库操作对象
    private StudentDao studentDao = new StudentDao();

    /**
     * 添加学生
     * @param student
     * @return
     */
    public int add(Student student) {
    	student.setCreateTime(new Date());
        return studentDao.add(student);
    }

    /**
     * 删除学生
     * @param no
     * @return
     */
    public int delete(String no) {
        return studentDao.delete(no);
    }

    /**
     * 更新学生
     * @param student
     * @return
     */
    public int update(Student student) {
        return studentDao.update(student);
    }

    /**
     * 获取学生
     * @return
     */
    public List<Student> getAllStudent(String no, String name) {
        return studentDao.getAllStudent(no, name);
    }

    /**
     * 根据no获取学生详情
     * @param no
     * @return
     */
    public Student getStudentByNo(String no) {
        return studentDao.getStudentByNo(no);
    }
}
