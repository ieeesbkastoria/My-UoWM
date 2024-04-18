package gr.ieee.cs.uowm.myuowm_admin_panel.controller;

import gr.ieee.cs.uowm.myuowm_admin_panel.model.Club;
import gr.ieee.cs.uowm.myuowm_admin_panel.model.Personnel;
import gr.ieee.cs.uowm.myuowm_admin_panel.service.WebAppService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/myuowm")
public class WebAppController {

    private final WebAppService webAppService;

    public WebAppController(WebAppService webAppService) {
        this.webAppService = webAppService;
    }

    @GetMapping("/timetable")
    public String getTimeTable() {
        return webAppService.getTimeTable();
    }

    @GetMapping("/lesxi")
    public String getMealPlan() {
        return webAppService.getDinnerPlan();
    }

    @GetMapping("/personnel")
    public List<Personnel> getAllPersonnelInfo() {
        return webAppService.getAllPersonnel();
    }

    @GetMapping("/personnel/{personalId}")
    public Personnel getPersonnel(@PathVariable("personalId") String personalID) {
        return webAppService.getPersonnel(personalID);
    }

    @GetMapping("/clubs")
    public List<Club> getAllClubInfo() {
        return webAppService.getAllClubs();
    }

    @GetMapping("/clubs/{clubId}")
    public Club getClubDetail(@PathVariable("clubId") String clubID) {
        return webAppService.getClub(clubID);
    }


}
