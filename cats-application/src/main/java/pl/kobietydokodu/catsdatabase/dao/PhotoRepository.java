package pl.kobietydokodu.catsdatabase.dao;

import org.springframework.data.repository.CrudRepository;
import pl.kobietydokodu.catsdatabase.model.CatPhoto;

public interface PhotoRepository extends CrudRepository<CatPhoto, Integer> {
}
