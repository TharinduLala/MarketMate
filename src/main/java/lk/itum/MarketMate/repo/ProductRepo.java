package lk.itum.MarketMate.repo;

import lk.itum.MarketMate.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,String> {
}
