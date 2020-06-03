package com.online.shopping.controller;

import com.online.shopping.service.IShoppingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by min.ye on 2020/6/3.
 */
public class BaseController {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    protected IShoppingService shoppingService;

}
