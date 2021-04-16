package org.tuniu.mybatis.util;

import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.tuniu.mybatis.entity.LwUser;

import java.sql.*;
import java.util.List;

public class TestDbUtil {
    public static void main(String[] args) {
        try {
            Connection conn = null;
            //1.注册JDBC驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.打开连接,获取connection对象
            conn = DriverManager.getConnection("jdbc:mysql://114.215.201.117/spring5?serverTimezone=GMT%2B8&useSSL=false", "root", "li199852");
            QueryRunner queryRunner = new QueryRunner();
            String sql = "select * from lw_user where user_id  = ?";
            //开启驼峰
            GenerousBeanProcessor bean = new GenerousBeanProcessor();
            RowProcessor processor = new BasicRowProcessor(bean);
            //执行查询
            //List<LwUser> list = queryRunner.query(conn, sql, new BeanListHandler<LwUser>(LwUser.class, processor));

            Object[] params = new Object[1];
            params[0] = "1";
            List<LwUser> lwUsers = queryRunner.query(conn,sql,new BeanListHandler<LwUser>(LwUser.class,processor),params);

            for (LwUser item : lwUsers) {
                System.out.println(item.toString());
            }
            //关闭连接
            DbUtils.closeQuietly(conn);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
