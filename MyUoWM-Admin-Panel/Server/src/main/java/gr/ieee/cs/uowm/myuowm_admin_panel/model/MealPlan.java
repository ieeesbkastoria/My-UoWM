package gr.ieee.cs.uowm.myuowm_admin_panel.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "meal_plan")
@Getter
@Setter
public class MealPlan {

    @Id
    private Byte id;
    @Column(nullable = false)
    private Long meal_id;
    @Column(nullable = false)
    private int week_number;
    @Column(nullable = false)
    private String day_of_week;
    @Column(nullable = false)
    private String dish1;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MealType mealType;
    @Column(nullable = false)
    private String dish2;
    @Column(nullable = false)
    private String salad;
    @Column(nullable = false)
    private String dessert;
}
