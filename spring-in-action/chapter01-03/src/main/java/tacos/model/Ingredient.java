package tacos.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "ingredient")
public class Ingredient {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @ManyToMany(mappedBy = "ingredients")
    private List<Taco> tacos;

    public enum Type {
        WRAP, PROTEIN, CHEESE, VEGGIES, SAUCE
    }
}