package gr.ieee.cs.uowm.myuowm_admin_panel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "dinner_plan")
public class DinnerPlan {

    @Id
    private String link;

    public DinnerPlan(String link) {
        this.link = link;
    }

    public DinnerPlan() {}

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
