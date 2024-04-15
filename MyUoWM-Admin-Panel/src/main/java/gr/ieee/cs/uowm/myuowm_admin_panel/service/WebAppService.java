package gr.ieee.cs.uowm.myuowm_admin_panel.service;

import gr.ieee.cs.uowm.myuowm_admin_panel.model.Club;
import gr.ieee.cs.uowm.myuowm_admin_panel.model.DinnerPlan;
import gr.ieee.cs.uowm.myuowm_admin_panel.model.Personal;
import gr.ieee.cs.uowm.myuowm_admin_panel.model.TimeTable;

import java.util.List;

public interface WebAppService {
    public TimeTable getTimeTable(String link);
    public DinnerPlan getDinnerPlan(String link);
    public List<Personal> getAllPersonal();
    public Personal getPersonal(String id);
    public List<Club> getAllClubs();
    public Club getClub(String id);
}