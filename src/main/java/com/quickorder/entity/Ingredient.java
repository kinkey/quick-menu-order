package com.quickorder.entity;

import javax.persistence.*;

/**
 * Created by bci on 12/18/18 at 3:32 PM
 */
@Entity
@Table(name = "ingredients")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_gen")
    @SequenceGenerator(name = "seq_gen", sequenceName = "seq_ingredients")
    private Long id;

    @Column(name = "ingredient_name")
    private String ingredientName;


    public Ingredient() {
    }
}
