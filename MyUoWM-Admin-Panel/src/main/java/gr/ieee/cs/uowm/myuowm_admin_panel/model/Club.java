package gr.ieee.cs.uowm.myuowm_admin_panel.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "club_info")
public class Club {

    @Id
    private String club_id;
    private String clubName;
    private String link;

    public Club(String club_id, String clubName, String link) {
        this.club_id = club_id;
        this.clubName = clubName;
        this.link = link;
    }

    public String getClub_id() {
        return club_id;
    }

    public void setClub_id(String club_id) {
        this.club_id = club_id;
    }

    public Club() {}

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }
}
