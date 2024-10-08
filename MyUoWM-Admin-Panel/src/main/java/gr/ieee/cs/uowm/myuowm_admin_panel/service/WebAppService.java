package gr.ieee.cs.uowm.myuowm_admin_panel.service;

import gr.ieee.cs.uowm.myuowm_admin_panel.model.Club;
import gr.ieee.cs.uowm.myuowm_admin_panel.model.Personnel;

import java.util.List;

public interface WebAppService {
    public String getTimeTable();
    public String getDinnerPlan();
    public List<Personnel> getAllPersonnel();
    public Personnel getPersonnel(String id);
    public List<Club> getAllClubs();
    public Club getClub(String id);
}
