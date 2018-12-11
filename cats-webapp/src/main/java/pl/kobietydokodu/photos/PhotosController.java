package pl.kobietydokodu.photos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.kobietydokodu.service.PhotosService;

@RestController("/upload")
public class PhotosController {

    @Autowired
    private PhotosService photosService;

    @GetMapping("/photoUpload")
    public void fileUpload() {

    }

    @PostMapping("/upload/{id}")
    public String singleFileUpload(@RequestParam("file") MultipartFile file, @PathVariable String id) {

        photosService.save(file, id);

        return "ok";
    }
}
