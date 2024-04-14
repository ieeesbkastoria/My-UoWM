package gr.ieee.cs.uowm.myuowm_admin_panel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "time_table")
public class TimeTable {

    @Id
    private String link;

    public TimeTable(String link) {
        this.link = link;
    }

    public TimeTable() {}

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
