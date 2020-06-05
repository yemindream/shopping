package com.online.shopping.model;

import com.online.shopping.service.IShoppingService;
import com.online.shopping.ui.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by yanry on 2020/6/5.
 */
@Route(value = "product", layout = MainLayout.class)
public class ProductPage extends VerticalLayout {
    private Grid<Product> grid = new Grid<>(Product.class);
    @Autowired
    private IShoppingService shoppingService;

    public ProductPage() {
        grid.setColumns("type", "price", "quantity", "description");

        add(grid);
    }

    private void updateList() {
//        grid.setItems(shoppingService.);
    }
}
