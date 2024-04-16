package gr.ieee.cs.uowm.myuowm_admin_panel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "personnel_info")
public class Personnel {

    @Id
    private String personnel_id;
    private String department;
    private String name;
    private String phone;
    private String office;
    private String officeHours;
    private String email;

    public Personnel(String personnel_id, String department, String name, String phone, String office, String officeHours, String email) {
        this.personnel_id = personnel_id;
        this.department = department;
        this.name = name;
        this.phone = phone;
        this.office = office;
        this.officeHours = officeHours;
        this.email = email;
    }

    public Personnel() {}

    public String getPersonnel_id() {
        return personnel_id;
    }

    public void setPersonnel_id(String personal_id) {
        this.personnel_id = personal_id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
