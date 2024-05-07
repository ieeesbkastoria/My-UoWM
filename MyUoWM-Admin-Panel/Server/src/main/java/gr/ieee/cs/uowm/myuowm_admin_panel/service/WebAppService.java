package gr.ieee.cs.uowm.myuowm_admin_panel.service;

import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.Club;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.Link;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.MealPlan;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.Personnel;

import java.util.List;

public interface WebAppService {
    public List<MealPlan> getMealPlan();
    public List<Personnel> getAllPersonnel();
    public Personnel getPersonnel(String id);
    public List<Club> getAllClubs();
    public Club getClub(String id);
    public List<Link> getAllLinks();
    public Link getSpecificLink(String url);

}
