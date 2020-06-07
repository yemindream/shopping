package com.online.shopping.ui;

import com.online.shopping.model.PurchaseHistory;
import com.online.shopping.service.IShoppingService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by yanry on 2020/6/7.
 */
@Route(value = "customer/purchase", layout = MainLayout.class)
public class PurchaseHistoryPage extends HorizontalLayout implements HasUrlParameter<Integer> {
    private Grid<PurchaseHistory> grid = new Grid<>(PurchaseHistory.class);
    private DatePicker fromDate = new DatePicker("From Date");
    private DatePicker toDate = new DatePicker("To Date");
    @Autowired
    private IShoppingService shoppingService;
    private int customerId;

    public PurchaseHistoryPage() {

    }

    @Override
    public void setParameter(BeforeEvent event, Integer parameter) {
        customerId = parameter;

    }

    private void updateList() {
        grid.setItems(shoppingService.getPurchaseHistoryListByCustomerId(customerId, fromDate.getValue(), toDate.getValue()));
    }

    private class RateForm extends FormLayout {
        private Binder<PurchaseHistory> binder = new Binder<>();

        public RateForm() {
            IntegerField rating = new IntegerField("Rating");
            Button btnSave = new Button("Save", event -> {

            });
        }
    }
}
