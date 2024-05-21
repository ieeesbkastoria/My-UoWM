package gr.ieee.cs.uowm.myuowm_admin_panel.service.impl;

import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.Club;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.Link;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.MealPlan;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.Personnel;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.repository.MyUoWmAdminPanelClubRepository;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.repository.MyUoWmAdminPanelLinkRepository;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.repository.MyUoWmAdminPanelMealPlanRepository;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.repository.MyUoWmAdminPanelPersonnelRepository;
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

    MyUoWmAdminPanelPersonnelRepository personnelRepository;
    MyUoWmAdminPanelClubRepository clubRepository;
    MyUoWmAdminPanelLinkRepository linkRepository;
    MyUoWmAdminPanelMealPlanRepository mealPlanRepository;

    @Override
    public List<Link> updateLinks(List<Link> links){
        links.forEach(link -> {
            if(linkRepository.findByUsage(link.getUsage()).isEmpty())
                throw new LinkNotFoundException("The link with the usage: " + link.getUsage() + "could not be found");
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
                throw new PersonnelNotFoundException("The employee with the id: " + employee.getPersonnel_id() + "could not be found");
        });

        personnelRepository.saveAll(personnel);
        return personnel;
    }

    @Override
    public String deletePersonnel(String personnelId) {
        if(personnelRepository.findById(personnelId).isEmpty())
            throw new PersonnelNotFoundException("The employee with the id: " + personnelId + "could not be found");

        personnelRepository.deleteById(personnelId);
        return "Personal with id: " + personnelId + " deleted successfully";

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
                throw new ClubNotFoundException("The club with the name: " + club.getClubName() + " could not be found");
        });

        clubRepository.saveAll(clubs);
        return clubs;
    }

    @Override
    public String deleteClub(String clubId) {
            if(clubRepository.findById(clubId).isEmpty())
                throw new ClubNotFoundException("The club with the name: " + clubId + " could not be found");

            clubRepository.deleteById(clubId);
            return "Club deleted successfully";
    }
}
