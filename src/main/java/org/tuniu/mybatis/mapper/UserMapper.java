package org.tuniu.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.tuniu.mybatis.entity.LwUser;
import org.tuniu.mybatis.entity.LwUserListJob;

import java.util.List;


public interface UserMapper {

    List<LwUser> selectAllData();

    LwUser listUserByUserName(String userName);

    int insert2(LwUser lwUser);

    List<LwUser> selectUserAndJob();

    List<LwUser> listUserByTable(@Param("tableName") String tableName);

    List<LwUser> listUserAndJob();

    List<LwUserListJob> listUserAndJob1();

    List<LwUser> list(LwUser lwUser);

    List<LwUser> list1(LwUser lwUser);


}
