package com.jkjprojektgruppe.schediastis.views.agenda;

import java.awt.*;
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
import java.time.YearMonth;
import javax.swing.*;


public class Agenda {
    private Item[] items;
    enum viewType {monthly, weeklyHorizontal, weeklyVertical, dailyHorizontal, dailyVertical};
    private final Calendar calendar;
    private final String[] months = {"January","February","March","April","May","June","July","August","September","November","December"};
    private final String[] days = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
    private GridLayout layout;
    private YearMonth monthOfYear;

    public Agenda(viewType view) {
        calendar = Calendar.getInstance();
        monthOfYear = YearMonth.now();
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
        layout = new GridLayout(6,7);
        for(int x=0;x<7;x++)
            layout.addLayoutComponent("",new JLabel(days[x]));
        int day = calendar.DAY_OF_WEEK-1;

        for(int y=0;y<day;y++)
            layout.addLayoutComponent("",new JLabel(""));

        for (int z = 0; z< monthOfYear.lengthOfMonth(); z++)
            layout.addLayoutComponent("",new JLabel(""+z));
        
    }

    private void displayWeeklyHorizontalView(){
        layout = new GridLayout(1,7);

    }

    private void displayWeeklyVerticalView(){
        layout = new GridLayout(7,1);

    }

    private void displayDailyHorizontalView(){
        layout = new GridLayout(1,1);
    }

    private void displayDailyVerticalView(){
        layout = new GridLayout(1,1);
    }

    public Item[] getItems(int startDate, int endDate){
        Item[] items = new Item[2]; //temporary, so itll stop giving me errors
        return items;
    }
}
