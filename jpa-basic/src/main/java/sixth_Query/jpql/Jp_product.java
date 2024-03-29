package sixth_Query.jpql;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Jp_product {

    @Id @GeneratedValue
    private Long id;
    private String name;
    private int price;
    private int stockAmount;


    // Method
    public void minusAmount(int amount) {
        this.stockAmount = this.stockAmount - amount;
    }


    // Getter/ setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }
}
