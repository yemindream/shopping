package com.online.shopping.service;

import com.google.common.base.Strings;
import com.online.shopping.common.page.AppPage;
import com.online.shopping.common.page.PageModel;
import com.online.shopping.mapper.*;
import com.online.shopping.model.*;
import com.online.shopping.vo.ProductView;
import com.online.shopping.vo.PurchaseView;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by min.ye on 2020/6/2.
 */
@Service
public class ShoppingServiceImpl extends BaseService implements IShoppingService {

    @Resource
    private RegistrationMapper registrationMapper;

    @Resource
    private CustomerMapper customerMapper;

    @Resource
    private SellerMapper sellerMapper;

    @Resource
    private ProductMapper productMapper;

    @Resource
    private PaymentMapper paymentMapper;

    @Resource
    private PurchaseHistoryMapper purchaseHistoryMapper;

    @Resource
    private RatingMapper ratingMapper;

    @Resource
    private DeliveryAddressMapper deliveryAddressMapper;

    @Override
    public Registration selectByUserName(String userName) {
        if (Strings.isNullOrEmpty(userName)) {
            return null;
        }
        return registrationMapper.selectByUserName(userName);
    }

    @Override
    public void register(Registration registration) {
        int id = registrationMapper.insert(registration);
    }

    @Override
    public Customer selectByCustomerId(Integer id) {
        Customer customer = customerMapper.selectByPrimaryKey(id);
        return customer;
    }

    @Override
    public void updateCustomerSelective(Customer customer) {
        customerMapper.updateByPrimaryKeySelective(customer);
    }

    @Override
    public void insertCustomerSelective(Customer customer) {
        customerMapper.insertSelective(customer);
    }

    @Override
    public void insertSellerSelective(Seller seller) {
        sellerMapper.insertSelective(seller);
    }

    @Override
    public Product selectByProductId(Long id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateProductSelective(Product product) {
        productMapper.updateByPrimaryKeySelective(product);
    }

    @Override
    public void insertProductSelective(Product product) {
        productMapper.insertSelective(product);
    }

    @Override
    public AppPage<List<Product>> selectAllProduct(Integer currentpage, Integer perpage) {
        PageModel<List<Product>> page = new PageModel<>(perpage, currentpage);
        page.start();
        List<Product> result = productMapper.selectAll();
        page.setResult(result);
        return page.convertToAppPageModel();
    }

    @Override
    public Payment selectByPaymentId(Integer id) {
        return paymentMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updatePaymentSelective(Payment payment) {
        paymentMapper.updateByPrimaryKeySelective(payment);
    }

    @Override
    public void insertPaymentSelective(Payment payment) {
        paymentMapper.insertSelective(payment);
    }

    @Override
    public AppPage<List<PurchaseView>> selectPurchaseHistory(Integer currentpage, Integer perpage, Integer uid, String date) {
        PageModel<List<PurchaseView>> page = new PageModel<>(perpage, currentpage);
        page.start();
        List<PurchaseView> result = purchaseHistoryMapper.selectByUserAndDate(uid, date);
        page.setResult(result);
        return page.convertToAppPageModel();
    }

    @Override
    public void insertRatingSelective(Rating rate) {
        ratingMapper.insertSelective(rate);
    }

    @Override
    public PurchaseHistory selectPurchaseHistoryById(Long id) {
        return purchaseHistoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updatePurchase(PurchaseHistory ph) {
        purchaseHistoryMapper.updateByPrimaryKeySelective(ph);
    }

    @Override
    public List<ProductView> getProductInfoBySellerId(Integer sellerId) {
        return productMapper.getProductInfoBySellerId(sellerId);
    }

    @Override
    public List<ProductView> getAllProductInfo() {
        return productMapper.getAllProductInfo();
    }

    @Override
    public Seller selectBySellerId(Integer id) {
        return sellerMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateSellerSelective(Seller seller) {
        sellerMapper.updateByPrimaryKeySelective(seller);
    }

    @Override
    public List<Payment> getPaymentListByCustomerId(Integer customerId) {
        return paymentMapper.getPaymentListByCustomerId(customerId);
    }

    @Override
    public List<PurchaseHistory> getPurchaseHistoryListByCustomerId(Integer customerId, Date startDate, Date endDate) {
        try {
            String startDateStr = null;
            String endDateStr = null;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            if (startDate != null) {
                startDateStr = sdf.format(startDate);
            }
            if (endDate != null) {
                endDateStr = sdf.format(endDate);
            }
            return purchaseHistoryMapper.getPurchaseHistoryListByCustomerId(customerId, startDateStr, endDateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public void insertPurchaseHistory(PurchaseHistory purchaseHistory) {
        purchaseHistoryMapper.insertSelective(purchaseHistory);

        //更新商品库存数量
        Product product = productMapper.selectByPrimaryKey(purchaseHistory.getProductId());
        product.setQuantity(product.getQuantity() - purchaseHistory.getQuantity());
        productMapper.updateByPrimaryKey(product);
    }

    @Override
    public void insertDeliveryAddress(DeliveryAddress deliveryAddress) {
        deliveryAddressMapper.insertSelective(deliveryAddress);
    }

    @Override
    public void insertPayment(Payment payment) {
        paymentMapper.insertSelective(payment);
    }

    @Override
    public int cancelPurchase(Long phid) {
        Payment payment = paymentMapper.selectByPurchaseId(phid);
        if (payment != null && payment.getState() == 1) {
            logger.info("用户已经支付了该商品，无法取消（只能退货）");
            return 1;
        }
        PurchaseHistory purchaseHistory = purchaseHistoryMapper.selectByPrimaryKey(phid);
        purchaseHistory.setState(1);
        purchaseHistoryMapper.updateByPrimaryKey(purchaseHistory);

        //更新商品库存数量
        Product product = productMapper.selectByPrimaryKey(purchaseHistory.getProductId());
        product.setQuantity(product.getQuantity() + purchaseHistory.getQuantity());
        productMapper.updateByPrimaryKey(product);

        return 0;
    }

    @Override
    public int returnPurchase(Long phid) {
        Payment payment = paymentMapper.selectByPurchaseId(phid);
        if (payment==null || payment.getState() != 1) {
            logger.info("用户未支付该商品，无法退货");
            return 1;
        }
        if (payment!=null){
            payment.setState(3);
            paymentMapper.updateByPrimaryKey(payment);
        }

        PurchaseHistory purchaseHistory = purchaseHistoryMapper.selectByPrimaryKey(phid);
        purchaseHistory.setState(2);
        purchaseHistoryMapper.updateByPrimaryKey(purchaseHistory);

        //更新商品库存数量
        Product product = productMapper.selectByPrimaryKey(purchaseHistory.getProductId());
        product.setQuantity(product.getQuantity() + purchaseHistory.getQuantity());
        productMapper.updateByPrimaryKey(product);

        return 0;
    }


}
