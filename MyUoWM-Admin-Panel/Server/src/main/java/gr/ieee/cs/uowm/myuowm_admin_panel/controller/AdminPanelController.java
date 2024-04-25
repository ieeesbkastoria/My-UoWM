package gr.ieee.cs.uowm.myuowm_admin_panel.controller;


import gr.ieee.cs.uowm.myuowm_admin_panel.model.*;
import gr.ieee.cs.uowm.myuowm_admin_panel.service.AdminPanelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminPanelController {

    private final AdminPanelService adminPanelService;

    public AdminPanelController(AdminPanelService adminPanelService) {
        this.adminPanelService = adminPanelService;
    }

    @PutMapping("/links")
    public String updateLinks(@RequestBody List<Link> links) {
        return adminPanelService.updateLinks(links);
    }

    @PutMapping("/lesxi")
    public String updateDinnerPlan(@RequestBody DinnerPlan dinnerPlan) {
        return adminPanelService.saveDinnerPlan(dinnerPlan);
    }

    @PostMapping("/personnel")
    public String addPersonnel(@RequestBody Personnel personnel) {
        return adminPanelService.savePersonnel(personnel);
    }

    @PutMapping("/personnel")
    public String updatePersonnel(@RequestBody Personnel personnel) {
        return adminPanelService.updatePersonnel(personnel);
    }

    @DeleteMapping("personnel/{personnelId}")
    public String deletePersonnel(@PathVariable("personnelId") String personnelId) {
        return adminPanelService.deletePersonnel(personnelId);
    }

    @PostMapping("/clubs")
    public String addClub(@RequestBody Club club) {
        return adminPanelService.saveClub(club);
    }

    @PutMapping("/club")
    public String updateClub(@RequestBody Club club) {
        return adminPanelService.updateClub(club);
    }

    @DeleteMapping("/club/{clubId}")
    public String deleteClub(@PathVariable("{clubId") String clubId) {
        return adminPanelService.deleteClub(clubId);
    }
}
