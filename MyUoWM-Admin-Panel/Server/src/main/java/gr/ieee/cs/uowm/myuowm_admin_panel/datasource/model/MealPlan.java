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
}
