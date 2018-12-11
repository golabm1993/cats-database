package pl.kobietydokodu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.kobietydokodu.catsdatabase.dao.CatRepository;
import pl.kobietydokodu.catsdatabase.dao.PhotoRepository;
import pl.kobietydokodu.catsdatabase.model.Cat;
import pl.kobietydokodu.catsdatabase.model.CatPhoto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PhotosService {

    private static String UPLOADED_FOLDER = "C:\\dev\\webProject\\BazaKotow\\koty-webapp\\src\\main\\resources\\";
    private static String SAVING_FOLDER = "C:\\dev\\webProject\\BazaKotow\\koty-webapp\\src\\main\\resources\\temp\\";

    private final PhotoRepository photoRepository;

    private final CatRepository catRepository;

    @Autowired
    public PhotosService(PhotoRepository photoRepository, CatRepository catRepository) {
        this.photoRepository = photoRepository;
        this.catRepository = catRepository;
    }

    public CatPhoto save(MultipartFile file, String catId) {

        byte[] bytes = new byte[0];

        String databasePhotoName = null;
        databasePhotoName = saveToFile(file, databasePhotoName);
        CatPhoto savedPhoto = photoRepository.save(createCatPhoto(file.getOriginalFilename(), Integer.valueOf(catId), databasePhotoName));
        return savedPhoto;
    }

    private String saveToFile(MultipartFile file, String databasePhotoName) {
        byte[] bytes;
        try {

            bytes = file.getBytes();

            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            databasePhotoName = String.valueOf(new Date().getTime());
            Path path1 = Paths.get(SAVING_FOLDER + databasePhotoName + ".jpg");

//            Files.write(path, bytes);
            Files.write(path1, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return databasePhotoName;
    }

    public List<CatPhoto> getAllPhotos() {
        return (List<CatPhoto>) photoRepository.findAll();
    }

    private CatPhoto createCatPhoto(String fileName, Integer catId, String databasePhotoName) {
        CatPhoto catPhoto = new CatPhoto();
        catPhoto.setOriginalPhotoName(fileName);
        catPhoto.setDatabasePhotoName(databasePhotoName);
        Optional<Cat> cat = catRepository.findById(catId);
        catPhoto.setCat(cat.get());
        return catPhoto;
    }

}
