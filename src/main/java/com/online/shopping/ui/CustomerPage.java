package com.online.shopping.ui;

import com.online.shopping.model.Customer;
import com.online.shopping.service.IShoppingService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by yanry on 2020/6/4.
 */
@Route(value = "customer", layout = MainLayout.class)
public class CustomerPage extends VerticalLayout implements HasUrlParameter<Integer> {
    private H1 title = new H1();
    private int id;
    @Autowired
    private IShoppingService shoppingService;

    public CustomerPage() {
        Button btnEdit = new Button("Set Information", event -> UI.getCurrent().navigate(EditCustomerPage.class, id));
        Button btnBuy = new Button("Buy Product", event -> UI.getCurrent().navigate(CustomerProductPage.class, id));
        Button btnPayment = new Button("Set Payment", event -> UI.getCurrent().navigate(PaymentPage.class, id));
        add(title, btnEdit, btnBuy, btnPayment);
    }

    @Override
    public void setParameter(BeforeEvent event, Integer parameter) {
        id = parameter;
        Customer customer = shoppingService.selectByCustomerId(parameter);
        title.setText(String.format("Welcome, %s", customer.getName()));
    }
}
