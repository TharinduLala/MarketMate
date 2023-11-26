package lk.itum.MarketMate.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class OrderProduct_PK implements Serializable {
    private String orderId;
    private String productId;
}
