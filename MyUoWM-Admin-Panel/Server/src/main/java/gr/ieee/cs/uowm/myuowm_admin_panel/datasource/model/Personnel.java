package gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "personnel_info")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Personnel {

    @Id
    private String personnel_id;
    private String department;
    private String name;
    private String phone;
    private String office;
    private String officeHours;
    private String email;

}
