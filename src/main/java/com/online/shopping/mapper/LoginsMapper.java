package com.online.shopping.mapper;

import com.online.shopping.model.Logins;

public interface LoginsMapper {
    int insert(Logins record);

    int insertSelective(Logins record);
}