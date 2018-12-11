package pl.kobietydokodu.catsdatabase.model;

import javax.persistence.*;

@Entity
public class CatPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String originalPhotoName;

    private String databasePhotoName;

    @ManyToOne
    @JoinColumn(name = "cat_id")
    private Cat cat;

    public CatPhoto() {}

    public CatPhoto(String originalPhotoName, Cat cat) {
        this.originalPhotoName = originalPhotoName;
        this.cat = cat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOriginalPhotoName() {
        return originalPhotoName;
    }

    public void setOriginalPhotoName(String originalPhotoName) {
        this.originalPhotoName = originalPhotoName;
    }

    public String getDatabasePhotoName() {
        return databasePhotoName;
    }

    public void setDatabasePhotoName(String databasePhotoName) {
        this.databasePhotoName = databasePhotoName;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }
}
