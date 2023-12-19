package lk.itum.MarketMate.controller;

import lk.itum.MarketMate.dto.UserDto;
import lk.itum.MarketMate.service.UserService;
import lk.itum.MarketMate.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {
    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/signup",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveUser(@ModelAttribute UserDto userDto) {
        userService.saveUser(userDto);
        return new ResponseUtil(200,"Signup Success",true);
    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping(path = "/login",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil loginUser(@ModelAttribute UserDto userDto) {
        boolean b = userService.loginUser(userDto);
        return new ResponseUtil(200,"Login Success",b);
    }
}
