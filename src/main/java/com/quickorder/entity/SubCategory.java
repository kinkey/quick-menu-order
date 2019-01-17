package com.quickorder.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sub_categories")
public class SubCategory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subCategory_id")
    private Category category;

    @OneToMany(mappedBy = "subCategory")
    private List<Product> productList;

    @Column(name = NAME)
    private String name;

    @Column(name = DESCRIPTION)
    private String description;

    public Long getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
