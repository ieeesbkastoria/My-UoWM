package gr.ieee.cs.uowm.myuowm_admin_panel.service;

import gr.ieee.cs.uowm.myuowm_admin_panel.model.Club;
import gr.ieee.cs.uowm.myuowm_admin_panel.model.DinnerPlan;
import gr.ieee.cs.uowm.myuowm_admin_panel.model.Link;
import gr.ieee.cs.uowm.myuowm_admin_panel.model.Personnel;

import java.util.List;

public interface AdminPanelService {
    public String saveDinnerPlan(DinnerPlan dinnerPlane);
    public String savePersonnel(Personnel personnel);
    public String updatePersonnel(Personnel personnel);
    public String deletePersonnel(String personalId);
    public String saveClub(Club club);
    public String updateClub(Club club);
    public String deleteClub(String clubId);
    public String updateLinks(List<Link> links);
}
