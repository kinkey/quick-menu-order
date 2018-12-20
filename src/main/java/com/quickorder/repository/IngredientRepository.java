package com.quickorder.repository;

import com.quickorder.entity.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository <Ingredient, Long> {
}
