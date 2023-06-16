package store.softstore.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private String subheader;

    private String product;

    private String firstYearPrice;

    private String secondYearPrice;

    public Product(long id, String title, String subheader, String product, String firstYearPrice, String secondYearPrice) {
        this.id = id;
        this.title = title;
        this.subheader = subheader;
        this.product = product;
        this.firstYearPrice = firstYearPrice;
        this.secondYearPrice = secondYearPrice;
    }

    public Product() {

    }

}










































































