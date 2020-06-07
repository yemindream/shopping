package com.online.shopping.ui;

import com.online.shopping.model.DeliveryAddress;
import com.online.shopping.model.Payment;
import com.online.shopping.model.Product;
import com.online.shopping.model.PurchaseHistory;
import com.online.shopping.service.IShoppingService;
import com.online.shopping.vo.ProductView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ReadOnlyHasValue;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by yanry on 2020/6/6.
 */
@Route(value = "customer/product", layout = MainLayout.class)
public class CustomerProductPage extends HorizontalLayout implements HasUrlParameter<Integer> {
    private Grid<ProductView> grid = new Grid<>(ProductView.class);
    @Autowired
    private IShoppingService shoppingService;
    private int customerId;

    public CustomerProductPage() {
        PurchaseForm purchaseForm = new PurchaseForm();
        grid.setColumns("type", "seller", "price", "quantity", "description", "avgRatingValue");
        grid.asSingleSelect().addValueChangeListener(event -> purchaseForm.binder.setBean(grid.asSingleSelect().getValue()));
        grid.setSizeFull();

        add(grid, purchaseForm);
        setSizeFull();
    }

    @Override
    public void setParameter(BeforeEvent event, Integer parameter) {
        customerId = parameter;
        listProduct();
    }

    private void listProduct() {
        grid.setItems(shoppingService.getAllProductInfo());
    }

    private class PurchaseForm extends FormLayout {
        private Binder<Product> binder = new Binder<>();

        public PurchaseForm() {
            Label productId = new Label();
            binder.forField(new ReadOnlyHasValue<>(id -> productId.setText("Product Id: " + id)))
                    .bind(product -> product.getId(), null);

            IntegerField quantity = new IntegerField("Quantity");
            TextField receiverName = new TextField("Receiver Name");
            TextField state = new TextField("State");
            TextField city = new TextField("City");
            TextField street = new TextField("Street");
            TextField zip = new TextField("Zip");
            TextField phone = new TextField("Phone");
            TextField email = new TextField("Email");
            TextField emergencyPhone = new TextField("Emergency Phone");
            TextField cardType = new TextField("Card Type");
            TextField cardHolder = new TextField("Card Holder");
            TextField billingAddress = new TextField("Billing Address");
            DatePicker expirationDate = new DatePicker("Expiration Date");

            Button btnBuy = new Button("Purchase", event -> {
                Product product = binder.getBean();
                DeliveryAddress deliveryAddress = new DeliveryAddress(receiverName.getValue(), state.getValue(),
                        city.getValue(), street.getValue(), zip.getValue(), phone.getValue(), email.getValue(),
                        emergencyPhone.getValue(), customerId);
                shoppingService.insertDeliveryAddress(deliveryAddress);
                PurchaseHistory purchaseHistory = new PurchaseHistory(product.getId(), quantity.getValue(),
                        deliveryAddress.getId());
                shoppingService.insertPurchaseHistory(purchaseHistory);
                Payment payment = new Payment(cardType.getValue(), cardHolder.getValue(), billingAddress.getValue(),
                        expirationDate.getValue(), product.getPrice() * quantity.getValue(),
                        purchaseHistory.getId());
                shoppingService.insertPayment(payment);
                UI.getCurrent().navigate(CustomerPage.class, customerId);
            });

            add(productId, quantity, receiverName, state, city, street, zip, phone, email, emergencyPhone,
                    cardType, cardHolder, billingAddress, expirationDate, btnBuy);
        }
    }
}
