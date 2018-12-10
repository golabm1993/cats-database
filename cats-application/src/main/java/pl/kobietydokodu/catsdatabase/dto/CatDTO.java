package pl.kobietydokodu.catsdatabase.dto;

import pl.kobietydokodu.catsdatabase.model.Cat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CatDTO {

    @NotEmpty
    private String name;

    @NotEmpty
    private String dateOfBirth;

    @NotNull
    private Float weight;

    @NotEmpty
    private String keeper;

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

    public Cat toEntity() {
        Cat cat = new Cat();
        cat.setName(name);
        cat.setDateOfBirth(dateOfBirth);
        cat.setWeight(weight);
        cat.setKeeper(keeper);
        return cat;
    }

    public CatDTO fromEntity(Cat cat) {
        CatDTO catDTO = new CatDTO();
        catDTO.setName(cat.getName());
        catDTO.setDateOfBirth(cat.getDateOfBirth());
        catDTO.setWeight(cat.getWeight());
        catDTO.setKeeper(cat.getKeeper());
        return catDTO;
    }
}
