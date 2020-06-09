package com.online.shopping.ui;

import com.online.shopping.model.Customer;
import com.online.shopping.service.IShoppingService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "customer/edit", layout = MainLayout.class)
public class EditCustomerPage extends FormLayout implements HasUrlParameter<Integer> {
    private TextField name = new TextField("Name");
    private TextField phoneNumber = new TextField("Phone Number");
    private TextField email = new TextField("Email");
    private ComboBox<String> gender = new ComboBox<>("Gender", "M", "F");
    private DatePicker birthdate = new DatePicker("Birth Date");
    private TextField state = new TextField("State");
    private TextField city = new TextField("City");
    private TextField street = new TextField("Street");
    private TextField zip = new TextField("Zip");

    private Binder<Customer> binder = new Binder<>(Customer.class);
    @Autowired
    private IShoppingService shoppingService;

    public EditCustomerPage() {
        binder.bindInstanceFields(this);
        Button btnSave = new Button("Save", event -> {
            Customer customer = binder.getBean();
            shoppingService.updateCustomerSelective(customer);
            UI.getCurrent().navigate(CustomerPage.class, customer.getId());
        });
        add(name, phoneNumber, email, gender, birthdate, state, city, street, zip, btnSave);
    }

    @Override
    public void setParameter(BeforeEvent event, Integer parameter) {
        binder.setBean(shoppingService.selectByCustomerId(parameter));
    }
}
