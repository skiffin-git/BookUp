package com.BaldFrogs.BookUp.Model;

import java.sql.Date;
import java.util.ArrayList;

public class Listing {
    private int id;
    private String location;
    private String description;
    private ArrayList<Date> availableDays;
    private float price;
    private int maxGuests;
    private ArrayList<Integer> images;
    private String contactInformation;

    public Listing()
    {
        availableDays = new ArrayList<>();
        images = new ArrayList<>();
    }

    public Listing(String location, String description, float price, int maxGuests, String contactInformation)
    {
        this.location = location;
        this.description = description;
        this.price = price;
        this.maxGuests = maxGuests;
        this.contactInformation = contactInformation;

        availableDays = new ArrayList<>();
        images = new ArrayList<>();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Date> getAvailableDays() {
        return availableDays;
    }

    public void setAvailableDays(ArrayList<Date> availableDays) {
        this.availableDays = availableDays;
    }

    public void addAvailableDay(Date d)
    {
        availableDays.add(d);
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getMaxGuests() {
        return maxGuests;
    }

    public void setMaxGuests(int maxGuests) {
        this.maxGuests = maxGuests;
    }

    public int getImage(int i) {
        if(images.size() == 0)
            return 0;

        return images.get(i);
    }

    public ArrayList<Integer> getImages() {
        return images;
    }

    public void setImages(ArrayList<Integer> images) {
        this.images = images;
    }

    public void addImage(Integer i)
    {
        images.add(i);
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
}
