package org.tuniu.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.tuniu.mybatis.entity.LwUser;
import org.tuniu.mybatis.entity.UserAddress;
import org.tuniu.mybatis.mapper.UserAddressMapper;
import org.tuniu.mybatis.mapper.UserMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TestMyBatisInsert {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        //读取mybatis-config配置文件
        InputStream stream = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream, "dev");
        //创建SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();
        try {
            LwUser lwUser = new LwUser();
            lwUser.setUserName("xiaoli");
            UserMapper userAddress = session.getMapper(UserMapper.class);
            int i = userAddress.insert2(lwUser);
            session.commit();
            System.out.println("插入成功数：" + i);
            System.out.println("插入数据的username为：" + lwUser.getUserId());
        } finally {
            session.close();
        }
        session = sqlSessionFactory.openSession();
        try {
            UserAddress userAddress = new UserAddress();
            UserAddress userAddress1 = new UserAddress();
            UserAddress userAddress2 = new UserAddress();
            userAddress.setAddress("广东深圳");
            userAddress1.setAddress("广东珠海");
            userAddress2.setAddress("广东汕头");
            UserAddressMapper mapper = session.getMapper(UserAddressMapper.class);
//            int count = mapper.insertUserAddress(userAddress);
            List<UserAddress> list = new ArrayList<UserAddress>();
            list.add(userAddress);
            list.add(userAddress1);
            list.add(userAddress2);
            int count = mapper.insertUserAddressList(list);
            session.commit();
            System.out.println("插入成功数：" + count);
            System.out.print("插入数据的主键为：");
            for (UserAddress address : list) {
                System.out.print(address.getId() + ",");
            }
        } finally {
            if (null != session) {
                session.close();
            }
        }
    }
}
