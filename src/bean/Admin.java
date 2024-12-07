package bean;

import java.util.Date;

/**
 * 管理员实体类
 */
public class Admin {
    private String username;
    private String password;
    private String realname;
    private String sex;
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

