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

    public AdminPanelServiceImpl(MyUoWmAdminPanelTimeTableRepository timeTableRepository, MyUoWmAdminPanelDinnerPlanRepository dinnerPlanRepository, MyUoWmAdminPanelPersonnelRepository personnelRepository, MyUoWmAdminPanelClubRepository clubRepository) {
        this.timeTableRepository = timeTableRepository;
        this.dinnerPlanRepository = dinnerPlanRepository;
        this.personnelRepository = personnelRepository;
        this.clubRepository = clubRepository;
    }

    @Override
    public String saveTimeTable(TimeTable timeTable) {
        try {
            timeTable.setId(1L);
            timeTableRepository.save(timeTable);
            return "TimeTable saved successfully";
        } catch (Exception e) {
            //TODO throw error
            return "Couldnt save TimeTable";
        }
    }

    @Override
    public String saveDinnerPlan(DinnerPlan dinnerPlan) {
        try {
            dinnerPlan.setId(1L);
            dinnerPlanRepository.save(dinnerPlan);
            return "DinnerPlan saved successfully";
        } catch (Exception e) {
            //TODO throw error
            return "Couldnt save DinnerPlan";
        }
    }

    @Override
    public String savePersonnel(Personnel personnel) {
        try {
            personnelRepository.save(personnel);
            return "Personnel saved successfully";
        } catch (Exception e) {
            //TODO throw error
            return "Couldnt save personnel";
        }
    }

    @Override
    public String updatePersonnel(Personnel personnel) {
        try {
            if(personnelRepository.findById(personnel.getPersonnel_id()).isEmpty())
                //TODO throw proper error message1
                return "Couldnt find personnel";
            personnelRepository.save(personnel);
            return "Personal updated successfully";
        } catch (Exception e) {
            //TODO throw error
            return null;
        }
    }

    @Override
    public String deletePersonnel(String personnelId) {
        try {
            if(personnelRepository.findById(personnelId).isEmpty())
                // TODO throw proper error message
                return "Couldnt find personnel";
            personnelRepository.deleteById(personnelId);
            return "Personal deleted successfully";
        } catch (Exception e) {
            //TODO throw error
            return null;
        }
    }

    @Override
    public String saveClub(Club club) {
        try {
            clubRepository.save(club);
            return "Club saved successfully";
        } catch (Exception e) {
            //TODO throw error
            return null;
        }
    }

    @Override
    public String updateClub(Club club) {
        try {
            if(clubRepository.findById(club.getClub_id()).isEmpty())
                //TODO throw proper error message
                return "Club not found";
            clubRepository.save(club);
            return "Club updated successfully";
        } catch (Exception e) {
            //TODO throw error
            return "Unexpected error";
        }
    }

    @Override
    public String deleteClub(String clubId) {
        try {
            if(clubRepository.findById(clubId).isEmpty())
                // TODO throw proper error message
                return "Club not found";
            clubRepository.deleteById(clubId);
            return "Club deleted successfully";
        } catch (Exception e) {
            //TODO throw error
            return null;
        }
    }
}
