package org.tuniu.mybatis.util;


import org.tuniu.mybatis.entity.LwUser;

import java.sql.*;

public class TestJDBC {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        /**步骤:
         * 1、注册驱动，并通过指定的数据库url，账号密码等信息来建立连接
         * 2、打开连接，获取Connection对象
         * 3、通过Connection获取Statement对象
         * 4、通过Statement对象操作SQL语句，获得结果集ResultSet对象
         * 5、通过ResultSet对象获取结果集，并将结果集转换为Java对象
         * 6、关闭数据库连接相关资源
         */
        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.打开链接获取Connection对象
            conn = DriverManager.getConnection("jdbc:mysql://114.215.201.117/spring5?serverTimezone=GMT%2B8&useSSL=false", "root", "li199852");
            //3、获得Statement对象
            stmt = conn.createStatement();
            //4.执行sql语句获取结果集ResultSet
            String sql = "select * from lw_user";
            //有条件查询
            String sql1 = "select * from lw_user where user_id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql1);
            preparedStatement.setString(1,"2");//第1个1表示参数位置，第二个是参数的值
            ResultSet resultSet1 = preparedStatement.executeQuery();
            ResultSet resultSet = stmt.executeQuery(sql);
            //5.将结果转为java对象
            while (resultSet1.next()) {
                LwUser lwUser = new LwUser();
                String user_id = resultSet1.getString("user_id");
                String user_name = resultSet1.getString("user_name");
                lwUser.setUserId(user_id);
                lwUser.setUserName(user_name);
                System.out.println(lwUser);
            }
            //6.关闭资源
            resultSet1.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (null != stmt) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (null != conn ) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
