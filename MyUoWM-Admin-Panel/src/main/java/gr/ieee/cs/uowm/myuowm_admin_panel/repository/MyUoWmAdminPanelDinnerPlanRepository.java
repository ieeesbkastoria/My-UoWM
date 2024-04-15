package gr.ieee.cs.uowm.myuowm_admin_panel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import gr.ieee.cs.uowm.myuowm_admin_panel.model.DinnerPlan;

public interface MyUoWmAdminPanelDinnerPlanRepository extends JpaRepository<DinnerPlan, String> {

}
