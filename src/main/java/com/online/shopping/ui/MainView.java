package com.online.shopping.ui;

import com.online.shopping.model.Customer;
import com.online.shopping.model.Registration;
import com.online.shopping.model.Seller;
import com.online.shopping.service.IShoppingService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

/**
 * Created by yanry on 2020/6/4.
 */
@Route
public class MainView extends FormLayout {
    @Autowired
    private IShoppingService shoppingService;

    public MainView() {
        setWidth("70%");

        TextField tfUsername = new TextField("Username");
        tfUsername.setPlaceholder("Enter Username");

        TextField tfPassword = new TextField("Password");
        tfPassword.setPlaceholder("Enter Password");

        Label lblMsg = new Label();

        Button btnLogin = new Button("Login", event -> {
            String username = tfUsername.getValue();
            Registration registration = shoppingService.selectByUserName(username);
            if (registration == null) {
                lblMsg.setText(String.format("user [%s] does not exist!", username));
            } else if (Objects.equals(tfPassword.getValue(), registration.getPassword())) {
                Integer userId = registration.getUserId();
                Seller seller = shoppingService.selectBySellerId(userId);
                if (seller != null) {
                    UI.getCurrent().navigate(SellerPage.class, userId);
                    return;
                }
                Customer customer = shoppingService.selectByCustomerId(userId);
                if (customer == null) {
                    customer = new Customer();
                    customer.setId(userId);
                    customer.setName(username);
                    shoppingService.insertCustomerSelective(customer);
                }
                UI.getCurrent().navigate(CustomerPage.class, userId);
            } else {
                lblMsg.setText("incorrect password!");
            }
        });

        Button btnRegister = new Button("Create New Account", event -> {
            UI.getCurrent().navigate(RegisterPage.class);
        });

        add(tfUsername, tfPassword, btnLogin, lblMsg, btnRegister);
    }
}
