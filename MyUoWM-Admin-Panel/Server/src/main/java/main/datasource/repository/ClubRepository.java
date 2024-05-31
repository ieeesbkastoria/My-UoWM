package main.datasource.repository;

import main.datasource.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepository extends JpaRepository<Club, String> {

}
