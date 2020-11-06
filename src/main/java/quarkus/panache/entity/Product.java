package quarkus.panache.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    private Long id;

    @NotEmpty(message = "the name is null")
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Min(1)
    private Float price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nome) {
        this.name = nome;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float preco) {
        this.price = preco;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
