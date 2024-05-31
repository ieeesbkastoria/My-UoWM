package main.service.impl;

import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.*;
import main.datasource.repository.ClubRepository;
import main.datasource.repository.LinkRepository;
import main.datasource.repository.MealPlanRepository;
import main.datasource.repository.PersonnelRepository;
import main.exception.club.ClubNotFoundException;
import main.exception.link.LinkNotFoundException;
import main.exception.link.LinkReturnDefaultException;
import main.exception.mealplan.MealPlanReturnDefaultException;
import main.exception.personnel.PersonnelNotFoundException;
import main.service.WebAppService;
import lombok.AllArgsConstructor;
import main.datasource.model.Club;
import main.datasource.model.Link;
import main.datasource.model.MealPlan;
import main.datasource.model.Personnel;
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

    @Override
    public List<Link> getAllLinks() {
        if (linkRepository.findAll().isEmpty())
            return linkRepository.findAll();

        // if there is no link in the databases return a default set of links
        throw new LinkReturnDefaultException("A default set of links is returned");
    }

    @Override
    public Link getLink(String usage) {
        if(linkRepository.findByUsage(usage).isPresent())
            return linkRepository.findByUsage(usage).get();

        throw new LinkNotFoundException("Given usage does not match any link in the data base");
    }
}
