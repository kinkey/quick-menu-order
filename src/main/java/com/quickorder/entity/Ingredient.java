package com.quickorder.entity;

import javax.persistence.*;

@Entity
@Table(name = "ingredients")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_gen")
    @SequenceGenerator(name = "seq_gen", sequenceName = "seq_ingredients")
    private Long id;

    @Column(name = "ingredient_name")
    private String ingredientName;

    @Column(name = "description")
    private String description;

    @Column(name = "price_when_extra")
    private String priceWhenExtra;

    public Ingredient() {
    }
}
