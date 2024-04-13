package gr.ieee.cs.uowm.myuowm_admin_panel.model;

//@Entity
//@Table(name = "dinner_plan")
public class DinnerPlan {

    private String link;

    public DinnerPlan(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
