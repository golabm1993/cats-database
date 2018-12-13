package pl.kobietydokodu.catsdatabase.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String dateOfBirth;
    private Float weight;
    private String keeper;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cat", orphanRemoval = true)
    private List<Toy> toys;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catId", orphanRemoval = true)
    private List<CatPhoto> photos;

    public List<Toy> getToys() {
        return toys;
    }

    public List<CatPhoto> getPhotos() {
        return photos;
    }

    public void setPhotos(List<CatPhoto> photos) {
        this.photos = photos;
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void setToys(List<Toy> toys) {
        this.toys = toys;
    }

    public Cat(String name, String dateOfBirth, Float weight, String keeper) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.weight = weight;
        this.keeper = keeper;
        toys = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cat() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public String getKeeper() {
        return keeper;
    }

    public void setKeeper(String keeper) {
        this.keeper = keeper;
    }

    public String sayHello() {
        return this.name + " " + this.dateOfBirth + " " + this.weight + " " + this.keeper;
    }
}
