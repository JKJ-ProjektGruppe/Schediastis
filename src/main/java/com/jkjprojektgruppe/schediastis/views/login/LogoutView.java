package com.jkjprojektgruppe.schediastis.views.login;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@Route(value = "logout")
@PageTitle("Logout")
public class LogoutView extends Div{

    private HorizontalLayout hLayout = new HorizontalLayout();
    private VerticalLayout vLayout = new VerticalLayout();

    public LogoutView()
    {
        setId("logout-view");
        add(hLayout);
        hLayout.add(vLayout);
        vLayout.add(new Label("You have successfully logged out"));
        vLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        hLayout.setAlignItems(FlexComponent.Alignment.CENTER);

        Button loginPageButton = new Button("Go to Login Page");
        loginPageButton.addClickListener(event ->
        {
            UI.getCurrent().navigate(LoginView.class);
        });
        vLayout.add(loginPageButton);



    }
}
