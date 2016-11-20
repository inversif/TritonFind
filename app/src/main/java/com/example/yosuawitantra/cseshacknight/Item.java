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
    public String getName()
    {
        return nameOfTheItem;
    }
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
    public ImageView getImage(){return Image;}
    //public static void getImage();

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

    public void setImage(ImageView new_image){ Image = new_image;}

    //Constructor
    public Item() {
        nameOfTheItem = "Default";
        locationFound = "Default";
        locationLost = "Default";
        locationDropOff = "Default ";
        Date = "Default";  //te lost or found date.
        Time = "Default";
        Image = null;
    }
    public Item(String nameOfTheItem,
            String locationFound,
            String locationLost,
            String locationDropOff,
            String Date,
            String Time,
            ImageView Image)
    {
        this.nameOfTheItem = nameOfTheItem;
        this.locationFound =locationFound;
        this.locationLost =locationLost;
        this.locationDropOff=locationDropOff;
        this.Date=Date;
        this.Time=Time;
        this.Image=Image;
    }

}
