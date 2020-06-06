package com.online.shopping.mapper;

import com.online.shopping.model.Payment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaymentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Payment record);

    int insertSelective(Payment record);

    Payment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Payment record);

    int updateByPrimaryKey(Payment record);

    List<Payment> getPaymentListByCustomerId(@Param("id") Integer customerId);

    Payment selectByPurchaseId(@Param("id") Long phid);
}
