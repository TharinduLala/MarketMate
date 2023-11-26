package lk.itum.MarketMate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Customer {

    @Id
    private String customerId;
    private String customerName;
    private String customerAddress;
    private String customerEmail;
    private String customerTelNo;

}
