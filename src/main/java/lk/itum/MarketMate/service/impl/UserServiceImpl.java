package lk.itum.MarketMate.service.impl;

import jakarta.transaction.Transactional;
import lk.itum.MarketMate.dto.UserDto;
import lk.itum.MarketMate.entity.User;
import lk.itum.MarketMate.repo.UserRepo;
import lk.itum.MarketMate.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final ModelMapper mapper;

    public UserServiceImpl(UserRepo userRepo, ModelMapper mapper) {
        this.userRepo = userRepo;
        this.mapper = mapper;
    }

    @Override
    public void saveUser(UserDto dto) {
        if (!userRepo.existsById(dto.getUserName())) {
            userRepo.save(mapper.map(dto, User.class));
        } else {
            throw new RuntimeException("This Username is Already Exists.");
        }
    }

    @Override
    public boolean loginUser(UserDto dto) {
        if (userRepo.existsById(dto.getUserName())) {
            User user = userRepo.findById(dto.getUserName()).get();
            if(user.getUserName().equals(dto.getUserName()) && user.getPassword().equals(dto.getPassword())&&user.getUserRole().equals(dto.getUserRole())){
                return true;
            }else {
                throw new RuntimeException("Login Failed.");
            }
        } else {
            throw new RuntimeException("Invalid Username.");
        }
    }
}
