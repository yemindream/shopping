package com.online.shopping.controller;

import com.google.common.base.Strings;
import com.online.shopping.common.result.ResultJson;
import com.online.shopping.common.result.ResultUtil;
import com.online.shopping.model.Customer;
import com.online.shopping.model.DeliveryAddress;
import com.online.shopping.model.Registration;
import org.springframework.web.bind.annotation.*;

/**
 * Created by min.ye on 2020/6/2.
 */
@RestController
@RequestMapping("account")
public class AccountController extends BaseController {

//    /**
//     * 登陆
//     *
//     * @param registration
//     * @return
//     */
//    @PostMapping
//    public ResultJson login(@RequestBody Registration registration) {
//        if (Strings.isNullOrEmpty(registration.getUsername())
//                || Strings.isNullOrEmpty(registration.getPassword())) {
//            return ResultUtil.failWithMsg("username和password不能为空");
//        }
//        Registration user = shoppingService.selectByUserName(registration.getUsername());
//        if (user == null || !user.getPassword().equals(registration.getPassword())) {
//            return ResultUtil.failWithMsg("用户名或密码错误");
//        }
//        return ResultUtil.successWithMsg("登陆成功");
//    }

    /**
     * 检查用户是否已经有帐号
     *
     * @param userName
     * @return
     */
    @RequestMapping("/check")
    public ResultJson check(@RequestParam("userName") String userName) {
        Registration user = shoppingService.selectByUserName(userName);
        return ResultUtil.successWithMsg(user != null ? "用户已存在" : "用户不存在");
    }

    /**
     * 注册一个新用户
     *
     * @param registration
     * @return
     */
    @PostMapping("/register")
    public ResultJson register(@RequestBody Registration registration) {
        if (registration == null) {
            return ResultUtil.failWithMsg("参数不能为空");
        }
        if (Strings.isNullOrEmpty(registration.getUsername())) {
            return ResultUtil.failWithMsg("username不能为空");
        }
        if (Strings.isNullOrEmpty(registration.getPassword())) {
            return ResultUtil.failWithMsg("password不能为空");
        }
        if (Strings.isNullOrEmpty(registration.getConfirmationCode())) {
            return ResultUtil.failWithMsg("confirmationCode不能为空");
        }
        try {
            Registration user = shoppingService.selectByUserName(registration.getUsername());
            if (user != null) {
                return ResultUtil.failWithMsg("帐号已存在，注册失败");
            }
            shoppingService.register(registration);
            return ResultUtil.successWithMsg("注册成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.failWithMsg("注册失败");
    }

    /**
     * 测试
     *
     * @return
     */
    @PostMapping("/test")
    public ResultJson register(@RequestBody DeliveryAddress deliveryAddress) {
        shoppingService.insertDeliveryAddress(deliveryAddress);
        return ResultUtil.successWithMsg("成功");
    }

    /**
     * 测试2
     *
     * @return
     */
    @PostMapping("/test2")
    public ResultJson<Object> register(@RequestParam("id") Integer id) {
        Customer customer = shoppingService.selectByCustomerId(id);
        return ResultUtil.successWithData(customer);
    }
}
