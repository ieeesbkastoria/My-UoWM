package gr.ieee.cs.uowm.myuowm_admin_panel.controller;


import gr.ieee.cs.uowm.myuowm_admin_panel.model.Club;
import gr.ieee.cs.uowm.myuowm_admin_panel.model.DinnerPlan;
import gr.ieee.cs.uowm.myuowm_admin_panel.model.Personnel;
import gr.ieee.cs.uowm.myuowm_admin_panel.model.TimeTable;
import gr.ieee.cs.uowm.myuowm_admin_panel.service.AdminPanelService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminPanelController {

    private final AdminPanelService adminPanelService;

    public AdminPanelController(AdminPanelService adminPanelService) {
        this.adminPanelService = adminPanelService;
    }

    @PutMapping("/timetable")
    public String updateTimeTable(@RequestBody TimeTable timeTable) {
        return adminPanelService.saveTimeTable(timeTable);
    }

    @PutMapping("/lesxi")
    public String updateDinnerPlan(@RequestBody DinnerPlan dinnerPlan) {
        return adminPanelService.saveDinnerPlan(dinnerPlan);
    }

    @PostMapping("/personal")
    public String addPersonnel(@RequestBody Personnel personnel) {
        return adminPanelService.savePersonnel(personnel);
    }

    @PutMapping("/personal")
    public String updatePersonnel(@RequestBody Personnel personnel) {
        return adminPanelService.updatePersonnel(personnel);
    }

    @DeleteMapping("personal/{personalId}")
    public String deletePersonnel(@PathVariable("personalId") String personalId) {
        return adminPanelService.deletePersonnel(personalId);
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
