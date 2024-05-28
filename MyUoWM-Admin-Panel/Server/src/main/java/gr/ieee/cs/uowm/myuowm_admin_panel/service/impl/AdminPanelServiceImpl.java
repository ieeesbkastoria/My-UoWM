package gr.ieee.cs.uowm.myuowm_admin_panel.service.impl;

import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.Club;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.Link;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.MealPlan;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.Personnel;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.repository.ClubRepository;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.repository.LinkRepository;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.repository.MealPlanRepository;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.repository.PersonnelRepository;
import gr.ieee.cs.uowm.myuowm_admin_panel.exception.club.ClubNotFoundException;
import gr.ieee.cs.uowm.myuowm_admin_panel.exception.link.LinkNotFoundException;
import gr.ieee.cs.uowm.myuowm_admin_panel.exception.personnel.PersonnelNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import gr.ieee.cs.uowm.myuowm_admin_panel.service.AdminPanelService;

import java.util.List;

@Service
@AllArgsConstructor
public class AdminPanelServiceImpl implements AdminPanelService {

    PersonnelRepository personnelRepository;
    ClubRepository clubRepository;
    LinkRepository linkRepository;
    MealPlanRepository mealPlanRepository;

    @Override
    public List<Link> updateLinks(List<Link> links){
        links.forEach(link -> {
            if(linkRepository.findByUsage(link.getUsage()).isEmpty())
                throw new LinkNotFoundException("The list of links contains a non valid link usage");
        });

        linkRepository.saveAll(links);
        return links;
    }

    @Override
    public List<MealPlan> saveMealPlan(List<MealPlan> mealPlan) {
        mealPlan.forEach(meal -> meal.setMealId(1L));
        mealPlanRepository.saveAll(mealPlan);
        return mealPlan;
    }

    @Override
    public Personnel savePersonnel(Personnel personnel) {
        personnelRepository.save(personnel);
        return personnel;
    }

    @Override
    public List<Personnel> updatePersonnel(List<Personnel> personnel) {
        personnel.forEach(employee -> {
            if(personnelRepository.findById(employee.getPersonnel_id()).isEmpty())
                throw new PersonnelNotFoundException("The provided list contains an employee with an unknown id");
        });

        personnelRepository.saveAll(personnel);
        return personnel;
    }

    @Override
    public String deletePersonnel(String personnelId) {
        if(personnelRepository.findById(personnelId).isEmpty())
            throw new PersonnelNotFoundException("The employee with the id: " + personnelId + " could not be found");

        personnelRepository.deleteById(personnelId);
        return "Personnel with id: " + personnelId + " deleted successfully";

    }

    @Override
    public Club saveClub(Club club) {
        clubRepository.save(club);
        return club;
    }

    @Override
    public List<Club> updateClub(List<Club> clubs) {
        clubs.forEach(club -> {
            if(clubRepository.findById(club.getClubName()).isEmpty())
                throw new ClubNotFoundException("The list of clubs contains a non valid club name");
        });

        clubRepository.saveAll(clubs);
        return clubs;
    }

    @Override
    public String deleteClub(String clubId) {
            if(clubRepository.findById(clubId).isEmpty())
                throw new ClubNotFoundException("The provided clubs name does not match any club in the database");

            clubRepository.deleteById(clubId);
            return "Club deleted successfully";
    }
}
