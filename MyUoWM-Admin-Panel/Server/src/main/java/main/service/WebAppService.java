package main.service;

import main.datasource.model.Club;
import main.datasource.model.Link;
import main.datasource.model.MealPlan;
import main.datasource.model.Personnel;

import java.util.List;

public interface WebAppService {
    public List<MealPlan> getMealPlan();
    public List<Personnel> getAllPersonnel();
    public Personnel getPersonnel(String id);
    public List<Club> getAllClubs();
    public Club getClub(String id);
    public List<Link> getAllLinks();
    public Link getLink(String url);

}
