package gr.ieee.cs.uowm.myuowm_admin_panel.service;

import gr.ieee.cs.uowm.myuowm_admin_panel.model.Club;
import gr.ieee.cs.uowm.myuowm_admin_panel.model.Personal;

import java.util.List;

public interface WebAppService {
    public String getTimeTable();
    public void saveTimeTable(String url);
    public String getDinnerPlan();
    public List<Personal> getAllPersonal();
    public Personal getPersonal(String id);
    public List<Club> getAllClubs();
    public Club getClub(String id);
}
