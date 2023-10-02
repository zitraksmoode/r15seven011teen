package work_space.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;


import java.time.LocalDateTime;

@Entity
@Table(name = "order")
public class Order {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Order(Long id, Person person, LocalDateTime orderDate) {
        this.id = id;
        this.person = person;
        this.orderDate = orderDate;
    }

    public Order() {
    }


}