package angular.api.rest.api.with.angular.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;
    private String productName;
    private String productImages;
    private double productPrice;
    private int productSale;
    private int productTotal;
    private String productDescription;
    private boolean productStatus;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    public Product() {
    }

    public Product(Long productId,String productName, double productPrice, String productImages, int productTotal, int productSale,String productDescription,boolean productStatus,Category category) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productImages = productImages;
        this.productTotal = productTotal;
        this.productSale = productSale;
        this.productDescription = productDescription;
        this.productStatus = productStatus;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productImages='" + productImages + '\'' +
                ", productPrice='" + productPrice + '\'' +
                ", productSale=" + productSale +
                ", productTotal=" + productTotal +
                ", productDescription='" + productDescription + '\'' +
                ", productStatus=" + productStatus +
                '}';
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImages() {
        return productImages;
    }

    public void setProductImages(String productImages) {
        this.productImages = productImages;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductSale() {
        return productSale;
    }

    public void setProductSale(int productSale) {
        this.productSale = productSale;
    }

    public int getProductTotal() {
        return productTotal;
    }

    public void setProductTotal(int productTotal) {
        this.productTotal = productTotal;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
