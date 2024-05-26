package gr.ieee.cs.uowm.myuowm_admin_panel.datasource.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.Club;

public interface MyUoWmAdminPanelClubRepository extends JpaRepository<Club, String> {

}
