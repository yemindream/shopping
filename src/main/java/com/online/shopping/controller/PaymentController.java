package com.online.shopping.controller;

import com.online.shopping.common.result.ResultJson;
import com.online.shopping.common.result.ResultUtil;
import com.online.shopping.model.Payment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by min.ye on 2020/6/3.
 */
@RestController
@RequestMapping("payment")
public class PaymentController extends BaseController {


    /**
     * 保存或更新支付信息
     *
     * @param payment
     * @return
     */
    @PostMapping("saveOrUpdate")
    public ResultJson updateProductInfo(@RequestBody Payment payment) {
        try {
            if (payment == null) {
                return ResultUtil.failWithMsg("参数错误");
            }
            boolean isUpdate = (payment.getId() != null) && (payment.getId() > 0);
            if (isUpdate) {
                Payment ct = shoppingService.selectByPaymentId(payment.getId());
                if (ct == null) {
                    return ResultUtil.failWithMsg("支付信息不存在");
                }
                payment.setId(ct.getId());
                shoppingService.updatePaymentSelective(payment);
                return ResultUtil.successWithMsg("更新成功");
            } else {
                shoppingService.insertPaymentSelective(payment);
                return ResultUtil.successWithMsg("保存成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.failWithMsg("失败");
    }
}
