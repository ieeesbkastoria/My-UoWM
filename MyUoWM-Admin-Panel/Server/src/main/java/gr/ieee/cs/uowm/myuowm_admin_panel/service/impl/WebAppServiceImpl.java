package gr.ieee.cs.uowm.myuowm_admin_panel.service.impl;

import gr.ieee.cs.uowm.myuowm_admin_panel.model.*;
import gr.ieee.cs.uowm.myuowm_admin_panel.repository.*;
import gr.ieee.cs.uowm.myuowm_admin_panel.service.WebAppService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WebAppServiceImpl implements WebAppService {

    MyUoWmAdminPanelClubRepository clubRepository;
    MyUoWmAdminPanelDinnerPlanRepository dinnerPlanRepository;
    MyUoWmAdminPanelPersonnelRepository personnelRepository;
    MyUoWmAdminPanelLinkRepository linkRepository;

    public WebAppServiceImpl(MyUoWmAdminPanelLinkRepository linkRepository, MyUoWmAdminPanelClubRepository clubRepository, MyUoWmAdminPanelDinnerPlanRepository dinnerPlanRepository, MyUoWmAdminPanelPersonnelRepository personnelRepository) {
        this.clubRepository = clubRepository;
        this.dinnerPlanRepository = dinnerPlanRepository;
        this.personnelRepository = personnelRepository;
        this.linkRepository = linkRepository;
    }

    @Override
    public String getDinnerPlan() {
        Optional<DinnerPlan> optionalDinnerPlan = dinnerPlanRepository.findTopByOrderByIdDesc();
        if(optionalDinnerPlan.isPresent()) {
            return optionalDinnerPlan.get().getUrl();
        } else {
            //TODO throw error
            return "Couldnt get DinnerPlan";
        }


    }

    @Override
    public List<Personnel> getAllPersonnel() {
        return personnelRepository.findAll();
    }

    @Override
    public Personnel getPersonnel(String id) {
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

    @Override
    public List<Link> getAllLinks() {
        return linkRepository.findAll();
    }

    @Override
    public Link getSpecificLink(String usage) {
        if(linkRepository.findByUsage(usage).isEmpty())
            //change system.out to custom Exception
            System.out.println("Error");
        return linkRepository.findByUsage(usage).get();
    }
}
