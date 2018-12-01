package pl.kobietydokodu.catsdatabase.model;

import javax.persistence.*;

@Entity
public class Toy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer amount;

    @ManyToOne
    @JoinColumn(name = "cat_id")
    private Cat cat;

    public Toy() {}

    public Toy(String id) {
        this.id = Integer.parseInt(id);
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Toy(String name, Integer amount) {
        this.name = name;
        this.amount = amount;
        this.id = cat.getId();
    }

    public Integer getCatId() {
        return cat.getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
