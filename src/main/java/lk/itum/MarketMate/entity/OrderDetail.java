package lk.itum.MarketMate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@IdClass(OrderProduct_PK.class)
public class OrderDetail {

    @Id
    private String orderId;
    @Id
    private String productId;
    private OrderProduct_PK orderProduct_pk;
    private int qty;
    private double unitPrice;
    private double discount;


    @ManyToOne
    @JoinColumn(name = "orderId", referencedColumnName = "orderId", insertable = false, updatable = false)
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "productId", referencedColumnName = "productId", insertable = false, updatable = false)
    private Product product;

}
