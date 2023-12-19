package lk.itum.MarketMate.service;

import lk.itum.MarketMate.dto.CustomerDto;
import lk.itum.MarketMate.dto.UserDto;

public interface UserService {
    void saveUser(UserDto dto);
    boolean loginUser(UserDto dto);
}
