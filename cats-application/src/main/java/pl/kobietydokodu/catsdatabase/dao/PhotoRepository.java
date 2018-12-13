package pl.kobietydokodu.catsdatabase.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pl.kobietydokodu.catsdatabase.model.CatPhoto;

public interface PhotoRepository extends JpaRepository<CatPhoto, Integer> {

    CatPhoto findCatPhotoByCatId(@Param("cat_id") Long catId);
}
