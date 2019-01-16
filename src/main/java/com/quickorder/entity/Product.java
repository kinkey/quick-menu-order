package com.quickorder.entity;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Product")
@Table(name = "products")
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = SEQ_GENERATOR)
    @SequenceGenerator(name = SEQ_GENERATOR, sequenceName = SEQ_PRODUCT)
    private Long id;

    @Column(name = NAME)
    private String name;

    @Column(name = DESCRIPTION)
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "quantity")
    private BigDecimal quantity;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "products_ingredients",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private List<Ingredient> ingredientList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subCategory_id")
    private SubCategory subCategory;


}
