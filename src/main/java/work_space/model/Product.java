package work_space.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;



@Entity
@Table(name = "product")
public class Product {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_product", nullable = false, length = 50)
    private String nameProduct;



    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Magazine getMagazine() {
        return magazine;
    }

    public void setMagazine(Magazine magazine) {
        this.magazine = magazine;
    }

    public Product(Long id, String nameProduct, Float price, Integer quantity, Magazine magazine) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.price = price;
        this.quantity = quantity;
        this.magazine = magazine;
    }

    public Product() {
    }

    @Column(name = "price", nullable = false)
    private Float price;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "magazine_id", nullable = false)
    private Magazine magazine;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
