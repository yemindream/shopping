package com.online.shopping.controller;

import com.online.shopping.common.page.AppPage;
import com.online.shopping.common.result.ResultJson;
import com.online.shopping.common.result.ResultUtil;
import com.online.shopping.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by min.ye on 2020/6/3.
 */
@RestController
@RequestMapping("product")
public class ProductController extends BaseController {

    /**
     * 保存或更新商品信息
     *
     * @param product
     * @return
     */
    @PostMapping("saveOrUpdate")
    public ResultJson updateProductInfo(
            @RequestBody Product product) {
        try {
            if (product == null) {
                return ResultUtil.failWithMsg("参数错误");
            }
            boolean isUpdate = (product.getId() != null) && (product.getId() > 0);
            if (isUpdate) {
                Product ct = shoppingService.selectByProductId(product.getId());
                if (ct == null) {
                    return ResultUtil.failWithMsg("商品不存在");
                }
                product.setId(ct.getId());
                shoppingService.updateProductSelective(product);
                return ResultUtil.successWithMsg("更新成功");
            } else {
                shoppingService.insertProductSelective(product);
                return ResultUtil.successWithMsg("保存成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.failWithMsg("失败");
    }

    /**
     * 查询商品
     *
     * @return
     */
    @GetMapping("selectAll")
    public ResultJson selectProduct(
            @RequestParam(required = false, value = "currentpage") final Integer currentpage,
            @RequestParam(required = false, value = "perpage") final Integer perpage
    ) {
        AppPage<List<Product>> page = shoppingService.selectAllProduct(currentpage, perpage);
        return ResultUtil.successWithData(page);
    }

}
