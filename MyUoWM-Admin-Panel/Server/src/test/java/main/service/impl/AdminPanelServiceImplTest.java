package main.service.impl;

import main.datasource.repository.ClubRepository;
import main.datasource.repository.LinkRepository;
import main.datasource.repository.PersonnelRepository;
import main.exception.club.ClubNotFoundException;
import main.exception.link.LinkNotFoundException;
import main.exception.personnel.PersonnelNotFoundException;
import main.datasource.model.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AdminPanelServiceImplTest {

    @Mock
    private ClubRepository clubRepository;
    @Mock
    private PersonnelRepository personnelRepository;
    @Mock
    private LinkRepository linkRepository;
    private AdminPanelServiceImpl adminService;

    AutoCloseable autoCloseable;
    Club club;
    Link link1, link2, link3;
    Personnel personnel;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        adminService = new AdminPanelServiceImpl(personnelRepository,clubRepository,
                linkRepository);

        club = new Club("IEEE SB", "url.com");
        link1 = new Link(1L, "link4", "url.com");
        link2 = new Link(1L, "link2", "url.com");
        link3 = new Link(1L, "link3", "url.com");

        personnel = new Personnel("4444", "CS", "Kostas",
                "6999999", "22", "kostas@uowm.gr");
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    // Test case Success
    @Test
    void testUpdateLinks_Found() {
        mock(Link.class);
        mock(LinkRepository.class);

        List<Link> linkList = List.of(link1, link2, link3);

        linkList.forEach(link ->
                when(linkRepository.findByUsage(link.getUsage()))
                        .thenReturn(Optional.of(link)));

        assertThat(adminService.updateLinks(linkList).equals(linkList)).isTrue();
    }

    // Test case Failure
    @Test
    void testUpdateLinks_UsageNotFound() {
        mock(Link.class);
        mock(LinkRepository.class);

        var linkList = List.of(link1, link2, link3);

        linkList.forEach(link ->
                when(linkRepository.findByUsage(link.getUsage()))
                        .thenReturn(Optional.empty()));

        LinkNotFoundException exception = assertThrows(LinkNotFoundException.class,
                () -> adminService.updateLinks(linkList));

        assertEquals(exception.getMessage(), "The list of links contains a non valid link usage");
    }

    // Test case Success
    @Test
    void testSavePersonnel_Success() {
        mock(Personnel.class);
        mock(PersonnelRepository.class);

        assertThat(adminService.savePersonnel(personnel).equals(personnel)).isTrue();
    }

    // Test case Success
    @Test
    void testUpdatePersonnel_Success() {
        mock(Personnel.class);
        mock(PersonnelRepository.class);

        var personnelList = List.of(personnel);

        personnelList.forEach(employee ->
                when(personnelRepository.findById(employee.getPersonnel_id()))
                        .thenReturn(Optional.of(employee)));

        assertThat(adminService.updatePersonnel(personnelList).equals(personnelList)).isTrue();
    }

    // Test case Failure
    @Test
    void testUpdatePersonnel_IdNotFound() {
        mock(Personnel.class);
        mock(PersonnelRepository.class);

        var personnelList = List.of(personnel);

        personnelList.forEach(employee ->
                when(personnelRepository.findById(employee.getPersonnel_id()))
                        .thenReturn(Optional.empty()));

        PersonnelNotFoundException exception = assertThrows(PersonnelNotFoundException.class,
                () -> adminService.updatePersonnel(personnelList));

        assertEquals(exception.getMessage(), "The provided list contains an employee with an unknown id");
    }

    // Test case Success
    @Test
    void testDeletePersonnel_Success() {
        mock(Personnel.class);
        mock(PersonnelRepository.class);

        var personnelId = personnel.getPersonnel_id();

        when(personnelRepository.findById(personnelId)).thenReturn(Optional.of(personnel));

        assertThat(adminService.deletePersonnel(personnelId)
                .equals("Personnel with id: " + personnelId + " deleted successfully")).isTrue();
    }

    // Test case Failure
    @Test
    void testDeletePersonnel_IdNotFound() {
        mock(Personnel.class);
        mock(PersonnelRepository.class);

        var personnelId = personnel.getPersonnel_id();

        PersonnelNotFoundException exception = assertThrows(PersonnelNotFoundException.class,
                () -> adminService.deletePersonnel(personnelId));

        assertEquals(exception.getMessage(),
                "The employee with the id: " + personnelId + " could not be found");
    }

    // Test case Success
    @Test
    void testSaveClub_Success() {
        mock(Club.class);
        mock(ClubRepository.class);

        assertThat(adminService.saveClub(club).equals(club)).isTrue();
    }

    // Test case Success
    @Test
    void testUpdateClub_Success() {
        mock(Club.class);
        mock(ClubRepository.class);

        var clubList = List.of(club);

        clubList.forEach(clubEntry ->
                when(clubRepository.findById(clubEntry.getClubName()))
                        .thenReturn(Optional.of(clubEntry)));

        assertThat(adminService.updateClub(clubList).equals(clubList)).isTrue();
    }

    // Test case Failure
    @Test
    void testUpdateClub_IdNotFound() {
        mock(Club.class);
        mock(ClubRepository.class);

        var clubList = List.of(club);

        clubList.forEach(clubEntry ->
                when(clubRepository.findById(clubEntry.getClubName()))
                        .thenReturn(Optional.empty()));

        ClubNotFoundException exception = assertThrows(ClubNotFoundException.class,
                () -> adminService.updateClub(clubList));

        assertEquals(exception.getMessage(), "The list of clubs contains a non valid club name");
    }

    // Test case Success
    @Test
    void testDeleteClub_Success() {
        mock(Club.class);
        mock(ClubRepository.class);

        var clubId = club.getClubName();

        when(clubRepository.findById(clubId)).thenReturn(Optional.of(club));

        assertThat(adminService.deleteClub(clubId).equals("Club deleted successfully")).isTrue();
    }

    // Test case Failure
    @Test
    void testDeleteClub_IdNotFound() {
        mock(Club.class);
        mock(ClubRepository.class);

        var clubId = club.getClubName();

        when(clubRepository.findById(clubId)).thenReturn(Optional.empty());

        ClubNotFoundException exception = assertThrows(ClubNotFoundException.class,
                () -> adminService.deleteClub(clubId));
        assertEquals(exception.getMessage(),
                "The provided clubs name does not match any club in the database");
    }
}