package gr.ieee.cs.uowm.myuowm_admin_panel.controller;


import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.Club;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.Link;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.MealPlan;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.Personnel;
import gr.ieee.cs.uowm.myuowm_admin_panel.response.ResponseHandler;
import gr.ieee.cs.uowm.myuowm_admin_panel.service.AdminPanelService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@PreAuthorize("hasRole('ADMIN')")
@AllArgsConstructor
@CrossOrigin
public class AdminPanelController {

    private final AdminPanelService adminPanelService;


    @PutMapping("/links")
    @PreAuthorize("hasAuthority('admin:update')")
    public ResponseEntity<Object> updateLinks(@RequestBody List<Link> links) {
        var response = adminPanelService.updateLinks(links);

        return ResponseHandler.responseBuilder("The links have been updated successfully", HttpStatus.OK, response);
    }

    @PutMapping("/lesxi")
    @PreAuthorize("hasAuthority('admin:update')")
    public ResponseEntity<Object> updateDinnerPlan(@RequestBody List<MealPlan> mealPlan) {
        var response = adminPanelService.saveMealPlan(mealPlan);

        return ResponseHandler.responseBuilder("The meal plan has been successfully updated", HttpStatus.OK, response);
    }

    @PostMapping("/personnel")
    @PreAuthorize("hasAuthority('admin:create')")
    public ResponseEntity<Object> addPersonnel(@RequestBody Personnel personnel) {
        var response = adminPanelService.savePersonnel(personnel);

        return ResponseHandler.responseBuilder("The provided employee has been added successfully", HttpStatus.OK, response);
    }

    @PutMapping("/personnel")
    @PreAuthorize("hasAuthority('admin:update')")
    public ResponseEntity<Object> updatePersonnel(@RequestBody List<Personnel> personnel) { //TODO change to list of personnel
        var response = adminPanelService.updatePersonnel(personnel);

        return ResponseHandler.responseBuilder("The provided personnel list has been updated successfully", HttpStatus.OK, response);
    }

    @DeleteMapping("/personnel/{personnelId}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public ResponseEntity<Object> deletePersonnel(@PathVariable("personnelId") String personnelId) {
        var response = adminPanelService.deletePersonnel(personnelId);

        return ResponseHandler.responseBuilder("The personnel with the provided id has been deleted successfully", HttpStatus.OK, response);
    }

    @PostMapping("/clubs")
    @PreAuthorize("hasAuthority('admin:create')")
    public ResponseEntity<Object> addClub(@RequestBody Club club) {
        var response = adminPanelService.saveClub(club);

        return ResponseHandler.responseBuilder("The the provided club has been added successfully", HttpStatus.OK, response);
    }

    @PutMapping("/club")
    @PreAuthorize("hasAuthority('admin:update')")
    public ResponseEntity<Object> updateClub(@RequestBody List<Club> clubs) { //TODO change to list of clubs
        var response = adminPanelService.updateClub(clubs);

        return ResponseHandler.responseBuilder("The the provided list of clubs has been updated successfully", HttpStatus.OK, response);
    }

    @DeleteMapping("/club/{clubId}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public ResponseEntity<Object> deleteClub(@PathVariable("{clubId") String clubId) {
        var response = adminPanelService.deleteClub(clubId);

        return ResponseHandler.responseBuilder("The club with the provided id has been deleted successfully", HttpStatus.OK, response);
    }
}
