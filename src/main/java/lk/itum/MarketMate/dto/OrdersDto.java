package lk.itum.MarketMate.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrdersDto {

    private String orderId;
    private double totalValue;
    private double netTotal;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate orderDate;
    private CustomerDto customer;
    private List<OrderDetailDto> orderDetails;


}
