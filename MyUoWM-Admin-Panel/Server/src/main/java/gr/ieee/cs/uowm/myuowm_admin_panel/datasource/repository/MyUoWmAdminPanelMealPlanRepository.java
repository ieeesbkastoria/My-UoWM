package gr.ieee.cs.uowm.myuowm_admin_panel.datasource.repository;

import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.MealPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MyUoWmAdminPanelMealPlanRepository extends JpaRepository<MealPlan, Long> {
    public List<MealPlan> findByMealId(Byte id);
}
