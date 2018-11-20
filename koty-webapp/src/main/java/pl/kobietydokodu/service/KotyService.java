package pl.kobietydokodu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kobietydokodu.bazakotow.dao.KotRepository;
import pl.kobietydokodu.bazakotow.dto.KotDTO;
import pl.kobietydokodu.bazakotow.model.Kot;

@Service
public class KotyService {

    private final KotRepository kotRepository;

    @Autowired
    public KotyService(KotRepository kotRepository) {
        this.kotRepository = kotRepository;
    }

    public Kot createNewCat(KotDTO kotDTO) {
        return kotRepository.save(KotDTOToKot(kotDTO));
    }

    public Iterable<Kot> getWszystkieKoty() {
        return kotRepository.findAll();
    }

    public Kot getCat(String id) {

        return kotRepository.findById(Integer.parseInt(id)).get();
    }

    private Kot KotDTOToKot(KotDTO kotDTO) {
        Kot kot = new Kot();
        kot.setImie(kotDTO.getImie());
        kot.setDataUrodzenia(kotDTO.getDataUrodzenia());
        kot.setWaga(kotDTO.getWaga());
        kot.setOpiekun(kotDTO.getOpiekun());
        return kot;
    }
}
