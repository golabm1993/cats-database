package pl.kobietydokodu.photos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pl.kobietydokodu.service.PhotosService;

@RestController("/upload")
public class PhotosController {

    @Autowired
    private PhotosService photosService;

    @PostMapping("/upload/{id}")
    public ResponseEntity singleFileUpload(@RequestParam("file") MultipartFile file, @PathVariable String id) {
        photosService.save(file, id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
