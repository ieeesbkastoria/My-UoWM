package gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model;

import jakarta.annotation.Nullable;
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
    private String email;

    public boolean equals(@Nullable Personnel personnel) {
        try {
            return personnel.getPersonnel_id().equals(personnel_id)
                    && personnel.getDepartment().equals(department)
                    && personnel.getName().equals(name)
                    && personnel.getOffice().equals(office)
                    && personnel.getEmail().equals(email);
        } catch (NullPointerException e) {
            return false;
        }
    }

}
