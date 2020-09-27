package com.jkjprojektgruppe.schediastis.views.items;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.jkjprojektgruppe.schediastis.views.main.MainView;

@Route(value = "item", layout = MainView.class)
@PageTitle("Agenda Item")
@CssImport("./styles/views/about/about-view.css")
public class ItemView extends Div {

    public ItemView() {
        setId("item-view");
        add(new Label("Content placeholder"));

    }

}
