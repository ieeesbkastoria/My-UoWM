package gr.ieee.cs.uowm.myuowm_admin_panel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import gr.ieee.cs.uowm.myuowm_admin_panel.model.TimeTable;

import java.util.Optional;

public interface MyUoWmAdminPanelTimeTableRepository extends JpaRepository<TimeTable, Long>{
    Optional<TimeTable> findTopByOrderByIdDesc();
}
