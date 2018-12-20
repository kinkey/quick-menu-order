package com.quickorder.entity;

import javax.persistence.*;

/**
 * Created by bci on 12/18/18 at 3:32 PM
 */
@Entity
@Table(name = "sub_categories")
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_gen")
    @SequenceGenerator(name = "seq_gen", sequenceName = "seq_sub_categories")
    private Long id;

    @Column(name = "sub_category_name")
    private String name;


    @Column(name = "sub_category_description")
    private String description;







    public SubCategory() {
    }
}
