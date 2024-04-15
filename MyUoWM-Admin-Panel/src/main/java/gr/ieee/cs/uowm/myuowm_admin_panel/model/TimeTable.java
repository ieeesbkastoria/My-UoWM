package gr.ieee.cs.uowm.myuowm_admin_panel.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "time_table")
public class TimeTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String url;

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
