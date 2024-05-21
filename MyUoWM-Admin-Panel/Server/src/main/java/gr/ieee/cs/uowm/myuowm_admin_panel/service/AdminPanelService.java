package gr.ieee.cs.uowm.myuowm_admin_panel.service;

import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.Club;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.Link;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.MealPlan;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.Personnel;

import java.util.List;

public interface AdminPanelService {
    public List<MealPlan> saveMealPlan(List<MealPlan> mealPlan);
    public Personnel savePersonnel(Personnel personnel);
    public Personnel updatePersonnel(Personnel personnel);
    public String deletePersonnel(String personalId);
    public Club saveClub(Club club);
    public Club updateClub(Club club);
    public String deleteClub(String clubId);
    public List<Link> updateLinks(List<Link> links);
}
