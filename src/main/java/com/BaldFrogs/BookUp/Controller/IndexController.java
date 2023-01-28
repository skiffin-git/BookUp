package com.BaldFrogs.BookUp.Controller;

import com.BaldFrogs.BookUp.Database.Database;
import com.BaldFrogs.BookUp.Model.Listing;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class IndexController
{
    //Show new created listings on home page
    @GetMapping("/")
    public String index(Model model)
    {
        ArrayList<Listing> listings = Database.NewListings();
        if(listings != null && listings.size() > 0)
            model.addAttribute("listings", Arrays.asList(listings.toArray()));

        model.addAttribute("location", "");
        model.addAttribute("checkIn", LocalDate.now());
        model.addAttribute("checkOut", LocalDate.now());
        model.addAttribute("guests", 1);

        return "index";
    }

    //Search for a listings
    @GetMapping("/search")
    public String search(
                          Model model, @RequestParam("location") String location,
                                       @RequestParam("check-in") Date checkIn,
                                       @RequestParam("check-out") Date checkOut,
                                       @RequestParam("guests") int guests
                         )
    {
        ArrayList<Listing> listings = Database.Search(location, checkIn, checkOut, guests);
        if(listings != null && listings.size() > 0)
            model.addAttribute("listings", Arrays.asList(listings.toArray()));

        model.addAttribute("location", location);
        model.addAttribute("checkIn", checkIn);
        model.addAttribute("checkOut", checkOut);
        model.addAttribute("guests", guests);

        return "index";
    }
}
