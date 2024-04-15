package gr.ieee.cs.uowm.myuowm_admin_panel.service.impl;

import gr.ieee.cs.uowm.myuowm_admin_panel.model.Club;
import gr.ieee.cs.uowm.myuowm_admin_panel.model.DinnerPlan;
import gr.ieee.cs.uowm.myuowm_admin_panel.model.Personal;
import gr.ieee.cs.uowm.myuowm_admin_panel.model.TimeTable;
import gr.ieee.cs.uowm.myuowm_admin_panel.service.WebAppService;

import java.util.List;

public class WebAppServiceImpl implements WebAppService {

    // add repository reference i.e.
    // UOWMRepository uowmRepository
    // use repository methods to service methods

    @Override
    public TimeTable getTimeTable(String link) {
        return null;
    }

    @Override
    public DinnerPlan getDinnerPlan(String link) {
        return null;
    }

    @Override
    public List<Personal> getAllPersonal() {
        return null;
    }

    @Override
    public Personal getPersonal(String id) {
        return null;
    }

    @Override
    public List<Club> getAllClubs() {
        return null;
    }

    @Override
    public Club getClub(String id) {
        return null;
    }
}
