package gr.ieee.cs.uowm.myuowm_admin_panel.controller;

import gr.ieee.cs.uowm.myuowm_admin_panel.model.Club;
import gr.ieee.cs.uowm.myuowm_admin_panel.model.DinnerPlan;
import gr.ieee.cs.uowm.myuowm_admin_panel.model.Personal;
import gr.ieee.cs.uowm.myuowm_admin_panel.model.TimeTable;
import gr.ieee.cs.uowm.myuowm_admin_panel.service.WebAppService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/personal")
    public List<Personal> getAllPersonalInfo() {
        return webAppService.getAllPersonal();
    }

    @GetMapping("/personal/{personalId}")
    public Personal getPersonal(@PathVariable("personalId") String personalID) {
        return webAppService.getPersonal(personalID);
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
