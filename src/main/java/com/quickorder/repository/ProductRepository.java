package com.quickorder.repository;

import com.quickorder.entity.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by bci on 2019-01-21 at 09:33
 */
public interface ProductRepository extends CrudRepository<Product, Long> {
}
