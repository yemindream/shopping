package com.online.shopping.mapper;

import com.online.shopping.base.BaseTkMapper;
import com.online.shopping.model.Product;
import com.online.shopping.vo.ProductView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper extends BaseTkMapper<Product> {
//    int deleteByPrimaryKey(Long id);
//
//    int insert(Product record);
//
//    int insertSelective(Product record);
//
//    Product selectByPrimaryKey(Long id);
//
//    int updateByPrimaryKeySelective(Product record);
//
//    int updateByPrimaryKeyWithBLOBs(Product record);
//
//    int updateByPrimaryKey(Product record);

    List<Product> selectAll();

    List<ProductView> getProductInfoBySellerId(@Param("id") Integer sellerId);

    List<ProductView> getAllProductInfo();
}
