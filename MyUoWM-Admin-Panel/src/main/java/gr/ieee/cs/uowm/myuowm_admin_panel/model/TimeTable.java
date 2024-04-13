package gr.ieee.cs.uowm.myuowm_admin_panel.model;

//@Entity
//@Table(name = "time_table")
public class TimeTable {

    private String link;

    public TimeTable(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
