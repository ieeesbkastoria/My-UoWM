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

    public boolean equals(MealPlan mealPlan) {
        if(mealPlan == null)
            return false;

        return mealPlan.getId().equals(id)
                && mealPlan.getMealId().equals(mealId)
                && mealPlan.getWeek_number().equals(week_number)
                && mealPlan.getDay_of_week().equals(day_of_week)
                && mealPlan.getDish1().equals(dish1)
                && mealPlan.getDish2().equals(dish2)
                && mealPlan.getMealType().equals(mealType)
                && mealPlan.getSalad().equals(salad)
                && mealPlan.getDessert().equals(dessert);
    }
}
