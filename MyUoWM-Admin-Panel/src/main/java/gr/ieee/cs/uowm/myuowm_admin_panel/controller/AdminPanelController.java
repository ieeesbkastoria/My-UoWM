package gr.ieee.cs.uowm.myuowm_admin_panel.controller;


import gr.ieee.cs.uowm.myuowm_admin_panel.model.Club;
import gr.ieee.cs.uowm.myuowm_admin_panel.model.DinnerPlan;
import gr.ieee.cs.uowm.myuowm_admin_panel.model.Personal;
import gr.ieee.cs.uowm.myuowm_admin_panel.model.TimeTable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminPanelController {

    @PutMapping("/timetable")
    public String updateTimeTable(@RequestBody TimeTable timeTable) {
        return "Time table updated successfully";
    }

    @PutMapping("/lesxi")
    public String updateDinnerPlan(@RequestBody DinnerPlan dinnerPlan) {
        return "Dinner table updated successfully";
    }

    @PostMapping("/personal")
    public String addPersonal(@RequestBody Personal personal) {
        return "Personal added successfully";
    }

    @PutMapping("/personal/{personalId}")
    public String updatePersonal(@RequestBody Personal personal, @PathVariable("personalId") String personalId) {
        return "Personal updated successfully";
    }

    @DeleteMapping("personal/{personalId}")
    public String deletePersonal(@RequestBody Personal personal, @PathVariable("personalId") String personalId) {
        return "Personal deleted successfully";
    }

    @PostMapping("/clubs")
    public String addClub(@RequestBody Club club) {
        return "Club added";
    }

    @PutMapping("/club/{clubId}")
    public String updateClub(@RequestBody Club club, @PathVariable("clubId") String clubId) {
        return "Club updated";
    }

    @DeleteMapping("/club/{clubId}")
    public String deleteClub(@RequestBody Club club, @PathVariable("{clubId") String clubId) {
        return "Club deleted successfully";
    }
}
