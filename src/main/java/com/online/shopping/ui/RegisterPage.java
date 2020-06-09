package com.online.shopping.ui;

import com.online.shopping.model.Customer;
import com.online.shopping.model.Registration;
import com.online.shopping.model.Seller;
import com.online.shopping.service.IShoppingService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "register", layout = MainLayout.class)
public class RegisterPage extends FormLayout {
    @Autowired
    private IShoppingService shoppingService;

    public RegisterPage() {
        TextField tfUsername = new TextField("Username");
        tfUsername.setPlaceholder("Username");

        TextField tfPassword = new TextField("Password");
        tfPassword.setPlaceholder("Password");

        TextField tfConfirmationCode = new TextField("Confirmation Code");
        tfConfirmationCode.setPlaceholder("Confirmation Code");

        TextField tfConfirmationPage = new TextField("Confirmation Page");
        tfConfirmationPage.setPlaceholder("Confirmation Page");

        Button btnCreateCustomer = new Button("Create Customer", event -> {
            String username = tfUsername.getValue();
            Registration registration = new Registration();
            registration.setUsername(username);
            registration.setPassword(tfPassword.getValue());
            registration.setConfirmationCode(tfConfirmationCode.getValue());
            registration.setConfirmationPage(tfConfirmationPage.getValue());
            shoppingService.register(registration);
            Integer userId = shoppingService.selectByUserName(username).getUserId();
            Customer customer = new Customer();
            customer.setId(userId);
            customer.setName(registration.getUsername());
            shoppingService.insertCustomerSelective(customer);
            UI.getCurrent().navigate(EditCustomerPage.class, userId);
        });

        Button btnCreateSeller = new Button("Create Seller", event -> {
            String username = tfUsername.getValue();
            Registration registration = new Registration();
            registration.setUsername(username);
            registration.setPassword(tfPassword.getValue());
            registration.setConfirmationCode(tfConfirmationCode.getValue());
            registration.setConfirmationPage(tfConfirmationPage.getValue());
            shoppingService.register(registration);
            Integer userId = shoppingService.selectByUserName(username).getUserId();
            Seller seller = new Seller();
            seller.setId(userId);
            seller.setName(registration.getUsername());
            shoppingService.insertSellerSelective(seller);
            UI.getCurrent().navigate(SellerPage.class, userId);
        });

        add(tfUsername, tfPassword, tfConfirmationCode, tfConfirmationPage, btnCreateCustomer, btnCreateSeller);
    }
}
