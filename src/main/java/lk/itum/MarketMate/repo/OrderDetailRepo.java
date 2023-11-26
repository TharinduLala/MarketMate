package lk.itum.MarketMate.repo;

import lk.itum.MarketMate.entity.OrderDetail;
import lk.itum.MarketMate.entity.OrderProduct_PK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepo extends JpaRepository<OrderDetail, OrderProduct_PK> {
}
