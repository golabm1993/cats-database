package pl.kobietydokodu.catsdatabase.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.kobietydokodu.catsdatabase.dto.CatDTO;
import pl.kobietydokodu.catsdatabase.model.Cat;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public class CatDAO {

    @Autowired
    private CatRepository catRepository;

    private Cat cat;

    @PersistenceContext
    EntityManager entityManager;

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

    @Transactional
    public Cat findCat(String id) {
        return entityManager.find(Cat.class, id);
    }

    @Transactional
    public void saveOrUpdate(Cat cat) {
        entityManager.merge(cat);
    }

//    public List<Cat> getCatsList() {
//        Query query = entityManager.createQuery("SELECT k FROM CAT k");
//        List<Cat> cats = query.getResultList();
//        return cats;
//    }

    @Override
    public String toString() {
        return cat.sayHello();
    }

}
