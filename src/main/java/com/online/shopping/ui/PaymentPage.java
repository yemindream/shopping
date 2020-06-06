package com.online.shopping.ui;

import com.online.shopping.model.Payment;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;

/**
 * Created by yanry on 2020/6/5.
 */
public class PaymentPage extends HorizontalLayout implements HasUrlParameter<Integer> {
    private Grid<Payment> grid = new Grid<>(Payment.class);

    public PaymentPage() {
    }

    @Override
    public void setParameter(BeforeEvent event, Integer parameter) {

    }
}
