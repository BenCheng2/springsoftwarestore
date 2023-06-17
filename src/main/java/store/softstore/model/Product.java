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

    private int firstYearPrice;

    private int secondYearPrice;


}










































































