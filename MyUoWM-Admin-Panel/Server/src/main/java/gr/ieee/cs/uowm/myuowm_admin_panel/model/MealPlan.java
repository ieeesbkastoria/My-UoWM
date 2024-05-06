package gr.ieee.cs.uowm.myuowm_admin_panel.model;

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
    private int week_number;
    @Column(nullable = false)
    private String day_of_week;
    @Column(nullable = false)
    private String dish1;
    // TODO change String of meal type to sql enum(Breakfast, lunch, dinner)
    @Column(nullable = false)
    private String meal_type;
    @Column(nullable = false)
    private String dish2;
    @Column(nullable = false)
    private String salad;
    @Column(nullable = false)
    private String dessert;


}
