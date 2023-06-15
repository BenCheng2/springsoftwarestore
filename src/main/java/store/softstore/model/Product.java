package store.softstore.model;

import jakarta.persistence.*;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubheader() {
        return subheader;
    }

    public void setSubheader(String subheader) {
        this.subheader = subheader;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getFirstYearPrice() {
        return firstYearPrice;
    }

    public void setFirstYearPrice(String firstYearPrice) {
        this.firstYearPrice = firstYearPrice;
    }

    public String getSecondYearPrice() {
        return secondYearPrice;
    }

    public void setSecondYearPrice(String secondYearPrice) {
        this.secondYearPrice = secondYearPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", subheader='" + subheader + '\'' +
                ", product='" + product + '\'' +
                ", firstYearPrice='" + firstYearPrice + '\'' +
                ", secondYearPrice='" + secondYearPrice + '\'' +
                '}';
    }
}










































































