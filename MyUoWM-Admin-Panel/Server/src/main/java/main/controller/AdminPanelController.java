package main.controller;


import main.datasource.model.Club;
import main.datasource.model.Link;
import main.datasource.model.MealPlan;
import main.datasource.model.Personnel;
import main.response.ResponseHandler;
import main.service.AdminPanelService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO add comments to each method(error handling information)
@RestController
@RequestMapping("/api/admin")
@AllArgsConstructor
@CrossOrigin
public class AdminPanelController {

    private final AdminPanelService adminPanelService;


    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/links")
    public ResponseEntity<Object> updateLinks(@RequestBody List<Link> links) {
        var response = adminPanelService.updateLinks(links);

        return ResponseHandler.responseBuilder("The links have been updated successfully", HttpStatus.OK, response);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/lesxi")
    public ResponseEntity<Object> updateDinnerPlan(@RequestBody List<MealPlan> mealPlan) {
        var response = adminPanelService.saveMealPlan(mealPlan);

        return ResponseHandler.responseBuilder("The meal plan has been successfully updated", HttpStatus.OK, response);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/personnel")
    public ResponseEntity<Object> addPersonnel(@RequestBody Personnel personnel) {
        var response = adminPanelService.savePersonnel(personnel);

        return ResponseHandler.responseBuilder("The provided employee has been added successfully", HttpStatus.OK, response);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PatchMapping("/personnel")
    public ResponseEntity<Object> updatePersonnel(@RequestBody List<Personnel> personnel) { //TODO change to list of personnel
        var response = adminPanelService.updatePersonnel(personnel);

        return ResponseHandler.responseBuilder("The provided personnel list has been updated successfully", HttpStatus.OK, response);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/personnel/{personnelId}")
    public ResponseEntity<Object> deletePersonnel(@PathVariable("personnelId") String personnelId) {
        var response = adminPanelService.deletePersonnel(personnelId);

        return ResponseHandler.responseBuilder("The personnel with the provided id has been deleted successfully", HttpStatus.OK, response);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/clubs")
    public ResponseEntity<Object> addClub(@RequestBody Club club) {
        var response = adminPanelService.saveClub(club);

        return ResponseHandler.responseBuilder("The the provided club has been added successfully", HttpStatus.OK, response);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/club")
    public ResponseEntity<Object> updateClub(@RequestBody List<Club> clubs) { //TODO change to list of clubs
        var response = adminPanelService.updateClub(clubs);

        return ResponseHandler.responseBuilder("The the provided list of clubs has been updated successfully", HttpStatus.OK, response);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/club/{clubId}")
    public ResponseEntity<Object> deleteClub(@PathVariable("{clubId") String clubId) {
        var response = adminPanelService.deleteClub(clubId);

        return ResponseHandler.responseBuilder("The club with the provided id has been deleted successfully", HttpStatus.OK, response);
    }
}
