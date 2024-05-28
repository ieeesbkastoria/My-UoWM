package gr.ieee.cs.uowm.myuowm_admin_panel.datasource.repository;

import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.Link;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LinkRepository extends JpaRepository<Link, Long> {
    Optional<Link> findByUsage(String usage);
}
