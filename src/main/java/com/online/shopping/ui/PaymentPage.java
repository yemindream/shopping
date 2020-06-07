package com.online.shopping.ui;

import com.online.shopping.model.Payment;
import com.online.shopping.service.IShoppingService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by yanry on 2020/6/5.
 */
@Route(value = "customer/payment", layout = MainLayout.class)
public class PaymentPage extends HorizontalLayout implements HasUrlParameter<Integer> {
    private Grid<Payment> grid = new Grid<>(Payment.class);
    @Autowired
    private IShoppingService shoppingService;
    private int customerId;

    public PaymentPage() {
        PaymentForm paymentForm = new PaymentForm();
        paymentForm.setSelected(null);
        grid.asSingleSelect().addValueChangeListener(event -> paymentForm.setSelected(grid.asSingleSelect().getValue()));
        grid.setSizeFull();
        setSizeFull();
        add(grid, paymentForm);
    }

    private void updateList() {
        grid.setItems(shoppingService.getPaymentListByCustomerId(customerId));
    }

    @Override
    public void setParameter(BeforeEvent event, Integer parameter) {
        customerId = parameter;
        updateList();
    }

    private class PaymentForm extends FormLayout {
        private Binder<Payment> binder = new Binder<>(Payment.class);
        private TextField cardType = new TextField("Card Type");
        private TextField cardHolder = new TextField("Card Holder");
        private TextField billingAddress = new TextField("Billing Address");
        private DatePicker expirationDate = new DatePicker("Expiration Date");

        public PaymentForm() {
            binder.bindInstanceFields(this);
            Button btnSave = new Button("Save", event -> {
                shoppingService.updatePaymentSelective(binder.getBean());
                updateList();
                setSelected(null);
            });

            add(cardType, cardHolder, billingAddress, expirationDate, btnSave);
        }

        private void setSelected(Payment payment) {
            binder.setBean(payment);
            if (payment == null) {
                setVisible(false);
            } else {
                setVisible(true);
                cardType.focus();
            }
        }
    }
}
