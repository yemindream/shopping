package com.online.shopping.controller;

import com.online.shopping.common.page.AppPage;
import com.online.shopping.common.result.ResultJson;
import com.online.shopping.common.result.ResultUtil;
import com.online.shopping.model.PurchaseHistory;
import com.online.shopping.vo.PurchaseView;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by min.ye on 2020/6/3.
 */
@RestController
@RequestMapping("purchase")
public class PurchaseController extends BaseController {

    /**
     * 查询购物历史
     *
     * @return
     */
    @GetMapping("/history/info")
    public ResultJson getPurchasedInformation(
            @RequestParam(required = false, value = "currentpage") final Integer currentpage,
            @RequestParam(required = false, value = "perpage") final Integer perpage,
            @RequestParam(required = false, value = "date") String date
    ) {
        int uid = 1;
        AppPage<List<PurchaseView>> page = shoppingService.selectPurchaseHistory(currentpage, perpage, uid, date);
        return ResultUtil.successWithData(page);
    }

    @RequestMapping("/{operation}")
    public ResultJson updatePurchase(
            @PathVariable("operation") String ope,
            @RequestParam("id") Long id
    ) {
        try {
            int status;
            if ("cancel".equals(ope)) {
                status = 1;
            } else if ("sendback".equals(ope)) {
                status = 2;
            } else {
                return ResultUtil.failWithMsg("操作无效");
            }
            PurchaseHistory ph = shoppingService.selectPurchaseHistoryById(id);
            ph.setState(status);
            shoppingService.updatePurchase(ph);
            return ResultUtil.successWithMsg("操作成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.failWithMsg("操作成功");
    }

}
