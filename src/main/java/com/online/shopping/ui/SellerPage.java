package com.online.shopping.ui;

import com.online.shopping.model.Seller;
import com.online.shopping.service.IShoppingService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "seller", layout = MainLayout.class)
public class SellerPage extends VerticalLayout implements HasUrlParameter<Integer> {
    private H1 title = new H1();
    private int id;
    @Autowired
    private IShoppingService shoppingService;

    public SellerPage() {
        Button btnEdit = new Button("Set Information", event -> UI.getCurrent().navigate(EditSellerPage.class, id));
        Button btnProductList = new Button("Set Products", event -> UI.getCurrent().navigate(SellerProductPage.class, id));

        add(title, btnEdit, btnProductList);
    }

    @Override
    public void setParameter(BeforeEvent event, Integer parameter) {
        id = parameter;
        Seller seller = shoppingService.selectBySellerId(parameter);
        title.setText(String.format("Welcome, %s", seller.getName()));
    }
}
