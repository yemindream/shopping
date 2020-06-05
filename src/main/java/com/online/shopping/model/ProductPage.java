package com.online.shopping.model;

import com.online.shopping.service.IShoppingService;
import com.online.shopping.ui.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by yanry on 2020/6/5.
 */
@Route(value = "product", layout = MainLayout.class)
public class ProductPage extends HorizontalLayout implements HasUrlParameter<Integer> {
    private Grid<Product> grid = new Grid<>(Product.class);
    @Autowired
    private IShoppingService shoppingService;

    public ProductPage() {
        ProductForm productForm = new ProductForm();
        productForm.setProduct(null);
        grid.setColumns("type", "price", "quantity", "description");
        grid.asSingleSelect().addValueChangeListener(event -> {
            productForm.setProduct(grid.asSingleSelect().getValue());
        });
        Button btnAdd = new Button("Add", event -> {
            grid.asSingleSelect().clear();
            productForm.setProduct(new Product());
        });

        add(new VerticalLayout(btnAdd, grid), productForm);
    }

    private void updateList() {
        // todo
    }

    @Override
    public void setParameter(BeforeEvent event, Integer parameter) {
        updateList();
    }

    private class ProductForm extends FormLayout {
        private TextField type = new TextField("Type");
        private TextField price = new TextField("price");
        private TextField quantity = new TextField("Quantity");
        private TextField description = new TextField("Description");

        private Binder<Product> binder = new Binder<>(Product.class);

        public ProductForm() {
            Button btnSave = new Button("Save", event -> {
                shoppingService.updateProductSelective(binder.getBean());
                updateList();
                setProduct(null);
            });

            add(type, price, quantity, description, btnSave);
            binder.bindInstanceFields(this);
        }

        private void setProduct(Product product) {
            binder.setBean(product);
            if (product == null) {
                setVisible(false);
            } else {
                setVisible(true);
                type.focus();
            }
        }
    }
}
