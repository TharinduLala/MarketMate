package lk.itum.MarketMate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderProduct_PK implements Serializable {
    private String orderId;
    private String productId;
}
