package projekat.obj.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@NamedQuery(name = OrderProduct.GET_ALL_ORDER_PRODUCTS, query = "Select op from OrderProduct op")
public class OrderProduct {

    public static final String GET_ALL_ORDER_PRODUCTS = "GetAllOrderProducts";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_product_seq")
    @SequenceGenerator(name = "order_product_seq", sequenceName = "order_product_seq", allocationSize = 1)
    private Long id;

    private Integer quantity;

    public OrderProduct() {
    }

    public OrderProduct(Integer quantity, Long id) {
        this.quantity = quantity;
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orders_id")
    private Orders orders;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderProduct that = (OrderProduct) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity);
    }

    @Override
    public String toString() {
        return "OrderProduct{" +
                "id=" + id +
                ", quantity=" + quantity +
                '}';
    }
}