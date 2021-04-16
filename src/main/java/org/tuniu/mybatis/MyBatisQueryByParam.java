package org.tuniu.mybatis;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.tuniu.mybatis.entity.LwUser;
import org.tuniu.mybatis.mapper.UserMapper;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class MyBatisQueryByParam {
    public static void main(String[] args) throws IOException {
        String config = "mybatis-config.xml";
        //1.读取mybatis-config配置文件
        InputStream stream = Resources.getResourceAsStream(config);
        //2.//创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        //3.创建SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();
        /**
         * 相比较于session.selectList("com.xxx.UserMapper.listAllUser")来实现查询，
         * 下面这种通过先获取mapper再挑用mapper中方法的方式会更灵活
         */
        UserMapper userMapper = session.getMapper(UserMapper.class);
        LwUser userList = userMapper.listUserByUserName("xiaoli");
        System.out.println(null == userList ? "": JSONObject.toJSONString(userList));
        List<LwUser> userList2 = userMapper.listUserByTable("lw_user");
        System.out.println(null == userList2 ? "": JSONObject.toJSONString(userList2));
    }
}
