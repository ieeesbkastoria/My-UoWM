package gr.ieee.cs.uowm.myuowm_admin_panel.service;

public interface AdminPanelService {
    public String saveTimeTable(String url);
    public String saveDinnerPlan(String url);
    public String savePersonal(String personalId, String department, String name, String phone, String office, String officeHours, String email);
    public String updatePersonal(String personalId, String department, String name, String phone, String office, String officeHours, String email);
    public String deletePersonal(String personalId);
    public String saveClub(String clubId, String name, String link);
    public String updateClub(String clubId, String name, String link);
    public String deleteClub(String clubId);
}
