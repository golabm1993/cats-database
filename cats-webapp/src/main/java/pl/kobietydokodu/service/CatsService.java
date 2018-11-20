package pl.kobietydokodu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kobietydokodu.catsdatabase.dao.CatRepository;
import pl.kobietydokodu.catsdatabase.dto.CatDTO;
import pl.kobietydokodu.catsdatabase.model.Cat;

import javax.validation.Valid;

@Service
public class CatsService {

    private final CatRepository catRepository;

    @Autowired
    public CatsService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    public Cat createNewCat(@Valid CatDTO catDTO) {
        return catRepository.save(CatDTOToCat(catDTO));
    }

    public Iterable<Cat> getAllCats() {
        return catRepository.findAll();
    }

    public Cat getCat(String id) {

        return catRepository.findById(Integer.parseInt(id)).get();
    }

    private Cat CatDTOToCat(CatDTO catDTO) {
        Cat cat = new Cat();
        cat.setName(catDTO.getName());
        cat.setDateOfBirth(catDTO.getDateOfBirth());
        cat.setWeight(catDTO.getWeight());
        cat.setKeeper(catDTO.getKeeper());
        return cat;
    }
}
