package projekat.obj.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@NamedQuery(name = ProductCategory.GET_ALL_PRODUCT_CATEGORIES, query = "Select pc from ProductCategory pc")
public class ProductCategory {

    public static final String GET_ALL_PRODUCT_CATEGORIES = "GetAllProductCategories";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_category_seq")
    @SequenceGenerator(name = "product_category_seq", sequenceName = "product_category_seq", allocationSize = 1)
    private Long id;

    public ProductCategory() {
    }

    public ProductCategory(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCategory that = (ProductCategory) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "id=" + id +
                '}';
    }
}