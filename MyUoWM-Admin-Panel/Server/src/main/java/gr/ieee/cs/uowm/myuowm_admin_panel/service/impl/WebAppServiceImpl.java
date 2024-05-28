package gr.ieee.cs.uowm.myuowm_admin_panel.service.impl;

import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.*;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.repository.ClubRepository;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.repository.LinkRepository;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.repository.MealPlanRepository;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.repository.PersonnelRepository;
import gr.ieee.cs.uowm.myuowm_admin_panel.exception.club.ClubNotFoundException;
import gr.ieee.cs.uowm.myuowm_admin_panel.exception.link.LinkNotFoundException;
import gr.ieee.cs.uowm.myuowm_admin_panel.exception.mealplan.MealPlanReturnDefaultException;
import gr.ieee.cs.uowm.myuowm_admin_panel.exception.personnel.PersonnelNotFoundException;
import gr.ieee.cs.uowm.myuowm_admin_panel.service.WebAppService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class WebAppServiceImpl implements WebAppService {

    ClubRepository clubRepository;
    PersonnelRepository personnelRepository;
    LinkRepository linkRepository;
    MealPlanRepository mealPlanRepository;

    @Override
    public List<MealPlan> getMealPlan() {
        if (!mealPlanRepository.findByMealId(1L).isEmpty())
            return mealPlanRepository.findByMealId(1L);

        // if there is no meal plan in the databases return a default meal plan
        throw new MealPlanReturnDefaultException("A default meal plan is return");
    }

    @Override
    public List<Personnel> getAllPersonnel() {
        return personnelRepository.findAll();
    }

    @Override
    public Personnel getPersonnel(String id) {
        if(personnelRepository.findById(id).isPresent())
            return personnelRepository.findById(id).get();

        throw new PersonnelNotFoundException("Given id does not match any personnel entity in the data base");
    }

    @Override
    public List<Club> getAllClubs() {
        return clubRepository.findAll();
    }

    @Override
    public Club getClub(String id) {
        if(clubRepository.findById(id).isPresent())
            return clubRepository.findById(id).get();

        throw new ClubNotFoundException("Given id does not match any club in the data base");
    }

    //TODO like the meal plan one
    @Override
    public List<Link> getAllLinks() {
        return linkRepository.findAll();
    }

    @Override
    public Link getLink(String usage) {
        if(linkRepository.findByUsage(usage).isPresent())
            return linkRepository.findByUsage(usage).get();

        throw new LinkNotFoundException("Given usage does not match any link in the data base");
    }
}
