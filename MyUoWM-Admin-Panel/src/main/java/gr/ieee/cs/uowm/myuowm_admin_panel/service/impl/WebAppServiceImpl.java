package gr.ieee.cs.uowm.myuowm_admin_panel.service.impl;

import gr.ieee.cs.uowm.myuowm_admin_panel.model.Club;
import gr.ieee.cs.uowm.myuowm_admin_panel.model.DinnerPlan;
import gr.ieee.cs.uowm.myuowm_admin_panel.model.Personnel;
import gr.ieee.cs.uowm.myuowm_admin_panel.model.TimeTable;
import gr.ieee.cs.uowm.myuowm_admin_panel.repository.MyUoWmAdminPanelClubRepository;
import gr.ieee.cs.uowm.myuowm_admin_panel.repository.MyUoWmAdminPanelDinnerPlanRepository;
import gr.ieee.cs.uowm.myuowm_admin_panel.repository.MyUoWmAdminPanelPersonnelRepository;
import gr.ieee.cs.uowm.myuowm_admin_panel.repository.MyUoWmAdminPanelTimeTableRepository;
import gr.ieee.cs.uowm.myuowm_admin_panel.service.WebAppService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WebAppServiceImpl implements WebAppService {

    MyUoWmAdminPanelClubRepository clubRepository;
    MyUoWmAdminPanelDinnerPlanRepository dinnerPlanRepository;
    MyUoWmAdminPanelPersonnelRepository personnelRepository;
    MyUoWmAdminPanelTimeTableRepository timeTableRepository;

    @Override
    public String getTimeTable() {
        Optional<TimeTable> optionalTimeTable = timeTableRepository.findTopByOrderByIdDesc();
        if(optionalTimeTable.isPresent()) {
            return optionalTimeTable.get().getUrl();
        } else {
            //TODO throw error
            return null;
        }
    }

    @Override
    public String getDinnerPlan() {
        Optional<DinnerPlan> optionalDinnerPlan = dinnerPlanRepository.findTopByOrderByIdDesc();
        if(optionalDinnerPlan.isPresent()) {
            return optionalDinnerPlan.get().getUrl();
        } else {
            //TODO throw error
            return null;
        }
    }

    @Override
    public List<Personnel> getAllPersonal() {
        return personnelRepository.findAll();
    }

    @Override
    public Personnel getPersonal(String id) {
        if(personnelRepository.findById(id).isEmpty())
            //change system.out to custom Exception
            System.out.println("Error");
        return personnelRepository.findById(id).get();
    }

    @Override
    public List<Club> getAllClubs() {
        return clubRepository.findAll();
    }

    @Override
    public Club getClub(String id) {
        if(clubRepository.findById(id).isEmpty())
            //change system.out to custom Exception
            System.out.println("Error");
        return clubRepository.findById(id).get();
    }
}
