package com.online.shopping.base;


import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Base Mapper
 *
 * @author yemin
 *
 * @param <T>
 */
public interface BaseTkMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
