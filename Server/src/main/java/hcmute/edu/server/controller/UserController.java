package hcmute.edu.server.controller;

import hcmute.edu.server.dto.ApiRespone;
import hcmute.edu.server.dto.request.UserLoginRequest;
import hcmute.edu.server.dto.request.UserRegisterRequest;
import hcmute.edu.server.dto.respone.UserRespone;
import hcmute.edu.server.entity.User;
import hcmute.edu.server.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserController {
    UserService userService;

    @PostMapping("/register")
    public ApiRespone<UserRespone> register(@RequestBody UserRegisterRequest request) {
        return ApiRespone.<UserRespone>builder()
                .result(userService.registerUser(request))
                .build();
    }

    @PostMapping("/login")
    public ApiRespone<UserRespone> login(@RequestBody UserLoginRequest request) {
        return ApiRespone.<UserRespone>builder()
                .result(userService.loginUser(request))
                .build();
    }
}
