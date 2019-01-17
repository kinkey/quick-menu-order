package com.quickorder.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ingredients")
public class Ingredient extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = NAME)
    private String name;

    @Column(name = DESCRIPTION)
    private String description;

    @Column(name = PRICE_WHEN_EXTRA)
    private String priceWhenExtra;

    @ManyToMany(mappedBy = "ingredientList")
    private List<Product> productList = new ArrayList<>();

}
