package com.online.shopping.mapper;

import com.online.shopping.model.Registration;
import org.apache.ibatis.annotations.Param;

public interface RegistrationMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(Registration record);

    int insertSelective(Registration record);

    Registration selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(Registration record);

    int updateByPrimaryKey(Registration record);

    Registration selectByUserName(@Param("username") String userName);
}
