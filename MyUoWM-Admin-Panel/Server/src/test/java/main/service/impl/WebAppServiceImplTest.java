package main.service.impl;

import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.*;
import main.datasource.repository.ClubRepository;
import main.datasource.repository.LinkRepository;
import main.datasource.repository.MealPlanRepository;
import main.datasource.repository.PersonnelRepository;
import main.exception.club.ClubNotFoundException;
import main.exception.link.LinkNotFoundException;
import main.exception.personnel.PersonnelNotFoundException;
import main.service.WebAppService;
import main.datasource.model.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class WebAppServiceImplTest {

    @Mock
    private ClubRepository clubRepository;
    @Mock
    private PersonnelRepository personnelRepository;
    @Mock
    private LinkRepository linkRepository;
    @Mock
    private MealPlanRepository mealPlanRepository;
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
        mock(MealPlanRepository.class);

        List<MealPlan> meals = List.of(mealPlan);
        when(mealPlanRepository.findByMealId(1L)).thenReturn(meals);
        assertThat(webAppService.getMealPlan().equals(meals)).isTrue();
    }

    // Test case Failure
    @Test
    void testGetMealPlan_NotFound() {
        mock(MealPlan.class);
        mock(MealPlanRepository.class);

        List<MealPlan> meals = List.of(mealPlan);
        when(mealPlanRepository.findByMealId(1L)).thenReturn(Collections.EMPTY_LIST);
        assertThat(webAppService.getMealPlan().equals(meals)).isFalse();
    }

    // Test case Success
    @Test
    void testGetAllPersonnel_Found() {
        mock(Personnel.class);
        mock(PersonnelRepository.class);

        List<Personnel> staff = List.of(personnel);
        when(personnelRepository.findAll()).thenReturn(staff);
        assertThat(webAppService.getAllPersonnel().equals(staff)).isTrue();
        assertThat(webAppService.getAllPersonnel().stream().allMatch(employee -> employee.equals(personnel))).isTrue();
    }

    // Test case Failure
    @Test
    void testGetAllPersonnel_NotFound() {
        mock(Personnel.class);
        mock(PersonnelRepository.class);

        List<Personnel> staff = List.of(personnel);
        when(personnelRepository.findAll()).thenReturn(Collections.EMPTY_LIST);
        assertThat(webAppService.getAllPersonnel().equals(staff)).isFalse();
    }

    // Test case Success
    @Test
    void testGetPersonnel_Found() {
        mock(Personnel.class);
        mock(PersonnelRepository.class);

        when(personnelRepository.findById(personnel.getPersonnel_id())).thenReturn(Optional.of(personnel));

        Assertions.assertThat(webAppService.getPersonnel(personnel.getPersonnel_id()).equals(personnel)).isTrue();
    }

    // Test case Failure
    @Test
    void testGetPersonnel_NotFound() {
        mock(Personnel.class);
        mock(PersonnelRepository.class);

        when(personnelRepository.findById(personnel.getPersonnel_id())).thenReturn(Optional.empty());

        PersonnelNotFoundException exception = assertThrows(PersonnelNotFoundException.class,
                () -> webAppService.getPersonnel(personnel.getPersonnel_id()));

        assertEquals(exception.getMessage(), "Given id does not match any personnel entity in the data base");
    }

    // Test case Success
    @Test
    void testGetAllClubs_Found() {
        mock(Club.class);
        mock(ClubRepository.class);

        List<Club> staff = List.of(club);
        when(clubRepository.findAll()).thenReturn(staff);
        assertThat(webAppService.getAllClubs().equals(staff)).isTrue();
        assertThat(webAppService.getAllClubs().stream().allMatch(_club -> _club.equals(club))).isTrue();
    }

    // Test case Failure
    @Test
    void testGetAllClubs_NotFound() {
        mock(Club.class);
        mock(ClubRepository.class);

        List<Club> staff = List.of(club);
        when(clubRepository.findAll()).thenReturn(Collections.EMPTY_LIST);
        assertThat(webAppService.getAllClubs().equals(staff)).isFalse();
    }

    // Test case Success
    @Test
    void testGetClub_Found() {
        mock(Club.class);
        mock(ClubRepository.class);

        when(clubRepository.findById(club.getClubName())).thenReturn(Optional.of(club));

        Assertions.assertThat(webAppService.getClub(club.getClubName()).equals(club)).isTrue();
    }

    //Test case Failure
    @Test
    void testGetClub_NotFound() {
        mock(Club.class);
        mock(ClubRepository.class);

        when(clubRepository.findById(club.getClubName())).thenReturn(Optional.empty());

        ClubNotFoundException exception = assertThrows(ClubNotFoundException.class,
                () -> webAppService.getClub(club.getClubName()));

        assertEquals(exception.getMessage(), "Given id does not match any club in the data base");
    }
    // Test case Success
    @Test
    void testGetAllLinks_Found() {
        mock(Link.class);
        mock(LinkRepository.class);

        List<Link> staff = List.of(link);
        when(linkRepository.findAll()).thenReturn(staff);
        assertThat(webAppService.getAllLinks().equals(staff)).isTrue();
        assertThat(webAppService.getAllLinks().stream().allMatch(_link -> _link.equals(link))).isTrue();
    }

    // Test case Failure
    @Test
    void testGetAllLinks_NotFound() {
        mock(Link.class);
        mock(LinkRepository.class);

        List<Link> staff = List.of(link);
        when(linkRepository.findAll()).thenReturn(Collections.EMPTY_LIST);
        assertThat(webAppService.getAllLinks().equals(staff)).isFalse();
    }
    // Test case Success
    @Test
    void testGetLink_Found() {
        mock(Link.class);
        mock(LinkRepository.class);

        when(linkRepository.findByUsage(link.getUsage())).thenReturn(Optional.of(link));

        Assertions.assertThat(webAppService.getLink(link.getUsage()).equals(link)).isTrue();
    }

    //Test case Failure
    @Test
    void testGetLink_NotFound() {
        mock(Link.class);
        mock(LinkRepository.class);

        when(linkRepository.findByUsage(link.getUsage())).thenReturn(Optional.empty());

        LinkNotFoundException exception = assertThrows(LinkNotFoundException.class,
                () -> webAppService.getLink(link.getUsage()));

        assertEquals(exception.getMessage(), "Given usage does not match any link in the data base");
    }
}