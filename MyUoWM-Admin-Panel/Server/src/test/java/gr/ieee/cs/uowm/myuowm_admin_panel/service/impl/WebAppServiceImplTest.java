package gr.ieee.cs.uowm.myuowm_admin_panel.service.impl;

import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.Club;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.Link;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.MealPlan;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.Personnel;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.repository.MyUoWmAdminPanelClubRepository;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.repository.MyUoWmAdminPanelLinkRepository;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.repository.MyUoWmAdminPanelMealPlanRepository;
import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.repository.MyUoWmAdminPanelPersonnelRepository;
import gr.ieee.cs.uowm.myuowm_admin_panel.service.WebAppService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class WebAppServiceImplTest {

    @Mock
    private MyUoWmAdminPanelClubRepository clubRepository;
    @Mock
    private MyUoWmAdminPanelPersonnelRepository personnelRepository;
    @Mock
    private MyUoWmAdminPanelLinkRepository linkRepository;
    @Mock
    private MyUoWmAdminPanelMealPlanRepository mealPlanRepository;
    private WebAppService webAppService;

    AutoCloseable autoCloseable;
    Club club;
    Link link;
    MealPlan mealPlan;
    Personnel personnel;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        webAppService = new WebAppServiceImpl(clubRepository, personnelRepository,
                linkRepository, mealPlanRepository);
        //TODO Create instances of club, link, mealPlan, personnel
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void getMealPlan() {
    }

    @Test
    void testGetMealPlan() {
    }

    @Test
    void getAllPersonnel() {
    }

    @Test
    void getPersonnel() {
    }

    @Test
    void getAllClubs() {
    }

    @Test
    void getClub() {
    }

    @Test
    void getAllLinks() {
    }

    @Test
    void getSpecificLink() {
    }
}