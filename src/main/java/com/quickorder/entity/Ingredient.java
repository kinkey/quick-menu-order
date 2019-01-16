package com.quickorder.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ingredients")
public class Ingredient extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = SEQ_GENERATOR)
    @SequenceGenerator(name = SEQ_GENERATOR, sequenceName = SEQ_INGREDIENT)
    private Long id;

    @Column(name = NAME)
    private String name;

    @Column(name = DESCRIPTION)
    private String description;

    @Column(name = "price_when_extra")
    private String priceWhenExtra;

    @ManyToMany(mappedBy = "ingredientList")
    private List<Product> productList = new ArrayList<>();

}
