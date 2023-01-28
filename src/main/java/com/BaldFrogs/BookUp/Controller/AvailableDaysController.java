package com.BaldFrogs.BookUp.Controller;

import com.BaldFrogs.BookUp.Database.Database;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
public class AvailableDaysController
{
    /*
        Add new day into listing
    */
    @GetMapping("/listing/{id}/edit/newDay")
    public String editListingNewDay(Model model, @PathVariable Integer id, @RequestParam("date") Date date)
    {
        Database.InsertAvailableDay(id, date);
        return "redirect:/listing/" + id + "/edit";
    }

    /*
        Remove day from listing
    */
    @GetMapping("/listing/{id}/edit/removeDay/{date}")
    public String editListingRemoveDay(Model model, @PathVariable Integer id, @PathVariable Date date)
    {
        Database.DeleteAvailableDay(id, date);
        return "redirect:/listing/" + id + "/edit";
    }
}
