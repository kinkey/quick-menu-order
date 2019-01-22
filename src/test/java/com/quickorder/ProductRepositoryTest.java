package com.quickorder;

import com.quickorder.entity.Ingredient;
import com.quickorder.entity.Product;
import com.quickorder.entity.SubCategory;
import com.quickorder.repository.IngredientRepository;
import com.quickorder.repository.ProductRepository;
import com.quickorder.repository.SubCategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static com.quickorder.IngredientRepositoryTest.*;
import static com.quickorder.SubCategoryRepositoryTest.TEST_SUB_CATEGORY;
import static com.quickorder.SubCategoryRepositoryTest.TEST_SUB_CATEGORY_DESCRIPTION;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class ProductRepositoryTest {

    static final String TEST_PRODUCT_NAME = "testProductName";
    static final String TEST_PRODUCT_DESCRIPTION = "testProductDescription";
    static final BigDecimal TEST_PRODUCT_PRICE = new BigDecimal("22.99");
    static final BigDecimal TEST_PRODUCT_QUANTITY = new BigDecimal("11.25");

    @Autowired
    public ProductRepository productRepository;

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Test
    public void createNewProduct() {
        Product testProduct = createProduct();
        Product savedProduct = productRepository.save(testProduct);

        assertThat(savedProduct.getName(), equalTo(TEST_PRODUCT_NAME));
        assertThat(savedProduct.getDescription(), equalTo(TEST_PRODUCT_DESCRIPTION));
        assertThat(savedProduct.getPrice(),equalTo(TEST_PRODUCT_PRICE));
        assertThat(savedProduct.getQuantity(),equalTo(TEST_PRODUCT_QUANTITY));
    }

    private Product createProduct() {
        Product testProduct = new Product();

        testProduct.setName(TEST_PRODUCT_NAME);
        testProduct.setDescription(TEST_PRODUCT_DESCRIPTION);
        testProduct.setPrice(TEST_PRODUCT_PRICE);
        testProduct.setQuantity(TEST_PRODUCT_QUANTITY);

        return testProduct;
    }

    private Ingredient createIngredient() {
        Ingredient testIngredient = new Ingredient();

        testIngredient.setName(TEST_INGREDIENT_NAME);
        testIngredient.setDescription(TEST_INGREDIENT_DESCRIPTION);
        testIngredient.setPriceWhenExtra(TEST_INGREDIENT_PRICE_WHEN_EXTRA);

        return testIngredient;
    }
    private SubCategory createSubCategory() {
        SubCategory testSubCategory = new SubCategory();

        testSubCategory.setName(TEST_SUB_CATEGORY);
        testSubCategory.setDescription(TEST_SUB_CATEGORY_DESCRIPTION);

        return testSubCategory;
    }
}
