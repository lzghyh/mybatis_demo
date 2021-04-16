package org.tuniu.mybatis.mapper;

import org.tuniu.mybatis.entity.UserAddress;

import java.util.List;

public interface UserAddressMapper {
    int insertUserAddress(UserAddress userAddress);

    int insertUserAddressList(List<UserAddress> list);

    List<UserAddress> selectUserAddress();

    List<UserAddress> selectUserAddress1();
}
