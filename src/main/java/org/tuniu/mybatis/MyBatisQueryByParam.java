package org.tuniu.mybatis;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.tuniu.mybatis.entity.LwUser;
import org.tuniu.mybatis.entity.LwUserListJob;
import org.tuniu.mybatis.mapper.UserMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisQueryByParam {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        //1.读取mybatis-config配置文件
        InputStream stream = Resources.getResourceAsStream(resource);
        //2.//创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        //3.创建SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();
        /**
         * 相比较于session.selectList("com.xxx.UserMapper.listAllUser")来实现查询，
         * 下面这种通过先获取mapper再挑用mapper中方法的方式会更灵活
         */
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<LwUserListJob> lwUserListJobs = userMapper.listUserAndJob1();//测试一对多查询
        System.out.println(null == lwUserListJobs ? "" : JSONObject.toJSONString(lwUserListJobs));
        System.out.println("--------------------------------------------");
        List<LwUser> lwUsers = userMapper.listUserAndJob();//一对一查询
        System.out.println(null == lwUsers ? "" : JSONObject.toJSONString(lwUsers));
        System.out.println("--------------------------------------------");
        LwUser userList = userMapper.listUserByUserName("t1");
        System.out.println(null == userList ? "" : JSONObject.toJSONString(userList));

        List<LwUser> userList2 = userMapper.listUserByTable("lw_user");
        System.out.println(null == userList2 ? "" : JSONObject.toJSONString(userList2));
    }
}
