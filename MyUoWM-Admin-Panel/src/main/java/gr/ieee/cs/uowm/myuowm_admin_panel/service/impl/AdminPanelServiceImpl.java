package gr.ieee.cs.uowm.myuowm_admin_panel.service.impl;

import org.springframework.stereotype.Service;

import gr.ieee.cs.uowm.myuowm_admin_panel.model.Club;
import gr.ieee.cs.uowm.myuowm_admin_panel.model.DinnerPlan;
import gr.ieee.cs.uowm.myuowm_admin_panel.model.Personal;
import gr.ieee.cs.uowm.myuowm_admin_panel.model.TimeTable;
import gr.ieee.cs.uowm.myuowm_admin_panel.repository.MyUoWmAdminPanelClubRepository;
import gr.ieee.cs.uowm.myuowm_admin_panel.repository.MyUoWmAdminPanelDinnerPlanRepository;
import gr.ieee.cs.uowm.myuowm_admin_panel.repository.MyUoWmAdminPanelPersonalRepository;
import gr.ieee.cs.uowm.myuowm_admin_panel.repository.MyUoWmAdminPanelTimeTableRepository;
import gr.ieee.cs.uowm.myuowm_admin_panel.service.AdminPanelService;

@Service
public class AdminPanelServiceImpl implements AdminPanelService {

    MyUoWmAdminPanelTimeTableRepository timeTableRepository;
    MyUoWmAdminPanelDinnerPlanRepository dinnerPlanRepository;
    MyUoWmAdminPanelPersonalRepository personalRepository;
    MyUoWmAdminPanelClubRepository clubRepository;
    
    @Override
    public String saveTimeTable(String url) {
        try {
            TimeTable timeTable = new TimeTable();
            timeTable.setUrl(url);
            timeTableRepository.save(timeTable);
            return "TimeTable saved successfully";
        } catch (Exception e) {
            //TODO throw error
            return null;
        }
    }

    @Override
    public String saveDinnerPlan(String url) {
        try {
            DinnerPlan dinnerPlan = new DinnerPlan();
            dinnerPlan.setUrl(url);
            dinnerPlanRepository.save(dinnerPlan);
            return "DinnerPlan saved successfully";
        } catch (Exception e) {
            //TODO throw error
            return null;
        }
    }

    @Override
    public String savePersonal(String personalId, String department, String name, String phone, String office, String officeHours, String email) {
        try {
            Personal personal = new Personal(
                personalId,
                department,
                name,
                phone,
                office,
                officeHours,
                email
            );
            personalRepository.save(personal);
            return "Personal saved successfully";
        } catch (Exception e) {
            //TODO throw error
            return null;
        }
    }

    @Override
    public String updatePersonal(String personalId, String department, String name, String phone, String office, String officeHours, String email) {
        try {
            Personal personal = personalRepository.findById(personalId).get();
            personal.setDepartment(department);
            personal.setName(name);
            personal.setPhone(phone);
            personal.setOffice(office);
            personal.setOfficeHours(officeHours);
            personal.setEmail(email);
            personalRepository.save(personal);
            return "Personal updated successfully";
        } catch (Exception e) {
            //TODO throw error
            return null;
        }
    }

    @Override
    public String deletePersonal(String personalId) {
        try {
            personalRepository.deleteById(personalId);
            return "Personal deleted successfully";
        } catch (Exception e) {
            //TODO throw error
            return null;
        }
    }

    @Override
    public String saveClub(String clubId, String clubName, String link) {
        try {
            Club club = new Club(
                clubName,
                link
            );
            clubRepository.save(club);
            return "Club saved successfully";
        } catch (Exception e) {
            //TODO throw error
            return null;
        }
    }

    @Override
    public String updateClub(String clubId, String clubName, String link) {
        try {
            Club club = clubRepository.findById(clubId).get();
            club.setClubName(clubName);
            club.setLink(link);
            clubRepository.save(club);
            return "Club updated successfully";
        } catch (Exception e) {
            //TODO throw error
            return null;
        }
    }

    @Override
    public String deleteClub(String clubId) {
        try {
            clubRepository.deleteById(clubId);
            return "Club deleted successfully";
        } catch (Exception e) {
            //TODO throw error
            return null;
        }
    }
}
