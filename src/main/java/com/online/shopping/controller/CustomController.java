package com.online.shopping.controller;

import com.online.shopping.common.result.ResultJson;
import com.online.shopping.common.result.ResultUtil;
import com.online.shopping.model.Customer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by min.ye on 2020/6/3.
 */
@RestController
@RequestMapping("customer")
public class CustomController extends BaseController {

    /**
     * 保存或更新客户信息
     *
     * @param customer
     * @return
     */
    @PostMapping("saveOrUpdate")
    public ResultJson updateCustomerInfo(
            @RequestBody Customer customer) {
        try {
            if (customer == null) {
                return ResultUtil.failWithMsg("参数错误");
            }
            boolean isUpdate = (customer.getId() != null) && (customer.getId() > 0);
            if (isUpdate) {
                Customer ct = shoppingService.selectByCustomerId(customer.getId());
                if (ct == null) {
                    return ResultUtil.failWithMsg("客户不存在");
                }
                customer.setId(ct.getId());
                shoppingService.updateCustomerSelective(customer);
                return ResultUtil.successWithMsg("更新成功");
            } else {
                shoppingService.insertCustomerSelective(customer);
                return ResultUtil.successWithMsg("保存成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.failWithMsg("失败");
    }
}
