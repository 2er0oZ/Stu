package bean;

import java.util.Date;

/**
 * 学生实体类
 */
public class Student {

    private String no;
    private String name;
    private String password;
    private String address;
    private String nationality;
    private String department;
    private String major;
    private String classes;
    private Date inDate;
    private Date createTime;

    public void setNo(String no) {
        this.no = no;
    }

    public String getNo() {
        return no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNationality() {
        return nationality;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getClasses() {
        return classes;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public Date getInDate() {
        return inDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Student{" +
                "no=" + no +
                ", name=" + name +
                ", password=" + password +
                ", address=" + address +
                ", nationality=" + nationality +
                ", department=" + department +
                ", major=" + major +
                ", classes=" + classes +
                ", inDate=" + inDate +
                ", createTime=" + createTime +
        '}';
    }
}


