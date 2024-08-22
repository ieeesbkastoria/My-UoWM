package gr.ieee.cs.uowm.myuowm_admin_panel.service;

import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.Club;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.Link;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.MealPlan;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.Personnel;

import java.util.List;

public interface AdminPanelService {
    public List<MealPlan> saveMealPlan(List<MealPlan> mealPlan);
    public Personnel savePersonnel(Personnel personnel);
    public List<Personnel> updatePersonnel(List<Personnel> personnel);
    public String deletePersonnel(String personalId);
    public Club saveClub(Club club);
    public List<Club> updateClub(List<Club> clubs);
    public String deleteClub(String clubId);
    public List<Link> updateLinks(List<Link> links);
}
