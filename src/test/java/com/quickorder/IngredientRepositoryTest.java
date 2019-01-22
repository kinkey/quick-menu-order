package com.quickorder;

import com.quickorder.entity.Ingredient;
import com.quickorder.repository.IngredientRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class IngredientRepositoryTest {

    static final String TEST_INGREDIENT_NAME = "testIngredientName";
    static final String TEST_INGREDIENT_DESCRIPTION = "testIngredientDescription";
    static final BigDecimal TEST_INGREDIENT_PRICE_WHEN_EXTRA = new BigDecimal("1.99");

    @Autowired
    public IngredientRepository ingredientRepository;

    @Test
    public void createNewIngredient() {
        Ingredient testIngredient = createIngredient();
        Ingredient savedIngredient = ingredientRepository.save(testIngredient);

        assertThat(savedIngredient.getName(), equalTo(TEST_INGREDIENT_NAME));
        assertThat(savedIngredient.getDescription(), equalTo(TEST_INGREDIENT_DESCRIPTION));
        assertThat(savedIngredient.getPriceWhenExtra(),equalTo(TEST_INGREDIENT_PRICE_WHEN_EXTRA));
    }

    private Ingredient createIngredient() {
        Ingredient testIngredient = new Ingredient();

        testIngredient.setName(TEST_INGREDIENT_NAME);
        testIngredient.setDescription(TEST_INGREDIENT_DESCRIPTION);
        testIngredient.setPriceWhenExtra(TEST_INGREDIENT_PRICE_WHEN_EXTRA);

        return testIngredient;
    }
}
