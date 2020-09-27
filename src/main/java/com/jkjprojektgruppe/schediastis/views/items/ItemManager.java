package com.jkjprojektgruppe.schediastis.views.items;

import org.apache.http.client.methods.RequestBuilder;

import java.util.ArrayList;
import java.util.List;

/*
 * https://developers.google.com/identity/protocols/oauth2
 *
 */
public class ItemManager {
    /*
     * Dev Notes: RequestBuilder.get(String URI)
     *  append ".addHeader(String fieldName, String argument)"
     */

    private static ItemManager INSTANCE = null;
    private String credentials;
    private Item currentItem;

    private ItemManager(){
        credentials = "";
        currentItem = null;
    }

    public static ItemManager getInstance(){
        if(INSTANCE == null){
            INSTANCE = new ItemManager();
        }
        return INSTANCE;
    }

    public Item getCurrentItem() { return currentItem; }
    public void setCurrrentItem( Item item ) {this.currentItem = item;}
    public String getCredentials() { return credentials; }
    public void setCredentials(String credentials){ this.credentials = credentials; }
    public List<? extends List<Item>> getAgendaItems( long startDate, long endDate ){
        List<? extends List<Item>> itemGrid = null;
        /*
         * Query Database using RequestBuilder to send an HTTP GET request.
         */
        if(true /* Elegantly catch exceptions or cases of failed queries*/ ){
            itemGrid = new ArrayList<ArrayList<Item>>();
        }
        return itemGrid;
    }
    /**Database queries to add, remove, update Tables and Entries**/
}
   /*
    * References:
    * https://developers.google.com/identity/protocols/oauth2
    * http://hc.apache.org/httpcomponents-client-4.3.x/httpclient/apidocs/org/apache/http/client/methods/RequestBuilder.html
    */