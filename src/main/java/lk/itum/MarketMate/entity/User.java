package lk.itum.MarketMate.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {
    @Id
    private String userName;
    private String password;
    private String name;
    private String userRole;
}
