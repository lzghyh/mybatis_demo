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

public class OtherTest {
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
        List<LwUserListJob> lwUserListJobs1 = userMapper.selectUserAndJob();//延迟加载(解决N+1问题)
        System.out.println("查询结果的数据："+lwUserListJobs1.size());//不会触发
        System.out.println("--------------------------------------------");
        System.out.println("查询一条数据："+lwUserListJobs1.get(0).getUserJobList());//触发
        System.out.println("--------------------------------------------");
        System.out.println(null == lwUserListJobs1 ? "": JSONObject.toJSONString(lwUserListJobs1));//触发
        session.close();
    }
}
