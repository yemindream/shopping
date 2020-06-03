package com.online.shopping.controller;

import com.online.shopping.common.result.ResultJson;
import com.online.shopping.common.result.ResultUtil;
import com.online.shopping.model.Seller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by min.ye on 2020/6/3.
 */
@RestController
@RequestMapping("seller")
public class SellerController extends BaseController {

    /**
     * 更新卖家信息
     *
     * @param seller
     * @param seller
     * @return
     */
    @PostMapping("saveOrUpdate")
    public ResultJson updateSellerInfo(
            @RequestBody Seller seller) {
        try {
            if (seller == null) {
                return ResultUtil.failWithMsg("参数错误");
            }
            boolean isUpdate = (seller.getId() != null) && (seller.getId() > 0);
            if (isUpdate) {
                Seller ct = shoppingService.selectBySellerId(seller.getId());
                if (ct == null) {
                    return ResultUtil.failWithMsg("卖家不存在");
                }
                seller.setId(ct.getId());
                shoppingService.updateSellerSelective(seller);
                return ResultUtil.successWithMsg("更新成功");
            } else {
                shoppingService.insertSellerSelective(seller);
                return ResultUtil.successWithMsg("保存成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.failWithMsg("更新失败");
    }
}
