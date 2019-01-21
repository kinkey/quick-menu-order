package com.quickorder;

import com.quickorder.entity.Category;
import com.quickorder.entity.SubCategory;
import com.quickorder.repository.CategoryRepository;
import com.quickorder.repository.SubCategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static com.quickorder.SubCategoryRepositoryTest.TEST_SUB_CATEGORY;
import static com.quickorder.SubCategoryRepositoryTest.TEST_SUB_CATEGORY_DESCRIPTION;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class CategoryRepositoryTest {

    static final String TEST_CATEGORY_NAME = "testCategoryName";
    static final String TEST_CATEGORY_DESCRIPTION = "someTestCategoryDescription";

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Test
    public void createNewCategory() {
        Category testCategory = createCategory();
        Category savedCategory = categoryRepository.save(testCategory);

        assertThat(savedCategory.getName(), equalTo(TEST_CATEGORY_NAME));
        assertThat(savedCategory.getDescription(), equalTo(TEST_CATEGORY_DESCRIPTION));
    }

    @Test
    public void linkSubCategory() {
        Category testCategory = createCategory();
        SubCategory testSubcategory = createSubCategory();
        SubCategory savedSubcategory = subCategoryRepository.save(testSubcategory);

        assertThat(savedSubcategory.getName(), equalTo(TEST_SUB_CATEGORY));
        assertThat(savedSubcategory.getDescription(), equalTo(TEST_SUB_CATEGORY_DESCRIPTION));

        List<SubCategory> subCategoryList = new ArrayList<>();
        subCategoryList.add(testSubcategory);

        testCategory.setSubCategoryList(subCategoryList);
        testSubcategory.setCategory(testCategory);

        Category savedCategory = categoryRepository.save(testCategory);

        assertThat(savedCategory.getName(), equalTo(TEST_CATEGORY_NAME));
        assertThat(savedCategory.getDescription(), equalTo(TEST_CATEGORY_DESCRIPTION));

        assertThat(savedCategory.getSubCategoryList().get(0).getCategory().getId(), equalTo(savedCategory.getId()));
        assertThat(savedCategory.getSubCategoryList().get(0).getCategory().getName(), equalTo(TEST_CATEGORY_NAME));
        assertThat(savedCategory.getSubCategoryList().get(0).getCategory().getDescription(), equalTo(TEST_CATEGORY_DESCRIPTION));

        assertThat(savedCategory.getSubCategoryList().get(0).getName(), equalTo(TEST_SUB_CATEGORY));
        assertThat(savedCategory.getSubCategoryList().get(0).getDescription(), equalTo(TEST_SUB_CATEGORY_DESCRIPTION));

    }

    private Category createCategory() {
        Category testCategory = new Category();

        testCategory.setName(TEST_CATEGORY_NAME);
        testCategory.setDescription(TEST_CATEGORY_DESCRIPTION);
        return testCategory;
    }
    private SubCategory createSubCategory() {
        SubCategory subCategory = new SubCategory();

        subCategory.setName(TEST_SUB_CATEGORY);
        subCategory.setDescription(TEST_SUB_CATEGORY_DESCRIPTION);
        return subCategory;
    }
}
