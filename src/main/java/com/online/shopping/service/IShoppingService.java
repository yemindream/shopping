package com.online.shopping.service;

import com.online.shopping.common.page.AppPage;
import com.online.shopping.model.*;
import com.online.shopping.vo.ProductView;
import com.online.shopping.vo.PurchaseView;

import java.time.LocalDate;
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

//    void insertRatingSelective(Rating rate);

    PurchaseHistory selectPurchaseHistoryById(Long id);

    void updatePurchase(PurchaseHistory ph);

    List<ProductView> getProductInfoBySellerId(Integer sellerId);

    /**
     * 查询所有ProductView
     *
     * @return
     */
    List<ProductView> getAllProductInfo();

    /**
     * 根据customerId获取payment列表
     *
     * @param customerId
     * @return
     */
    List<Payment> getPaymentListByCustomerId(Integer customerId);

    /**
     * 根据customerId获取PurchaseHistory列表，按时间段筛选
     *
     * @param customerId
     * @param startDate
     * @param endDate
     * @return
     */
    List<PurchaseHistory> getPurchaseHistoryListByCustomerId(Integer customerId, LocalDate startDate, LocalDate endDate);

    /**
     * 插入PurchaseHistory(自动更新商品数量)
     *
     * @param purchaseHistory
     */
    void insertPurchaseHistory(PurchaseHistory purchaseHistory);

    /**
     * 插入deliveryAddress
     *
     * @param deliveryAddress
     */
    void insertDeliveryAddress(DeliveryAddress deliveryAddress);

    /**
     * 插入payment
     *
     * @param payment
     */
    void insertPayment(Payment payment);

    /**
     * 取消下单（更新购物状态，更新商品库存）
     *
     * @param phid 购物记录id号
     * @return 返回0, 取消成功
     * 返回1，用于已支付，无法取消（只能退货）
     */
    int cancelPurchase(Long phid);

    /**
     * 退货（更新支付状态，更新购物状态，更新库存）
     *
     * @param phid
     * @return 返回0，退货成功
     * 返回1，用户未支付该商品，无法退货
     */
    int returnPurchase(Long phid);
}
