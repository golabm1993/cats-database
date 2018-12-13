package pl.kobietydokodu.cats;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.kobietydokodu.catsdatabase.dto.CatDTO;
import pl.kobietydokodu.catsdatabase.model.Cat;
import pl.kobietydokodu.service.CatsService;
import pl.kobietydokodu.service.PhotosService;
import pl.kobietydokodu.service.ToysService;

import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller("/cats")
public class CatsController {

    @Autowired
    private CatsService catsService;

    @Autowired
    private ToysService toysService;

    @Autowired
    private PhotosService photosService;

    public String id_nowe;

    @GetMapping("/")
    public String listOfCats(Model model) {
        model.addAttribute("cats", catsService.getAllCats());
        return "welcome";
    }

    @GetMapping("/newCat")
    public String newCatForm(Model model) {
        model.addAttribute("cat", new Cat());
        return "newCat";
    }

    @PostMapping
    public String addNewCat(@ModelAttribute("cat") @Valid CatDTO catDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "newCat";
        } else {
            catsService.createNewCat(catDTO);
            return "redirect:/";
        }
    }

    @GetMapping("/catDetails/{id}")
    public String displayCatDetails(@PathVariable String id, Model model) {
        model.addAttribute("cat", catsService.getCat(id));
        model.addAttribute("toys", toysService.getAllToys());
        model.addAttribute("photos", photosService.getAllPhotos());
//        id_nowe = id;
        return "catDetails";
    }

    @GetMapping(value="/catDetails/{id}/image", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody
    byte[] getImage(@PathVariable String id) throws IOException {
        String photoName = photosService.getPhoto(Long.valueOf(id)).getDatabasePhotoName();
        return Files.readAllBytes(Paths.get("C:\\Users\\G\\Documents\\CatsDatabase\\cats-webapp\\src\\main\\resources\\" + photoName + ".jpg"));

//        return IOUtils.toByteArray(inputStream);
    }
}
