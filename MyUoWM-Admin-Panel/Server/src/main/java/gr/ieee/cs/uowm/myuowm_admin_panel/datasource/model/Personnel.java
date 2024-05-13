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
    private String email;

    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;

        if(obj.getClass() != this.getClass())
            return false;

        final Personnel other = (Personnel) obj;

        if((this.personnel_id == null) ? (other.personnel_id != null) : !this.personnel_id.equals(other.personnel_id))
            return false;
        if((this.department == null) ? (other.department != null) : !this.department.equals(other.department))
            return false;
        if((this.name == null) ? (other.name != null) : !this.name.equals(other.name))
            return false;
        if((this.phone == null) ? (other.phone != null) : !this.phone.equals(other.phone))
            return false;
        if((this.office == null) ? (other.office != null) : !this.office.equals(other.office))
            return false;
        if((this.email == null) ? (other.email != null) : !this.email.equals(other.email))
            return false;

        return true;
    }

}
