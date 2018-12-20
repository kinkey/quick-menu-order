package com.quickorder.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_gen")
    @SequenceGenerator(name = "seq_gen", sequenceName = "seq_products")
    private Long id;


    @Column(name = "product_name")
    private String name;

    @Column(name = "product_description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;


    @Column(name = "quantity")
    private BigDecimal quantity;



    private Ingredient ingredients;



    private SubCategory subCategory;


    public Product() {
    }
}
