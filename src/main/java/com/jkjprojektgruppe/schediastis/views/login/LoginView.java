package com.jkjprojektgruppe.schediastis.views.login;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.jkjprojektgruppe.schediastis.views.main.MainView;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.router.RouterLink;

@Route(value = "login", layout = MainView.class)
@PageTitle("Login")
@CssImport("./styles/views/about/about-view.css")
@RouteAlias(value = "")
public class LoginView extends Div {

    public LoginView() {
        setId("login-view");
        add(new Label("Content placeholder"));
        Button loginButton = new Button("Login");
        loginButton.addClickListener(this::redirectToMain);
        add(loginButton);
    }

    private void redirectToMain(ClickEvent<Button> buttonClickEvent) {
        //Get Credentials from class-scope textboxes
        //Check credentials against database
        RouterLink link = new RouterLink("Main", MainView.class);
    }

}