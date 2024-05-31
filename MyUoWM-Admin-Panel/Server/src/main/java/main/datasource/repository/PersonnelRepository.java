package main.datasource.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import main.datasource.model.Personnel;

public interface PersonnelRepository extends JpaRepository<Personnel, String>{

}
