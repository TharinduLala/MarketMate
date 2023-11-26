package lk.itum.MarketMate.service.impl;

import jakarta.transaction.Transactional;
import lk.itum.MarketMate.dto.OrdersDto;
import lk.itum.MarketMate.entity.OrderDetail;
import lk.itum.MarketMate.entity.OrderProduct_PK;
import lk.itum.MarketMate.entity.Orders;
import lk.itum.MarketMate.entity.Product;
import lk.itum.MarketMate.repo.OrderDetailRepo;
import lk.itum.MarketMate.repo.OrdersRepo;
import lk.itum.MarketMate.repo.ProductRepo;
import lk.itum.MarketMate.service.OrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrdersRepo ordersRepo;
    private final OrderDetailRepo orderDetailRepo;
    private final ProductRepo productRepo;
    private final ModelMapper mapper;

    public OrderServiceImpl(OrdersRepo ordersRepo, OrderDetailRepo orderDetailRepo, ProductRepo productRepo, ModelMapper mapper) {
        this.ordersRepo = ordersRepo;
        this.orderDetailRepo = orderDetailRepo;
        this.productRepo = productRepo;
        this.mapper = mapper;
    }


    @Override
    public void purchaseOrder(OrdersDto dto) {
        Orders order = mapper.map(dto, Orders.class);
        if (!ordersRepo.existsById(dto.getOrderId())) {
            ordersRepo.save(order);

            if (dto.getOrderDetails().size() < 1) throw new RuntimeException("No Products Added for this Order");

            for (OrderDetail orderDetail : order.getOrderDetails()) {
                Product product = productRepo.findById(orderDetail.getProductId()).get();
                product.setQtyInStock(product.getQtyInStock() - orderDetail.getQty());
                productRepo.save(product);
            }
        } else {
            throw new RuntimeException("Purchase Order Failed..!, Order ID " + dto.getOrderId() + " Already Exist.!");
        }

    }

    @Override
    public void deleteOrder(String oid) {
        if (ordersRepo.existsById(oid)) {
            ordersRepo.deleteById(oid);
        } else {
            throw new RuntimeException("Delete Order Failed..!, Order ID " + oid + " Not Exist..!");
        }

    }

    @Override
    public void updateOrder(OrdersDto dto) {
        if (ordersRepo.existsById(dto.getOrderId())) {
            Orders order = mapper.map(dto, Orders.class);
            if (dto.getOrderDetails().size() < 1) throw new RuntimeException("No Products Added for this Order");
            for (OrderDetail orderDetail : order.getOrderDetails()) {
                Product product = productRepo.findById(orderDetail.getProductId()).get();
                OrderDetail previousOrderDetail = orderDetailRepo.findById(new OrderProduct_PK(orderDetail.getOrderId(), orderDetail.getProductId())).get();

                int newQty = orderDetail.getQty();
                int previousQty = previousOrderDetail.getQty();
                if (newQty > previousQty) {
                    int difference = newQty - previousQty;
                    product.setQtyInStock(product.getQtyInStock() - difference);
                } else if (newQty < previousQty) {
                    int difference = previousQty - newQty;
                    product.setQtyInStock(product.getQtyInStock() + difference);
                }
                productRepo.save(product);
            }
            ordersRepo.deleteById(dto.getOrderId());
            ordersRepo.save(order);

        } else {
            throw new RuntimeException("Purchase Order Failed..!, Order ID " + dto.getOrderId() + " Not Exist.!");
        }

    }

    @Override
    public OrdersDto searchOrder(String oid) {
        if (ordersRepo.existsById(oid)) {
            return mapper.map(ordersRepo.findById(oid), OrdersDto.class);
        } else {
            throw new RuntimeException("Search Order Failed..!, Order ID " + oid + " Not Exist.!");
        }
    }

    @Override
    public List<OrdersDto> getAllOrders() {
        return mapper.map(ordersRepo.findAll(), new TypeToken<List<OrdersDto>>() {
        }.getType());
    }
}
