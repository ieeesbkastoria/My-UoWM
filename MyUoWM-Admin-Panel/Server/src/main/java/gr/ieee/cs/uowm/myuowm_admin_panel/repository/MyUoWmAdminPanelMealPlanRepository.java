package gr.ieee.cs.uowm.myuowm_admin_panel.repository;

import gr.ieee.cs.uowm.myuowm_admin_panel.model.MealPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MyUoWmAdminPanelMealPlanRepository extends JpaRepository<MealPlan, Long> {
    Optional<MealPlan> findTopByOrderByIdDesc();
}
