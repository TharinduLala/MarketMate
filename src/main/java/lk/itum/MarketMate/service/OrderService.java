package lk.itum.MarketMate.service;

import lk.itum.MarketMate.dto.OrdersDto;

import java.util.List;

public interface OrderService {
    void purchaseOrder(OrdersDto dto);

    void deleteOrder(String oid);

    void updateOrder(OrdersDto dto);

    OrdersDto searchOrder(String oid);

    List<OrdersDto> getAllOrders();
}
