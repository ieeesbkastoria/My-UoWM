package gr.ieee.cs.uowm.myuowm_admin_panel.controller;

import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.Club;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.Link;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.MealPlan;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.Personnel;
import gr.ieee.cs.uowm.myuowm_admin_panel.service.WebAppService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/myuowm")
@AllArgsConstructor
@CrossOrigin
public class WebAppController {

    private final WebAppService webAppService;

    @GetMapping("/lesxi")
    public List<MealPlan> getLesxi() {
        return webAppService.getMealPlan();
    }

    @GetMapping("/links")
    public List<Link> getAllLinks() {
        return webAppService.getAllLinks();
    }

    @GetMapping("/links/{usage}")
    public Link getSpecificLink(@PathVariable("usage")String usage) {
        return webAppService.getLink(usage);
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
