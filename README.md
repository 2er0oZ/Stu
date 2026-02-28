# 学生信息管理系统(Java Web)

## 功能模块

### 1. 管理员模块
*   **登录验证**：通过 Session 进行用户身份校验，防止未登录访问。
*   **学生管理**：
    *   添加学生信息（学号、姓名、性别、年龄、所在班级等）。
    *   修改学生信息。
    *   删除学生信息（支持单个删除与批量删除）。
    *   查询学生信息（支持模糊查询、分页显示）。
*   **班级/专业管理**：对学院、专业、班级信息的维护。

### 2. 学生模块 (如包含)
*   **个人信息查询**：学生登录后可查看个人档案。
*   **密码修改**：修改个人账户密码。

## 数据库设计
系统主要包含以下数据表（示例）：

*   **t_student (学生表)**
    *   `id`: 主键
    *   `student_id`: 学号
    *   `name`: 姓名
    *   `gender`: 性别
    *   `age`: 年龄
    *   `class_id`: 班级外键
*   **t_user / t_admin (用户/管理员表)**
    *   `id`: 主键
    *   `username`: 用户名
    *   `password`: 密码
    *   `role`: 角色

## 环境搭建与运行指南

### 前置要求
1.  JDK 1.8 或以上版本
2.  Tomcat 8.5 或 9.0
3.  MySQL 数据库
4.  Maven 3.x
5.  IDE (IntelliJ IDEA / Eclipse)

### 部署步骤

1.  **获取源码**
bash
git clone https://github.com/your-username/Stu-main.git


2.  **数据库配置**
    *   在 MySQL 中创建数据库（例如：`db_student`）。
    *   执行项目根目录下的 SQL 脚本（如 `sql/schema.sql` 或类似文件）创建数据表。
    *   修改 `src/main/resources/db.properties` 或 `JDBCUtil.java` 中的数据库连接信息（用户名、密码、URL）。

3.  **项目构建**
    *   使用 IDE 导入 Maven 项目。
    *   执行 `mvn clean install` 下载依赖并编译。

4.  **配置服务器**
    *   在 IDE 中配置 Tomcat 服务器，将项目 Artifact (`Stu-main:war exploded`) 部署到服务器中。

5.  **启动访问**
    *   启动 Tomcat。
    *   浏览器访问：`http://localhost:8080/项目名/` 。
    *   默认管理员账号/密码请参考代码注释或初始化 SQL 文件。
