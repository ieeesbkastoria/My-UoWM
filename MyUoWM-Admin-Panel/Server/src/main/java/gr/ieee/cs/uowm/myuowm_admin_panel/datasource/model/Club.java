package gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "club_info")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Club {

    @Id
    private String club_id;
    private String clubName;
    private String link;
}
