package pl.kobietydokodu.catsdatabase.dao;

import org.springframework.data.repository.CrudRepository;
import pl.kobietydokodu.catsdatabase.model.Cat;

public interface CatRepository extends CrudRepository<Cat, Integer> {
}
