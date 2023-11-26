package lk.itum.MarketMate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailDto {

    private String orderId;
    private String productId;
    private int qty;
    private double unitPrice;
    private double discount;


}
