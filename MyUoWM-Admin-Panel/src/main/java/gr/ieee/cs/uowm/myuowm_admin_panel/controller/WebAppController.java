package gr.ieee.cs.uowm.myuowm_admin_panel.controller;

import gr.ieee.cs.uowm.myuowm_admin_panel.model.Club;
import gr.ieee.cs.uowm.myuowm_admin_panel.model.DinnerPlan;
import gr.ieee.cs.uowm.myuowm_admin_panel.model.Personal;
import gr.ieee.cs.uowm.myuowm_admin_panel.model.TimeTable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import java.sql.Time;
import java.util.List;

@RestController
@RequestMapping("/myuowm")
public class WebAppController {


    //Serve Static Files
    @GetMapping("/timetable")
    public TimeTable getTimeTable() {
        //TODO
        return new TimeTable("/");
    }

    @GetMapping("/lesxi")
    public DinnerPlan getMealPlan() {
        //TODO
        return new DinnerPlan("/");
    }

    @GetMapping("/personal")
    public List<Personal> getAllPersonalInfo() {
        //TODO
        return null;
    }

    @GetMapping("/personl{personalId}")
    public Personal getPersonal(@PathVariable("personalId") String personalID) {
        //TODO
        return null;
    }

    @GetMapping("/clubs")
    public List<Club> getAllClubInfo() {
        //TODO
        return null;
    }

    @GetMapping("/clubs{clubId}")
    public Club getClubDetail(@PathVariable("clubId") String clubID) {
        //TODO
        return null;
    }


}
