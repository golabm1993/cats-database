package pl.kobietydokodu.cats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.kobietydokodu.catsdatabase.dto.CatDTO;
import pl.kobietydokodu.catsdatabase.model.Cat;
import pl.kobietydokodu.service.CatsService;

import javax.validation.Valid;

@Controller
public class CatsController {

    @Autowired
    private CatsService catsService;

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
        return "catDetails";
    }
}
