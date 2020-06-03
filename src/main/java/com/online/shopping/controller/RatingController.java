package com.online.shopping.controller;

import com.online.shopping.common.result.ResultJson;
import com.online.shopping.common.result.ResultUtil;
import com.online.shopping.model.Rating;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by min.ye on 2020/6/3.
 */
@RestController
@RequestMapping("rate")
public class RatingController extends BaseController {

    /**
     * 新增评分
     *
     * @param rate
     * @return
     */
    @PostMapping
    public ResultJson addRate(@RequestBody Rating rate) {
        try {
            shoppingService.insertRatingSelective(rate);
            return ResultUtil.successWithMsg("保存成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.failWithMsg("失败");
    }
}
