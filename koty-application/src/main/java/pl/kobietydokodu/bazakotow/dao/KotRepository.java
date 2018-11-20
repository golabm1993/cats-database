package pl.kobietydokodu.bazakotow.dao;

import org.springframework.data.repository.CrudRepository;
import pl.kobietydokodu.bazakotow.model.Kot;

public interface KotRepository extends CrudRepository<Kot, Integer> {
}
