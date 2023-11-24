package lk.itum.MarketMate.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class CustomerDto {
    private String customerId;
    private String customerName;
    private String customerAddress;
    private String customerEmail;
    private String customerTelNo;
}
