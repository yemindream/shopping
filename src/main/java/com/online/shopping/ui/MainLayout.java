package com.online.shopping.ui;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLayout;

public class MainLayout extends VerticalLayout implements RouterLayout {
    public MainLayout() {
        setSizeFull();
        add(new Button("back", event -> UI.getCurrent().navigate("")));
    }
}
