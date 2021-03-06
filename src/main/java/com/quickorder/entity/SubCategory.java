package com.quickorder.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sub_categories")
public class SubCategory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = SEQ_GENERATOR)
    @SequenceGenerator(name = SEQ_GENERATOR, sequenceName = SEQ_SUBCATEGORY)
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


}
