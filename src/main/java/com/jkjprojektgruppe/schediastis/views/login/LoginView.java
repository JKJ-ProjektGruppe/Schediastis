package com.jkjprojektgruppe.schediastis.views.login;

import com.jkjprojektgruppe.schediastis.views.items.ItemManager;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.jkjprojektgruppe.schediastis.views.main.MainView;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.component.textfield.TextField;



@Route(value = "login")
@PageTitle("Login")
@CssImport("./styles/views/about/about-view.css")
@RouteAlias(value = "")
public class LoginView extends Div {
    private String username;
    private String password;
    private TextField usernameTextField;
    private TextField passwordTextField;
    private VerticalLayout mainpanel = new VerticalLayout();
    private final Button loginButton = new Button("Login");


    public LoginView() {

        setId("login-view");
        Label titleLabel = new Label("Schediastis");
        add(titleLabel);
        LoginPanel();
    }



    public void LoginPanel()
    {   mainpanel.add(new Label("Please Login!"));
        defaultPanel();
        add(mainpanel);
        HorizontalLayout buttonLayout = new HorizontalLayout();
        Button createAccountButton = new Button("Create New Account");
        buttonLayout.add(loginButton);
        buttonLayout.add(createAccountButton);
        mainpanel.add(buttonLayout);

        Label userError = new Label("Incorrect password/ username");
        userError.setVisible(false);
        mainpanel.add(userError);
        Label emptyBoxError = new Label("Please fill out both the username and password");
        emptyBoxError.setVisible(false);
        mainpanel.add(emptyBoxError);

        loginButton.addClickListener(event -> {
            if(!(usernameTextField.isEmpty()|| passwordTextField.isEmpty()))
            {
                emptyBoxError.setVisible(false);
                username = usernameTextField.getValue();
                password = passwordTextField.getValue();
                if(accountVerified(username, password))
                {
                    userError.setVisible(false);
                    UI.getCurrent().navigate(MainView.class); //Goes to MainView
                    ItemManager.getInstance().setCredentials("");
                }
                else
                {
                    userError.setVisible(true);

                }
            }
            else
            {
                emptyBoxError.setVisible(true);
            }
        });
        createAccountButton.addClickListener(event -> {
            mainpanel.removeAll();
            buttonLayout.removeAll();
            CreateLoginPanel();
        });

    }

    public void CreateLoginPanel()
    {
        mainpanel.add(new Label(": Create an Account"));
        defaultPanel();
        add(mainpanel);
        HorizontalLayout buttonLayout = new HorizontalLayout();
        Button createAccountButton = new Button("Create New Account");
        Button backButton = new Button("Back");
        buttonLayout.add(backButton);
        buttonLayout.add(createAccountButton);
        mainpanel.add(buttonLayout);

        Label emptyBoxError = new Label("Please fill out both the username and password");
        emptyBoxError.setVisible(false);
        mainpanel.add(emptyBoxError);
        Label addAccount = new Label("Account added Successfully");
        addAccount.setVisible(false);
        mainpanel.add(addAccount);
        createAccountButton.addClickListener(event ->
        {
            if(!(usernameTextField.isEmpty()|| passwordTextField.isEmpty())) {
                emptyBoxError.setVisible(false);
                addAccount.setVisible(true);
                username = usernameTextField.getValue();
                password = passwordTextField.getValue();
                addToDatabase();
            }
            else
            {
                addAccount.setVisible(false);
                emptyBoxError.setVisible(true);
            }
        });
        backButton.addClickListener(event->
        {
            mainpanel.removeAll();
            buttonLayout.removeAll();
            LoginPanel();
        });

    }

    public void defaultPanel()
    {
        HorizontalLayout usernameLayout = new HorizontalLayout();
        Label usernameLabel = new Label("Username: ");
        usernameTextField = new TextField("Enter Username");
        usernameLayout.add(usernameLabel);
        usernameLayout.add(usernameTextField);
        mainpanel.add(usernameLayout);

        HorizontalLayout passwordLayout = new HorizontalLayout();
        Label passwordLabel = new Label("Password: ");
        passwordTextField = new TextField("Enter Password");
        passwordLayout.add(passwordLabel);
        passwordLayout.add(passwordTextField);
        mainpanel.add(passwordLayout);
        mainpanel.setAlignItems(FlexComponent.Alignment.CENTER);
    }

    public boolean accountVerified(String user, String pass)
    {
        return true;
    }

    public void addToDatabase()
    {

    }

}