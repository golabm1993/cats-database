package pl.kobietydokodu.catsdatabase.dto;

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
}
