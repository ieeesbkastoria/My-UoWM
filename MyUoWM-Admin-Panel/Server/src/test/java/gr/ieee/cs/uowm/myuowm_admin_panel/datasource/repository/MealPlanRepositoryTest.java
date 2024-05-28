package gr.ieee.cs.uowm.myuowm_admin_panel.datasource.repository;

import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.MealPlan;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.MealType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class MealPlanRepositoryTest {

    @Autowired
    private MealPlanRepository mealPlanRepository;
    MealPlan mealPlan;
    MealType mealType;

    @BeforeEach
    void setUp() {
        mealType = MealType.DINNER;
        mealPlan = new MealPlan(1L, 2L, 1,
                "Monday", "Soupa",
                "Fasolia", mealType,
                "salad", "dessert");

        mealPlanRepository.save(mealPlan);
    }

    @AfterEach
    void tearDown() {
        mealPlan = null;
        mealType = null;
        mealPlanRepository.deleteAll();
    }

    // Test case SUCCESS
    @Test
    void findByMealId_Found() {
        List<MealPlan> mealList = mealPlanRepository.findByMealId(2L);

        mealList.forEach(meal -> {
            assertThat(meal.getId().equals(mealPlan.getId())).isTrue();
            assertThat(meal.getMealId().equals(mealPlan.getMealId())).isTrue();
            assertThat(meal.getWeek_number().equals(mealPlan.getWeek_number())).isTrue();
            assertThat(meal.getDay_of_week().equals(mealPlan.getDay_of_week())).isTrue();
            assertThat(meal.getDish1().equals(mealPlan.getDish1())).isTrue();
            assertThat(meal.getDish2().equals(mealPlan.getDish2())).isTrue();
            assertThat(meal.getMealType().equals(mealPlan.getMealType())).isTrue();
            assertThat(meal.getSalad().equals(mealPlan.getSalad())).isTrue();
            assertThat(meal.getDessert().equals(mealPlan.getDessert())).isTrue();
        });
    }

    // Test case FAILURE
    @Test
    void findByMealId_NotFound() {
        List<MealPlan> mealList = mealPlanRepository.findByMealId(3L);

        mealList.forEach(meal -> {
            assertThat(meal.getId().equals(mealPlan.getId())).isFalse();
            assertThat(meal.getMealId().equals(mealPlan.getMealId())).isFalse();
            assertThat(meal.getWeek_number().equals(mealPlan.getWeek_number())).isFalse();
            assertThat(meal.getDay_of_week().equals(mealPlan.getDay_of_week())).isFalse();
            assertThat(meal.getDish1().equals(mealPlan.getDish1())).isFalse();
            assertThat(meal.getDish2().equals(mealPlan.getDish2())).isFalse();
            assertThat(meal.getMealType().equals(mealPlan.getMealType())).isFalse();
            assertThat(meal.getSalad().equals(mealPlan.getSalad())).isFalse();
            assertThat(meal.getDessert().equals(mealPlan.getSalad())).isFalse();
        });
    }
}