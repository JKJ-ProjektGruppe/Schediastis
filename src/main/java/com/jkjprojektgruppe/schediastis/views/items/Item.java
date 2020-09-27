package com.jkjprojektgruppe.schediastis.views.items;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Item {
    private String name;
    private long start; //might change to string
    private long end; //might change to string?
    private String details;
    private String location;
    private String people;

    public Item(){
        this(null, 0, 0, null, null, null);
    }
    public Item(String name, long start, long end,
                String details, String location, String people){
        this.name=(name == null) ? "" : name;
        this.start=start;
        this.end=end;
        this.details=(details == null) ? "" : details;
        this.location=(location == null) ? "" : location;
        this.people=(people == null) ? "" : people;
    }

    public void setName(String name){
        this.name=(name == null) ? "" : name;
    }
    public void setStart(long start) {this.start=start;}
    public void setEnd(long end){this.end=end;}
    public void setDetails(String details){
        this.details=(details == null) ? "" : details;
    }
    public void setLocation(String location){
        this.location=(location == null) ? "" : location;
    }
    public void setPeople(String people){
        this.people=(people == null) ? "" : people;
    }

    public String getName(){return name;}
    public long getStart(){return start;}
    public long getEnd(){return end;}
    public String getDetails(){return details;}
    public String getLocation(){return location;}
    public String getPeople(){return people;}

    public String getStartISO(){

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd  |  HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(this.start);
        df.setTimeZone(cal.getTimeZone());
        String strISO = df.format(cal.getTime());
        return strISO;
    }
    public String getEndISO(){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd  |  HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        /**Uncomment when ready**/ //cal.setTimeInMillis(this.end);
        df.setTimeZone(cal.getTimeZone());
        String strISO = df.format(cal.getTime());
        return strISO;
    }
}
