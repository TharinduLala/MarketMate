package lk.itum.MarketMate.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class OrderDetail {

    @EmbeddedId
    private OrderProduct_PK orderItem_pk;
    private int qty;
    private double unitPrice;
    private double discount;


    @ManyToOne
    @JoinColumn(name = "orderId",referencedColumnName = "orderId",insertable = false,updatable = false)
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "productId",referencedColumnName = "productId",insertable = false,updatable = false)
    private Product product;

}
