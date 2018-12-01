package pl.kobietydokodu.catsdatabase.dao;

import org.springframework.data.repository.CrudRepository;
import pl.kobietydokodu.catsdatabase.model.Toy;

public interface ToyRepository extends CrudRepository<Toy, Integer> {
}
