package pl.kobietydokodu.cats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.kobietydokodu.catsdatabase.dto.CatDTO;
import pl.kobietydokodu.catsdatabase.model.Cat;
import pl.kobietydokodu.service.CatsService;
import pl.kobietydokodu.service.ToysService;

import javax.validation.Valid;

@Controller("/cats")
public class CatsController {

    @Autowired
    private CatsService catsService;

    @Autowired
    private ToysService toysService;

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
        id_nowe = id;
        return "catDetails";
    }
}
