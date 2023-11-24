package lk.itum.MarketMate.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class User {
    @Id
    private String userName;
    private String Password;
    private String name;
    private String userRole;
}
