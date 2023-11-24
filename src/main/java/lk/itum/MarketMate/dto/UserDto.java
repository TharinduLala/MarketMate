package lk.itum.MarketMate.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDto {
    private String userName;
    private String Password;
    private String name;
    private String userRole;
}
