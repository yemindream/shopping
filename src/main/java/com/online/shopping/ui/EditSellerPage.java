package com.online.shopping.ui;

import com.online.shopping.model.Seller;
import com.online.shopping.service.IShoppingService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "seller/edit", layout = MainLayout.class)
public class EditSellerPage extends FormLayout implements HasUrlParameter<Integer> {
    private Binder<Seller> binder = new Binder<>(Seller.class);
    @Autowired
    private IShoppingService shoppingService;

    private TextField name = new TextField("Name");
    private TextField sellingAddress = new TextField("Selling Address");
    private TextField email = new TextField("Email");
    private TextField companyName = new TextField("Company Name");

    public EditSellerPage() {
        binder.bindInstanceFields(this);
        Button btnSave = new Button("Save", event -> {
            Seller seller = binder.getBean();
            shoppingService.updateSellerSelective(seller);
            UI.getCurrent().navigate(SellerPage.class, seller.getId());
        });

        add(name, sellingAddress, email, companyName, btnSave);
    }

    @Override
    public void setParameter(BeforeEvent event, Integer parameter) {
        binder.setBean(shoppingService.selectBySellerId(parameter));
    }
}
