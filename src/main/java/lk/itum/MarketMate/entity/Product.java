package lk.itum.MarketMate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Product {

    @Id
    private String productId;
    private String productName;
    private int qtyInStock;
    private LocalDate mfdDate;
    private LocalDate expDate;
    private double unitPrice;
    private double productDiscount;
}
