package com.jkjprojektgruppe.schediastis.views.agenda;

import java.awt.*;
import java.time.DayOfWeek;
import java.util.Calendar;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
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
import jdk.javadoc.internal.doclets.formats.html.markup.Table;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.MonthDay;
import javax.swing.*;
import javax.swing.text.html.parser.ContentModel;
import java.util.ArrayList;
import java.util.List;

@Route(value = "Calender")
public class Agenda extends Div{
    private Item[] items;
    enum viewType {monthly, weeklyHorizontal, weeklyVertical, dailyHorizontal, dailyVertical};
    private final Calendar calendar;
    private final String[] months = {"January","February","March","April","May","June","July","August","September","November","December"};
    private final String[] days = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
    private YearMonth monthYear;
    private MonthDay monthDay;
    private VerticalLayout layout = new VerticalLayout();
    private int year;
    private int month;
    private int day;
    private viewType view;

    public Agenda() {
        calendar = Calendar.getInstance();
        monthYear = YearMonth.now();
        monthDay = MonthDay.now();
        year = monthYear.getYear();
        month = monthYear.getMonthValue();
        day = monthDay.getDayOfMonth();
        view = viewType.monthly;
        initializeAgenda(view);
        add(layout);
    }

    private void initializeAgenda(viewType view){
        add(layout);
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
        HorizontalLayout first = new HorizontalLayout();
        for(int x=0;x<7;x++) {
            Label label = new Label(days[x]);
            label.setMinWidth("100px");
            first.add(label);
        }
        layout.add(first);

        HorizontalLayout second = new HorizontalLayout();
        int firstDayOfMonth = (monthYear.atDay(1).getDayOfWeek()).getValue();
        for(int y=0;y<firstDayOfMonth;y++) {
            Label label = new Label("");
            label.setMinWidth("100px");
            second.add(label);
        }

        int counter = 1;
        HorizontalLayout third = new HorizontalLayout();
        HorizontalLayout fourth = new HorizontalLayout();
        HorizontalLayout fifth = new HorizontalLayout();
        HorizontalLayout sixth = new HorizontalLayout();

        int z = 7-firstDayOfMonth;
        while(counter<=monthYear.lengthOfMonth()) {
            if (counter <= z){
                Label label = new Label(""+counter);
                label.setMinWidth("100px");
                if(z==day)
                   label.setTitle("Today");
                second.add(label);
            }else
                if (counter<=(z+7)) {
                    Label label = new Label(""+counter);
                    label.setMinWidth("100px");
                    if(z==day)
                        label.setTitle("Today");
                    third.add(label);
                }else
                    if (counter<=(z+14)) {
                        Label label = new Label(""+counter);
                        label.setMinWidth("100px");
                        if(z==day)
                            label.setTitle("Today");
                        fourth.add(label);
                    }else
                        if (counter<=(z+21)) {
                            Label label = new Label(""+counter);
                            label.setMinWidth("100px");
                            if(z==day)
                                label.setTitle("Today");
                            fifth.add(label);
                        }else
                            if (counter<=(z+28)) {
                                Label label = new Label(""+counter);
                                label.setMinWidth("100px");
                                if(z==day)
                                    label.setTitle("Today");
                                sixth.add(label);
                            }
            counter++;
        }
        layout.add(second);
        layout.add(third);
        layout.add(fourth);
        layout.add(fifth);
        layout.add(sixth);
        add(layout);
    }

    private void displayWeeklyHorizontalView(){
        HorizontalLayout first = new HorizontalLayout();
        for(int x=0;x<7;x++)
            first.add(new Label(days[x]));
        layout.add(first);

        HorizontalLayout second = new HorizontalLayout();
        int dayOfWeekInMonth = calendar.get(calendar.DAY_OF_WEEK_IN_MONTH);
        int dayOfWeek = calendar.get(calendar.DAY_OF_WEEK)-1;

        add(layout);

    }

    private void displayWeeklyVerticalView(){


    }

    private void displayDailyHorizontalView(){

    }

    private void displayDailyVerticalView(){


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
