package pl.kobietydokodu.koty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.kobietydokodu.bazakotow.dao.KotDAO;
import pl.kobietydokodu.bazakotow.model.Kot;
import pl.kobietydokodu.bazakotow.dto.KotDTO;
import pl.kobietydokodu.service.KotyService;

import javax.validation.Valid;

@Controller
public class KotyController {

    @Autowired
    private KotDAO kotDAO;

    @Autowired
    private KotyService kotyService;

//    @GetMapping("/")
//    public String listOfCats(Model model) {
//        model.addAttribute("koty", kotDAO.getListaKotow());
//        return "welcome";
//    }

    @GetMapping("/")
    public String listOfCats(Model model) {
//        model.addAttribute("koty", kotDAO.getWszystkieKoty());
        model.addAttribute("koty", kotyService.getWszystkieKoty());
        return "welcome";
    }

    @GetMapping("/newCat")
    public String newCatForm(Model model) {
        model.addAttribute("kot", new Kot());
        return "newCat";
    }

//    @PostMapping("/newCat")
//    public String addNewCat(@ModelAttribute Kot kot) {
//        kotDAO.dodajKota(kot);
//        return "redirect:/";
//    }

//    @GetMapping("/newCat")
//    public String newCatForm() {
//        return "newCat";
//    }

    @PostMapping
    public String addNewCat(@ModelAttribute("kot") @Valid KotDTO kot, BindingResult result) {
        if(result.hasErrors()) {
            return "newCat";
        } else {
            kotyService.createNewCat(kot);
            return "redirect:/";
        }
    }

//    @GetMapping("/catDetails/{id}")
//    public String displayCatDetails(@PathVariable String id, Model model) {
//        model.addAttribute("kot", kotDAO.getListaKotow().get(Integer.parseInt(id)));
//        return "catDetails";
//    }

    @GetMapping("/catDetails/{id}")
    public String displayCatDetails(@PathVariable String id, Model model) {
        model.addAttribute("kot", kotyService.getCat(id));
        return "catDetails";
    }
}
