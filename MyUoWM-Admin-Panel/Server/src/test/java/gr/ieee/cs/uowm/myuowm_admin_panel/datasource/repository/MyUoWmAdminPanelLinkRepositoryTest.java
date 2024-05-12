package gr.ieee.cs.uowm.myuowm_admin_panel.datasource.repository;

import gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model.Link;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class MyUoWmAdminPanelLinkRepositoryTest {

    @Autowired
    private MyUoWmAdminPanelLinkRepository linkRepository;
    Link link;

    @BeforeEach
    void setUp() {
        link = new Link(1L, "timeTable", "my.url.com");
        linkRepository.save(link);
    }

    @AfterEach
    void tearDown() {
        link = null;
        linkRepository.deleteAll();
    }

    // Test case SUCCESS
    @Test
    void testFindByUsage_Found() {
        Optional<Link> link1 = linkRepository.findByUsage("timeTable");

        assertThat(link1.get().getId().equals(link.getId())).isTrue(); // test failed, findByUsage changes link Id for some reason
        assertThat(link1.get().getUsage().equals(link.getUsage())).isTrue();
        assertThat(link1.get().getUrl().equals(link.getUrl())).isTrue();
    }

    // Test case FAILURE
    @Test
    void testFindByUsage_NotFound() {
        Optional<Link> link1 = linkRepository.findByUsage("somethingElse");

        assertThat(link1.isEmpty()).isTrue();
    }
}