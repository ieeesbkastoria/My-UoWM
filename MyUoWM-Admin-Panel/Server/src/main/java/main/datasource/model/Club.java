package main.datasource.model;


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
    private String clubName;
    private String link;

    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;

        if(obj.getClass() != this.getClass())
            return false;

        final Club other = (Club) obj;

        if((this.clubName == null) ? (other.clubName != null) : !this.clubName.equals(other.clubName))
            return false;
        if((this.link == null) ? (other.link != null) : !this.link.equals(other.link))
            return false;

        return true;
    }
}
