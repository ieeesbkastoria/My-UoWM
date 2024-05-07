package gr.ieee.cs.uowm.myuowm_admin_panel.repository;

import gr.ieee.cs.uowm.myuowm_admin_panel.model.MealPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MyUoWmAdminPanelMealPlanRepository extends JpaRepository<MealPlan, Long> {
    public List<MealPlan> findByMealId(Byte id);
}
