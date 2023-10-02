package work_space.model;


import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "person")
public class Person {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "full_name")
    @Size(min = 10, max = 100 , message = "Полное имя должно быть больше чем 10 и меньше чем 100")
    private  String full_name;


    public Person(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public Person(String full_name, float budget) {
        this.full_name = full_name;
        this.budget = budget;
    }

    public Person() {
    }

    @Column(name = "budget")
    @NotNull
    private float budget;


}
