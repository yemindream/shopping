package com.online.shopping.ui;

import com.online.shopping.model.PurchaseHistory;
import com.online.shopping.service.IShoppingService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ReadOnlyHasValue;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "customer/purchase", layout = MainLayout.class)
public class PurchaseHistoryPage extends HorizontalLayout implements HasUrlParameter<Integer> {
    private Grid<PurchaseHistory> grid = new Grid<>(PurchaseHistory.class);
    private DatePicker fromDate = new DatePicker("From Date");
    private DatePicker toDate = new DatePicker("To Date");
    @Autowired
    private IShoppingService shoppingService;
    private int customerId;

    public PurchaseHistoryPage() {
        RateForm rateForm = new RateForm();
        grid.setSizeFull();
        grid.setColumns("id", "productId", "quantity", "state", "rating");
        grid.asSingleSelect().addValueChangeListener(event -> {
            PurchaseHistory value = grid.asSingleSelect().getValue();
            rateForm.binder.setBean(value);
        });

        Button btnSearch = new Button("Search", event -> updateList());
        VerticalLayout verticalLayout = new VerticalLayout(fromDate, toDate, btnSearch, grid);
        verticalLayout.setSizeFull();

        setSizeFull();
        add(verticalLayout, rateForm);
    }

    @Override
    public void setParameter(BeforeEvent event, Integer parameter) {
        customerId = parameter;
    }

    private void updateList() {
        grid.setItems(shoppingService.getPurchaseHistoryListByCustomerId(customerId, fromDate.getValue(), toDate.getValue()));
    }

    private class RateForm extends FormLayout {
        private Binder<PurchaseHistory> binder = new Binder<>(PurchaseHistory.class);

        public RateForm() {
            Label purchaseId = new Label();
            binder.forField(new ReadOnlyHasValue<>(id -> purchaseId.setText("Purchase Id: " + id)))
                    .bind(purchaseHistory -> purchaseHistory.getId(), null);
            IntegerField rating = new IntegerField("Rating");
            binder.forField(rating).bind("rating");
            Button btnSave = new Button("Set Rating", event -> {
                PurchaseHistory bean = binder.getBean();
                if (bean != null) {
                    shoppingService.updatePurchase(bean);
                    updateList();
                }
            });
            Button btnCancel = new Button("Cancel", event -> {
                PurchaseHistory bean = binder.getBean();
                if (bean != null) {
                    shoppingService.cancelPurchase(bean.getId());
                    updateList();
                }
            });
            Button btnSendBack = new Button("Send Back", event -> {
                PurchaseHistory bean = binder.getBean();
                if (bean != null) {
                    shoppingService.returnPurchase(bean.getId());
                    updateList();
                }
            });

            add(purchaseId, rating, btnSave, btnCancel, btnSendBack);
        }
    }
}
