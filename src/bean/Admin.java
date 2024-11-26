package bean;

import java.util.Date;

/**
 * 管理员实体类
 */
public class Admin {

    /** 用户名 */
    private String username;

    /** 密码 */
    private String password;

    /** 真实姓名 */
    private String realname;

    /** 性别 */
    private String sex;

    /** 创建时间 */
    private Date createTime;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getRealname() {
        return realname;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "username=" + username +
                ", password=" + password +
                ", realname=" + realname +
                ", sex=" + sex +
                ", createTime=" + createTime +
        '}';
    }
}

