package com.example.yosuawitantra.cseshacknight;

import android.widget.ImageView;

import java.sql.Time;

/**
 * Created by kingcobra93 on 11/20/16.
 */

public class Item
{
    //Member variables.
    private String nameOfTheItem;
    private String locationFound;
    private String locationLost;
    private String locationDropOff;
    private String Date;  //te lost or found date.
    private String Time;
    private ImageView Image;

    //Member Methods

    //Accessor methods
    public String getName() {return nameOfTheItem;}
    public String getLocationFound()
    {
        return locationLost;
    }
    public String getLocationLost()
    {
        return locationLost;
    }
    public String getLocationDropOff()
    {
        return locationDropOff;
    }
    public String getdate()
    {
        return Date;
    }
    public String gettime()
    {
        return Time;
    }
    public ImageView getImage(){ return Image; }

    //Mutator Function
    public void setNameOfTheItem(String item_name)
    {
        nameOfTheItem = item_name;
    }

    public void setLocationFound(String location_Lost)
    {
        locationLost = location_Lost;
    }

    public void setLocationDropOff(String location_DropOff)
    {
        locationDropOff = location_DropOff;
    }

    public void setLocationLost(String location_lost)
    {
        locationLost = location_lost;
    }

    public void setDate(String new_date)
    {
        Date = new_date;
    }

    public void setTime(String new_time)
    {
        Time = new_time;
    }

    public void setImage(ImageView img) { Image = img; }

    //Constructor
    public Item(String description, String location, String s, String dateandTime, String s1, ImageView imageView) {
        nameOfTheItem = "Default";
        locationFound = "Default";
        locationLost = "Default";
        locationDropOff = "Default ";
        Date = "Default";  //te lost or found date.
        Time = "Default";
        Image = new ImageView(null);
    }

    //Constructor
    public Item(String nm, String locF, String locL, String locDF, String da, String ti, ImageView img) {
        nameOfTheItem = nm;
        locationFound = locF;
        locationLost = locL;
        locationDropOff = locDF;
        Date = da;  //te lost or found date.
        Time = ti;
        Image = img;
    }
}
