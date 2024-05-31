package main.datasource.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "links")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String usage;
    @Column(nullable = false)
    private String url;

    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;

        if(obj.getClass() != this.getClass())
            return false;

        final Link other = (Link) obj;

        if((this.id == null) ? (other.id != null) : !this.id.equals(other.id))
            return false;
        if((this.usage == null) ? (other.usage != null) : !this.usage.equals(other.usage))
            return false;
        if((this.url == null) ? (other.url != null) : !this.url.equals(other.url))
            return false;

        return true;
    }
}
