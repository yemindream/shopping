package com.online.shopping.base;


import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Base Mapper
 *
 * @param <T>
 */
public interface BaseTkMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
