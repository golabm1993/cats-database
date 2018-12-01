package pl.kobietydokodu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kobietydokodu.catsdatabase.dao.CatRepository;
import pl.kobietydokodu.catsdatabase.dao.ToyRepository;
import pl.kobietydokodu.catsdatabase.dto.ToyDTO;
import pl.kobietydokodu.catsdatabase.model.Cat;
import pl.kobietydokodu.catsdatabase.model.Toy;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class ToysService {

    private final ToyRepository toyRepository;

    private final CatRepository catRepository;

    @Autowired
    public ToysService(ToyRepository toyRepository, CatRepository catRepository) {

        this.toyRepository = toyRepository;
        this.catRepository = catRepository;
    }

    public Toy createNewToy(@Valid ToyDTO toyDTO, String catId) {
        Optional<Cat> cat = catRepository.findById(Integer.valueOf(catId));
        Toy toy = toyDTO.toEntity();
        toy.setCat(cat.get());
        return toyRepository.save(toy);
    }

    public List<Toy> getAllToys() {
        return (List<Toy>) toyRepository.findAll();
    }

    public void deleteToy(String id) {
        toyRepository.deleteById(Integer.valueOf(id));
    }

}
