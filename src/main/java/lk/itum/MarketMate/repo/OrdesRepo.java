package lk.itum.MarketMate.repo;

import lk.itum.MarketMate.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdesRepo extends JpaRepository<Orders,String> {
}
