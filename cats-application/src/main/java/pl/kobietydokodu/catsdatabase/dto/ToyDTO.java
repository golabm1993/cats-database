package pl.kobietydokodu.catsdatabase.dto;

import pl.kobietydokodu.catsdatabase.model.Cat;
import pl.kobietydokodu.catsdatabase.model.Toy;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ToyDTO {

    private Integer id;

    @NotEmpty
    private String name;

    @NotNull
    private Integer amount;

    private Cat cat;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Toy toEntity() {
        Toy toy = new Toy();
        toy.setName(name);
        toy.setAmount(amount);
        return toy;
    }

    public ToyDTO fromEntity(Toy toy) {
        ToyDTO toyDTO = new ToyDTO();
        toyDTO.setName(toy.getName());
        toyDTO.setAmount(toy.getAmount());
        return toyDTO;
    }
}
