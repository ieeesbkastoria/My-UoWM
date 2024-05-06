package gr.ieee.cs.uowm.myuowm_admin_panel.service.impl;

import gr.ieee.cs.uowm.myuowm_admin_panel.model.*;
import gr.ieee.cs.uowm.myuowm_admin_panel.repository.*;
import gr.ieee.cs.uowm.myuowm_admin_panel.service.WebAppService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class WebAppServiceImpl implements WebAppService {

    MyUoWmAdminPanelClubRepository clubRepository;
    MyUoWmAdminPanelPersonnelRepository personnelRepository;
    MyUoWmAdminPanelLinkRepository linkRepository;
    MyUoWmAdminPanelMealPlanRepository mealPlanRepository;

    @Override
    public MealPlan getMealPlan() {
        Optional<MealPlan> optionalMealPlan = mealPlanRepository.findTopByOrderByIdDesc();
        if(optionalMealPlan.isPresent()) {
            return optionalMealPlan.get();
        } else {
            //TODO throw error
            return null;
        }


    }

    @Override
    public List<Personnel> getAllPersonnel() {
        return personnelRepository.findAll();
    }

    @Override
    public Personnel getPersonnel(String id) {
        if(personnelRepository.findById(id).isEmpty())
            //change system.out to custom Exception
            System.out.println("Error");
        return personnelRepository.findById(id).get();
    }

    @Override
    public List<Club> getAllClubs() {
        return clubRepository.findAll();
    }

    @Override
    public Club getClub(String id) {
        if(clubRepository.findById(id).isEmpty())
            //change system.out to custom Exception
            System.out.println("Error");
        return clubRepository.findById(id).get();
    }

    @Override
    public List<Link> getAllLinks() {
        return linkRepository.findAll();
    }

    @Override
    public Link getSpecificLink(String usage) {
        if(linkRepository.findByUsage(usage).isEmpty())
            //change system.out to custom Exception
            System.out.println("Error");
        return linkRepository.findByUsage(usage).get();
    }
}
