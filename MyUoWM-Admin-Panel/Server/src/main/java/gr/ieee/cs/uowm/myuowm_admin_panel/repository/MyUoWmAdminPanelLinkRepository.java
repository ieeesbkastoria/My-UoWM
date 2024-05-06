package gr.ieee.cs.uowm.myuowm_admin_panel.repository;

import gr.ieee.cs.uowm.myuowm_admin_panel.model.Link;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MyUoWmAdminPanelLinkRepository  extends JpaRepository<Link, Long> {
    Optional<Link> findByUsage(String usage);
}
