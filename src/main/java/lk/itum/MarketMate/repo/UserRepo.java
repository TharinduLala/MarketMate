package lk.itum.MarketMate.repo;

import lk.itum.MarketMate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String> {
}
