package pl.kobietydokodu.catsdatabase.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.kobietydokodu.catsdatabase.dto.CatDTO;
import pl.kobietydokodu.catsdatabase.model.Cat;

import java.util.Optional;

@Repository
public class CatDAO {

    @Autowired
    private CatRepository catRepository;

    private Cat cat;

    public Iterable<Cat> getAllCats() {
        return catRepository.findAll();
    }

    // w bazach danych są metody persist albo save
    // zamiast dodajKota

    public CatDTO addCat(Cat cat) {
        catRepository.save(cat);
        return null;
    }

    public Optional<Cat> getCat(String id) {
        return catRepository.findById(Integer.parseInt(id));
    }

    @Override
    public String toString() {
        return cat.sayHello();
    }

}
