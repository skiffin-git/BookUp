package com.BaldFrogs.BookUp.Controller;

import com.BaldFrogs.BookUp.Database.Database;
import com.BaldFrogs.BookUp.Utils.FileUploadUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Controller
public class ImageController
{
    /*
        Upload new image
    */
    @PostMapping("/listing/{id}/edit/uploadImage")
    public String editListingUploadImage(Model model, @PathVariable Integer id, @RequestParam("img") MultipartFile multipartFile)
    {
        String uploadDir = "src/main/resources/images/";
        String type = multipartFile.getContentType();

        //Max file size is 5mb
        if(multipartFile.getSize() < 5242880 && type.equals("image/png") || type.equals("image/jpeg"))
        {
            try
            {
                int i = Database.InsertImage(id);
                FileUploadUtil.saveFile(uploadDir, Integer.toString(i) + ".jpg", multipartFile);
                return "redirect:/listing/" + id + "/edit";
            }
            catch (IOException e)
            {
                System.out.println(e.getMessage());
            }
        }
        return "redirect:/listing/" + id + "/edit";
    }

    /*
        Remove image
    */
    @GetMapping("/listing/{id}/edit/removeImage/{img_id}")
    public String editListingRemoveImage(Model model, @PathVariable Integer id, @PathVariable Integer img_id)
    {
        Database.DeleteImage(img_id);
        return "redirect:/listing/" + id + "/edit";
    }

    @RequestMapping(value = "/images/{imageName}")
    @ResponseBody
    public byte[] getImage(@PathVariable String imageName)
    {
        try
        {
            File serverFile = new File("src/main/resources/images/" + imageName);
            return Files.readAllBytes(serverFile.toPath());
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
