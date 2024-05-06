package gr.ieee.cs.uowm.myuowm_admin_panel.controller;


import gr.ieee.cs.uowm.myuowm_admin_panel.model.*;
import gr.ieee.cs.uowm.myuowm_admin_panel.service.AdminPanelService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminPanelController {

    private final AdminPanelService adminPanelService;

    public AdminPanelController(AdminPanelService adminPanelService) {

        this.adminPanelService = adminPanelService;
    }


    @PutMapping("/links")
    @PreAuthorize("hasAuthority('admin:update')")
    public String updateLinks(@RequestBody List<Link> links) {
        return adminPanelService.updateLinks(links);
    }

    @PutMapping("/lesxi")
    @PreAuthorize("hasAuthority('admin:update')")
    public String updateDinnerPlan(@RequestBody DinnerPlan dinnerPlan) {
        return adminPanelService.saveDinnerPlan(dinnerPlan);
    }

    @PostMapping("/personnel")
    @PreAuthorize("hasAuthority('admin:create')")
    public String addPersonnel(@RequestBody Personnel personnel) {
        return adminPanelService.savePersonnel(personnel);
    }

    @PutMapping("/personnel")
    @PreAuthorize("hasAuthority('admin:update')")
    public String updatePersonnel(@RequestBody Personnel personnel) {
        return adminPanelService.updatePersonnel(personnel);
    }

    @DeleteMapping("/personnel/{personnelId}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public String deletePersonnel(@PathVariable("personnelId") String personnelId) {
        return adminPanelService.deletePersonnel(personnelId);
    }

    @PostMapping("/clubs")
    @PreAuthorize("hasAuthority('admin:create')")
    public String addClub(@RequestBody Club club) {
        return adminPanelService.saveClub(club);
    }

    @PutMapping("/club")
    @PreAuthorize("hasAuthority('admin:update')")
    public String updateClub(@RequestBody Club club) {
        return adminPanelService.updateClub(club);
    }

    @DeleteMapping("/club/{clubId}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public String deleteClub(@PathVariable("{clubId") String clubId) {
        return adminPanelService.deleteClub(clubId);
    }
}
