package gr.ieee.cs.uowm.myuowm_admin_panel.service.impl;

import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.*;
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

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

//TODO Update tests to get specific object when exceptions are implemented

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

        club = new Club("IEEE SB", "url.com");
        link = new Link(1L, "usage", "url.com");
        mealPlan = new MealPlan(1L, 1L, 1, "Monday", "dish1", "dish2", MealType.DINNER, "salad", "cake");
        personnel = new Personnel("4444", "CS", "Kostas", "6999999", "22", "kostas@uowm.gr");

    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    // Test case Success
    @Test
    void testGetMealPlan_Found() {
        mock(MealPlan.class);
        mock(MyUoWmAdminPanelMealPlanRepository.class);

        List<MealPlan> meals = List.of(mealPlan);
        when(mealPlanRepository.findByMealId(1L)).thenReturn(meals);
        assertThat(webAppService.getMealPlan().equals(meals)).isTrue();
    }

    // Test case Failure
    @Test
    void testGetMealPlan_NotFound() {
        mock(MealPlan.class);
        mock(MyUoWmAdminPanelMealPlanRepository.class);

        List<MealPlan> meals = List.of(mealPlan);
        when(mealPlanRepository.findByMealId(1L)).thenReturn(Collections.EMPTY_LIST);
        assertThat(webAppService.getMealPlan().equals(meals)).isFalse();
    }

    // Test case Success
    @Test
    void testGetAllPersonnel_Found() {
        mock(Personnel.class);
        mock(MyUoWmAdminPanelPersonnelRepository.class);

        List<Personnel> staff = List.of(personnel);
        when(personnelRepository.findAll()).thenReturn(staff);
        assertThat(webAppService.getAllPersonnel().equals(staff)).isTrue();
        assertThat(webAppService.getAllPersonnel().stream().allMatch(employee -> employee.equals(personnel))).isTrue();
    }

    // Test case Failure
    @Test
    void testGetAllPersonnel_NotFound() {
        mock(Personnel.class);
        mock(MyUoWmAdminPanelPersonnelRepository.class);

        List<Personnel> staff = List.of(personnel);
        when(personnelRepository.findAll()).thenReturn(Collections.EMPTY_LIST);
        assertThat(webAppService.getAllPersonnel().equals(staff)).isFalse();
    }

    // Test case Success
    @Test
    void testGetPersonnel_Found() {
        mock(Personnel.class);
        mock(MyUoWmAdminPanelPersonnelRepository.class);

        when(personnelRepository.findById(personnel.getPersonnel_id())).thenReturn(Optional.of(personnel));

        assertThat(webAppService.getPersonnel(personnel.getPersonnel_id()).equals(personnel)).isTrue();
    }

    // Test case Failure
    // TODO
    @Test
    void testGetPersonnel_NotFound() {
        mock(Personnel.class);
        mock(MyUoWmAdminPanelPersonnelRepository.class);

        when(personnelRepository.findById(personnel.getPersonnel_id())).thenReturn(Optional.empty());

        //TODO change to check for custom exception
        assertThat(webAppService.getPersonnel(personnel.getPersonnel_id()).equals(personnel)).isFalse();
    }

    // Test case Success
    @Test
    void testGetAllClubs_Found() {
        mock(Club.class);
        mock(MyUoWmAdminPanelClubRepository.class);

        List<Club> staff = List.of(club);
        when(clubRepository.findAll()).thenReturn(staff);
        assertThat(webAppService.getAllClubs().equals(staff)).isTrue();
        assertThat(webAppService.getAllClubs().stream().allMatch(_club -> _club.equals(club))).isTrue();
    }

    // Test case Failure
    @Test
    void testGetAllClubs_NotFound() {
        mock(Club.class);
        mock(MyUoWmAdminPanelClubRepository.class);

        List<Club> staff = List.of(club);
        when(clubRepository.findAll()).thenReturn(Collections.EMPTY_LIST);
        assertThat(webAppService.getAllClubs().equals(staff)).isFalse();
    }

    @Test
    void getClub() {
    }

    // Test case Success
    @Test
    void testGetAllLinks_Found() {
        mock(Link.class);
        mock(MyUoWmAdminPanelLinkRepository.class);

        List<Link> staff = List.of(link);
        when(linkRepository.findAll()).thenReturn(staff);
        assertThat(webAppService.getAllLinks().equals(staff)).isTrue();
        assertThat(webAppService.getAllLinks().stream().allMatch(_link -> _link.equals(link))).isTrue();
    }

    // Test case Failure
    @Test
    void testGetAllLinks_NotFound() {
        mock(Link.class);
        mock(MyUoWmAdminPanelLinkRepository.class);

        List<Link> staff = List.of(link);
        when(linkRepository.findAll()).thenReturn(Collections.EMPTY_LIST);
        assertThat(webAppService.getAllLinks().equals(staff)).isFalse();
    }
    @Test
    void getSpecificLink() {
    }
}