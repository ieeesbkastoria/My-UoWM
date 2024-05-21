package gr.ieee.cs.uowm.myuowm_admin_panel.service.impl;

import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.Club;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.Link;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.MealPlan;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.Personnel;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.repository.MyUoWmAdminPanelClubRepository;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.repository.MyUoWmAdminPanelLinkRepository;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.repository.MyUoWmAdminPanelMealPlanRepository;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.repository.MyUoWmAdminPanelPersonnelRepository;
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
        try {
            linkRepository.saveAll(links);
            return links;
        } catch (Exception e) {
            //TODO Throw error
            return "Couldn't save Links";
        }
    }

    @Override
    public List<MealPlan> saveMealPlan(List<MealPlan> mealPlan) {
        try {
            mealPlan.forEach(meal -> meal.setMealId(1L));
            mealPlanRepository.saveAll(mealPlan);
            return mealPlan;
        } catch (Exception e) {
            //TODO throw error
            return "Couldnt save DinnerPlan";
        }
    }

    @Override
    public Personnel savePersonnel(Personnel personnel) {
        try {
            personnelRepository.save(personnel);
            return personnel;
        } catch (Exception e) {
            //TODO throw error
            return "Couldnt save personnel";
        }
    }

    @Override
    public Personnel updatePersonnel(Personnel personnel) {
        try {
            if(personnelRepository.findById(personnel.getPersonnel_id()).isEmpty())
                //TODO throw proper error message1
                return personnel;
            personnelRepository.save(personnel);
            return personnel;
        } catch (Exception e) {
            //TODO throw error
            return null;
        }
    }

    @Override
    public String deletePersonnel(String personnelId) {
        try {
            if(personnelRepository.findById(personnelId).isEmpty())
                // TODO throw proper error message
                return "Couldnt find personnel";
            personnelRepository.deleteById(personnelId);
            return "Personal deleted successfully";
        } catch (Exception e) {
            //TODO throw error
            return null;
        }
    }

    @Override
    public Club saveClub(Club club) {
        try {
            clubRepository.save(club);
            return Club;
        } catch (Exception e) {
            //TODO throw error
            return null;
        }
    }

    @Override
    public Club updateClub(Club club) {
        try {
            if(clubRepository.findById(club.getClubName()).isEmpty())
                //TODO throw proper error message
                return club;
            clubRepository.save(club);
            return club;
        } catch (Exception e) {
            //TODO throw error
            return "Unexpected error";
        }
    }

    @Override
    public String deleteClub(String clubId) {
        try {
            if(clubRepository.findById(clubId).isEmpty())
                // TODO throw proper error message
                return "Club not found";
            clubRepository.deleteById(clubId);
            return "Club deleted successfully";
        } catch (Exception e) {
            //TODO throw error
            return null;
        }
    }
}
