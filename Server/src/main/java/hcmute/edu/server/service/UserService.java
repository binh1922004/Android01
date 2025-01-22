package hcmute.edu.server.service;

import hcmute.edu.server.dto.request.UserLoginRequest;
import hcmute.edu.server.dto.request.UserRegisterRequest;
import hcmute.edu.server.dto.respone.UserRespone;
import hcmute.edu.server.entity.User;
import hcmute.edu.server.mapper.UserMapper;
import hcmute.edu.server.repo.UserRepository;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;
    public UserRespone registerUser(UserRegisterRequest userRegisterRequest) {

        User user = userMapper.toUser(userRegisterRequest);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userMapper.toUserRespone(userRepository.save(user));
    }

    public UserRespone loginUser(UserLoginRequest userLoginRequest) {
        Optional<User> userOptional = userRepository.findByEmail(userLoginRequest.getEmail());
        if (userOptional.isEmpty()){
            throw new RuntimeException("User not found");
        }

        User user = userOptional.get();
        if (!passwordEncoder.matches(userLoginRequest.getPassword(), user.getPassword())){
            throw new RuntimeException("Wrong password");
        }
        return userMapper.toUserRespone(user);
    }
}
