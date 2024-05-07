package gr.ieee.cs.uowm.myuowm_admin_panel.service;

import gr.ieee.cs.uowm.myuowm_admin_panel.model.*;

import java.util.ArrayList;
import java.util.List;

public interface AdminPanelService {
    public String saveMealPlan(ArrayList<MealPlan> mealPlan);
    public String savePersonnel(Personnel personnel);
    public String updatePersonnel(Personnel personnel);
    public String deletePersonnel(String personalId);
    public String saveClub(Club club);
    public String updateClub(Club club);
    public String deleteClub(String clubId);
    public String updateLinks(List<Link> links);
}
