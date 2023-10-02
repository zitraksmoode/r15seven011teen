package work_space.model;



import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
@Entity
@Table(name = "Magazine")
public class Magazine {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStore_name() {
        return store_name;
    }

    public void setStore_name(int store_name) {
        this.store_name = store_name;
    }

    public Magazine(Long id, int store_name) {
        this.id = id;
        this.store_name = store_name;
    }

    public Magazine() {
    }

    @Size(min = 10, max = 100)
    @Column(name = "store_name")
    private int store_name;


}
