package lk.itum.MarketMate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Orders {

    @Id
    private String orderId;
    private double totalValue;
    private double netTotal;
    private LocalDate orderDate;

    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "customerId",referencedColumnName = "customerId")
    private Customer customer;

    @OneToMany(mappedBy = "orders",cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;

}
