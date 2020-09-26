package com.jkjprojektgruppe.schediastis.views.agenda;

import java.util.Calendar;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.jkjprojektgruppe.schediastis.views.main.MainView;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.component.textfield.TextField;
import com.jkjprojektgruppe.schediastis.views.items.Item;


public class Agenda {
    private Item[] items;
    enum viewType {monthly, weeklyHorizontal, weeklyVertical, dailyHorizontal, dailyVertical};
    private static Calendar calendar;

    public Agenda(viewType view) {
        calendar = Calendar.getInstance();
        initializeAgenda(view);
    }

    private void initializeAgenda(viewType view){
        switch (view){
            case monthly:
                displayMonthlyView();
                break;
            case weeklyHorizontal:
                displayWeeklyHorizontalView();
                break;
            case weeklyVertical:
                displayWeeklyVerticalView();
                break;
            case dailyHorizontal:
                displayDailyHorizontalView();
                break;
            case dailyVertical:
                displayDailyVerticalView();
                break;
        }
    }

    private void displayMonthlyView(){

    }

    private void displayWeeklyHorizontalView(){

    }

    private void displayWeeklyVerticalView(){

    }

    private void displayDailyHorizontalView(){

    }

    private void displayDailyVerticalView(){

    }

    public Item[] getItems(int startDate, int endDate){
        Item[] items = new Item[2]; //temporary, so itll stop giving me errors
        return items;
    }
}
