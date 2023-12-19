package lk.itum.MarketMate.controller;

import lk.itum.MarketMate.dto.OrdersDto;
import lk.itum.MarketMate.service.OrderService;
import lk.itum.MarketMate.util.ResponseUtil;
import org.springframework.http.MediaType;
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


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllOrders() {
        return new ResponseUtil(200,"Ok",orderService.getAllOrders());
    }

    @GetMapping(path = "/{orderId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchOrder(@PathVariable String orderId) {
        return new ResponseUtil(200,"Ok",orderService.searchOrder(orderId));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveOrder(@RequestBody OrdersDto ordersDto) {
        orderService.purchaseOrder(ordersDto);
        return new ResponseUtil(200,"Order Successful",null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateOrder(@RequestBody OrdersDto ordersDto) {
        orderService.updateOrder(ordersDto);
        return new ResponseUtil(200,"Updated Successfully",null);
    }

    @DeleteMapping(params = {"orderId"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteOrder(@RequestParam String orderId) {
        orderService.deleteOrder(orderId);
        return new ResponseUtil(200,"Deleted Successfully",null);
    }


}
