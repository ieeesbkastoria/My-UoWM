package gr.ieee.cs.uowm.myuowm_admin_panel.model;



//@Entity
//@Table(name = "club_info")
public class Club {

    private String clubName;
    private String link;

    public Club(String clubName, String link) {
        this.clubName = clubName;
        this.link = link;
    }

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
