package gr.ieee.cs.uowm.myuowm_admin_panel.datasource.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "meal_plan")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MealPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long mealId;
    @Column(nullable = false)
    private Integer week_number;
    @Column(nullable = false)
    private String day_of_week;
    @Column(nullable = false)
    private String dish1;
    @Column(nullable = false)
    private String dish2;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MealType mealType;
    @Column(nullable = false)
    private String salad;
    @Column(nullable = false)
    private String dessert;

    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;

        if(obj.getClass() != this.getClass())
            return false;

        final MealPlan other = (MealPlan) obj;

        if((this.id == null) ? (other.id != null) : !this.id.equals(other.id))
            return false;
        if((this.mealId == null) ? (other.mealId != null) : !this.mealId.equals(other.mealId))
            return false;
        if((this.week_number == null) ? (other.week_number == null) : !this.week_number.equals(other.week_number))
            return false;
        if((this.day_of_week == null) ? (other.day_of_week != null) : !this.day_of_week.equals(other.day_of_week))
            return false;
        if((this.dish1 == null) ? (other.dish1 != null) : !this.dish1.equals(other.dish1))
            return false;
        if((this.dish2 == null) ? (other.dish2 != null) : !this.dish2.equals(other.dish2))
            return false;
        if((this.mealType == null) ? (other.mealType != null) : !this.mealType.equals(other.mealType))
            return false;
        if((this.salad == null) ? (other.salad != null) : !this.salad.equals(other.salad))
            return false;
        if((this.dessert == null) ? (other.dessert != null) : !this.dessert.equals(other.dessert))
            return false;

        return true;
    }

}
