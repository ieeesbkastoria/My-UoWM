package gr.ieee.cs.uowm.myuowm_admin_panel.service.impl;

import org.springframework.stereotype.Service;

import gr.ieee.cs.uowm.myuowm_admin_panel.model.Club;
import gr.ieee.cs.uowm.myuowm_admin_panel.model.DinnerPlan;
import gr.ieee.cs.uowm.myuowm_admin_panel.model.Personnel;
import gr.ieee.cs.uowm.myuowm_admin_panel.model.TimeTable;
import gr.ieee.cs.uowm.myuowm_admin_panel.repository.MyUoWmAdminPanelClubRepository;
import gr.ieee.cs.uowm.myuowm_admin_panel.repository.MyUoWmAdminPanelDinnerPlanRepository;
import gr.ieee.cs.uowm.myuowm_admin_panel.repository.MyUoWmAdminPanelPersonnelRepository;
import gr.ieee.cs.uowm.myuowm_admin_panel.repository.MyUoWmAdminPanelTimeTableRepository;
import gr.ieee.cs.uowm.myuowm_admin_panel.service.AdminPanelService;

@Service
public class AdminPanelServiceImpl implements AdminPanelService {

    MyUoWmAdminPanelTimeTableRepository timeTableRepository;
    MyUoWmAdminPanelDinnerPlanRepository dinnerPlanRepository;
    MyUoWmAdminPanelPersonnelRepository personnelRepository;
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
            Personnel personnel = new Personnel(
                personalId,
                department,
                name,
                phone,
                office,
                officeHours,
                email
            );
            personnelRepository.save(personnel);
            return "Personal saved successfully";
        } catch (Exception e) {
            //TODO throw error
            return null;
        }
    }

    @Override
    public String updatePersonal(String personalId, String department, String name, String phone, String office, String officeHours, String email) {
        try {
            Personnel personnel = personnelRepository.findById(personalId).get();
            personnel.setDepartment(department);
            personnel.setName(name);
            personnel.setPhone(phone);
            personnel.setOffice(office);
            personnel.setOfficeHours(officeHours);
            personnel.setEmail(email);
            personnelRepository.save(personnel);
            return "Personal updated successfully";
        } catch (Exception e) {
            //TODO throw error
            return null;
        }
    }

    @Override
    public String deletePersonal(String personalId) {
        try {
            personnelRepository.deleteById(personalId);
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
