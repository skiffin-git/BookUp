package com.BaldFrogs.BookUp.Controller;

import com.BaldFrogs.BookUp.Database.Database;
import com.BaldFrogs.BookUp.Model.Listing;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;

@Controller
public class ListingController
{
    /*
        GetRequest for rendering listing
     */
    @GetMapping("/listing/{id}")
    public String viewListing(Model model, @PathVariable Integer id)
    {
        Listing l = Database.QueryListing(id);
        model.addAttribute("location", l.getLocation());
        model.addAttribute("description", l.getDescription());

        if (l.getAvailableDays().size() > 0)
            model.addAttribute("availableDays", Arrays.asList(l.getAvailableDays().toArray()));

        if(l.getImages() != null && l.getImages().size() > 0)
            model.addAttribute("images", Arrays.asList(l.getImages().toArray()));

        model.addAttribute("price", l.getPrice());
        model.addAttribute("maxGuests", l.getMaxGuests());
        model.addAttribute("contactInformation", l.getContactInformation());

        return "listing";
    }

    /*
        New listing form page
     */
    @GetMapping("/listing")
    public String viewListing(Model model)
    {
        Listing l = new Listing();
        model.addAttribute("listing", l);
        return "forms/newListing";
    }

    /*
        Add new listing into database and redirect to the listing page
    */
    @PostMapping("/listing/new")
    public String newSubmit(@ModelAttribute Listing listing, Model model)
    {
        int id = Database.InsertListing(listing);
        return "redirect:/listing/" + id;
    }

    /*
        Edit Listing
    */
    @GetMapping("/listing/{id}/edit")
    public String editListing(Model model, @PathVariable Integer id)
    {
        Listing l = Database.QueryListing(id);
        l.setId(id);
        model.addAttribute("listing", l);
        model.addAttribute("availableDays", Arrays.asList(l.getAvailableDays().toArray()));
        model.addAttribute("images", Arrays.asList(l.getImages().toArray()));
        return "forms/editListing";
    }

    /*
        Delete Listing
    */
    @GetMapping("/listing/{id}/edit/delete")
    public String deleteListing(Model model, @PathVariable Integer id)
    {
        Database.DeleteListing(id);
        return "redirect:/";
    }

    /*
        Save listing changes and redirect to the listing page
    */
    @PostMapping("/listing/save")
    public String saveSubmit(@ModelAttribute Listing listing, Model model)
    {
        Database.UpdateListing(listing, listing.getId());
        return "redirect:/listing/" + listing.getId();
    }
}
