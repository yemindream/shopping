package com.online.shopping.service;

import com.online.shopping.common.page.AppPage;
import com.online.shopping.model.*;
import com.online.shopping.vo.PurchaseView;

import java.util.List;

/**
 * Created by min.ye on 2020/6/2.
 */
public interface IShoppingService {
    Registration selectByUserName(String userName);

    void register(Registration registration);

    Customer selectByCustomerId(Integer id);

    void updateCustomerSelective(Customer customer);

    Seller selectBySellerId(Integer id);

    void updateSellerSelective(Seller seller);

    void insertCustomerSelective(Customer customer);

    void insertSellerSelective(Seller seller);

    Product selectByProductId(Long id);

    void updateProductSelective(Product product);

    void insertProductSelective(Product product);

    AppPage<List<Product>> selectAllProduct(Integer currentpage, Integer perpage);

    Payment selectByPaymentId(Integer id);

    void updatePaymentSelective(Payment payment);

    void insertPaymentSelective(Payment payment);

    AppPage<List<PurchaseView>> selectPurchaseHistory(Integer integer, Integer currentpage, Integer perpage, String date);

    void insertRatingSelective(Rating rate);

    PurchaseHistory selectPurchaseHistoryById(Long id);

    void updatePurchase(PurchaseHistory ph);
}
