package com.online.shopping.mapper;

import com.online.shopping.model.PurchaseHistory;
import com.online.shopping.vo.PurchaseView;

import java.util.List;

public interface PurchaseHistoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PurchaseHistory record);

    int insertSelective(PurchaseHistory record);

    PurchaseHistory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PurchaseHistory record);

    int updateByPrimaryKey(PurchaseHistory record);

    List<PurchaseView> selectByUserAndDate(Integer uid, String date);
}
