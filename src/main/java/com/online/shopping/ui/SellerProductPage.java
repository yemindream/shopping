package com.online.shopping.ui;

import com.online.shopping.model.Product;
import com.online.shopping.service.IShoppingService;
import com.online.shopping.vo.ProductView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by yanry on 2020/6/5.
 */
@Route(value = "seller/product", layout = MainLayout.class)
public class SellerProductPage extends VerticalLayout implements HasUrlParameter<Integer> {
    @Autowired
    private IShoppingService shoppingService;
    private Grid<ProductView> grid = new Grid<>(ProductView.class, false);
    private int sellerId;

    public SellerProductPage() {
        ProductForm productForm = new ProductForm();
        productForm.setProduct(null);
        grid.setColumns("id", "type", "price", "quantity", "description", "avgRatingValue");
        grid.asSingleSelect().addValueChangeListener(event -> productForm.setProduct(grid.asSingleSelect().getValue()));
        Button btnAdd = new Button("Add", event -> {
            grid.asSingleSelect().clear();
            productForm.setProduct(new Product());
        });

        HorizontalLayout mainContent = new HorizontalLayout(grid, productForm);
        mainContent.setSizeFull();
        grid.setSizeFull();
        setSizeFull();
        add(btnAdd, mainContent);
    }

    private void updateList() {
        grid.setItems(shoppingService.getProductInfoBySellerId(sellerId));
    }

    @Override
    public void setParameter(BeforeEvent event, Integer parameter) {
        sellerId = parameter;
        updateList();
    }

    private class ProductForm extends FormLayout {
        private TextField type = new TextField("Type");
        private NumberField nfPrice = new NumberField("Price");
        private IntegerField quantity = new IntegerField("Quantity");
        private TextField description = new TextField("Description");

        private Binder<Product> binder = new Binder<>(Product.class);

        public ProductForm() {
            quantity.setMin(0);
            Button btnSave = new Button("Save", event -> {
                Product product = binder.getBean();
                if (product.getId() == null) {
                    product.setSeller(sellerId);
                    shoppingService.insertProductSelective(product);
                } else {
                    shoppingService.updateProductSelective(product);
                }
                updateList();
                setProduct(null);
            });

            add(type, nfPrice, quantity, description, btnSave);
            binder.bindInstanceFields(this);
            binder.forField(nfPrice).bind(product -> {
                Long price = product.getPrice();
                if (price == null) {
                    return 0d;
                }
                return price.doubleValue();
            }, (product, fieldvalue) -> product.setPrice(fieldvalue.longValue()));
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
