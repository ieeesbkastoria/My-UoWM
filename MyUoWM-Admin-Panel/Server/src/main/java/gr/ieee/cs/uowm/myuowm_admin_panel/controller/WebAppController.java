package gr.ieee.cs.uowm.myuowm_admin_panel.controller;

import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.Club;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.Link;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.MealPlan;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.Personnel;
import gr.ieee.cs.uowm.myuowm_admin_panel.service.WebAppService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/myuowm")
@AllArgsConstructor
@CrossOrigin
public class WebAppController {

    private final WebAppService webAppService;

    @GetMapping("/lesxi")
    @ResponseStatus(HttpStatus.OK)
    public List<MealPlan> getLesxi() {
        return webAppService.getMealPlan();
    }

    @GetMapping("/links")
    @ResponseStatus(HttpStatus.OK)
    public List<Link> getAllLinks() {
        return webAppService.getAllLinks();
    }

    @GetMapping("/links/{usage}")
    @ResponseStatus(HttpStatus.OK)
    public Link getSpecificLink(@PathVariable("usage")String usage) {
        return webAppService.getLink(usage);
    }

    @GetMapping("/personnel")
    @ResponseStatus(HttpStatus.OK)
    public List<Personnel> getAllPersonnelInfo() {
        return webAppService.getAllPersonnel();
    }

    @GetMapping("/personnel/{personalId}")
    @ResponseStatus(HttpStatus.OK)
    public Personnel getPersonnel(@PathVariable("personalId") String personalID) {
        return webAppService.getPersonnel(personalID);
    }

    @GetMapping("/clubs")
    @ResponseStatus(HttpStatus.OK)
    public List<Club> getAllClubInfo() {
        return webAppService.getAllClubs();
    }

    @GetMapping("/clubs/{clubId}")
    @ResponseStatus(HttpStatus.OK)
    public Club getClubDetail(@PathVariable("clubId") String clubID) {
        return webAppService.getClub(clubID);
    }


}
