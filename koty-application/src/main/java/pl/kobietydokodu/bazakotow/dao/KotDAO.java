package pl.kobietydokodu.bazakotow.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.kobietydokodu.bazakotow.dto.KotDTO;
import pl.kobietydokodu.bazakotow.model.Kot;

import java.util.Optional;

@Repository
public class KotDAO {

    @Autowired
    private KotRepository kotRepository;

    private Kot kot;

//    private static final List<Kot> LISTA_KOTOW = new ArrayList<>();

//    public List<Kot> getListaKotow() {
//        return LISTA_KOTOW;
//    }

    public Iterable<Kot> getWszystkieKoty() {
        return kotRepository.findAll();
    }

    // w bazach danych są metody persist albo save
    // zamiast dodajKota

    public KotDTO dodajKota(Kot kot) {
            kotRepository.save(kot);
//        LISTA_KOTOW.add(kot);
        return null;
    }

    public Optional<Kot> getKot(String id) {
        return kotRepository.findById(Integer.parseInt(id));
    }

    @Override
    public String toString() {
        return kot.przedstawSie();
    }

}
