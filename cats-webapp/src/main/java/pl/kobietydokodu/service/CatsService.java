package pl.kobietydokodu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kobietydokodu.catsdatabase.dao.CatRepository;
import pl.kobietydokodu.catsdatabase.dto.CatDTO;
import pl.kobietydokodu.catsdatabase.model.Cat;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class CatsService {

    private final CatRepository catRepository;

    @Autowired
    public CatsService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    public CatDTO createNewCat(@Valid CatDTO catDTO) {
        Cat cat = catDTO.toEntity();
        Cat savedCat = catRepository.save(cat);
        CatDTO savedCatDTO = catDTO.fromEntity(savedCat);
        return savedCatDTO;
    }

    public List<Cat> getAllCats() {
        return (List<Cat>) catRepository.findAll();
    }

    public Cat getCat(String id) {
        Optional<Cat> cat = catRepository.findById(Integer.valueOf(id));
        if(cat.isPresent()) {
            return cat.get();
        }
        return null;
    }
}
