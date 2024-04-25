package gr.ieee.cs.uowm.myuowm_admin_panel.model;

import jakarta.persistence.*;


@Entity
@Table(name = "time_table")
public class TimeTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String url;

    public TimeTable(Long id, String url) {
        this.id = id;
        this.url = url;
    }

    public TimeTable() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
