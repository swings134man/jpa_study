package sixth_Query.jpql;

import fifth_value_type.Adderss;

import javax.persistence.*;

@Entity
public class Jp_order {
    @Id
    @GeneratedValue
    private Long id;
    private int orderAmount;

    @Embedded
    private Jp_Address address;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Jp_product product;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Jp_Address getAddress() {
        return address;
    }

    public void setAddress(Jp_Address address) {
        this.address = address;
    }

    public Jp_product getProduct() {
        return product;
    }

    public void setProduct(Jp_product product) {
        this.product = product;
    }
}
