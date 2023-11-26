package lk.itum.MarketMate.dto;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {
    private String productId;
    private String productName;
    private int qtyInStock;
    private LocalDate mfdDate;
    private LocalDate expDate;
    private double unitPrice;
    private double productDiscount;
}
