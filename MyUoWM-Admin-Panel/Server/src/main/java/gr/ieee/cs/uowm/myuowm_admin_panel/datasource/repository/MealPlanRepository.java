package gr.ieee.cs.uowm.myuowm_admin_panel.datasource.repository;

import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.MealPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MealPlanRepository extends JpaRepository<MealPlan, Long> {
    List<MealPlan> findByMealId(Long id);
}
