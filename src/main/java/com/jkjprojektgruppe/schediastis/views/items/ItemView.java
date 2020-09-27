package com.jkjprojektgruppe.schediastis.views.items;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.jkjprojektgruppe.schediastis.views.main.MainView;

@Route(value = "item", layout = MainView.class)
@PageTitle("Agenda Item")
public class ItemView extends Div {
    private Item item;
    private VerticalLayout viewLayout;

    public ItemView() {
        setId("item-view");
        this.item = ItemManager.getInstance().getCurrentItem();
        instantiateView();
    }

    public void instantiateView(){
        viewLayout = new VerticalLayout();
        instantiateHeaders();
        instantiateContextDisplay();
        add(viewLayout);
    }

    public void instantiateHeaders(){
        HorizontalLayout sec1 = new HorizontalLayout();
        H2 header1 = new H2("Agenda Item: \t");
        H2 itemNameLabel1 = new H2(item.getName());
        /** Add decoration here **/
        itemNameLabel1.setHeightFull();
        sec1.add(header1);
        sec1.add(itemNameLabel1);
        viewLayout.add(sec1);
    }
    public void instantiateContextDisplay(){
        HorizontalLayout sec1 = new HorizontalLayout();
        H4 spacing1 = new H4("\t");
        VerticalLayout sec2 = new VerticalLayout();
            HorizontalLayout startSec = new HorizontalLayout();
            H6 fieldName1 = new H6("Start Time:");
            H6 fieldValue1 = new H6(item.getStartISO());
            sec2.add(startSec);

        sec1.add(spacing1);
        sec1.add(sec2);



        viewLayout.add(new Hr());
        viewLayout.add(new H4("Time and Place"));
        viewLayout.add(sec1);
    }

}
