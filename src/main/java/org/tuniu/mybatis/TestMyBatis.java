package org.tuniu.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.tuniu.mybatis.entity.LwUser;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMyBatis {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        //读取mybatis-config配置文件
        InputStream stream = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream, "dev");
        //创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
//            List<LwUser> list = sqlSession.selectList("org.tuniu.mybatis.mapper.UserMapper.selectAllData");
            String name ="xiaoli";
            List<LwUser> list = sqlSession.selectList("org.tuniu.mybatis.mapper.UserMapper.listUserByUserName",name);
            for (LwUser lwUser : list) {
                System.out.println(lwUser.toString());
            }
        } finally {
            if (null != sqlSession) {
                sqlSession.close();
            }
        }
    }
}
