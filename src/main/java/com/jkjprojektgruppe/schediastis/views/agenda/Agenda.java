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
import java.util.ArrayList;
import java.util.List;


public class Agenda extends Div{
    private Item[] items;
    enum viewType {monthly, weeklyHorizontal, weeklyVertical, dailyHorizontal, dailyVertical};
    private final Calendar calendar;
    private final String[] months = {"January","February","March","April","May","June","July","August","September","November","December"};
    private final String[] days = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
    private GridLayout layout;
    private YearMonth monthOfYear;
    private int year;
    private int month;
    private int day;

    public Agenda(viewType view) {
        calendar = Calendar.getInstance();
        monthOfYear = YearMonth.now();
        month = calendar.get(Calendar.MONTH);
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

        int dayOfWeek = calendar.get(calendar.DAY_OF_WEEK)-1;
        for(int y=0;y<dayOfWeek;y++) {
            layout.addLayoutComponent("", new JLabel(""));
        }
        int dayOfWeekInMonth = calendar.get(calendar.DAY_OF_WEEK_IN_MONTH);
        for (int z = 1; z <= monthOfYear.lengthOfMonth(); z++) {
            JLabel label = new JLabel(""+z);
            label.setOpaque(true);
            if (z == dayOfWeekInMonth)
                label.setBackground(Color.RED);
            layout.addLayoutComponent("", label);
        }
    }

    private void displayWeeklyHorizontalView(){
        layout = new GridLayout(2,7);

        for(int x=0;x<7;x++)
            layout.addLayoutComponent("",new JLabel(days[x]));
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

    /*
    private String getEventForDay(Item[] items){
        //used to see if there is an event for the day, if so, adds the relevant data
    }
    */

    public Item[] getItems(int startDate, int endDate){
        Item[] items = new Item[2]; //temporary
        return items;
    }
}
