package lk.itum.MarketMate.controller;

import lk.itum.MarketMate.dto.OrdersDto;
import lk.itum.MarketMate.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order")
@CrossOrigin
public class OrderController {
    final
    OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping
    public String getAllOrders() {
        return "Get ALl Orders";
    }

    @GetMapping(path = "/{orderId}")
    public String searchOrder(@PathVariable String orderId) {
        return "Search Order";
    }

    @PostMapping
    public String saveOrder(@RequestBody OrdersDto ordersDto) {
        return "save Order";
    }

    @PutMapping
    public String updateOrder(@RequestBody OrdersDto ordersDto) {
        return "update Order";
    }

    @DeleteMapping(params = {"orderId"})
    public String deleteOrder(@RequestParam String orderId) {
        return "delete Order";
    }


}
