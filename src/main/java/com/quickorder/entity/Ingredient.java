package com.quickorder.entity;

import javax.persistence.*;
import java.math.BigDecimal;
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
    private BigDecimal priceWhenExtra;

    @ManyToMany(mappedBy = "ingredientList")
    private List<Product> productList = new ArrayList<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPriceWhenExtra() {
        return priceWhenExtra;
    }

    public void setPriceWhenExtra(BigDecimal priceWhenExtra) {
        this.priceWhenExtra = priceWhenExtra;
    }
}