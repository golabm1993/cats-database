package pl.kobietydokodu.toys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.kobietydokodu.catsdatabase.dto.ToyDTO;
import pl.kobietydokodu.catsdatabase.model.Toy;
import pl.kobietydokodu.service.ToysService;

import javax.validation.Valid;

@Controller("/toys")
public class ToysController {

    @Autowired
    private ToysService toysService;

    @GetMapping("/newToy/{id}")
    public String newToyForm(@PathVariable String id, Model model) {
        model.addAttribute("catId", id);
        model.addAttribute("toy", new Toy());
        return "newToy";
    }

    @PostMapping("/newToy/{id}")
    public String addNewToy(@PathVariable String id, @ModelAttribute("toy") @Valid ToyDTO toyDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "newToy";
        } else {
            toysService.createNewToy(toyDTO, id);
            return "redirect:/catDetails/" + id;
        }
    }

    @DeleteMapping("/catDetails/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        toysService.deleteToy(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
